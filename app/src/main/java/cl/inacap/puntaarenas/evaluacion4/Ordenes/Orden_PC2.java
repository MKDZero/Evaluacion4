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

public class Orden_PC2 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_pc2;
    TextView precio_pc2;
    EditText nombre_cliente_pc2;
    EditText direccion_pc2;
    Button agregar_pc2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__pc2);

        ordenesdb = new DatabaseHelper(this);


        precio_pc2 = (TextView) findViewById(R.id.precio_pc2);
        producto_pc2 = (TextView) findViewById(R.id.producto_pc2);
        nombre_cliente_pc2 = (EditText) findViewById(R.id.nombre_cliente_pc2);
        direccion_pc2 = (EditText) findViewById(R.id.direccion_pc2);
        agregar_pc2 = (Button) findViewById(R.id.agregar_pc2);

        Añadir2();

    }




    public void Añadir2(){

        agregar_pc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_pc_2 = producto_pc2.getText().toString();
                String nombre_cliente_pc_2 = nombre_cliente_pc2.getText().toString();
                String direccion_pc_2 = direccion_pc2.getText().toString();
                String precio_pc_2 = precio_pc2.getText().toString();

                boolean insertData = ordenesdb.addData(producto_pc_2, nombre_cliente_pc_2, direccion_pc_2, precio_pc_2);


                if(insertData){
                    Toast.makeText(Orden_PC2.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_PC2.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
