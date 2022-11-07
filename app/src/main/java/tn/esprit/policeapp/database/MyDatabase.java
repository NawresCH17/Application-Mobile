package tn.esprit.policeapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import tn.esprit.policeapp.dao.UserDAO;
import tn.esprit.policeapp.entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract UserDAO userDAO();

    public static MyDatabase getDatabase(Context ctx) {
        if (instance == null) {
            instance = Room.databaseBuilder(ctx.getApplicationContext(), MyDatabase.class, "projectBD")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
