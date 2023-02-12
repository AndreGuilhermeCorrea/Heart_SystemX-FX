package controller.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controller.Icontroller;
import controller.fxml.FormAntropometria;
import model.entities.Antropometria;
import model.entities.ClienteView;
import model.service.AntropometriaService;
import model.service.ClienteService;

public class AntropometriaCT implements Icontroller {

	private FormAntropometria frame;
	private Antropometria objAntrop;
	private ClienteView objClient;
	private ClienteService servicoClient;
	private AntropometriaService servicoAntro;

	// envia solicitação para camada de serviço e retorna objeto carregado
	private ClienteView pesquisaView(String cpf) {
		this.servicoClient = new ClienteService();
		objClient = servicoClient.pespesquisaCPFeNome(cpf);
		return objClient;
	}

	// envia solicitação para camada de serviço e retorna objeto carregado
	private Antropometria findByCPF(String cpf) {
		this.servicoAntro = new AntropometriaService();
		objAntrop = servicoAntro.pesquisaView(cpf);
		return objAntrop;
	}

	// envia solicitação do cálculo para camada de serviço e retorna objeto
	private Antropometria calcular(Antropometria objAntrop) {
		servicoAntro = new AntropometriaService();
		Antropometria resultado;
		resultado = servicoAntro.calcular(objAntrop);
		return resultado;
	}

	@Override
	public void pesquisaCpf(Object view) {
		frame = (FormAntropometria) view;
		String cpf = frame.getTfCpfA().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chama o método de pesquisa do cliente passando o cpf
			pesquisaView(cpf);
			if (objClient == null) {
				setarNullFrame(frame);
			} else {
				// seta os textfields com os dados do DB de acordo com a pesquisa do cpf
				frame.getTfNomeClienteA().setText(objClient.getNomeCompleto());
				String genero = objClient.getGenero();
				frame.getTfSexo().setText(genero.substring(0, 1));
				frame.getTfIdade().setText(intFormat(objClient.getIdade()));
			}
		}

	}

	@Override
	public void inserir(Object view) {
		frame = (FormAntropometria) view;
		String cpf = frame.getTfCpfA().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chamada do método
			this.objAntrop = instanciaOBJ(frame);
			// envia solicitação para camada de serviço com objeto carregado
			servicoAntro = new AntropometriaService();
			servicoAntro.insert(objAntrop);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}

	}

	@Override
	public void atualizar(Object view) {
		frame = (FormAntropometria) view;
		String cpf = frame.getTfCpfA().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o Cliente dessa tabela?",
					"Atenção! Essa ação não pode ser desfeita!", JOptionPane.YES_NO_OPTION);
			if (sai == JOptionPane.YES_OPTION) {
				// chamada do método
				this.objAntrop = instanciaOBJ(frame);
				// envia solicitação para camada de serviço com objeto carregado
				this.servicoAntro.update(objAntrop);
				// chama o metodo para anular os tf passando o frame como objeto
				setarNullFrame(frame);
			}
		}
	}

	@Override
	public void deletar(Object view) {
		frame = (FormAntropometria) view;
		String cpf = frame.getTfCpfA().getText();
		int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover o Cliente dessa tabela?",
				"Atenção! Essa ação não pode ser desfeita!", JOptionPane.YES_NO_OPTION);
		if (sai == JOptionPane.YES_OPTION) {
			// envia solicitação para camada de serviço
			servicoAntro.deleteByCpf(cpf);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	@Override
	public void buscaObj(Object view) {
		frame = (FormAntropometria) view;
		String cpf = frame.getTfCpfA().getText();
		findByCPF(cpf);
		// chamada do método
		frame = instanciaForm(objAntrop);
	}

	// realiza os calculos atravéz da camada de serviço de acordo com dados
	// inseridos no frame e retorna no objeto
	public void calc(Object view) {
		frame = (FormAntropometria) view;
		objAntrop = new Antropometria();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		//// seta o objeto Antropologia com os dados inseridos no frame
		objAntrop.setCpfCliente(frame.getTfCpfA().getText());
		objAntrop.setNomeCliente(frame.getTfNomeClienteA().getText());
		objAntrop.setIdade(Integer.parseInt(frame.getTfIdade().getText()));
		objAntrop.setSexo(frame.getTfSexo().getText());
		objAntrop.setPeso(Double.parseDouble(frame.getTfPeso().getText()));
		objAntrop.setAltura(Double.parseDouble(frame.getTfAltura().getText()));
		objAntrop.setPedometro1(Integer.parseInt(frame.getTfPedometro1().getText()));
		objAntrop.setPedometro2(Integer.parseInt(frame.getTfPedometro2().getText()));
		objAntrop.setPedometro3(Integer.parseInt(frame.getTfPedometro3().getText()));
		objAntrop.setSentarAlcanca(Double.parseDouble(frame.getTfSentarAlcanca().getText()));
		objAntrop.setcPunho(Double.parseDouble(frame.getTfcPunho().getText()));
		objAntrop.setcCintura(Double.parseDouble(frame.getTfcCintura().getText()));
		objAntrop.setcQuadril(Double.parseDouble(frame.getTfcQuadril().getText()));
		objAntrop.setPregaCutaneaTorax(Double.parseDouble(frame.getTfPcTorax().getText()));
		objAntrop.setPregaCutaneaAbdomem(Double.parseDouble(frame.getTfPcAbdomem().getText()));
		objAntrop.setPregaCutaneaCoxa(Double.parseDouble(frame.getTfPcCoxa().getText()));
		objAntrop.setPregaCutaneaTriciptal(Double.parseDouble(frame.getTfPcTricip().getText()));
		objAntrop.setPregaCutaneaSuprailiaca(Double.parseDouble(frame.getTfPcSuprailiaca().getText()));
		try {
			objAntrop.setDtCadastroA(formato.parse(frame.getTfDtCadastroA().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Date Error!: " + e.getMessage());
		}

		// chama o método da camada de serviço passando o objeto para realização dos
		// calculos
		calcular(objAntrop);

		// seta o frame após o calculo das medidas requisitados pelo serviço
		frame.getTfIMC().setText(doubleFormat(objAntrop.getImc()));
		frame.getTfCIMC().setText(objAntrop.getcImc());
		frame.getTfPedometroMedia().setText(doubleFormat(objAntrop.getPedometroMedia()));
		frame.getTfPedometroClass().setText(objAntrop.getPedometroClass());
		frame.getTfRazaoCintQuad().setText(doubleFormat(objAntrop.getRazaoCQ()));
		frame.getTfPesoDesejavel().setText(doubleFormat(objAntrop.getPesoDesejavel()));
		frame.getTfIMCDesejavel().setText(doubleFormat(objAntrop.getImcDesejavel()));
		frame.getTfRiscoSaude().setText(objAntrop.getcRiscoSaude());
		frame.getTfPesoAjustado().setText(doubleFormat(objAntrop.getPesoAjustado()));
		frame.getTfAdequacaoPeso().setText(doubleFormat(objAntrop.getAdequacaoPeso()));
		frame.getTfCompleicao().setText(doubleFormat(objAntrop.getCompleicao()));
		frame.getTfTipoComp().setText(objAntrop.getTipoComp());
		frame.getTfNivelFlexib().setText(objAntrop.getNivelFlexibilidade());
		frame.getTfSomaDobras().setText(doubleFormat(objAntrop.getSomaDobrasCutaneas()));
		frame.getTfMassaCMagra().setText(doubleFormat(objAntrop.getMassaCMagra()));
		frame.getTfMassaCGorda().setText(doubleFormat(objAntrop.getMassaCGorda()));
		frame.getTfMassaCPercentual().setText(doubleFormat(objAntrop.getMassaCPercentual()));
		frame.getTfDensidade().setText(doubleFormat(objAntrop.getDensidade()));
	}

	// método para formatar com 2 casas decimais e trocar a virgula pelo ponto
	private String doubleFormat(Double aDouble) {
		return String.format("%.2f", aDouble).replaceAll(",", ".");
	}

	// metodo para formatar inteiro em string
	private String intFormat(Integer intA) {
		String saida = Integer.toString(intA);
		return saida;
	}

	// método seta o objeto com o frame passado
	private Antropometria instanciaOBJ(FormAntropometria frame) {
		this.objAntrop = new Antropometria();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		objAntrop.setCpfCliente(frame.getTfCpfA().getText());
		objAntrop.setAltura(Double.parseDouble(frame.getTfAltura().getText()));
		objAntrop.setPeso(Double.parseDouble(frame.getTfPeso().getText()));
		objAntrop.setPedometro1(Integer.parseInt(frame.getTfPedometro1().getText()));
		objAntrop.setPedometro2(Integer.parseInt(frame.getTfPedometro2().getText()));
		objAntrop.setPedometro3(Integer.parseInt(frame.getTfPedometro3().getText()));
		objAntrop.setSentarAlcanca(Double.parseDouble(frame.getTfSentarAlcanca().getText()));
		objAntrop.setcPunho(Double.parseDouble(frame.getTfcPunho().getText()));
		objAntrop.setcCintura(Double.parseDouble(frame.getTfcCintura().getText()));
		objAntrop.setcQuadril(Double.parseDouble(frame.getTfcQuadril().getText()));
		objAntrop.setPregaCutaneaTorax(Double.parseDouble(frame.getTfPcTorax().getText()));
		objAntrop.setPregaCutaneaAbdomem(Double.parseDouble(frame.getTfPcAbdomem().getText()));
		objAntrop.setPregaCutaneaTriciptal(Double.parseDouble(frame.getTfPcTricip().getText()));
		objAntrop.setPregaCutaneaCoxa(Double.parseDouble(frame.getTfPcCoxa().getText()));
		objAntrop.setPregaCutaneaSuprailiaca(Double.parseDouble(frame.getTfPcSuprailiaca().getText()));
		objAntrop.setImc(Double.parseDouble(frame.getTfIMC().getText()));
		objAntrop.setcImc(frame.getTfCIMC().getText());
		objAntrop.setPedometroMedia(Double.parseDouble(frame.getTfPedometroMedia().getText()));
		objAntrop.setPedometroClass(frame.getTfPedometroClass().getText());
		objAntrop.setRazaoCQ(Double.parseDouble(frame.getTfRazaoCintQuad().getText()));
		objAntrop.setPesoDesejavel(Double.parseDouble(frame.getTfPesoDesejavel().getText()));
		objAntrop.setImcDesejavel(Double.parseDouble(frame.getTfIMCDesejavel().getText()));
		objAntrop.setcRiscoSaude(frame.getTfRiscoSaude().getText());
		objAntrop.setPesoAjustado(Double.parseDouble(frame.getTfPesoAjustado().getText()));
		objAntrop.setAdequacaoPeso(Double.parseDouble(frame.getTfAdequacaoPeso().getText()));
		objAntrop.setCompleicao(Double.parseDouble(frame.getTfCompleicao().getText()));
		objAntrop.setTipoComp(frame.getTfTipoComp().getText());
		objAntrop.setNivelFlexibilidade(frame.getTfNivelFlexib().getText());
		objAntrop.setSomaDobrasCutaneas(Double.parseDouble(frame.getTfSomaDobras().getText()));
		objAntrop.setMassaCMagra(Double.parseDouble(frame.getTfMassaCMagra().getText()));
		objAntrop.setMassaCGorda(Double.parseDouble(frame.getTfMassaCGorda().getText()));
		objAntrop.setMassaCPercentual(Double.parseDouble(frame.getTfMassaCPercentual().getText()));
		objAntrop.setDensidade(Double.parseDouble(frame.getTfDensidade().getText()));
		try {
			objAntrop.setDtCadastroA(formato.parse(frame.getTfDtCadastroA().getText()));
		} catch (ParseException e) {

		}
		return objAntrop;
	}

	// método seta o Frame com o o objeto passado
	private FormAntropometria instanciaForm(Antropometria objAntrop) {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		frame.getTfDtCadastroA().setText(formato.format(objAntrop.getDtCadastroA()));
		frame.getTfAltura().setText(doubleFormat(objAntrop.getAltura()));
		frame.getTfPeso().setText(doubleFormat(objAntrop.getPeso()));
		frame.getTfPedometro1().setText(intFormat(objAntrop.getPedometro1()));
		frame.getTfPedometro2().setText(intFormat(objAntrop.getPedometro2()));
		frame.getTfPedometro3().setText(intFormat(objAntrop.getPedometro3()));
		frame.getTfSentarAlcanca().setText(doubleFormat(objAntrop.getSentarAlcanca()));
		frame.getTfcPunho().setText(doubleFormat(objAntrop.getcPunho()));
		frame.getTfcCintura().setText(doubleFormat(objAntrop.getcCintura()));
		frame.getTfcQuadril().setText(doubleFormat(objAntrop.getcQuadril()));
		frame.getTfPcTorax().setText(doubleFormat(objAntrop.getPregaCutaneaTorax()));
		frame.getTfPcAbdomem().setText(doubleFormat(objAntrop.getPregaCutaneaAbdomem()));
		frame.getTfPcTricip().setText(doubleFormat(objAntrop.getPregaCutaneaTriciptal()));
		frame.getTfPcCoxa().setText(doubleFormat(objAntrop.getPregaCutaneaCoxa()));
		frame.getTfPcSuprailiaca().setText(doubleFormat(objAntrop.getPregaCutaneaSuprailiaca()));
		frame.getTfIMC().setText(doubleFormat(objAntrop.getImc()));
		frame.getTfCIMC().setText(objAntrop.getcImc());
		frame.getTfPedometroMedia().setText(doubleFormat(objAntrop.getPedometroMedia()));
		frame.getTfPedometroClass().setText(objAntrop.getPedometroClass());
		frame.getTfRazaoCintQuad().setText(doubleFormat(objAntrop.getRazaoCQ()));
		frame.getTfPesoDesejavel().setText(doubleFormat(objAntrop.getPesoDesejavel()));
		frame.getTfIMCDesejavel().setText(doubleFormat(objAntrop.getImcDesejavel()));
		frame.getTfRiscoSaude().setText(objAntrop.getcRiscoSaude());
		frame.getTfPesoAjustado().setText(doubleFormat(objAntrop.getPesoAjustado()));
		frame.getTfAdequacaoPeso().setText(doubleFormat(objAntrop.getAdequacaoPeso()));
		frame.getTfCompleicao().setText(doubleFormat(objAntrop.getCompleicao()));
		frame.getTfTipoComp().setText(objAntrop.getTipoComp());
		frame.getTfNivelFlexib().setText(objAntrop.getNivelFlexibilidade());
		frame.getTfSomaDobras().setText(doubleFormat(objAntrop.getSomaDobrasCutaneas()));
		frame.getTfMassaCMagra().setText(doubleFormat(objAntrop.getMassaCMagra()));
		frame.getTfMassaCGorda().setText(doubleFormat(objAntrop.getMassaCGorda()));
		frame.getTfMassaCPercentual().setText(doubleFormat(objAntrop.getMassaCPercentual()));
		frame.getTfDensidade().setText(doubleFormat(objAntrop.getDensidade()));
		return frame;
	}

	// método seta o frame com nulo
	private void setarNullFrame(FormAntropometria frame) {
		frame.getTfCpfA().setText("");
		frame.getTfIdade().setText("Id");
		frame.getTfSexo().setText("Sx");
		frame.getTfNomeClienteA().setText("");
		frame.getTfDtCadastroA().setText("");
		frame.getTfAltura().setText("");
		frame.getTfPeso().setText("");
		frame.getTfPedometro1().setText("");
		frame.getTfPedometro2().setText("");
		frame.getTfPedometro3().setText("");
		frame.getTfSentarAlcanca().setText("");
		frame.getTfcPunho().setText("");
		frame.getTfcCintura().setText("");
		frame.getTfcQuadril().setText("");
		frame.getTfPcTorax().setText("");
		frame.getTfPcAbdomem().setText("");
		frame.getTfPcTricip().setText("");
		frame.getTfPcCoxa().setText("");
		frame.getTfPcSuprailiaca().setText("");
		frame.getTfIMC().setText("");
		frame.getTfCIMC().setText("");
		frame.getTfPedometroMedia().setText("");
		frame.getTfPedometroClass().setText("");
		frame.getTfRazaoCintQuad().setText("");
		frame.getTfPesoDesejavel().setText("");
		frame.getTfIMCDesejavel().setText("");
		frame.getTfRiscoSaude().setText("");
		frame.getTfPesoAjustado().setText("");
		frame.getTfAdequacaoPeso().setText("");
		frame.getTfCompleicao().setText("");
		frame.getTfTipoComp().setText("");
		frame.getTfNivelFlexib().setText("");
		frame.getTfSomaDobras().setText("");
		frame.getTfMassaCMagra().setText("");
		frame.getTfMassaCGorda().setText("");
		frame.getTfMassaCPercentual().setText("");
		frame.getTfDensidade().setText("");
	}
}
