package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Root(name = "rss", strict = false)
public class NewsModelRSS {

    @Getter
    @Setter
    @Path("channel")
    @ElementList(entry = "item", inline = true)
    private ArrayList<NewsModel> newsList;
}