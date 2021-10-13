package jjcamposc.ioc.twoactivities_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_SECOND ="jjcamposc.ioc.twoactivities_1.extra.MESSAGE";
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        Intent intentRecollida = getIntent();
        String missatgeRecollit = intentRecollida.getStringExtra(MainActivity.EXTRA_MESSAGE_MAIN);
        TextView textView = findViewById(R.id.text_message_second);
        textView.setText(missatgeRecollit);

        editText2 = findViewById(R.id.edit_text_second);

    }

    public void resendMissatge(View view) {
       String missatgeSecond = editText2.getText().toString();                     // Recupero el text de l'edit text i el converteixo en String
       Intent intentSecond = new Intent();                                        // Creo un intent buit
       intentSecond.putExtra(EXTRA_MESSAGE_SECOND,missatgeSecond);               // Afegeixo un ExtraMessage
       setResult(RESULT_OK, intentSecond);
       finish();
       //Retornar pel canal de forma exitosa el missatge de l'intent.
        // El primer paràmetre és la constant RESULT_OK de la classe Activity que indica que tot ha sortit bé.
       // El segon paràmetre és l'Intent portador del mensaje.
    }
}