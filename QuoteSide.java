package dsx.se450;

public class QuoteSide  implements Tradable{
	 private Tradable delegate;
	// private String orderSide;
	 public QuoteSide(String userName,String productSymbol, Price orderPrice, int originalVolume, String orderSide){
		 delegate=TradableFactory.build(userName, productSymbol,  orderPrice,  originalVolume,  orderSide);
		 
	 }
		@Override
		public String getProduct() {
			// TODO Auto-generated method stub
			return delegate.getProduct();
		}

		@Override
		public Price getPrice() {
			// TODO Auto-generated method stub
			return delegate.getPrice();
		}

		@Override
		public int getOriginalVolume() {
			// TODO Auto-generated method stub
			return delegate.getOriginalVolume();
		}

		@Override
		public int getRemainingVolume() {
			// TODO Auto-generated method stub
			return delegate.getRemainingVolume();
		}

		@Override
		public int getCancelledVolume() {
			// TODO Auto-generated method stub
			return delegate.getCancelledVolume();
		}

		@Override
		public void setCancelledVolume(int newCancelledVolume) throws Exception {
			// TODO Auto-generated method stub
			delegate.setCancelledVolume(newCancelledVolume);
			
		}

		@Override
		public void setRemainingVolume(int newRemainingVolume) throws Exception {
			delegate.setCancelledVolume(newRemainingVolume);
			
		}

		@Override
		public String getUser() {
			// TODO Auto-generated method stub
			return delegate.getUser();
		}

		@Override
		public String getSide() {
			// TODO Auto-generated method stub
			return delegate.getSide();
		}

		@Override
		public boolean isQuote() {
			// TODO Auto-generated method stub
			return delegate.isQuote();
		}

		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return delegate.getId();
		}
		
		
		
		

	}


