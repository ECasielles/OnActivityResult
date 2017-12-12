package com.example.usuario.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    private EditText edtMessage;
    private Button btnCancel, btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        edtMessage = findViewById(R.id.editText);
        btnCancel = findViewById(R.id.btnCancel);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.- Comprobar que no esté vacío
                if(!edtMessage.getText().toString().isEmpty()) {
                    //2.- Se añade el mensaje al intent
                    Intent intent = new Intent(SecondaryActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("message", edtMessage.getText().toString());
                    intent.putExtras(bundle);

                    //3.- Indicar que el reslutado ha sido correcto
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
            }
        });

    }
}
