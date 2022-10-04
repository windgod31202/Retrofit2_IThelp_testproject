package com.example.retrofit_test_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIService apiService;
    LoginSiteManager loginSiteManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        apiService = LoginSiteManager.getInstance ().getAPI ();

        GetFakeAPI ();
    }

    public void GetFakeAPI(){
        Call<List<APIResponse>> call = apiService.response ();

        call.enqueue (new Callback<List<APIResponse>> () {
            @Override
            public void onResponse (Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                for (int i = 0;i<response.body ().size ();i++){
                    Log.e ("TAG", "onResponse: "+response.body ().get (i).getUserId ());
                    Log.e ("TAG", "onResponse: "+response.body ().get (i).getId ());
                    Log.e ("TAG", "onResponse: "+response.body ().get (i).getTitle ());
                    Log.e ("TAG", "onResponse: "+response.body ().get (i).getBody ());

                }
            }

            @Override
            public void onFailure (Call<List<APIResponse>> call, Throwable t) {
                Log.e ("TAG", "onFailure: " );
            }
        });
    }
}