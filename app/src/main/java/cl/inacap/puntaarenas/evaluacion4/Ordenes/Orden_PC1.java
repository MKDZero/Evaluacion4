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

public class Orden_PC1 extends AppCompatActivity {

    DatabaseHelper ordenesdb;

    TextView producto_pc1;
    TextView precio_pc1;
    EditText nombre_cliente_pc1;
    EditText direccion_pc1;
    Button agregar_pc1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orden__pc1);

        ordenesdb = new DatabaseHelper(this);


        precio_pc1 = (TextView) findViewById(R.id.precio_pc1);
        producto_pc1 = (TextView) findViewById(R.id.producto_pc1);
        nombre_cliente_pc1 = (EditText) findViewById(R.id.nombre_cliente_pc1);
        direccion_pc1 = (EditText) findViewById(R.id.direccion_pc1);
        agregar_pc1 = (Button) findViewById(R.id.agregar_pc1);

    Añadir1();

    }




    public void Añadir1(){

        agregar_pc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String producto_pc_1 = producto_pc1.getText().toString();
                String nombre_cliente_pc_1 = nombre_cliente_pc1.getText().toString();
                String direccion_pc_1 = direccion_pc1.getText().toString();
                String precio_pc_1 = precio_pc1.getText().toString();

                boolean insertData = ordenesdb.addData(producto_pc_1, nombre_cliente_pc_1, direccion_pc_1, precio_pc_1);


                if(insertData){
                    Toast.makeText(Orden_PC1.this, "Orden Agregada", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(Orden_PC1.this, "Ocurrio un error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }



}
