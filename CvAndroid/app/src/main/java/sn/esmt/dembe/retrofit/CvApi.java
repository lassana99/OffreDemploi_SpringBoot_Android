package sn.esmt.dembe.retrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import sn.esmt.dembe.model.Cv;

public interface CvApi {
    @GET("/cvs/all")
    public Call<ArrayList<Cv>> all();

    @POST("/cvs/save")
    Call<Cv> save(@Body Cv cv);
}
