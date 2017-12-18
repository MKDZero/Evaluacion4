package cl.inacap.puntaarenas.evaluacion4.Lista_productos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Sonido1;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Sonido2;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Sonido3;
import cl.inacap.puntaarenas.evaluacion4.R;

public class SonidoActivity extends AppCompatActivity {

    Button btn_sonido1,btn_sonido2,btn_sonido3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);

        btn_sonido1 = (Button) findViewById(R.id.btn_sonido1);
        btn_sonido2 = (Button) findViewById(R.id.btn_sonido2);
        btn_sonido3 = (Button) findViewById(R.id.btn_sonido3);

        btn_sonido1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sonido1 = new Intent(SonidoActivity.this, Orden_Sonido1.class);
                SonidoActivity.this.startActivity(sonido1);
            }
        });
        btn_sonido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sonido2 = new Intent(SonidoActivity.this, Orden_Sonido2.class);
                SonidoActivity.this.startActivity(sonido2);
            }
        });

        btn_sonido3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sonido3 = new Intent(SonidoActivity.this, Orden_Sonido3.class);
                SonidoActivity.this.startActivity(sonido3);
            }
        });
    }
}
