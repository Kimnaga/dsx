package dsx.se450;

public class TradableImpl  implements Tradable{
	
	private String userName;
	private String productSymbol;
	private String orderId;
	private String orderSide;
	private Price orderPrice;
	private int originalVolume;
	private int remainingVolume;
	private int cancelledVolume;
	private boolean isQuote; 
	private long currentTime;
	
	
	
	public TradableImpl( String userName,String productSymbol, Price orderPrice, int originalVolume, String orderSide)
	{
		 this.currentTime= System.nanoTime();
		
		this.userName = userName;
		this.productSymbol=productSymbol;
		this.orderPrice= orderPrice;
		this.originalVolume=originalVolume;
		this.remainingVolume= originalVolume;
		this.orderSide =orderSide;
		
		
	}
	

	@Override
	public String getProduct() {
		
		return this.productSymbol;
	}

	@Override
	public Price getPrice() {
		
		return this.orderPrice;
	}

	@Override
	public int getOriginalVolume() {
		
		return originalVolume;
	}

	@Override
	public int getRemainingVolume() {
		
		return remainingVolume;
	}

	@Override
	public int getCancelledVolume() {
		
		return cancelledVolume;
	}

	@Override
	public void setCancelledVolume(int newCancelledVolume) throws Exception{
		
		//this should be changed with the Exception by myself
		if(newCancelledVolume<0||cancelledVolume+remainingVolume>originalVolume)
		{
			throw new Exception(" newCancelledVolume is negative");
		}
		this.cancelledVolume= newCancelledVolume;
		
	}

	@Override
	public void setRemainingVolume(int newRemainingVolume) throws Exception{
		
		//this should be changed with the Exception by myself
				if(newRemainingVolume<0||cancelledVolume+remainingVolume>originalVolume)
				{
					throw new Exception(" newCancelledVolume is negative");
				}
				this.cancelledVolume= newRemainingVolume;
	}
	
	public void setQuote(boolean flag) {
		this.isQuote = flag;
	}

	@Override
	public String getUser() {
		
		return userName;
	}

	@Override
	public String getSide() {
		
		return orderSide;
	}

	@Override
	public boolean isQuote() {
		// TODO Auto-generated method stub
		return isQuote;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return orderId;
	}

}
