package news.com.news.details;

import android.content.Context;
import android.widget.Toast;

import news.com.news.ApplicationNews;
import news.com.news.R;
import news.com.news.responseobjects.Details;
import news.com.news.responseobjects.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zodiakaio on 09.03.2018.
 *
 */

public class DetailsPresenter implements DetailsContract.Presenter {

    private Context context;
    private DetailsContract.View view;

    public DetailsPresenter(Context context, DetailsContract.View view){
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void getDetails(int id) {
        ApplicationNews.getApi().getDetails(id).enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                if (response.body() != null){
                    News element = response.body().getNews();
                    view.setData(element);
                }
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {
                Toast.makeText(context, context.getResources().getText(R.string.error_message), Toast.LENGTH_LONG).show();

            }
        });
    }
}
