package controller.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controller.Icontroller;
import controller.fxml.FormPsico;
import model.entities.ClienteView;
import model.entities.Psico;
import model.service.ClienteService;
import model.service.PsicoService;

public class PsicoCT implements Icontroller {

	private Psico objPsico;
	private ClienteView objClienteView;
	private ClienteService servicoClient;
	private PsicoService servicoPsico;
	private FormPsico frame;

	// envia solicitação para camada de serviço e retorna objeto carregado
	private ClienteView pesquisaView(String cpf) {
		this.servicoClient = new ClienteService();
		objClienteView = servicoClient.pespesquisaCPFeNome(cpf);
		return objClienteView;
	}

	// envia solicitação para camada de serviço e retorna objeto carregado
	private Psico findByCpf(String cpf) {
		this.servicoPsico = new PsicoService();
		objPsico = servicoPsico.pesquisaView(cpf);
		return objPsico;
	}

	// pesquisa cliente cadastrado
	@Override
	public void pesquisaCpf(Object view) {
		frame = (FormPsico) view;
		String cpf = frame.getTfCPFPsico().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chama o método de pesquisa do cliente passando o cpf
			pesquisaView(cpf);
			if (objClienteView == null) {
				setarNullFrame(frame);
			} else {
				// seta os textfields com os dados do DB de acordo com a pesquisa do cpf
				frame.getTfNomePsico().setText(objClienteView.getNomeCompleto());
			}
		}
	}

	// insere cliente nessa tabela com base no objeto passado para camada de servico
	@Override
	public void inserir(Object view) {
		frame = (FormPsico) view;
		String cpf = frame.getTfCPFPsico().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chamada do método
			this.objPsico = instanciaOBJ(frame);
			// envia solicitação para camada de serviço com objeto carregado
			servicoPsico = new PsicoService();
			servicoPsico.insert(objPsico);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// atualiza cliente nessa tabela com base no objeto passado para camada de
	// servico
	@Override
	public void atualizar(Object view) {
		frame = (FormPsico) view;
		String cpf = frame.getTfCPFPsico().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o Cliente dessa tabela?",
					"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
			if (sai == JOptionPane.YES_OPTION) {
				// chamada do método
				this.objPsico = instanciaOBJ(frame);
				// envia solicitação para camada de serviço com objeto carregado
				this.servicoPsico.update(objPsico);
				// chama o metodo para anular os tf passando o frame como objeto
				setarNullFrame(frame);
			}
		}
	}

	// deleta o cliente com base no cpf passado para camada de servico
	@Override
	public void deletar(Object view) {
		frame = (FormPsico) view;
		String cpf = frame.getTfCPFPsico().getText();
		int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover o Cliente dessa tabela?",
				"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
		if (sai == JOptionPane.YES_OPTION) {
			// envia solicitação para camada de serviço
			this.servicoPsico.deleteByCpf(cpf);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// pesquisa cliente ja cadastrado nessa tabela e retorna o objeto
	@Override
	public void buscaObj(Object view) {
		frame = (FormPsico) view;
		String cpf = frame.getTfCPFPsico().getText();
		// chama o método de pesquisa do cliente passando o cpf
		findByCpf(cpf);
		// chamada do método
		frame = instanciaForm(objPsico);
	}

	// método seta o objeto com o frame passado
	private Psico instanciaOBJ(FormPsico frame) {
		this.objPsico = new Psico();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		objPsico.setCpfCliente(frame.getTfCPFPsico().getText());
		objPsico.setPrimeiroHP(frame.getTfPsico1().getText());
		objPsico.setSegundoHP(frame.getTfPsico2().getText());
		objPsico.setTerceiroHP(frame.getTfPsico3().getText());
		objPsico.setQuartoHP(frame.getTfPsico4().getText());
		objPsico.setQuintoHP(frame.getTfPsico5().getText());
		objPsico.setSextoHP(frame.getTfPsico6().getText());
		objPsico.setSetimoHP(frame.getTfPsico7().getText());
		objPsico.setOitavoHP(frame.getTfPsico8().getText());
		objPsico.setNonoHP(frame.getTfPsico9().getText());
		objPsico.setDecimoHP(frame.getTfPsico10().getText());
		objPsico.setDecimoPrimeiroHP(frame.getTfPsico11().getText());
		objPsico.setDecimoSegundoHP(frame.getTfPsico12().getText());
		objPsico.setDecimoTerceiroHP(frame.getTfPsico13().getText());
		objPsico.setDecimoQuartoHP(frame.getTfPsico14().getText());
		objPsico.setDecimoQuintoHP(frame.getTfPsico15().getText());
		objPsico.setDecimoSextoHP(frame.getTfPsico16().getText());
		objPsico.setDecimoSetimoHP(frame.getTfPsico17().getText());
		objPsico.setDecimoOitavoHP(frame.getTfPsico18().getText());
		objPsico.setDecimoNonoHP(frame.getTfPsico19().getText());
		objPsico.setVigesimoHP(frame.getTfPsico20().getText());
		objPsico.setVigesimoPrimeiroHP(frame.getTfPsico21().getText());
		objPsico.setVigesimoSegundoHP(frame.getTfPsico22().getText());
		objPsico.setVigesimoTerceiroHP(frame.getTfPsico23().getText());
		objPsico.setVigesimoQuartoHP(frame.getTfPsico24().getText());
		try {
			objPsico.setDtCadastroHP(formato.parse(frame.getTfDtCadPsico().getText()));
		} catch (ParseException e) {

		}
		return objPsico;
	}

	// método seta o Frame com o objeto passado
	private FormPsico instanciaForm(Psico objPsico) {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		frame.getTfPsico1().setText(objPsico.getPrimeiroHP());
		frame.getTfPsico2().setText(objPsico.getSegundoHP());
		frame.getTfPsico3().setText(objPsico.getTerceiroHP());
		frame.getTfPsico4().setText(objPsico.getQuartoHP());
		frame.getTfPsico5().setText(objPsico.getQuintoHP());
		frame.getTfPsico6().setText(objPsico.getSextoHP());
		frame.getTfPsico7().setText(objPsico.getSetimoHP());
		frame.getTfPsico8().setText(objPsico.getOitavoHP());
		frame.getTfPsico9().setText(objPsico.getNonoHP());
		frame.getTfPsico10().setText(objPsico.getDecimoHP());
		frame.getTfPsico11().setText(objPsico.getDecimoPrimeiroHP());
		frame.getTfPsico12().setText(objPsico.getDecimoSegundoHP());
		frame.getTfPsico13().setText(objPsico.getDecimoTerceiroHP());
		frame.getTfPsico14().setText(objPsico.getDecimoQuartoHP());
		frame.getTfPsico15().setText(objPsico.getDecimoQuintoHP());
		frame.getTfPsico16().setText(objPsico.getDecimoSextoHP());
		frame.getTfPsico17().setText(objPsico.getDecimoSetimoHP());
		frame.getTfPsico18().setText(objPsico.getDecimoOitavoHP());
		frame.getTfPsico19().setText(objPsico.getDecimoNonoHP());
		frame.getTfPsico20().setText(objPsico.getVigesimoHP());
		frame.getTfPsico21().setText(objPsico.getVigesimoPrimeiroHP());
		frame.getTfPsico22().setText(objPsico.getVigesimoSegundoHP());
		frame.getTfPsico23().setText(objPsico.getVigesimoTerceiroHP());
		frame.getTfPsico24().setText(objPsico.getVigesimoQuartoHP());
		frame.getTfDtCadPsico().setText(formato.format(objPsico.getDtCadastroHP()));
		return frame;
	}

	// método seta o frame com nulo
	private void setarNullFrame(FormPsico frame) {
		frame.getTfCPFPsico().setText("");
		frame.getTfNomePsico().setText("Nome Cliente");
		frame.getTfPsico1().setText("");
		frame.getTfPsico2().setText("");
		frame.getTfPsico3().setText("");
		frame.getTfPsico4().setText("");
		frame.getTfPsico5().setText("");
		frame.getTfPsico6().setText("");
		frame.getTfPsico7().setText("");
		frame.getTfPsico8().setText("");
		frame.getTfPsico9().setText("");
		frame.getTfPsico10().setText("");
		frame.getTfPsico11().setText("");
		frame.getTfPsico12().setText("");
		frame.getTfPsico13().setText("");
		frame.getTfPsico14().setText("");
		frame.getTfPsico15().setText("");
		frame.getTfPsico16().setText("");
		frame.getTfPsico17().setText("");
		frame.getTfPsico18().setText("");
		frame.getTfPsico19().setText("");
		frame.getTfPsico20().setText("");
		frame.getTfPsico21().setText("");
		frame.getTfPsico22().setText("");
		frame.getTfPsico23().setText("");
		frame.getTfPsico24().setText("");
		frame.getTfDtCadPsico().setText("");
	}

}
