package dsx.se450;

import java.text.DecimalFormat;

public class Price {
        private long value;
        private  boolean isMarketPrice;
       
        protected Price(long value)
        {
        	this.value=value;
        	this.isMarketPrice=false;
        }
	    protected Price()
	    {
	    	isMarketPrice=true;
	    }
	     public long getValue() throws invalidPriceOperationException
	     {
	        	if(this.isMarket()||this==null)
	        	{
	        		throw new invalidPriceOperationException ("The input is a " + (this == null? "null" : "market price"));
	        	}	        	
	    	 return this.value;
	     }
	    
        public Price add(Price p) throws invalidPriceOperationException
        {
        	return PriceFactory.makeLimitPrice(p.getValue()+this.value);
        }
        
        public Price subtract(Price p) throws invalidPriceOperationException
        {
        	return PriceFactory.makeLimitPrice(this.value-p.getValue());
        }
        
        public Price multiply(int p) 
        {
        	return PriceFactory.makeLimitPrice(p*this.value);
        }
        
        public int compareTo( Price p) throws invalidPriceOperationException
        {
        	if(p.isMarket()||p==null)
        	{
        		throw new invalidPriceOperationException ("The input is a " + (this == null? "null" : "market price"));
        	}	    
        	
        	if( this.value==p.getValue())
        	    return 0;
        	if( this.value>p.getValue())
		    	return 1;
		    else
		    	return -1;
        }
        
	    public boolean greaterOrEqual(Price p) throws invalidPriceOperationException
	    {
	    	return this.compareTo(p)>=0;
	    }
	    
	    public boolean greaterThan(Price p) throws invalidPriceOperationException
	    {	    	
	    	return this.compareTo(p)>0;    			
	    }
	    
	    public boolean lessOrEqual(Price p) throws invalidPriceOperationException
	    {    	
	    	return this.compareTo(p)<=0;			
	    }
	    
	    public boolean equals(Price p) throws invalidPriceOperationException
	    {   	
	    	return this.compareTo(p)==0;   			
	    }
	    
	    public boolean lessThan(Price p)throws invalidPriceOperationException
	    {	    	
	    	return this.compareTo(p)<0;	    			
	    }
	   
	    public boolean isMarket()
	    {
	    	return this.isMarketPrice;
	    }
	    
	    public boolean isNegative()
	    {
	    	if(this.isMarket())
	    	{
	    		return false;
	    	}	    	
	    	return this.value<0;
	    }
	    
	    
	    public String toString()
	    {
	    	if(this.isMarketPrice)
	    	{
	    		return "MKT";
	    	}
	    	
	    	double x = (double)value/100;
	    	DecimalFormat df = new DecimalFormat("#,##0.00");
	        String a =df.format(x);
	        String temp = "$"+a;      
	        return temp;
	    }
	    
	    public static void main (String [] args){
	      Price a = new Price (900);
	      Price b = new Price (900);
	      
	      try {
	    	  a.greaterOrEqual(b);
	    	  System.out.println(" b is greater or equal to a : " + a.greaterOrEqual(b));
	    	  a.greaterThan(b);
		      System.out.println(" b is greater than   a      : " + a.greaterThan(b));
		      a.lessOrEqual(b);
		      System.out.println(" b is less or equal to a    : " + a.lessOrEqual(b));
		      a.lessThan(b);
		      System.out.println(" b is less than      a      : " + a.lessThan(b));
		      a.equals(b);
		      System.out.println(" b is equal to       a      : " + a.equals(b));	    	  
	      }	      
	      catch (invalidPriceOperationException p) {
	    	  System.out.println(" Failure : " + p.getMessage());
	      }
	      
	      	      
	   try {
		   a.add(b);
		   System.out.println(" a + b : " + a.add(b));
		   a.subtract(b);
		   System.out.println(" a - b : " + a.subtract(b));
		   
	   }
	   catch (invalidPriceOperationException s){
		   System.out.println("Failure : " + s.getMessage());		   
	   }
	   

	   System.out.println("Multiply a by 3 : " + a.multiply(3));	
	    }
}