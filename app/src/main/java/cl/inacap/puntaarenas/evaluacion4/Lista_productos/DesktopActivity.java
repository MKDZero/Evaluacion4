package cl.inacap.puntaarenas.evaluacion4.Lista_productos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_PC1;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_PC2;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_PC3;
import cl.inacap.puntaarenas.evaluacion4.R;

public class DesktopActivity extends AppCompatActivity {

    Button btn_pc1,btn_pc2,btn_pc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        btn_pc1 = (Button) findViewById(R.id.btn_pc1);
        btn_pc2 = (Button) findViewById(R.id.btn_pc2);
        btn_pc3 = (Button) findViewById(R.id.btn_pc3);

        btn_pc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pc1 = new Intent(DesktopActivity.this, Orden_PC1.class);
                DesktopActivity.this.startActivity(pc1);
            }
        });
        btn_pc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pc2 = new Intent(DesktopActivity.this, Orden_PC2.class);
                DesktopActivity.this.startActivity(pc2);
            }
        });

        btn_pc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pc3 = new Intent(DesktopActivity.this, Orden_PC3.class);
                DesktopActivity.this.startActivity(pc3);
            }
        });
    }
}
