package com.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class RouteDirection {
    @JacksonXmlProperty(isAttribute = true)
    private String RouteNo;
    @JacksonXmlProperty(isAttribute = true)
    private String RouteLabel;
    @JacksonXmlProperty(isAttribute = true)
    private String Direction;
    @JacksonXmlProperty(isAttribute = true)
    private String RequestProcessingTime;
    @JacksonXmlProperty(isAttribute = true)
    private Trips Trips;

    public RouteDirection(){

    }

    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String RouteNo) {
        this.RouteNo = RouteNo;
    }

    public String getRouteLabel() {
        return RouteLabel;
    }

    public void setRouteLabel(String routeLabel) {
        this.RouteLabel = routeLabel;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        this.Direction = direction;
    }

    public String getRequestProcessingTime() {
        return RequestProcessingTime;
    }

    public void setRequestProcessingTime(String requestProcessingTime) {
        this.RequestProcessingTime = requestProcessingTime;
    }

    public Trips getTrips() {
        return Trips;
    }

    public void setTrips(Trips trips) {
        this.Trips = trips;
    }
}
