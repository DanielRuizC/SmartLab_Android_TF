package com.project.smartlab_tf.ui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;

    private DBHelper( Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    public static DBHelper getInstance(Context context){
        if(instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }


    @Override
    //crear tabla equipos
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + Constantes.EQUIPOS_TABLE +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nombre TEXT NOT NULL," +
                " sede TEXT NOT NULL," +
                " descripcion TEXT NOT NULL,";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
