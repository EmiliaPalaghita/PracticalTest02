package ro.pub.cs.systems.eim.practicaltest02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest02MainActivity extends AppCompatActivity {

    EditText serverPortEditText;
    Button serverButton;
    EditText clientPortEditText;
    EditText requestedUrlEditText;
    Button clientButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test02_main);

        serverPortEditText = findViewById(R.id.server_port_et);
        serverButton = findViewById(R.id.server_connect_btn);
        clientPortEditText = findViewById(R.id.client_port_et);
        requestedUrlEditText = findViewById(R.id.url_requested_et);
        clientButton = findViewById(R.id.client_connect_btn);
        resultTextView = findViewById(R.id.result_tv);

        serverButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on serverButton", Toast.LENGTH_SHORT).show();
            }
        });

        clientButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Clicked on clientButton", Toast.LENGTH_SHORT).show();
            }
        });
    }
}