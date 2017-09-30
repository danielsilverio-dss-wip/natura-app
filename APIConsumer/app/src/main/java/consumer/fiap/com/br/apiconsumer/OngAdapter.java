package consumer.fiap.com.br.apiconsumer;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.resource;

/**
 * Created by WaldemirGomesDeAndra on 28/09/2017.
 */

public class OngAdapter extends ArrayAdapter<Ong> {

    private  Context context = null;
    private  List<Ong> elementos = null;

    public OngAdapter(Context context, List<Ong> elementos) {
        super(context, R.layout.linha, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView id = (TextView) rowView.findViewById(R.id.txtId);
        TextView nome = (TextView) rowView.findViewById(R.id.txtNome);

        ImageView img = (ImageView) rowView.findViewById(R.id.imgProj);

        id.setText("" + elementos.get(position).getId());
        nome.setText(elementos.get(position).getNome());

        return rowView;
    }


}

