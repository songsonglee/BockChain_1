package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.ECGenParameterSpec;

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
}
