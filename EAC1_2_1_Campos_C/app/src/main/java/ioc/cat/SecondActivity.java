package ioc.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button webIocBtn;
    private Button callBtn;
    private Button shareAppBtn;
    private Button shareMainBtn;
    private EditText etMessageShare;
    private EditText etMessageToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        webIocBtn = findViewById(R.id.webIoc);
        callBtn = findViewById(R.id.buttonCall);
        shareAppBtn = findViewById(R.id.buttonShareApp);
        etMessageShare = findViewById(R.id.etCompartirApp);
        shareMainBtn = findViewById(R.id.buttonShareMain);
        etMessageToMain = findViewById(R.id.etCompartirMain);

        webIocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ioc.xtec.cat/educacio/"));
               SecondActivity.this.startActivity(browserIntent);
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:112"));
                SecondActivity.this.startActivity(callIntent);
            }
        });

        shareAppBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, etMessageShare.getText().toString());
                shareIntent.setType("text/plain");

                Intent sendIntent = Intent.createChooser(shareIntent, null);
                SecondActivity.this.startActivity(sendIntent);
            }
        });

        shareMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(SecondActivity.this,MainActivity.class);
                mainIntent.putExtra("missatge", etMessageToMain.getText().toString());
                SecondActivity.this.startActivity(mainIntent);
                startActivity(mainIntent);
                //finish();
            }
        });



    }
}