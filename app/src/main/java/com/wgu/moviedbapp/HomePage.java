package com.wgu.moviedbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HomePage extends AppCompatActivity {
    TextView about;

    private static String DATABASE_PATH_AND_NAME;
    private static String CHECK_DATABASES_FOLDER;
    private static final String DATABASE_NAME = "moviedatabase.db";
    private static final String LOG_TAG = "moviedatabase.db";

    OpenDatabase sqh;
    SQLiteDatabase sqdb;

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        about = findViewById(R.id.idAboutButton);
        setupDatabaseStrings();
        setUpDatabase();
        InitDataBase();
        DisplayRecords();

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePage.this, About.class));
            }
        });
    }

    protected void setupDatabaseStrings()
    {
// Full path to where we will copy music.db to on the emulator!
        DATABASE_PATH_AND_NAME = "/data/data/" + getApplicationContext().getPackageName() +
                "/databases/" + DATABASE_NAME;
// Used to check if the "databases" folder exists
        CHECK_DATABASES_FOLDER = "/data/data/" + getApplicationContext().getPackageName() +
                "/databases";
// Debug information
        Log.i("DATABASE_PATH_AND_NAME","DATABASE_PATH_AND_NAME = " + DATABASE_PATH_AND_NAME);
        Log.i("CHECK_DATABASES_FOLDER","CHECK_DATABASES_FOLDER = " + CHECK_DATABASES_FOLDER);
    } // protected void setupDatabaseStrings()

    protected void setUpDatabase()
    {
        ctx = this.getBaseContext();
        try
        {
            CopyDataBaseFromAsset();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    } // protected void setUpDatabase()

    protected void CopyDataBaseFromAsset() throws IOException
    {
// Open the sqlite database "music.db" found in the assets folder
        InputStream in = ctx.getAssets().open(DATABASE_NAME);
        Log.w( LOG_TAG , "Starting copying...");
        String outputFileName = DATABASE_PATH_AND_NAME;
        File databaseFolder = new File( CHECK_DATABASES_FOLDER );
// databases folder exists ? No - Create it and copy !!!
        if ( !databaseFolder.exists() )
        {
            databaseFolder.mkdir();
            OutputStream out = new FileOutputStream(outputFileName);
            byte[] buffer = new byte[1024];
            int length;
            while ( (length = in.read(buffer)) > 0 )
            {
                out.write(buffer,0,length);
            } // while ( (length = in.read(buffer)) > 0 )
            out.flush();
            out.close();
            in.close();
            Log.w(LOG_TAG, "Completed.");
        } // if ( !databaseFolder.exists() )
    } // protected void CopyDataBaseFromAsset() throws IOException

    public void InitDataBase()
    {
// Init the SQLite Helper Class
        sqh = new OpenDatabase(this);
// RETRIEVE A READABLE AND WRITEABLE DATABASE
        sqdb = sqh.getWritableDatabase();
    } // public void InitDataBase() {

    public void DisplayRecords()
    {
        Cursor c = sqdb.rawQuery("SELECT * FROM movies", null);
        if (c != null)
        {
            if (c.moveToFirst())
            {
                do
                {
                    Integer id = c.getInt(0);
                    ///String songtitle = c.getString(1);
                    String year = c.getString(2);
//                    String artist = c.getString(3);
//                    String album = c.getString(4);
                    Log.w("SONG_TABLE", "ID = " + id + " Songtitle = " + year);
                } while (c.moveToNext());
            }
        }
        c.close();
    } // public void DisplayRecords()

}