package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.util.encoders.Base64;
/*
 * Ÿ�� � ��ȣȭ�� �̿��� ����, ����Ű�� ������ �����ϴ� ����
 */

public class EC {
	private final String ALGORITHM = "sect163k1";

	public void generate(String privateKeyName, String publicKeyName) throws Exception{
		KeyPairGenerator generator = KeyPairGenerator.getInstance("ECDSA", "BC");
		ECGenParameterSpec ecsp;
		ecsp = new ECGenParameterSpec(ALGORITHM);
		generator.initialize(ecsp, new SecureRandom());
		
		KeyPair keyPair = generator.generateKeyPair();
		System.out.println("Ÿ��� ��ȣŰ �ѽ� ����");
		
		PrivateKey prvKey = keyPair.getPrivate();
		PublicKey pubKey = keyPair.getPublic();
		
		writePemFile(prvKey, "EC PRIVATE KEY", privateKeyName);
		writePemFile(pubKey, "EC PUBLIC KEY", publicKeyName);
	}
	private void writePemFile(Key key, String description, String filename) throws FileNotFoundException, IOException{
		Pem pemFile = new Pem(key, description);
		pemFile.write(filename);
		System.out.println(String.format("EC ��ȣŰ %s�� %s ���Ͽ� ����", description, filename));
	}
	public PrivateKey readPrivateKeyFromPemFile(String privateKeyName) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		String data = readString(privateKeyName);
		System.out.println("EC ����Ű��" + privateKeyName + "���� �о�Խ��ϴ�.");
		System.out.print(data);
		
		data = data.replaceAll("-----BEGIN EC PRIVATE KEY-----", "");
		data = data.replaceAll("-----END EC PRIVATE KEY-----", "");
		byte[] decoded = Base64.decode(data);
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
		KeyFactory factory = KeyFactory.getInstance("ECDSA");
		PrivateKey privateKey = factory.generatePrivate(spec);
		return privateKey;
	}
	
	public PublicKey readPublicKeyFromPemFile(String publicKeyName) throws FileNotFoundException, IOException, NoSuchAlgorithmException, InvalidKeySpecException{
		String data = readString(publicKeyName);
		System.out.println("EC ����Ű��" + publicKeyName + "���� �о�Խ��ϴ�.");
		System.out.print(data);
		
		data = data.replaceAll("-----BEGIN EC PUBLIC KEY-----", "");
		data = data.replaceAll("-----END EC PUBLIC KEY-----", "");
		
		byte[] decoded = Base64.decode(data);
		X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
		KeyFactory factory = KeyFactory.getInstance("ECDSA");
		PublicKey publicKey = factory.generatePublic(spec);
		return publicKey;
	}
	
	private String readString(String filename) throws FileNotFoundException, IOException{
		String pem = "";
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		while((line = br.readLine()) != null)
			pem  += line + "\n";
		br.close();
		return pem;
	}
}
