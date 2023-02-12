package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.AntropometriaDAO;
import model.entities.Antropometria;
import util.conect.ConnectDB;
import util.exception.DbException;
import util.exception.DbIntegrityException;

//classe que implementa interface AntropometriaDAO, vai encapsular todas operacoes referente ao banco de dados.
public class AntropometriaDaoJDBC implements AntropometriaDAO {

	private Connection conectaDB;

	public AntropometriaDaoJDBC(Connection conectaDB) {
		this.conectaDB = conectaDB;
	}

	public AntropometriaDaoJDBC() {
	}

	@Override
	public void insert(Antropometria objAntro) {
		PreparedStatement pst = null;
		String insereSql = "insert into tbantropometria values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(insereSql);
			pst.setString(1, objAntro.getCpfCliente());
			pst.setDate(2, new java.sql.Date(objAntro.getDtCadastroA().getTime()));
			pst.setDouble(3, objAntro.getPeso());
			pst.setDouble(4, objAntro.getAltura());
			pst.setDouble(5, objAntro.getImc());
			pst.setString(6, objAntro.getcImc());
			pst.setInt(7, objAntro.getPedometro1());
			pst.setInt(8, objAntro.getPedometro2());
			pst.setInt(9, objAntro.getPedometro3());
			pst.setDouble(10, objAntro.getPedometroMedia());
			pst.setString(11, objAntro.getPedometroClass());
			pst.setDouble(12, objAntro.getSentarAlcanca());
			pst.setDouble(13, objAntro.getcPunho());
			pst.setDouble(14, objAntro.getcCintura());
			pst.setDouble(15, objAntro.getcQuadril());
			pst.setDouble(16, objAntro.getRazaoCQ());
			pst.setDouble(17, objAntro.getPesoDesejavel());
			pst.setDouble(18, objAntro.getImcDesejavel());
			pst.setString(19, objAntro.getcRiscoSaude());
			pst.setDouble(20, objAntro.getPesoAjustado());
			pst.setDouble(21, objAntro.getAdequacaoPeso());
			pst.setDouble(22, objAntro.getCompleicao());
			pst.setString(23, objAntro.getTipoComp());
			pst.setString(24, objAntro.getNivelFlexibilidade());
			pst.setDouble(25, objAntro.getPregaCutaneaTorax());
			pst.setDouble(26, objAntro.getPregaCutaneaAbdomem());
			pst.setDouble(27, objAntro.getPregaCutaneaCoxa());
			pst.setDouble(28, objAntro.getPregaCutaneaTriciptal());
			pst.setDouble(29, objAntro.getPregaCutaneaSuprailiaca());
			pst.setDouble(30, objAntro.getSomaDobrasCutaneas());
			pst.setDouble(31, objAntro.getMassaCMagra());
			pst.setDouble(32, objAntro.getMassaCGorda());
			pst.setDouble(33, objAntro.getMassaCPercentual());
			pst.setDouble(34, objAntro.getDensidade());

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
	public void update(Antropometria objAntro) {
		PreparedStatement pst = null;
		String campos = "cpf=?, data=?, peso=?, altura=?, Imc=?, CImc=?, Pedometro1=?, Pedometro2=?, Pedometro3=?, PedometroMedia=?, PedometroClass=?,"
				+ "	sentarAlcanca=?, cPunho=?, cCintura=?, cQuadril=?,"
				+ "	razaoCQ=?, pesoDesejavel=?, imcDesejavel=?, cRiscoSaude=?, pesoAjustado=?, adequacaoPeso=?, compleicao=?, tipoComp=?,"
				+ "	nivelFlexibilidade=?, pregaCutaneaTorax=?, pregaCutaneaAbdomem=?, pregaCutaneaCoxa=?, "
				+ "	pregaCutaneaTriciptal=?, pregaCutaneaSuprailiaca=?,"
				+ "	somaDobrasCutaneas=?, massaCMagra=?, massaCGorda=?, massaCPercentual=?, densidade=?";
		String atualizaSql = "update tbantropometria set " + campos + " WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(atualizaSql);
			pst.setString(1, objAntro.getCpfCliente());
			pst.setDate(2, new java.sql.Date(objAntro.getDtCadastroA().getTime()));
			pst.setDouble(3, objAntro.getPeso());
			pst.setDouble(4, objAntro.getAltura());
			pst.setDouble(5, objAntro.getImc());
			pst.setString(6, objAntro.getcImc());
			pst.setInt(7, objAntro.getPedometro1());
			pst.setInt(8, objAntro.getPedometro2());
			pst.setInt(9, objAntro.getPedometro3());
			pst.setDouble(10, objAntro.getPedometroMedia());
			pst.setString(11, objAntro.getPedometroClass());
			pst.setDouble(12, objAntro.getSentarAlcanca());
			pst.setDouble(13, objAntro.getcPunho());
			pst.setDouble(14, objAntro.getcCintura());
			pst.setDouble(15, objAntro.getcQuadril());
			pst.setDouble(16, objAntro.getRazaoCQ());
			pst.setDouble(17, objAntro.getPesoDesejavel());
			pst.setDouble(18, objAntro.getImcDesejavel());
			pst.setString(19, objAntro.getcRiscoSaude());
			pst.setDouble(20, objAntro.getPesoAjustado());
			pst.setDouble(21, objAntro.getAdequacaoPeso());
			pst.setDouble(22, objAntro.getCompleicao());
			pst.setString(23, objAntro.getTipoComp());
			pst.setString(24, objAntro.getNivelFlexibilidade());
			pst.setDouble(25, objAntro.getPregaCutaneaTorax());
			pst.setDouble(26, objAntro.getPregaCutaneaAbdomem());
			pst.setDouble(27, objAntro.getPregaCutaneaCoxa());
			pst.setDouble(28, objAntro.getPregaCutaneaTriciptal());
			pst.setDouble(29, objAntro.getPregaCutaneaSuprailiaca());
			pst.setDouble(30, objAntro.getSomaDobrasCutaneas());
			pst.setDouble(31, objAntro.getMassaCMagra());
			pst.setDouble(32, objAntro.getMassaCGorda());
			pst.setDouble(33, objAntro.getMassaCPercentual());
			pst.setDouble(34, objAntro.getDensidade());
			pst.setString(35, objAntro.getCpfCliente());
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
		// Instrução SQL para deletar registro específico da tabela
		// tbantropometriainicial,
		String deleteSQL = "delete from tbantropometria WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(deleteSQL);
			pst.setString(1, cpf);
			int rowsAffected = pst.executeUpdate();
			// teste para linhas afetadas
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cliente Excluído com sucesso!");
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
	public Antropometria findByCPF(String cpf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela
		// tbantropometriainicial pelo cpf
		String selectSQL = "select * from tbantropometria where cpf=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa objAntro pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				Antropometria objAntro = instanciaAntropologia(rs);
				int sai = JOptionPane.showConfirmDialog(null, "Cliente já cadastrado nessa tabela! Deseja Alterar?",
						"Atenção!", JOptionPane.YES_NO_OPTION);
				if (sai == JOptionPane.YES_OPTION) {
					return objAntro;
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
	public List<Antropometria> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de todos os registro da tbantropometriainicial
		String selectSQL = "select * from tbantropometriainicial";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			rs = pst.executeQuery();
			List<Antropometria> list = new ArrayList<>();
			// Laço de repetição para preencher objAntro lista com os registros
			while (rs.next()) {
				// cahamada do método instanciaAntropologia passando rs como argumento
				Antropometria objAntro = instanciaAntropologia(rs);
				list.add(objAntro);
			}
			return list;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	private Antropometria instanciaAntropologia(ResultSet rs) throws SQLException {
		Antropometria objAntro = new Antropometria();
		objAntro.setCpfCliente(rs.getString("cpf"));
		objAntro.setDtCadastroA(rs.getDate("data"));
		objAntro.setPeso(rs.getDouble("peso"));
		objAntro.setAltura(rs.getDouble("altura"));
		objAntro.setImc(rs.getDouble("imc"));
		objAntro.setcImc(rs.getString("cImc"));
		objAntro.setPedometro1(rs.getInt("pedometro1"));
		objAntro.setPedometro2(rs.getInt("pedometro2"));
		objAntro.setPedometro3(rs.getInt("pedometro3"));
		objAntro.setPedometroMedia(rs.getDouble("pedometroMedia"));
		objAntro.setPedometroClass(rs.getString("pedometroClass"));
		objAntro.setSentarAlcanca(rs.getDouble("sentarAlcanca"));
		objAntro.setcPunho(rs.getDouble("cPunho"));
		objAntro.setcCintura(rs.getDouble("cCintura"));
		objAntro.setcQuadril(rs.getDouble("cQuadril"));
		objAntro.setRazaoCQ(rs.getDouble("razaoCQ"));
		objAntro.setPesoDesejavel(rs.getDouble("pesoDesejavel"));
		objAntro.setImcDesejavel(rs.getDouble("imcDesejavel"));
		objAntro.setcRiscoSaude(rs.getString("cRiscoSaude"));
		objAntro.setPesoAjustado(rs.getDouble("pesoAjustado"));
		objAntro.setAdequacaoPeso(rs.getDouble("adequacaoPeso"));
		objAntro.setCompleicao(rs.getDouble("compleicao"));
		objAntro.setTipoComp(rs.getString("tipoComp"));
		objAntro.setNivelFlexibilidade(rs.getString("nivelFlexibilidade"));
		objAntro.setPregaCutaneaTorax(rs.getDouble("pregaCutaneaTorax"));
		objAntro.setPregaCutaneaAbdomem(rs.getDouble("pregaCutaneaAbdomem"));
		objAntro.setPregaCutaneaCoxa(rs.getDouble("pregaCutaneaCoxa"));
		objAntro.setPregaCutaneaTriciptal(rs.getDouble("pregaCutaneaTriciptal"));
		objAntro.setPregaCutaneaSuprailiaca(rs.getDouble("pregaCutaneaSuprailiaca"));
		objAntro.setSomaDobrasCutaneas(rs.getDouble("somaDobrasCutaneas"));
		objAntro.setMassaCMagra(rs.getDouble("massaCMagra"));
		objAntro.setMassaCGorda(rs.getDouble("massaCGorda"));
		objAntro.setMassaCPercentual(rs.getDouble("massaCPercentual"));
		objAntro.setDensidade(rs.getDouble("densidade"));

		return objAntro;
	}

}
