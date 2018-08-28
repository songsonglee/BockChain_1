package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.Key;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

/*
 * 개인키, 공개키 정보를 읽어서 file에 쓰는 역할
 */
public class Pem {
	private PemObject pemObject;
	
	public Pem(Key key, String description) {
		this.pemObject = new PemObject(description, key.getEncoded());
	}
	
	public void write(String filename) throws FileNotFoundException, IOException{
		PemWriter pemWriter = new PemWriter(new OutputStreamWriter(new FileOutputStream(filename)));
		try {
			pemWriter.writeObject(this.pemObject);
		}finally {
			pemWriter.close();
		}
	}
}
