package com.resources;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.model.GetNextTripsForStop;
import com.model.GetNextTripsForStopAllRoutes;
import com.model.GtfsStops;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;

import java.io.*;

@RestController
@SpringBootApplication
@CrossOrigin("*") //TODO: change this

public class OCTracker {
    RestTemplate restTemplate = new RestTemplate();

    //Need to use XML instead of JSON since the API's JSON is inconsistent
    @RequestMapping("/GetNextTripsForStopAllRoutesResult/{stopNo}")
    GetNextTripsForStopAllRoutes getNextTripsForStopAllRoutesResult(@PathVariable("stopNo") String stopNo){
        String url =
                "https://api.octranspo1.com/v2.0/GetNextTripsForStopAllRoutes?appID=e76b6187" +
                        "&apiKey=420e65cc50b027fa7bd1bf232b00f6ed&stopNo=" + stopNo + "&format=xml";

        String xmlResponse =  this.restTemplate.getForObject(url, String.class);
        GetNextTripsForStopAllRoutes getNextTripsForStopAllRoutes = new GetNextTripsForStopAllRoutes();

        try {
            SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(xmlResponse.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String strMsg = new String(out.toByteArray());

            String TARGET_ELEMENT = "GetRouteSummaryForStopResult";
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(strMsg));
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(xmlStreamReader.getLocalName())) {
                    getNextTripsForStopAllRoutes = xmlMapper.readValue(xmlStreamReader, GetNextTripsForStopAllRoutes.class);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getNextTripsForStopAllRoutes;
    }

    @RequestMapping("/GetNextTripsForStopResult/{stopNo}/{routeNo}")
    GetNextTripsForStop getNextTripsForStopResult(@PathVariable("stopNo") String stopNo,
                                                  @PathVariable("routeNo") String routeNo){
        String url =
                "https://api.octranspo1.com/v2.0/GetNextTripsForStop?appID=e76b6187" +
                        "&apiKey=420e65cc50b027fa7bd1bf232b00f6ed&stopNo=" + stopNo + "&routeNo=" + routeNo + "&format=xml";

        String xmlResponse =  this.restTemplate.getForObject(url, String.class);
        GetNextTripsForStop getRouteSummaryForStop = new GetNextTripsForStop();

        try {
            SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(xmlResponse.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String strMsg = new String(out.toByteArray());

            String TARGET_ELEMENT = "GetNextTripsForStopResult";
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(strMsg));
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(xmlStreamReader.getLocalName())) {
                    getRouteSummaryForStop = xmlMapper.readValue(xmlStreamReader, GetNextTripsForStop.class);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getRouteSummaryForStop;
    }

    @RequestMapping("/GetRouteSummaryForStopResult/{stopNo}")
    GetNextTripsForStopAllRoutes getRouteSummaryForStopResult(@PathVariable("stopNo") String stopNo){
        String url =
                "https://api.octranspo1.com/v2.0/GetRouteSummaryForStop?appID=e76b6187" +
                        "&apiKey=420e65cc50b027fa7bd1bf232b00f6ed&stopNo=" + stopNo + "&format=xml";

        String xmlResponse =  this.restTemplate.getForObject(url, String.class);
        GetNextTripsForStopAllRoutes getRouteSummaryForStop = new GetNextTripsForStopAllRoutes();

        try {
            SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(xmlResponse.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String strMsg = new String(out.toByteArray());

            String TARGET_ELEMENT = "GetRouteSummaryForStopResult";
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(strMsg));
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(xmlStreamReader.getLocalName())) {
                    getRouteSummaryForStop = xmlMapper.readValue(xmlStreamReader, GetNextTripsForStopAllRoutes.class);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getRouteSummaryForStop;
    }

    @RequestMapping("/Gtfs")
    GtfsStops getGtfsStopDataResult(){
        String url =
                "https://api.octranspo1.com/v2.0/Gtfs?appID=e76b6187" +
                        "&apiKey=420e65cc50b027fa7bd1bf232b00f6ed&table=stops&format=xml";

        String xmlResponse =  this.restTemplate.getForObject(url, String.class);
        GtfsStops gtfsStops = new GtfsStops();

        try {
            SOAPMessage message = MessageFactory.newInstance().createMessage(null,
                    new ByteArrayInputStream(xmlResponse.getBytes()));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String strMsg = new String(out.toByteArray());

            String TARGET_ELEMENT = "Gtfs";
            XmlMapper xmlMapper = new XmlMapper();
            xmlMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

            XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new StringReader(strMsg));
            while (xmlStreamReader.hasNext()) {
                int type = xmlStreamReader.next();
                if (type == XMLStreamReader.START_ELEMENT && TARGET_ELEMENT.equals(xmlStreamReader.getLocalName())) {
                    gtfsStops = xmlMapper.readValue(xmlStreamReader, GtfsStops.class);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gtfsStops;
    }

    public static void main(String[] args) {
        SpringApplication.run(OCTracker.class, args);
    }
}