package com.htec.codingexercise.network.http;


import com.htec.codingexercise.App;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.htec.codingexercise.network.http.Constants.RETROFIT_API;


/**
 * Dagger network module that provides objects which will live during the application lifecycle.
 */
@Singleton
@Module
public class ModuleHTTPClient {

    private final String baseUrl;
    private final String cacheDirName;

    /**
     * Network dagger module
     *
     * @param baseUrl rest base url
     */
    public ModuleHTTPClient(String baseUrl, String cacheDirName) {
        this.baseUrl = baseUrl;
        this.cacheDirName = cacheDirName;
    }

    /**
     * Provide http cache
     */
    @Provides
    @Singleton
    @Named(RETROFIT_API)
    Cache provideOkHttpCache(App app) {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(new File(app.getCacheDir(), cacheDirName), cacheSize);
        return cache;
    }

    /**
     * Provide http client
     *
     * @param cache Http cache
     * @return http client
     */
    @Provides
    @Singleton
    @Named(RETROFIT_API)
    OkHttpClient provideOkHttpClient(@Named(RETROFIT_API) Cache cache) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        return builder
                .cache(cache)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Provide Retrofit
     *
     * @param okHttpClient http client
     * @return retrofit
     */
    @Singleton
    @Provides
    @Named(RETROFIT_API)
    Retrofit provideRetrofit(@Named(RETROFIT_API) OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .addConverterFactory(new ToStringConverterFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }
}
