package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PsicoAltoRisco implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Questionário investigativo para clientes cujo atendimento psiquico inicial
	 * resulta de comportamento suicida
	 */

	/*
	 * 1- primeiro - Voce tem pensado em se machucar? 2- segundo Voce pensa em dar
	 * fim a sua vida? 3- terceiro Voce tem pensado em suicídio? 4- quarto Sente
	 * que a vida perdeu o sentido? 5- quinto Voce pensou que seria melhor morrer?
	 * 6- sexto Sente-se útil na vida que está levando? 7- setimo Voce alguma vez
	 * pensou ou está pensando em se machucar agora? 8- oitavo Voce tem se sentido
	 * tão mal que chega a pensar em se machucar? 9- nono Voce tem um plano para se
	 * matar? 10- decimo Voce tem um plano de como faria isso? 11- decimoPrimeiro
	 * Tem desejo de receber ajuda?
	 * 
	 */

	// atributos
	private String cpfCliente;
	private String primeiro;
	private String segundo;
	private String terceiro;
	private String quarto;
	private String quinto;
	private String sexto;
	private String setimo;
	private String oitavo;
	private String nono;
	private String decimo;
	private String decimoPrimeiro;
	private Date dtCadastroHPAR;

	public PsicoAltoRisco() {
	}

	public PsicoAltoRisco(String cpfCliente, String primeiro, String segundo, String terceiro, String quarto,
			String quinto, String sexto, String setimo, String oitavo, String nono, String decimo,
			String decimoPrimeiro, Date dtCadastroHPAR) {
		this.cpfCliente = cpfCliente;
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.terceiro = terceiro;
		this.quarto = quarto;
		this.quinto = quinto;
		this.sexto = sexto;
		this.setimo = setimo;
		this.oitavo = oitavo;
		this.nono = nono;
		this.decimo = decimo;
		this.decimoPrimeiro = decimoPrimeiro;
		this.dtCadastroHPAR = dtCadastroHPAR;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getPrimeiro() {
		return primeiro;
	}

	public String getSegundo() {
		return segundo;
	}

	public String getTerceiro() {
		return terceiro;
	}

	public String getQuarto() {
		return quarto;
	}

	public String getQuinto() {
		return quinto;
	}

	public String getSexto() {
		return sexto;
	}

	public String getSetimo() {
		return setimo;
	}

	public String getOitavo() {
		return oitavo;
	}

	public String getNono() {
		return nono;
	}

	public String getDecimo() {
		return decimo;
	}

	public String getDecimoPrimeiro() {
		return decimoPrimeiro;
	}

	public Date getDtCadastroHPAR() {
		return dtCadastroHPAR;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setPrimeiro(String primeiro) {
		this.primeiro = primeiro;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	public void setTerceiro(String terceiro) {
		this.terceiro = terceiro;
	}

	public void setQuarto(String quarto) {
		this.quarto = quarto;
	}

	public void setQuinto(String quinto) {
		this.quinto = quinto;
	}

	public void setSexto(String sexto) {
		this.sexto = sexto;
	}

	public void setSetimo(String setimo) {
		this.setimo = setimo;
	}

	public void setOitavo(String oitavo) {
		this.oitavo = oitavo;
	}

	public void setNono(String nono) {
		this.nono = nono;
	}

	public void setDecimo(String decimo) {
		this.decimo = decimo;
	}

	public void setDecimoPrimeiro(String decimoPrimeiro) {
		this.decimoPrimeiro = decimoPrimeiro;
	}

	public void setDtCadastroHPAR(Date dtCadastroHPAR) {
		this.dtCadastroHPAR = dtCadastroHPAR;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PsicoAltoRisco other = (PsicoAltoRisco) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	@Override
	public String toString() {
		return "PsicoAltoRisco [cpfCliente=" + cpfCliente + ", primeiro=" + primeiro + ", segundo=" + segundo
				+ ", terceiro=" + terceiro + ", quarto=" + quarto + ", quinto=" + quinto + ", sexto=" + sexto
				+ ", setimo=" + setimo + ", oitavo=" + oitavo + ", nono=" + nono + ", decimo=" + decimo
				+ ", decimoPrimeiro=" + decimoPrimeiro + ", dtCadastroHPAR=" + dtCadastroHPAR + "]";
	}

}
