package br.com.fiap.natura.naturaapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.adapter.ProdutosProjetoAdapter;
import br.com.fiap.natura.naturaapp.bean.ProdutoProjeto;
import br.com.fiap.natura.naturaapp.bean.Projeto;
import br.com.fiap.natura.naturaapp.simulacao.ListaProdutosProjeto;
import br.com.fiap.natura.naturaapp.simulacao.ListaProjetos;

public class ProjectActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private TextView txtNomeProjeto;
    private TextView txtDescricaoProjeto;
    private ImageView imgProjeto;
    private ListView lvProdutos;

    private static List<Projeto> projetos;
    private static List<ProdutoProjeto> produtosProjeto;
    private static List<Long> idsProdutosSelecionados;

    private ProdutosProjetoAdapter produtosProjetoAdapter;

    private Projeto projeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_project);

        Log.i("TesteOnItemClick","Agora vai!");

        encontraViews();

        buscaProjetoEscolhido();

        criaProdutosProjeto();

        idsProdutosSelecionados = new ArrayList<Long>();

        produtosProjetoAdapter = new ProdutosProjetoAdapter(produtosProjeto, this);
        lvProdutos.setAdapter(produtosProjetoAdapter);
        lvProdutos.setOnItemClickListener(this);

        setaValoresNasViews();
    }

    private void buscaProjetoEscolhido() {
        Bundle bundle = getIntent().getExtras();

        long projectId = 1;
        if(getIntent().hasExtra("id")){
            projectId = bundle.getLong("id");
        }

        projeto = ListaProjetos.buscaPorId(projectId);
    }


    private void encontraViews() {
        txtNomeProjeto = (TextView) findViewById(R.id.txtNomeProjeto);
        txtDescricaoProjeto = (TextView) findViewById(R.id.txtDescricaoProjeto);
        imgProjeto = (ImageView) findViewById(R.id.imgProjeto);
        lvProdutos = (ListView) findViewById(R.id.lvProdutos);
    }

    private void setaValoresNasViews() {
        txtNomeProjeto.setText(projeto.getNome());

        int identifier = this.getResources().getIdentifier(projeto.getImagem(),"drawable",this.getPackageName());
        Drawable resource = this.getDrawable(identifier);
        imgProjeto.setImageDrawable(resource);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Log.i("TesteOnItemClick","Agora vai!");
        ProdutoProjeto produtoProjeto = (ProdutoProjeto) produtosProjetoAdapter.getItem(i);

        idsProdutosSelecionados.add(produtoProjeto.getId());

    }

    public void voltar(View v){
        finish();
    }

    private void criaProdutosProjeto() {
        ListaProdutosProjeto produtos = new ListaProdutosProjeto();
        produtosProjeto = ListaProdutosProjeto.getProdutosProjeto();
    }

    public void doar(View v){
        Intent i = new Intent(this, DonationActivity.class);

        long [] idsProdutosArray = longListToArray(idsProdutosSelecionados);
        i.putExtra("idsProdutosSelecionados", idsProdutosArray);

        startActivity(i);
    }

    private long[] longListToArray(List<Long> longList) {

        long[] array = new long[longList.size()];
        int i = 0;
        for (Long valor : longList) {
            array[i++] = valor;
        }

        return array;

    }


}
