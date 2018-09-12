package blockchain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockChain B1=new BlockChain();
		System.out.println(B1.latestBlock().Hash);
		B1.createTransactions(new Transactions("address1","address2",100));
		B1.createTransactions(new Transactions("address2","address1",20));
		System.out.println("starting to mine");
		B1.minePendingtransactions("address3");
		B1.createTransactions(new Transactions("address2","address1",70));
		B1.minePendingtransactions("address3");
	
		System.out.println(B1.isValid());
		System.out.println(B1.getBalance("address3"));
	}

}
