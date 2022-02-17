package dev.JSalmon.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_ISTRUE = "android.gequiz.answer_is_true";
    private boolean mAnswerIsTrue;
    private static final String EXTRA_ANSWER_SHOWN = "android.gequiz.answer_shown";

    public static Intent newIntent (Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_ISTRUE, answerIsTrue);
        return i;
    }// newIntent()

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }// wasAnswerShown()

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue=getIntent().getBooleanExtra(EXTRA_ANSWER_ISTRUE, false);

        mAnswerTextView = (TextView) findViewById(R.id.answer_text);

        mShowAnswer = (Button) findViewById(R.id.show_Answer_Button);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                if (mAnswerIsTrue){
                    mAnswerTextView.setText((R.string.button_true));
                }else{
                    mAnswerTextView.setText((R.string.button_false));
                }
                setAnswerShownResult(true);
            }
        });
    }// onCreate()

    private void setAnswerShownResult (boolean isAnswerShown) {
        Intent data =new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }// setAnswerShownResult()

}// CheatActivity