package dev.JSalmon.geoquiz;

import android.app.Activity;
import android.content.Intent;
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
    private Button mCheatButton;
    private TextView puntosTextView;
    private int puntos=0;
    private static final String KEY_INDEX = "index";
    private static final String KEY_PUNTOS = "puntos";
    private static final int CODE_CHEAT = 0;
    private boolean isCheater;

    public static final String EXTRA_MESSAGE = "dev.JSalmon.geoquiz.MESSAGE";

    private TextView preguntasTextView;
    private Preguntas[] arrayPreguntas=new Preguntas[]{
            new Preguntas(R.string.pregunta1, true),
            new Preguntas(R.string.pregunta2, false),
            new Preguntas(R.string.pregunta3, true),
            new Preguntas(R.string.pregunta4, true),
            new Preguntas(R.string.pregunta5, false),
            new Preguntas(R.string.pregunta6, true),
            new Preguntas(R.string.pregunta7, false),
    };
    private int currentIndex=0;

    private void updatePregunta(){
        int pregunta=arrayPreguntas [currentIndex].getTextResId();
        preguntasTextView.setText(pregunta);
    }// updatePregunta()

    private void updatePuntos(){
        puntosTextView = findViewById(R.id.textPuntos);
        puntosTextView.setText(getResources().getString(R.string.string_puntos)+" "+Integer.toString(puntos));
    }// updatePuntos()

    private void finDisplay(){
        int indexIf = currentIndex;
        if (++indexIf == arrayPreguntas.length){
            Intent intent = new Intent(this, finDisplay.class);
            String message = Integer.toString(puntos);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }
    }// finDisplay()

    private void checkAnswer (boolean userPressedTrue){
        boolean answerIsTrue=arrayPreguntas [currentIndex].isAnswerTrue();
        int messageResId=0;

        if (isCheater) {
            messageResId=R.string.judgment_toast;
            finDisplay();
        }else{
            if (userPressedTrue == answerIsTrue) {
                ++puntos;
                updatePuntos();
                messageResId = R.string.correct_toast;
                finDisplay();
            } else {
                messageResId = R.string.incorrect_tost;
                finDisplay();
            }
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
        currentIndex = (currentIndex + 1) % arrayPreguntas.length;
        updatePregunta();
    }// checkAnswer()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updatePuntos();

        if (savedInstanceState != null){
            currentIndex=savedInstanceState.getInt(KEY_INDEX, 0);
            puntos=savedInstanceState.getInt(KEY_PUNTOS, 0);
            updatePuntos();
        }

        preguntasTextView= findViewById(R.id.textPreguntas);
        updatePregunta();

        mCheatButton=findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                boolean answerIsTrue = arrayPreguntas[currentIndex].isAnswerTrue();
                Intent i=CheatActivity.newIntent(MainActivity.this, answerIsTrue);
                startActivityForResult(i, CODE_CHEAT);
            }// onClick()
        });

        mTrueButton= findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                checkAnswer(true);
                isCheater=false;
            }// onClick()
        });

        mFalseButton= findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v) {
                checkAnswer(false);
                isCheater=false;
            }// onClick()
        });

        button_swipe=findViewById(R.id.button_Swipe);
        button_swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeLeft() {
                finDisplay();
                currentIndex=(currentIndex+1) % arrayPreguntas.length;
                isCheater=false;
                updatePregunta();
            }// onSwipeLeft()
        });

    }// onCreate()

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == CODE_CHEAT) {
            if (data == null) {
                return;
            }
            isCheater = CheatActivity.wasAnswerShown(data);
        }
    }// onActivityResult()

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, currentIndex);
        savedInstanceState.putInt(KEY_PUNTOS, puntos);
    }// onSaveInstanceState()

}// MainActivity