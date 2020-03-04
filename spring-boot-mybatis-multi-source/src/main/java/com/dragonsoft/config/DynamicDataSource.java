package com.dragonsoft.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * @author ronin
 */
public class DynamicDataSource {

    /**
     * oracle数据源：
     */
    @Configuration
    @MapperScan(basePackages = "com.dragonsoft.dao.oracle",
            sqlSessionFactoryRef = "oracleSqlSessionFactory")
//    @MapperScan(basePackages = "com.dragonsoft.dao.oracle",
//            sqlSessionTemplateRef = "oracleSqlSessionTemplate")
    public static class oracleDataSource {
        @Primary
        @Bean("oracleDataSource")
        @Qualifier("oracleDataSource")
        @ConfigurationProperties(prefix = "spring.datasource.oracle")
        public DataSource dataSource() {
            return new DruidDataSource();
        }

        @Primary
        @Bean("oracleSqlSessionFactory")
        @Qualifier("oracleSqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/oracle/*.xml"));
            return factoryBean.getObject();
        }

        @Primary
        @Bean("oracleTransactionManager")
        @Qualifier("oracleTransactionManager")
        public DataSourceTransactionManager transactionManager(@Qualifier("oracleDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Primary
        @Bean("oracleSqlSessionTemplate")
        @Qualifier("oracleSqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("oracleSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

    /**
     * mysql数据源
     */
    @Configuration
    @MapperScan(basePackages = "com.dragonsoft.dao.mysql",
            sqlSessionFactoryRef = "mysqlSqlSessionFactory")
//    @MapperScan(basePackages = "com.dragonsoft.dao.mysql",
//            sqlSessionTemplateRef = "mysqlSqlSessionTemplate")
    public static class mysqlDataSource {
        @Bean("mysqlDataSource")
        @Qualifier("mysqlDataSource")
        @ConfigurationProperties(prefix = "spring.datasource.mysql")
        public DataSource dataSource() {
            return new DruidDataSource();
        }

        @Bean("mysqlSqlSessionFactory")
        @Qualifier("mysqlSqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/mysql/*.xml"));
            return factoryBean.getObject();
        }

        @Bean("mysqlTransactionManager")
        @Qualifier("mysqlTransactionManager")
        public DataSourceTransactionManager transactionManager(@Qualifier("mysqlDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean("mysqlSqlSessionTemplate")
        @Qualifier("mysqlSqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("mysqlSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

}
