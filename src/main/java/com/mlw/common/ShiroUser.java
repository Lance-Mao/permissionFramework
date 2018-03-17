package com.mlw.common;

import java.io.Serializable;
import java.util.Set;

/**
 * 自定义Authentication对象,携带Url及角色信息
 * @author mlw
 * @create 2018-03-16 下午6:10
 */
public class ShiroUser implements Serializable {

    private String id;

    private String name;

    private Set<String> urlSet;

    private Set<String> roles;


    public ShiroUser(String id, String name, Set<String> urlSet) {
        this.id = id;
        this.name = name;
        this.urlSet = urlSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getUrlSet() {
        return urlSet;
    }

    public void setUrlSet(Set<String> urlSet) {
        this.urlSet = urlSet;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }


    /**
     * 本函数输出将作为默认的<shiro:principal/>输出.
     */
}
