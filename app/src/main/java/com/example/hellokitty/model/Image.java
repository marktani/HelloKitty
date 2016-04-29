package com.example.hellokitty.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;

@Root(name = "response")
public class Image {
    @Path("data/images/image")
    @Element(name = "url")
    private String url;

    @Path("data/images/image")
    @Element(name = "id")
    private String id;

    @Path("data/images/image")
    @Element(name = "source_url")
    private String source_url;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(url);
        stringBuilder.append("\n");
        stringBuilder.append(id);
        stringBuilder.append("\n");
        stringBuilder.append(source_url);
        return stringBuilder.toString();
    }

    public String getUrl() {
        return url;
    }

    public String getSourceUrl() {
        return source_url;
    }

    public String getId() {
        return id;
    }

}
