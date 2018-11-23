package ex4;

import java.util.concurrent.Semaphore;

public class ThreadController extends Thread {

	static int TotalIngressos = 100;
	Semaphore semaforo;
	private int QuantIngressos;
	private int idThread;
	private int tempo;

	public ThreadController(int idThread, int QuantIngressos, Semaphore semaforo) {
		this.idThread = idThread;
		this.QuantIngressos = QuantIngressos;
		this.semaforo = semaforo;
	}

	public void Login() {
		tempo = (int) (0.4 + Math.random() * 2);
		if (tempo > 1) {
			System.err.println("\nThread #" + idThread + ": Login Timeout");
		} else {
			Compra();
		}
	}

	public void Compra() {
		tempo = (int) (1 + Math.random() * 3);
		if (tempo > 2.5) {
			System.err.println("\nThread #" + idThread + ": Sessão Encerrada por Timeout");
		} else {
			try {
				semaforo.acquire();
				if (QuantIngressos > TotalIngressos) {
					System.err.println("\nThread #" + idThread + ": Quantidade não disponível");
				} else {
					TotalIngressos -= QuantIngressos;
					System.out.println("\nThread #" + idThread + " comprou: " + QuantIngressos
							+ " ingressos\nAssim restando: " + TotalIngressos);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
		}
	}

	@Override
	public void run() {
		Login();
	}

}
