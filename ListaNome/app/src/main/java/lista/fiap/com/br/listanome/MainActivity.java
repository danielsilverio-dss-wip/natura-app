package lista.fiap.com.br.listanome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lvFilmes);
        ArrayList<Filme> filmes = adicionarFilmes();
        ArrayAdapter adapter = new FilmeAdapter(this, filmes);
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

            }
        });


    }


    private ArrayList<Filme> adicionarFilmes() {

        ArrayList<Filme> filmes = new ArrayList<Filme>();

        Filme e = new Filme("Procurando nemo", "filmes de criança muito bom ", R.drawable.nemo);
        filmes.add(e);
        e = new Filme("Transformers 5",
                "Ação, autobots", R.drawable.transformers);
        filmes.add(e);
        e = new Filme("Piratas do caribe",
                "A vinganla de salazar", R.drawable.salazar);
        filmes.add(e);

        return filmes;
    }

}

