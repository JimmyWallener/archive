package se.gritacademy.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import se.gritacademy.model.EntriesModel;

public class DbHandler extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "journal";
    private static final String TABLE = "journal_entries";
    private static final String KEY_ID = "id";
    private static final String TITLE = "journal_title";
    private static final String ENTRY = "journal_entries";


    public DbHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            String makeDatabase = "CREATE TABLE " + TABLE +" (" + KEY_ID + " INTEGER PRIMARY KEY, "
                    + TITLE + " TEXT,"
                    + ENTRY + " TEXT" +")";
            db.execSQL(makeDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
            onCreate(db);
    }

    public void setData(EntriesModel entries){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();



        value.put(TITLE, entries.getTitle());
        value.put(ENTRY, entries.getEntry());

        db.insert(TABLE, null,value);

        Log.d("handler", entries.getTitle());
        db.close();
    }




    // For populating JournalActivity with entries
    public List<EntriesModel> listAllEntries() {

        List<EntriesModel> entries = new ArrayList<>();

        String dbQuery = "SELECT * FROM " + TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(dbQuery,null);

        if (cursor.moveToFirst()) {
            do {
                EntriesModel entry = new EntriesModel();
                entry.setId(Integer.parseInt(cursor.getString(0)));
                entry.setTitle(cursor.getString(1));
                entry.setEntry(cursor.getString(2));
                entries.add(entry);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return entries;

    }


    public int entriesCounter() {
        String count = "SELECT * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(count, null);


        return cursor.getCount();

    }
}
