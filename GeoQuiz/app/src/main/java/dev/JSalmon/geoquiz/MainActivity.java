package dev.JSalmon.geoquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//VOY POR LA PAGINA 64 DEL NERDS 2
public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
<<<<<<< HEAD
=======
    private Button button_swipe;

    private TextView preguntasTextView;
    private Preguntas[] arrayPreguntas=new Preguntas[]{
            new Preguntas(R.string.pregunta1, true),
            new Preguntas(R.string.pregunta2, false),
            new Preguntas(R.string.pregunta3, true),
    };
    private int currentIndex=0;
>>>>>>> 797ede0 (commit 27/10/2021)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
=======
        preguntasTextView= findViewById(R.id.textPreguntas);
        updatePregunta();

>>>>>>> 797ede0 (commit 27/10/2021)
        mTrueButton= findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(v -> Toast.makeText(MainActivity.this,
        R.string.verdadero_toast,
        Toast.LENGTH_SHORT).show());

        mFalseButton= findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(v -> Toast.makeText(MainActivity.this,
        R.string.falso_tost,
        Toast.LENGTH_SHORT).show());

        button_swipe=findViewById(R.id.button_Swipe);
        button_swipe.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            @Override
            public void onSwipeLeft() {
                currentIndex=(currentIndex+1) % arrayPreguntas.length;
                updatePregunta();
            }
        });
        updatePregunta();

    }// onCreate()

    private void updatePregunta(){
        int pregunta=arrayPreguntas [currentIndex].getTextResId();
        preguntasTextView.setText(pregunta);
    }

}// MainActivity