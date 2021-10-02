package DP;

public class rodCutting {

	public static void main(String[] args) {

		int[] price = { 0, 3, 5, 8, 9, 10, 17, 17, 20 };

		System.out.println(RodCutRecursion(price, price.length - 1));
		System.out.println(RodCutTD(price, price.length - 1, new int[price.length]));
		System.out.println(RodCutBU(price));

	}

	public static int RodCutRecursion(int[] price, int n) {

		int left = 1;
		int right = n - 1;

		int max = price[n];

		while (left <= right) {

			int fp = RodCutRecursion(price, left);
			int sp = RodCutRecursion(price, right);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;

		}

		return max;
	}

	private static int RodCutTD(int[] price, int n, int[] strg) {

		if (strg[n] != 0)
			return strg[n];

		int left = 1;
		int right = n - 1;

		int max = price[n];

		while (left <= right) {

			int fp = RodCutTD(price, left, strg);
			int sp = RodCutTD(price, right, strg);

			int total = fp + sp;

			if (total > max)
				max = total;

			left++;
			right--;

		}

		strg[n] = max;

		return max;
	}

	private static int RodCutBU(int[] price) {

		int[] strg = new int[price.length];

		strg[0] = price[0];
		strg[1] = price[1];

		for (int n = 2; n <= strg.length - 1; n++) {

			int left = 1;
			int right = n - 1;

			int max = price[n];

			while (left <= right) {

				int fp = strg[left];
				int sp = strg[right];

				int total = fp + sp;

				if (total > max)
					max = total;

				left++;
				right--;

			}

			strg[n] = max;
		}

		return strg[strg.length - 1];
	}

}
