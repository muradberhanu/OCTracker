package com.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "GtfsStopDataResult")

public class GtfsStops {
    @JacksonXmlProperty(localName = "result")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<GtfsStop> GtfsStop;

    public GtfsStops(){

    }

    public List<com.model.GtfsStop> getGtfsStop() {
        return GtfsStop;
    }

    public void setGtfsStop(List<com.model.GtfsStop> gtfsStop) {
        GtfsStop = gtfsStop;
    }
}

class GtfsStop{
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlCData
    private String Id;
    @JacksonXmlProperty(localName = "Stop_id")
    private String Stop_id;
    @JacksonXmlProperty(localName = "Stop_code")
    private String Stop_code;
    @JacksonXmlProperty(localName = "Stop_name")
    private String Stop_name;
    @JacksonXmlProperty(localName = "Stop_desc")
    private String Stop_desc;
    @JacksonXmlProperty(localName = "Stop_lat")
    private String Stop_lat;
    @JacksonXmlProperty(localName = "Stop_lon")
    private String Stop_lon;
    @JacksonXmlProperty(localName = "Stop_street")
    private String Stop_street;
    @JacksonXmlProperty(localName = "Stop_city")
    private RouteForStop Stop_city;
    @JacksonXmlProperty(localName = "Stop_region")
    private String Stop_region;
    @JacksonXmlProperty(localName = "Stop_postcode")
    private String Stop_postcode;
    @JacksonXmlProperty(localName = "Stop_country")
    private RouteForStop Stop_country;
    @JacksonXmlProperty(localName = "Zone_id")
    private String Zone_id;

    public GtfsStop(){

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStop_id() {
        return Stop_id;
    }

    public void setStop_id(String stop_id) {
        Stop_id = stop_id;
    }

    public String getStop_code() {
        return Stop_code;
    }

    public void setStop_code(String stop_code) {
        Stop_code = stop_code;
    }

    public String getStop_name() {
        return Stop_name;
    }

    public void setStop_name(String stop_name) {
        Stop_name = stop_name;
    }

    public String getStop_desc() {
        return Stop_desc;
    }

    public void setStop_desc(String stop_desc) {
        Stop_desc = stop_desc;
    }

    public String getStop_lat() {
        return Stop_lat;
    }

    public void setStop_lat(String stop_lat) {
        Stop_lat = stop_lat;
    }

    public String getStop_lon() {
        return Stop_lon;
    }

    public void setStop_lon(String stop_lon) {
        Stop_lon = stop_lon;
    }

    public String getStop_street() {
        return Stop_street;
    }

    public void setStop_street(String stop_street) {
        Stop_street = stop_street;
    }

    public RouteForStop getStop_city() {
        return Stop_city;
    }

    public void setStop_city(RouteForStop stop_city) {
        Stop_city = stop_city;
    }

    public String getStop_region() {
        return Stop_region;
    }

    public void setStop_region(String stop_region) {
        Stop_region = stop_region;
    }

    public String getStop_postcode() {
        return Stop_postcode;
    }

    public void setStop_postcode(String stop_postcode) {
        Stop_postcode = stop_postcode;
    }

    public RouteForStop getStop_country() {
        return Stop_country;
    }

    public void setStop_country(RouteForStop stop_country) {
        Stop_country = stop_country;
    }

    public String getZone_id() {
        return Zone_id;
    }

    public void setZone_id(String zone_id) {
        Zone_id = zone_id;
    }
}

