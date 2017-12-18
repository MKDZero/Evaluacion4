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

public class Orden_Sonido3 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_sonido3;
    TextView precio_sonido3;
    EditText nombre_cliente_sonido3;
    EditText direccion_sonido3;
    Button agregar_sonido3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__sonido3);

        ordenesdb = new DatabaseHelper(this);


        precio_sonido3 = (TextView) findViewById(R.id.precio_sonido3);
        producto_sonido3 = (TextView) findViewById(R.id.producto_sonido3);
        nombre_cliente_sonido3 = (EditText) findViewById(R.id.nombre_cliente_sonido3);
        direccion_sonido3 = (EditText) findViewById(R.id.direccion_sonido3);
        agregar_sonido3 = (Button) findViewById(R.id.agregar_sonido3);

        Añadir1();

    }




    public void Añadir1(){

        agregar_sonido3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_sonido_3 = producto_sonido3.getText().toString();
                String nombre_cliente_sonido_3 = nombre_cliente_sonido3.getText().toString();
                String direccion_sonido_3 = direccion_sonido3.getText().toString();
                String precio_sonido_3 = precio_sonido3.getText().toString();

                boolean insertData = ordenesdb.addData(producto_sonido_3, nombre_cliente_sonido_3, direccion_sonido_3, precio_sonido_3);


                if(insertData){
                    Toast.makeText(Orden_Sonido3.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Sonido3.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
