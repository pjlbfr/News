package news.com.news.categories;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import news.com.news.ApplicationNews;
import news.com.news.R;
import news.com.news.responseobjects.Categories;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Zodiakaio on 08.03.2018.
 *
 */

public class CategoryPresenter implements CategoryContract.Presenter{

    private final CategoryContract.View view;
    private Context context;

    public CategoryPresenter(Context context, @NonNull CategoryContract.View view){
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void getCategory() {
        ApplicationNews.getApi().getCategories().enqueue(new Callback<Categories>() {
            @Override
            public void onResponse(Call<Categories> call, Response<Categories> response) {
                if (response.body() != null)
                    view.setData(response.body().getList());
            }

            @Override
            public void onFailure(Call<Categories> call, Throwable t) {
                Toast.makeText(context, context.getResources().getText(R.string.error_message), Toast.LENGTH_LONG).show();
            }
        });
    }
}
