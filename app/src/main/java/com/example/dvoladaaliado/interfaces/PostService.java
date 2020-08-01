package com.example.dvoladaaliado.interfaces;

import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostService {

    String API_ROUTE = "/subscription";

    @GET(API_ROUTE)

    Call<JSONObject> getPost();

}
