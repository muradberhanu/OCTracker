package com.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Trips {
    @JacksonXmlProperty(localName = "Trip")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Trip> Trip;

    public List<Trip> getTrip() {
        return Trip;
    }

    public void setTrip(List<Trip> trip) {
        this.Trip = trip;
    }

}
