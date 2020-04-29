package cn.hp.system.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hp.system.domain.User;
import cn.hp.system.utils.ActiveUser;
import cn.hp.system.utils.ResultObj;

@RestController
@RequestMapping("/login")
public class LoginController {
	private Log log=LogFactory.getLog(LoginController.class);
	@RequestMapping("/login")
	public ResultObj login(String username,String password,HttpSession session){
		try {
//			获得subject主题
			Subject subject = SecurityUtils.getSubject();
			
//			封装数据名和密码
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
//		认证（登录）
		subject.login(token);
//		获得用户登录的信息
		ActiveUser activerUser = (ActiveUser) subject.getPrincipal();
		User user=activerUser.getUser();
//		存储用户信息到session
		session.setAttribute("user", user);
//		返回登录成功信息
		return ResultObj.LOGIN_SUCCESS;
		} catch (Exception e) {
			log.error("登录失败。用户名或密码错误");
			return ResultObj.LOGIN_ERROR;
		}
	}
}
