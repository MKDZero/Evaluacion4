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

public class Orden_Monitor2 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_monitor2;
    TextView precio_monitor2;
    EditText nombre_cliente_monitor2;
    EditText direccion_monitor2;
    Button agregar_monitor2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__monitor2);

        ordenesdb = new DatabaseHelper(this);


        precio_monitor2 = (TextView) findViewById(R.id.precio_monitor2);
        producto_monitor2 = (TextView) findViewById(R.id.producto_monitor2);
        nombre_cliente_monitor2 = (EditText) findViewById(R.id.nombre_cliente_monitor2);
        direccion_monitor2 = (EditText) findViewById(R.id.direccion_monitor2);
        agregar_monitor2 = (Button) findViewById(R.id.agregar_monitor2);

        Añadir1();

    }




    public void Añadir1(){

        agregar_monitor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_monitor_2 = producto_monitor2.getText().toString();
                String nombre_cliente_monitor_2 = nombre_cliente_monitor2.getText().toString();
                String direccion_monitor_2 = direccion_monitor2.getText().toString();
                String precio_monitor_2 = precio_monitor2.getText().toString();

                boolean insertData = ordenesdb.addData(producto_monitor_2, nombre_cliente_monitor_2, direccion_monitor_2, precio_monitor_2);


                if(insertData){
                    Toast.makeText(Orden_Monitor2.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Monitor2.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
