package database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import models.Album;

public class AlbumDatabaseHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "album.db";
    private static final int DATABASE_VERSION = 1;

    // Declarar tablas y columnas
    public static final String ALBUMS_TABLE = "albums";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ARTIST = "artist";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_IMAGE_URL = "image_url";

    public AlbumDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ALBUMS_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TITLE + " TEXT, " +
                COLUMN_ARTIST + " TEXT, " +
                COLUMN_GENRE + " TEXT, " +
                COLUMN_IMAGE_URL + " TEXT" + "); "
        );

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, "Un susurro en la tormenta");
        values.put(COLUMN_ARTIST, "La Oreja de Van Gogh");
        values.put(COLUMN_GENRE, "Pop");
        values.put(COLUMN_IMAGE_URL, "https://i0.wp.com/havisolo.com/wp-content/uploads/2020/09/image002-3-e1593889165711.jpg");

        ContentValues values2 = new ContentValues();
        values2.put(COLUMN_TITLE, "Un susurro en la tormenta");
        values2.put(COLUMN_ARTIST, "La Oreja de Van Gogh");
        values2.put(COLUMN_GENRE, "Pop");
        values2.put(COLUMN_IMAGE_URL, "https://i0.wp.com/havisolo.com/wp-content/uploads/2020/09/image002-3-e1593889165711.jpg");

        db.insert(ALBUMS_TABLE, null, values);
        db.insert(ALBUMS_TABLE, null, values2);

        values.clear();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Implementar lógica de migración
    }

    public List<Album> getAllAlbums() {
        List<Album> albumList = new ArrayList<>();
        // Obtener la db declarada en el constructor
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_ARTIST,
                COLUMN_GENRE,
                COLUMN_IMAGE_URL
        };

        Cursor cursor = db.query(
                ALBUMS_TABLE,  // Nombre de la tabla
                columns,
                null, null, null,null, null
        );

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                    @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
                    @SuppressLint("Range") String artist = cursor.getString(cursor.getColumnIndex(COLUMN_ARTIST));
                    @SuppressLint("Range") String genre = cursor.getString(cursor.getColumnIndex(COLUMN_GENRE));
                    @SuppressLint("Range") String imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE_URL));

                    // Cree un objeto Album con los datos recuperados
                    albumList.add(new Album(id, title, artist, genre, imageUrl));

                } while (cursor.moveToNext());
            }
        }
        return albumList;
    }
}
