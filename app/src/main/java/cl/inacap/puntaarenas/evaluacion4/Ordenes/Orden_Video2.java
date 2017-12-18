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

public class Orden_Video2 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_video2;
    TextView precio_video2;
    EditText nombre_cliente_video2;
    EditText direccion_video2;
    Button agregar_video2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__video2);

        ordenesdb = new DatabaseHelper(this);


        precio_video2 = (TextView) findViewById(R.id.precio_video2);
        producto_video2 = (TextView) findViewById(R.id.producto_video2);
        nombre_cliente_video2 = (EditText) findViewById(R.id.nombre_cliente_video2);
        direccion_video2 = (EditText) findViewById(R.id.direccion_video2);
        agregar_video2 = (Button) findViewById(R.id.agregar_video2);

        Añadir1();

    }




    public void Añadir1(){

        agregar_video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_video_2 = producto_video2.getText().toString();
                String nombre_cliente_video_2 = nombre_cliente_video2.getText().toString();
                String direccion_video_2 = direccion_video2.getText().toString();
                String precio_video_2 = precio_video2.getText().toString();

                boolean insertData = ordenesdb.addData(producto_video_2, nombre_cliente_video_2, direccion_video_2, precio_video_2);


                if(insertData){
                    Toast.makeText(Orden_Video2.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Video2.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
