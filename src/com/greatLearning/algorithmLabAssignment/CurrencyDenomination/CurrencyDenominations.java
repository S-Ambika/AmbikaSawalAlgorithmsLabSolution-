package com.greatLearning.algorithmLabAssignment.CurrencyDenomination;

import java.util.Scanner;

public class CurrencyDenominations {
	int i = -1;
	int arr_size, loop_check;
	boolean flag;
	int num = 1;
	int notesArr[],notesCounter[];
	Scanner sc_input = new Scanner(System.in);
	MergeSortHeper mergesortHeper = new MergeSortHeper();

	public void insertValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");

			// if(sc_input.nextInt()>0) {
			notesArr[i] = sc_input.nextInt();
			// }

		}
	}

	public void printValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print( notesArr[i]+" ");
		}
		System.out.println();
	}

	private void SolutionImplementation() {
		System.out.println("Enter the size of denominations array : ");

		arr_size = sc_input.nextInt();

		notesArr = new int[arr_size];
		notesCounter = new int[arr_size];

		System.out.println("Enter the values of array : ");
		insertValues(arr_size);
		printValues(arr_size);
		notesArr = mergesortHeper.sort(notesArr, 0, arr_size - 1);
		System.out.println("Array sorted in Descending order : ");
		printValues(arr_size);

		System.out.println("Enter input of the amount that you want to pay : ");

		int amt = sc_input.nextInt();
		

		checkMinCombination(amt);
		

	}
	
	private void checkMinCombination(int amt) {
		try {
		for (int i = 0; i < 5; i++) {
			if (amt >= notesArr[i]) {
				notesCounter[i] = amt / notesArr[i];
				amt = amt - notesCounter[i] * notesArr[i];
			}
		}
	
		// Print notes
		System.out.println("Currency Count ->");
		for (int i = 0; i <notesCounter.length ; i++) {
			if (notesCounter[i] != 0) {
				System.out.println(notesArr[i] + " : "
					+ notesCounter[i]);
			}
		}
			}catch(ArithmeticException e) {
				
				System.out.println("Invalid values...");
			}
		}
	
	public static void main(String args[]) {

		CurrencyDenominations currencydenominations = new CurrencyDenominations();

		currencydenominations.SolutionImplementation();

	}
}
