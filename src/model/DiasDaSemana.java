package model;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class DiasDaSemana {
	
	public static String[] dias(String[] diasDaSemana) {
		
		String[] dias = new String[diasDaSemana.length];
		DayOfWeek day = null;
		String full_name = null;
		
		for (int i = 0; i < diasDaSemana.length; i++) {

			switch (diasDaSemana[i].toLowerCase()	) {

			case "segunda":
				day = DayOfWeek.MONDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "terça":
				day = DayOfWeek.TUESDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "quarta":
				day = DayOfWeek.WEDNESDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "quinta":
				day = DayOfWeek.THURSDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "sexta":
				day = DayOfWeek.FRIDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "sabado":
				day = DayOfWeek.SATURDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			case "domingo":	
				day = DayOfWeek.SUNDAY;
				full_name = day.getDisplayName(TextStyle.FULL,  Locale.getDefault());
				dias[i] = full_name;
				break;
			}
		}
		for(String dia: dias)
			System.out.println(dia);
		return dias;
	}
}
