package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * classe entidade do negócio com os atributos da tabela. 
 */

public class Saude implements Serializable {

	private static final long serialVersionUID = 1L;

	// atributos
	private String cpfCliente;
	private Date dtCadastroS;
	private String tabagista;
	private String etilista;
	private String dieta;
	private String faltaDeAr;
	private String vidaSexualAtiva;
	private String usoDeMedicacao;
	private String diabetes;
	private String dorNoPeito;
	private String hipertensao;
	private String colesterolAlto;
	private String triglicerides;
	private String anemia;
	private String gota;
	private String alergia;
	private String patologiaCardiaca;
	private String arritmia;
	private String infarto;
	private String stent;
	private String cateterismo;
	private String aVC;
	private String renal;
	private String cancer;
	private String hepatite;
	private String labirintite;
	private String patologiaArterial;
	private String patologiaPulmonar;
	private String tireoide;
	private String habitoMesntrual;
	private String habitoIntestinal;
	private String patologiaOrtopedica;
	private String doresDeCabeca;

	public Saude() {
	}

	public Saude(String cpfCliente, Date dtCadastroS, String tabagista, String etilista, String dieta, String faltaDeAr,
			String vidaSexualAtiva, String usoDeMedicacao, String diabetes, String dorNoPeito, String hipertensao,
			String colesterolAlto, String triglicerides, String anemia, String gota, String alergia,
			String patologiaCardiaca, String arritmia, String infarto, String stent, String cateterismo, String aVC,
			String renal, String cancer, String hepatite, String labirintite, String patologiaArterial,
			String patologiaPulmonar, String tireoide, String habitoMesntrual, String habitoIntestinal,
			String patologiaOrtopedica, String doresDeCabeca) {
		super();
		this.cpfCliente = cpfCliente;
		this.dtCadastroS = dtCadastroS;
		this.tabagista = tabagista;
		this.etilista = etilista;
		this.dieta = dieta;
		this.faltaDeAr = faltaDeAr;
		this.vidaSexualAtiva = vidaSexualAtiva;
		this.usoDeMedicacao = usoDeMedicacao;
		this.diabetes = diabetes;
		this.dorNoPeito = dorNoPeito;
		this.hipertensao = hipertensao;
		this.colesterolAlto = colesterolAlto;
		this.triglicerides = triglicerides;
		this.anemia = anemia;
		this.gota = gota;
		this.alergia = alergia;
		this.patologiaCardiaca = patologiaCardiaca;
		this.arritmia = arritmia;
		this.infarto = infarto;
		this.stent = stent;
		this.cateterismo = cateterismo;
		this.aVC = aVC;
		this.renal = renal;
		this.cancer = cancer;
		this.hepatite = hepatite;
		this.labirintite = labirintite;
		this.patologiaArterial = patologiaArterial;
		this.patologiaPulmonar = patologiaPulmonar;
		this.tireoide = tireoide;
		this.habitoMesntrual = habitoMesntrual;
		this.habitoIntestinal = habitoIntestinal;
		this.patologiaOrtopedica = patologiaOrtopedica;
		this.doresDeCabeca = doresDeCabeca;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public Date getDtCadastroS() {
		return dtCadastroS;
	}

	public String getTabagista() {
		return tabagista;
	}

	public String getEtilista() {
		return etilista;
	}

	public String getDieta() {
		return dieta;
	}

	public String getFaltaDeAr() {
		return faltaDeAr;
	}

	public String getVidaSexualAtiva() {
		return vidaSexualAtiva;
	}

	public String getUsoDeMedicacao() {
		return usoDeMedicacao;
	}

	public String getDiabetes() {
		return diabetes;
	}

	public String getDorNoPeito() {
		return dorNoPeito;
	}

	public String getHipertensao() {
		return hipertensao;
	}

	public String getColesterolAlto() {
		return colesterolAlto;
	}

	public String getTriglicerides() {
		return triglicerides;
	}

	public String getAnemia() {
		return anemia;
	}

	public String getGota() {
		return gota;
	}

	public String getAlergia() {
		return alergia;
	}

	public String getPatologiaCardiaca() {
		return patologiaCardiaca;
	}

	public String getArritmia() {
		return arritmia;
	}

	public String getInfarto() {
		return infarto;
	}

	public String getStent() {
		return stent;
	}

	public String getCateterismo() {
		return cateterismo;
	}

	public String getaVC() {
		return aVC;
	}

	public String getRenal() {
		return renal;
	}

	public String getCancer() {
		return cancer;
	}

	public String getHepatite() {
		return hepatite;
	}

	public String getLabirintite() {
		return labirintite;
	}

	public String getPatologiaArterial() {
		return patologiaArterial;
	}

	public String getPatologiaPulmonar() {
		return patologiaPulmonar;
	}

	public String getTireoide() {
		return tireoide;
	}

	public String getHabitoMesntrual() {
		return habitoMesntrual;
	}

	public String getHabitoIntestinal() {
		return habitoIntestinal;
	}

	public String getPatologiaOrtopedica() {
		return patologiaOrtopedica;
	}

	public String getDoresDeCabeca() {
		return doresDeCabeca;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setDtCadastroS(Date dtCadastroS) {
		this.dtCadastroS = dtCadastroS;
	}

	public void setTabagista(String tabagista) {
		this.tabagista = tabagista;
	}

	public void setEtilista(String etilista) {
		this.etilista = etilista;
	}

	public void setDieta(String dieta) {
		this.dieta = dieta;
	}

	public void setFaltaDeAr(String faltaDeAr) {
		this.faltaDeAr = faltaDeAr;
	}

	public void setVidaSexualAtiva(String vidaSexualAtiva) {
		this.vidaSexualAtiva = vidaSexualAtiva;
	}

	public void setUsoDeMedicacao(String usoDeMedicacao) {
		this.usoDeMedicacao = usoDeMedicacao;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	public void setDorNoPeito(String dorNoPeito) {
		this.dorNoPeito = dorNoPeito;
	}

	public void setHipertensao(String hipertensao) {
		this.hipertensao = hipertensao;
	}

	public void setColesterolAlto(String colesterolAlto) {
		this.colesterolAlto = colesterolAlto;
	}

	public void setTriglicerides(String triglicerides) {
		this.triglicerides = triglicerides;
	}

	public void setAnemia(String anemia) {
		this.anemia = anemia;
	}

	public void setGota(String gota) {
		this.gota = gota;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public void setPatologiaCardiaca(String patologiaCardiaca) {
		this.patologiaCardiaca = patologiaCardiaca;
	}

	public void setArritmia(String arritmia) {
		this.arritmia = arritmia;
	}

	public void setInfarto(String infarto) {
		this.infarto = infarto;
	}

	public void setStent(String stent) {
		this.stent = stent;
	}

	public void setCateterismo(String cateterismo) {
		this.cateterismo = cateterismo;
	}

	public void setaVC(String aVC) {
		this.aVC = aVC;
	}

	public void setRenal(String renal) {
		this.renal = renal;
	}

	public void setCancer(String cancer) {
		this.cancer = cancer;
	}

	public void setHepatite(String hepatite) {
		this.hepatite = hepatite;
	}

	public void setLabirintite(String labirintite) {
		this.labirintite = labirintite;
	}

	public void setPatologiaArterial(String patologiaArterial) {
		this.patologiaArterial = patologiaArterial;
	}

	public void setPatologiaPulmonar(String patologiaPulmonar) {
		this.patologiaPulmonar = patologiaPulmonar;
	}

	public void setTireoide(String tireoide) {
		this.tireoide = tireoide;
	}

	public void setHabitoMesntrual(String habitoMesntrual) {
		this.habitoMesntrual = habitoMesntrual;
	}

	public void setHabitoIntestinal(String habitoIntestinal) {
		this.habitoIntestinal = habitoIntestinal;
	}

	public void setPatologiaOrtopedica(String patologiaOrtopedica) {
		this.patologiaOrtopedica = patologiaOrtopedica;
	}

	public void setDoresDeCabeca(String doresDeCabeca) {
		this.doresDeCabeca = doresDeCabeca;
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
		Saude other = (Saude) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	@Override
	public String toString() {
		return "Saude [cpfCliente=" + cpfCliente + ", dtCadastroS=" + dtCadastroS + ", tabagista=" + tabagista
				+ ", etilista=" + etilista + ", dieta=" + dieta + ", faltaDeAr=" + faltaDeAr + ", vidaSexualAtiva="
				+ vidaSexualAtiva + ", usoDeMedicacao=" + usoDeMedicacao + ", diabetes=" + diabetes + ", dorNoPeito="
				+ dorNoPeito + ", hipertensao=" + hipertensao + ", colesterolAlto=" + colesterolAlto
				+ ", triglicerides=" + triglicerides + ", anemia=" + anemia + ", gota=" + gota + ", alergia=" + alergia
				+ ", patologiaCardiaca=" + patologiaCardiaca + ", arritmia=" + arritmia + ", infarto=" + infarto
				+ ", stent=" + stent + ", cateterismo=" + cateterismo + ", aVC=" + aVC + ", renal=" + renal
				+ ", cancer=" + cancer + ", hepatite=" + hepatite + ", labirintite=" + labirintite
				+ ", patologiaArterial=" + patologiaArterial + ", patologiaPulmonar=" + patologiaPulmonar
				+ ", tireoide=" + tireoide + ", habitoMesntrual=" + habitoMesntrual + ", habitoIntestinal="
				+ habitoIntestinal + ", patologiaOrtopedica=" + patologiaOrtopedica + ", doresDeCabeca=" + doresDeCabeca
				+ "]";
	}

}