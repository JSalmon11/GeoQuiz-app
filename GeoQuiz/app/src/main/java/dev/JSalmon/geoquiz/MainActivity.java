package dev.JSalmon.geoquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//VOY POR LA PAGINA 64 DEL NERDS 2
public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton= findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(v -> Toast.makeText(MainActivity.this,
        R.string.verdadero_toast,
        Toast.LENGTH_SHORT).show());

        mFalseButton= findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(v -> Toast.makeText(MainActivity.this,
        R.string.falso_tost,
        Toast.LENGTH_SHORT).show());
    }// onCreate()

}// MainActivity