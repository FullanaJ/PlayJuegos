package com.fullana.playjuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Filter extends AppCompatActivity {

    private final List<String> genres = List.of("Acción", "Aventura", "Deportes", "Disparos", "Estrategia", "Lucha", "Musical", "Rol", "Simulación");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);

        ListView listView = findViewById(R.id.genreList);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            Snackbar a = Snackbar.make(v, "El botón se desplaza hacia arriba", Snackbar.LENGTH_SHORT);
            a.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
            a.show();
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, genres);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show());

    }

    public void showChip(View view){
        Chip chip = (Chip) view;

        Toast.makeText(this, chip.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}