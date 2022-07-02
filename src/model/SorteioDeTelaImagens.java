package model;

import java.util.Random;

public class SorteioDeTelaImagens {

	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

	public String sorteioDeTela() {
		
			String imagens[] = { "src/Imagens/pipocaFilme.jpeg", "src/Imagens/imagensDEFilmes.png",
					"src/Imagens/xx.png" };

			int numero = new Random().nextInt(3);
			String opApp = imagens[numero];
			return opApp;
	}
}
