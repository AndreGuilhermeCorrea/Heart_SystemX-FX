package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.PsicoDAO;
import model.entities.Psico;
import util.conect.ConnectDB;
import util.exception.DbException;
import util.exception.DbIntegrityException;

//classe que implementa interface PsicoDAO, vai encapsular todas operacoes referente ao banco de dados.
public class PsicoDaoJDBC implements PsicoDAO {

	private Connection conectaDB;

	public PsicoDaoJDBC(Connection conectaDB) {
		this.conectaDB = conectaDB;
	}

	public PsicoDaoJDBC() {
	}

	@Override
	public void insert(Psico objPsico) {
		PreparedStatement pst = null;
		String insereSql = "insert into tbpsico values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(insereSql);
			pst.setString(1, objPsico.getCpfCliente());
			pst.setString(2, objPsico.getPrimeiroHP());
			pst.setString(3, objPsico.getSegundoHP());
			pst.setString(4, objPsico.getTerceiroHP());
			pst.setString(5, objPsico.getQuartoHP());
			pst.setString(6, objPsico.getQuintoHP());
			pst.setString(7, objPsico.getSextoHP());
			pst.setString(8, objPsico.getSetimoHP());
			pst.setString(9, objPsico.getOitavoHP());
			pst.setString(10, objPsico.getNonoHP());
			pst.setString(11, objPsico.getDecimoHP());
			pst.setString(12, objPsico.getDecimoPrimeiroHP());
			pst.setString(13, objPsico.getDecimoSegundoHP());
			pst.setString(14, objPsico.getDecimoTerceiroHP());
			pst.setString(15, objPsico.getDecimoQuartoHP());
			pst.setString(16, objPsico.getDecimoQuintoHP());
			pst.setString(17, objPsico.getDecimoSextoHP());
			pst.setString(18, objPsico.getDecimoSetimoHP());
			pst.setString(19, objPsico.getDecimoOitavoHP());
			pst.setString(20, objPsico.getDecimoNonoHP());
			pst.setString(21, objPsico.getVigesimoHP());
			pst.setString(22, objPsico.getVigesimoPrimeiroHP());
			pst.setString(23, objPsico.getVigesimoSegundoHP());
			pst.setString(24, objPsico.getVigesimoTerceiroHP());
			pst.setString(25, objPsico.getVigesimoQuartoHP());
			pst.setDate(26, new java.sql.Date(objPsico.getDtCadastroHP().getTime()));
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
	public void update(Psico objPsico) {
		PreparedStatement pst = null;
		String campos = "cpf=?, primeiroHP=?, segundoHP=?, terceiroHP=?, quartoHP=?, quintoHP=?, "
				+ "sextoHP=?, setimoHP=?, oitavoHP=?, nonoHP=?, "
				+ "decimoHP=?, decimoPrimeiroHP=?, decimoSegundoHP=?, decimoTerceiroHP=?, decimoQuartoHP=?, decimoQuintoHP=?, "
				+ "decimoSextoHP=?, decimoSetimoHP=?, decimoOitavoHP=?, decimoNonoHP=?, "
				+ "vigesimoHP=?, vigesimoPrimeiroHP=?, vigesimoSegundoHP=?, vigesimoTerceiroHP=?, vigesimoQuartoHP=?, data=?";
		String atualizaSql = "update tbpsico set " + campos + " WHERE cpf=?";
		try {

			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(atualizaSql);
			pst.setString(1, objPsico.getCpfCliente());
			pst.setString(2, objPsico.getPrimeiroHP());
			pst.setString(3, objPsico.getSegundoHP());
			pst.setString(4, objPsico.getTerceiroHP());
			pst.setString(5, objPsico.getQuartoHP());
			pst.setString(6, objPsico.getQuintoHP());
			pst.setString(7, objPsico.getSextoHP());
			pst.setString(8, objPsico.getSetimoHP());
			pst.setString(9, objPsico.getOitavoHP());
			pst.setString(10, objPsico.getNonoHP());
			pst.setString(11, objPsico.getDecimoHP());
			pst.setString(12, objPsico.getDecimoPrimeiroHP());
			pst.setString(13, objPsico.getDecimoSegundoHP());
			pst.setString(14, objPsico.getDecimoTerceiroHP());
			pst.setString(15, objPsico.getDecimoQuartoHP());
			pst.setString(16, objPsico.getDecimoQuintoHP());
			pst.setString(17, objPsico.getDecimoSextoHP());
			pst.setString(18, objPsico.getDecimoSetimoHP());
			pst.setString(19, objPsico.getDecimoOitavoHP());
			pst.setString(20, objPsico.getDecimoNonoHP());
			pst.setString(21, objPsico.getVigesimoHP());
			pst.setString(22, objPsico.getVigesimoPrimeiroHP());
			pst.setString(23, objPsico.getVigesimoSegundoHP());
			pst.setString(24, objPsico.getVigesimoTerceiroHP());
			pst.setString(25, objPsico.getVigesimoQuartoHP());
			pst.setDate(26, new java.sql.Date(objPsico.getDtCadastroHP().getTime()));
			pst.setString(27, objPsico.getCpfCliente());
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
		// Instrução SQL para deletar registro específico da tabela tbhistoriafamiliar,
		String deleteSQL = "delete from tbpsico WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(deleteSQL);
			pst.setString(1, cpf);
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
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
	public Psico findByCPF(String cpf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela
		String selectSQL = "select * from tbpsico where cpf=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				Psico objPsico = instanciaPsico(rs);
				int sai = JOptionPane.showConfirmDialog(null, "Cliente já cadastrado nessa tabela! Deseja Alterar?",
						"Atenção!", JOptionPane.YES_NO_OPTION);
				if (sai == JOptionPane.YES_OPTION) {
					return objPsico;
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
	public List<Psico> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de todos os registro da tbhistoriafamiliar
		String selectSQL = "select * from tbpsico";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			rs = pst.executeQuery();
			List<Psico> list = new ArrayList<>();
			// Laço de repetição para preencher a lista com os registros
			while (rs.next()) {
				// cahamada do método instanciaCliente passando rs como argumento
				Psico objPsico = instanciaPsico(rs);
				list.add(objPsico);
			}
			return list;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	private Psico instanciaPsico(ResultSet rs) throws SQLException {
		Psico objPsico = new Psico();
		objPsico.setCpfCliente(rs.getString("cpf"));
		objPsico.setPrimeiroHP(rs.getString("primeiroHP"));
		objPsico.setSegundoHP(rs.getString("segundoHP"));
		objPsico.setTerceiroHP(rs.getString("terceiroHP"));
		objPsico.setQuartoHP(rs.getString("quartoHP"));
		objPsico.setQuintoHP(rs.getString("quintoHP"));
		objPsico.setSextoHP(rs.getString("sextoHP"));
		objPsico.setSetimoHP(rs.getString("setimoHP"));
		objPsico.setOitavoHP(rs.getString("oitavoHP"));
		objPsico.setNonoHP(rs.getString("nonoHP"));
		objPsico.setDecimoHP(rs.getString("decimoHP"));
		objPsico.setDecimoPrimeiroHP(rs.getString("decimoPrimeiroHP"));
		objPsico.setDecimoSegundoHP(rs.getString("decimoSegundoHP"));
		objPsico.setDecimoTerceiroHP(rs.getString("decimoTerceiroHP"));
		objPsico.setDecimoQuartoHP(rs.getString("decimoQuartoHP"));
		objPsico.setDecimoQuintoHP(rs.getString("decimoQuintoHP"));
		objPsico.setDecimoSextoHP(rs.getString("decimoSextoHP"));
		objPsico.setDecimoSetimoHP(rs.getString("decimoSetimoHP"));
		objPsico.setDecimoOitavoHP(rs.getString("decimoOitavoHP"));
		objPsico.setDecimoNonoHP(rs.getString("decimoNonoHP"));
		objPsico.setVigesimoHP(rs.getString("vigesimoHP"));
		objPsico.setVigesimoPrimeiroHP(rs.getString("vigesimoPrimeiroHP"));
		objPsico.setVigesimoSegundoHP(rs.getString("vigesimoSegundoHP"));
		objPsico.setVigesimoTerceiroHP(rs.getString("vigesimoTerceiroHP"));
		objPsico.setVigesimoQuartoHP(rs.getString("vigesimoQuartoHP"));
		objPsico.setDtCadastroHP(rs.getDate("data"));
		return objPsico;
	}

}
