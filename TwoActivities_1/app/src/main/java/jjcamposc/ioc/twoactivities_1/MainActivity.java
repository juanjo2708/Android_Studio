package jjcamposc.ioc.twoactivities_1;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE_MAIN ="jjcamposc.ioc.twoactivities_1.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;

    private EditText editTextMessageMain;
    private TextView textViewMain;

    ActivityResultLauncher<Intent> arl = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent data = result.getData();

                    }
                }
            }
    )


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessageMain = findViewById(R.id.edit_text_main);

        textViewMain=findViewById(R.id.text_message_main);


    }

    public void launchSecondActivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        String missatgeMain = editTextMessageMain.getText().toString();
        Intent intentMain = new Intent(this, SecondActivity2.class);
        intentMain.putExtra(EXTRA_MESSAGE_MAIN, missatgeMain);
        startActivityForResult(intentMain, TEXT_REQUEST);
    }

    //Sobrescribirem  un mètode especial de la classe Activity anomenat onActivityResult(),
    // el qual es autoinvocat per rebre la informació de una activitat que va ser cridada amb startActivityForResult().
    @Override
    // @params  Codi de petició, codi del resultat, intent de reenviament
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity2.EXTRA_MESSAGE_SECOND);
                textViewMain.setVisibility(View.VISIBLE);
                textViewMain.setText(reply);
            }
        }
    }






    public void veureImatge(View view) {
        Intent intentImg = new Intent(this, SecondActivity2.class);
        intentImg.putExtra(EXTRA_MESSAGE_MAIN,"Consulto via button imatge");
        startActivity(intentImg);

    }

    public void nouLaunch(View view) {




    }
}