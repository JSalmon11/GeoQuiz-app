package dev.JSalmon.geoquiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button button_swipe;
    private TextView puntosTextView;
    private int puntos=0;

    private TextView preguntasTextView;
    private Preguntas[] arrayPreguntas=new Preguntas[]{
            new Preguntas(R.string.pregunta1, true),
            new Preguntas(R.string.pregunta2, false),
            new Preguntas(R.string.pregunta3, true),
    };
    private int currentIndex=0;

    private void updatePregunta(){
        int pregunta=arrayPreguntas [currentIndex].getTextResId();
        preguntasTextView.setText(pregunta);
    }

    private void updatePuntos(){
        puntosTextView = findViewById(R.id.textPuntos);
        puntosTextView.setText("Puntos: "+Integer.toString(puntos));
    }

    private void checkAnswer (boolean userPressedTrue){
        boolean answerIsTrue=arrayPreguntas [currentIndex].isAnswerTrue();

        int messageResId=0;

        if (userPressedTrue==answerIsTrue){
            ++puntos;
            updatePuntos();
            messageResId=R.string.correct_toast;
        }else{
            messageResId=R.string.incorrect_tost;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        currentIndex=(currentIndex+1) % arrayPreguntas.length;
        updatePregunta();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updatePuntos();

        preguntasTextView= findViewById(R.id.textPreguntas);
        updatePregunta();

        mTrueButton= findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                checkAnswer(true);
            }
        });

        mFalseButton= findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                checkAnswer(false);
            }
        });

        button_swipe=findViewById(R.id.button_Swipe);
        button_swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeLeft() {
                currentIndex=(currentIndex+1) % arrayPreguntas.length;
                updatePregunta();
            }
        });

    }// onCreate()

}// MainActivity