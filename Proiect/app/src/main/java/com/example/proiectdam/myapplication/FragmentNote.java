package com.example.proiectdam.myapplication;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;

public class FragmentNote extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container, false);

        //db
        Bundle extra = this.getArguments();
        int id = extra.getInt("id");
        String path = extra.getString("path");
        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        //region Switch on checked change
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics());
        final LinearLayout.LayoutParams paramsShow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final LinearLayout.LayoutParams paramsHide = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height);

        //Anul 1 Semestrul 1
        Switch swA1S1 = (Switch)v.findViewById(R.id.switchA1S1);
        final TableLayout tableA1S1 = (TableLayout)v.findViewById(R.id.tabelA1S1);
        final LinearLayout layoutA1S1 = (LinearLayout)v.findViewById(R.id.NoteA1S1);
        swA1S1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA1S1.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA1S1.setLayoutParams(paramsHide);
                }
            }
        });

        //Anul 1 Semestrul 2
        Switch swA1S2 = (Switch)v.findViewById(R.id.switchA1S2);
        final TableLayout tableA1S2 = (TableLayout)v.findViewById(R.id.tabelA1S2);
        final LinearLayout layoutA1S2 = (LinearLayout)v.findViewById(R.id.NoteA1S2);
        swA1S2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA1S2.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA1S2.setLayoutParams(paramsHide);
                }
            }
        });

        //Anul 2 Semestrul 1
        Switch swA2S1 = (Switch)v.findViewById(R.id.switchA2S1);
        final TableLayout tableA2S1 = (TableLayout)v.findViewById(R.id.tabelA2S1);
        final LinearLayout layoutA2S1 = (LinearLayout)v.findViewById(R.id.NoteA2S1);
        swA2S1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA2S1.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA2S1.setLayoutParams(paramsHide);
                }
            }
        });

        //Anul 2 Semestrul 2
        Switch swA2S2 = (Switch)v.findViewById(R.id.switchA2S2);
        final TableLayout tableA2S2 = (TableLayout)v.findViewById(R.id.tabelA2S2);
        final LinearLayout layoutA2S2 = (LinearLayout)v.findViewById(R.id.NoteA2S2);
        swA2S2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA2S2.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA2S2.setLayoutParams(paramsHide);
                }
            }
        });

        //Anul 3 Semestrul 1
        Switch swA3S1 = (Switch)v.findViewById(R.id.switchA3S1);
        final TableLayout tableA3S1 = (TableLayout)v.findViewById(R.id.tabelA3S1);
        final LinearLayout layoutA3S1 = (LinearLayout)v.findViewById(R.id.NoteA3S1);
        swA3S1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA3S1.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA3S1.setLayoutParams(paramsHide);
                }
            }
        });

        //Anul 3 Semestrul 2
        Switch swA3S2 = (Switch)v.findViewById(R.id.switchA3S2);
        final TableLayout tableA3S2 = (TableLayout)v.findViewById(R.id.tabelA3S2);
        final LinearLayout layoutA3S2 = (LinearLayout)v.findViewById(R.id.NoteA3S2);
        swA3S2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b)
                {
                    layoutA3S2.setLayoutParams(paramsShow);
                }
                if(!b)
                {
                    layoutA3S2.setLayoutParams(paramsHide);
                }
            }
        });
        //endregion

        //region TextView pentru orar
        TextView[] m_a1s1 = {
                (TextView) v.findViewById(R.id.textView1A1S1M),
                (TextView) v.findViewById(R.id.textView2A1S1M),
                (TextView) v.findViewById(R.id.textView3A1S1M),
                (TextView) v.findViewById(R.id.textView4A1S1M),
                (TextView) v.findViewById(R.id.textView5A1S1M),
                (TextView) v.findViewById(R.id.textView6A1S1M),
                (TextView) v.findViewById(R.id.textView7A1S1M),
        };
        TextView[] n_a1s1 = {
                (TextView) v.findViewById(R.id.textView1A1S1N),
                (TextView) v.findViewById(R.id.textView2A1S1N),
                (TextView) v.findViewById(R.id.textView3A1S1N),
                (TextView) v.findViewById(R.id.textView4A1S1N),
                (TextView) v.findViewById(R.id.textView5A1S1N),
                (TextView) v.findViewById(R.id.textView6A1S1N),
                (TextView) v.findViewById(R.id.textView7A1S1N),
        };
        TextView[] c_a1s1 = {
                (TextView) v.findViewById(R.id.textView1A1S1C),
                (TextView) v.findViewById(R.id.textView2A1S1C),
                (TextView) v.findViewById(R.id.textView3A1S1C),
                (TextView) v.findViewById(R.id.textView4A1S1C),
                (TextView) v.findViewById(R.id.textView5A1S1C),
                (TextView) v.findViewById(R.id.textView6A1S1C),
                (TextView) v.findViewById(R.id.textView7A1S1C),
        };

        TextView[] m_a1s2 = {
                (TextView) v.findViewById(R.id.textView1A1S2M),
                (TextView) v.findViewById(R.id.textView2A1S2M),
                (TextView) v.findViewById(R.id.textView3A1S2M),
                (TextView) v.findViewById(R.id.textView4A1S2M),
                (TextView) v.findViewById(R.id.textView5A1S2M),
                (TextView) v.findViewById(R.id.textView6A1S2M),
                (TextView) v.findViewById(R.id.textView7A1S2M),
        };
        TextView[] n_a1s2 = {
                (TextView) v.findViewById(R.id.textView1A1S2N),
                (TextView) v.findViewById(R.id.textView2A1S2N),
                (TextView) v.findViewById(R.id.textView3A1S2N),
                (TextView) v.findViewById(R.id.textView4A1S2N),
                (TextView) v.findViewById(R.id.textView5A1S2N),
                (TextView) v.findViewById(R.id.textView6A1S2N),
                (TextView) v.findViewById(R.id.textView7A1S2N),
        };
        TextView[] c_a1s2 = {
                (TextView) v.findViewById(R.id.textView1A1S2C),
                (TextView) v.findViewById(R.id.textView2A1S2C),
                (TextView) v.findViewById(R.id.textView3A1S2C),
                (TextView) v.findViewById(R.id.textView4A1S2C),
                (TextView) v.findViewById(R.id.textView5A1S2C),
                (TextView) v.findViewById(R.id.textView6A1S2C),
                (TextView) v.findViewById(R.id.textView7A1S2C),
        };

        TextView[] m_a2s1 = {
                (TextView) v.findViewById(R.id.textView1A2S1M),
                (TextView) v.findViewById(R.id.textView2A2S1M),
                (TextView) v.findViewById(R.id.textView3A2S1M),
                (TextView) v.findViewById(R.id.textView4A2S1M),
                (TextView) v.findViewById(R.id.textView5A2S1M),
                (TextView) v.findViewById(R.id.textView6A2S1M),
                (TextView) v.findViewById(R.id.textView7A2S1M),
        };
        TextView[] n_a2s1 = {
                (TextView) v.findViewById(R.id.textView1A2S1N),
                (TextView) v.findViewById(R.id.textView2A2S1N),
                (TextView) v.findViewById(R.id.textView3A2S1N),
                (TextView) v.findViewById(R.id.textView4A2S1N),
                (TextView) v.findViewById(R.id.textView5A2S1N),
                (TextView) v.findViewById(R.id.textView6A2S1N),
                (TextView) v.findViewById(R.id.textView7A2S1N),
        };
        TextView[] c_a2s1 = {
                (TextView) v.findViewById(R.id.textView1A2S1C),
                (TextView) v.findViewById(R.id.textView2A2S1C),
                (TextView) v.findViewById(R.id.textView3A2S1C),
                (TextView) v.findViewById(R.id.textView4A2S1C),
                (TextView) v.findViewById(R.id.textView5A2S1C),
                (TextView) v.findViewById(R.id.textView6A2S1C),
                (TextView) v.findViewById(R.id.textView7A2S1C),
        };

        TextView[] m_a2s2 = {
                (TextView) v.findViewById(R.id.textView1A2S2M),
                (TextView) v.findViewById(R.id.textView2A2S2M),
                (TextView) v.findViewById(R.id.textView3A2S2M),
                (TextView) v.findViewById(R.id.textView4A2S2M),
                (TextView) v.findViewById(R.id.textView5A2S2M),
                (TextView) v.findViewById(R.id.textView6A2S2M),
                (TextView) v.findViewById(R.id.textView7A2S2M),
        };
        TextView[] n_a2s2 = {
                (TextView) v.findViewById(R.id.textView1A2S2N),
                (TextView) v.findViewById(R.id.textView2A2S2N),
                (TextView) v.findViewById(R.id.textView3A2S2N),
                (TextView) v.findViewById(R.id.textView4A2S2N),
                (TextView) v.findViewById(R.id.textView5A2S2N),
                (TextView) v.findViewById(R.id.textView6A2S2N),
                (TextView) v.findViewById(R.id.textView7A2S2N),
        };
        TextView[] c_a2s2 = {
                (TextView) v.findViewById(R.id.textView1A2S2C),
                (TextView) v.findViewById(R.id.textView2A2S2C),
                (TextView) v.findViewById(R.id.textView3A2S2C),
                (TextView) v.findViewById(R.id.textView4A2S2C),
                (TextView) v.findViewById(R.id.textView5A2S2C),
                (TextView) v.findViewById(R.id.textView6A2S2C),
                (TextView) v.findViewById(R.id.textView7A2S2C),
        };

        TextView[] m_a3s1 = {
                (TextView) v.findViewById(R.id.textView1A3S1M),
                (TextView) v.findViewById(R.id.textView2A3S1M),
                (TextView) v.findViewById(R.id.textView3A3S1M),
                (TextView) v.findViewById(R.id.textView4A3S1M),
                (TextView) v.findViewById(R.id.textView5A3S1M),
                (TextView) v.findViewById(R.id.textView6A3S1M),
                (TextView) v.findViewById(R.id.textView7A3S1M),
        };
        TextView[] n_a3s1 = {
                (TextView) v.findViewById(R.id.textView1A3S1N),
                (TextView) v.findViewById(R.id.textView2A3S1N),
                (TextView) v.findViewById(R.id.textView3A3S1N),
                (TextView) v.findViewById(R.id.textView4A3S1N),
                (TextView) v.findViewById(R.id.textView5A3S1N),
                (TextView) v.findViewById(R.id.textView6A3S1N),
                (TextView) v.findViewById(R.id.textView7A3S1N),
        };
        TextView[] c_a3s1 = {
                (TextView) v.findViewById(R.id.textView1A3S1C),
                (TextView) v.findViewById(R.id.textView2A3S1C),
                (TextView) v.findViewById(R.id.textView3A3S1C),
                (TextView) v.findViewById(R.id.textView4A3S1C),
                (TextView) v.findViewById(R.id.textView5A3S1C),
                (TextView) v.findViewById(R.id.textView6A3S1C),
                (TextView) v.findViewById(R.id.textView7A3S1C),
        };

        TextView[] m_a3s2 = {
                (TextView) v.findViewById(R.id.textView1A3S2M),
                (TextView) v.findViewById(R.id.textView2A3S2M),
                (TextView) v.findViewById(R.id.textView3A3S2M),
                (TextView) v.findViewById(R.id.textView4A3S2M),
                (TextView) v.findViewById(R.id.textView5A3S2M),
                (TextView) v.findViewById(R.id.textView6A3S2M),
                (TextView) v.findViewById(R.id.textView7A3S2M),
        };
        TextView[] n_a3s2 = {
                (TextView) v.findViewById(R.id.textView1A3S2N),
                (TextView) v.findViewById(R.id.textView2A3S2N),
                (TextView) v.findViewById(R.id.textView3A3S2N),
                (TextView) v.findViewById(R.id.textView4A3S2N),
                (TextView) v.findViewById(R.id.textView5A3S2N),
                (TextView) v.findViewById(R.id.textView6A3S2N),
                (TextView) v.findViewById(R.id.textView7A3S2N),
        };
        TextView[] c_a3s2 = {
                (TextView) v.findViewById(R.id.textView1A3S2C),
                (TextView) v.findViewById(R.id.textView2A3S2C),
                (TextView) v.findViewById(R.id.textView3A3S2C),
                (TextView) v.findViewById(R.id.textView4A3S2C),
                (TextView) v.findViewById(R.id.textView5A3S2C),
                (TextView) v.findViewById(R.id.textView6A3S2C),
                (TextView) v.findViewById(R.id.textView7A3S2C),
        };
        //endregion

        //region Prelucrari afisare date in controale
        int nr_a1s1 = 0;
        int nr_a1s2 = 0;
        int nr_a2s1 = 0;
        int nr_a2s2 = 0;
        int nr_a3s1 = 0;
        int nr_a3s2 = 0;

        int id_note_a1s1 = 0;
        int id_note_a1s2 = 0;
        int id_note_a2s1 = 0;
        int id_note_a2s2 = 0;
        int id_note_a3s1 = 0;
        int id_note_a3s2 = 0;

        TextView separator_a1s1_a1s2 = (TextView) v.findViewById(R.id.textViewSeparatorA1S1_A1S2);
        TextView separator_a1s2_a2s1 = (TextView) v.findViewById(R.id.textViewSeparatorA1S2_A2S1);
        TextView separator_a2s1_a2s2 = (TextView) v.findViewById(R.id.textViewSeparatorA2S1_A2S2);
        TextView separator_a2s2_a3s1 = (TextView) v.findViewById(R.id.textViewSeparatorA2S2_A3S1);
        TextView separator_a3s1_a3s2 = (TextView) v.findViewById(R.id.textViewSeparatorA3S1_A3S2);

        String sql = "SELECT * FROM studenti WHERE id=" + id;
        Cursor c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            id_note_a1s1 = c.getInt(c.getColumnIndex("id_note_a1s1"));
            id_note_a1s2 = c.getInt(c.getColumnIndex("id_note_a1s2"));
            id_note_a2s1 = c.getInt(c.getColumnIndex("id_note_a2s1"));
            id_note_a2s2 = c.getInt(c.getColumnIndex("id_note_a2s2"));
            id_note_a3s1 = c.getInt(c.getColumnIndex("id_note_a3s1"));
            id_note_a3s2 = c.getInt(c.getColumnIndex("id_note_a3s2"));
        }

        if(id_note_a1s1 == 0){
            layoutA1S1.setVisibility(View.GONE);
            separator_a1s1_a1s2.setVisibility(View.GONE);
        }
        if(id_note_a1s2 == 0){
            layoutA1S2.setVisibility(View.GONE);
            separator_a1s2_a2s1.setVisibility(View.GONE);
        }
        if(id_note_a2s1 == 0){
            layoutA2S1.setVisibility(View.GONE);
            separator_a2s1_a2s2.setVisibility(View.GONE);
        }
        if(id_note_a2s2 == 0){
            layoutA2S2.setVisibility(View.GONE);
            separator_a2s2_a3s1.setVisibility(View.GONE);
        }
        if(id_note_a3s1 == 0){
            layoutA3S1.setVisibility(View.GONE);
            separator_a3s1_a3s2.setVisibility(View.GONE);
        }
        if(id_note_a3s2 == 0){
            layoutA3S2.setVisibility(View.GONE);
        }


        //A1S1
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a1s1;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a1s1[nr_a1s1].setText(c.getString(c.getColumnIndex("materia")));
                n_a1s1[nr_a1s1].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a1s1[nr_a1s1].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a1s1[nr_a1s1].setVisibility(View.VISIBLE);
                n_a1s1[nr_a1s1].setVisibility(View.VISIBLE);
                c_a1s1[nr_a1s1].setVisibility(View.VISIBLE);
                nr_a1s1++;
            }while(c.moveToNext());
        }

        //A1S2
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a1s2;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a1s2[nr_a1s2].setText(c.getString(c.getColumnIndex("materia")));
                n_a1s2[nr_a1s2].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a1s2[nr_a1s2].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a1s2[nr_a1s2].setVisibility(View.VISIBLE);
                n_a1s2[nr_a1s2].setVisibility(View.VISIBLE);
                c_a1s2[nr_a1s2].setVisibility(View.VISIBLE);
                nr_a1s2++;
            }while(c.moveToNext());
        }

        //A2S1
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a2s1;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a2s1[nr_a2s1].setText(c.getString(c.getColumnIndex("materia")));
                n_a2s1[nr_a2s1].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a2s1[nr_a2s1].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a2s1[nr_a2s1].setVisibility(View.VISIBLE);
                n_a2s1[nr_a2s1].setVisibility(View.VISIBLE);
                c_a2s1[nr_a2s1].setVisibility(View.VISIBLE);
                nr_a2s1++;
            }while(c.moveToNext());
        }

        //A2S2
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a2s2;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a2s2[nr_a2s2].setText(c.getString(c.getColumnIndex("materia")));
                n_a2s2[nr_a2s2].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a2s2[nr_a2s2].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a2s2[nr_a2s2].setVisibility(View.VISIBLE);
                n_a2s2[nr_a2s2].setVisibility(View.VISIBLE);
                c_a2s2[nr_a2s2].setVisibility(View.VISIBLE);
                nr_a2s2++;
            }while(c.moveToNext());
        }

        //A3S1
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a3s1;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a3s1[nr_a3s1].setText(c.getString(c.getColumnIndex("materia")));
                n_a3s1[nr_a3s1].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a3s1[nr_a3s1].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a3s1[nr_a3s1].setVisibility(View.VISIBLE);
                n_a3s1[nr_a3s1].setVisibility(View.VISIBLE);
                c_a3s1[nr_a3s1].setVisibility(View.VISIBLE);
                nr_a3s1++;
            }while(c.moveToNext());
        }

        //A3S2
        sql = "SELECT * FROM note WHERE id_nota=" + id_note_a1s1;
        c = db.rawQuery(sql, null);

        if (c.moveToFirst()) {
            do{
                m_a3s2[nr_a3s2].setText(c.getString(c.getColumnIndex("materia")));
                n_a3s2[nr_a3s2].setText(String.valueOf(c.getInt(c.getColumnIndex("nota"))));
                c_a3s2[nr_a3s2].setText(String.valueOf(c.getInt(c.getColumnIndex("credite"))));

                m_a3s2[nr_a3s2].setVisibility(View.VISIBLE);
                n_a3s2[nr_a3s2].setVisibility(View.VISIBLE);
                c_a3s2[nr_a3s2].setVisibility(View.VISIBLE);
                nr_a3s2++;
            }while(c.moveToNext());
        }
        //endregion


        db.close();
        return v;
    }
}
