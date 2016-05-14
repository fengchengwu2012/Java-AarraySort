public class ArraySort {

	/*
	 * bubbleSort()ð������ ����˿�ʼ���Ƚ��������ڵ�Ԫ�أ���ֵ���Ԫ�ؽ������Ҷ�
	 * n>1�ǰ��������У���һ��������ֵ�������һ��λ�ã��ڶ�������ڶ����Ԫ�طŵ������ڶ�λ�ϣ��Դ����� n<1ʱ���������У�
	 */
	public int[] bubbleSort(int[] arr, int n) {
		int temp;
		if (n < 1) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length - 1 - i; j++) {
					if (arr[j] < arr[j + 1]) {
						temp = arr[j + 1];
						arr[j + 1] = arr[j];
						arr[j] = temp;
					}
				}
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length - 1 - i; j++) {
					if (arr[j] > arr[j + 1]) {
						temp = arr[j + 1];
						arr[j + 1] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}

		return arr;
	}

	/*
	 * ѡ������ ����min��Ϊÿ�αȽ���Сֵ���±��� n>1�������У�n<1��������
	 */
	public int[] selecSort(int[] arr, int n) {
		int temp;
		int min = 0;
		if (n < 1) {
			for (int i = 0; i < arr.length; i++) {
				min = i;
				for (int j = i + 1; j < arr.length - 1; j++) {
					if (arr[min] > arr[j])
						min = j;
				}
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				min = i;
				for (int j = i + 1; j < arr.length - 1; j++) {
					if (arr[min] < arr[j])
						min = j;
				}
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;

			}
		}

		return arr;
	}

	/*
	 * �������� ������ĵ�һ��Ԫ��a[0]��ʼ�������һ��Ԫ��a[1]���뵽a[0]��ǰ����ߺ��棬���ż�����һ����;
	 * ÿ�ζ��ǽ�a[i]���뵽�Ѿ�����õ�a[0]~a[i-1]�к��ʵ�λ�� n>1�������У�n<1��������
	 */
	public int[] insertSort(int[] arr, int n) {
		int temp;
		if (n > 1) {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i; j >= 1; j--) {
					if (arr[j] < arr[j - 1]) {
						temp = arr[j - 1];
						arr[j - 1] = arr[j];
						arr[j] = temp;
					} else {
						break;
					}

				}
			}
		} else {
			for (int i = 1; i < arr.length; i++) {
				for (int j = i; j >= 1; j--) {
					if (arr[j] > arr[j - 1]) {
						temp = arr[j - 1];
						arr[j] = arr[j - 1];
						arr[j - 1] = temp;
					} else
						break;
				}
			}
		}

		return arr;
	}
/*
 * �ݹ鷨����
 */
 
	public int[] recuSort(int high){
		    int[] arr=new int[high];
		    int temp=high;
			int iMax=0;  //�������Ԫ�ص��±�
			int max=arr[0];//������Ԫ�ص����ֵ��ʼֵ����Ϊarr[0]
			if(temp>=1){
				for(int i=0;i<temp;i++){
					if(max<arr[i]){
						iMax=i;
						max=arr[i];
					}
				}
			}
			if(max!=arr[temp]){//���arr[high]�������ֵ����ô�Ͱ����ֵarr[iMax]��arr[high]����λ��
				arr[iMax]=arr[temp];
				arr[temp]=max;
				 
			}
			recuSort(temp-1);
			
			return arr;
	}
	
	
	/*
	 * ���ַ����� ���ֲ���ǰ�������� ������������в��� ���ֲ��ҵĻ���˼����: ����ȷ���ò���������м��λ�ã�int mid =
	 * (low+upper) / 2; Ȼ�󽫴����ҵ�ֵ���м��λ�õ�ֵ�Ƚϣ� ����ȣ�����ҳɹ������ش�λ�á�
	 * ���м��λ��ֵ���ڴ���ֵ�����µĲ����������м��λ�õ��������
	 * ���м��λ��ֵС�ڴ���ֵ�����µĲ����������м��λ�õ��ұ�������һ�β���������µĲ���������еġ� key��Ҫ�����ҵ�ֵ
	 */
	public int binSerach(int[] arr, int key) {
	    bubbleSort(arr, 1);
		int temp;
		int lower = 0;
		int uper = arr.length - 1;
		while (lower <= uper) {
			int middle = (lower + uper) / 2;
			if (arr[middle] < key) {
				lower = middle + 1;
			} else if (arr[middle] > key) {
				uper = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
	
	
	
	//���ֲ��ҵĵݹ鷽����recurrence method��
     public int  recuBinSearch(int[] arr,int key,int low,int high){
    	 quickSort(arr, 0, arr.length-1);
    	 if (low > high) {
 			return -1;
 		}
 		int mid = (low + high) / 2;
 		if (arr[mid] == key) {
 			return mid;
 		}
 		if (arr[mid] < key) {
 			 recuBinSearch(arr, low, mid - 1, key);
 		}
 		if (arr[mid] > key) {
 			 recuBinSearch(arr, mid + 1, high, key);
 		}
 		return -1;

     }
	
     /*
      * �õݹ鷨����
      */
     
     public static void  recuSort(int[] arr,int high) {
 		int iMax = 0;//��¼���Ԫ�ص��±�
 		int max = arr[0];  //��¼���Ԫ�ص�ֵ
 		if (high >= 1) {
 			for (int i = 0; i < high; i++) {
 				if (max < arr[i]) {
 					iMax = i;
 					max = arr[i];
 				}
 				if (max != arr[high])
 					arr[iMax] = arr[high];
 				arr[high] = max;
 			}
 			recuSort(arr,high - 1);
 		}

 	}

     
     /*
	 *��������
     * �õݹ�˼��
     *�ҵ�һ�� pivot������һ��ѭ�������� pivot�ĵ���� pivot���ұߣ���С�� pivot�ķ��� pivot�����
     *�ڲ��õݹ�ķ�ʽ��pivot���ߵ�����Ԫ������һ��ѭ���ķ�������
    */
	public void quickSort(int[] arr, int l, int r) {
		//��i�ĳ�ʼֵ��λ����ߣ�����һ������Ԫ��
		int i = l;
		//��j�ĳ�ʼֵ��λ���ұߣ�����������һ����
		int j = r;
		//��֧��pivot��λ��������е㣬
		int pivot = arr[(l + r) / 2];

		while (i <= j) {//����һ��ѭ��
			while (i <= j) {
				if (arr[i] < pivot) {//����߿�ʼ���ң�ֱ���ҵ�һ����pivot�������Ԫ��ͣ����
					i++;
				}

				while (j >= i) {//���ұ߱߿�ʼ���ң�ֱ���ҵ�һ����pivotС������Ԫ��ͣ����
					if (arr[j]> pivot) {
						j--;
					}

					if (i <= j) {//�����ҵ�����ߵ�arr[i]���ұߵ�arr[j]����λ��
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						i++;
						j--;
					}

				}
			}
			
			//��Ϊһ��ѭ����i��j������λ�ã����Եݹ���ж�������i<r��j>l
			if(i<r)//���õݹ��ų�һ��ѭ���������˳��
                quickSort(arr,l,i);
			if(j>l)
				quickSort(arr, j, r);
		}
	}
}
