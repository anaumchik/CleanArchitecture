package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Aliaksandr Navumchyk
 */
@ToString
@Root(name = "item")
public class NewsModel implements Parcelable {

    @Getter
    @Setter
    @Element(required = false, name = "guid")
    private String guid;
    @Getter
    @Setter
    @Element(required = false, name = "pubDate")
    private String pubDate;
    @Getter
    @Setter
    @Element(required = false, name = "category")
    private String category;
    @Getter
    @Setter
    @Element(required = false, name = "title")
    private String title;
    @Getter
    @Setter
    @Element(required = false, name = "description")
    private String body;
    @Getter
    @Setter
    @Element(required = false, name = "enclosure")
    private NewsModelEnclosure enclosure;
    @Getter
    @Setter
    @Element(required = false, name = "link")
    private String link;

    public NewsModel() {
    }

    public NewsModel(String title, String body) {
        this.title = title;
        this.body = body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.guid);
        dest.writeString(this.pubDate);
        dest.writeString(this.category);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeParcelable(this.enclosure, flags);
        dest.writeString(this.link);
    }

    protected NewsModel(Parcel in) {
        this.guid = in.readString();
        this.pubDate = in.readString();
        this.category = in.readString();
        this.title = in.readString();
        this.body = in.readString();
        this.enclosure = in.readParcelable(Enclosure.class.getClassLoader());
        this.link = in.readString();
    }

    public static final Parcelable.Creator<NewsModel> CREATOR = new Parcelable.Creator<NewsModel>() {
        @Override
        public NewsModel createFromParcel(Parcel source) {
            return new NewsModel(source);
        }

        @Override
        public NewsModel[] newArray(int size) {
            return new NewsModel[size];
        }
    };
}

