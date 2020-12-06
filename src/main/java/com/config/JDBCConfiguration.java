package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	@Bean
	public static Connection getConnexionBDD() {
		String url = "jdbc:mysql://localhost:3308/twic?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false";
		String user = "eseo";
		String passwd = "eseo";
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connecter");

		} catch (Exception e) {
			Logger.getLogger("logger").log(Level.WARNING, "Context",e);
			System.out.println("Erreur");
			System.exit(0);
		}
		return conn;
	}
}
