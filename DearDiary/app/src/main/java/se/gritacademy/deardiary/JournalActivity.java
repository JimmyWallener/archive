package se.gritacademy.deardiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import se.gritacademy.db.DbHandler;
import se.gritacademy.model.EntriesModel;

public class JournalActivity extends AppCompatActivity {

    TextView jTitle,jText;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);

        jText = findViewById(R.id.journal_textfield);
        jTitle = findViewById(R.id.journal_title);

        updateText();

    }


    private void updateText(){
        DbHandler db = new DbHandler(this);


            if(getIntent().hasExtra("id")) {
                ID = getIntent().getIntExtra("id",0);

                List<EntriesModel> entries = db.listAllEntries();

                Log.d("checkintent", String.valueOf(ID));

                for (EntriesModel e : entries) {
                    if(ID == e.getId()) {
                        jTitle.setText(e.getTitle());
                        jText.setText(e.getEntry());
                    }
                }

            }

    }
}
