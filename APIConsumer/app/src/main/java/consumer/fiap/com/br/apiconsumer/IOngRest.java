package consumer.fiap.com.br.apiconsumer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by WaldemirGomesDeAndra on 28/09/2017.
 */

public interface IOngRest {

    @GET("/ong")
    Call<List<Ong>> getLivros();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://59cd19ccc80b4a001175c43c.mockapi.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
