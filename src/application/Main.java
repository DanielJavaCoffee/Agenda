package application;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

import javax.swing.JOptionPane;

import enuns.StatusDeExebicao;
import model.CentralDeInformacoes;
import model.Persistencia;
import tela.TelaDeCadastroDeUsuario;
import tela.TelaDeLogin;

public class Main {

	public static void main(String[] args) {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes centralDeInformacoes = persistencia.recuperarCentral();

		// Initializing a DayOfWeek instance
		DayOfWeek dayOfWeek = DayOfWeek.MONDAY;

		// Get textual representation of the
		// day-of-week in FULL style
		String full_name = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());

		// Get textual representation of the
		// day-of-week in SHORT style
		String short_name = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.getDefault());

		// Get textual representation of the
		// day-of-week in NARROW style
		String narrow_name = dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.getDefault());

		// Printing the textual names of the day-of-week
		System.out.println(full_name);

		System.out.println(short_name);

		System.out.println(narrow_name);

		if (centralDeInformacoes.getTodosOsUsuarios().size() > 0) {
			new TelaDeLogin(null);
		} else {
			new TelaDeCadastroDeUsuario(null);
		}
	}
}

/*
 * DayOfWeek[] dias = new DayOfWeek[6]; DayOfWeek day = null;
 * 
 * Scanner leitor = new Scanner(System.in);
 * System.out.println("Informe os dias da semana separada por vírgula:"); String
 * diasDaSemana[] = leitor.nextLine().split(", ");
 * 
 * for (int i = 0; i < diasDaSemana.length; i++) {
 * 
 * switch (diasDaSemana[i].toLowerCase() ) {
 * 
 * case "segunda": day = DayOfWeek.of(1); dias[i] = day; break; case "terça":
 * day = DayOfWeek.of(2); dias[i] = day; break; case "quarta": day =
 * DayOfWeek.of(3); dias[i] = day; break; case "quinta": day = DayOfWeek.of(4);
 * dias[i] = day; break; case "sexta": day = DayOfWeek.of(5); dias[i] = day;
 * break; case "sabado": day = DayOfWeek.of(6); dias[i] = day; break; case
 * "domingo": day = DayOfWeek.of(7); dias[i] = day; break; } }
 * 
 * for (DayOfWeek diasDa : dias) { System.out.println(diasDa.name()); }
 * 
 * leitor.close();
 */