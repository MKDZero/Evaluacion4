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

public class Orden_PC3 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_pc3;
    TextView precio_pc3;
    EditText nombre_cliente_pc3;
    EditText direccion_pc3;
    Button agregar_pc3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__pc3);

        ordenesdb = new DatabaseHelper(this);


        precio_pc3 = (TextView) findViewById(R.id.precio_pc3);
        producto_pc3 = (TextView) findViewById(R.id.producto_pc3);
        nombre_cliente_pc3 = (EditText) findViewById(R.id.nombre_cliente_pc3);
        direccion_pc3 = (EditText) findViewById(R.id.direccion_pc3);
        agregar_pc3 = (Button) findViewById(R.id.agregar_pc3);

        Añadir3();

    }




    public void Añadir3(){

        agregar_pc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_pc_3 = producto_pc3.getText().toString();
                String nombre_cliente_pc_3 = nombre_cliente_pc3.getText().toString();
                String direccion_pc_3 = direccion_pc3.getText().toString();
                String precio_pc_3 = precio_pc3.getText().toString();

                boolean insertData = ordenesdb.addData(producto_pc_3, nombre_cliente_pc_3, direccion_pc_3, precio_pc_3);


                if(insertData){
                    Toast.makeText(Orden_PC3.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_PC3.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
