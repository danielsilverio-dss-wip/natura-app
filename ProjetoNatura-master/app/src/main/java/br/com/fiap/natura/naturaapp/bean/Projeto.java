package br.com.fiap.natura.naturaapp.bean;

/**
 * Created by daniel on 08/09/17.
 */

public class Projeto {

    private long id;
    private String nome;
    private String descricao;
    private String imagem;
    //private Ong ong;
    //private List<ProdutosPorProjeto> produtosPorProjeto;
    //private List<Compra> compras;

    public Projeto(){}

    public Projeto(long id, String nome, String descricao, String imagem) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    /*
        public Projeto(long id, String nome, String descricao, Ong ong, List<ProdutosPorProjeto> produtosPorProjeto) {
            super();
            this.id = id;
            this.nome = nome;
            this.descricao = descricao;
            this.ong = ong;
            this.produtosPorProjeto = produtosPorProjeto;
        }
        */
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }
    /*
    public Ong getOng() {
        return ong;
    }
    public void setOng(Ong ong) {
        this.ong = ong;
    }
    public List<ProdutosPorProjeto> getProdutosPorProjeto() {
        return produtosPorProjeto;
    }
    public void setProdutosPorProjeto(List<ProdutosPorProjeto> produtosPorProjeto) {
        this.produtosPorProjeto = produtosPorProjeto;
    }
    */
}
