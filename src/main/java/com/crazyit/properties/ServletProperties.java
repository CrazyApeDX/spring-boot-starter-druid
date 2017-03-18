package com.crazyit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Druid 监控视图 Servlet 配置属性模型
 * @author CrazyApeDX
 *         Created on 2017/3/18.
 */
@ConfigurationProperties(prefix = ServletProperties.PREFIX)
public class ServletProperties {

    public final static String PREFIX = "druid.servlet";

    private String url = "/druid/*";
    private String username = "root";
    private String password = "root";
    private String resetEnable = "false";
    private String allow;
    private String deny;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResetEnable() {
        return resetEnable;
    }

    public void setResetEnable(String resetEnable) {
        this.resetEnable = resetEnable;
    }

    public String getAllow() {
        return allow;
    }

    public void setAllow(String allow) {
        this.allow = allow;
    }

    public String getDeny() {
        return deny;
    }

    public void setDeny(String deny) {
        this.deny = deny;
    }

    @Override
    public String toString() {
        return "ServletProperties{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", resetEnable='" + resetEnable + '\'' +
                ", allow='" + allow + '\'' +
                ", deny='" + deny + '\'' +
                '}';
    }
}
