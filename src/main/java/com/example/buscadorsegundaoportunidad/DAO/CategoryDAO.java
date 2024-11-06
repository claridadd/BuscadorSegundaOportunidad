package com.example.buscadorsegundaoportunidad.DAO;

import com.example.buscadorsegundaoportunidad.Modelos.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
}
