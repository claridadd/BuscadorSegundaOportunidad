package com.example.buscadorsegundaoportunidad.Modelos;

import java.sql.Timestamp;

public class Category
{
    private int id;
    private int color;
    private int parent_id;
    private String parent_path;
    private Boolean active;
    private Timestamp create_date;

    public Category(int id, int color,int parent_id, String parent_path, boolean active, Timestamp create_date )
    {
        this.id = id;
        this.color = color;
        this.parent_id = parent_id;
        this.parent_path = parent_path;
        this.active = active;
        this.create_date = create_date;
    }


    public int getId()
    {
        return id;
    }

    public int getColor()
    {
        return color;
    }

    public void setColor(int color)
    {
        this.color = color;
    }

    public int getParent_id()
    {
        return parent_id;
    }

    public void setParent_id(int parent_id)
    {
        this.parent_id = parent_id;
    }

    public String getParent_path()
    {
        return parent_path;
    }

    public void setParent_path(String parent_path)
    {
        this.parent_path = parent_path;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public Timestamp getCreate_date()
    {
        return create_date;
    }

    public void setCreate_date(Timestamp create_date)
    {
        this.create_date = create_date;
    }

}

