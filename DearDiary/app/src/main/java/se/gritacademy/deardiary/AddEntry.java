package se.gritacademy.deardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import se.gritacademy.db.DbHandler;
import se.gritacademy.model.EntriesModel;

public class AddEntry extends AppCompatActivity {
    DbHandler db;
    EditText title, entryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        db = new DbHandler(this);

        title = findViewById(R.id.diary_title);
        entryText = findViewById(R.id.diary_entry);
    }


    public void setEntry(View view) {
        String titleText = title.getText().toString();
        String diaryText = entryText.getText().toString();

        db.setData(new EntriesModel(titleText,diaryText));


        Log.d("entry","title " + titleText + " entry " + diaryText);
        startActivity(new Intent(this,MainActivity.class));
    }


}
