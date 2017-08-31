package com.dongnao.jack.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JackShiroRealm extends AuthorizingRealm {
    
    private static final Logger logger = LoggerFactory.getLogger(JackShiroRealm.class);
    
    /**
     * 这是授权方法  
     */
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        return null;
    }
    
    /**
     * 这是认证方法  
     */
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        //token中储存着输入的用户名和密码  
        return null;
    }
}
