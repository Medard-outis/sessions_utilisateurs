package com.example.sessions_utilisateur;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class DashboardController {
    @FXML
    private Label welcomeLabel;
    @FXML
    private Button adminPanelButton;
    @FXML
    private Button logoutButton;

    @FXML
    private void initialize() {
        UserSession session = UserSession.getInstance();
        welcomeLabel.setText("Bienvenue, " + session.getUsername());

        if (!session.isAdmin()) {
            adminPanelButton.setVisible(false);
            adminPanelButton.setDisable(true);
        }
    }

    @FXML
    private void handleAdminPanel(ActionEvent event) {
        System.out.println("Panneau admin ouvert (réservé aux admins)");
    }

    @FXML
    private void handleLogout(ActionEvent event) {
        UserSession.clearSession();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/example/session/views/Login.fxml"));
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
