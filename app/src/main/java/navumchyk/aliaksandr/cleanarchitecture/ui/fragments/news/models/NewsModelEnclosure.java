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

    public Enclosure() {
    }

    protected Enclosure(Parcel in) {
        this.url = in.readString();
        this.length = in.readString();
        this.type = in.readString();
    }

    public static final Parcelable.Creator<Enclosure> CREATOR = new Parcelable.Creator<Enclosure>() {
        @Override
        public Enclosure createFromParcel(Parcel source) {
            return new Enclosure(source);
        }

        @Override
        public Enclosure[] newArray(int size) {
            return new Enclosure[size];
        }
    };
}
