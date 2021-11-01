package jjcamposc.ioc.twoactivities_2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private TextView txt_result;
    private Button btn_get_result;

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
                           txt_result.setText(dades);
                       }
                    }

                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_result = findViewById(R.id.textView);
        txt_result.setText("text provinent de la primera activitat");
        btn_get_result = findViewById(R.id.button);

    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ResultActiivity.class);
        intent.putExtra("retorn",txt_result.getText().toString());
        setResult(74, intent);
        activityLauncher.launch(intent);
    }
}