package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Psico implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * Abordagem psicolÃ³gica ao cliente usuÃ¡rio do programa
	 */

	/*
	 * 1- primeiroHP Tem interesse em acompanhamento PsicolÃ³gico? 2- segundoHP
	 * Possui alguma patologia limitante para exercicio do Programa? 3- terceiroHP
	 * Possui sentimento de tristeza com frequencia? 4- quartoHP Possui sentimento
	 * de solidÃ£o com frequencia? 5- quintoHP Possui algum transtorno? 6- sextoHP
	 * Os pensamentos sÃ£o organizados 7- setimoHP A linguagem e o diÃ¡logo
	 * sÃ£o claros? 8- oitavoHP Possui dificuldade de concentraÃ§Ã£o? 9-
	 * nonoHP Possui dificuldade de memorizar? 10- decimoHP Faz acompanhamento com
	 * psicolÃ³go ou psiquiatra? 11- decimoPrimeiroHP JÃ¡ fez acompanhamento com
	 * psicolÃ³go ou psiquiatra? 12- decimoSegundoHP Sente-se Amado ou acolhido
	 * por Amigos e/ou Familiares? 13- decimoTerceiroHP Dorme bem? 14-
	 * decimoQuartoHP Se Automedica? 15- decimoQuintoHP Faz uso elevado de
	 * Ã�lcool? 16- decimoSextoHP Faz uso de Drogas? 17- decimoSetimoHP Possui
	 * bom relacionamento Familiar? 18- decimoOitavoHP Possui bom relacionamento
	 * Social? 19- decimoNonoHP PrÃ¡tica atividade fÃ­sica? 20- vigesimoHP Voce
	 * possui planos para o futuro? 21- vigesimoPrimeiroHP Pra voce a vida vale a
	 * pena? 22- vigesimoSegundoHP Caso a morte surgisse ela seria bem vinda? 23-
	 * vigesimoTerceiroHP Voce ja cogitou se machucar/ferir/morrer? 24-
	 * vigesimoQuartoHP Voce ja tentou suÃ­cidio?
	 */

	// atributos
	private String cpfCliente;

	private String primeiroHP;
	private String segundoHP;
	private String terceiroHP;
	private String quartoHP;
	private String quintoHP;
	private String sextoHP;
	private String setimoHP;
	private String oitavoHP;
	private String nonoHP;
	private String decimoHP;
	private String decimoPrimeiroHP;
	private String decimoSegundoHP;
	private String decimoTerceiroHP;
	private String decimoQuartoHP;
	private String decimoQuintoHP;
	private String decimoSextoHP;
	private String decimoSetimoHP;
	private String decimoOitavoHP;
	private String decimoNonoHP;
	private String vigesimoHP;
	private String vigesimoPrimeiroHP;
	private String vigesimoSegundoHP;
	private String vigesimoTerceiroHP;
	private String vigesimoQuartoHP;

	private Date dtCadastroHP;

	public Psico() {
	}

	public Psico(String cpfCliente, String primeiroHP, String segundoHP, String terceiroHP, String quartoHP,
			String quintoHP, String sextoHP, String setimoHP, String oitavoHP, String nonoHP, String decimoHP,
			String decimoPrimeiroHP, String decimoSegundoHP, String decimoTerceiroHP, String decimoQuartoHP,
			String decimoQuintoHP, String decimoSextoHP, String decimoSetimoHP, String decimoOitavoHP,
			String decimoNonoHP, String vigesimoHP, String vigesimoPrimeiroHP, String vigesimoSegundoHP,
			String vigesimoTerceiroHP, String vigesimoQuartoHP, Date dtCadastroHP) {
		this.cpfCliente = cpfCliente;
		this.primeiroHP = primeiroHP;
		this.segundoHP = segundoHP;
		this.terceiroHP = terceiroHP;
		this.quartoHP = quartoHP;
		this.quintoHP = quintoHP;
		this.sextoHP = sextoHP;
		this.setimoHP = setimoHP;
		this.oitavoHP = oitavoHP;
		this.nonoHP = nonoHP;
		this.decimoHP = decimoHP;
		this.decimoPrimeiroHP = decimoPrimeiroHP;
		this.decimoSegundoHP = decimoSegundoHP;
		this.decimoTerceiroHP = decimoTerceiroHP;
		this.decimoQuartoHP = decimoQuartoHP;
		this.decimoQuintoHP = decimoQuintoHP;
		this.decimoSextoHP = decimoSextoHP;
		this.decimoSetimoHP = decimoSetimoHP;
		this.decimoOitavoHP = decimoOitavoHP;
		this.decimoNonoHP = decimoNonoHP;
		this.vigesimoHP = vigesimoHP;
		this.vigesimoPrimeiroHP = vigesimoPrimeiroHP;
		this.vigesimoSegundoHP = vigesimoSegundoHP;
		this.vigesimoTerceiroHP = vigesimoTerceiroHP;
		this.vigesimoQuartoHP = vigesimoQuartoHP;
		this.dtCadastroHP = dtCadastroHP;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getPrimeiroHP() {
		return primeiroHP;
	}

	public String getSegundoHP() {
		return segundoHP;
	}

	public String getTerceiroHP() {
		return terceiroHP;
	}

	public String getQuartoHP() {
		return quartoHP;
	}

	public String getQuintoHP() {
		return quintoHP;
	}

	public String getSextoHP() {
		return sextoHP;
	}

	public String getSetimoHP() {
		return setimoHP;
	}

	public String getOitavoHP() {
		return oitavoHP;
	}

	public String getNonoHP() {
		return nonoHP;
	}

	public String getDecimoHP() {
		return decimoHP;
	}

	public String getDecimoPrimeiroHP() {
		return decimoPrimeiroHP;
	}

	public String getDecimoSegundoHP() {
		return decimoSegundoHP;
	}

	public String getDecimoTerceiroHP() {
		return decimoTerceiroHP;
	}

	public String getDecimoQuartoHP() {
		return decimoQuartoHP;
	}

	public String getDecimoQuintoHP() {
		return decimoQuintoHP;
	}

	public String getDecimoSextoHP() {
		return decimoSextoHP;
	}

	public String getDecimoSetimoHP() {
		return decimoSetimoHP;
	}

	public String getDecimoOitavoHP() {
		return decimoOitavoHP;
	}

	public String getDecimoNonoHP() {
		return decimoNonoHP;
	}

	public String getVigesimoHP() {
		return vigesimoHP;
	}

	public String getVigesimoPrimeiroHP() {
		return vigesimoPrimeiroHP;
	}

	public String getVigesimoSegundoHP() {
		return vigesimoSegundoHP;
	}

	public String getVigesimoTerceiroHP() {
		return vigesimoTerceiroHP;
	}

	public String getVigesimoQuartoHP() {
		return vigesimoQuartoHP;
	}

	public Date getDtCadastroHP() {
		return dtCadastroHP;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setPrimeiroHP(String primeiroHP) {
		this.primeiroHP = primeiroHP;
	}

	public void setSegundoHP(String segundoHP) {
		this.segundoHP = segundoHP;
	}

	public void setTerceiroHP(String terceiroHP) {
		this.terceiroHP = terceiroHP;
	}

	public void setQuartoHP(String quartoHP) {
		this.quartoHP = quartoHP;
	}

	public void setQuintoHP(String quintoHP) {
		this.quintoHP = quintoHP;
	}

	public void setSextoHP(String sextoHP) {
		this.sextoHP = sextoHP;
	}

	public void setSetimoHP(String setimoHP) {
		this.setimoHP = setimoHP;
	}

	public void setOitavoHP(String oitavoHP) {
		this.oitavoHP = oitavoHP;
	}

	public void setNonoHP(String nonoHP) {
		this.nonoHP = nonoHP;
	}

	public void setDecimoHP(String decimoHP) {
		this.decimoHP = decimoHP;
	}

	public void setDecimoPrimeiroHP(String decimoPrimeiroHP) {
		this.decimoPrimeiroHP = decimoPrimeiroHP;
	}

	public void setDecimoSegundoHP(String decimoSegundoHP) {
		this.decimoSegundoHP = decimoSegundoHP;
	}

	public void setDecimoTerceiroHP(String decimoTerceiroHP) {
		this.decimoTerceiroHP = decimoTerceiroHP;
	}

	public void setDecimoQuartoHP(String decimoQuartoHP) {
		this.decimoQuartoHP = decimoQuartoHP;
	}

	public void setDecimoQuintoHP(String decimoQuintoHP) {
		this.decimoQuintoHP = decimoQuintoHP;
	}

	public void setDecimoSextoHP(String decimoSextoHP) {
		this.decimoSextoHP = decimoSextoHP;
	}

	public void setDecimoSetimoHP(String decimoSetimoHP) {
		this.decimoSetimoHP = decimoSetimoHP;
	}

	public void setDecimoOitavoHP(String decimoOitavoHP) {
		this.decimoOitavoHP = decimoOitavoHP;
	}

	public void setDecimoNonoHP(String decimoNonoHP) {
		this.decimoNonoHP = decimoNonoHP;
	}

	public void setVigesimoHP(String vigesimoHP) {
		this.vigesimoHP = vigesimoHP;
	}

	public void setVigesimoPrimeiroHP(String vigesimoPrimeiroHP) {
		this.vigesimoPrimeiroHP = vigesimoPrimeiroHP;
	}

	public void setVigesimoSegundoHP(String vigesimoSegundoHP) {
		this.vigesimoSegundoHP = vigesimoSegundoHP;
	}

	public void setVigesimoTerceiroHP(String vigesimoTerceiroHP) {
		this.vigesimoTerceiroHP = vigesimoTerceiroHP;
	}

	public void setVigesimoQuartoHP(String vigesimoQuartoHP) {
		this.vigesimoQuartoHP = vigesimoQuartoHP;
	}

	public void setDtCadastroHP(Date dtCadastroHP) {
		this.dtCadastroHP = dtCadastroHP;
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
		Psico other = (Psico) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	@Override
	public String toString() {
		return "Psico [cpfCliente=" + cpfCliente + ", primeiroHP=" + primeiroHP + ", segundoHP=" + segundoHP
				+ ", terceiroHP=" + terceiroHP + ", quartoHP=" + quartoHP + ", quintoHP=" + quintoHP + ", sextoHP="
				+ sextoHP + ", setimoHP=" + setimoHP + ", oitavoHP=" + oitavoHP + ", nonoHP=" + nonoHP + ", decimoHP="
				+ decimoHP + ", decimoPrimeiroHP=" + decimoPrimeiroHP + ", decimoSegundoHP=" + decimoSegundoHP
				+ ", decimoTerceiroHP=" + decimoTerceiroHP + ", decimoQuartoHP=" + decimoQuartoHP + ", decimoQuintoHP="
				+ decimoQuintoHP + ", decimoSextoHP=" + decimoSextoHP + ", decimoSetimoHP=" + decimoSetimoHP
				+ ", decimoOitavoHP=" + decimoOitavoHP + ", decimoNonoHP=" + decimoNonoHP + ", vigesimoHP=" + vigesimoHP
				+ ", vigesimoPrimeiroHP=" + vigesimoPrimeiroHP + ", vigesimoSegundoHP=" + vigesimoSegundoHP
				+ ", vigesimoTerceiroHP=" + vigesimoTerceiroHP + ", vigesimoQuartoHP=" + vigesimoQuartoHP
				+ ", dtCadastroHP=" + dtCadastroHP + "]";
	}

}