module com.example.buscadorsegundaoportunidad {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.buscadorsegundaoportunidad to javafx.fxml;
    exports com.example.buscadorsegundaoportunidad;
    exports com.example.buscadorsegundaoportunidad.Controladores;
    opens com.example.buscadorsegundaoportunidad.Controladores to javafx.fxml;
    opens com.example.buscadorsegundaoportunidad.Modelos to javafx.base;
}