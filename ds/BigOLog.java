package com.example.ds;

public class BigOLog {

	public static void main(String[] args) {
		logFun(8);
	}
	
	
	private static double logFun(double n) {
		System.out.println(n);
		if (n <= 1) return 0;
		n = Math.floor(n/2);
		return logFun(n);
	}

}
