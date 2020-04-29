package cn.hp.system.service.impl;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hp.system.domain.User;
import cn.hp.system.mapper.UserMapper;
import cn.hp.system.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
//根据用户名查询用户信息
	@Autowired
	private UserMapper userMapper;
//	声明日志输入对象
	private Log log=LogFactory.getLog(UserServiceImpl.class);
	
	@Override
	public User queryUserByUserName(String username) {
		if(username==null){
			log.error("用户名不能为空"); //在控制台输出信息
			throw new RuntimeException("用户名不能为空");
		}
			User user = userMapper.queryUserByUsername(username);
		return user;
	}

}
