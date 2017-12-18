package cl.inacap.puntaarenas.evaluacion4.Ordenes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.inacap.puntaarenas.evaluacion4.DatabaseHelper;
import cl.inacap.puntaarenas.evaluacion4.R;

public class Orden_Monitor3 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_monitor3;
    TextView precio_monitor3;
    EditText nombre_cliente_monitor3;
    EditText direccion_monitor3;
    Button agregar_monitor3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__monitor3);

        ordenesdb = new DatabaseHelper(this);


        precio_monitor3 = (TextView) findViewById(R.id.precio_monitor3);
        producto_monitor3 = (TextView) findViewById(R.id.producto_monitor3);
        nombre_cliente_monitor3 = (EditText) findViewById(R.id.nombre_cliente_monitor3);
        direccion_monitor3 = (EditText) findViewById(R.id.direccion_monitor3);
        agregar_monitor3 = (Button) findViewById(R.id.agregar_monitor3);

        Añadir1();

    }




    public void Añadir1(){

        agregar_monitor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_monitor_3 = producto_monitor3.getText().toString();
                String nombre_cliente_monitor_3 = nombre_cliente_monitor3.getText().toString();
                String direccion_monitor_3 = direccion_monitor3.getText().toString();
                String precio_monitor_3 = precio_monitor3.getText().toString();

                boolean insertData = ordenesdb.addData(producto_monitor_3, nombre_cliente_monitor_3, direccion_monitor_3, precio_monitor_3);


                if(insertData){
                    Toast.makeText(Orden_Monitor3.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Monitor3.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
