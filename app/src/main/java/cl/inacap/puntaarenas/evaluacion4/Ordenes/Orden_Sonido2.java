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

public class Orden_Sonido2 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_sonido2;
    TextView precio_sonido2;
    EditText nombre_cliente_sonido2;
    EditText direccion_sonido2;
    Button agregar_sonido2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__sonido2);

        ordenesdb = new DatabaseHelper(this);


        precio_sonido2 = (TextView) findViewById(R.id.precio_sonido2);
        producto_sonido2 = (TextView) findViewById(R.id.producto_sonido2);
        nombre_cliente_sonido2 = (EditText) findViewById(R.id.nombre_cliente_sonido2);
        direccion_sonido2 = (EditText) findViewById(R.id.direccion_sonido2);
        agregar_sonido2 = (Button) findViewById(R.id.agregar_sonido2);

        Añadir1();

    }




    public void Añadir1(){

        agregar_sonido2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_sonido_2 = producto_sonido2.getText().toString();
                String nombre_cliente_sonido_2 = nombre_cliente_sonido2.getText().toString();
                String direccion_sonido_2 = direccion_sonido2.getText().toString();
                String precio_sonido_2 = precio_sonido2.getText().toString();

                boolean insertData = ordenesdb.addData(producto_sonido_2, nombre_cliente_sonido_2, direccion_sonido_2, precio_sonido_2);


                if(insertData){
                    Toast.makeText(Orden_Sonido2.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Sonido2.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
