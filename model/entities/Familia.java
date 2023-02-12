package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * classe Familia com atributos dos campos da tabela. 
 */
public class Familia implements Serializable {

	private static final long serialVersionUID = 1L;

	// atributos
	private String cpfCliente;
	private Date dtCadastroHF;
	private String patologiaCardiaca;
	private String patologiaArterial;
	private String patologiaPulmonar;
	private String tabagista;
	private String etilista;
	private String diabetes;
	private String cancer;
	private String hipertensao;
	private String renal;
	private String aVC;
	private String asma;

	// construtor padrão vazio
	public Familia() {
	}

	// construtor com argumentos
	public Familia(String cpfCliente, Date dtCadastroHF, String patologiaCardiaca, String patologiaArterial,
			String patologiaPulmonar, String tabagista, String etilista, String diabetes, String cancer,
			String hipertensao, String renal, String aVC, String asma) {
		this.cpfCliente = cpfCliente;
		this.dtCadastroHF = dtCadastroHF;
		this.patologiaCardiaca = patologiaCardiaca;
		this.patologiaArterial = patologiaArterial;
		this.patologiaPulmonar = patologiaPulmonar;
		this.tabagista = tabagista;
		this.etilista = etilista;
		this.diabetes = diabetes;
		this.cancer = cancer;
		this.hipertensao = hipertensao;
		this.renal = renal;
		this.aVC = aVC;
		this.asma = asma;
	}

	// gethers e sethers
	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Date getdtCadastroHF() {
		return dtCadastroHF;
	}

	public void setdtCadastroHF(Date dtCadastroHF) {
		this.dtCadastroHF = dtCadastroHF;
	}

	public String getPatologiaCardiaca() {
		return patologiaCardiaca;
	}

	public void setPatologiaCardiaca(String patologiaCardiaca) {
		this.patologiaCardiaca = patologiaCardiaca;
	}

	public String getPatologiaArterial() {
		return patologiaArterial;
	}

	public void setPatologiaArterial(String patologiaArterial) {
		this.patologiaArterial = patologiaArterial;
	}

	public String getPatologiaPulmonar() {
		return patologiaPulmonar;
	}

	public void setPatologiaPulmonar(String patologiaPulmonar) {
		this.patologiaPulmonar = patologiaPulmonar;
	}

	public String getTabagista() {
		return tabagista;
	}

	public void setTabagista(String tabagista) {
		this.tabagista = tabagista;
	}

	public String getEtilista() {
		return etilista;
	}

	public void setEtilista(String etilista) {
		this.etilista = etilista;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public String getCancer() {
		return cancer;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public String getHipertensao() {
		return hipertensao;
	}

	public void setHipertensao(String hipertensao) {
		this.hipertensao = hipertensao;
	}

	public String getRenal() {
		return renal;
	}

	public void setRenal(String renal) {
		this.renal = renal;
	}

	public String getaVC() {
		return aVC;
	}

	public void setaVC(String aVC) {
		this.aVC = aVC;
	}

	public String getAsma() {
		return asma;
	}

	public void setAsma(String asma) {
		this.asma = asma;
	}

	// hash cod e equals para que os objetos possam ser comparados pelo conteúdo
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
		Familia other = (Familia) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	// toString
	@Override
	public String toString() {
		return "HistoriaFamilia [cpfCliente=" + cpfCliente + ", dtCadastroHF=" + dtCadastroHF + ", patologiaCardiaca="
				+ patologiaCardiaca + ", patologiaArterial=" + patologiaArterial + ", patologiaPulmonar="
				+ patologiaPulmonar + ", tabagista=" + tabagista + ", etilista=" + etilista + ", diabetes=" + diabetes
				+ ", cancer=" + cancer + ", hipertensao=" + hipertensao + ", renal=" + renal + ", aVC=" + aVC
				+ ", asma=" + asma + "]";
	}
}
