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

public class Orden_Sonido1 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_sonido1;
    TextView precio_sonido1;
    EditText nombre_cliente_sonido1;
    EditText direccion_sonido1;
    Button agregar_sonido1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__sonido1);

        ordenesdb = new DatabaseHelper(this);


        precio_sonido1 = (TextView) findViewById(R.id.precio_sonido1);
        producto_sonido1 = (TextView) findViewById(R.id.producto_sonido1);
        nombre_cliente_sonido1 = (EditText) findViewById(R.id.nombre_cliente_sonido1);
        direccion_sonido1 = (EditText) findViewById(R.id.direccion_sonido1);
        agregar_sonido1 = (Button) findViewById(R.id.agregar_sonido1);

        Añadir1();

    }




    public void Añadir1(){

        agregar_sonido1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_sonido_1 = producto_sonido1.getText().toString();
                String nombre_cliente_sonido_1 = nombre_cliente_sonido1.getText().toString();
                String direccion_sonido_1 = direccion_sonido1.getText().toString();
                String precio_sonido_1 = precio_sonido1.getText().toString();

                boolean insertData = ordenesdb.addData(producto_sonido_1, nombre_cliente_sonido_1, direccion_sonido_1, precio_sonido_1);


                if(insertData){
                    Toast.makeText(Orden_Sonido1.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Sonido1.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
