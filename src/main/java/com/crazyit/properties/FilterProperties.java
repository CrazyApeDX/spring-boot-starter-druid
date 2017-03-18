package com.crazyit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Druid 监控过滤器配置属性模型
 * @author CrazyApeDX
 *         Created on 2017/3/18.
 */
@ConfigurationProperties(prefix = FilterProperties.PREFIX)
public class FilterProperties {

    public final static String PREFIX = "druid.filter";

    // 过滤器url-pattern
    private String url = "/*";
    // 配置哪些资源不被统计
    private String exclusions = "/druid/*,*.html,*.js,*.css,*.gif,*.jpg,*.jpeg,*.png,*.ico";
    // 配置 Session 统计的最大个数
    private String sessionStatMaxCount = "1000";
    // 是否关闭 Session 统计功能
    private String sessionStatEnable = "true";
    // 配置统计的 Session 名
    private String principalSessionName;
    // 配置统计的 Cookie 名
    private String principalCookieName;
    // 是否监控单个 URL 调用的 SQL 列表
    private String profileEnable = "true";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExclusions() {
        return exclusions;
    }

    public void setExclusions(String exclusions) {
        this.exclusions = exclusions;
    }

    public String getSessionStatMaxCount() {
        return sessionStatMaxCount;
    }

    public void setSessionStatMaxCount(String sessionStatMaxCount) {
        this.sessionStatMaxCount = sessionStatMaxCount;
    }

    public String getSessionStatEnable() {
        return sessionStatEnable;
    }

    public void setSessionStatEnable(String sessionStatEnable) {
        this.sessionStatEnable = sessionStatEnable;
    }

    public String getPrincipalSessionName() {
        return principalSessionName;
    }

    public void setPrincipalSessionName(String principalSessionName) {
        this.principalSessionName = principalSessionName;
    }

    public String getPrincipalCookieName() {
        return principalCookieName;
    }

    public void setPrincipalCookieName(String principalCookieName) {
        this.principalCookieName = principalCookieName;
    }

    public String getProfileEnable() {
        return profileEnable;
    }

    public void setProfileEnable(String profileEnable) {
        this.profileEnable = profileEnable;
    }

    @Override
    public String toString() {
        return "FilterProperties{" +
                "url='" + url + '\'' +
                ", exclusions='" + exclusions + '\'' +
                ", sessionStatMaxCount='" + sessionStatMaxCount + '\'' +
                ", sessionStatEnable='" + sessionStatEnable + '\'' +
                ", principalSessionName='" + principalSessionName + '\'' +
                ", principalCookieName='" + principalCookieName + '\'' +
                ", profileEnable='" + profileEnable + '\'' +
                '}';
    }
}
