package me.mehedee.accounts.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import me.mehedee.accounts.persistence.dao.AccountDao;
import me.mehedee.accounts.persistence.entity.AccountEntity;

@Database(entities = AccountEntity.class, version = 1)
public abstract class MainDatabase extends RoomDatabase {
    public abstract AccountDao accountDao();

    private static MainDatabase INSTANCE;

    public static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void create(final Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, MainDatabase.class, "main-db").build();
        }
    }

    public static MainDatabase getInstance(){
        return INSTANCE;
    }

}
