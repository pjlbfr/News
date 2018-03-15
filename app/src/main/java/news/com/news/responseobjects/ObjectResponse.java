package news.com.news.responseobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class ObjectResponse {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("list")
    @Expose
    private List<News> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<News> getList() {
        return list;
    }

    public void setList(List<News> list) {
        this.list = list;
    }
}
