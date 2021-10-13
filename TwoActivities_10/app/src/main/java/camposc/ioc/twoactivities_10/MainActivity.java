package camposc.ioc.twoactivities_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                startActivityForResult(intentMainReturn, MISSATGE_RETORNAT);
            }
        });



    }
}