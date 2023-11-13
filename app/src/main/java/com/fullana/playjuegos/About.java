package com.fullana.playjuegos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class About extends AppCompatActivity {

    protected RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        recyclerView = findViewById(R.id.recyclerAbout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new AboutAdapter());

    }

    class AboutAdapter extends  RecyclerView.Adapter<AboutAdapter.AboutHolder>{

        private final repoAbout repo = new repoAbout();

        @NonNull
        @Override
        public AboutHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recyclerview_about, parent, false);

            return new AboutHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull AboutHolder holder, int position) {
            setViewHolder(repo.getRepo().get(position),holder);
        }

        private void setViewHolder(repoAbout.Row row, AboutHolder holder) {
            holder.nombre.setText(row.getNombre());
            holder.imageView.setImageResource(row.getUrl());
            holder.nombre.setText(row.getNombre());
            holder.anyo.setText(row.getAnyo());
        }

        @Override
        public int getItemCount() {
            return repo.getRepo().size();
        }

        class AboutHolder extends RecyclerView.ViewHolder{

            protected ImageView imageView;
            protected TextView nombre,anyo;
            public AboutHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView7);
                nombre = itemView.findViewById(R.id.nombre);
                anyo = itemView.findViewById(R.id.anyo);
            }
        }
    }
}
class repoAbout{

    private ArrayList<Row> repo;

    public repoAbout() {
        repo = new ArrayList<>();
        repo.add(new Row(R.drawable.image1,"María Mata","2014"));
        repo.add(new Row(R.drawable.image2,"Antonio Sanz","1890"));
        repo.add(new Row(R.drawable.image3,"Carlos","967"));
        repo.add(new Row(R.drawable.image4,"Berta","945"));
        repo.add(new Row(R.drawable.image5,"Héctor Campos","879"));
        repo.add(new Row(R.drawable.image6,"Ismael","678"));
        repo.add(new Row(R.drawable.image7,"Pedro PicaPiedras","AC 2000"));
        repo.add(new Row(R.drawable.image8,"Pedro Perez","2020"));
    }

    public ArrayList<Row> getRepo() {
        return repo;
    }

    public void setRepo(ArrayList<Row> repo) {
        this.repo = repo;
    }

    static class Row {
        private String nombre,anyo;
        private int url;

        public Row(int url, String nombre, String anyo) {
            this.url = url;
            this.nombre = nombre;
            this.anyo = anyo;
        }

        public int getUrl() {
            return url;
        }

        public void setUrl(int url) {
            this.url = url;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getAnyo() {
            return anyo;
        }

        public void setAnyo(String anyo) {
            this.anyo = anyo;
        }
    }
}
