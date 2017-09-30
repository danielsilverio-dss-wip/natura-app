package br.com.fiap.natura.naturaapp.bean;

/**
 * Created by daniel on 08/09/17.
 */

public class ProdutoProjeto {

    private long id;

    private Produto produto;

    private int qtdArrecadado;

    private int qtdTotal;

    public ProdutoProjeto() {}

    public ProdutoProjeto(long id, Produto produto, int qtdArrecadado, int qtdTotal) {
        this.id = id;
        this.produto = produto;
        this.qtdArrecadado = qtdArrecadado;
        this.qtdTotal = qtdTotal;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdArrecadado() {
        return qtdArrecadado;
    }

    public void setQtdArrecadado(int qtdArrecadado) {
        this.qtdArrecadado = qtdArrecadado;
    }

    public int getQtdTotal() {
        return qtdTotal;
    }

    public void setQtdTotal(int qtdTotal) {
        this.qtdTotal = qtdTotal;
    }
}
