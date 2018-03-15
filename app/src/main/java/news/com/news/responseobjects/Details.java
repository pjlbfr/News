package news.com.news.responseobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Zodiakaio on 03.03.2018.
 *
 */

public class Details {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("news")
    @Expose
    private News news;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }
}
