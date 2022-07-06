package application;

import model.CentralDeInformacoes;
import model.Persistencia;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeLogin;

public class Main {

	public static void main(String[] args) {
			
		
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();
		
		if (centralDeInformacoes.getTodosOsUsuarios().size() > 0) {
			new TelaDeLogin(null);
		} else {
			new TelaDeCadastroDeUsuario(null);
		}	
	}
}
