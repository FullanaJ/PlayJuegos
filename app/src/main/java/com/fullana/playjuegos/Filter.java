package com.fullana.playjuegos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Filter extends AppCompatActivity {

    protected RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            Snackbar a = Snackbar.make(v, "El botón se desplaza hacia arriba", Snackbar.LENGTH_SHORT);
            a.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
            a.show();
        });
        recyclerView = findViewById(R.id.recycler2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new filtroAdapter());

    }

    public void showChip(View view){
        Chip chip = (Chip) view;

        Toast.makeText(this, chip.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}
class filtroAdapter extends RecyclerView.Adapter<filtroAdapter.ViewHolderPersonalizado> implements View.OnClickListener {

     List<String> generos = List.of("Accion", "Aventura", "Deportes", "Disparos", "Estrategia", "Lucha", "Musical", "Rol", "Simulacion");

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"Has elegido el juego : "+((TextView) view).getText().toString(),Toast.LENGTH_SHORT).show();
    }


    public static class ViewHolderPersonalizado extends RecyclerView.ViewHolder {
        protected final TextView textView;

        public ViewHolderPersonalizado(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            textView = (TextView) view.findViewById(R.id.textView4);

        }

    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public ViewHolderPersonalizado onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_filter_recycler_view_content, parent, false);

        return new ViewHolderPersonalizado(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderPersonalizado viewHolder, final int position) {

        viewHolder.textView.setText(generos.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return generos.size();
    }
}
