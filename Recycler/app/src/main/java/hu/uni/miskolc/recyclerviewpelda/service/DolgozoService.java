package hu.uni.miskolc.recyclerviewpelda.service;

import java.util.List;

import hu.uni.miskolc.recyclerviewpelda.model.Dolgozo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DolgozoService {
    @GET("dolgozok")
    Call<List<Dolgozo>> dolgozokListazasa();

}
