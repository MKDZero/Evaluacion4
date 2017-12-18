package cl.inacap.puntaarenas.evaluacion4;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import cl.inacap.puntaarenas.evaluacion4.Lista_productos.DesktopActivity;
import cl.inacap.puntaarenas.evaluacion4.Lista_productos.MonitoresActivity;
import cl.inacap.puntaarenas.evaluacion4.Lista_productos.SonidoActivity;
import cl.inacap.puntaarenas.evaluacion4.Lista_productos.VideoActivity;
import cl.inacap.puntaarenas.evaluacion4.Sucursales.SucursalActivity;

public class DesplegableActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView btnvideo;
    ImageView btnsonido;
    ImageView btndesktop;
    ImageView btnmonitores;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegable);

        btnvideo = (ImageView) findViewById(R.id.btnvideo);
        btnsonido = (ImageView) findViewById(R.id.btnsonido);
        btndesktop = (ImageView) findViewById(R.id.btndesktop);
        btnmonitores = (ImageView) findViewById(R.id.btnmonitores);

        btndesktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent desktop = new Intent(DesplegableActivity.this, DesktopActivity.class);
                DesplegableActivity.this.startActivity(desktop);
            }
        });
        btnmonitores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent monitores = new Intent(DesplegableActivity.this, MonitoresActivity.class);
                DesplegableActivity.this.startActivity(monitores);
            }
        });
        btnsonido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sonido = new Intent(DesplegableActivity.this, SonidoActivity.class);
                DesplegableActivity.this.startActivity(sonido);
            }
        });
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent video = new Intent(DesplegableActivity.this, VideoActivity.class);
                DesplegableActivity.this.startActivity(video);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.desplegable, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_revisar) {
            Intent intent1 = new Intent(this, UsersListActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent1.putExtra("ver pedidos", true);
            startActivity(intent1);

        } else if (id == R.id.nav_sesion) {
            Intent intent2 = new Intent(this, LoginActivity.class);
            intent2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent2.putExtra("Exit me", true);
            startActivity(intent2);
            finish();

        } else if (id == R.id.nav_sucursal){
            Intent intent3 = new Intent(DesplegableActivity.this, SucursalActivity.class);
            intent3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent3.putExtra("Revisar sucursales", true);
            startActivity(intent3);
            finish();
        } else if (id == R.id.nav_revpedido){
            Intent intent4 = new Intent(DesplegableActivity.this, RevisarPedidosActivity.class);
            intent4.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent4.putExtra("Revisar pedidos", true);
            startActivity(intent4);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
