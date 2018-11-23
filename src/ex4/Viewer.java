package ex4;

import java.util.concurrent.Semaphore;

import ex4.ThreadController;

public class Viewer {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for (int i = 1; i <= 100; i++) {
			int ingressos = (int) (1 + Math.random() * 4);
			Thread go = new ThreadController(i, ingressos, semaforo);
			go.start();
		}
	}
}
