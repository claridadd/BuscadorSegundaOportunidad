package com.example.buscadorsegundaoportunidad.Controladores;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class HelloControllerAñadir
{

    @javafx.fxml.FXML
    private Button btnAceptar;
    @javafx.fxml.FXML
    private Label lbTitulo;
    @javafx.fxml.FXML
    private Button btnCancelar;
    @javafx.fxml.FXML
    private VBox vbFondo;
    @javafx.fxml.FXML
    private TextField tfColor;
    @javafx.fxml.FXML
    private TextField tfParentId;
    @javafx.fxml.FXML
    private TextField tfParentPath;
    @javafx.fxml.FXML
    private TextField tfId;
    @javafx.fxml.FXML
    private DatePicker dpCreationDate;
    @javafx.fxml.FXML
    private CheckBox cbActive;


    @javafx.fxml.FXML
    public void btnAciones(ActionEvent actionEvent)
    {
        Button btn = (Button) actionEvent.getSource();
        String id = btn.getId();

        switch (id)
        {
            case "btnAceptar":
                if(tfId.getText().isEmpty())
                {
//                   //Si no tiene id se crea una nueva tupla

                }
        }



    }
}
