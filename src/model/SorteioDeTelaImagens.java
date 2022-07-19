package model;

import java.util.Random;

public class SorteioDeTelaImagens {

	public String sorteioDeTela() {
		
			String imagens[] = { "FundoDeTela/pipocaFilme.jpeg", "FundoDeTela/imagensDEFilmes.png",
					"FundoDeTela/foto01.png" };

			int numero = new Random().nextInt(3);
			String sorteio = imagens[numero];
			return sorteio;
	}
}
