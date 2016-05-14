public class Crypto {

	// 使用一个预定义的种子(seed)来对要加密内容进行异或运算，解密时只用使用相同的种子
	// 再进行一次异或运算就还原了。
	//
	

	class NumCrypto extends Crypto{
		// 对一个字符串按照指定的数字进行加密
		public String jiaMi(String str, int key) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) {
				sb.append(str.charAt(i) ^ key);
			}
			return sb.toString();
		}

		public String jieMi(String str, int key) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length() / 8; i++) {
				int ss = Integer.parseInt(str.subSequence(i * 8, i * 8 + 8)
						.toString());
				sb.append((char) (ss ^ key));
			}
			return sb.toString();
		}
		
	 
	}
	
	
	class StringCrypto {
	 // 对一个字符串按照指定的字符进行加密
		static final int len = 5;		 //每个字符加密后占5位
		 static final String seed = "asdf";  //加密解密密码
		public String encode(String str) {	// 使用异或进行简单的密码加密
			int[] array = new int[str.length()]; //用来放置加密码后的数据
			String result = "";
			String temp = "";
			for (int i = 0, j = 0; i < str.length(); i++, j++) {
				if (j == seed.length())
					j = 0;
				array[i] = str.charAt(i) ^ seed.charAt(j);	//对每一个字符进行加密
			}
			for (int k = 0; k < str.length(); k++) {	//每个字符加密后占5位
				if (array[k] < 10) {
					temp = "0000" + array[k];
				} else if (array[k]<100) {
					temp = "000" + array[k];
				}else if (array[k]<1000) {
					temp = "00" + array[k];
				}else if(array[k]<10000){
						temp = "0" + array[k];
				}else {
					temp = array[k]+"";
				}
				result += temp;
			}
			return result;
		}
		public String decode(String str) {	// 密码解密，str为加密后的字符
			char[] array = new char[str.length() / len]; //放置解密后的字符
			String result = "";
			for (int i = 0, j = 0; i < str.length() / len; i++, j++) {
				if (j == seed.length())
					j = 0;
				int n = Integer.parseInt(str.substring(i * len, i * len + len));
				array[i] = (char) ((char) n ^ seed.charAt(j)); //异或解密
			}
			for (int k = 0; k < str.length() / len; k++) 
				result += array[k];
			return result;
		}
		
	}

	
	/*"中b国cde人a"
	 * 
	 * @param bytes待截取的字符串转换成的字节数组
	 * @param n用户想要截取的字节数
	 * @return 返回真正截取的字符的个数
	 */
	
	public static int fun(byte[] bytes, int n) {
		int res = 0;
		boolean flag = false;// 表示是半个汉字
		for (int i = 0; i < n; i++) {
			if (bytes[i] < 0 && !flag) {// 半个汉字
				flag = true;
			} else { // 一个完整字符
				res++;
				flag = false;
			}
		}
		return res;
	}


}

	
	


