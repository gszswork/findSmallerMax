/*
 *  author:gszswork 
 *  Question:Given a number 'X', output the largest number smaller than the number 'X' that can be obtained
 *  by swapping different bits of the number.
 *  Example: input: 21345   output: 12543
 *  Idea: 从数字个位开始向左扫描，当存在某一位（设x）小于上一位（y），例如yx567，则从已扫描的部分中找到小于上一位（y）且最大的数z，交换y与该数，然后将
 *  后边的部分倒序排序后接在交换后z所在的位后边。
 */
import java.util.Scanner;
public class findSmallerMax {
	public static int smallerMax(char[] arr) {
		//找到比上一位小的那一位，并且交换该位的上一位与已扫描中符合要求（smallerMax）的一位。返回交换的坐标
		for(int i=arr.length-1; i>0; i--) {
			if(arr[i] < arr[i-1]) {
				char temp = arr[i-1];
				char max = '0';
				int maxIndex = 0;
				for(int j=i;j<arr.length;j++) 
					if(arr[j] >= max && arr[j]<temp) {
						max = arr[j];
						maxIndex = j;
					}
				arr[i-1] = arr[maxIndex];
				arr[maxIndex] = temp;
				return i;
			}
		}
		return -1;
	}
	public static void reSort(char[] arr,int index) {
		//根据smallerMax中提供的交换坐标，将坐标之后的部分反转。
		char[] list = new char[arr.length-index];
		for(int i=index; i<arr.length;i++) {
			list[i-index] = arr[i];
		}
		for(int i=0; i<list.length/2; i++) {			//注意这里应该在length/2的时候结束循环，否则会再换回去
			char temp = list[i];
			list[i] = list[list.length-i-1];
			list[list.length-i-1] = temp;
		}
		for(int i=0; i<list.length; i++) 
			arr[index+i] = list[i]; 
	}
	public static void main(String agrs[]) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char[] arr = str.toCharArray();
		int index = findSmallerMax.smallerMax(arr);
		if(index != -1) 
			findSmallerMax.reSort(arr, index);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
		}
	}
}
