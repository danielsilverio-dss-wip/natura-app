package br.com.fiap.natura.naturaapp.simulacao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.natura.naturaapp.bean.Produto;
import br.com.fiap.natura.naturaapp.bean.ProdutoProjeto;

/**
 * Created by daniel on 08/09/17.
 */

public class ListaProdutosProjeto {


    private static List<ProdutoProjeto> produtosProjeto;

    public ListaProdutosProjeto() {
        criaProdutosProjeto(); // cria uma lista fictícia de projetos ao chamar o contrutor
    }

    public static List<ProdutoProjeto> getProdutosProjeto() {
        return produtosProjeto;
    }

    public static void setProdutosProjeto(List<ProdutoProjeto> produtosProjeto) {
        ListaProdutosProjeto.produtosProjeto = produtosProjeto;
    }

    public static ProdutoProjeto buscaPorId(long id){

        for (ProdutoProjeto produtoProjeto : produtosProjeto) {
            if(produtoProjeto.getId() == id){
                return  produtoProjeto;
            }
        }
        return null;
    }

    private static void criaProdutosProjeto(){
        produtosProjeto = new ArrayList<ProdutoProjeto>();

        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(new Produto(0, "Arroz"));
        produtos.add(new Produto(1, "Feijão"));
        produtos.add(new Produto(2, "Caderno"));
        produtos.add(new Produto(3, "Shampoo"));
        produtos.add(new Produto(4, "Creme de barbear"));
        produtos.add(new Produto(5, "Maquiagem"));
        produtos.add(new Produto(6, "Ervilhas"));
        produtos.add(new Produto(7, "Papel de Origami"));

        // gerando valores ficticios
        for (int i = 0; i < 7; i++){
            produtosProjeto.add(new ProdutoProjeto(
                    i,
                    produtos.get(i),
                    10+i,
                    20+i));
        }
    }
}
