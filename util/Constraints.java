package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Constraints {

	// mÃ©todo para delimitar tamanho do campo
	private static void limCamp(TextField textField, Integer tamanho) {
		textField.textProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null || newValue.length() > tamanho) {
				textField.setText(oldValue);
			}
		});
	}

	// mÃ©todo para posicionar o cursor ao fim do campo
	public static void posicionarCursorFim(TextField textField) {
		Platform.runLater(() -> {
			if (textField.getText().length() != 0) {
				textField.positionCaret(textField.getText().length());
			}
		});
	}

	// mÃ©todo para se aceitar apenas numeros de 0 a 9
	public static void mskNum(TextField textField, Integer tamanho) {
		Constraints.limCamp(textField, tamanho);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo para numeros decimais
	public static void mskDouble(TextField textField) {
		Constraints.limCamp(textField, 4);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textoDigitado = textoDigitado.replaceFirst("([0-9]{1})([0-9]{2})", "$1.$2");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para Data dd/MM/yyyy
	public static void mskDt(TextField textField) {
		Constraints.limCamp(textField, 10);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {

			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textoDigitado = textoDigitado.replaceFirst("(\\d{2})(\\d)", "$1/$2");
			textoDigitado = textoDigitado.replaceFirst("(\\d{2})\\/(\\d{2})(\\d)", "$1/$2/$3");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para Celular (##)#####-####
	public static void mskCEL(TextField textField) {
		Constraints.limCamp(textField, 14);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {

			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textoDigitado = textoDigitado.replaceFirst("([1-9]{2})", "($1)");
			textoDigitado = textoDigitado.replaceFirst("([1-9]{2})([0-9]{5})([0-9]{4})$", "($1)$2-$3");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para CPF ###.###.###-##
	public static void mskCPF(TextField textField) {
		Constraints.limCamp(textField, 14);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textoDigitado = textoDigitado.replaceFirst("([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$", "$1.$2.$3-$4");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para CEP ##.###-##
	public static void mskCEP(TextField textField) {
		Constraints.limCamp(textField, 10);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll("[^0-9]", "");
			textoDigitado = textoDigitado.replaceFirst("([0-9]{2})([0-9]{3})([0-9]{3})$", "$1.$2-$3");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para somente letras e retornar todas maiusculas
	public static void mskLetras(TextField textField, Integer tamanho) {
		Constraints.limCamp(textField, tamanho);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll(
					"[^ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZÃ§Ã‡Ã©Ã¡Ã­ÃºÃ³Ã�Ã‰Ã“Ã�ÃšÃ£ÃµÃƒÃ•]", "");
			textoDigitado = textoDigitado.toUpperCase();
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para estados 2 digitos e retornar em maiusculas
	public static void mskUF(TextField textField) {
		Constraints.limCamp(textField, 2);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			// implementar ainda: AC AL AP AM BA CE ES GO MA MT MS MG PA PB PR PE PI RJ RN
			// RS RO RR SC SP SE TO DF
			textoDigitado = textoDigitado.replaceAll("[^abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ]", "");
			textoDigitado = textoDigitado.toUpperCase();
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo calculo idade
	public static void mskIdade(TextField campoDtNasc, TextField campoIdade) throws ParseException {
		Constraints.limCamp(campoIdade, 3);
		campoDtNasc.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = campoDtNasc.getText();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dtFormatada = formato.parse(textoDigitado);
				Calendar dateOfBirth = new GregorianCalendar();
				dateOfBirth.setTime(dtFormatada);
				// Cria um objeto calendar com a data atual
				Calendar today = Calendar.getInstance();

				// ObtÃ©m a idade baseado no ano
				int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
				dateOfBirth.add(Calendar.YEAR, age);

				// se a data de hoje Ã© antes da data de Nascimento, entÃ£o diminui 1(um)
				if (today.before(dateOfBirth)) {
					age--;
				}
				String idade = Integer.toString(age);
				campoIdade.setText(idade);

			} catch (ParseException e1) {
				Alertas.showAlert(null, "Erro ao Calcular a idade! ", e1.getMessage(), AlertType.ERROR);

			}

		});
	}

	// mÃ©todo para alterar virgula para ponto
	public static void mskPV(TextField textField, Integer tamanho) {
		Constraints.limCamp(textField, tamanho);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.replaceAll(",", ".");
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

	// mÃ©todo Monta a mascara para s ou n retornar em maiusculas
	public static void mskSN(TextField textField) {
		Constraints.limCamp(textField, 1);
		textField.lengthProperty().addListener((observable, oldValue, newValue) -> {
			String textoDigitado = textField.getText();
			textoDigitado = textoDigitado.toUpperCase();
			textField.setText(textoDigitado);
			Constraints.posicionarCursorFim(textField);

		});
	}

}
