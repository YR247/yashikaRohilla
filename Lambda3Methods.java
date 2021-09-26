package LambdaPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

interface PerformOperation {
	 boolean check(int a);
	}
	class MyMath {
	 public static boolean checker(PerformOperation p, int num) {
	  return p.check(num);
	 }

	   PerformOperation isOdd()
	   {
	       PerformOperation po = (int a)-> a%2 == 0 ? false : true;
	       return po;
	   }
	   PerformOperation isPrime()
	   {
	       PerformOperation po = (int a)->  
	       {
	           if(a == 1) return true;
	           else
	           {
	               for (int i =  2; i < Math.sqrt(a); i++)
	                    if(a%i == 0) return false;
	                return true;
	           }
	       };
	       return po;
	   }
	   PerformOperation isPalindrome()
	   {
	       ArrayList<Integer> array = new ArrayList<>();
	       PerformOperation po = (int a)->
	       {
	            String str = Integer.toString(a);
	           String reverse = "";
	           for(int i = str.length()-1; i >= 0; i--)
	           {
	               reverse = reverse + str.charAt(i);
	           }
	           if(reverse.equals(str)) return true;
	           else
	        	   return false;
	       };
	       return po;
	   }
	}



	public class Lambda3Methods {

	 public static void main(String[] args) throws IOException {
	  MyMath ob = new MyMath();
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  int T = Integer.parseInt(br.readLine());
	  PerformOperation op;
	  boolean ret = false;
	  String ans = null;
	  while (T--> 0) {
	   String s = br.readLine().trim();
	   StringTokenizer st = new StringTokenizer(s);
	   int ch = Integer.parseInt(st.nextToken());
	   int num = Integer.parseInt(st.nextToken());
	   if (ch == 1) {
	    op = ob.isOdd();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "ODD" : "EVEN";
	   } else if (ch == 2) {
	    op = ob.isPrime();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "PRIME" : "COMPOSITE";
	   } else if (ch == 3) {
	    op = ob.isPalindrome();
	    ret = ob.checker(op, num);
	    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

	   }
	   System.out.println(ans);
	  }
	 }
	}
	
//	5       -  no of inputs jo denge hum
//	1 2     -  1 is case of even odd  & 2 is input to be checked
//	EVEN
//	2 5
//	PRIME
//	1 3
//	ODD
//	2 6
//	COMPOSITE
//	3 343
//	PALINDROME