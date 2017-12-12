package com.example.usuario.onactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txvMessageSurname, txvMessageName;
    private Button btnName, btnSurname;

    private final static int NAME = 0;
    private final static int SURNAME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvMessageName = findViewById(R.id.txvMessageName);
        txvMessageSurname = findViewById(R.id.txvMessageSurname);
        btnName = findViewById(R.id.btnName);
        btnSurname = findViewById(R.id.btnSurname);
    }

    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, SecondaryActivity.class);
        switch (view.getId()){
            case R.id.btnName:
                startActivityForResult(intent, MainActivity.NAME);
                break;
            case R.id.btnSurname:
                startActivityForResult(intent, MainActivity.SURNAME);
                break;
        }
    }

    /**
     * Se trata de un método Callback que será llamado cuando SecondaryActivity finalice
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //1.- Se comprueba el código de la petición
        switch (requestCode){
            case NAME:
                //2.- Se comprueba el resultado
                if(resultCode == RESULT_OK)
                    txvMessageName.setText(data.getExtras().getString("message"));
                break;
            case SURNAME:
                if(resultCode == RESULT_OK)
                    txvMessageSurname.setText(data.getExtras().getString("message"));
                break;
        }

    }

}
