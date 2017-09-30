package br.com.fiap.natura.naturaapp.simulacao;


import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.bean.Projeto;
import br.com.fiap.natura.naturaapp.repository.Iprojeto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by daniel on 08/09/17.
 */

public class ListaProjetos {

    private static List<Projeto> projetos;

    public ListaProjetos() {
        criaProjetos(); // cria uma lista fictícia de projetos ao chamar o contrutor
    }

    public static List<Projeto> getProjetos() {
        return projetos;
    }

    public static void setProjetos(List<Projeto> projetos) {
        ListaProjetos.projetos = projetos;
    }

    public static Projeto buscaPorId(long id){

        if(projetos == null){
            criaProjetos();
        }

        Projeto p = new Projeto();
        for (Projeto projeto : projetos) {
            if(projeto.getId() == id){
                return projeto;
            }
            p = projeto;
        }
        return p;
    }

    private static void criaProjetos(){

        projetos = new ArrayList<Projeto>();

        Iprojeto iprojeto = Iprojeto.retrofit.create(Iprojeto.class);

        final Call<List<Projeto>> call = iprojeto.getProjetos();

        //
        call.enqueue(new Callback<List<Projeto>>(){

            @Override
            public void onResponse(Call<List<Projeto>> call, Response<List<Projeto>> response) {
                projetos = response.body();

                Log.i("deu certo", "projeto: " + projetos.get(0).getNome());
                Log.e("deu certo", "sua mae viado");
            }

            @Override
            public void onFailure(Call<List<Projeto>> call, Throwable t) {
                //Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();
                Log.e("deu onfalue", "sua mae viado");
            }



        });


        /*
        projetos.add(new Projeto(0, "Crianças da Musica",   "descricao", "projeto_criancas_musica"));
        projetos.add(new Projeto(1, "Beleza e Autoestima",  "descricao", "projeto_embelezamento"));
        projetos.add(new Projeto(2, "Sopão Solidário",      "descricao", "projeto_sopao_solidario"));
        projetos.add(new Projeto(3, "Cabeleza",             "descricao", "projeto_corte_cabelo"));
        projetos.add(new Projeto(4, "Caderno na mão",       "descricao", "projeto_caderno_na_mao"));
        projetos.add(new Projeto(5, "Páscoa Feliz",         "descricao", "img_projeto1"));
        projetos.add(new Projeto(6, "Arte Jovem",           "descricao", "img_projeto2"));
        projetos.add(new Projeto(7, "Violonantes",          "descricao", "img_projeto3"));
        projetos.add(new Projeto(8, "Criança Feliz",        "descricao", "projeto_projeto_criancas"));
        projetos.add(new Projeto(9, "Escola das Crianças",  "descricao", "projeto_construcao_escola"));
        */

    }
}
