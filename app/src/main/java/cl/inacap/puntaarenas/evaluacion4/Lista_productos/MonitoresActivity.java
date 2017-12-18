package cl.inacap.puntaarenas.evaluacion4.Lista_productos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Monitor1;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Monitor2;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Monitor3;
import cl.inacap.puntaarenas.evaluacion4.R;

public class MonitoresActivity extends AppCompatActivity {

    Button btn_monitor1,btn_monitor2,btn_monitor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitores);

        btn_monitor1 = (Button) findViewById(R.id.btn_monitor1);
        btn_monitor2 = (Button) findViewById(R.id.btn_monitor2);
        btn_monitor3 = (Button) findViewById(R.id.btn_monitor3);

        btn_monitor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monitor1 = new Intent(MonitoresActivity.this, Orden_Monitor1.class);
                MonitoresActivity.this.startActivity(monitor1);
            }
        });
        btn_monitor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monitor2 = new Intent(MonitoresActivity.this, Orden_Monitor2.class);
                MonitoresActivity.this.startActivity(monitor2);
            }
        });

        btn_monitor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monitor3 = new Intent(MonitoresActivity.this, Orden_Monitor3.class);
                MonitoresActivity.this.startActivity(monitor3);
            }
        });
    }
}
