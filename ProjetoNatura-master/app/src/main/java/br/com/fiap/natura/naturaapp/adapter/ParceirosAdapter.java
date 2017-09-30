package br.com.fiap.natura.naturaapp.adapter;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fiap.natura.naturaapp.R;
import br.com.fiap.natura.naturaapp.bean.Parceiro;

/**
 * Created by daniel on 09/09/17.
 */

public class ParceirosAdapter extends BaseAdapter {

    private final List<Parceiro> parceiros;
    private final Activity activity;

    public ParceirosAdapter(List<Parceiro> parceiros, Activity activity) {
        this.parceiros = parceiros;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return parceiros.size();
    }

    @Override
    public Object getItem(int position) {
        return parceiros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return parceiros.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View myView = activity.getLayoutInflater().inflate(R.layout.lista_parceiros, parent, false);
        Parceiro parceiro = parceiros.get(position);

        TextView nome = (TextView) myView.findViewById(R.id.lista_parceiros_nome);
        ImageView logo = (ImageView) myView.findViewById(R.id.lista_parceiros_icone);


        int identifier = activity.getResources().getIdentifier(parceiro.getLogo(),"drawable",activity.getPackageName());
        Drawable resource = activity.getDrawable(identifier);
        logo.setImageDrawable(resource);


        nome.setText(parceiro.getNome());

        return myView;
    }
}
