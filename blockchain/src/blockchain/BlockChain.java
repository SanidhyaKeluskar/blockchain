package blockchain;

import java.util.ArrayList;

public class BlockChain {
	ArrayList<Block> chain;
	ArrayList<Transactions> pendingTransactions;
	int minerReward;
	public BlockChain(){
		chain = new ArrayList<Block>();
		pendingTransactions= new ArrayList<Transactions>();
		genesisBlock();
		minerReward=100;
	}

	void genesisBlock() {
		// TODO Auto-generated method stub
		chain.add( new Block(1,23,new Transactions(null,null,100)) );
	}
	
	Block latestBlock(){
		return chain.get(chain.size()-1);
	}
	
	void minePendingtransactions(String minerAddress){
		int j=pendingTransactions.size();
		for( int i=0;i<j;i++){
		Block k = latestBlock();
		Block one=new Block(2,23,pendingTransactions.get(i));
		one.previousHash=k.Hash;
		one.Hash=one.mineBlock(2);
		System.out.println("block minded");
		chain.add(one);
		}
		pendingTransactions.clear();
		createTransactions(new Transactions("null",minerAddress,100));
		
	}
	
	void createTransactions(Transactions transaction){
		pendingTransactions.add(transaction);
	}
	
	
	int getBalance(String address){
		int j=chain.size();
		int balance=0;
		for(int i=1;i<j;i++){
		if(chain.get(i).transactions.toAddress.equals(address)){
			balance=balance+chain.get(i).transactions.amount;
		}
		if(chain.get(i).transactions.fromAddress.equals(address)){
			balance=balance-chain.get(i).transactions.amount;
		}
		}
		return balance;
	}
	boolean isValid(){ 
		for(int i=1;i<chain.size();i++){
			Block currentblock=chain.get(i);
			Block previousblock=chain.get(i-1);
			if(currentblock.previousHash!=previousblock.Hash){
				return false;
			}
			if(currentblock.calculateHash().equals(currentblock.Hash)){
		
			}
			else{
				return false;
			}
			

		}
		return true;
	}
	 

}
