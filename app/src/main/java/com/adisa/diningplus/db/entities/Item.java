package com.adisa.diningplus.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "items")
public class Item implements Serializable {
    @PrimaryKey
    public int id;
    public String name;
    public String ingredients;
    public String course;

    public boolean meat;
    public boolean animal_products;
    public boolean alcohol;
    public boolean nuts;
    public boolean shellfish;
    public boolean peanuts;
    public boolean dairy;
    public boolean egg;
    public boolean pork;
    public boolean fish;
    public boolean soy;
    public boolean wheat;
    public boolean gluten;
    public boolean coconut;

    @ColumnInfo(name = "meal_id")
    public int mealId;

    @Ignore
    public boolean allergenic;
}
