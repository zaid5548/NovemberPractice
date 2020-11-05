package Stack_Problem;

public class nextGreater extends Stack_1 {

	public static void main(String[] args) throws Exception {
		int[] arr = { 1, 5, 2, 3, 6, 10, 9 };
		Stack_1 s = new Stack_1();
		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > s.peek()) {
				int temp = s.pop();
				System.out.println(temp + "-->" + arr[i]);
			}
			s.push(arr[i]);

		}
		while (!s.isEmpty()) {
			int temp = s.pop();
			System.out.println(temp + "-->" + "-1");
		}

	}

}
