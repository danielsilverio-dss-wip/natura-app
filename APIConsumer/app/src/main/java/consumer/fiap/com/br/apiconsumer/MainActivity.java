package consumer.fiap.com.br.apiconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onStart();
    }


    @Override
    protected void onStart(){
        super.onStart();
        final ListView lista = (ListView) findViewById(R.id.lvNome);

        IOngRest iOngRest = IOngRest.retrofit.create(IOngRest.class);


        final Call<List<Ong>> call = iOngRest.getLivros();

        //
        call.enqueue(new Callback<List<Ong>>(){


            @Override
            public void onResponse(Call<List<Ong>> call, Response<List<Ong>> response) {

                final List<Ong> listaLivros = response.body();
                if (listaLivros != null){

                    OngAdapter adapter = new OngAdapter(getBaseContext(), listaLivros);
                    lista.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<List<Ong>> call, Throwable t) {

                Toast.makeText(getBaseContext(), "Problema de acesso", Toast.LENGTH_LONG).show();

            }
        });




    }

}
