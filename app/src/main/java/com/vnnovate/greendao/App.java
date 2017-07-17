package com.vnnovate.greendao;

import android.app.Application;

import com.vnnovate.greendao.Entities.DaoMaster;
import com.vnnovate.greendao.Entities.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Vnnovate on 17-Jul-17.
 */

public class App extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"student-db");
        Database db =helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}