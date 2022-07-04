package com.model;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetNextTripsForStopAllRoutesResult")
public class GetNextTripsForStopAllRoutes {

    @JacksonXmlProperty(localName = "StopNo")
    private String StopNo;
    @JacksonXmlProperty(localName = "StopDescription")
    private String StopDescription;
    @JacksonXmlProperty(localName = "Routes")
    private Routes Routes;

    public GetNextTripsForStopAllRoutes(){

    }

    public String getStopNo() {
        return StopNo;
    }

    public void setStopNo(String stopNo) {
        this.StopNo = stopNo;
    }

    public String getStopDescription() {
        return StopDescription;
    }

    public void setStopDescription(String stopDescription) {
        this.StopDescription = stopDescription;
    }

    public Routes getRoutes() {
        return Routes;
    }

    public void setRoutes(Routes routes) {
        this.Routes = routes;
    }

}
