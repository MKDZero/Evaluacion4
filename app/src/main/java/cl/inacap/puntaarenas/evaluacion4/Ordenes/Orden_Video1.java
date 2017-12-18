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

public class Orden_Video1 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_video1;
    TextView precio_video1;
    EditText nombre_cliente_video1;
    EditText direccion_video1;
    Button agregar_video1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__video1);

        ordenesdb = new DatabaseHelper(this);


        precio_video1 = (TextView) findViewById(R.id.precio_video1);
        producto_video1 = (TextView) findViewById(R.id.producto_video1);
        nombre_cliente_video1 = (EditText) findViewById(R.id.nombre_cliente_video1);
        direccion_video1 = (EditText) findViewById(R.id.direccion_video1);
        agregar_video1 = (Button) findViewById(R.id.agregar_video1);

        Añadir1();

    }




    public void Añadir1(){

        agregar_video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_video_1 = producto_video1.getText().toString();
                String nombre_cliente_video_1 = nombre_cliente_video1.getText().toString();
                String direccion_video_1 = direccion_video1.getText().toString();
                String precio_video_1 = precio_video1.getText().toString();

                boolean insertData = ordenesdb.addData(producto_video_1, nombre_cliente_video_1, direccion_video_1, precio_video_1);


                if(insertData){
                    Toast.makeText(Orden_Video1.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Video1.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
