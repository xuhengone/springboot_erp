package cn.hp.system.mapper;

import cn.hp.system.domain.User;

public interface UserMapper {
	public User queryUserByUsername(String username);
}
