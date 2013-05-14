
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Variables {
    
    private static ArrayList<String> cat=new ArrayList<String>();
    
    public static String home;
    
    static void init(){
        
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A172421&page=null{}Camcorders");
        cat.add("http://www.amazon.com/s/ref=lp_562261011_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A499248%2Cn%3A562261011&page=null{}Lenses");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A172435%2Cn%3A3443921%2Cn%3A3443931%2Cn%3A525460&page=null{}Lenses");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A499320&page=null{}Binoculars");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A172435%2Cn%3A3443921%2Cn%3A3443931%2Cn%3A525460&page=null{}DigitalPhototFrames");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A2335752011%2Cn%3A%212335753011%2Cn%3A2407755011&page=null{}PhoneAccess");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A2335752011%2Cn%3A%212335753011%2Cn%3A2407749011&page=null{}Phones");
        cat.add("http://www.amazon.com/s/ref=lp_14210751_pg_null?rh=n%3A468642%2Cn%3A%2111846801%2Cn%3A14210751&page=null{}PS3Games");
        cat.add("http://www.amazon.com/s/ref=lp_11075831_pg_null?rh=n%3A468642%2Cn%3A%2111846801%2Cn%3A11075831&page=null{}NintendoDSGames");
        cat.add("http://www.amazon.com/s/ref=lp_1264866011_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A172623%2Cn%3A172630%2Cn%3A1264866011&page=null{}MP3Players");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A172623%2Cn%3A172630%2Cn%3A290438%2Ck%3Aipod&page=null{}MP3Access");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A172526&page=null{}GPSAndNavi");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A3248684011%2Cn%3A1077068&page=null{}CarElectrical");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A15684181%2Cn%3A%2115690151%2Cn%3A15857501%2Cn%3A15735141&page=null{}CarSecurity");
        cat.add("http://www.amazon.com/s/ref=lp_3737671_pg_null?rh=n%3A1055398%2Cn%3A%211063498%2Cn%3A3206324011%2Cn%3A3737671&page=null{}AC");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A2619525011%2Cn%3A%212619526011%2Cn%3A3741181&page=null{}ElectricalParts");
        cat.add("http://www.amazon.com/s/ref=lp_510106_pg_null?rh=n%3A1055398%2Cn%3A%211063498%2Cn%3A510106&page=null{}VaccumCleaners");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A2619525011%2Cn%3A%212619526011%2Cn%3A3741441&page=null{}RangeHoods");
        cat.add("http://www.amazon.com/s/ref=lp_3737601_pg_null?rh=n%3A1055398%2Cn%3A%211063498%2Cn%3A3206324011%2Cn%3A3737601&page=null{}Fans");
        cat.add("http://www.amazon.com/s/ref=lp_267554011_pg_null?rh=n%3A1055398%2Cn%3A%211063498%2Cn%3A3206324011%2Cn%3A267554011&page=null{}AirPurifiers");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A2619525011%2Cn%3A%212619526011%2Cn%3A495362&page=null{}CeilingFansAndAccess");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A541966%2Cn%3A565108&page=null{}Laptops");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A541966%2Cn%3A172456%2Cn%3A3011391011%2Cn%3A172470&page=null{}Access");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A541966%2Cn%3A565098&page=null{}Desktops");
        cat.add("http://www.amazon.com/s/ref=lp_172659_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A1266092011%2Cn%3A172659&page=null{}TV");
        cat.add("http://www.amazon.com/s/ref=lp_352697011_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A1266092011%2Cn%3A3213025011%2Cn%3A352697011&page=null{}BluRayPlayers");
        cat.add("http://www.amazon.com/s/ref=lp_300334_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A541966%2Cn%3A300334&page=null{}Projecters");
        cat.add("http://www.amazon.com/s/ref=lp_13447451_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A1266092011%2Cn%3A13447451&page=null{}DigitalMediaDevices");
        cat.add("http://www.amazon.com/s/ref=lp_10966881_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A10966881&page=null{}Antennas");
        cat.add("http://www.amazon.com/s/ref=lp_760796_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A172664%2Cn%3A760796&page=null{}TVMounts");
        cat.add("http://www.amazon.com/s/ref=lp_202505011_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A172540%2Cn%3A464418%2Cn%3A202505011&page=null{}HDMICables");
        cat.add("http://www.amazon.com/s/ref=lp_1063310_pg_null?rh=n%3A1055398%2Cn%3A%211063498%2Cn%3A1063306%2Cn%3A1063310&page=null{}HomeEntertainmentFurniture");
        cat.add("http://www.amazon.com/s/ref=lp_281408_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A281408&page=null{}BlankCD,DVD");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A172541&page=null{}Headphones");
        cat.add("http://www.amazon.com/s/ref=lp_10967581_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A173244%2Cn%3A10967581&page=null{}TVRemoteControls");
        cat.add("http://www.amazon.com/s/ref=lp_173541_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A173541&page=null{}BatteriesChargersAccessories");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A281407%2Cn%3A172532%2Cn%3A173243&page=null{}CleaningAccesssories");
        cat.add("http://www.amazon.com/s/ref=lp_281056_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A1266092011%2Cn%3A281056&page=null{}HomeAudio");
        cat.add("http://www.amazon.com/s/ref=sr_pg_null?rh=n%3A172282%2Cn%3A%21493964%2Cn%3A502394%2Cn%3A281052&page=null{}Cameras");
        
    }
    
    public static ArrayList<String> returnList(){
        ArrayList<String> temp=cat;
        return temp;
    }
    
}
