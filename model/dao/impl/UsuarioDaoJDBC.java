package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.UsuarioDAO;
import model.entities.Usuario;
import util.conect.ConnectDB;
import util.exception.DbException;
import util.exception.DbIntegrityException;

//classe que implementa interface UsuarioDAO, vai encapsular todas operacoes referente ao banco de dados.
public class UsuarioDaoJDBC implements UsuarioDAO {

	private Connection conectaDB;

	public UsuarioDaoJDBC() {
	}

	public UsuarioDaoJDBC(Connection conectaDB) {
		this.conectaDB = conectaDB;
	}

	@Override
	public void insert(Usuario objUser) {
		PreparedStatement pst = null;
		String insereSql = "insert into tbusuario values(?,?,?,?)";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(insereSql);

			pst.setString(1, objUser.getCpfUsuario());
			pst.setString(2, objUser.getUsuario());
			pst.setString(3, objUser.getLogin());
			pst.setString(4, objUser.getSenha());

			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Usuário Cadastrado com sucesso!");
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
	public void update(Usuario objUser) {
		PreparedStatement pst = null;
		// Comando SQL para fazer a atualização no banco dos valores
		String campos = "cpfUsuario=?, usuario=?, login=?, senha=?";
		String atualizaSql = "update tbusuario set " + campos + " WHERE cpfUsuario=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(atualizaSql);
			pst.setString(1, objUser.getCpfUsuario());
			pst.setString(2, objUser.getUsuario());
			pst.setString(3, objUser.getLogin());
			pst.setString(4, objUser.getSenha());
			pst.setString(5, objUser.getCpfUsuario());
			pst.executeUpdate();
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
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
		// Instrução SQL para deletar registro específico da tabela tbusuario, pelo cpf
		String deleteSQL = "delete from tbusuario WHERE cpfUsuario=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(deleteSQL);
			pst.setString(1, cpf);
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
			} else {
				throw new DbException("Erro!!! Nenhuma linha afetada!");
			}
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
		}

	}

	@Override
	public Usuario findByCPF(String cpf) {

		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela tbusuario pelo
		// cpf
		String selectSQL = "select * from tbusuario WHERE cpfUsuario=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				Usuario objUser = instanciaUsuario(rs);
				int sai = JOptionPane.showConfirmDialog(null, "Usuário já cadastrado nessa tabela! Deseja Alterar?",
						"Atenção!", JOptionPane.YES_NO_OPTION);
				if (sai == JOptionPane.YES_OPTION) {
					return objUser;
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
	public List<Usuario> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de todos os registro da tbusuario
		String selectSQL = "select * from tbusuario";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			rs = pst.executeQuery();
			List<Usuario> list = new ArrayList<>();
			// Laço de repetição para preencher a lista com os registros
			while (rs.next()) {
				// cahamada do método instanciaUsuario passando rs como argumento
				Usuario objUser = instanciaUsuario(rs);
				list.add(objUser);
			}
			return list;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	private Usuario instanciaUsuario(ResultSet rs) throws SQLException {
		Usuario objUser = new Usuario();
		objUser.setCpfUsuario(rs.getString("cpfUsuario"));
		objUser.setUsuario(rs.getString("usuario"));
		objUser.setLogin(rs.getString("login"));
		objUser.setSenha(rs.getString("senha"));
		return objUser;
	}

	@Override
	public ResultSet logar(Usuario objUser) {
		PreparedStatement pst = null;

		String selectSQL = "select * from tbusuario where login=? and senha=?";

		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);

			pst.setString(1, objUser.getUsuario());
			pst.setString(2, objUser.getSenha());

			ResultSet rs = pst.executeQuery();
			return rs;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "UsuarioDao: " + e.getMessage());
			return null;

		}
	}
}
