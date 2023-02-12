package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.ClienteDAO;
import model.entities.Cliente;
import model.entities.ClienteView;
import util.conect.ConnectDB;
import util.exception.DbException;
import util.exception.DbIntegrityException;

//classe que implementa interface ClienteDAO, vai encapsular todas operacoes referente ao banco de dados.
public class ClienteDaoJDBC implements ClienteDAO {

	private Connection conectaDB;

	public ClienteDaoJDBC(Connection conectaDB) {
		this.conectaDB = conectaDB;
	}

	public ClienteDaoJDBC() {
	}

	@Override
	public void insert(Cliente objClient) {
		PreparedStatement pst = null;
		String insereSql = "insert into tbclientes values" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(insereSql);
			pst.setString(1, objClient.getCpfCliente());
			pst.setString(2, objClient.getNomeCompleto());
			pst.setDate(3, new java.sql.Date(objClient.getDatacadastro().getTime()));
			pst.setString(4, objClient.getCartaosus());
			pst.setDate(5, new java.sql.Date(objClient.getNascimento().getTime()));
			pst.setString(6, objClient.getGenero());
			pst.setString(7, objClient.getRaca());
			pst.setString(8, objClient.getEmail());
			pst.setString(9, objClient.getRg());
			pst.setString(10, objClient.getNaturalidade());
			pst.setString(11, objClient.getNacionalidade());
			pst.setString(12, objClient.getEndereco());
			pst.setInt(13, objClient.getNumero());
			pst.setString(14, objClient.getComplemento());
			pst.setString(15, objClient.getBairro());
			pst.setString(16, objClient.getCidade());
			pst.setString(17, objClient.getEstado());
			pst.setString(18, objClient.getCep());
			pst.setString(19, objClient.getTelefonecontato());
			pst.setString(20, objClient.getNomemae());
			pst.setString(21, objClient.getEscolaridade());
			pst.setString(22, objClient.getReligiao());
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!");
			} else {
				throw new DbException("Erro!!! Nenhuma linha afetada!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
		}
	}

	@Override
	public void update(Cliente objClient) {
		PreparedStatement pst = null;
		// Comando SQL para fazer a atualização no banco dos valores
		String campos = "cpf=?, nomecompleto=?, datacadastro=?, cartaosus=?,"
				+ " nascimento=?, genero=?, raca=?, email=?, rg=?, naturalidade=?, nacionalidade=?,"
				+ " endereço=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, cep=?, telefonecontato=?,"
				+ " nomemae=?, escolaridade=?, religião=?";
		String atualizaSql = "update tbclientes set " + campos + " WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(atualizaSql);
			pst.setString(1, objClient.getCpfCliente());
			pst.setString(2, objClient.getNomeCompleto());
			pst.setDate(3, new java.sql.Date(objClient.getDatacadastro().getTime()));
			pst.setString(4, objClient.getCartaosus());
			pst.setDate(5, new java.sql.Date(objClient.getNascimento().getTime()));
			pst.setString(6, objClient.getGenero());
			pst.setString(7, objClient.getRaca());
			pst.setString(8, objClient.getEmail());
			pst.setString(9, objClient.getRg());
			pst.setString(10, objClient.getNaturalidade());
			pst.setString(11, objClient.getNacionalidade());
			pst.setString(12, objClient.getEndereco());
			pst.setInt(13, objClient.getNumero());
			pst.setString(14, objClient.getComplemento());
			pst.setString(15, objClient.getBairro());
			pst.setString(16, objClient.getCidade());
			pst.setString(17, objClient.getEstado());
			pst.setString(18, objClient.getCep());
			pst.setString(19, objClient.getTelefonecontato());
			pst.setString(20, objClient.getNomemae());
			pst.setString(21, objClient.getEscolaridade());
			pst.setString(22, objClient.getReligiao());
			pst.setString(23, objClient.getCpfCliente());
			pst.executeUpdate();
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
			} else {
				throw new DbException("Erro!!! Nenhuma linha afetada!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
		}
	}

	@Override
	public void deleteByCpf(String cpf) {
		PreparedStatement pst = null;
		// Instrução SQL para deletar registro específico da tabela tbclientes, pelo
		String deleteSQL = "delete from tbclientes WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(deleteSQL);
			pst.setString(1, cpf);
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
			} else {
				throw new DbException("Cpf Não localizado!!! Nenhuma linha afetada!");
			}
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
		}
	}

	@Override
	public Cliente findByCPF(String cpf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela tbclientes pelo
		String selectSQL = "select * from tbclientes where cpf=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				Cliente objClient = instanciaCliente(rs);
				int sai = JOptionPane.showConfirmDialog(null, "Cliente já cadastrado nessa tabela! Deseja Alterar?",
						"Atenção!", JOptionPane.YES_NO_OPTION);
				if (sai == JOptionPane.YES_OPTION) {
					return objClient;
				}
			} else {
				return null;
			}
			return null;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	@Override
	public List<Cliente> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de todos os registro da tbclientes
		String selectSQL = "select * from tbclientes";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			rs = pst.executeQuery();
			List<Cliente> list = new ArrayList<>();
			// Laço de repetição para preencher a lista com os registros
			while (rs.next()) {
				// cahamada do método instanciaCliente passando rs como argumento
				Cliente objClient = instanciaCliente(rs);
				list.add(objClient);
			}
			return list;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	// método para instanciação do cliente com excessão propagada e nao tratada
	private Cliente instanciaCliente(ResultSet rs) throws SQLException {
		Cliente objClient = new Cliente();
		// "seta" os atributos da classe Cliente com os dados dos campos do banco
		objClient.setCpfCliente(rs.getString("cpf"));
		objClient.setNomeCompleto(rs.getString("nomecompleto"));
		objClient.setDatacadastro(rs.getDate("datacadastro"));
		objClient.setCartaosus(rs.getString("cartaosus"));
		objClient.setNascimento(rs.getDate("nascimento"));
		objClient.setGenero(rs.getString("genero"));
		objClient.setRaca(rs.getString("raca"));
		objClient.setEmail(rs.getString("email"));
		objClient.setRg(rs.getString("rg"));
		objClient.setNaturalidade(rs.getString("naturalidade"));
		objClient.setNacionalidade(rs.getString("nacionalidade"));
		objClient.setEndereco(rs.getString("endereço"));
		objClient.setNumero(rs.getInt("numero"));
		objClient.setComplemento(rs.getString("complemento"));
		objClient.setBairro(rs.getString("bairro"));
		objClient.setCidade(rs.getString("cidade"));
		objClient.setEstado(rs.getString("estado"));
		objClient.setCep(rs.getString("cep"));
		objClient.setTelefonecontato(rs.getString("telefonecontato"));
		objClient.setNomemae(rs.getString("nomemae"));
		objClient.setEscolaridade(rs.getString("escolaridade"));
		objClient.setReligiao(rs.getString("religião"));
		return objClient;
	}

	public ClienteView pespesquisaCPFeNome(String cpf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela tbclientes pelo
		// cpf
		String selectSQL = "select cpf, nomecompleto, nascimento, genero from tbclientes where cpf=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				ClienteView objClient = new ClienteView();
				objClient.setCpfCliente(rs.getString("cpf"));
				objClient.setNomeCompleto(rs.getString("nomecompleto"));
				objClient.setNascimento(rs.getDate("nascimento"));
				objClient.setGenero(rs.getString("genero"));
				return objClient;
			} else {
				JOptionPane.showMessageDialog(null, "Cpf Não cadastrado no Banco de dados!");
				JOptionPane.showMessageDialog(null, "Cadastre o Cliente antes de prosseguir");
			}
			return null;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}

	}
}
