package com.example.proiectdam.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/*
DATE LOGARE

user                 pass
buradasilviu         1234
burtearazvan         1234
cazalbasulaurentiu   1234
burlacualina         1234
*/

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        EditText ed1 = (EditText)findViewById(R.id.editTextUser);
        EditText ed2 = (EditText)findViewById(R.id.editTextPass);
        ImageView imgView = (ImageView)findViewById(R.id.imageView);
        TextView textWarning = (TextView)findViewById(R.id.textViewWarning);

        ed1.setText("");
        ed2.setText("");
        imgView.setVisibility(View.INVISIBLE);
        textWarning.setText("");
    }

    public void update_database(View view) throws MalformedURLException {
        String path = LoginActivity.this.getFilesDir().getAbsolutePath() + "/proiectdb.db";

        if (isOnline()) {
            DownloadDB download = new DownloadDB();
            URL url = new URL("https://goo.gl/gsXJFZ");
            download.execute(url);
        } else {
            Toast.makeText(LoginActivity.this, "Nu ma pot conecta la internet!", Toast.LENGTH_SHORT).show();
        }
    }

    class DownloadDB extends AsyncTask<URL, Integer, Boolean>{
        private ProgressDialog progress;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = new ProgressDialog(LoginActivity.this);
            progress.setTitle("Download database");
            progress.setMessage("Please wait...");
            progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progress.setProgress(0);
            progress.setIndeterminate(true);
            progress.setMax(1);
            progress.show();
        }

        @Override
        protected Boolean doInBackground(URL... params) {
            HttpClient client = new DefaultHttpClient();
            try {
                HttpGet httpget = new HttpGet(params[0].toURI());
                HttpResponse response = client.execute(httpget);
                if (response.getStatusLine().getReasonPhrase().equals("OK")) {
                    InputStream in = response.getEntity().getContent();
                    long dbsize = response.getEntity().getContentLength();
                    long download_curent = 0;
                    FileOutputStream fisier_db = openFileOutput("proiectdb.db", Context.MODE_PRIVATE);
                    byte[] buffer = new byte[256];
                    int i;
                    while ((i = in.read(buffer)) != -1) {
                        fisier_db.write(buffer, 0, i);
                        download_curent += i;
                        publishProgress((int) download_curent/1000, (int) dbsize/1000);
                    }
                    fisier_db.close();
                    in.close();
                    return true;
                }
                else{
                    progress.dismiss();
                    Handler handler =  new Handler(LoginActivity.this.getMainLooper());
                    handler.post( new Runnable(){
                        public void run(){
                            Toast.makeText(LoginActivity.this, "Download failed!",Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }catch (Exception ex){

            }
            return false;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progress.setProgressNumberFormat("%1d/%2d kB");
            progress.setMessage("Downloading...");
            progress.setIndeterminate(false);
            progress.setMax(values[1]);
            progress.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) {
                Toast.makeText(LoginActivity.this, "Database download complet", Toast.LENGTH_LONG).show();
                final Thread t = new Thread() {
                    @Override
                    public void run() {
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        progress.dismiss();
                    }
                };
                t.start();
            }
        }
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null &&
                cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }

    private boolean checkDataBase(String path) {
        SQLiteDatabase checkDB = null;

        try {
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        } catch(SQLiteException e) {
            e.printStackTrace();
        }

        if(checkDB != null){
            checkDB.close();
        }

        return (checkDB != null);
    }

    public void login_event(View v) throws IOException {
        final View view = (View)v.getParent();
        EditText ETUser = (EditText)view.findViewById(R.id.editTextUser);
        EditText ETPass = (EditText)view.findViewById(R.id.editTextPass);

        String user = ETUser.getText().toString();
        String pass = ETPass.getText().toString();

        if(user.equals(""))
        {
            TextView tv = (TextView)view.findViewById(R.id.textViewWarning);
            ImageView iv = (ImageView)view.findViewById(R.id.imageView);
            tv.setText("Introduceti username!");
            iv.setVisibility(View.VISIBLE);
        }
        else if(pass.equals(""))
        {
            TextView tv = (TextView)view.findViewById(R.id.textViewWarning);
            ImageView iv = (ImageView)view.findViewById(R.id.imageView);
            tv.setText("Introduceti password!");
            iv.setVisibility(View.VISIBLE);
        }
        else
        {
            String path = LoginActivity.this.getFilesDir().getAbsolutePath() + "/proiectdb.db";

            if(!checkDataBase(path)) {
                if (isOnline()) {
                    DownloadDB download = new DownloadDB();
                    URL url = new URL("https://goo.gl/gsXJFZ");
                    download.execute(url);
                } else {
                    Toast.makeText(LoginActivity.this, "Nu ma pot conecta la internet!", Toast.LENGTH_SHORT).show();
                }
            }
            else{
                SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

                String sql = "SELECT * FROM studenti WHERE username='" + user + "' AND password='" + pass + "'";
                Cursor c = db.rawQuery(sql, null);
                if(c.moveToFirst()){
                    int id = c.getInt(c.getColumnIndex("id"));
                    Intent it = new Intent(getApplicationContext(), MenuActivity.class);
                    it.putExtra("id", id);
                    it.putExtra("path", path);
                    db.close();
                    startActivity(it);
                }
                else{
                    db.close();
                    Toast.makeText(LoginActivity.this, "Logare esuata!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }



}
