package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Root(name = "enclosure")
@ToString
public class NewsModelEnclosure {

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
}
