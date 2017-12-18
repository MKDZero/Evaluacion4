package cl.inacap.puntaarenas.evaluacion4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import cl.inacap.puntaarenas.evaluacion4.Modelo.Pedidos;

public class RevisarPedidosActivity extends AppCompatActivity {

    ListView lista;

    ArrayList<String> listainformacion;
    ArrayList<Pedidos> listapedidos;

    SQLiteOpenHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisar_pedidos);

       conn = new SQLiteOpenHelper(getApplicationContext(),"usuarios.db",null,1) {
           @Override
           public void onCreate(SQLiteDatabase sqLiteDatabase) {

           }

           @Override
           public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

           }
       };

        lista= (ListView) findViewById(R.id.lista);


       consultarlistaproductos();

       ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,listainformacion);
       lista.setAdapter(adaptador);



    }

    private void consultarlistaproductos() {
        SQLiteDatabase db= conn.getReadableDatabase();

        Pedidos pedido =null;
        listapedidos= new ArrayList<Pedidos>();

        Cursor cursor=db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME,null);

        while (cursor.moveToNext()){
            pedido=new Pedidos();
            pedido.setId(cursor.getString(0));
            pedido.setNombre_cliente(cursor.getString(1));
            pedido.setNombre_producto(cursor.getString(2));
            pedido.setDireccion(cursor.getString(3));
            pedido.setPrecio(cursor.getString(4));

            listapedidos.add(pedido);
        }

        obtenerLista();

    }

    private void obtenerLista() {
        listainformacion=new ArrayList<String>();

        for (int i=0; i<listapedidos.size();i++){
            listainformacion.add("- Numero ID: ["+listapedidos.get(i).getId()+ "] - Nombre del producto: ["+listapedidos.get(i).getNombre_cliente()+"] - Nombre del cliente: ["+listapedidos.get(i).getNombre_producto()+ "] - Direccion: ["+listapedidos.get(i).getDireccion()+"] - Precio: ["+listapedidos.get(i).getPrecio()+"]");

        }
    }
}