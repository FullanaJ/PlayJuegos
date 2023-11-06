package com.fullana.playjuegos;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fullana.playjuegos.databinding.GamesBinding;

import java.util.ArrayList;
import java.util.List;

public class Games extends AppCompatActivity {

    protected GamesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = GamesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        binding.recycler.setAdapter(new RecyclerAdapter(Juegos.repo()));
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> s = new ArrayList<>();
                ((RecyclerAdapter) binding.recycler.getAdapter()).lista.forEach(
                        (p) -> {
                            if(p.isCheked())
                                s.add(p.getTitulo());
                        }
                );
                if (s.isEmpty())
                    Toast.makeText(Games.this,"No Has elegido ninguna opción",Toast.LENGTH_SHORT).show();
                else {
                    String texto ="Has elegido ";
                    if (s.size()>1){
                        String f = "y "+s.remove(s.size()-1);
                        for (String p :s) {
                            texto.concat(","+p+" ");
                        }
                        Toast.makeText(Games.this,texto+f,Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Games.this,texto+s.get(0),Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox checkBox;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkBox);
            imageView = itemView.findViewById(R.id.imageView8);

        }
    }
}
class Juegos{
    private int urlIagen;
    private String titulo;
    private boolean cheked;

    public Juegos(int urlIagen, String titulo, boolean cheked) {
        this.urlIagen = urlIagen;
        this.titulo = titulo;
        this.cheked = cheked;
    }

    public static ArrayList<Juegos> repo(){

        ArrayList<Juegos> list = new ArrayList<>();
        list.add(new Juegos(R.drawable.games_aircontrol,"Air Control",false));
        list.add(new Juegos(R.drawable.games_angrybirds,"Angry Birds",false));
        list.add(new Juegos(R.drawable.games_dragonfly,"Dragon Fly",false));
        list.add(new Juegos(R.drawable.games_hillclimbingracing,"Hill Climbing Racing",false));
        list.add(new Juegos(R.drawable.games_pocketsoccer,"Poket Soccer",false));
        list.add(new Juegos(R.drawable.games_ninjump,"Ninja Jump",false));

        return list;
    }
    public int getUrlIagen() {
        return urlIagen;
    }

    public void setUrlIagen(int urlIagen) {
        this.urlIagen = urlIagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isCheked() {
        return cheked;
    }

    public void setCheked(boolean cheked) {
        this.cheked = cheked;
    }
}
class RecyclerAdapter extends RecyclerView.Adapter<Games.ViewHolder>{


    ArrayList<Juegos> lista;

    public RecyclerAdapter(ArrayList<Juegos> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public Games.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview, parent, false);

        return new Games.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Games.ViewHolder holder, int position) {

        Juegos j = lista.get(position);
        holder.imageView.setImageResource(j.getUrlIagen());
        holder.checkBox.setText(j.getTitulo());
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                j.setCheked(b);
            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}