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

public class Orden_Monitor1 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_monitor1;
    TextView precio_monitor1;
    EditText nombre_cliente_monitor1;
    EditText direccion_monitor1;
    Button agregar_monitor1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__monitor1);

        ordenesdb = new DatabaseHelper(this);


        precio_monitor1 = (TextView) findViewById(R.id.precio_monitor1);
        producto_monitor1 = (TextView) findViewById(R.id.producto_monitor1);
        nombre_cliente_monitor1 = (EditText) findViewById(R.id.nombre_cliente_monitor1);
        direccion_monitor1 = (EditText) findViewById(R.id.direccion_monitor1);
        agregar_monitor1 = (Button) findViewById(R.id.agregar_monitor1);

        Añadir1();

    }




    public void Añadir1(){

        agregar_monitor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_monitor_1 = producto_monitor1.getText().toString();
                String nombre_cliente_monitor_1 = nombre_cliente_monitor1.getText().toString();
                String direccion_monitor_1 = direccion_monitor1.getText().toString();
                String precio_monitor_1 = precio_monitor1.getText().toString();

                boolean insertData = ordenesdb.addData(producto_monitor_1, nombre_cliente_monitor_1, direccion_monitor_1, precio_monitor_1);


                if(insertData){
                    Toast.makeText(Orden_Monitor1.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Monitor1.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
