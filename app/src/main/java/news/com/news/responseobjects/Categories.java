package news.com.news.responseobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zodiakaio on 01.03.2018.
 *
 */

public class Categories {

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("list")
    @Expose
    private List<Category> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Category> getList() {
        return list;
    }

    public void setList(List<Category> list) {
        this.list = list;
    }
}
