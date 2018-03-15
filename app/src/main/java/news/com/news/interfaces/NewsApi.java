package news.com.news.interfaces;

import news.com.news.responseobjects.Categories;
import news.com.news.responseobjects.Details;
import news.com.news.responseobjects.ObjectResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Zodiakaio on 28.02.2018.
 *
 */

public interface NewsApi {
    @GET("v1/news/categories")
    Call<Categories> getCategories();

    @GET("v1/news/categories/{id}/news")
    Call<ObjectResponse> getNews(@Path("id") int id, @Query("page") int page);

    @GET("v1/news/details")
    Call<Details> getDetails(@Query("id") int id);
}
