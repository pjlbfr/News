package news.com.news.details;

import news.com.news.interfaces.BaseView;
import news.com.news.responseobjects.News;

/**
 * Created by Zodiakaio on 14.03.2018.
 *
 */

public interface DetailsContract {
    interface View extends BaseView<Presenter>{
        void setData(News element);
    }

    interface Presenter{
        void getDetails(int id);
    }
}
