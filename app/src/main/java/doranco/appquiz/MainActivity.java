package doranco.appquiz;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editTextNom;
    private Button btnCommenser;
    private ImageView delete;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById((R.id.textView_bonjour));
        editTextNom = findViewById(R.id.editTextNom);
        btnCommenser = findViewById(R.id.btnCommencer);
        delete = findViewById(R.id.Delete);

        sharedPreferences = getSharedPreferences("users", MODE_PRIVATE);

        editTextNom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String nom = editTextNom.getText().toString().trim();
                if(!nom.isEmpty()){
                    btnCommenser.setTextColor(getColor(R.color.btn_text_active));
                    btnCommenser.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.btn_commenser_active)));
                    btnCommenser.setEnabled(!nom.isEmpty());
                    delete.setImageTintList(ColorStateList.valueOf(getColor(R.color.btn_delete_active)));
                    delete.setEnabled(!nom.isEmpty());
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        String user = sharedPreferences.getString("user","");
        String Score =  sharedPreferences.getString("score","");
        int totaleQuestion = sharedPreferences.getInt("totaleQuestion",0);
        if (!Score.equals("")){
            editTextNom.setText(user);
            textView.setText("Bonjour "+user+"\n votre dernier score est "+Score+"/"+totaleQuestion);
        }
    }

    public void Delete(View view){

        editTextNom.setText("");
    }

    public void Commencer(View view){
        Intent intent = new Intent(MainActivity.this, QuizActivity.class);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("user",editTextNom.getText().toString());
        startActivity(intent);
    }


}