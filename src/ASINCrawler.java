
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ASINCrawler {

    String cat;
    String link;
    String home;
    
    double fail=0;
    double sucsess=0;
    
    List<String> duplicateList;
    int xmlCount=0;
    
    public ASINCrawler(String l, String c, String h){
        cat=c;
        link=l;
        home=h;
    }
    
    public void start() throws Exception{
        File f=new File(".");
        String list[]=f.list();
        duplicateList=Arrays.asList(list);
        
        System.out.println("Crawling "+cat+":");
        for(int i=1;i<300;i++){
            System.out.println("\tCrawling Page "+i);
            String l=link.replaceAll("null", i+"");
            BufferedReader rd=new BufferedReader(new InputStreamReader(new URL(l).openStream()));
            String mess="", temp=null;
            while((temp=rd.readLine())!=null){
                mess=mess+temp;
            }
            rd.close();
            
            ArrayList<String> asinList=new ArrayList<String>();
            
            Pattern p = Pattern.compile("\\WB[\\w\\d]{9}\\W");
            Matcher m = p.matcher(mess);
            while(m.find()){
                String s=m.group();
                s=s.replaceAll("\\W", "");
                if(!asinList.contains(s)){
                    asinList.add(s);
                }
            }
            
            for(String asin: asinList){
                getProductDescriptionPage(asin);
                getXML(asin);
            }
            
            if (xmlCount==5000){
                xmlCount=0;
                System.out.println("XMLCount has reached 2000. Pausing for 20 minutes");
                try{Thread.sleep(60*20*1000);}catch (Exception e){}
            }
        }
    }
    
    
    private void getXML(String asin){
        try{
            xmlCount++;
            
            if(duplicateList.contains(asin+".xml")){
                System.err.println("Skipping XML Duplicate ASIN");
                throw new Exception();
            }
            
            String data=XMLDataCrawler.crawlXMLData(asin);
            
            BufferedWriter wt=new BufferedWriter(new FileWriter(asin+".xml"));
            wt.write(data);
            wt.flush();
            wt.close();
            System.out.println("\t\tFinished fetching for "+asin);
            
            sucsess++;
            
            } catch (Exception e){
                fail++;
                System.err.println("XML Fetching Failed for "+asin);
                System.err.println("Failure Rate: "+(fail/(fail+sucsess))*100);
                e.printStackTrace();
            }
    }
    
    private void getProductDescriptionPage(String asin) {
        try{
        
       if(duplicateList.contains(asin+".html")){
           System.err.println("Skipping HTML for Duplicate ASIN");
           throw new Exception();
       }
            
        String l="http://www.amazon.com/dp/"+asin;
        
        BufferedReader rd=new BufferedReader(new InputStreamReader(new URL(l).openStream()));
        String mess="", temp=null;
        while((temp=rd.readLine())!=null){
            mess=mess+temp;
        }
        rd.close();
        
        //System.out.println("\t\tFetching HTML for "+asin);
        BufferedWriter wt=new BufferedWriter(new FileWriter(asin+".html"));
        wt.write(mess);
        wt.flush();
        wt.close();
        } catch (Exception e){System.out.println("\tFetching FAILED for "+asin);}
    }
    
}
