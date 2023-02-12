package controller.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controller.Icontroller;
import controller.fxml.FormPsicoAltoRisco;
import model.entities.ClienteView;
import model.entities.PsicoAltoRisco;
import model.service.ClienteService;
import model.service.PsicoAltoRiscoService;

public class PsicoAltoRiscoCT implements Icontroller {

	private PsicoAltoRisco objPAR;
	private ClienteView objClienteView;
	private ClienteService servicoClient;
	private PsicoAltoRiscoService servicoPsicoAR;
	private FormPsicoAltoRisco frame;

	// envia solicitação para camada de serviço e retorna objeto carregado
	private ClienteView pesquisaView(String cpf) {
		this.servicoClient = new ClienteService();
		objClienteView = servicoClient.pespesquisaCPFeNome(cpf);
		return objClienteView;
	}

	// envia solicitação para camada de serviço e retorna objeto carregado
	private PsicoAltoRisco findByCpf(String cpf) {
		this.servicoPsicoAR = new PsicoAltoRiscoService();
		objPAR = servicoPsicoAR.pesquisaView(cpf);
		return objPAR;
	}

	// pesquisa cliente cadastrado SWING
	@Override
	public void pesquisaCpf(Object view) {
		frame = (FormPsicoAltoRisco) view;
		String cpf = frame.getTfCPFPsicoAr().getText();
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
				frame.getTfNomePsicoAr().setText(objClienteView.getNomeCompleto());
			}
		}
	}

	// insere cliente nessa tabela com base no objeto passado para camada de servico
	@Override
	public void inserir(Object view) {
		frame = (FormPsicoAltoRisco) view;
		String cpf = frame.getTfCPFPsicoAr().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chamada do método
			this.objPAR = instanciaOBJ(frame);
			// envia solicitação para camada de serviço com objeto carregado
			servicoPsicoAR = new PsicoAltoRiscoService();
			servicoPsicoAR.insert(objPAR);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// atualiza cliente nessa tabela com base no objeto passado para camada de
	// servico
	@Override
	public void atualizar(Object view) {
		frame = (FormPsicoAltoRisco) view;
		String cpf = frame.getTfCPFPsicoAr().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o Cliente dessa tabela?",
					"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
			if (sai == JOptionPane.YES_OPTION) {
				// chamada do método
				this.objPAR = instanciaOBJ(frame);
				// envia solicitação para camada de serviço com objeto carregado
				this.servicoPsicoAR.update(objPAR);
				// chama o metodo para anular os tf passando o frame como objeto
				setarNullFrame(frame);
			}
		}
	}

	// deleta o cliente com base no cpf passado para camada de servico
	@Override
	public void deletar(Object view) {
		frame = (FormPsicoAltoRisco) view;
		String cpf = frame.getTfCPFPsicoAr().getText();
		int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover o Cliente dessa tabela?",
				"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
		if (sai == JOptionPane.YES_OPTION) {
			// envia solicitação para camada de serviço
			this.servicoPsicoAR.deleteByCpf(cpf);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// pesquisa cliente ja cadastrado nessa tabela e retorna o objeto
	@Override
	public void buscaObj(Object view) {
		frame = (FormPsicoAltoRisco) view;
		String cpf = frame.getTfCPFPsicoAr().getText();
		findByCpf(cpf);
		// chamada do método
		frame = InstanciaForm(objPAR);
	}

	// método seta o objeto com o frame passado
	private PsicoAltoRisco instanciaOBJ(FormPsicoAltoRisco frame) {
		this.objPAR = new PsicoAltoRisco();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		objPAR.setCpfCliente(frame.getTfCPFPsicoAr().getText());
		objPAR.setPrimeiro(frame.getTfPsicoAr1().getText());
		objPAR.setSegundo(frame.getTfPsicoAr2().getText());
		objPAR.setTerceiro(frame.getTfPsicoAr3().getText());
		objPAR.setQuarto(frame.getTfPsicoAr4().getText());
		objPAR.setQuinto(frame.getTfPsicoAr5().getText());
		objPAR.setSexto(frame.getTfPsicoAr6().getText());
		objPAR.setSetimo(frame.getTfPsicoAr7().getText());
		objPAR.setOitavo(frame.getTfPsicoAr8().getText());
		objPAR.setNono(frame.getTfPsicoAr9().getText());
		objPAR.setDecimo(frame.getTfPsicoAr10().getText());
		objPAR.setDecimoPrimeiro(frame.getTfPsicoAr11().getText());
		try {
			objPAR.setDtCadastroHPAR(formato.parse(frame.getTfDtCadPsicoAr().getText()));
		} catch (ParseException e) {
		}
		return objPAR;
	}

	// método seta o Frame com o o objeto passado
	private FormPsicoAltoRisco InstanciaForm(PsicoAltoRisco objPAR) {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		frame.getTfPsicoAr1().setText(objPAR.getPrimeiro());
		frame.getTfPsicoAr2().setText(objPAR.getSegundo());
		frame.getTfPsicoAr3().setText(objPAR.getTerceiro());
		frame.getTfPsicoAr4().setText(objPAR.getQuarto());
		frame.getTfPsicoAr5().setText(objPAR.getQuinto());
		frame.getTfPsicoAr6().setText(objPAR.getSexto());
		frame.getTfPsicoAr7().setText(objPAR.getSetimo());
		frame.getTfPsicoAr8().setText(objPAR.getOitavo());
		frame.getTfPsicoAr9().setText(objPAR.getNono());
		frame.getTfPsicoAr10().setText(objPAR.getDecimo());
		frame.getTfPsicoAr11().setText(objPAR.getDecimoPrimeiro());
		frame.getTfDtCadPsicoAr().setText(formato.format(objPAR.getDtCadastroHPAR()));
		return frame;
	}

	// método seta o frame com nulo
	private void setarNullFrame(FormPsicoAltoRisco frame) {
		frame.getTfCPFPsicoAr().setText("");
		frame.getTfNomePsicoAr().setText("Nome Cliente");
		frame.getTfPsicoAr1().setText("");
		frame.getTfPsicoAr2().setText("");
		frame.getTfPsicoAr3().setText("");
		frame.getTfPsicoAr4().setText("");
		frame.getTfPsicoAr5().setText("");
		frame.getTfPsicoAr6().setText("");
		frame.getTfPsicoAr7().setText("");
		frame.getTfPsicoAr8().setText("");
		frame.getTfPsicoAr9().setText("");
		frame.getTfPsicoAr10().setText("");
		frame.getTfPsicoAr11().setText("");
		frame.getTfDtCadPsicoAr().setText("");
	}
}
