public class ArraySort {

	/*
	 * bubbleSort()冒泡排序法 从左端开始，比较两个相邻的元素，将值大的元素交换至右端
	 * n>1是按升序排列，第一次求出最大值放在组后一个位置，第二次求出第二大的元素放到倒数第二位上，以此类推 n<1时按降序排列；
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
	 * 选择排序法 定义min作为每次比较最小值的下标标记 n>1升序排列，n<1降序排列
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
	 * 插入排序 从数组的第一个元素a[0]开始，将其后一个元素a[1]插入到a[0]的前面或者后面，接着继续这一过程;
	 * 每次都是将a[i]插入到已经排序好的a[0]~a[i-1]中合适的位置 n>1升序排列，n<1降序排列
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
 * 递归法排序
 */
 
	public int[] recuSort(int high){
		    int[] arr=new int[high];
		    int temp=high;
			int iMax=0;  //放置最大元素的下标
			int max=arr[0];//将数组元素的最大值初始值设置为arr[0]
			if(temp>=1){
				for(int i=0;i<temp;i++){
					if(max<arr[i]){
						iMax=i;
						max=arr[i];
					}
				}
			}
			if(max!=arr[temp]){//如果arr[high]不是最大值，那么就把最大值arr[iMax]和arr[high]调换位置
				arr[iMax]=arr[temp];
				arr[temp]=max;
				 
			}
			recuSort(temp-1);
			
			return arr;
	}
	
	
	/*
	 * 二分法查找 二分查找前提条件： 已排序的数组中查找 二分查找的基本思想是: 首先确定该查找区间的中间点位置：int mid =
	 * (low+upper) / 2; 然后将待查找的值与中间点位置的值比较： 若相等，则查找成功并返回此位置。
	 * 若中间点位置值大于待查值，则新的查找区间是中间点位置的左边区域。
	 * 若中间点位置值小于待查值，则新的查找区间是中间点位置的右边区域。下一次查找是针对新的查找区间进行的。 key是要被查找的值
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
	
	
	
	//二分查找的递归方法（recurrence method）
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
      * 用递归法排序
      */
     
     public static void  recuSort(int[] arr,int high) {
 		int iMax = 0;//记录最大元素的下标
 		int max = arr[0];  //记录最大元素的值
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
	 *快速排序法
     * 用递归思想
     *找到一个 pivot，经过一轮循环将大于 pivot的点放在 pivot的右边，将小于 pivot的放在 pivot的左边
     *在采用递归的方式将pivot两边的数组元素依照一轮循环的方法排序
    */
	public void quickSort(int[] arr, int l, int r) {
		//将i的初始值定位在左边，即第一个数组元素
		int i = l;
		//将j的初始值定位在右边，即数组的最后一个数
		int j = r;
		//将支点pivot定位在数组的中点，
		int pivot = arr[(l + r) / 2];

		while (i <= j) {//做第一轮循环
			while (i <= j) {
				if (arr[i] < pivot) {//从左边开始查找，直到找到一个比pivot大的数组元素停下来
					i++;
				}

				while (j >= i) {//从右边边开始查找，直到找到一个比pivot小的数组元素停下来
					if (arr[j]> pivot) {
						j--;
					}

					if (i <= j) {//将查找到的左边的arr[i]和右边的arr[j]交换位置
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
						i++;
						j--;
					}

				}
			}
			
			//因为一轮循环后，i和j交换了位置，所以递归的判断条件是i<r，j>l
			if(i<r)//利用递归排除一轮循环后的数组顺序
                quickSort(arr,l,i);
			if(j>l)
				quickSort(arr, j, r);
		}
	}
}
