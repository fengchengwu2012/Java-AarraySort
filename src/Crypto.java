public class Crypto {

	// ʹ��һ��Ԥ���������(seed)����Ҫ�������ݽ���������㣬����ʱֻ��ʹ����ͬ������
	// �ٽ���һ���������ͻ�ԭ�ˡ�
	//
	

	class NumCrypto extends Crypto{
		// ��һ���ַ�������ָ�������ֽ��м���
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
	 // ��һ���ַ�������ָ�����ַ����м���
		static final int len = 5;		 //ÿ���ַ����ܺ�ռ5λ
		 static final String seed = "asdf";  //���ܽ�������
		public String encode(String str) {	// ʹ�������м򵥵��������
			int[] array = new int[str.length()]; //�������ü�����������
			String result = "";
			String temp = "";
			for (int i = 0, j = 0; i < str.length(); i++, j++) {
				if (j == seed.length())
					j = 0;
				array[i] = str.charAt(i) ^ seed.charAt(j);	//��ÿһ���ַ����м���
			}
			for (int k = 0; k < str.length(); k++) {	//ÿ���ַ����ܺ�ռ5λ
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
		public String decode(String str) {	// ������ܣ�strΪ���ܺ���ַ�
			char[] array = new char[str.length() / len]; //���ý��ܺ���ַ�
			String result = "";
			for (int i = 0, j = 0; i < str.length() / len; i++, j++) {
				if (j == seed.length())
					j = 0;
				int n = Integer.parseInt(str.substring(i * len, i * len + len));
				array[i] = (char) ((char) n ^ seed.charAt(j)); //������
			}
			for (int k = 0; k < str.length() / len; k++) 
				result += array[k];
			return result;
		}
		
	}

	
	/*"��b��cde��a"
	 * 
	 * @param bytes����ȡ���ַ���ת���ɵ��ֽ�����
	 * @param n�û���Ҫ��ȡ���ֽ���
	 * @return ����������ȡ���ַ��ĸ���
	 */
	
	public static int fun(byte[] bytes, int n) {
		int res = 0;
		boolean flag = false;// ��ʾ�ǰ������
		for (int i = 0; i < n; i++) {
			if (bytes[i] < 0 && !flag) {// �������
				flag = true;
			} else { // һ�������ַ�
				res++;
				flag = false;
			}
		}
		return res;
	}


}

	
	


