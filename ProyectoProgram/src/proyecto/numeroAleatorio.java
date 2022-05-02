package proyecto;

import java.util.Random;

public class numeroAleatorio {
	
	//retorna numeros aleatorios flotantes
	public float generarNumeros() {
		Random rand = new Random();
		float n = rand.nextFloat(10000);
		n += 1;		
		return n;
	}
}
