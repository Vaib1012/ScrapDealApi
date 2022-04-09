package com.ibm.app.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.ibm.app.models.ArbitrageStock;

@Service
public class FinanceAPIService {

	private static final String GET_URL = "http://127.0.0.1:5000/table";
	@Autowired
	private Gson gson;
	
	public ArbitrageStock[] sendGET() {
		URL obj;
		try {
			obj = new URL(GET_URL);

			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			//con.setRequestProperty("accept", "application/json");

			int responseCode = con.getResponseCode();

			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				Reader reader = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
				return gson.fromJson(reader, ArbitrageStock[].class);
			} else {
				//print internal server error
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArbitrageStock[0];

	}



}
