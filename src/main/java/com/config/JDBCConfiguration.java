package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JDBCConfiguration {
	@Bean
	public static Connection getConnexionBDD() {
		String url = "jdbc:postgresql://localhost:5432/sonar";
		String user = "postgres";
		String passwd = "postgres";
		Connection conn = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connecter");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur");
			System.exit(0);
		}
		return conn;
	}
}
