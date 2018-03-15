package news.com.news.responseobjects;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Zodiakaio on 28.02.2018.
 *
 */

public class News implements Parcelable{

    private int id;
    private String title;
    private Date date;
    private String shortDescription;
    private String fullDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeString(shortDescription);
    }

    public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int i) {
            return new News[i];
        }
    };

    private News(Parcel parcel) {
        id = parcel.readInt();
        title = parcel.readString();
        shortDescription = parcel.readString();
    }
}
