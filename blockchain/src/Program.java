import java.util.ArrayList;
import blockchain.ui.MainFrame;
import blockchain.core.*;

public class Program {
	public static void main(String args[]) {
	//	MainFrame mainframe = new MainFrame();
		Block block1 = new Block(1, null, new ArrayList<Transaction>());
		Block block2 = new Block(2, block1.getBlockHash(), new ArrayList<Transaction>());
		Register test = new Register("���ϱ� ������29�� 27", "���̼�");
		block2.addTransaction(new Transaction(test, "�̰���", 100000000));
		block2.printInfo();
	
	}
}
