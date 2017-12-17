package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

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
public class NewsModel {

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
    private Enclosure enclosure;
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
}

