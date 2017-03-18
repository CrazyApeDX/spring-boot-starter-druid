package com.crazyit;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.crazyit.properties.DruidProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Druid 连接池自动配置类
 * 启动条件：
 * 1. 当前项目处于Web环境;
 * 2. 且当前没有已经实例化的 DataSource Bean;
 * 3. Classpath 中存在 Druid 核心类：DruidDataSource， StatViewServlet， WebStatFilter
 * 达成条件后会实例化 DataSource，且注册 StatViewServlet 和 WebStatFilter
 * @author CrazyApeDX
 *         Created on 2017/3/18.
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnMissingBean({DataSource.class, DruidDataSource.class})
@ConditionalOnClass({DruidDataSource.class, StatViewServlet.class, WebStatFilter.class})
@EnableConfigurationProperties(DruidProperties.class)
public class DruidAutoConfiguration {

    private final static Logger LOGGER = LoggerFactory.getLogger(DruidAutoConfiguration.class);

    @Autowired
    private DruidProperties druid;

    /**
     * 实例化 DataSource, 并将其交由 Spring 托管
     * @return {@link DruidDataSource}
     */
    @Bean(name = "dataSource", initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws Exception {
        LOGGER.info("---- 开始初始化数据源 ----");
        LOGGER.info("---- 参数properties = {} ----", this.druid.toString());

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setName(this.druid.getName());

        if (null != this.druid.getUrl()) {
            dataSource.setUrl(this.druid.getUrl());
        } else {
            dataSource.close();
            throw new NullPointerException("必须填写数据库连接URL");
        }
        if (null != this.druid.getUsername()) {
            dataSource.close();
            dataSource.setUsername(this.druid.getUsername());
        } else {
            dataSource.close();
            throw new NullPointerException("必须填写数据库连接账号");
        }
        if (null != this.druid.getPassword()) {
            dataSource.close();
            dataSource.setPassword(this.druid.getPassword());
        } else {
            throw new NullPointerException("必须填写数据库连接密码");
        }

        dataSource.setDriverClassName(this.druid.getDriverClassName());
        dataSource.setInitialSize(this.druid.getInitialSize());
        dataSource.setMaxActive(this.druid.getMaxActive());
        dataSource.setMinIdle(this.druid.getMinIdle());
        dataSource.setMaxWait(this.druid.getMaxWait());
        dataSource.setPoolPreparedStatements(this.druid.getPoolPreparedStatements());
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(
                this.getProperties().getMaxPoolPreparedStatementPerConnectionSize());
        dataSource.setValidationQuery(this.druid.getValidationQuery());

        if (null != this.druid.getValidationQueryTimeout()) {
            dataSource.setValidationQueryTimeout(this.druid.getValidationQueryTimeout());
        }

        dataSource.setTestOnBorrow(this.druid.getTestOnBorrow());
        dataSource.setTestOnReturn(this.druid.getTestOnReturn());
        dataSource.setTestWhileIdle(this.druid.getTestWhileIdle());
        dataSource.setTimeBetweenEvictionRunsMillis(this.druid.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(this.druid.getMinEvictableIdleTimeMillis());
        dataSource.setTimeBetweenLogStatsMillis(this.druid.getTimeBetweenLogStatsMillis());

        if (null != this.druid.getFilter()) {
            dataSource.setFilters(this.druid.getFilters());
        }
        if (null != this.druid.getConnectionProperties()) {
            dataSource.setConnectionProperties(this.druid.getConnectionProperties());
        }

        LOGGER.info("---- 初始化数据源结束 -----");
        return dataSource;
    }

    /**
     * 实例化 ViewStatServlet 并注册到 Web 环境中
     * @return {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        LOGGER.info("---- 开始初始化StatViewServlet ----");
        LOGGER.info("---- 参数：servlet = {} ----", this.druid.getServlet().toString());

        ServletRegistrationBean bean =
                new ServletRegistrationBean(
                        new StatViewServlet(),
                        this.druid.getServlet().getUrl());
        bean.addInitParameter("loginUsername", this.druid.getServlet().getUsername());
        bean.addInitParameter("loginPassword", this.druid.getServlet().getPassword());
        bean.addInitParameter("resetEnable", this.druid.getServlet().getResetEnable());
        if (null != this.druid.getServlet().getAllow()) {
            bean.addInitParameter("allow", this.druid.getServlet().getAllow());
        }
        if (null != this.druid.getServlet().getDeny()) {
            bean.addInitParameter("deny", this.druid.getServlet().getDeny());
        }

        LOGGER.info("---- 初始化StatViewServlet结束 ----");
        return bean;
    }

    /**
     * 实例化 WebStatFilter 并注册到 Web 环境中
     * @return
     */
    @Bean
    public FilterRegistrationBean druidFilter() {
        LOGGER.info("---- 开始初始化WebStatFilter ----");
        LOGGER.info("---- 参数：filter = {} ----", this.druid.getFilter().toString());

        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.addUrlPatterns(this.druid.getFilter().getUrl());
        bean.addInitParameter("exclusions", this.druid.getFilter().getExclusions());
        bean.addInitParameter("sessionStatMaxCount",
                this.druid.getFilter().getSessionStatMaxCount());
        bean.addInitParameter("sessionStatEnable",
                this.druid.getFilter().getSessionStatEnable());
        if (null != this.druid.getFilter().getPrincipalSessionName()) {
            bean.addInitParameter("principalSessionName",
                this.druid.getFilter().getPrincipalSessionName());
        }
        if (null != this.druid.getFilter().getPrincipalCookieName()) {
            bean.addInitParameter("principalCookieName",
                    this.druid.getFilter().getPrincipalCookieName());
        }
        bean.addInitParameter("profileEnable",
                this.druid.getFilter().getProfileEnable());
        return bean;
    }

    public DruidProperties getProperties() {
        return druid;
    }

    public void setProperties(DruidProperties properties) {
        this.druid = properties;
    }
}
