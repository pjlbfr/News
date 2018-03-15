package news.com.news.categories;

import java.util.List;

import news.com.news.interfaces.BaseView;
import news.com.news.responseobjects.Category;

/**
 * Created by Zodiakaio on 14.03.2018.
 *
 */

public interface CategoryContract {
    interface View extends BaseView<Presenter>{
        void setData(List<Category> list);
    }

    interface Presenter {
        void getCategory();
    }
}
