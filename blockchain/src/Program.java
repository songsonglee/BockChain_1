import java.security.Security;
import java.util.ArrayList;
import blockchain.ui.MainFrame;
import blockchain.core.*;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.Signature;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import util.EC;

public class Program {
	public static void main(String args[]) throws Exception{
		MainFrame mainframe = new MainFrame();
		/*
		Block block1 = new Block(1, null, new ArrayList<Transaction>());
		Block block2 = new Block(2, block1.getBlockHash(), new ArrayList<Transaction>());
		Register test = new Register("���ϱ� ������29�� 27", "���̼�");
		block2.addTransaction(new Transaction(test, "�̰���", 100000000));
		block2.printInfo();
		
	    Security.addProvider(new BouncyCastleProvider());
	    EC ec = new EC();
	    ec.generate("private1.pem", "public1.pem");
	    ec.generate("private2.pem", "public2.pem");
	    // ���� ���·� ������ Ű �����͸� ���α׷����� �ҷ��ɴϴ�.
	    PrivateKey privateKey1 = ec.readPrivateKeyFromPemFile("private1.pem");
	    PublicKey publicKey1 = ec.readPublicKeyFromPemFile("public1.pem");
	    PrivateKey privateKey2 = ec.readPrivateKeyFromPemFile("private2.pem");
	    PublicKey publicKey2 = ec.readPublicKeyFromPemFile("public2.pem");
	    Signature ecdsa;

	    ecdsa = Signature.getInstance("SHA1withECDSA");
	    ecdsa.initSign(privateKey1);
	    String text = "���Դϴ�.";
	    System.out.println("�� ����: " + text);
	    byte[] baText = text.getBytes("UTF-8");
	    // �� �����͸� ��ȣȭ�Ͽ� ������ �����͸� ����մϴ�.
	    ecdsa.update(baText);
	    byte[] baSignature = ecdsa.sign();
	    System.out.println("����� ��: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

	    Signature signature;
	    signature = Signature.getInstance("SHA1withECDSA");

	    // ������ ���� ����Ű 2�� �̿��� ��ȣȭ�� �����մϴ�.
	    signature.initVerify(publicKey2);
	    signature.update(baText);
	    boolean result = signature.verify(baSignature);
	    // ����Ű�� ��Ī�Ǵ� ����Ű�� �ƴϹǷ� ��ȣȭ�� �����մϴ�.
	    System.out.println("�ſ� ����: " + result);
*/
	  }
}
