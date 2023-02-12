package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Antropometria implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeCliente;
	private Date dtNasci;
	private Integer idade;
	private String sexo;
	private String cpfCliente;
	private Date dtCadastroA;
	private Double peso;
	private Double altura;
	private Double imc;
	private String cImc;
	private Integer pedometro1;
	private Integer pedometro2;
	private Integer pedometro3;
	private Double pedometroMedia;
	private String pedometroClass;
	private Double sentarAlcanca;
	private Double cPunho;
	private Double cCintura;
	private Double cQuadril;
	private Double razaoCQ;
	private Double pesoDesejavel;
	private Double imcDesejavel;
	private String cRiscoSaude;
	private Double pesoAjustado;
	private Double adequacaoPeso;
	private Double compleicao;
	private String tipoComp;
	private String nivelFlexibilidade;
	private Double pregaCutaneaTorax;
	private Double pregaCutaneaAbdomem;
	private Double pregaCutaneaCoxa;
	private Double pregaCutaneaTriciptal;
	private Double pregaCutaneaSuprailiaca;
	private Double somaDobrasCutaneas;
	private Double massaCMagra;
	private Double massaCGorda;
	private Double massaCPercentual;
	private Double densidade;

	public Antropometria() {
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public Date getDtNasci() {
		return dtNasci;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public Date getDtCadastroA() {
		return dtCadastroA;
	}

	public Double getPeso() {
		return peso;
	}

	public Double getAltura() {
		return altura;
	}

	public Double getImc() {
		return imc;
	}

	public String getcImc() {
		return cImc;
	}

	public Integer getPedometro1() {
		return pedometro1;
	}

	public Integer getPedometro2() {
		return pedometro2;
	}

	public Integer getPedometro3() {
		return pedometro3;
	}

	public Double getPedometroMedia() {
		return pedometroMedia;
	}

	public String getPedometroClass() {
		return pedometroClass;
	}

	public Double getSentarAlcanca() {
		return sentarAlcanca;
	}

	public Double getcPunho() {
		return cPunho;
	}

	public Double getcCintura() {
		return cCintura;
	}

	public Double getcQuadril() {
		return cQuadril;
	}

	public Double getRazaoCQ() {
		return razaoCQ;
	}

	public Double getPesoDesejavel() {
		return pesoDesejavel;
	}

	public Double getImcDesejavel() {
		return imcDesejavel;
	}

	public String getcRiscoSaude() {
		return cRiscoSaude;
	}

	public Double getPesoAjustado() {
		return pesoAjustado;
	}

	public Double getAdequacaoPeso() {
		return adequacaoPeso;
	}

	public Double getCompleicao() {
		return compleicao;
	}

	public String getTipoComp() {
		return tipoComp;
	}

	public String getNivelFlexibilidade() {
		return nivelFlexibilidade;
	}

	public Double getPregaCutaneaTorax() {
		return pregaCutaneaTorax;
	}

	public Double getPregaCutaneaAbdomem() {
		return pregaCutaneaAbdomem;
	}

	public Double getPregaCutaneaCoxa() {
		return pregaCutaneaCoxa;
	}

	public Double getPregaCutaneaTriciptal() {
		return pregaCutaneaTriciptal;
	}

	public Double getPregaCutaneaSuprailiaca() {
		return pregaCutaneaSuprailiaca;
	}

	public Double getSomaDobrasCutaneas() {
		return somaDobrasCutaneas;
	}

	public Double getMassaCMagra() {
		return massaCMagra;
	}

	public Double getMassaCGorda() {
		return massaCGorda;
	}

	public Double getMassaCPercentual() {
		return massaCPercentual;
	}

	public Double getDensidade() {
		return densidade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setDtNasci(Date dtNasci) {
		this.dtNasci = dtNasci;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setDtCadastroA(Date dtCadastroA) {
		this.dtCadastroA = dtCadastroA;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}

	public void setcImc(String cImc) {
		this.cImc = cImc;
	}

	public void setPedometro1(Integer pedometro1) {
		this.pedometro1 = pedometro1;
	}

	public void setPedometro2(Integer pedometro2) {
		this.pedometro2 = pedometro2;
	}

	public void setPedometro3(Integer pedometro3) {
		this.pedometro3 = pedometro3;
	}

	public void setPedometroMedia(Double pedometroMedia) {
		this.pedometroMedia = pedometroMedia;
	}

	public void setPedometroClass(String pedometroClass) {
		this.pedometroClass = pedometroClass;
	}

	public void setSentarAlcanca(Double sentarAlcanca) {
		this.sentarAlcanca = sentarAlcanca;
	}

	public void setcPunho(Double cPunho) {
		this.cPunho = cPunho;
	}

	public void setcCintura(Double cCintura) {
		this.cCintura = cCintura;
	}

	public void setcQuadril(Double cQuadril) {
		this.cQuadril = cQuadril;
	}

	public void setRazaoCQ(Double razaoCQ) {
		this.razaoCQ = razaoCQ;
	}

	public void setPesoDesejavel(Double pesoDesejavel) {
		this.pesoDesejavel = pesoDesejavel;
	}

	public void setImcDesejavel(Double imcDesejavel) {
		this.imcDesejavel = imcDesejavel;
	}

	public void setcRiscoSaude(String cRiscoSaude) {
		this.cRiscoSaude = cRiscoSaude;
	}

	public void setPesoAjustado(Double pesoAjustado) {
		this.pesoAjustado = pesoAjustado;
	}

	public void setAdequacaoPeso(Double adequacaoPeso) {
		this.adequacaoPeso = adequacaoPeso;
	}

	public void setCompleicao(Double compleicao) {
		this.compleicao = compleicao;
	}

	public void setTipoComp(String tipoComp) {
		this.tipoComp = tipoComp;
	}

	public void setNivelFlexibilidade(String nivelFlexibilidade) {
		this.nivelFlexibilidade = nivelFlexibilidade;
	}

	public void setPregaCutaneaTorax(Double pregaCutaneaTorax) {
		this.pregaCutaneaTorax = pregaCutaneaTorax;
	}

	public void setPregaCutaneaAbdomem(Double pregaCutaneaAbdomem) {
		this.pregaCutaneaAbdomem = pregaCutaneaAbdomem;
	}

	public void setPregaCutaneaCoxa(Double pregaCutaneaCoxa) {
		this.pregaCutaneaCoxa = pregaCutaneaCoxa;
	}

	public void setPregaCutaneaTriciptal(Double pregaCutaneaTriciptal) {
		this.pregaCutaneaTriciptal = pregaCutaneaTriciptal;
	}

	public void setPregaCutaneaSuprailiaca(Double pregaCutaneaSuprailiaca) {
		this.pregaCutaneaSuprailiaca = pregaCutaneaSuprailiaca;
	}

	public void setSomaDobrasCutaneas(Double somaDobrasCutaneas) {
		this.somaDobrasCutaneas = somaDobrasCutaneas;
	}

	public void setMassaCMagra(Double massaCMagra) {
		this.massaCMagra = massaCMagra;
	}

	public void setMassaCGorda(Double massaCGorda) {
		this.massaCGorda = massaCGorda;
	}

	public void setMassaCPercentual(Double massaCPercentual) {
		this.massaCPercentual = massaCPercentual;
	}

	public void setDensidade(Double densidade) {
		this.densidade = densidade;
	}

	public Antropometria(String nomeCliente, Date dtNasci, Integer idade, String cpfCliente, String sexo,
			Date dtCadastroA, Double peso, Double altura, Double imc, String cImc, Integer pedometro1,
			Integer pedometro2, Integer pedometro3, Double pedometroMedia, String pedometroClass, Double sentarAlcanca,
			Double cPunho, Double cCintura, Double cQuadril, Double razaoCQ, Double pesoDesejavel, Double imcDesejavel,
			String cRiscoSaude, Double pesoAjustado, Double adequacaoPeso, Double compleicao, String tipoComp,
			String nivelFlexibilidade, Double pregaCutaneaTorax, Double pregaCutaneaAbdomem, Double pregaCutaneaCoxa,
			Double pregaCutaneaTriciptal, Double pregaCutaneaSuprailiaca, Double somaDobrasCutaneas, Double massaCMagra,
			Double massaCGorda, Double massaCPercentual, Double densidade) {
		super();
		this.nomeCliente = nomeCliente;
		this.dtNasci = dtNasci;
		this.idade = idade;
		this.cpfCliente = cpfCliente;
		this.sexo = sexo;
		this.dtCadastroA = dtCadastroA;
		this.peso = peso;
		this.altura = altura;
		this.imc = imc;
		this.cImc = cImc;
		this.pedometro1 = pedometro1;
		this.pedometro2 = pedometro2;
		this.pedometro3 = pedometro3;
		this.pedometroMedia = pedometroMedia;
		this.pedometroClass = pedometroClass;
		this.sentarAlcanca = sentarAlcanca;
		this.cPunho = cPunho;
		this.cCintura = cCintura;
		this.cQuadril = cQuadril;
		this.razaoCQ = razaoCQ;
		this.pesoDesejavel = pesoDesejavel;
		this.imcDesejavel = imcDesejavel;
		this.cRiscoSaude = cRiscoSaude;
		this.pesoAjustado = pesoAjustado;
		this.adequacaoPeso = adequacaoPeso;
		this.compleicao = compleicao;
		this.tipoComp = tipoComp;
		this.nivelFlexibilidade = nivelFlexibilidade;
		this.pregaCutaneaTorax = pregaCutaneaTorax;
		this.pregaCutaneaAbdomem = pregaCutaneaAbdomem;
		this.pregaCutaneaCoxa = pregaCutaneaCoxa;
		this.pregaCutaneaTriciptal = pregaCutaneaTriciptal;
		this.pregaCutaneaSuprailiaca = pregaCutaneaSuprailiaca;
		this.somaDobrasCutaneas = somaDobrasCutaneas;
		this.massaCMagra = massaCMagra;
		this.massaCGorda = massaCGorda;
		this.massaCPercentual = massaCPercentual;
		this.densidade = densidade;
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
		Antropometria other = (Antropometria) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	@Override
	public String toString() {
		return "Antropometria [nomeCliente=" + nomeCliente + ", dtNasci=" + dtNasci + ", idade=" + idade
				+ ", cpfCliente=" + cpfCliente + ", sexo=" + sexo + ", dtCadastroA=" + dtCadastroA + ", peso=" + peso
				+ ", altura=" + altura + ", imc=" + imc + ", cImc=" + cImc + ", pedometro1=" + pedometro1
				+ ", pedometro2=" + pedometro2 + ", pedometro3=" + pedometro3 + ", pedometroMedia=" + pedometroMedia
				+ ", pedometroClass=" + pedometroClass + ", sentarAlcanca=" + sentarAlcanca + ", cPunho=" + cPunho
				+ ", cCintura=" + cCintura + ", cQuadril=" + cQuadril + ", razaoCQ=" + razaoCQ + ", pesoDesejavel="
				+ pesoDesejavel + ", imcDesejavel=" + imcDesejavel + ", cRiscoSaude=" + cRiscoSaude + ", pesoAjustado="
				+ pesoAjustado + ", adequacaoPeso=" + adequacaoPeso + ", compleicao=" + compleicao + ", tipoComp="
				+ tipoComp + ", nivelFlexibilidade=" + nivelFlexibilidade + ", pregaCutaneaTorax=" + pregaCutaneaTorax
				+ ", pregaCutaneaAbdomem=" + pregaCutaneaAbdomem + ", pregaCutaneaCoxa=" + pregaCutaneaCoxa
				+ ", pregaCutaneaTriciptal=" + pregaCutaneaTriciptal + ", pregaCutaneaSuprailiaca="
				+ pregaCutaneaSuprailiaca + ", somaDobrasCutaneas=" + somaDobrasCutaneas + ", massaCMagra="
				+ massaCMagra + ", massaCGorda=" + massaCGorda + ", massaCPercentual=" + massaCPercentual
				+ ", densidade=" + densidade + "]";
	}

}