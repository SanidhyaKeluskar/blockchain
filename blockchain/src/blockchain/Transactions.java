package blockchain;

public class Transactions {
	String fromAddress;
	String toAddress;
	int amount;
	Transactions(String fromAddress,String toAddress, int amount){
		this.fromAddress= fromAddress;
		this.toAddress= toAddress;
		this.amount= amount;
	}

}
