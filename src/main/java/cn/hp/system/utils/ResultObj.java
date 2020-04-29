package cn.hp.system.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
	public static final ResultObj LOGIN_SUCCESS=new ResultObj(200,"登录成功");
	public static final ResultObj LOGIN_ERROR=new ResultObj(-1,"登录失败,用户名或密码错误");
	
	private Integer code;
	private String msg;
	
}
