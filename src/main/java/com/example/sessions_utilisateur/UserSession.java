package com.example.sessions_utilisateur;
import javafx.application.Application;
import javafx.stage.Stage;



    public class UserSession {
        private static UserSession instance;

        private String username;
        private String role; // "admin" or "user"

        private UserSession(String username, String role) {
            this.username = username;
            this.role = role;
        }

        public static void createSession(String username, String role) {
            instance = new UserSession(username, role);
        }

        public static UserSession getInstance() {
            return instance;
        }

        public static void clearSession() {
            instance = null;
        }

        public String getUsername() {
            return username;
        }

        public String getRole() {
            return role;
        }

        public boolean isAdmin() {
            return "admin".equalsIgnoreCase(role);
        }
    }

// This class manages the user session, allowing to create, retrieve, and clear the session.
