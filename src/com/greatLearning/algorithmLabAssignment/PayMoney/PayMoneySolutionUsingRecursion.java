package com.greatLearning.algorithmLabAssignment.PayMoney;

import java.util.Scanner;

/*
 * PayMoney. processes thousands of transactions daily amounting to crores of Rupees. They
also have a daily target that they must achieve. Given a list of transactions done by
PayMoney and a daily target, your task is to determine at which transaction PayMoney
achieves the same. If the target is not achievable, then display the target is not achieved
 */
public class PayMoneySolutionUsingRecursion {

	int i = -1;
	int arr_size, loop_check;
	boolean flag;
	int num = 1;
	int transactionArr[];
	Scanner sc_input = new Scanner(System.in);

	/*
	 * Inserting values in array from User
	 */
	public void insertValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");

			transactionArr[i] = sc_input.nextInt();

		}
	}

	/*
	 * Printing values from array
	 */
	public void printValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.println("Value at position " + i + "is:" + transactionArr[i]);
		}
		System.out.println();
	}

	/*
	 * implementing solution for PayuMoney Problem
	 */
	private void SolutionImplementation() {
		System.out.println("Enter the size of transaction array : ");

		arr_size = sc_input.nextInt();

		transactionArr = new int[arr_size];

		System.out.println("Enter the values of array : ");
		insertValues(arr_size);
		printValues(arr_size);

		System.out.println("Enter the total no of targets that needs to be achieved : ");

		int target_size = sc_input.nextInt();
		while (loop_check < target_size) { // till no. of target are defined
			System.out.println("Enter the value of target : ");

			int target_value = sc_input.nextInt();
			/*
			 * check for 0 & negative values
			 */
			if (target_value > 0) {
				pairwiseSum(transactionArr, 0, arr_size, target_value, num, transactionArr[0], loop_check + 1);
			} else {
				System.out.println("Enter some valid value");
			}
			loop_check++;
		}

	}

	void pairwiseSum(int arr[], int i, int n, int val, int num, int sum, int target_count) {

		if (i >= n - 1) {
			System.out.println("Given target is not achieved");

		} else {
			try {
				/*
				 * in case target value is equal to value at array[0] position
				 */
				if (val <= arr[0]) {
					System.out.println("Target " + target_count + " is achieved after : " + 1 + " transaction");

				} else {

					sum = sum + arr[i + 1];

					if (sum > val) {

						num = i + 1;
						num++;

						System.out.println("Target " + target_count + " is achieved after : " + num + " transactions");

					} else {
						num++;
						/*
						 * recursion applied for next values
						 */
						pairwiseSum(arr, i + 1, n, val, num, sum, target_count);
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("exc : " + e.getMessage());

			}

		}

	}

	public static void main(String args[]) {

		PayMoneySolutionUsingRecursion paymoneysolution = new PayMoneySolutionUsingRecursion();

		paymoneysolution.SolutionImplementation();

	}

}
