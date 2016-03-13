import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

import com.sun.xml.internal.ws.wsdl.writer.document.FaultType;

public class Question7 {
	
	public Question7() {
		highestBefore(0.01);
		highestBefore(0.5);
		System.out.println(pCollTApprox((int) Math.pow(10, 6), 1178));
//		System.out.println("pCol m=365 n=5: " + pColl((int) Math.pow(10, 6), 10));
	}
	
	private void highestBefore(double p) {
		System.out.println("Computing highest n before " + (int) (p * 100) + "%:");
		double pn = 0;
		int n = 0;
		while (pn < p) {
			n++;
			pn = pCollTApprox((int) Math.pow(10, 6), n);
		}
		n--;
		System.out.println("Highest n before " + (int) (p * 100) + "% is: " + n + "\n");
	}
	
	private BigInteger factorial(int f) {
		long start = System.currentTimeMillis();
		BigInteger acc = BigInteger.valueOf(f);
		for (int i = f - 1; i >= 1; i--) {
			System.out.println(i);
			acc = acc.multiply(BigInteger.valueOf(i));
		}
		long end = System.currentTimeMillis();
		long dt = end - start;
		long dts = dt / 1000;
		System.out.println("Computed " + f + "! in " + dts + " seconds.");
		return acc;
	}
	
	private BigDecimal pColl(int m, int n) {
		return BigDecimal.valueOf(1).subtract(
				new BigDecimal(factorial(m)).divide(
				new BigDecimal(factorial(m - n)).multiply(new BigDecimal(Math.pow(m, n))), 4, RoundingMode.HALF_UP
				));
	}
	
	private double pCollSqApprox(int m, int n) {
		return Math.pow(n, 2) / (2 * m);
	}
	
	private double pCollTApprox(int m, int n) {
		return 1.0 - Math.exp(
					((-1.0 * n) * (n - 1.0)) / (2.0 * m)
				);
	}
	
	public static void main(String[] args) {
		Question7 q7 = new Question7();
	}
	
}
