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
		Register test = new Register("성북구 보문로29길 27", "오미숙");
		block2.addTransaction(new Transaction(test, "이경훈", 100000000));
		block2.printInfo();
		
	    Security.addProvider(new BouncyCastleProvider());
	    EC ec = new EC();
	    ec.generate("private1.pem", "public1.pem");
	    ec.generate("private2.pem", "public2.pem");
	    // 파일 형태로 저장한 키 데이터를 프로그램으로 불러옵니다.
	    PrivateKey privateKey1 = ec.readPrivateKeyFromPemFile("private1.pem");
	    PublicKey publicKey1 = ec.readPublicKeyFromPemFile("public1.pem");
	    PrivateKey privateKey2 = ec.readPrivateKeyFromPemFile("private2.pem");
	    PublicKey publicKey2 = ec.readPublicKeyFromPemFile("public2.pem");
	    Signature ecdsa;

	    ecdsa = Signature.getInstance("SHA1withECDSA");
	    ecdsa.initSign(privateKey1);
	    String text = "평문입니다.";
	    System.out.println("평문 정보: " + text);
	    byte[] baText = text.getBytes("UTF-8");
	    // 평문 데이터를 암호화하여 서명한 데이터를 출력합니다.
	    ecdsa.update(baText);
	    byte[] baSignature = ecdsa.sign();
	    System.out.println("서명된 값: 0x" + (new BigInteger(1, baSignature).toString(16)).toUpperCase());

	    Signature signature;
	    signature = Signature.getInstance("SHA1withECDSA");

	    // 검증할 때는 공개키 2를 이용해 복호화를 수행합니다.
	    signature.initVerify(publicKey2);
	    signature.update(baText);
	    boolean result = signature.verify(baSignature);
	    // 개인키와 매칭되는 공개키가 아니므로 복호화에 실패합니다.
	    System.out.println("신원 검증: " + result);
*/
	  }
}
