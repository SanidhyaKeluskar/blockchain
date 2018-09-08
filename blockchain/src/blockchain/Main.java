package blockchain;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockChain B1=new BlockChain();
		System.out.println(B1.latestBlock().Hash);
		System.out.println("mining block");
		B1.newBlock(1,23,"hi this is not test");
		System.out.println();
		System.out.println(B1.latestBlock().previousHash);
		System.out.println(B1.latestBlock().Hash);
		System.out.println();
		System.out.println("mining block");
		B1.newBlock(1,23,"hi this is not also test");
		System.out.println(B1.latestBlock().previousHash);
		System.out.println(B1.latestBlock().Hash);
		System.out.println(B1.isValid());
	}

}
