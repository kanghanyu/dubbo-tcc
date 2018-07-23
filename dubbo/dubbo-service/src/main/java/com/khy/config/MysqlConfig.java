package com.khy.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MysqlConfig {
	
	@Bean(name = "druidData")
	public DataSource dataSource() throws SQLException{
		DruidDataSource druidData = new DruidDataSource();
		druidData.setDriverClassName("com.mysql.jdbc.Driver");
		druidData.setUrl("jdbc:mysql://localhost:3306/inst01");
		druidData.setUsername("root");
		druidData.setPassword("khanyu");
		druidData.setInitialSize(1);
		druidData.setMinIdle(1);
		druidData.setMaxActive(10);
		druidData.setMaxWait(10000L);
		druidData.setTimeBetweenEvictionRunsMillis(60000L);
		druidData.setMinEvictableIdleTimeMillis(300000L);
		druidData.setTestWhileIdle(true);
		druidData.setTestOnBorrow(true);
		druidData.setTestOnReturn(false);
		druidData.setPoolPreparedStatements(true);
		druidData.setMaxPoolPreparedStatementPerConnectionSize(20);
		druidData.setDefaultAutoCommit(true);
		druidData.setValidationQuery("select 'x'");
		druidData.setFilters("stat");
		return druidData;
	}
	
	@Bean(name = "dataSource")
	public DataSource setDataSource(@Autowired DataSource druidData){
		LocalXADataSource localXADataSource = new LocalXADataSource();
		localXADataSource.setDataSource(druidData);
		return localXADataSource;
	}
	
	@Bean(name = "jdbcTemplate")
	public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource) throws SQLException {
		return new JdbcTemplate(dataSource());
	}

}
