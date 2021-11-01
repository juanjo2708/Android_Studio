package jjcamposc.ioc.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE ="com.example.android.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.edit_text_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(SecondActivity.EXTRA_MESSAGE_RET);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);


    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button is clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}