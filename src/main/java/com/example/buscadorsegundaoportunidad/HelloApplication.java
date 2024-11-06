package com.example.buscadorsegundaoportunidad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventanaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setMinHeight(751);
        stage.setMinWidth(800);
        stage.setTitle("Tabla de res_partner_category");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(getClass().getResource("estilos.css").toExternalForm());
    }

    public static void main(String[] args)
    {
        launch();
    }
}