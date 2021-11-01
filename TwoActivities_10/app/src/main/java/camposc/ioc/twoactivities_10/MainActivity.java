package camposc.ioc.twoactivities_10;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    EditText etMain;
    Button buttonMain;
    Button buttoMainRetorn;

    // keys definition
    public final static String EXTRA_MISSATGE = "camposc.ioc.twoactivities_10.MISSATGE";
    public final static String EXTRA_CONTINGUT = "camposc.ioc.twoactivities_10.extra.CONTINGUT";

    public final static String TAG ="MainActivity";

    // Request codes
    public final static int MISSATGE_RETORNAT =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tVMain);
        etMain = findViewById(R.id.eTMain);
        buttonMain = findViewById(R.id.buttonMain);
        buttoMainRetorn = findViewById(R.id.button2Main);

        //launcher per recollir les dades  retornades de Second Activity
        ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Log.d(TAG,"onActivityResult: ");
                        if (result.getResultCode()==78){
                            Intent intent = result.getData();

                            if(intent !=null){
                                String dades = intent.getStringExtra("result");
                                tvMain.setText(dades);
                            }
                        }
                    }
                }
        );



        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(MainActivity.this,SecondActivity.class);
                intentMain.putExtra(EXTRA_MISSATGE,tvMain.getText().toString());
                intentMain.putExtra(EXTRA_CONTINGUT,etMain.getText().toString());
                startActivity(intentMain);
            }
        });

        buttoMainRetorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMainReturn = new Intent(MainActivity.this,SecondActivity.class);
                intentMainReturn.putExtra(EXTRA_MISSATGE,tvMain.getText().toString());
                intentMainReturn.putExtra(EXTRA_CONTINGUT,etMain.getText().toString());
                setResult(74, intentMainReturn);
                activityLauncher.launch(intentMainReturn);

            }
        });



    }
}