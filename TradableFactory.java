package dsx.se450;

public class TradableFactory {
	
	 public static TradableImpl build(String userName,String productSymbol, Price orderPrice, int originalVolume, String orderSide)
	    {
		  return new TradableImpl(userName, productSymbol,  orderPrice,  originalVolume,  orderSide);
	    }

}
