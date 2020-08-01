package com.example.dvoladaaliado.activities;

        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.util.JsonReader;
        import android.util.Log;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.dvoladaaliado.R;
        import com.example.dvoladaaliado.adapters.ListAdapter;
        import com.example.dvoladaaliado.interfaces.PostService;
        import com.example.dvoladaaliado.pojo.Plan;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.nio.charset.Charset;
        import java.util.ArrayList;
        import java.util.List;

        import javax.net.ssl.HttpsURLConnection;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class ImprovePackageActivity extends AppCompatActivity {
    public static final String LOG_TAG = ImprovePackageActivity.class.getSimpleName();
    private static final String USGS_REQUEST_URL = "https://dvolada-primary-server.herokuapp.com/subscription";

    ArrayList<Plan> plans = new ArrayList<>();
    RecyclerView recyclerView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improve_package);

        getPosts();
        recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(this, plans));


    }

    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dvolada-primary-server.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostService postService = retrofit.create(PostService.class);
        Call<JSONObject> call = postService.getPost();
        call.enqueue(new Callback<JSONObject>() {

            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                if (response.isSuccessful()){
                    Log.d("EXITO", String.valueOf(response.code()));
                    try {
                        List<Plan> result = (List<Plan>) response.body().getJSONArray("result");
                        //JSONObject r = result.getJSONObject(0);
                        for (Plan p : result){
                            Log.d("DATA", p.getName());
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    Log.d("RESPONSE", String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {
                Log.d("ERROR", String.valueOf(t.getMessage()));
            }
        });
    }
}