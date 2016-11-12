package com.example.proiectdam.myapplication;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentAcasa extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_acasa, container, false);
        TextView t_nume = (TextView)v.findViewById(R.id.textViewNumeValue);
        TextView t_localitate = (TextView)v.findViewById(R.id.textViewLocalitateValue);
        TextView t_email = (TextView)v.findViewById(R.id.textViewEmailValue);
        TextView t_forma_invatamant = (TextView)v.findViewById(R.id.textViewInvatamantValue);
        TextView t_specializare = (TextView)v.findViewById(R.id.textViewSpecializareValue);
        TextView t_an_stiudiu = (TextView)v.findViewById(R.id.textViewAnValue);
        TextView t_grupa = (TextView)v.findViewById(R.id.textViewGrupaValue);
        TextView t_seria = (TextView)v.findViewById(R.id.textViewSeriaValue);
        TextView t_forma_finantare = (TextView)v.findViewById(R.id.textViewFinantareValue);


        Bundle extra = this.getArguments();
        int id = extra.getInt("id");
        String path = extra.getString("path");

        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        String sql = "SELECT * FROM studenti WHERE id=" + id;
        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            t_nume.setText(c.getString(c.getColumnIndex("nume")));
            t_localitate.setText(c.getString(c.getColumnIndex("localitate")));
            t_email.setText(c.getString(c.getColumnIndex("email")));
            t_forma_invatamant.setText(c.getString(c.getColumnIndex("forma_invatamant")));
            t_specializare.setText(c.getString(c.getColumnIndex("specializare")));
            t_an_stiudiu.setText(String.valueOf(c.getInt(c.getColumnIndex("an_studiu"))));
            t_grupa.setText(String.valueOf(c.getInt(c.getColumnIndex("grupa"))));
            t_seria.setText(c.getString(c.getColumnIndex("seria")));
            t_forma_finantare.setText(c.getString(c.getColumnIndex("forma_finantare")));
        }
        db.close();
        return v;
    }
}
