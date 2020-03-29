package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import model.Content;
import model.Controller;

public class Main {

	private static Controller c;
	private static final String PATH = "data/incor.txt";
	private static final String OUTPUT = "data/output";
	private static boolean ver = false;

	public static void main(String[] args) {
		c = new Controller();
		try {
			BufferedReader br = new BufferedReader(new FileReader(PATH));
			BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));

			String[] all = br.readLine().split("");
			int p1 = 0;
			int p2 = 0;
			int p3 = 0;
			int i = 0;
			while (i < all.length ) {
				p1 = i;
				p2 = p1+1;
				if (!all[p2].equals("1")) {
					operation1(all[p1], all[p2]);
					i = p2+1;
				} else {
					p3 = p2+1;
					operation0(all[p1], all[p3]);
					i = p3+1;
				}
			}
			br.close();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void operation0(String c1, String c3) {
		if (c1.equalsIgnoreCase("0")) {
			c.addOnMachineC0(new Content(c3 + ""));
			ver = true;
		} else if (c1.equalsIgnoreCase("1")) {
			if (ver == true && c.verifyForAdd() == true) {
				c.addOnMachineC1second(new Content(c3 + ""));
			}else {
				c.addOnMachineC1(new Content(c3 + ""));
			}
			ver = false;
		} else {
			c.addOnMachineC2(new Content(c3 + ""));
			ver = true;
		}
	}

	public static void operation1(String c1, String c2) {
		switch (c1) {
		case "0":
			if (c2.equalsIgnoreCase("0")) {
				System.out.println(c.readOnMachineC0());
			} else {
				c.removeOnMachineC0();
			}
			break;
		case "1":
			if (c2.equalsIgnoreCase("0")) {
				System.out.println(c.readOnMachineC1());
			} else {
				c.removeOnMachineC1();
			}
			break;
		case "2":
			if (c2.equalsIgnoreCase("0")) {
				System.out.println(c.readOnMachineC2());
			} else {
				c.removeOnMachineC2();
			}
			break;
		}
	}
}
