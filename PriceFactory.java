package dsx.se450;
import java.util.*;

public class PriceFactory {
	static private HashMap<Long, Price> hm = new HashMap<>();
	static Price marketPrice = new Price();
	
    public static Price makeLimitPrice(String value)
    {
    	 
 		value =value.replaceAll("[$,]","");
     	double a =Double.parseDouble(value);
     
     	if(value.contains("."))
 		{
     	a=a*100;

 		}
 		long x= (long)a;		
    	return makeLimitPrice(x);
    }
    
    public static Price makeLimitPrice(long value)
    {
    	if(hm.containsKey(value))
     	   return hm.get(value);
     	else
     	{
     		Price a = new Price(value);
     		hm.put(value,a);
     		return a;
     	}
    }
    
    public static Price makeMarketPrice()
    {
    	return marketPrice;
    }
}
