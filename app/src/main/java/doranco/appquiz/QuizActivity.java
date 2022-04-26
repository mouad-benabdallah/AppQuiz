package doranco.appquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView question_num,question;
    private Button reponse1,reponse2,reponse3,reponse4;
    private Integer score;
    Question q ;

    SharedPreferences sharedPreferences;

    QuestionBank questions = DataQuiz.generateQuestions();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE);

        question_num = findViewById(R.id.question_num);
        question = findViewById(R.id.Question);
        reponse1 = findViewById(R.id.reponse1);
        reponse2 = findViewById(R.id.reponse2);
        reponse3 = findViewById(R.id.reponse3);
        reponse4 = findViewById(R.id.reponse4);


        reponse1.setTag(0);
        reponse2.setTag(1);
        reponse3.setTag(2);
        reponse4.setTag(3);


        reponse1.setOnClickListener(this);
        reponse2.setOnClickListener(this);
        reponse3.setOnClickListener(this);
        reponse4.setOnClickListener(this);



    }

    @Override
    protected void onStart() {
        super.onStart();
        loadQuastion();

    }

    public void onClick(View view){
        int reponseIndex = (int) view.getTag();

        if(questions.getNextQuestionIndex() <= questions.getTotaleOfAllQuestions()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadQuastion();
                }
            },2000);
            questions.setNextQuestionIndex(questions.getNextQuestionIndex()+1);
            if(reponseIndex == q.getCorrectreponseindex()){
                score++;
            }
        }
        else {
            AlertDialog.Builder alert = new AlertDialog.Builder(QuizActivity.this);
            alert.setTitle("Fin !");
            alert.setMessage("Votre score "+score+"/"+questions.getTotaleOfAllQuestions());
            alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("score",Integer.toString(score))
                    .putInt("totaleQuestion",questions.getTotaleOfAllQuestions())
                    .apply();
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            });
            alert.show();

        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    public void loadQuastion(){
        q = questions.getNextQuestion();
        question_num.setText(questions.getNextQuestionIndex()+"/"+questions.getTotaleOfAllQuestions());
        question.setText(q.getQuestion());
        reponse1.setText(q.getReponseslist().get(0));
        reponse2.setText(q.getReponseslist().get(1));
        reponse3.setText(q.getReponseslist().get(2));
        reponse4.setText(q.getReponseslist().get(3));
    }
}