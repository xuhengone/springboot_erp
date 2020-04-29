package cn.hp.system.service;

import cn.hp.system.domain.User;

public interface UserService {
//	根据用户名查询用户信息
	public User queryUserByUserName(String username);

}
