package com.project.smartlab_tf.ui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class DAOLaboratorio {
    DBHelper dbHelper;
    SQLiteDatabase db;
    public DAOLaboratorio(Context context){
        dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<EquipoModel> listarUsuarios(){
        ArrayList<EquipoModel> lista = new ArrayList<>();
        Cursor c = null;
        try{
            c = db.rawQuery("SELECT * FROM " + Constantes.EQUIPOS_TABLE, null);
            EquipoModel equipo;
            while(c.moveToNext()){
                equipo = new EquipoModel(c.getInt(0), c.getString(1), c.getString(2));
                lista.add(equipo);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
            Objects.requireNonNull(c).close();
        return lista;
    }

    public long registrarUsuario(EquipoModel equipo){
        try{
            ContentValues values = new ContentValues();
            values.put("nombre", equipo.getNombre());
            values.put("descripcion", equipo.getDescripcion());

            return db.insert(Constantes.EQUIPOS_TABLE, null,values);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public EquipoModel obtenerEquipo(int id){
        EquipoModel equipo = null;
        String[] args = {String.valueOf(id)};
        Cursor c = null;
        try{
            c = db.rawQuery("SELECT * FROM " + Constantes.EQUIPOS_TABLE + " WHERE id = ?", args);
            while (c.moveToNext()){
                equipo = new EquipoModel(c.getInt(0), c.getString(1), c.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            Objects.requireNonNull(c).close();
        }
        return equipo;
    }

    public int editarEquipo(EquipoModel usuario){
        try{
            ContentValues values = new ContentValues();
            values.put("nombre", usuario.getNombre());
            values.put("descripcion", usuario.getDescripcion());

            String[] args = new String[]{String.valueOf(usuario.getId())};
            return db.update(Constantes.EQUIPOS_TABLE, values, "id=?", args);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    public int eliminarEquipo(int id){
        try{
            String[] args = {String.valueOf(id)};
            return db.delete(Constantes.EQUIPOS_TABLE, "id=?",args);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
