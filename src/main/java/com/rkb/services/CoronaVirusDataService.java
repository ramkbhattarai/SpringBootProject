package com.rkb.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rkb.models.LocationStat;

@Service
public class CoronaVirusDataService {
	
	private static String Virus_Data_Url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	private List<LocationStat> allStats = new ArrayList<>();
	
	@PostConstruct
	@Scheduled(cron = "* 1 * * * *")
	public void fetchVirusData() throws Exception {
		URL url = new URL(Virus_Data_Url);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				in.close();
				con.disconnect();
				changeToJson(content.toString());
				
	}

	private void changeToJson(String content) {
		List<LocationStat> stats = new ArrayList<>();
		String [] arr = content.split(" ");
		for(int i = 1; i <= 13; i++) {
			LocationStat ls = new LocationStat();
			String[] ar = arr[i].split(",");
			int length = ar.length -1;
			String an = ar[length -1];
			String[] ans = an.split("");
			int k = 0;
			for(int i1 = 0; i1 < ans.length; i1++) {
				if(isNumeric(ans[i1])){
					k++;
				}
			}
			String cases = an.substring(0, k);
			String state = an.substring(k);
				ls.setCountry(ar[0]);
				ls.setState(state);
				ls.setLat(ar[1]);
				ls.setLng(ar[2]);
				ls.setCases(cases);
				stats.add(ls);
		}
		this.allStats = stats;
	}
	
	public  boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
