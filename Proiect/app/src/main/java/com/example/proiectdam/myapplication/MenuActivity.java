package com.example.proiectdam.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    final Fragment fragmentAcasa = new FragmentAcasa();
    final Fragment fragmentOrar = new FragmentOrar();
    final Fragment fragmentNote = new FragmentNote();
    final Fragment fragmentInformatii = new FragmentInformatii();
    final Fragment fragmentAbout = new About();
    final Fragment fragmentWebpageCSIE = new WebpageCSIE();

    Fragment fragmentContinut = null;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setSubtitle("Acasa");
        toolbar.setLogo(getResources().getDrawable(R.drawable.acasa));
        toolbar.setAlpha(0.9f);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.item_acasa);

        Bundle extra = getIntent().getExtras();
        fragmentAcasa.setArguments(extra);
        fragmentOrar.setArguments(extra);
        fragmentNote.setArguments(extra);
        int id = extra.getInt("id");
        String path = extra.getString("path");

        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        String sql = "SELECT * FROM studenti WHERE id=" + id;
        Cursor c = db.rawQuery(sql, null);

        if(c.moveToFirst()){
            View headerLayout = navigationView.getHeaderView(0);
            TextView t1 = (TextView)headerLayout.findViewById(R.id.header_nume);
            TextView t2= (TextView)headerLayout.findViewById(R.id.header_info);
            t1.setText(" " + c.getString(c.getColumnIndex("nume")));
            t2.setText(" Seria " + c.getString(c.getColumnIndex("seria")) + ", Grupa " + c.getString(c.getColumnIndex("grupa")));
        }

        db.close();
        fragmentContinut = fragmentAcasa;
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frameContinut, fragmentContinut).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
            toolbar.setSubtitle("About");
            fragmentContinut = fragmentAbout;
        }
        if(fragmentContinut != null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameContinut, fragmentContinut).commit();
        }
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return super.onOptionsItemSelected(item);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.item_acasa){
            toolbar.setSubtitle("Acasa");
            toolbar.setLogo(getResources().getDrawable(R.drawable.acasa));
            fragmentContinut = fragmentAcasa;
        }
        else if (id == R.id.item_orar) {
            toolbar.setSubtitle("Orar");
            toolbar.setLogo(getResources().getDrawable(R.drawable.orar));
            fragmentContinut = fragmentOrar;

        } else if (id == R.id.item_note) {
            toolbar.setSubtitle("Note");
            toolbar.setLogo(getResources().getDrawable(R.drawable.note));
            fragmentContinut = fragmentNote;

        } else if (id == R.id.item_informatii_utile) {
            toolbar.setSubtitle("Informatii utile");
            toolbar.setLogo(getResources().getDrawable(R.drawable.informatii));
            fragmentContinut = fragmentInformatii;
        }else if (id == R.id.item_webpageCSIE) {
            toolbar.setSubtitle("Webpage CSIE");
            toolbar.setLogo(getResources().getDrawable(R.drawable.webpage_csie));
            fragmentContinut = fragmentWebpageCSIE;
        }

        if(fragmentContinut != null){
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameContinut, fragmentContinut).commit();
        }
        
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        
        return true;
    }
}

