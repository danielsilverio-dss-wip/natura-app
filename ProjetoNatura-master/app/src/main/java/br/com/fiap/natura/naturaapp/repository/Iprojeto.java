package br.com.fiap.natura.naturaapp.repository;

import java.util.List;

import br.com.fiap.natura.naturaapp.bean.Projeto;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by logonrm on 30/09/2017.
 */

public interface Iprojeto {

    @GET("/projeto")
    Call<List<Projeto>> getProjetos();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.20.94.60:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
