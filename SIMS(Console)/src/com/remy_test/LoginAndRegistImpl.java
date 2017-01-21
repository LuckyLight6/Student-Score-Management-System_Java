package com.remy_test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 这是IO版实现用户登录注册
 * 
 * @author Remy
 * @version V1.0
 * 
 *          数据存储格式： admin=admin
 * 
 *          注意事项： 1：为了保证文件存在，用静态代码块实现的。 2：每次调用注册功能，其实都会重新创建文件，所以，我们要追加写入。
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
		System.out.println("\t\t   ┌═════════■□■□════┐");
		System.out.println("\t\t   │   学生信息管理系统   │");
		System.out.println("\t\t   └════■□■□═════════┘");
		System.out.println("\t\t   ┌──────────────┐");
		System.out.println("\t\t   │1、登录  2、注册   │");
		System.out.println("\t\t   └──────────────┘");
		System.out.print("\t\t请选择您要进行的操作：");
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
				System.out.println("\t\t输入有误，请重新输入：");
				choose = sc.nextLine();
			}

			if (choose.equals("1")) {
				while (times < 3) {
					System.out.print("请输入用户名：");
					String userName = sc.nextLine();
					System.out.print("请输入密码：");
					String password = sc.nextLine();

					if (login(userName, password)) {
						System.out.println("登录成功！");
						flag = false;
						break;
					} else {
						if (times < 2) {
							System.out.println("用户名或密码有误，请重新输入！");
						} else {
							System.out.println("账户已锁定，请联系相关关人员解锁！");
							flag = false;
						}
					}

					times++;
				}
			}

			if (choose.equals("2")) {
				System.out.print("请输入用户名：");
				String userName = sc.nextLine();
				System.out.print("请输入密码：");
				String password = sc.nextLine();
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);

				if (regist(user)) {
					System.out.println("注册成功！");
				} else {
					System.out.println("该用户已存在！");
				}
			}
		}
	}
}
