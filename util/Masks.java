package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Masks {

	public static String calcIdade(String tfDtNasc) throws ParseException {

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date dtFormatada = formato.parse(tfDtNasc);

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dtFormatada);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		dateOfBirth.add(Calendar.YEAR, age);

		// se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if (today.before(dateOfBirth)) {
			age--;
		}
		// conversao int para string
		String idade = Integer.toString(age);
		return idade;
	}

}
