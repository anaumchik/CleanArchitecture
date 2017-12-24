package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import android.os.Parcel;
import android.os.Parcelable;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Root(name = "enclosure")
@ToString
public class NewsModelEnclosure implements Parcelable {

    @Getter
    @Setter
    @Attribute(required = false, name = "url")
    protected String url;
    @Getter
    @Setter
    @Attribute(required = false, name = "length")
    protected String length;
    @Getter
    @Setter
    @Attribute(required = false, name = "type")
    protected String type;

    public NewsModelEnclosure() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.length);
        dest.writeString(this.type);
    }

    protected NewsModelEnclosure(Parcel in) {
        this.url = in.readString();
        this.length = in.readString();
        this.type = in.readString();
    }

    public static final Creator<NewsModelEnclosure> CREATOR = new Creator<NewsModelEnclosure>() {
        @Override
        public NewsModelEnclosure createFromParcel(Parcel source) {
            return new NewsModelEnclosure(source);
        }

        @Override
        public NewsModelEnclosure[] newArray(int size) {
            return new NewsModelEnclosure[size];
        }
    };
}
