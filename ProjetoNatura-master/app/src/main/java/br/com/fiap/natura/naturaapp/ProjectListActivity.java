package br.com.fiap.natura.naturaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.fiap.natura.naturaapp.adapter.ProjetosAdapter;
import br.com.fiap.natura.naturaapp.bean.Projeto;
import br.com.fiap.natura.naturaapp.simulacao.ListaProjetos;

public class ProjectListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvProjetos;
    private static List<Projeto> projetos; // lista temporariamente populada por criaProjetos()
    private ProjetosAdapter adpProjetos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_project_list);

        Log.i("ProjectListActivity",getApplicationContext().getPackageName());

        criaProjetos();


        for (Projeto projeto : projetos) {
            projeto.setImagem("projeto_criancas_musica");
            Log.i("Agora vai!!!!","nome: " + projeto.getNome() + "descricao:" + projeto.getDescricao() +
                    "imagem:" + projeto.getImagem());
        }

        lvProjetos = (ListView) findViewById(R.id.lvProjetos);
        adpProjetos = new ProjetosAdapter(projetos, this);
        lvProjetos.setAdapter(adpProjetos);
        lvProjetos.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Projeto projeto = (Projeto) adpProjetos.getItem(i);

        Intent intent = new Intent(this, ProjectActivity.class);
        intent.putExtra("id", projeto.getId());
        startActivity(intent);

    }

    private void criaProjetos() {
        ListaProjetos listaProjetos = new ListaProjetos();
        projetos = ListaProjetos.getProjetos();
    }

    public void voltar(View v){
        finish();
    }

}
