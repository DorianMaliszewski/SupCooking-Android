package com.supinfo.app.supcooking.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.supinfo.app.supcooking.models.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class SupCookingDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    private static SupCookingDatabase INSTANCE;

    public static SupCookingDatabase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized  (SupCookingDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SupCookingDatabase.class, "supcooking_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
