package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Enviar = (Button)findViewById(R.id.btnenviar);
        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(MainActivity.this,Manifest
                .permission.SEND_SMS)!=PackageManager.PERMISSION_GRANTED){ActivityCompat.requestPermissions(MainActivity.this,new String[]
                { Manifest.permission.SEND_SMS,},1000);
        }else{

        };
        Enviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                enviarMensaje("71604244","Hola Soy ANDROFAST te estoy enviando un Mensaje");


            }
        });
    }
    private void enviarMensaje (String numero, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,mensaje,null,null);
            Toast.makeText(getApplicationContext(), "Mensaje Enviado.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, datos incorrectos.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}