package ex1;

import java.util.Random;

import ex1.ThreadController;

public class Threadviewer {
	public static void main(String[] args) {
		int Valores[][] = new int[3][5];
		Random r = new Random();
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 4; j++) {
				Valores[i][j] = r.nextInt(1000);
			}
		}
		for (int i = 0; i <= 2; i++) {
			Thread go = new ThreadController(Valores, i);
			go.start();
		}
	}
}
