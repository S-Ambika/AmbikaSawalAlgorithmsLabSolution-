package com.greatLearning.algorithmLabAssignment.PayMoney;

import java.util.Scanner;

/*
 * PayMoney. processes thousands of transactions daily amounting to crores of Rupees. They
also have a daily target that they must achieve. Given a list of transactions done by
PayMoney and a daily target, your task is to determine at which transaction PayMoney
achieves the same. If the target is not achievable, then display the target is not achieved
 */
public class PayMoneySolutionUsingIteration {

	int i = -1;
	int arr_size, loop_check;
	boolean flag;
	int num_of_txn;
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
			System.out.print(transactionArr[i] + " ");
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
		/*
		 * continue to ask for target value till num of targets are mentioned
		 */
		while (loop_check < target_size) {
			System.out.println("Enter the value of target : ");

			int target_value = sc_input.nextInt();
			/*
			 * check for 0 & negative values
			 */
			if (target_value > 0) {
				pairwiseSum(transactionArr, arr_size, target_value, loop_check + 1);
			} else {
				System.out.println("Enter some valid value");
			}
			loop_check++;
		}

	}

	/*
	 * adding adjacent elements and checking whether target is achieved or not
	 */
	void pairwiseSum(int arr[], int arr_size, int target_value, int target_count) {
		int sum = arr[0];
		for (int i = 0; i + 1 < arr_size; i++) {
			sum = sum + arr[i + 1];
			/*
			 * Checking here to find whether target will be achieved or not
			 */
			if (sum >= target_value) {
				num_of_txn = i + 1;
				flag = true;
				break;
			} else {
				flag = false;
			}
		}
		if (flag)
			System.out.println("Target " + target_count + " is achieved after " + num_of_txn + " transactions");
		else
			System.out.println("Given target is not achieved");

	}

	public static void main(String args[]) {

		PayMoneySolutionUsingIteration paymoneysolution = new PayMoneySolutionUsingIteration();

		paymoneysolution.SolutionImplementation();

	}
}