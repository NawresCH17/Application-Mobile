package tn.esprit.policeapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import tn.esprit.policeapp.entities.Carte;
import tn.esprit.policeapp.entities.User;

@Dao
public interface CarteDAO {


    @Insert
    public void insertCarte(Carte c1);

    @Delete
    public void deleteCarte(Carte c1);

    @Query("SELECT * FROM Carte")
    public List<Carte> findCartes();

}
