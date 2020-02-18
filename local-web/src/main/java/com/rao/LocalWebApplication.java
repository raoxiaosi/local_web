package com.rao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(value = "com.rao.dao")
@SpringBootApplication
public class LocalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocalWebApplication.class, args);
	}
}
