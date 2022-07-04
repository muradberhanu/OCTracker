package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GetNextTripsForStopResult")
public class GetNextTripsForStop {

    @JacksonXmlProperty(localName = "StopNo")
    private String StopNo;
    @JacksonXmlProperty(localName = "StopLabel")
    private String StopLabel;
    @JacksonXmlProperty(localName = "Route")
    private RouteForStop Route;

    public GetNextTripsForStop(){

    }

    public String getStopNo() {
        return StopNo;
    }

    public void setStopNo(String stopNo) {
        this.StopNo = stopNo;
    }

    public String getStopLabel() {
        return StopLabel;
    }

    public void setStopLabel(String stopLabel) {
        this.StopLabel = stopLabel;
    }

    public RouteForStop getRoute(){
        return Route;
    }

    public void setRouteDirection(RouteForStop route){
        this.Route = route;
    }

}

class RouteForStop{
    @JacksonXmlProperty(localName = "RouteDirection")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RouteDirection> RouteDirection;

    public List<RouteDirection> getRouteDirection(){
        return RouteDirection;
    }

    public void setRouteDirection(List<RouteDirection> routeDirection){
        this.RouteDirection = routeDirection;
    }
}
