package com.greatLearning.algorithmLabAssignment.CurrencyDenomination;

public class MergeSortHeper{ 



	 void merging(int[] num, int left, int main, int right)
	   {
	      // finding size of two sub arrays
	      int list1 = main - left + 1;
	      int list2 = right - main;
	      // creating temporary array
	      int[] L = new int[list1];
	      int[] R = new int[list2];
	      // copying data to temporary array
	      for(int a = 0; a < list1; ++a)
	         L[a] = num[left + a];
	      for(int b = 0; b < list2; ++b)
	         R[b] = num[main + 1+ b];
	      // existing index of first and second sub array
	      int p = 0, q = 0;
	      // existing index of merged sub array
	      int r = left;
	      while(p < list1 && q < list2)
	      {
	         if(L[p] <= R[q])
	         {
	        	 num[r] = R[q];
		            q++;
	         }
	         else
	         {
	        	 num[r] = L[p];
		            p++;
	           
	         }
	         r++;
	      }
	      // copying remaining elements of L[] array
	      while(p < list1)
	      {
	         num[r] = L[p];
	         p++;
	         r++;
	      }
	      // copying remaining elements of R[] array
	      while(q < list2)
	      {
	         num[r] = R[q];
	         q++;
	         r++;
	      }
	   }
	   // function that sorts
	public   int[] sort(int[] arrNum, int l, int r)
	   {
	      if(l < r)
	      {
	         // finding middle point
	         int m = (l + r) / 2;
	         // sorting first and second list
	         sort(arrNum, l, m);
	         sort(arrNum , m+1, r);
	         // merging sorted list
	         merging(arrNum, l, m, r);
	      }
		return arrNum;
	   }	


	
}
