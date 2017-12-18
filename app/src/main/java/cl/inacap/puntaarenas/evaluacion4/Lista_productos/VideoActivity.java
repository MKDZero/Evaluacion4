package cl.inacap.puntaarenas.evaluacion4.Lista_productos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Video1;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Video2;
import cl.inacap.puntaarenas.evaluacion4.Ordenes.Orden_Video3;
import cl.inacap.puntaarenas.evaluacion4.R;

public class VideoActivity extends AppCompatActivity {

    Button btn_video1,btn_video2,btn_video3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        btn_video1 = (Button) findViewById(R.id.btn_video1);
        btn_video2 = (Button) findViewById(R.id.btn_video2);
        btn_video3 = (Button) findViewById(R.id.btn_video3);

        btn_video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent video1 = new Intent(VideoActivity.this, Orden_Video1.class);
                VideoActivity.this.startActivity(video1);
            }
        });
        btn_video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent video2 = new Intent(VideoActivity.this, Orden_Video2.class);
                VideoActivity.this.startActivity(video2);
            }
        });

        btn_video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent video3 = new Intent(VideoActivity.this, Orden_Video3.class);
                VideoActivity.this.startActivity(video3);
            }
        });
    }
}
