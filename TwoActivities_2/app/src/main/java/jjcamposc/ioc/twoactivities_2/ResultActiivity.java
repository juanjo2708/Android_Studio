package jjcamposc.ioc.twoactivities_2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActiivity extends AppCompatActivity {

    private TextView tvMissatge;
    private EditText etMessage1;
    private Button btn_retorn;

    ActivityResultLauncher<Intent> arl_result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==74){
                        Intent intent = result.getData();

                        if(result.getData() != null){
                            String dadesMain = intent.getStringExtra("retorn");
                            tvMissatge.setText(dadesMain);
                        }
                    }
                }
            }
    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_actiivity);
        etMessage1 = findViewById(R.id.etMessage);
        btn_retorn = findViewById(R.id.button2);
        tvMissatge = findViewById(R.id.textView2);

        btn_retorn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("result", etMessage1.getText().toString());
                setResult(78, intent);
               ResultActiivity.super.onBackPressed();
            }
        });

    }

}