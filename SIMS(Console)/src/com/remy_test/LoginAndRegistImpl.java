package com.remy_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * ����IO��ʵ���û���¼ע��
 * 
 * @author Remy
 * @version V1.0
 * 
 *          ���ݴ洢��ʽ�� admin=admin
 * 
 *          ע����� 1��Ϊ�˱�֤�ļ����ڣ��þ�̬�����ʵ�ֵġ� 2��ÿ�ε���ע�Ṧ�ܣ���ʵ�������´����ļ������ԣ�����Ҫ׷��д�롣
 */
public class LoginAndRegistImpl implements LoginAndRegist {
	private static File file = new File("login.dat");
	private Scanner sc;

	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void showLoginAndRegisterMenu() {
		System.out.println("\t\t   ���T�T�T�T�T�T�T�T�T���������T�T�T�T��");
		System.out.println("\t\t   ��   ѧ����Ϣ����ϵͳ   ��");
		System.out.println("\t\t   ���T�T�T�T���������T�T�T�T�T�T�T�T�T��");
		System.out.println("\t\t   ��������������������������������");
		System.out.println("\t\t   ��1����¼  2��ע��   ��");
		System.out.println("\t\t   ��������������������������������");
		System.out.print("\t\t��ѡ����Ҫ���еĲ�����");
	}

	@Override
	public boolean login(String userName, String password) {
		boolean flag = false;
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] userDatas = line.split("=");

				if (userDatas[0].equals(userName)
						&& userDatas[1].equals(password)) {
					flag = true;
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	@Override
	public boolean regist(User user) {
		boolean flag = true;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			br = new BufferedReader(new FileReader(file));

			String line = null;
			while ((line = br.readLine()) != null) {
				String[] userDatas = line.split("=");

				if (userDatas[0].equals(user.getUserName())
						&& userDatas[1].equals(user.getPassword())) {
					flag = false;
					return flag;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			bw = new BufferedWriter(new FileWriter(file, true));
			StringBuilder sb = new StringBuilder();

			sb.append(user.getUserName()).append("=")
					.append(user.getPassword());

			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return flag;
	}

	public void operator() {
		sc = new Scanner(System.in);
		String choose;
		int times = 0;
		boolean flag = true;

		while (flag) {
			showLoginAndRegisterMenu();
			choose = sc.nextLine();

			while ((!choose.equals("1")) && (!choose.equals("2"))) {
				System.out.println("\t\t�����������������룺");
				choose = sc.nextLine();
			}

			if (choose.equals("1")) {
				while (times < 3) {
					System.out.print("�������û�����");
					String userName = sc.nextLine();
					System.out.print("���������룺");
					String password = sc.nextLine();

					if (login(userName, password)) {
						System.out.println("��¼�ɹ���");
						flag = false;
						break;
					} else {
						if (times < 2) {
							System.out.println("�û����������������������룡");
						} else {
							System.out.println("�˻�������������ϵ��ع���Ա������");
							flag = false;
						}
					}

					times++;
				}
			}

			if (choose.equals("2")) {
				System.out.print("�������û�����");
				String userName = sc.nextLine();
				System.out.print("���������룺");
				String password = sc.nextLine();
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);

				if (regist(user)) {
					System.out.println("ע��ɹ���");
				} else {
					System.out.println("���û��Ѵ��ڣ�");
				}
			}
		}
	}
}
