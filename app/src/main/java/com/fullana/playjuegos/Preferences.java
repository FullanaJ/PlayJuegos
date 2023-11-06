package com.fullana.playjuegos;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fullana.playjuegos.databinding.PreferencesBinding;

public class Preferences extends AppCompatActivity {

    protected PreferencesBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PreferencesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.seekBar.setMax(binding.ratingBar.getMax());
        binding.seekBar.setMin(binding.ratingBar.getMin());
        binding.floatingActionButton.setOnClickListener((l)->{
          try {
              RadioGroup group = binding.radioGroup;
              int radioButtonID = group.getCheckedRadioButtonId();
              View radioButton = group.findViewById(radioButtonID);
              int idx = group.indexOfChild(radioButton);
              RadioButton r = (RadioButton) group.getChildAt(idx);
              String selectedtext = r.getText().toString()+" puntuacion: "+ binding.seekBar.getProgress();
              Toast.makeText(this,selectedtext,Toast.LENGTH_SHORT).show();
          }catch (Exception e){
              Toast.makeText(this,"Selecciona alguna opcion",Toast.LENGTH_SHORT).show();
          }
                    });
        binding.ratingBar.setOnRatingBarChangeListener((j,f,e) -> {
            if(e){
                binding.seekBar.setProgress((int) f);
            }
        });
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    binding.ratingBar.setProgress(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
