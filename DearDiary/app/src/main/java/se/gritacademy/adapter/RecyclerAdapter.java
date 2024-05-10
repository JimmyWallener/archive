package se.gritacademy.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import se.gritacademy.db.DbHandler;
import se.gritacademy.deardiary.JournalActivity;
import se.gritacademy.deardiary.R;
import se.gritacademy.model.EntriesModel;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<EntriesModel> list;


    Context context;


    public RecyclerAdapter(Context context) {
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
       View view  = layoutInflater.inflate(R.layout.rows, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            DbHandler db = new DbHandler(context);
            list =  db.listAllEntries();

            holder.title.setText(list.get(position).getTitle());
            holder.image.setImageResource(R.drawable.diary);

            Log.d("titles", list.toString());

        holder.recyclerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JournalActivity.class);
                EntriesModel forwardInfo = list.get(position);

                intent.putExtra("id", forwardInfo.getId());
                context.startActivity(intent);
                Log.d("forwardid", String.valueOf(+ forwardInfo.getId()));
            }
        });
    }

    @Override
    public int getItemCount() {
        DbHandler db = new DbHandler(context);
        Log.d("Recycler","Entries :" + db.entriesCounter());
        return db.entriesCounter();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        ConstraintLayout recyclerLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_view);
            image = itemView.findViewById(R.id.title_image);
            recyclerLayout = itemView.findViewById(R.id.recyclerLayout);
        }
    }
}
