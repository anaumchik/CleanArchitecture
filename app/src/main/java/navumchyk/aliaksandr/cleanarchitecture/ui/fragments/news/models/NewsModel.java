package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Aliaksandr Navumchyk
 */
@ToString
@AllArgsConstructor
@Root(name = "item")
public class NewsModel {

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
    private String img;
    @Getter
    @Setter
    @Element(required = false, name = "link")
    private String link;

}
