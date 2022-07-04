package com.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Routes {
    @JacksonXmlProperty(localName = "Route")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Route> Route;

    public List<Route> getRoute() {
        return Route;
    }

    public void setRoute(List<Route> route) {
        this.Route = route;
    }

}
