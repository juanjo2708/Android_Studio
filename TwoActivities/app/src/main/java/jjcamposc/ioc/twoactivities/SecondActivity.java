package jjcamposc.ioc.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_RET ="com.example.android.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        mMessageEditText = findViewById(R.id.edit_text_second);


    }

    public void launchSecondMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_RET,message);
        startActivity(intent);

    }
}