package camposc.ioc.twoactivities_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvSecond;
    EditText etSecond;
    Button buttonSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Assignació de variables als controls
        tvSecond = findViewById(R.id.tVSecond);
        etSecond = findViewById(R.id.eTSecond);
        buttonSecond = findViewById(R.id.buttonSecond);

        // Recepció de les dades del MainActivity
        Intent intentReceptor = getIntent();    //Creo l' Intent getintent

        //Si existeixen -> recullo les variables passades via Intent
        if(intentReceptor != null) {
            String missatge = intentReceptor.getStringExtra(MainActivity.EXTRA_MISSATGE);
            String contingut = intentReceptor.getStringExtra(MainActivity.EXTRA_CONTINGUT);

            //Assignació de valors a les variables.
            tvSecond.setText(missatge);
            etSecond.setText(contingut);
        }
    }
}