package se.gritacademy.deardiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import se.gritacademy.adapter.RecyclerAdapter;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        image = findViewById(R.id.title_image);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(this));
    }



    public void addEntry(View view) {
        startActivity(new Intent(this,AddEntry.class));

    }

}
