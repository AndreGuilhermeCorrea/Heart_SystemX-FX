package controller.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import controller.Icontroller;
import controller.fxml.FormFamilia;
import model.entities.ClienteView;
import model.entities.Familia;
import model.service.ClienteService;
import model.service.FamiliaService;

public class FamiliaCT implements Icontroller {

	private Familia objFam;
	private ClienteView objClienteView;
	private ClienteService servicoClient;
	private FamiliaService servicoFamilia;
	private FormFamilia frame;

	// envia solicitação para camada de serviço e retorna objeto carregado
	private ClienteView pesquisaView(String cpf) {
		this.servicoClient = new ClienteService();
		objClienteView = servicoClient.pespesquisaCPFeNome(cpf);
		return objClienteView;
	}

	// envia solicitação para camada de serviço e retorna objeto carregado
	private Familia findByCpf(String cpf) {
		this.servicoFamilia = new FamiliaService();
		objFam = servicoFamilia.pesquisaView(cpf);
		return objFam;
	}

	// pesquisa cliente cadastrado
	@Override
	public void pesquisaCpf(Object view) {
		frame = (FormFamilia) view;
		String cpf = frame.getTfCpfFam().getText();
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
				frame.getTfNomeFam().setText(objClienteView.getNomeCompleto());
			}
		}
	}

	// insere cliente nessa tabela com base no objeto passado para camada de servico
	@Override
	public void inserir(Object view) {
		frame = (FormFamilia) view;
		String cpf = frame.getTfCpfFam().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			// chamada do método
			this.objFam = instanciaOBJ(frame);
			// envia solicitação para camada de serviço com objeto carregado
			servicoFamilia = new FamiliaService();
			servicoFamilia.insert(objFam);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// atualiza cliente nessa tabela com base no objeto passado para camada de
	// servico
	@Override
	public void atualizar(Object view) {
		frame = (FormFamilia) view;
		String cpf = frame.getTfCpfFam().getText();
		// teste para cpf nao nulo
		if (cpf.equals("")) {
			JOptionPane.showMessageDialog(null, "O Campo CPF nao Pode ser Nulo!");
		} else {
			int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja alterar o Cliente dessa tabela?",
					"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
			if (sai == JOptionPane.YES_OPTION) {
				// chamada do método
				this.objFam = instanciaOBJ(frame);
				// envia solicitação para camada de serviço com objeto carregado
				this.servicoFamilia.update(objFam);
				// chama o metodo para anular os tf passando o frame como objeto
				setarNullFrame(frame);
			}
		}
	}

	// deleta o cliente com base no cpf passado para camada de servico
	@Override
	public void deletar(Object view) {
		frame = (FormFamilia) view;
		String cpf = frame.getTfCpfFam().getText();
		int sai = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Remover o Cliente dessa tabela?",
				"Aten��o! Essa a��o n�o pode ser desfeita!", JOptionPane.YES_NO_OPTION);
		if (sai == JOptionPane.YES_OPTION) {
			// envia solicitação para camada de serviço
			this.servicoFamilia.deleteByCpf(cpf);
			// chama o metodo para anular os tf passando o frame como objeto
			setarNullFrame(frame);
		}
	}

	// pesquisa cliente ja cadastrado nessa tabela e retorna o objeto
	@Override
	public void buscaObj(Object view) {
		frame = (FormFamilia) view;
		String cpf = frame.getTfCpfFam().getText();
		findByCpf(cpf);
		// chamada do método
		frame = instanciaForm(objFam);
	}

	// método seta o objeto com o frame passado
	private Familia instanciaOBJ(FormFamilia frame) {
		this.objFam = new Familia();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		objFam.setCpfCliente(frame.getTfCpfFam().getText());
		objFam.setPatologiaCardiaca(frame.getTfFam1().getText());
		objFam.setPatologiaArterial(frame.getTfFam2().getText());
		objFam.setPatologiaPulmonar(frame.getTfFam3().getText());
		objFam.setTabagista(frame.getTfFam4().getText());
		objFam.setEtilista(frame.getTfFam5().getText());
		objFam.setDiabetes(frame.getTfFam6().getText());
		objFam.setCancer(frame.getTfFam7().getText());
		objFam.setHipertensao(frame.getTfFam8().getText());
		objFam.setRenal(frame.getTfFam9().getText());
		objFam.setaVC(frame.getTfFam10().getText());
		objFam.setAsma(frame.getTfFam11().getText());
		try {
			objFam.setdtCadastroHF(formato.parse(frame.getTfDtCadFam().getText()));
		} catch (ParseException e) {
		}
		return objFam;
	}

	// método seta o Frame com o o objeto passado
	private FormFamilia instanciaForm(Familia objFam) {
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		frame.getTfFam1().setText(objFam.getPatologiaCardiaca());
		frame.getTfFam2().setText(objFam.getPatologiaArterial());
		frame.getTfFam3().setText(objFam.getPatologiaPulmonar());
		frame.getTfFam4().setText(objFam.getTabagista());
		frame.getTfFam5().setText(objFam.getEtilista());
		frame.getTfFam6().setText(objFam.getDiabetes());
		frame.getTfFam7().setText(objFam.getCancer());
		frame.getTfFam8().setText(objFam.getHipertensao());
		frame.getTfFam9().setText(objFam.getRenal());
		frame.getTfFam10().setText(objFam.getaVC());
		frame.getTfFam11().setText(objFam.getAsma());
		frame.getTfDtCadFam().setText(formato.format(objFam.getdtCadastroHF()));
		return frame;
	}

	// método seta o frame com nulo
	private void setarNullFrame(FormFamilia frame) {
		frame.getTfCpfFam().setText("");
		frame.getTfNomeFam().setText("Nome Cliente");
		frame.getTfFam1().setText("");
		frame.getTfFam2().setText("");
		frame.getTfFam3().setText("");
		frame.getTfFam4().setText("");
		frame.getTfFam5().setText("");
		frame.getTfFam6().setText("");
		frame.getTfFam7().setText("");
		frame.getTfFam8().setText("");
		frame.getTfFam9().setText("");
		frame.getTfFam10().setText("");
		frame.getTfFam11().setText("");
		frame.getTfDtCadFam().setText("");
	}

}
