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
    SiteManager loginSiteManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        apiService = loginSiteManager.getInstance ().getAPI ();

//        GetFakeAPI ();
        GetUsersInfomation ();
    }

    public void GetFakeAPI(){
        Call<List<APIResponse>> call = apiService.response ();

        call.enqueue (new Callback<List<APIResponse>> () {
            @Override
            public void onResponse (Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
                for (int i = 0;i<response.body ().size ();i++){
                    Log.e ("TAG", "userid: "+response.body ().get (i).getUserId ());
                    Log.e ("TAG", "ID: "+response.body ().get (i).getId ());
                    Log.e ("TAG", "title: "+response.body ().get (i).getTitle ());
                    Log.e ("TAG", "body: "+response.body ().get (i).getBody ());
                }
                Log.e ("TAG", "size: "+response.body ().size () );
            }

            @Override
            public void onFailure (Call<List<APIResponse>> call, Throwable t) {
                Log.e ("TAG", "onFailure: " );
            }
        });
    }

    public void GetUsersInfomation(){

        Call<List<UsersResponse>> calluser = apiService.userresponse ();

        calluser.enqueue (new Callback<List<UsersResponse>> () {
            @Override
            public void onResponse (Call<List<UsersResponse>> call, Response<List<UsersResponse>> response) {
                for (int i = 0;i<response.body ().size ();i++){
                    Log.e ("TAG", "ID: "+response.body ().get (i).getId () );
                    Log.e ("TAG", "Name: "+response.body ().get (i).getName () );
                    Log.e ("TAG", "UserName: "+response.body ().get (i).getUsername () );
                    Log.e ("TAG", "Email: "+response.body ().get (i).getEmail () );
                    Log.e ("TAG", "Address_Street: "+response.body ().get (i).getAddress ().getStreet () );
                    Log.e ("TAG", "Address_Suite: "+response.body ().get (i).getAddress ().getSuite () );
                    Log.e ("TAG", "Address_City: "+response.body ().get (i).getAddress ().getCity ());
                    Log.e ("TAG", "Address_Zipcode: "+response.body ().get (i).getAddress ().getZipcode ());
                    Log.e ("TAG", "Address_Geo_Lat: "+response.body ().get (i).getAddress ().getGeo ().getLat ());
                    Log.e ("TAG", "Address_Geo_Lng: "+response.body ().get (i).getAddress ().getGeo ().getLng ());
                }
                Log.e ("TAG", "Size: "+response.body ().size () );
            }

            @Override
            public void onFailure (Call<List<UsersResponse>> call, Throwable t) {
                Log.e ("TAG", "onFailure: ");
            }
        });
    }
}