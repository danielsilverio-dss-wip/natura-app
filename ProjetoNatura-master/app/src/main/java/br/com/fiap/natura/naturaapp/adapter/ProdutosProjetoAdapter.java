package br.com.fiap.natura.naturaapp.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.fiap.natura.naturaapp.R;
import br.com.fiap.natura.naturaapp.bean.ProdutoProjeto;

/**
 * Created by daniel on 08/09/17.
 */

public class ProdutosProjetoAdapter extends BaseAdapter {

    private final List<ProdutoProjeto> produtosProjeto;
    private final Activity activity;

    public ProdutosProjetoAdapter(List<ProdutoProjeto> produtosProjeto, Activity activity) {
        this.produtosProjeto = produtosProjeto;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return produtosProjeto.size();
    }

    @Override
    public Object getItem(int i) {
        return produtosProjeto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return produtosProjeto.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myView = activity.getLayoutInflater().inflate(R.layout.lista_produtos, viewGroup, false);
        ProdutoProjeto produtoProjeto = produtosProjeto.get(i);

        TextView nome = (TextView) myView.findViewById(R.id.lista_produto_nome);
        TextView qtdArrecadado = (TextView) myView.findViewById(R.id.lista_produto_arrecadado);
        TextView qtdTotal = (TextView) myView.findViewById(R.id.lista_produto_quantidade_total);

        nome.setText(produtoProjeto.getProduto().getNome());
        qtdArrecadado.setText(Integer.toString(produtoProjeto.getQtdArrecadado()));
        qtdTotal.setText(Integer.toString(produtoProjeto.getQtdTotal()));

        return myView;
    }
}
