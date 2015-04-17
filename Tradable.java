package dsx.se450;

public interface Tradable {
	
	public String getProduct();
	
	 public Price getPrice();
	 
	 
	 public int getOriginalVolume();
	 
	 public int getRemainingVolume();
	 
	 public int getCancelledVolume();
	 
	 
	 public void setCancelledVolume( int newCancelledVolume) throws Exception;
	 
	 
	 public void setRemainingVolume(int newRemainingVolume) throws Exception;
	 
	 public String getUser();
	 
	 
	 public String getSide();
	 
	 public boolean isQuote();
	 
	 public String getId();
	
	
	
	
	

}
