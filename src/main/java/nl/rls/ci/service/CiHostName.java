package nl.rls.ci.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class CiHostName {
	public static String getPublicHostName() {
		String systemipaddress = "";
		try {
			URL url_name = new URL("http://bot.whatismyipaddress.com");
			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
			// reads system IPAddress
			systemipaddress = sc.readLine().trim();
		} catch (Exception e) {
			systemipaddress = "Cannot Execute Properly";
		}
		return systemipaddress;
	}
	
	public static String getLocalHostName() {
		InetAddress localhost;
		try {
			localhost = InetAddress.getLocalHost();
			return localhost.getHostAddress().trim();
		} catch (UnknownHostException e) {
			e.printStackTrace();
			return "Cannot Execute Properly";
		}
	}

}
