package br.com.fiap.natura.naturaapp.simulacao;


import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.bean.Projeto;

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

    }
}
