package com.example.retrofit_test_project;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("posts")
    Call<List<APIResponse>> response();

    @GET("users")
    Call<List<UsersResponse>> userresponse();
}
