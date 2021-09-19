package com.greatLearning.algorithmLabPayMoney;

import java.util.Scanner;

public class PayMoneySolution {

	int i=-1;
	int arr_size,j;
boolean flag;
	int transactionArr[];
	 Scanner sc_input = new Scanner(System.in);

	
	public  void insertValues(int size) {
		for (int i = 0; i < size; i++) {
			System.out.print("Enter element at position " + i + "-  ");
			transactionArr[i] = sc_input.nextInt();
		}
	}

	public  void printValues(int size) {
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
		while(j<target_size) {
		//for(int i=0;i<target_size;i++) {
			System.out.println("Enter the value of target : ");

			int target_value = sc_input.nextInt();
			
			pairwiseSum(transactionArr,0,arr_size,target_value,0,transactionArr[0]);
//			int res=checkValueStatus(transactionArr[0],target_value,0);
//			System.out.println("result : "+res);
			//}
			j++;}

		
	}
	

	int pairwiseSum(int arr[], int i, int n, int val, int num, int sum) {
		
//		num=num+1;
		if (i == n) {
			return 0;
		}

		else {

if(val<=arr[0]) {
	
	System.out.println(sum + " : " + " Achieved after :" + 1 + " txns");
	return 2;
	
}
else {
	System.out.println(" val of i : " + sum + ":  i+1 :  " + arr[i + 1]);

			sum = sum + arr[i + 1];
			num=num+2;

				if (sum > val) {

				System.out.println(sum + " : " + " Achieved after :" + num + " txns");
				return 2;
			} else {
//					num=num+1;			
//					num=num+1;

//					System.out.println("last val of i : "+i);
//					System.out.println("last val of num : "+num);

				return pairwiseSum(arr, i + 1, n, val, num+1, sum);
			}
}
			// }

//				System.out.print(sum + " ");

//				System.out.println(" not Achieved");
		}

	}
	
	

	
	
	private int checkValueStatus(int val,int target_value,int num) {
		
		// Java program to find sum of array
		// elements using recursion.

	while(i<arr_size) {
		System.out.println("i : "+i);

			num++;
			i++;

				if (val== target_value) {
					flag=true;
					return 0;
				}
				else if(val>=target_value) {
					flag=true;
System.out.println("After : "+num+" txns");
					 return 1;
				}
				
				else
				System.out.println("i : "+i);

				return (checkValueStatus(transactionArr[i]+transactionArr[i+1],target_value,num));
			
	}
	return -1;
			
		
		
		
	}
	
	public static void main(String args[]) {

		PayMoneySolution paymoneysolution=new PayMoneySolution();
		
		paymoneysolution.SolutionImplementation();
		
	}
	
	
}
