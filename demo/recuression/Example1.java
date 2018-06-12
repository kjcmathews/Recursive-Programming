package demo.recuression;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Example1 {

	private static int count = 0;

	public static void main(String[] args) {
		Exampl1 exampl1 = new Exampl1();

		// print n star
		exampl1.printStar(10);
		// power printing
		System.out.println(exampl1.power(2, 4));
		// isPalandrom
		System.out.println(exampl1.isPalindrome("asa"));
		// binary
		exampl1.printBinary(205);
		// crawl Directory
		System.out.println();
		System.out.println("----- printing file content -----");
		exampl1.crawlDirec(new File("D:/persoal _test/python"), "    ");

		// binary Search
		int a[] = { 1, 2, 3, 5, 6, 7 };
		System.out.println(exampl1.BinarySearch(6, a));

		// print all binary of a given number
		exampl1.printGivenBinaryNumberDigit(3, "");

		exampl1.printGivenDecimalNumberDigit(2, "");

		exampl1.diceRoll(2, new LinkedList<Integer>());
		exampl1.diceSum(4, new LinkedList<>(), 10, 0);

		exampl1.rearrangeString("joe");
	}

	/**
	 * just printing n element as '*'
	 * 
	 * @param n
	 */
	void printStar(int n) {
		// base Case
		if (n == 1) {
			System.out.print("*");
		} else {
			System.out.print("*");
			// print remaining n-1 '*'
			printStar(n - 1);
		}

	}

	/**
	 * printing power of a given number
	 * 
	 * @param base
	 * @param power
	 * @return
	 */
	int power(int base, int power) {
		if (power == 0) {
			return 1;
		} else {
			// 3^7==3^6 * 3^1
			return base * power(base, power - 1);
		}
	}

	/**
	 * checks is given string is palindrome
	 * 
	 * @param string
	 * @return boolean
	 */
	boolean isPalindrome(String string) {

		if (string.length() > 1) {
			return true;
		}

		char first = string.charAt(0);
		char last = string.charAt(string.length() - 1);
		if (first == last) {
			String str = string.substring(1, string.length() - 1);
			return isPalindrome(str);
		} else {
			return false;
		}
	}

	/**
	 * print binary of a number
	 * 
	 * @param n
	 */
	void printBinary(int n) {
		if (n < 2) {
			System.out.print(n);

		} else {
			int cb = n % 2;
			int q = n / 2;
			printBinary(q);
			System.out.print(cb);
		}
	}

	/**
	 * Crawl into the given folder with intents
	 * 
	 * @param folder
	 * @param intent
	 */
	void crawlDirec(final File folder, String intent) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				System.out.println(intent + fileEntry.getName());
				crawlDirec(fileEntry, intent + "     ");
			} else {
				System.out.println(intent + fileEntry.getName());
			}
		}
	}

	/**
	 * Binary Search worst case O(log n)
	 *  
	 * @param num
	 * @param arr
	 * @return element at index
	 */
	int BinarySearch(int num, int arr[]) {
		int orignalindex = 0;
		if (num < arr[arr.length / 2]) {
			orignalindex = arr.length / 2;
		} else if (num == arr[arr.length / 2]) {
			return arr.length / 2;
		}
		return BinarySearchByIndex(num, arr, orignalindex);
	}

	private int BinarySearchByIndex(int num, int[] arr, int orignalindex) {
		// {1,2,3 ,4,5};
		int length = arr.length;
		int midIndex = length / 2;
		if (midIndex == 0) {
			return -1;
		}
		if (arr[midIndex] == num) {
			return orignalindex + 1;
		} else if (arr[midIndex] > num) {
			orignalindex -= midIndex;
			return BinarySearchByIndex(num, Arrays.copyOfRange(arr, 0, midIndex), orignalindex);
		} else if (arr[midIndex] < num) {
			orignalindex += midIndex;
			return BinarySearchByIndex(num, Arrays.copyOfRange(arr, midIndex, length), orignalindex);
		} else {
			return -1;
		}
	}

	/**
	 * print all binary for given digits 
	 * @param numDigits
	 * @param intent
	 */
	void printGivenBinaryNumberDigit(int numDigits, String intent) {
		// System.out.println("num==>"+numDigits+"intent==>"+intent);
		if (numDigits <= 0) {
			System.out.println(intent);
		} else {
			printGivenBinaryNumberDigit(numDigits - 1, intent + 0);
			printGivenBinaryNumberDigit(numDigits - 1, intent + 1);
		}
	}

	/**
	 * print all decimal number of given digits
	 * 
	 * @param numDigits
	 * @param prefix
	 */
	void printGivenDecimalNumberDigit(int numDigits, String prefix) {
		if (numDigits <= 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i <= 9; i++) {
				printGivenDecimalNumberDigit(numDigits - 1, prefix + i);
			}
		}
	}

	/**
	 * dice roll n number of Dice
	 * 
	 * @param numberOfDice
	 * @param currentDice
	 */
	void diceRoll(int numberOfDice, LinkedList<Integer> currentDice) {
		//System.out.println("numberOfDice===>" + numberOfDice + "," + "currentDice===>" + currentDice);
		if (numberOfDice <= 0) {
			System.out.println(currentDice);
		} else {
			for (int i = 1; i <= 6; i++) {
				currentDice.add(i);
				diceRoll(numberOfDice - 1, currentDice);
				//System.out.println("currentDice.remove===>" + currentDice.getLast());
				currentDice.removeLast();
			}
		}
	}

	/**
	 * sum of the Dice rolled
	 * 
	 * @param numDice
	 * @param chosenDiceLsit
	 * @param requiredSum
	 * @param totalSum
	 */
	void diceSum(int numDice, LinkedList<Integer> chosenDiceLsit, int requiredSum, int totalSum) {
		if (numDice <= 0) {
			System.out.println(chosenDiceLsit);
			System.out.println(totalSum);
			if (totalSum == requiredSum) {
				count++;
			}
			System.out.println("count=========>" + count);

		} else {
			totalSum = +totalSum;

			for (int j = 1; j <= 6; j++) {
				if (totalSum + j <= requiredSum) {
					chosenDiceLsit.add(j);
					diceSum(numDice - 1, chosenDiceLsit, requiredSum, totalSum + j);
					chosenDiceLsit.removeLast();
				}
			}

			totalSum = 0;
		}

	}

	/**
	 * all possible character formed from the give string
	 * 
	 * @param charecter
	 */
	void rearrangeString(String charecter) {

		char arr[] = charecter.toCharArray();
		HashSet aad = new HashSet<>();
		rearrangeStringList(arr, arr.length - 1, aad);
		System.out.println(aad);

	}

	private void rearrangeStringList(char[] cs, int num, HashSet listvalue) {
		if (num > 0) {
			for (int i = 0; i < cs.length; i++) {
				char chosen = cs[i];
				char temp = cs[num];
				cs[i] = temp;
				cs[num] = chosen;

				// if(!listvalue.contains(new String(cs))){
				listvalue.add(new String(cs));
				rearrangeStringList(cs, num - 1, listvalue);
				// }
				char temp2 = cs[i];
				char chosen2 = cs[num];
				cs[i] = chosen2;
				cs[num] = temp2;
			}

		}
	}
}
