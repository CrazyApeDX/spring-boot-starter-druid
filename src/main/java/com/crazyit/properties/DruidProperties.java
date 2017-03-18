package com.crazyit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author CrazyApeDX
 *         Created on 2017/3/18.
 */
@ConfigurationProperties(prefix = DruidProperties.PREFIX)
@EnableConfigurationProperties({ServletProperties.class, FilterProperties.class})
public class DruidProperties {

    public final static String PREFIX = "druid";

    private String name;
    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Integer initialSize = 0;
    private Integer maxActive = 8;
    private Integer minIdle = 0;
    private Long maxWait = 60000L;
    private Boolean poolPreparedStatements = false;
    private Integer maxPoolPreparedStatementPerConnectionSize = -1;
    private String validationQuery = "SELECT 'X'";
    private Integer validationQueryTimeout;
    private Boolean testOnBorrow = true;
    private Boolean testOnReturn = false;
    private Boolean testWhileIdle = false;
    private Long timeBetweenEvictionRunsMillis = 60000L;
    private Long minEvictableIdleTimeMillis = 60000L;
    private Long timeBetweenLogStatsMillis = 0L;
    private String filters;
    private String connectionProperties;

    private ServletProperties servlet;
    private FilterProperties filter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Integer getInitialSize() {
        return initialSize;
    }

    public void setInitialSize(Integer initialSize) {
        this.initialSize = initialSize;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }

    public Long getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(Long maxWait) {
        this.maxWait = maxWait;
    }

    public Boolean getPoolPreparedStatements() {
        return poolPreparedStatements;
    }

    public void setPoolPreparedStatements(Boolean poolPreparedStatements) {
        this.poolPreparedStatements = poolPreparedStatements;
    }

    public Integer getMaxPoolPreparedStatementPerConnectionSize() {
        return maxPoolPreparedStatementPerConnectionSize;
    }

    public void setMaxPoolPreparedStatementPerConnectionSize(Integer maxPoolPreparedStatementPerConnectionSize) {
        this.maxPoolPreparedStatementPerConnectionSize = maxPoolPreparedStatementPerConnectionSize;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Integer getValidationQueryTimeout() {
        return validationQueryTimeout;
    }

    public void setValidationQueryTimeout(Integer validationQueryTimeout) {
        this.validationQueryTimeout = validationQueryTimeout;
    }

    public Boolean getTestOnBorrow() {
        return testOnBorrow;
    }

    public void setTestOnBorrow(Boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }

    public Boolean getTestOnReturn() {
        return testOnReturn;
    }

    public void setTestOnReturn(Boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }

    public Boolean getTestWhileIdle() {
        return testWhileIdle;
    }

    public void setTestWhileIdle(Boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }

    public Long getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }

    public Long getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }

    public Long getTimeBetweenLogStatsMillis() {
        return timeBetweenLogStatsMillis;
    }

    public void setTimeBetweenLogStatsMillis(Long timeBetweenLogStatsMillis) {
        this.timeBetweenLogStatsMillis = timeBetweenLogStatsMillis;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public ServletProperties getServlet() {
        return servlet;
    }

    public void setServlet(ServletProperties servlet) {
        this.servlet = servlet;
    }

    public FilterProperties getFilter() {
        return filter;
    }

    public void setFilter(FilterProperties filter) {
        this.filter = filter;
    }

    @Override
    public String toString() {
        return "DruidProperties{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                ", initialSize=" + initialSize +
                ", maxActive=" + maxActive +
                ", minIdle=" + minIdle +
                ", maxWait=" + maxWait +
                ", poolPreparedStatements=" + poolPreparedStatements +
                ", maxPoolPreparedStatementPerConnectionSize=" + maxPoolPreparedStatementPerConnectionSize +
                ", validationQuery='" + validationQuery + '\'' +
                ", validationQueryTimeout=" + validationQueryTimeout +
                ", testOnBorrow=" + testOnBorrow +
                ", testOnReturn=" + testOnReturn +
                ", testWhileIdle=" + testWhileIdle +
                ", timeBetweenEvictionRunsMillis=" + timeBetweenEvictionRunsMillis +
                ", minEvictableIdleTimeMillis=" + minEvictableIdleTimeMillis +
                ", timeBetweenLogStatsMillis=" + timeBetweenLogStatsMillis +
                ", filters='" + filters + '\'' +
                ", connectionProperties='" + connectionProperties + '\'' +
                ", servlet=" + servlet +
                ", filter=" + filter +
                '}';
    }
}
