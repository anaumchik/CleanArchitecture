package navumchyk.aliaksandr.cleanarchitecture.ui.fragments.news.models;

import org.simpleframework.xml.ElementList;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

public class NewsModelResponse {

    @Getter
    @Setter
    @ElementList(entry = "item", inline = true)
    private ArrayList<NewsModel> newsModelList;
}