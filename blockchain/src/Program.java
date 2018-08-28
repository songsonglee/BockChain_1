import java.security.Security;
import java.util.ArrayList;
import blockchain.ui.MainFrame;
import blockchain.core.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import util.EC;

public class Program {
	public static void main(String args[]) throws Exception{
	//	MainFrame mainframe = new MainFrame();
		/*
		Block block1 = new Block(1, null, new ArrayList<Transaction>());
		Block block2 = new Block(2, block1.getBlockHash(), new ArrayList<Transaction>());
		Register test = new Register("���ϱ� ������29�� 27", "���̼�");
		block2.addTransaction(new Transaction(test, "�̰���", 100000000));
		block2.printInfo();
		*/
		Security.addProvider(new BouncyCastleProvider());
		
		EC ec = new EC();
		ec.generate("private.pem", "public.pem");
	}
}
