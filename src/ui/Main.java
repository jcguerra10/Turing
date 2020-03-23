package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int c0;
	static int c1;
	static int c2;

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String lect;

			lect = br.readLine();
			String[] s;
			while (lect != null) {
				s = lect.split("");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
