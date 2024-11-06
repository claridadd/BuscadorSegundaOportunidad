package com.example.buscadorsegundaoportunidad.Controladores;

import com.example.buscadorsegundaoportunidad.DAO.CategoryDAO;
import com.example.buscadorsegundaoportunidad.HelloApplication;
import com.example.buscadorsegundaoportunidad.Modelos.Category;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class HelloController
{

    @FXML
    private VBox vbFondo;
    @FXML
    private Label lbTitulo;
    @FXML
    private ImageView ivBuscar;
    @FXML
    private TableColumn columnaActive;
    @FXML
    private ImageView ivEditar;
    @FXML
    private Button btnBorrar;
    @FXML
    private TableColumn columnaParentPath;
    @FXML
    private ImageView ivBorrar;
    @FXML
    private TableColumn columnaIdPadre;
    @FXML
    private Button btnEditar;
    @FXML
    private TableColumn columnaColor;
    @FXML
    private TableColumn columnaId;
    @FXML
    private TableView tvTabla;
    @FXML
    private Button btnAñadir;
    @FXML
    private Button btnBuscar;
    @FXML
    private ImageView ivAñadir;
    @FXML
    private TableColumn columnaCreateDate;
    @FXML
    private TextField tfVisor;


    public void initialize() throws SQLException
    {
        columnaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnaColor.setCellValueFactory(new PropertyValueFactory<>("color"));
        columnaIdPadre.setCellValueFactory(new PropertyValueFactory<>("parent_id"));
        columnaParentPath.setCellValueFactory(new PropertyValueFactory<>("parent_path"));
        columnaActive.setCellValueFactory(new PropertyValueFactory<>("active"));
        columnaCreateDate.setCellValueFactory(new PropertyValueFactory<>("create_date"));

    }

    @FXML
    public void botonBuscar(ActionEvent actionEvent) throws SQLException
    {
        Task<Void> tarea = new Task<Void>()
        {
            @Override
            protected Void call() throws Exception
            {
                try
                {
                    List<Category> categorias = CategoryDAO.obtenerCategorias(tfVisor.getText());
                    ObservableList<Category> datos = FXCollections.observableArrayList(categorias);

                    Platform.runLater(() ->
                    {
                        tvTabla.setItems(datos);
                    });

                } catch (Exception e)
                {
                    System.err.println("Error de SQL al consultar: " + e.getMessage());
                    Platform.runLater(() ->
                    {
                    });
                }
                return null;
            }
        };

        Thread hilo = new Thread(tarea);
        hilo.start();
    }

    @FXML
    public void botonBorrar(ActionEvent actionEvent)
    {
    }

    @FXML
    public void botonAñadir(ActionEvent actionEvent)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(v);
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 449, 400);
            Stage stage = new Stage();
            stage.setTitle("Añadir");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setX(595);
            stage.setY(135);

            //La ventana no se va a poder hacer ni mas grande ni mas pequeña de lo que es
            //stage.setMaxWidth(993);
            //stage.setMaxHeight(815);
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void botonEditar(ActionEvent actionEvent)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ventanaAnadir.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 449, 400);
            Stage stage = new Stage();
            stage.setTitle("Editar");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setX(595);
            stage.setY(135);

            //La ventana no se va a poder mas grande ni mas pequeña de lo que es
            //stage.setMaxWidth(993);
            //stage.setMaxHeight(815);
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}