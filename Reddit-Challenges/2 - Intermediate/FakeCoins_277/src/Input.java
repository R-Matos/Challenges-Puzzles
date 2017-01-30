	/**
	 * Class holds user input for each scale state.
	 */
	public class Input {
		
		private String left;
		private String right;
		private String balance;
		
		
		public String getLeft() {
			return left;
		}
		public void setLeft(String left) {
			this.left = left;
		}
		public String getRight() {
			return right;
		}
		public void setRight(String right) {
			this.right = right;
		}
		public String getBalance() {
			return balance;
		}
		public void setBalance(String balance) {
			this.balance = balance;
		}
		
		@Override
		public String toString() {
			return this.left +", "+ this.right +", "+ this.balance;
		}
		
		
		/**
		 * Constructor
		 * 
		 * @param leftSide String containing coins on left side of scale
		 * @param rightSide String containing coins on right side of scale
		 * @param balanceState Which side scale is leaned towards. Left/Right/Equal(balanced)
		 */
		public Input(String leftSide, String rightSide, String balanceState) {
			this.left = leftSide;
			this.right = rightSide;
			this.balance = balanceState;
		}
		
	}