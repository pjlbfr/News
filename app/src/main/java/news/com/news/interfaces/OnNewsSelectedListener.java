package news.com.news.interfaces;

import news.com.news.responseobjects.News;

/**
 * Created by Zodiakaio on 06.03.2018.
 *
 */

public interface OnNewsSelectedListener {
    void onNewsSelected(News news);
    void loadPage();
}
