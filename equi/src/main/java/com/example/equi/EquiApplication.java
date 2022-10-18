package com.example.equi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


@SpringBootApplication
public class EquiApplication {

	public EquiApplication() throws Exception {
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(EquiApplication.class, args);

	}



}



