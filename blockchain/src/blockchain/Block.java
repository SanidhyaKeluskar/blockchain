package blockchain;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Block {
	int index;
	int time;
	String data;
	String previousHash;
	String Hash;
	public Block(int index, int time, String data){
		this.index=index;
		this.time=time;
		this.data=data;
		this.previousHash="";
		this.Hash=calculateHash();
	}
	
	public String calculateHash(){
		String hashValue="";
		String inputByte= Integer.toString(index)+Integer.toString(time)+data+previousHash;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(inputByte.getBytes());
			byte[] bbytes=md.digest();
			hashValue=DatatypeConverter.printHexBinary(bbytes);
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashValue;
	}

}
