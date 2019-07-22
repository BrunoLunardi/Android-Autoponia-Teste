package br.com.livroandroid.autoponiateste;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ShareCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.livroandroid.autoponiateste.activity.SiteAutoponia;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RelativeLayout relCondutividade, relOxigenio, relPh, relTemperatura;
    TextView editCondutividade, editOxigenio, editPh, editTemperatura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        editCondutividade = (TextView) findViewById(R.id.editCondutividade);
        editOxigenio = (TextView) findViewById(R.id.editOxigenio);
        editPh = (TextView) findViewById(R.id.editPh);
        editTemperatura = (TextView) findViewById(R.id.editTemperatura);

        //Log.d("testeAqui", String.valueOf(editCondutividade.getText()));

        if(String.valueOf(editCondutividade.getText()).equals("0")){
            relCondutividade = (RelativeLayout) findViewById(R.id.relCondutividade);
            relCondutividade.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if(String.valueOf(editOxigenio.getText()).equals("0")){
            relOxigenio = (RelativeLayout) findViewById(R.id.relOxigenio);
            relOxigenio.setBackgroundColor(getResources().getColor(R.color.red));
            Toast.makeText(getApplicationContext(), "Problemas com o nível de oxigênio!", Toast.LENGTH_LONG).show();
        }
        if(String.valueOf(editPh.getText()).equals("0")){
            relPh = (RelativeLayout) findViewById(R.id.relPh);
            relPh.setBackgroundColor(getResources().getColor(R.color.red));
        }
        if(String.valueOf(editTemperatura.getText()).equals("0")){
            relTemperatura = (RelativeLayout) findViewById(R.id.relTemperatura);
            relTemperatura.setBackgroundColor(getResources().getColor(R.color.red));
        }

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Configurações do usuário", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.relatorios) {
            // Handle the camera action
            Toast.makeText(getApplicationContext(), "Abrir tela de relatórios", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            //Toast.makeText(getApplicationContext(), "Compartilhar", Toast.LENGTH_SHORT).show();

            String txt = "Teste app autoponia";
            //MimeType indica a forma como um conteúdo deve ser tratado
            String mimeType = "text/plain";

            //facilita o compartilhamento de dados entre seu app e outros, como whatsapp, facebook...
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("teste")
                    .setText(txt)
                    .startChooser();

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(this, SiteAutoponia.class);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "Site", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
