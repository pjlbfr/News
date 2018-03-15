package news.com.news;

import android.app.Application;

import news.com.news.interfaces.NewsApi;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Zodiakaio on 28.02.2018.
 *
 */

public class ApplicationNews extends Application {

    private static NewsApi sNewsApi;
    private Retrofit retrofit;

    @Override
    public void onCreate(){
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://testtask.sebbia.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sNewsApi = retrofit.create(NewsApi.class);
    }

    public static NewsApi getApi(){
     return sNewsApi;
    }
}
