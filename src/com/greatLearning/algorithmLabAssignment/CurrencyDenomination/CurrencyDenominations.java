package com.greatLearning.algorithmLabAssignment.CurrencyDenomination;

import java.util.Scanner;

/*
 * You are a traveler and traveling to a country where the currency denominations are
unknown and as you travel, you get to know about the denomination in random order.
You want to make a payment of amount x, in such a way that the number of notes you give
is minimum
 */

public class CurrencyDenominations {
	int arr_size;
	int notesArr[], notesCounter[];
	Scanner sc_input = new Scanner(System.in);

	/*
	 * Inserting values in array from User
	 */
	public void insertValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");
			notesArr[i] = sc_input.nextInt();
		}
	}

	/*
	 * Printing values from array
	 */
	public void printValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(notesArr[i] + " ");
		}
		System.out.println();
	}

	/*
	 * implementing solution for Currency Denomination Problem
	 */
	private void SolutionImplementation() {
		System.out.println("Enter the size of denominations array : ");

		/*
		 * taking size of array from user
		 */
		arr_size = sc_input.nextInt();

		notesArr = new int[arr_size]; // providing size to array
		notesCounter = new int[arr_size]; // keeping counter array size same as main array

		System.out.println("Enter the values of array : ");
		insertValues(arr_size);
		printValues(arr_size);
		/*
		 * sorting array using MergeSort implemented in different Helper class calling
		 * method by creating object of Helper class
		 */
		MergeSortHelper mergesortHeper = new MergeSortHelper();
		notesArr = mergesortHeper.sortInDescending(notesArr, 0, arr_size - 1);
		System.out.println("Array sorted in Descending order : ");
		printValues(arr_size);

		System.out.println("Enter input of the amount that you want to pay : ");
		int amt = sc_input.nextInt();
		/*
		 * Checking for minimum combinations
		 */
		checkMinCombination(amt);

	}

	private void checkMinCombination(int amt) {
		try {
			for (int i = 0; i < notesArr.length; i++) {
				if (amt >= notesArr[i]) {
					/*
					 * logic to find number of notes required
					 */
					notesCounter[i] = amt / notesArr[i];
					amt = amt - notesCounter[i] * notesArr[i];
				}
			}
			if (amt > 0) {
				System.out.println("Finding minimum no. of notes is NOT possible with this combinations");
				}
			else {
				// Print min combination of notes
				System.out.println("Your payment approach in order to give min no of notes will be ->");
				for (int i = 0; i < notesCounter.length; i++) {
					if (notesCounter[i] != 0) {
						System.out.println(notesArr[i] + " : " + notesCounter[i]);
					}
				}
			}

		} catch (ArithmeticException e) {

			System.out.println("Invalid values...");
		}
	}

	public static void main(String args[]) {

		CurrencyDenominations currencydenominations = new CurrencyDenominations();
		/*
		 * implemeting method
		 */
		currencydenominations.SolutionImplementation();

	}
}
