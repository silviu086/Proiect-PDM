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

public class FragmentOrar extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_orar,container,false);

        //region Vectori TextView pentru orar
        TextView luni_m[] = {
                (TextView) v.findViewById(R.id.textViewLuni1M),
                (TextView) v.findViewById(R.id.textViewLuni2M),
                (TextView) v.findViewById(R.id.textViewLuni3M),
                (TextView) v.findViewById(R.id.textViewLuni4M),
                (TextView) v.findViewById(R.id.textViewLuni5M)
        };
        TextView luni_s[] = {
                (TextView) v.findViewById(R.id.textViewLuni1S),
                (TextView) v.findViewById(R.id.textViewLuni2S),
                (TextView) v.findViewById(R.id.textViewLuni3S),
                (TextView) v.findViewById(R.id.textViewLuni4S),
                (TextView) v.findViewById(R.id.textViewLuni5S)
        };
        TextView luni_o[] = {
                (TextView) v.findViewById(R.id.textViewLuni1O),
                (TextView) v.findViewById(R.id.textViewLuni2O),
                (TextView) v.findViewById(R.id.textViewLuni3O),
                (TextView) v.findViewById(R.id.textViewLuni4O),
                (TextView) v.findViewById(R.id.textViewLuni5O)
        };

        TextView marti_m[] = {
                (TextView) v.findViewById(R.id.textViewMarti1M),
                (TextView) v.findViewById(R.id.textViewMarti2M),
                (TextView) v.findViewById(R.id.textViewMarti3M),
                (TextView) v.findViewById(R.id.textViewMarti4M),
                (TextView) v.findViewById(R.id.textViewMarti5M)
        };
        TextView marti_s[] = {
                (TextView) v.findViewById(R.id.textViewMarti1S),
                (TextView) v.findViewById(R.id.textViewMarti2S),
                (TextView) v.findViewById(R.id.textViewMarti3S),
                (TextView) v.findViewById(R.id.textViewMarti4S),
                (TextView) v.findViewById(R.id.textViewMarti5S)
        };
        TextView marti_o[] = {
                (TextView) v.findViewById(R.id.textViewMarti1O),
                (TextView) v.findViewById(R.id.textViewMarti2O),
                (TextView) v.findViewById(R.id.textViewMarti3O),
                (TextView) v.findViewById(R.id.textViewMarti4O),
                (TextView) v.findViewById(R.id.textViewMarti5O)
        };

        TextView miercuri_m[] = {
                (TextView) v.findViewById(R.id.textViewMiercuri1M),
                (TextView) v.findViewById(R.id.textViewMiercuri2M),
                (TextView) v.findViewById(R.id.textViewMiercuri3M),
                (TextView) v.findViewById(R.id.textViewMiercuri4M),
                (TextView) v.findViewById(R.id.textViewMiercuri5M)
        };
        TextView miercuri_s[] = {
                (TextView) v.findViewById(R.id.textViewMiercuri1S),
                (TextView) v.findViewById(R.id.textViewMiercuri2S),
                (TextView) v.findViewById(R.id.textViewMiercuri3S),
                (TextView) v.findViewById(R.id.textViewMiercuri4S),
                (TextView) v.findViewById(R.id.textViewMiercuri5S)
        };
        TextView miercuri_o[] = {
                (TextView) v.findViewById(R.id.textViewMiercuri1O),
                (TextView) v.findViewById(R.id.textViewMiercuri2O),
                (TextView) v.findViewById(R.id.textViewMiercuri3O),
                (TextView) v.findViewById(R.id.textViewMiercuri4O),
                (TextView) v.findViewById(R.id.textViewMiercuri5O)
        };

        TextView joi_m[] = {
                (TextView) v.findViewById(R.id.textViewJoi1M),
                (TextView) v.findViewById(R.id.textViewJoi2M),
                (TextView) v.findViewById(R.id.textViewJoi3M),
                (TextView) v.findViewById(R.id.textViewJoi4M),
                (TextView) v.findViewById(R.id.textViewJoi5M)
        };
        TextView joi_s[] = {
                (TextView) v.findViewById(R.id.textViewJoi1S),
                (TextView) v.findViewById(R.id.textViewJoi2S),
                (TextView) v.findViewById(R.id.textViewJoi3S),
                (TextView) v.findViewById(R.id.textViewJoi4S),
                (TextView) v.findViewById(R.id.textViewJoi5S)
        };
        TextView joi_o[] = {
                (TextView) v.findViewById(R.id.textViewJoi1O),
                (TextView) v.findViewById(R.id.textViewJoi2O),
                (TextView) v.findViewById(R.id.textViewJoi3O),
                (TextView) v.findViewById(R.id.textViewJoi4O),
                (TextView) v.findViewById(R.id.textViewJoi5O)
        };

        TextView vineri_m[] = {
                (TextView) v.findViewById(R.id.textViewVineri1M),
                (TextView) v.findViewById(R.id.textViewVineri2M),
                (TextView) v.findViewById(R.id.textViewVineri3M),
                (TextView) v.findViewById(R.id.textViewVineri4M),
                (TextView) v.findViewById(R.id.textViewVineri5M)
        };
        TextView vineri_s[] = {
                (TextView) v.findViewById(R.id.textViewVineri1S),
                (TextView) v.findViewById(R.id.textViewVineri2S),
                (TextView) v.findViewById(R.id.textViewVineri3S),
                (TextView) v.findViewById(R.id.textViewVineri4S),
                (TextView) v.findViewById(R.id.textViewVineri5S)
        };
        TextView vineri_o[] = {
                (TextView) v.findViewById(R.id.textViewVineri1O),
                (TextView) v.findViewById(R.id.textViewVineri2O),
                (TextView) v.findViewById(R.id.textViewVineri3O),
                (TextView) v.findViewById(R.id.textViewVineri4O),
                (TextView) v.findViewById(R.id.textViewVineri5O)
        };
        //endregion


        //db
        Bundle extra = this.getArguments();
        int id = extra.getInt("id");
        int id_orar = 0;
        String path = extra.getString("path");
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        String sql = "SELECT * FROM studenti WHERE id=" + id;
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()) {
            id_orar = c.getInt(c.getColumnIndex("id_orar"));
        }

        //region Prelucrari afisare date in controale
        int n_luni = 0;
        int n_marti = 0;
        int n_miercuri = 0;
        int n_joi = 0;
        int n_vineri = 0;
        sql = "SELECT * FROM orar WHERE id_orar = " + String.valueOf(id_orar);
        c = db.rawQuery(sql, null);
        if(c.moveToFirst()){
            do{
                if(c.getString(c.getColumnIndex("ziua")).equals("luni")){
                    luni_m[n_luni].setText(c.getString(c.getColumnIndex("materia")));
                    luni_s[n_luni].setText(c.getString(c.getColumnIndex("sala")));
                    luni_o[n_luni].setText(c.getString(c.getColumnIndex("ora")));
                    luni_m[n_luni].setVisibility(View.VISIBLE);
                    luni_s[n_luni].setVisibility(View.VISIBLE);
                    luni_o[n_luni].setVisibility(View.VISIBLE);
                    n_luni++;
                }
                else if(c.getString(c.getColumnIndex("ziua")).equals("marti")){
                    marti_m[n_marti].setText(c.getString(c.getColumnIndex("materia")));
                    marti_s[n_marti].setText(c.getString(c.getColumnIndex("sala")));
                    marti_o[n_marti].setText(c.getString(c.getColumnIndex("ora")));
                    marti_m[n_marti].setVisibility(View.VISIBLE);
                    marti_s[n_marti].setVisibility(View.VISIBLE);
                    marti_o[n_marti].setVisibility(View.VISIBLE);
                    n_marti++;
                }
                else if(c.getString(c.getColumnIndex("ziua")).equals("miercuri")){
                    miercuri_m[n_miercuri].setText(c.getString(c.getColumnIndex("materia")));
                    miercuri_s[n_miercuri].setText(c.getString(c.getColumnIndex("sala")));
                    miercuri_o[n_miercuri].setText(c.getString(c.getColumnIndex("ora")));
                    miercuri_m[n_miercuri].setVisibility(View.VISIBLE);
                    miercuri_s[n_miercuri].setVisibility(View.VISIBLE);
                    miercuri_o[n_miercuri].setVisibility(View.VISIBLE);
                    n_miercuri++;
                }
                else if(c.getString(c.getColumnIndex("ziua")).equals("joi")){
                    joi_m[n_joi].setText(c.getString(c.getColumnIndex("materia")));
                    joi_s[n_joi].setText(c.getString(c.getColumnIndex("sala")));
                    joi_o[n_joi].setText(c.getString(c.getColumnIndex("ora")));
                    joi_m[n_joi].setVisibility(View.VISIBLE);
                    joi_s[n_joi].setVisibility(View.VISIBLE);
                    joi_o[n_joi].setVisibility(View.VISIBLE);
                    n_joi++;
                }
                else if(c.getString(c.getColumnIndex("ziua")).equals("vineri")){
                    vineri_m[n_vineri].setText(c.getString(c.getColumnIndex("materia")));
                    vineri_s[n_vineri].setText(c.getString(c.getColumnIndex("sala")));
                    vineri_o[n_vineri].setText(c.getString(c.getColumnIndex("ora")));
                    vineri_m[n_vineri].setVisibility(View.VISIBLE);
                    vineri_s[n_vineri].setVisibility(View.VISIBLE);
                    vineri_o[n_vineri].setVisibility(View.VISIBLE);
                    n_vineri++;
                }
            }while (c.moveToNext());
        }
        //endregion

        db.close();
        return v;
    }
}
