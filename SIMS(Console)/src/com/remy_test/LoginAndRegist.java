package com.remy_test;

public interface LoginAndRegist {
	/**
	 * �����û���¼����
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @return ��¼�Ƿ�ɹ�
	 */
	public boolean login(String userName, String password);

	/**
	 * �����û�ע�Ṧ��
	 * 
	 * @param user
	 *            ��ע����û���Ϣ
	 */
	public boolean regist(User user);
}
