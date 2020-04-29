package cn.hp.system.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hp.system.domain.User;
import cn.hp.system.service.UserService;
import cn.hp.system.utils.ActiveUser;

public class UserRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	@Override
	public String getName() {
		return this.getClass().getName();
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		String username = token.getPrincipal().toString();
		User user = userService.queryUserByUserName(username);
		if(user !=null){
			ActiveUser activeUser=new ActiveUser();
			activeUser.setUser(user);
			ByteSource credentialsSalt=ByteSource.Util.bytes(user.getSalt());
			SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(activeUser,user.getPwd(), credentialsSalt, getName());
			return info;
		}
		return null;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

}
