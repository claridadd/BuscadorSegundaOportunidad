package com.example.buscadorsegundaoportunidad.Controladores;

import com.example.buscadorsegundaoportunidad.DAO.CategoryDAO;
import com.example.buscadorsegundaoportunidad.Modelos.Category;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

public class HelloController
{

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
    private VBox vbFondo;
    @FXML
    private Button btnEditar;
    @FXML
    private TableColumn columnaColor;
    @FXML
    private TableColumn columnaId;
    @FXML
    private TableView tvTabla;
    @FXML
    private Label lbTitulo;
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
    }

    @FXML
    public void botonEditar(ActionEvent actionEvent)
    {
    }
}