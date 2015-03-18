package com.ednardo.loteca;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class springGoogle {

	public static void main(String[] args) throws ParseException {
		// RestTemplate restTemplate = new RestTemplate();
		// Map<String, String> vars = new HashMap<String, String>();
		//
		// vars.put("address", "Florianópolis");
		// vars.put("sensor", "false");
		// String result = restTemplate.getForObject(
		// "http://maps.googleapis.com/maps/api/geocode/xml?address={address}&sensor={sensor}",
		//
		// String.class, vars);
		//
		// System.out.println(result);

		Date d = new Date();
		System.out.println(d);
		Format formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss Z");
		String DateToStr = "Ter, 10 Mar 2015 16:20:02 -0300";// formatter.format(d);
		System.out.println(formatter.parseObject(DateToStr));

		// Ter, 10 Mar 2015 21:51:40 BRT
		// Tue, 10 Mar 2015 16:20:02 -0300
		// Ter, 10 Mar 2015 21:52:53 -0300
	}
}
