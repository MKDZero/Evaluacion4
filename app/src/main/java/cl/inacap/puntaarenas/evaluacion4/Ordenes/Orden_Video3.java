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

public class Orden_Video3 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_video3;
    TextView precio_video3;
    EditText nombre_cliente_video3;
    EditText direccion_video3;
    Button agregar_video3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__video3);

        ordenesdb = new DatabaseHelper(this);


        precio_video3 = (TextView) findViewById(R.id.precio_video3);
        producto_video3 = (TextView) findViewById(R.id.producto_video3);
        nombre_cliente_video3 = (EditText) findViewById(R.id.nombre_cliente_video3);
        direccion_video3 = (EditText) findViewById(R.id.direccion_video3);
        agregar_video3 = (Button) findViewById(R.id.agregar_video3);

        Añadir1();

    }




    public void Añadir1(){

        agregar_video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_video_3 = producto_video3.getText().toString();
                String nombre_cliente_video_3 = nombre_cliente_video3.getText().toString();
                String direccion_video_3 = direccion_video3.getText().toString();
                String precio_video_3 = precio_video3.getText().toString();

                boolean insertData = ordenesdb.addData(producto_video_3, nombre_cliente_video_3, direccion_video_3, precio_video_3);


                if(insertData){
                    Toast.makeText(Orden_Video3.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_Video3.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
