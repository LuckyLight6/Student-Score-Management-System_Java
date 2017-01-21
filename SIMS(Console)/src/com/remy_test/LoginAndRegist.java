package com.remy_test;

public interface LoginAndRegist {
	/**
	 * 这是用户登录功能
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 登录是否成功
	 */
	public boolean login(String userName, String password);

	/**
	 * 这是用户注册功能
	 * 
	 * @param user
	 *            被注册的用户信息
	 */
	public boolean regist(User user);
}
