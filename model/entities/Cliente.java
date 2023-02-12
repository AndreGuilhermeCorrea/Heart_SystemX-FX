package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/*
 * classe Cliente com atributos dos campos da tabela. 
 */
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	// atributos
	private String cpfCliente;
	private String nomeCompleto;
	private Date datacadastro;
	private String cartaosus;
	private Integer idade;
	private Date nascimento;
	private String genero;
	private String raca;
	private String email;
	private String rg;
	private String naturalidade;
	private String nacionalidade;
	private String endereco;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String telefonecontato;
	private String nomemae;
	private String escolaridade;
	private String religiao;

	// construtor padrão vazio
	public Cliente() {
	}

	// construtor com argumentos
	public Cliente(String cpfCliente, String nomeCompleto, Date datacadastro, String cartaosus, Integer idade,
			Date nascimento, String genero, String raca, String email, String rg, String naturalidade,
			String nacionalidade, String endereco, Integer numero, String complemento, String bairro, String cidade,
			String estado, String cep, String telefonecontato, String nomemae, String escolaridade, String religiao) {
		super();
		this.cpfCliente = cpfCliente;

		this.nomeCompleto = nomeCompleto;
		this.datacadastro = datacadastro;
		this.cartaosus = cartaosus;
		this.idade = idade;
		this.nascimento = nascimento;
		this.genero = genero;
		this.raca = raca;
		this.email = email;
		this.rg = rg;

		this.naturalidade = naturalidade;
		this.nacionalidade = nacionalidade;
		this.endereco = endereco;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.telefonecontato = telefonecontato;
		this.nomemae = nomemae;
		this.escolaridade = escolaridade;
		this.religiao = religiao;
	}

	// gethers e sethers
	public String getCpfCliente() {
		return cpfCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public Date getDatacadastro() {
		return datacadastro;
	}

	public String getCartaosus() {
		return cartaosus;
	}

	public Integer getIdade() {
		return idade;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public String getGenero() {
		return genero;
	}

	public String getRaca() {
		return raca;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public String getTelefonecontato() {
		return telefonecontato;
	}

	public String getNomemae() {
		return nomemae;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public void setCartaosus(String cartaosus) {
		this.cartaosus = cartaosus;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setTelefonecontato(String telefonecontato) {
		this.telefonecontato = telefonecontato;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(cpfCliente, other.cpfCliente);
	}

	// toString
	@Override
	public String toString() {
		return "Cliente [cpfCliente=" + cpfCliente + ", nomeCompleto=" + nomeCompleto + ", datacadastro=" + datacadastro
				+ ", cartaosus=" + cartaosus + ", idade=" + idade + ", nascimento=" + nascimento + ", genero=" + genero
				+ ", raca=" + raca + ", email=" + email + ", rg=" + rg + ", naturalidade=" + naturalidade
				+ ", nacionalidade=" + nacionalidade + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", cep=" + cep + ", telefonecontato=" + telefonecontato + ", nomemae=" + nomemae + ", escolaridade="
				+ escolaridade + ", religiao=" + religiao + "]";
	}
}
