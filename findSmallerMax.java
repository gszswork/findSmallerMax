/*
 *  author:gszswork
 *  Question:Given a number 'X', output the largest number smaller than the number 'X' that can be obtained
 *  by swapping different bits of the number.
 *  Example: input: 21345   output: 12543
 *  Idea: 从数字个位开始向前扫描，如果存在某一位数值小于前一位，则交换这两位，并且将已扫描的部分翻转后添加到交换的两位后面。
 *  考虑到题目对于数字的限制是数字的位数在1000以内，直接采用char来表示每一位，程序只对char和String进行操作会更加方便。
 */
import java.util.Scanner;
public class findSmallerMax {
	public static void reSort(char[] arr,int index) {
		//给定char数组arr，将索引index之后的部分翻转并且print
		char [] list = new char[arr.length - index -1];
		for(int i=0; i<list.length; i++) {
			list[i] = arr[index + i +1];
		}
		char temp;
		for(int i=0; i< list.length/2; i++) {
			temp = list[i];
			list[i] = list[list.length - i -1];
			list[list.length - i -1] = temp;
		}
		for (int i=0; i<list.length; i++) {
			arr[index + i +1] = list[i];
		}
		//System.out.println(arr.length);
		for(int i=0; i<arr.length; i++) 
			System.out.print(arr[i]);
			
	}
	public static void main(String agrs[]) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		char[] arr = str.toCharArray();
		int length = arr.length;
		int changeIndex = -1;
		for(int i=length-1; i>0; i--) {
			if(arr[i] < arr[i-1]) {
				char temp = arr[i];
				arr[i] = arr[i-1];
				arr[i-1] = temp;
				changeIndex = i;
			}
		}
		if(changeIndex != -1)
			findSmallerMax.reSort(arr, changeIndex);
		else 
			for(int i=0; i<arr.length;i++)
				System.out.print(arr[i]);
	}
}
