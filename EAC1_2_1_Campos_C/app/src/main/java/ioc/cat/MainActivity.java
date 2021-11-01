package ioc.cat;

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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSecondActivity;
    private TextView tvDadesRebudes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSecondActivity = findViewById(R.id.buttonSecondActivity);
        tvDadesRebudes = findViewById(R.id.tvDades);

        if (getIntent().getStringExtra("missatge") != null) {
            String missatgeRebut = getIntent().getStringExtra("missatge");
            tvDadesRebudes.setText(missatgeRebut);
        }else{
            tvDadesRebudes.setText("Sense missatges de Second Activity");
        }


        btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }


}