package blockchain;

import java.util.ArrayList;

public class BlockChain {
	ArrayList<Block> chain;
	public BlockChain(){
		chain = new ArrayList<Block>();
		genesisBlock();
	}

	void genesisBlock() {
		// TODO Auto-generated method stub
		chain.add( new Block(1,23,"hi this is test") );
	}
	
	Block latestBlock(){
		return chain.get(chain.size()-1);
	}
	
	void newBlock(int index, int time, String data){
		Block k = latestBlock();
		Block one=new Block(index,time,data);
		one.previousHash=k.Hash;
		one.Hash=one.mineBlock(6);
		chain.add(one);
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
