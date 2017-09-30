package lista.fiap.com.br.listanome;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by WaldemirGomesDeAndra on 29/09/2017.
 */

public class FilmeAdapter extends ArrayAdapter<Filme> {


    private Context context;
    private ArrayList<Filme> elementos;


    public FilmeAdapter(Context context, ArrayList<Filme>elementos) {
        super(context, R.layout.linha,elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linha, parent, false);

        TextView nomeEscola = (TextView) rowView.findViewById(R.id.nome);
        TextView endereco = (TextView) rowView.findViewById(R.id.endereco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);



        nomeEscola.setText(elementos.get(position).getNome());
        endereco.setText(elementos.get(position).getDescricao());

       //passar o atributo que corresponde a um byte
        // Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        //imagem.setImageBitmap();

        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }



}
