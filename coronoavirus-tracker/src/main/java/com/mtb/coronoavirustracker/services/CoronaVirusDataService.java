package com.mtb.coronoavirustracker.services;


import com.mtb.coronoavirustracker.models.LocationStats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


@Service
public class CoronaVirusDataService {
    private StringBuffer responseContent=new StringBuffer();

    public List<LocationStats> getAllStats() {
        return allStats;
    }

    private List<LocationStats> allStats=new ArrayList<>();
    @PostConstruct
    @Scheduled(cron="* * 1 * * *")
    public void fetchVirusData() throws IOException {

        List<LocationStats> newStats=new ArrayList<>();
        CloseableHttpClient client1= HttpClients.createDefault();
        HttpGet get=new HttpGet("https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv");

        //HttpResponse response=client.execute(httpPost);
        CloseableHttpResponse response=client1.execute(get);
        HttpEntity entity=response.getEntity();
            String result= EntityUtils.toString(entity);



        //Reader in = new FileReader("path/to/file.csv");
        StringReader in=new StringReader(result);
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
        for (CSVRecord record : records) {
            LocationStats locationStats=new LocationStats();
            String state = record.get("Province/State");
            locationStats.setState(record.get("Province/State"));
            locationStats.setCountry(record.get("Country/Region"));
            int latestCases=Integer.parseInt(record.get(record.size()-1));
            int prevDayCases=Integer.parseInt(record.get(record.size()-2));
            locationStats.setLatestTotalCases(latestCases);
            locationStats.setDiffFromPreviousDay(latestCases-prevDayCases);
            newStats.add(locationStats);

            /*String customerNo = record.get("CustomerNo");
            String name = record.get("Name");*/
        }
        this.allStats=newStats;
    }
}
