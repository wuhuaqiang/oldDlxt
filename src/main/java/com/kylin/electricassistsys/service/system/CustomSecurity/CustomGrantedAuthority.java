package com.kylin.electricassistsys.service.system.CustomSecurity;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Threecolors on 2017/12/4.
 */
public class CustomGrantedAuthority implements GrantedAuthority
{
    private String permissionUrl;
    private Integer method;

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {
        this.method = method;
    }

    public CustomGrantedAuthority (String permissionUrl, Integer method) {
        this.permissionUrl = permissionUrl;
        this.method = method;
    }

    @Override
    public String getAuthority() {
        return this.permissionUrl + ";"+this.method;
    }
}
