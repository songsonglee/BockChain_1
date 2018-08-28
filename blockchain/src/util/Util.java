package util;

import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Date;

public class Util {
	public enum chType { MAKE_CONTRACT, CHANGE_OWNER }
	public static String getHash(String input) {
		StringBuffer result = new StringBuffer();
		
		try {
			MessageDigest enc = MessageDigest.getInstance("SHA-256");
			enc.update(input.getBytes());
			byte bytes[] = enc.digest();
			for(int i = 0; i < bytes.length; i++) {
				result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	//현재 날짜를 yyyy/mm/dd 형식의 문자열로 바꿔주는 함수
	public static String getDate() {
		Calendar cal = Calendar.getInstance();
		String year = new Integer(cal.get(Calendar.YEAR)).toString();
		String month = new Integer(cal.get(Calendar.MONTH)).toString();
		String date = new Integer(cal.get(Calendar.DAY_OF_MONTH)).toString();
		return year + "." + month + "." + date;
	}
}
