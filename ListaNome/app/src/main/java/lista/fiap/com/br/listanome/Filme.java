package lista.fiap.com.br.listanome;

/**
 * Created by WaldemirGomesDeAndra on 29/09/2017.
 */

public class Filme {

    private String nome;
    private String descricao;
    private int Imagem;


    public Filme(String nome, String descricao, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        Imagem = imagem;
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

    public int getImagem() {

        return Imagem;
    }

    public void setImagem(int imagem) {
        Imagem = imagem;
    }



    public void convertImagem(byte[] b){





    }

}
