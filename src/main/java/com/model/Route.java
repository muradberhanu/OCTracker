package com.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;

public class Route {
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlCData
    private String RouteNo;
    @JacksonXmlProperty(isAttribute = true)
    private String RouteHeading;
    @JacksonXmlProperty(isAttribute = true)
    private String DirectionID;
    @JacksonXmlProperty(isAttribute = true)
    private String Direction;
    @JacksonXmlProperty(isAttribute = true)
    private Trips Trips;

    public Route(){

    }

    public String getRouteNo() {
        return RouteNo;
    }

    public void setRouteNo(String RouteNo) {
        this.RouteNo = RouteNo;
    }

    public String getRouteHeading() {
        return RouteHeading;
    }

    public void setRouteHeading(String routeHeading) {
        this.RouteHeading = routeHeading;
    }

    public String getDirectionID() {
        return DirectionID;
    }

    public void setDirectionID(String directionID) {
        this.DirectionID = directionID;
    }

    public String getDirection() {
        return Direction;
    }

    public void setDirection(String direction) {
        this.Direction = direction;
    }

    public Trips getTrips() {
        return Trips;
    }

    public void setTrips(Trips trips) {
        this.Trips = trips;
    }
}
