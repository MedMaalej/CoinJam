package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static String printBin(String soFar, long iterations) {
		if (iterations == 0) {
			return soFar;
		} else {
			return printBin(soFar + "0", iterations - 1)
					+ printBin(soFar + "1", iterations - 1);
		}
	}
    
	public static int firstDivisor(long n) {
		for (int i = 2; i <= n - 1; i++) {
			if (n % i == 0)
				return i;

		}
		return 0;
	}

	public static boolean containsNonBinary(String str) {
		for (int k = 0; k < str.length(); k++) {
			if (str.charAt(k) != '1' || str.charAt(k) != '0')
				return false;
		}
		return true;
	}

	public static String convert(String n, int b1, int b2) {
		return Long.toString(Long.parseLong(n, b1), b2);
	}

	public static boolean isPrime(long n) {

		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isJamCoin(String binaryStr) {
		 
		if (containsNonBinary(binaryStr) || binaryStr.charAt(0) != '1'
				|| binaryStr.charAt(binaryStr.length() - 1) != '1') {

			return false;
		}

		long n = Long.parseLong(binaryStr.trim(), 2);

		long actNumber;
		for (int j = 2; j <= 10; j++) {
			// conv = convert(binaryStr, 2,j);

			actNumber = Long.parseLong(binaryStr.trim(), j);
            
			// System.out.println(actNumber);
			if (isPrime(actNumber))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int T;

		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		T = sc.nextInt();
		for (int c = 0; c < T; c++) {
			int N, J;
			do {
				N = sc.nextInt();
				J = sc.nextInt();
			} while (N < 2 || N > 16 || J < 1 || J > 50);
			
			System.out.println("Case #1:");
			int nbJamCoins = 0;
			int it = 0;
			while (nbJamCoins < J) {
				while (it < printBin("", N).length()) {
					String str = printBin("", N).substring(it, it + N);
					if (isJamCoin(str)) {
						nbJamCoins++;
						long actNumber;
						System.out.print(str + " ");
						for (int j = 2; j <= 10; j++) {
							// conv = convert(binaryStr, 2,j);

							actNumber = Long.parseLong(str, j);
                           
							System.out.print(firstDivisor(actNumber) + " ");
							// System.out.println(actNumber);

						}
						System.out.print("\n");
					}
					if (nbJamCoins >= J)
						break;
					
					it += N;
				}
				

			}
		}
	}

}
