package br.com.fiap.natura.naturaapp.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fiap.natura.naturaapp.R;
import br.com.fiap.natura.naturaapp.bean.Projeto;

/**
 * Created by daniel on 08/09/17.
 */

public class ProjetosAdapter extends BaseAdapter {

    private final List<Projeto> projetos;
    private final Activity activity;
    //private Context context;

    public ProjetosAdapter(List<Projeto> projetos, Activity activity/*, Context context*/) {
        this.projetos = projetos;
        this.activity = activity;
        //this.context = context;
    }

    @Override
    public int getCount() {
        return projetos.size();
    }

    @Override
    public Object getItem(int i) {
        return projetos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return projetos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myView = activity.getLayoutInflater().inflate(R.layout.lista_projetos, viewGroup, false);
        Projeto projeto = projetos.get(i);

        ImageView imagem = (ImageView) myView.findViewById(R.id.lista_projetos_imagem);
        TextView nome = (TextView) myView.findViewById(R.id.lista_projetos_nome);

        nome.setText(projeto.getNome());

        Log.i("PackageName",viewGroup.getContext().getPackageName());

        int identifier = activity.getResources().getIdentifier(projeto.getImagem(),"drawable",activity.getPackageName());
        Log.i("identifier", Integer.toString(identifier));
        Drawable resource = activity.getDrawable(identifier);
        imagem.setImageDrawable(resource);

        /*
        //int imagemResource = viewGroup.getContext().getResources().getIdentifier(projeto.getImagem(), null, viewGroup.getContext().getPackageName());
        int imagemResource = viewGroup.getContext().getResources().getIdentifier("br.com.fiap.natura.naturaapp:drawable/projeto_criancas_musica.jpg", null, null);
        Log.i("imagemResource",Integer.toString(imagemResource));
        //Drawable resource = view.getResources().getDrawable(imagemResource);
        Drawable resource = viewGroup.getContext().getDrawable(imagemResource);
        */

        return myView;
    }
}
