package ex1;

public class ThreadController extends Thread{
	private int Valores[][] = new int[3][5];
	private int idThread;
	private int Soma = 0;
	
	public ThreadController(int Val[][], int idThread){
		this.idThread = idThread;
		this.Valores = Val;
	}
	
	public void fazSoma(){
		for (int i = 0; i <= 4; i++){
			Soma += Valores[idThread][i];
		}
		System.out.println("Linha #" +idThread +" resulta na soma: " +Soma);
	}
	@Override
	public void run() {
		fazSoma();
	}
}
