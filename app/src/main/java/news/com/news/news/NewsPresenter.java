package news.com.news.news;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import news.com.news.ApplicationNews;
import news.com.news.R;
import news.com.news.responseobjects.ObjectResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zodiakaio on 08.03.2018.
 *
 */

public class NewsPresenter implements NewsContract.Presenter {

    private Context context;
    private NewsContract.View view;
    private int page;

    public NewsPresenter(Context context, @NonNull NewsContract.View view){
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void setToFirstPage() {
        this.page = 0;
    }

    @Override
    public void getNews(int id) {
        ApplicationNews.getApi().getNews(id, page).enqueue(new Callback<ObjectResponse>() {
            @Override
            public void onResponse(Call<ObjectResponse> call, Response<ObjectResponse> response) {
                if (response.body() != null) {
                    view.setData(response.body().getList());
                    page++;
                }
            }

            @Override
            public void onFailure(Call<ObjectResponse> call, Throwable t) {
                Toast.makeText(context, context.getResources().getText(R.string.error_message), Toast.LENGTH_LONG).show();
            }
        });
    }
}
