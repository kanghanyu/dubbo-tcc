package com.khy;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource({ "classpath:bytetcc-supports-dubbo.xml","dubbo-provider.xml"})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, JdbcTemplateAutoConfiguration.class })
public class ProviderMain {
	
	public static void main(String[] args) {
		System.out.println("dubbo 服务开始启动");
		SpringApplication.run(ProviderMain.class, args);
		System.out.println("dubbo 服务启动完毕");
		
	}
}



