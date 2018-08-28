import java.util.ArrayList;
import blockchain.ui.MainFrame;
import blockchain.core.*;

public class Program {
	public static void main(String args[]) {
	//	MainFrame mainframe = new MainFrame();
		Block block1 = new Block(1, null, new ArrayList<Transaction>());
		Block block2 = new Block(2, block1.getBlockHash(), new ArrayList<Transaction>());
		Register test = new Register("¼ººÏ±¸ º¸¹®·Î29±æ 27", "¿À¹Ì¼÷");
		block2.addTransaction(new Transaction(test, "ÀÌ°æÈÆ", 100000000));
		block2.printInfo();
	
	}
}
