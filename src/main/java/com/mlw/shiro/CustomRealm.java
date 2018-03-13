package com.mlw.shiro;

import com.mlw.entity.SysUser;
import com.mlw.service.PermissionService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private PermissionService permissionService;


    /**
     * 授权  验证权限时调用
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //从principal获取主身份信息
        //将getPrimaryPrincipal方法返回值转为真实身份类型(在上边的goGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo)
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();

        //根据身份信息获取权限信息
        //从数据库中获取动态权限数据
        Set<String> roleNames = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roleNames.add(null);   //添加角色
        permissions.add(null);  //添加权限

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
        return info;
    }

    /**
     * 认证  登陆时调用
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //token是用户输入的
        //第一步:丛token中取出身份信息
        String username = (String) token.getPrincipal();

        //第二步:根据用户输入的userCode丛数据库查询
        SysUser sysUser = null;

        try {
            sysUser = permissionService.findSysUserByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sysUser == null) {
            return null;
        }

        //从数据库查询到的密码
        String password = sysUser.getPassword();
        //盐 salt
        String salt = sysUser.getSalt();


        //将用户信息设置到simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo = new
                SimpleAuthenticationInfo(sysUser, password, this.getName());

        return simpleAuthenticationInfo;
    }
}