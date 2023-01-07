package com.examenYadzael.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examenYadzael.demo.Tools.MyLoggers;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		MyLoggers.infoLog("App creada correctamente", "Hecho por: Hiram Yadzael Vargas Chalico, enero 2023 :)");
	}

}
