package com.zhou;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 4;
		Double d = 4.0;
		String s = "HackerRank ";
		Scanner scan = new Scanner(System.in);
		int j = Integer.parseInt(scan.nextLine());
		double d1 = Double.parseDouble(scan.nextLine());
		String s1 = scan.nextLine();
		
		int sum = i + j;
		double result = d + d1;
		String s2 = s + s1;
		System.out.println(sum);
		System.out.println(result);
		System.out.println(s2);
	}

}
