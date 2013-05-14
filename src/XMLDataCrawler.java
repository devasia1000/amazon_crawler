

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XMLDataCrawler {
    
    private static String AWS_ACCESS_KEY_ID="AKIAJU2XWWK2FL4A7XMQ";
    private static String AWS_SECRET_KEY="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";
    private static final String ENDPOINT = "ecs.amazonaws.com";
    
    static String crawlXMLData(String asin) throws Exception{
        
        SignedRequestsHelper helper=null;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("AssociateTag", "wwwrobotboybl-20");
        params.put("Version", "2012-09-10");
        params.put("Operation", "ItemLookup");
        params.put("ItemId", asin);
        params.put("ResponseGroup", "EditorialReview,BrowseNodes"); 


        String requestUrl = helper.sign(params);
        
           BufferedReader rd=new BufferedReader(new InputStreamReader(new URL(requestUrl).openStream()));
           
           String total="", mess=null;
           while((mess=rd.readLine())!=null){
              total=total+mess;
           }
           rd.close();
           
           try{Thread.sleep(1000);} catch (Exception e){}
           
           
           SignedRequestsHelper helper2=null;
        try {
            helper2 = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, String> params2 = new HashMap<String, String>();
        params2.put("Service", "AWSECommerceService");
        params2.put("AssociateTag", "wwwrobotboybl-20");
        params2.put("Version", "2012-09-10");
        params2.put("Operation", "ItemLookup");
        params2.put("ItemId", asin);
        params2.put("ResponseGroup", "Large"); 
        

        String requestUrl2 = helper2.sign(params2);
        
           BufferedReader rd2=new BufferedReader(new InputStreamReader(new URL(requestUrl2).openStream()));
           
           String total2="", mess2=null;
           while((mess2=rd2.readLine())!=null){
              total2=total2+mess2;
           }
           rd2.close();
           
           total=total.replaceFirst("</ItemLookupResponse>", "");
           
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document dom = dBuilder.parse(new InputSource(new StringReader(total2)));
            
            NodeList child3=dom.getElementsByTagName("Title");
            String title=null;
            try{
                title=child3.item(0).getTextContent();
                total=total+"<Title>"+title+"</Title>";
            } catch (Exception e){
                System.err.println("Could not fetch title: "+asin);
            }
            
            
            NodeList child5=dom.getElementsByTagName("Brand");
            NodeList childTemp1=dom.getElementsByTagName("Manufacturer");
            NodeList childTemp2=dom.getElementsByTagName("Publisher");
            
            String brand=null;
            try{
                brand=child5.item(0).getTextContent();
                
            } catch (NullPointerException e){
                try{
                    brand=childTemp1.item(0).getTextContent();
                    
                } catch (NullPointerException e1){
                    try{
                        brand=childTemp2.item(0).getTextContent();
                        
                    } catch (NullPointerException e2){
                        brand="NULL";
                    }
                    
                }

            }
            
            total=total+"<Brand>"+brand+"</Brand>"+"</ItemLookupResponse>";
            
            try{Thread.sleep(1000);} catch (Exception e){}
            
           return total;   
    }   
}

