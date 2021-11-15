package dev.JSalmon.geoquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class finDisplay extends AppCompatActivity {
    private Button buttonRestart;
    private TextView puntuacionTextView;

    public void restartApp(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fin_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textPuntuación);
        textView.setText(message);

        buttonRestart= findViewById(R.id.restart_button);
        buttonRestart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                restartApp();
            }
        });
    }
}