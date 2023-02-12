package controller.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controller.Icontroller;
import controller.fxml.FormSaude;
import model.entities.ClienteView;
import model.entities.Saude;
import model.service.ClienteService;
import model.service.SaudeService;

public class SaudeCT implements Icontroller {

	private Saude objSaude;
	private ClienteView objClienteView;
	private SaudeService servicoSaude;
	private ClienteService servicoClient;
	private FormSaude frame;

	// envia solicitação para camada de serviço e retorna objeto carregado
	private ClienteView pesquisaView(String cpf) {
		this.servicoClient = new ClienteService();
		objClienteView = servicoClient.pespesquisaCPFeNome(cpf);
		return objClienteView;
	}

	// envia solicitação para camada de serviço e retorna objeto carregado
	private Saude findByCPF(String cpf) {
		this.servicoSaude = new SaudeService();
		objSaude = servicoSaude.pesquisaView(cpf);
		return objSaude;
	}

	// pesquisa cliente cadastrado
	@Override
	public void pesquisaCpf(Object view) {
		frame = (FormSaude) view;
		String cpf = frame.getTfCPFClienteS().getText();
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
				frame.getTfNomeCliente().setText(objClienteView.getNomeCompleto());
			}
		}
	}

	// insere cliente nessa tabela com base no objeto passado para camada de servico
	@Override
	public void inserir(Object view) {
		frame = (FormSaude) view;
		String cpf = frame.getTfCPFClienteS().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chamada do método
			this.objSaude = instanciaOBJ(frame);
			// envia solicitação para camada de serviço com objeto carregado
			servicoSaude = new SaudeService();
			servicoSaude.insert(objSaude);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// atualiza cliente nessa tabela com base no objeto passado para camada de
	// servico
	@Override
	public void atualizar(Object view) {
		frame = (FormSaude) view;
		String cpf = frame.getTfCPFClienteS().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o Cliente dessa tabela?",
					"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
			if (sai == JOptionPane.YES_OPTION) {
				// chamada do método
				this.objSaude = instanciaOBJ(frame);
				// envia solicitação para camada de serviço com objeto carregado
				this.servicoSaude.update(objSaude);
				// chama o metodo para anular os tf passando o frame como objeto
				setarNullFrame(frame);
			}
		}
	}

	// deleta o cliente com base no cpf passado para camada de servico
	@Override
	public void deletar(Object view) {
		frame = (FormSaude) view;
		String cpf = frame.getTfCPFClienteS().getText();
		int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover o Cliente dessa tabela?",
				"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
		if (sai == JOptionPane.YES_OPTION) {
			// envia solicitação para camada de serviço
			this.servicoSaude.deleteByCpf(cpf);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// pesquisa cliente ja cadastrado nessa tabela e retorna o objeto
	@Override
	public void buscaObj(Object view) {
		frame = (FormSaude) view;
		String cpf = frame.getTfCPFClienteS().getText();
		findByCPF(cpf);
		// chamada do método
		frame = instanciaForm(objSaude);
	}

	// método seta o objeto com o frame passado
	private Saude instanciaOBJ(FormSaude frame) {
		this.objSaude = new Saude();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		objSaude.setCpfCliente(frame.getTfCPFClienteS().getText());
		objSaude.setTabagista(frame.getTfS1().getText());
		objSaude.setEtilista(frame.getTfS2().getText());
		objSaude.setDieta(frame.getTfS3().getText());
		objSaude.setFaltaDeAr(frame.getTfS4().getText());
		objSaude.setVidaSexualAtiva(frame.getTfS5().getText());
		objSaude.setUsoDeMedicacao(frame.getTfS6().getText());
		objSaude.setDiabetes(frame.getTfS7().getText());
		objSaude.setDorNoPeito(frame.getTfS8().getText());
		objSaude.setHipertensao(frame.getTfS9().getText());
		objSaude.setColesterolAlto(frame.getTfS10().getText());
		objSaude.setTriglicerides(frame.getTfS11().getText());
		objSaude.setAnemia(frame.getTfS12().getText());
		objSaude.setGota(frame.getTfS13().getText());
		objSaude.setAlergia(frame.getTfS14().getText());
		objSaude.setPatologiaCardiaca(frame.getTfS15().getText());
		objSaude.setArritmia(frame.getTfS16().getText());
		objSaude.setInfarto(frame.getTfS17().getText());
		objSaude.setStent(frame.getTfS18().getText());
		objSaude.setCateterismo(frame.getTfS19().getText());
		objSaude.setaVC(frame.getTfS20().getText());
		objSaude.setRenal(frame.getTfS21().getText());
		objSaude.setCancer(frame.getTfS22().getText());
		objSaude.setHepatite(frame.getTfS23().getText());
		objSaude.setLabirintite(frame.getTfS24().getText());
		objSaude.setPatologiaArterial(frame.getTfS25().getText());
		objSaude.setPatologiaPulmonar(frame.getTfS26().getText());
		objSaude.setTireoide(frame.getTfS27().getText());
		objSaude.setHabitoMesntrual(frame.getTfS28().getText());
		objSaude.setHabitoIntestinal(frame.getTfS29().getText());
		objSaude.setPatologiaOrtopedica(frame.getTfS30().getText());
		objSaude.setDoresDeCabeca(frame.getTfS31().getText());
		try {
			objSaude.setDtCadastroS(formato.parse(frame.getTfDtCadastroS().getText()));
		} catch (ParseException e) {

		}
		return objSaude;
	}

	// método seta o Frame com o objeto passado
	private FormSaude instanciaForm(Saude objSaude) {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		frame.getTfS1().setText(objSaude.getTabagista());
		frame.getTfS2().setText(objSaude.getEtilista());
		frame.getTfS3().setText(objSaude.getDieta());
		frame.getTfS4().setText(objSaude.getFaltaDeAr());
		frame.getTfS5().setText(objSaude.getVidaSexualAtiva());
		frame.getTfS6().setText(objSaude.getUsoDeMedicacao());
		frame.getTfS7().setText(objSaude.getDiabetes());
		frame.getTfS8().setText(objSaude.getDorNoPeito());
		frame.getTfS9().setText(objSaude.getHipertensao());
		frame.getTfS10().setText(objSaude.getColesterolAlto());
		frame.getTfS11().setText(objSaude.getTriglicerides());
		frame.getTfS12().setText(objSaude.getAnemia());
		frame.getTfS13().setText(objSaude.getGota());
		frame.getTfS14().setText(objSaude.getAlergia());
		frame.getTfS15().setText(objSaude.getPatologiaCardiaca());
		frame.getTfS16().setText(objSaude.getArritmia());
		frame.getTfS17().setText(objSaude.getInfarto());
		frame.getTfS18().setText(objSaude.getStent());
		frame.getTfS19().setText(objSaude.getCateterismo());
		frame.getTfS20().setText(objSaude.getaVC());
		frame.getTfS21().setText(objSaude.getRenal());
		frame.getTfS22().setText(objSaude.getCancer());
		frame.getTfS23().setText(objSaude.getHepatite());
		frame.getTfS24().setText(objSaude.getLabirintite());
		frame.getTfS25().setText(objSaude.getPatologiaArterial());
		frame.getTfS26().setText(objSaude.getPatologiaPulmonar());
		frame.getTfS27().setText(objSaude.getTireoide());
		frame.getTfS28().setText(objSaude.getHabitoMesntrual());
		frame.getTfS29().setText(objSaude.getHabitoIntestinal());
		frame.getTfS30().setText(objSaude.getPatologiaOrtopedica());
		frame.getTfS31().setText(objSaude.getDoresDeCabeca());
		frame.getTfDtCadastroS().setText(formato.format(objSaude.getDtCadastroS()));
		return frame;
	}

	// método seta o frame com nulo
	private void setarNullFrame(FormSaude frame2) {
		frame.getTfCPFClienteS().setText("");
		frame.getTfNomeCliente().setText("Nome Cliente");
		frame.getTfS1().setText("");
		frame.getTfS2().setText("");
		frame.getTfS3().setText("");
		frame.getTfS4().setText("");
		frame.getTfS5().setText("");
		frame.getTfS6().setText("");
		frame.getTfS7().setText("");
		frame.getTfS8().setText("");
		frame.getTfS9().setText("");
		frame.getTfS10().setText("");
		frame.getTfS11().setText("");
		frame.getTfS12().setText("");
		frame.getTfS13().setText("");
		frame.getTfS14().setText("");
		frame.getTfS15().setText("");
		frame.getTfS16().setText("");
		frame.getTfS17().setText("");
		frame.getTfS18().setText("");
		frame.getTfS19().setText("");
		frame.getTfS20().setText("");
		frame.getTfS21().setText("");
		frame.getTfS22().setText("");
		frame.getTfS23().setText("");
		frame.getTfS24().setText("");
		frame.getTfS25().setText("");
		frame.getTfS26().setText("");
		frame.getTfS27().setText("");
		frame.getTfS28().setText("");
		frame.getTfS29().setText("");
		frame.getTfS30().setText("");
		frame.getTfS31().setText("");
		frame.getTfDtCadastroS().setText("");

	}

}
