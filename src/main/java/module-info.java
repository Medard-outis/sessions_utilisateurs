module com.example.sessions_utilisateur {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sessions_utilisateur to javafx.fxml;
    exports com.example.sessions_utilisateur;
}