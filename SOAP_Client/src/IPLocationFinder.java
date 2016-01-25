

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;


public class IPLocationFinder {
    public static void main(String[] args){
        GeoIPService geo = new GeoIPService();
        GeoIPServiceSoap service = geo.getGeoIPServiceSoap();
        String ipAdress = "8.8.8.8";
        GeoIP getIP = service.getGeoIP(ipAdress);
       
        System.out.println(getIP.getCountryName());

       
    }
}