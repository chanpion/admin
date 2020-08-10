package com.chanpion.admin.system.auth;

import com.chanpion.admin.common.utils.LogUtil;
import com.chanpion.admin.system.dao.UserDAO;
import com.chanpion.admin.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author April Chen
 * @date 2020/8/4 20:35
 */
public class AuthRealm extends AuthorizingRealm {
    @Resource
    private UserDAO userDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return new SimpleAuthorizationInfo();
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LogUtil.info("token:{}", token);
        String username = token.getUsername();
        return new SimpleAuthenticationInfo("admin", "admin", getName());
    }
}
