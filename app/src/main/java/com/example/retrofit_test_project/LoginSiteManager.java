package com.example.retrofit_test_project;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginSiteManager {
    // 以Singleton模式建立
    private static LoginSiteManager mInstance = new LoginSiteManager();

    private APIService myAPIService;

    private LoginSiteManager() {

        // 設置baseUrl即要連的網站，addConverterFactory用Gson作為資料處理Converter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPIService = retrofit.create(APIService.class);

    }

    public static LoginSiteManager getInstance() {
        return mInstance;
    }

    public APIService getAPI() {
        return myAPIService;
    }


}
