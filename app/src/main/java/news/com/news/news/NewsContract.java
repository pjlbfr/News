package news.com.news.news;

import java.util.List;

import news.com.news.interfaces.BaseView;
import news.com.news.responseobjects.News;

/**
 * Created by Zodiakaio on 14.03.2018.
 *
 */

public interface NewsContract {
    interface View extends BaseView<Presenter>{
        void setData(List<News> list);
    }

    interface Presenter{
        void getNews(int id);
        void setToFirstPage();
    }
}
