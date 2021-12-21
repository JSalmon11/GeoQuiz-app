package dev.JSalmon.geoquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class finDisplay extends AppCompatActivity {
    private Button buttonRestart;
    private Button buttonRanking;
    private TextView puntuacionTextView;
    public static final String RUTA = "dev.JSalmon.geoquiz.MESSAGE";

    public void restartApp(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }// restartApp()

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        puntuacionTextView = findViewById(R.id.textPuntuación);
        puntuacionTextView.setText(getResources().getString(R.string.finalPuntos)+" "+message);


        File f = new File("/storage/emulated/files/Ranking.dat");
        String ruta = f.getAbsolutePath();
        if (ruta != null) {
            Log.i(":::TAG:", ruta);
        }
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(f);
            fos.write(Integer.parseInt(message));
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonRanking= findViewById(R.id.buttonRanking);
        buttonRanking.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                Intent intent = new Intent(finDisplay.this, Ranking.class);
                startActivity(intent);
            }
        });

        buttonRestart= findViewById(R.id.restart_button);
        buttonRestart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                restartApp();
            }
        });
    }// onCreate()
}// finDisplay