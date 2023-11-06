package com.fullana.playjuegos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    protected ImageButton imageButton;
    protected Toolbar toolbar;
    protected Button play,newplayer,preferences,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializa();
        setOnClicks();
    }

    private void setOnClicks() {

        newplayer.setOnClickListener((l)-> {
            Intent intent = new Intent(this,NewPlayer.class);
            startActivity(intent);
        });
        preferences.setOnClickListener( (l) -> {
            Intent intent = new Intent(this, Preferences.class);
            startActivity(intent);
        });
        play.setOnClickListener( (l) -> {
            Intent intent = new Intent(this, Games.class);
            startActivity(intent);
        });
        imageButton.setOnClickListener( (l) -> {
            Intent intent = new Intent(this, Filter.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_buscar){
            Toast.makeText(this,"Busqueda",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializa() {
        imageButton = findViewById(R.id.imageButton4);
        toolbar = findViewById(R.id.toolbar);
        play = findViewById(R.id.button);
        newplayer = findViewById(R.id.button2);
        preferences = findViewById(R.id.button3);
        about = findViewById(R.id.button4);
    }
}