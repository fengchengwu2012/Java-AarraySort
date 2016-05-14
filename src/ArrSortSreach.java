 class ArrSortSreach {
	int digit;
	int index;

	@Override
	public String toString() {
		return "ArrSortSreach [digit=" + digit + ", index=" + index + "]";
	}

	/*
	 * ����һ�� getArrSortSreach()�˷����Ĺ����Ǵ���һ��ArrSortSreach��Ķ�������items
	 * item.digit��¼����arr[]��ֵ
	 * item.index��¼arr[]���±�
	 */
	private ArrSortSreach[] getArrSortSreach(int[] arr) {
		ArrSortSreach[] items = new ArrSortSreach[arr.length];
		for (int i = 0; i < items.length; i++) {
			ArrSortSreach item = new ArrSortSreach();
			item.digit = arr[i];
			item.index = i;
			items[i] = item;
		}
		return items;
	}
/*
 * ��ð�����򷨶�ArrSortSreach�������� items[]��digit���Խ�������
 */
	private ArrSortSreach[] sortMaoPao(ArrSortSreach[] items) {
		ArrSortSreach temp ;
		for (int i = 0; i < items.length; i++) {
			for (int j = 0; j <items.length - 1 - i; j++) {
				if (items[j].digit > items[j + 1].digit) {
					temp = items[j] ;
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
		return items;
	}

	public int ZheBanSerach(int[] arr, int key) {
		//����getArrSortSreach()����һ��ArrSortSreach������飺items
		ArrSortSreach[] items = getArrSortSreach(arr);
		ArrSortSreach[] items0=sortMaoPao(items);
		int left = 0;
		int right = items0.length;
		int middle = ((left + right)) / 2;
		while (left <= right) {
			if (key == items0[middle].digit) {
				return items0[middle].index;

			} else if (items0[middle].digit > key) {
				right = middle - 1;
				middle = (left + right) / 2;
			} else {
				left = middle + 1;
				middle = (left + right) / 2;
			}

		}
		return -1;

	}

}
