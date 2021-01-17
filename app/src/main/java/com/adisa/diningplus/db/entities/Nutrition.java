package com.adisa.diningplus.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "nutrition")
public class Nutrition implements Serializable {
    public String name;
    @ColumnInfo(name = "portion_size")
    public String portionSize;
    public String calories;

    @ColumnInfo(name="total_fat")
    public String totalFat;
    @ColumnInfo(name="saturated_fat")
    public String saturatedFat;
    @ColumnInfo(name="trans_fat")
    public String transFat;
    public String cholesterol;
    public String sodium;
    @ColumnInfo(name="total_carbohydrate")
    public String totalCarbohydrate;
    @ColumnInfo(name="dietary_fiber")
    public String dietaryFiber;
    @ColumnInfo(name="total_sugars")
    public String totalSugars;
    public String protein;
    @ColumnInfo(name="vitamin_d")
    public String vitaminD;
    @ColumnInfo(name="vitamin_a")
    public String vitaminA;
    @ColumnInfo(name="vitamin_c")
    public String vitaminC;
    public String calcium;
    public String iron;
    public String potassium;

    @ColumnInfo(name="total_fat_pdv")
    public Integer totalFatPDV;
    @ColumnInfo(name="saturated_fat_pdv")
    public Integer saturatedFatPDV;
    @ColumnInfo(name="trans_fat_pdv")
    public Integer transFatPDV;
    @ColumnInfo(name="cholesterol_pdv")
    public Integer cholesterolPDV;
    @ColumnInfo(name="sodium_pdv")
    public Integer sodiumPDV;
    @ColumnInfo(name="total_carbohydrate_pdv")
    public Integer totalCarbohydratePDV;
    @ColumnInfo(name="dietary_fiber_pdv")
    public Integer dietaryFiberPDV;
    @ColumnInfo(name="total_sugars_pdv")
    public Integer totalSugarsPDV;
    @ColumnInfo(name="protein_pdv")
    public Integer proteinPDV;
    @ColumnInfo(name="vitamin_d_pdv")
    public Integer vitaminDPDV;
    @ColumnInfo(name="vitamin_a_pdv")
    public Integer vitaminAPDV;
    @ColumnInfo(name="vitamin_c_pdv")
    public Integer vitaminCPDV;
    @ColumnInfo(name="calcium_pdv")
    public Integer calciumPDV;
    @ColumnInfo(name="iron_pdv")
    public Integer ironPDV;
    @ColumnInfo(name="potassium_pdv")
    public Integer potassiumPDV;

    @PrimaryKey
    @ColumnInfo(name = "item_id")
    public int itemId;
}
