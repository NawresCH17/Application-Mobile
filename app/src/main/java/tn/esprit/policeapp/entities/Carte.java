package tn.esprit.policeapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Carte {
    @PrimaryKey(autoGenerate = true)
    public int idCarte;
    @ColumnInfo
    public String nom;
    @ColumnInfo
    public String prenom;
    @ColumnInfo
    public String adresse;
    @ColumnInfo
    public String phone;
    @ColumnInfo
    public String profession;
    @ColumnInfo
    public Date datenaiss;
    @ColumnInfo
    public String lieunaiss;
}
