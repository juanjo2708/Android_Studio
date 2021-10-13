package jjcamposc.ioc.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Primera Pantalla";
    private TextView tvCentral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCentral = findViewById(R.id.tvBenvinguda);
        tvCentral.setText("BENVINGUT/A A M8 JUAN JOSÉ CAMPOS");

        Log.i(TAG,"Soc Juan Jose Campos ");

    }
}