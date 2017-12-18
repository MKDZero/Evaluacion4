package cl.inacap.puntaarenas.evaluacion4.Sucursales;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.inacap.puntaarenas.evaluacion4.Mapa.MapaActivity;
import cl.inacap.puntaarenas.evaluacion4.Mapa.MapaActivity2;
import cl.inacap.puntaarenas.evaluacion4.Mapa.MapaActivity3;
import cl.inacap.puntaarenas.evaluacion4.R;

public class SucursalActivity extends AppCompatActivity {

    Button botonpuq;
    Button buttonstgo;
    Button buttonpuerto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucursal);

        botonpuq = (Button) findViewById(R.id.buttonpuq);
        buttonpuerto = (Button) findViewById(R.id.buttonpuerto);
        buttonstgo = (Button) findViewById(R.id.buttonstgo);

        botonpuq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent botonpuq=new Intent(SucursalActivity.this, MapaActivity.class);
                startActivity(botonpuq);
            }
        });
        buttonstgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonstgo=new Intent(SucursalActivity.this, MapaActivity2.class);
                startActivity(botonstgo);
            }
        });
        buttonpuerto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent botonpuerto= new Intent(SucursalActivity.this, MapaActivity3.class);
                startActivity(botonpuerto);
            }
        });

    }
}
