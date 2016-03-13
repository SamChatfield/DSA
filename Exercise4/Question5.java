import java.util.Hashtable;
import java.util.Scanner;

public class Question5 {
	
	private final Hashtable<Character, Integer> mapper;
	private boolean running;
	
	public Question5(String[] list) {
		mapper = new Hashtable<>(26);
		char[] ab = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for (int i = 0; i < ab.length; i++) {
			mapper.put(ab[i], i);
		}
	}
	
	public void run() {
		Scanner in = new Scanner(System.in);
		running = true;
		while (running) {
			System.out.println("Please enter a string to hash or quit to stop:");
			String str = in.nextLine().toLowerCase();
			
			if (str.equals("quit")) {
				System.out.println("Now quitting");
				running = false;
			} else {
				System.out.println("The returned hash value for '" + str + "' is: " + hash(str));
				System.out.println();
			}
		}
		in.close();
		System.exit(0);
	}
	
	private int hash(String str) {
		char[] chars = str.toCharArray();
		int sum = 0;
		for (char c : chars) {
			sum += mapper.get(c);
		}
		return sum % 13;
	}
	
	public static void main(String[] args) { // args is list of strings to hash
		Question5 q5 = new Question5(args);
		q5.run();
	}
	
}
