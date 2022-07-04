package com.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlElement;

public class Trip {
    @JacksonXmlProperty(isAttribute = true)
    @JacksonXmlCData
    private String TripDestination;
    @JacksonXmlProperty(isAttribute = true)
    private String TripStartTime;
    @JacksonXmlProperty(isAttribute = true)
    private String AdjustedScheduleTime;
    @JacksonXmlProperty(isAttribute = true)
    private String AdjustmentAge;
    @JacksonXmlProperty(isAttribute = true)
    private String LastTripOfSchedule;
    @JacksonXmlProperty(isAttribute = true)
    private String BusType;
    @JacksonXmlProperty(isAttribute = true)
    private String Longitude;
    @JacksonXmlProperty(isAttribute = true)
    private String Latitude;
    @JacksonXmlProperty(isAttribute = true)
    private String GPSSpeed;

    public String getTripDestination() {
        return TripDestination;
    }

    public void setTripDestination(String tripDestination) {
        this.TripDestination = tripDestination;
    }

    public String getTripStartTime() {
        return TripStartTime;
    }

    public void setTripStartTime(String tripStartTime) {
        this.TripStartTime = tripStartTime;
    }

    public String getAdjustedScheduleTime() {
        return AdjustedScheduleTime;
    }

    public void setAdjustedScheduleTime(String adjustedScheduleTime) {
        this.AdjustedScheduleTime = adjustedScheduleTime;
    }

    public String getAdjustmentAge() {
        return AdjustmentAge;
    }

    public void setAdjustmentAge(String adjustmentAge) {
        this.AdjustmentAge = adjustmentAge;
    }

    public String getLastTripOfSchedule() {
        return LastTripOfSchedule;
    }

    public void setLastTripOfSchedule(String lastTripOfSchedule) {
        this.LastTripOfSchedule = lastTripOfSchedule;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        this.BusType = busType;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    public String getGPSSpeed() {
        return GPSSpeed;
    }

    public void setGPSSpeed(String GPSSpeed) {
        this.GPSSpeed = GPSSpeed;
    }


}
