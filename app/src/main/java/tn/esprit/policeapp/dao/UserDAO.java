package tn.esprit.policeapp.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import tn.esprit.policeapp.entities.User;

@Dao
public interface UserDAO {

        @Query("SELECT * FROM User where username=:username and password= :password")
        User getUser(String username, String password);

        @Insert
        void insert(User user);

        @Update
        void update(User user);

        @Delete
        void delete(User user);
    }

