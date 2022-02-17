package dev.JSalmon.geoquiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

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

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.ganador);
        mediaPlayer.start();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        puntuacionTextView = findViewById(R.id.textPuntuación);
        int puntuacion = Integer.parseInt(message);
        puntuacionTextView.setText(getResources().getString(R.string.finalPuntos)+" "+puntuacion);

        boolean puntuacionSuperada=false;
        int puntuacionMax = 0;
        for (int i = 0; i < 10; ++i) {
            if (TaskTablaRanking.prefs.getPuntuacion(i + "") < puntuacion) {
                puntuacionMax=TaskTablaRanking.prefs.getPuntuacion(i + "");
                TaskTablaRanking.prefs.setPuntuacion(i + "", puntuacion);
                puntuacion=puntuacionMax;
            }
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