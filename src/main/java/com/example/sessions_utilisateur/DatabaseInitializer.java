package com.example.sessions_utilisateur;

import javafx.application.Application;
import javafx.stage.Stage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initialize() {
        String url = "jdbc:mysql://localhost:3306/javafx_app";
        String user = "root";
        String password = ""; // Modifie selon ton mot de passe

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stmt = conn.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "username VARCHAR(50) NOT NULL UNIQUE," +
                    "password VARCHAR(100) NOT NULL," +
                    "role VARCHAR(20) NOT NULL" +
                    ")";
            stmt.execute(createTable);

            String insertAdmin = "INSERT IGNORE INTO users (username, password, role) VALUES " +
                    "('admin', 'admin123', 'admin')," +
                    "('user', 'user123', 'user')";
            stmt.execute(insertAdmin);

            System.out.println("Base de données initialisée.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

