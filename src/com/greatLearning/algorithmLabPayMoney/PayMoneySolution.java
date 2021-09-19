package com.greatLearning.algorithmLabPayMoney;

import java.util.Scanner;

public class PayMoneySolution {

	int i = -1;
	int arr_size, loop_check;
	boolean flag;
	int num = 1;
	int transactionArr[];
	Scanner sc_input = new Scanner(System.in);

	public void insertValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");
			transactionArr[i] = sc_input.nextInt();
		}
	}

	public void printValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.println("Value at position " + i + "is:" + transactionArr[i]);
		}
		System.out.println();
	}

	private void SolutionImplementation() {
		System.out.println("Enter the size of transaction array : ");

		arr_size = sc_input.nextInt();

		transactionArr = new int[arr_size];

		System.out.println("Enter the values of array : ");
		insertValues(arr_size);
		printValues(arr_size);

		System.out.println("Enter the total no of targets that needs to be achieved : ");

		int target_size = sc_input.nextInt();
		while (loop_check < target_size) {
			// for(int i=0;i<target_size;i++) {
			System.out.println("Enter the value of target : ");

			int target_value = sc_input.nextInt();
			// System.out.println("loop : "+loop_check);

			pairwiseSum(transactionArr, 0, arr_size, target_value, num, transactionArr[0], loop_check + 1);
//			int res=checkValueStatus(transactionArr[0],target_value,0);
			// }
			// num++;
			loop_check++;
		}

	}

	void pairwiseSum(int arr[], int i, int n, int val, int num, int sum, int target_count) {

//		num=num+1;
//		System.out.println(" val of i : "+i);
//		System.out.println(" val of num : "+num);

		if (i >= n - 1) {
			System.out.println("Given target is not achieved");
			// return 0;

		}

		else {

			try {
				if (val <= arr[0]) {

					System.out.println("Target " + target_count + " is achieved after : " + 1 + " transaction");
					// return 2;

				} else {

					// System.out.println(" val of prev : " + sum + ": next : " + arr[i + 1]);

					sum = sum + arr[i + 1];
					// System.out.println(" val inside sum : " + sum );
//				System.out.println("^^^^^^^^^^ val inside i : " + i );

//				num = num + 2;

					if (sum > val) {

						num = i + 1;
						num++;

						System.out.println("Target " + target_count + " is achieved after : " + num + " transactions");

					} else {
//					num=num+1;			
//					num=num+1;

//					System.out.println("last val of i : "+i);
//					System.out.println("last val of num : "+num);
//					num=num+1;
						num++;
						pairwiseSum(arr, i + 1, n, val, num, sum, target_count);
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("exc : " + e.getMessage());

			}
			// }

//				System.out.print(sum + " ");

//				System.out.println(" not Achieved");
		}

	}

	public static void main(String args[]) {

		PayMoneySolution paymoneysolution = new PayMoneySolution();

		paymoneysolution.SolutionImplementation();

	}

}
