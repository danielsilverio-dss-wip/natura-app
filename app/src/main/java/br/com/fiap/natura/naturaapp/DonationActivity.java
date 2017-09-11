package br.com.fiap.natura.naturaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.adapter.ParceirosAdapter;
import br.com.fiap.natura.naturaapp.bean.Parceiro;
import br.com.fiap.natura.naturaapp.simulacao.ListaParceiros;

public class DonationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvParceiros;

    private ParceirosAdapter parceirosAdapter;

    private static List<Long> idsProdutos;
    private static List<Parceiro> parceiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        encontraViews();

        idsProdutos = recuperaListaDeIds();

        criaParceiros();

        parceirosAdapter = new ParceirosAdapter(parceiros, this);
        lvParceiros.setAdapter(parceirosAdapter);
        lvParceiros.setOnItemClickListener(this);


    }

    private void criaParceiros() {
        parceiros = new ArrayList<Parceiro>();
        ListaParceiros listaParceiros = new ListaParceiros();
        parceiros = ListaParceiros.getParceiros();
    }

    private void encontraViews() {
        lvParceiros = (ListView) findViewById(R.id.lvParceiros);
    }

    private List<Long> recuperaListaDeIds() {
        Bundle bundle = getIntent().getExtras();
        long[] projectId = bundle.getLongArray("idsProdutosSelecionados");

        List<Long> ids = new ArrayList<Long>();

        for (int i = 0; i < projectId.length; i++){
            ids.add(projectId[i]);
        }
        return ids;
    }

    public void voltar(View v){
        //Intent i = new Intent(this, ProjectActivity.class);
        //startActivity(i);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SucessfulActivity.class);
        startActivity(intent);
    }
}
