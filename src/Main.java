
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String args[]) {
        if(args.length<1){
            System.out.println("Usage: java -jar crawler.jar <categoryNumber>");
            System.exit(0);
        }
        
        List<String> cat=Arrays.asList(args);
        try{
            Variables.init();
            ArrayList<String> list=Variables.returnList();
            for(int i=0;i<list.size();i++){
                String s= (String) list.get(i);
                if(cat.contains(i+"")){
                    String[] tem=s.split("\\{\\}");
                    ASINCrawler crawler=new ASINCrawler(tem[0], tem[1], "");
                    crawler.start();
                }
                
            }
        } catch (Exception e){e.printStackTrace();}
    }
}
