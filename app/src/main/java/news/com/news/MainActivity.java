package news.com.news;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import news.com.news.categories.CategoryFragment;
import news.com.news.categories.CategoryPresenter;
import news.com.news.details.DetailsPresenter;
import news.com.news.details.DetailsFragment;
import news.com.news.news.NewsFragment;
import news.com.news.news.NewsPresenter;
import news.com.news.responseobjects.News;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class MainActivity extends AppCompatActivity implements CategoryFragment.OpenNewsListener, NewsFragment.OpenDetailsListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        CategoryFragment   categoryFragment = CategoryFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                                   .add(R.id.frameCont, categoryFragment)
                                   .commit();
        new CategoryPresenter(getApplicationContext(), categoryFragment);
    }

    @Override
    public void openNews(int id) {
        NewsFragment newsFragment = NewsFragment.newInstance(id);
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.frameCont, newsFragment)
                                   .addToBackStack(null)
                                   .commit();
        new NewsPresenter(getApplicationContext(), newsFragment);
    }

    @Override
    public void openDetails(News element) {
        DetailsFragment detailsFragment = DetailsFragment.newInstance(element);
        getSupportFragmentManager().beginTransaction()
                                   .replace(R.id.frameCont, detailsFragment)
                                   .addToBackStack(null)
                                   .commit();
        new DetailsPresenter(getApplicationContext(), detailsFragment);
    }
}
