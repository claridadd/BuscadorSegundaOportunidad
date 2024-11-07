package com.example.buscadorsegundaoportunidad.DAO;

import com.example.buscadorsegundaoportunidad.Modelos.Category;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.buscadorsegundaoportunidad.DAO.ConexionBD.connection;

public class CategoryDAO
{
    public static List<Category> obtenerCategorias(String valor)
    {

        List<Category> categorias = new ArrayList<>();
        String BBDD;

        if (!valor.isEmpty())
            BBDD = "SELECT * FROM res_partner_category WHERE id = ?";
        else
            BBDD = "SELECT * FROM res_partner_category";

        try (   Connection conexion = ConexionBD.getConnection();
                PreparedStatement preparado = conexion.prepareStatement(BBDD))
        {
            if (!valor.isEmpty())
                preparado.setInt(1, Integer.parseInt(valor));
            ResultSet resultSet = preparado.executeQuery();

            while (resultSet.next())
            {
                int id = resultSet.getInt("id");
                int color = resultSet.getInt("color");
                int parent_id = resultSet.getInt("parent_id");
                String parent_path = resultSet.getString("parent_path");
                boolean active = resultSet.getBoolean("active");
                Timestamp create_date = resultSet.getTimestamp("create_date");

                categorias.add(new Category(id, color, parent_id, parent_path, active, create_date));
            }

        } catch (SQLException e){
            System.err.println("Error de SQL al crear: " + e.getMessage());
        }
        return categorias;

    }

    public static void crearFila(TextField tfColor, TextField tfParentId, TextField tfParentPath, boolean active, Timestamp create_date)
    {
        try (Connection conexion = ConexionBD.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO res_parent_category(color,parent_id,parent_path,active,create_date) VALUES(?,?,?,?,?)"))
        {
            statement.setInt(1, Integer.parseInt(tfColor.getText()));
            statement.setInt(2, Integer.parseInt(tfParentId.getText()));
            statement.setString(3, tfParentPath.getText());
            statement.setBoolean(4, active);
            statement.setTimestamp(5, create_date);
            statement.execute();

        } catch (SQLException e)
        {
            System.err.println("Error de SQL al crear: " + e.getMessage());
        }
    }
}
