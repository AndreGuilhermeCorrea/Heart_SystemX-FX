package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.dao.SaudeDAO;
import model.entities.Saude;
import util.conect.ConnectDB;
import util.exception.DbException;
import util.exception.DbIntegrityException;

//classe que implementa interface SaudeDAO, vai encapsular todas operacoes referente ao banco de dados.
public class SaudeDaoJDBC implements SaudeDAO {

	private Connection conectaDB;

	public SaudeDaoJDBC(Connection conectaDB) {
		this.conectaDB = conectaDB;
	}

	public SaudeDaoJDBC() {
	}

	@Override
	public void insert(Saude objSaude) {
		PreparedStatement pst = null;
		String insereSql = "insert into tbsaude values"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(insereSql);
			pst.setString(1, objSaude.getCpfCliente());
			pst.setDate(2, new java.sql.Date(objSaude.getDtCadastroS().getTime()));
			pst.setString(3, objSaude.getTabagista());
			pst.setString(4, objSaude.getEtilista());
			pst.setString(5, objSaude.getDieta());
			pst.setString(6, objSaude.getFaltaDeAr());
			pst.setString(7, objSaude.getVidaSexualAtiva());
			pst.setString(8, objSaude.getUsoDeMedicacao());
			pst.setString(9, objSaude.getDiabetes());
			pst.setString(10, objSaude.getDorNoPeito());
			pst.setString(11, objSaude.getHipertensao());
			pst.setString(12, objSaude.getColesterolAlto());
			pst.setString(13, objSaude.getTriglicerides());
			pst.setString(14, objSaude.getAnemia());
			pst.setString(15, objSaude.getGota());
			pst.setString(16, objSaude.getAlergia());
			pst.setString(17, objSaude.getPatologiaCardiaca());
			pst.setString(18, objSaude.getArritmia());
			pst.setString(19, objSaude.getInfarto());
			pst.setString(20, objSaude.getStent());
			pst.setString(21, objSaude.getCateterismo());
			pst.setString(22, objSaude.getaVC());
			pst.setString(23, objSaude.getRenal());
			pst.setString(24, objSaude.getCancer());
			pst.setString(25, objSaude.getHepatite());
			pst.setString(26, objSaude.getLabirintite());
			pst.setString(27, objSaude.getPatologiaArterial());
			pst.setString(28, objSaude.getPatologiaPulmonar());
			pst.setString(29, objSaude.getTireoide());
			pst.setString(30, objSaude.getHabitoMesntrual());
			pst.setString(31, objSaude.getHabitoIntestinal());
			pst.setString(32, objSaude.getPatologiaOrtopedica());
			pst.setString(33, objSaude.getDoresDeCabeca());
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
	public void update(Saude objSaude) {
		PreparedStatement pst = null;
		System.out.println(objSaude);

		String campos = "cpf=?, data=?, tabagista=?, etilista=?, "
				+ "dieta=?, faltaDeAr=?,  vidaSexualAtiva=?, usoDeMedicacao=?, "
				+ "diabetes=?, dorNoPeito=?, hipertensao=?, colesterolAlto=?, "
				+ "triglicerides=?, anemia=?, gota=?, alergia=?,  "
				+ "patologiaCardiaca=?, arritmia=?, infarto=?, stent=?, cateterismo=?, aVC=?, renal=?, cancer=?, "
				+ "hepatite=?, labirintite=?, patologiaArterial=?, patologiaPulmonar=?, "
				+ "tireoide=?, habitoMenstrual=?, habitoIntestinal=?, patologiaOrtopedica=?, doresDeCabeca=?";
		String atualizaSql = "update tbsaude set " + campos + " WHERE cpf=?";
		try {
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(atualizaSql);

			pst.setString(1, objSaude.getCpfCliente());
			pst.setDate(2, new java.sql.Date(objSaude.getDtCadastroS().getTime()));
			pst.setString(3, objSaude.getTabagista());
			pst.setString(4, objSaude.getEtilista());
			pst.setString(5, objSaude.getDieta());
			pst.setString(6, objSaude.getFaltaDeAr());
			pst.setString(7, objSaude.getVidaSexualAtiva());
			pst.setString(8, objSaude.getUsoDeMedicacao());
			pst.setString(9, objSaude.getDiabetes());
			pst.setString(10, objSaude.getDorNoPeito());
			pst.setString(11, objSaude.getHipertensao());
			pst.setString(12, objSaude.getColesterolAlto());
			pst.setString(13, objSaude.getTriglicerides());
			pst.setString(14, objSaude.getAnemia());
			pst.setString(15, objSaude.getGota());
			pst.setString(16, objSaude.getAlergia());
			pst.setString(17, objSaude.getPatologiaCardiaca());
			pst.setString(18, objSaude.getArritmia());
			pst.setString(19, objSaude.getInfarto());
			pst.setString(20, objSaude.getStent());
			pst.setString(21, objSaude.getCateterismo());
			pst.setString(22, objSaude.getaVC());
			pst.setString(23, objSaude.getRenal());
			pst.setString(24, objSaude.getCancer());
			pst.setString(25, objSaude.getHepatite());
			pst.setString(26, objSaude.getLabirintite());
			pst.setString(27, objSaude.getPatologiaArterial());
			pst.setString(28, objSaude.getPatologiaPulmonar());
			pst.setString(29, objSaude.getTireoide());
			pst.setString(30, objSaude.getHabitoMesntrual());
			pst.setString(31, objSaude.getHabitoIntestinal());
			pst.setString(32, objSaude.getPatologiaOrtopedica());
			pst.setString(33, objSaude.getDoresDeCabeca());
			pst.setString(34, objSaude.getCpfCliente());
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
		// Instrução SQL para deletar registro específico da tabela tbsaude,
		String deleteSQL = "delete from tbsaude WHERE cpf=?";
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
	public Saude findByCPF(String cpf) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		// Instrução SQL para seleção de registro específico da tabela
		// tbsaude pelo cpf
		String selectSQL = "select * from tbsaude where cpf=?";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			pst.setString(1, cpf);
			// Executa a pesquisa da seleção SQL e atribui o resultado ao ResultSet;
			rs = pst.executeQuery();
			// Laço de repetição para preencher com os dados do banco
			if (rs.next()) {
				Saude objSaude = instanciaSaude(rs);
				int sai = JOptionPane.showConfirmDialog(null, "Cliente já cadastrado nessa tabela! Deseja Alterar?",
						"Atenção!", JOptionPane.YES_NO_OPTION);
				if (sai == JOptionPane.YES_OPTION) {
					return objSaude;
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
	public List<Saude> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;

		// Instrução SQL para seleção de todos os registro da tbsaude
		String selectSQL = "select * from tbsaude";
		try {
			// conexao db
			conectaDB = ConnectDB.getConnection();
			pst = conectaDB.prepareStatement(selectSQL);
			rs = pst.executeQuery();
			List<Saude> list = new ArrayList<>();
			// Laço de repetição para preencher a lista com os registros
			while (rs.next()) {
				// cahamada do método instanciaSaude passando rs como argumento
				Saude objSaude = instanciaSaude(rs);
				list.add(objSaude);
			}
			return list;
		} catch (Exception e1) {
			throw new DbException(e1.getMessage());
		} finally {
			ConnectDB.closePreparedStatement(pst);
			ConnectDB.closeResultSet(rs);
		}
	}

	// método para instanciação da saude com excessão propagada e nao tratada
	private Saude instanciaSaude(ResultSet rs) throws SQLException {
		Saude objSaude = new Saude();
		// "seta" os atributos da classe Familia com os dados dos campos do banco
		objSaude.setCpfCliente(rs.getString("cpf"));
		objSaude.setDtCadastroS(rs.getDate("data"));
		objSaude.setTabagista(rs.getString("tabagista"));
		objSaude.setEtilista(rs.getString("etilista"));
		objSaude.setDieta(rs.getString("dieta"));
		objSaude.setFaltaDeAr(rs.getString("faltaDeAr"));
		objSaude.setVidaSexualAtiva(rs.getString("vidaSexualAtiva"));
		objSaude.setUsoDeMedicacao(rs.getString("usoDeMedicacao"));
		objSaude.setDiabetes(rs.getString("diabetes"));
		objSaude.setDorNoPeito(rs.getString("dorNoPeito"));
		objSaude.setHipertensao(rs.getString("hipertensao"));
		objSaude.setColesterolAlto(rs.getString("colesterolAlto"));
		objSaude.setTriglicerides(rs.getString("triglicerides"));
		objSaude.setAnemia(rs.getString("anemia"));
		objSaude.setGota(rs.getString("gota"));
		objSaude.setAlergia(rs.getString("alergia"));
		objSaude.setPatologiaCardiaca(rs.getString("patologiaCardiaca"));
		objSaude.setArritmia(rs.getString("arritmia"));
		objSaude.setInfarto(rs.getString("infarto"));
		objSaude.setStent(rs.getString("stent"));
		objSaude.setCateterismo(rs.getString("cateterismo"));
		objSaude.setaVC(rs.getString("aVC"));
		objSaude.setRenal(rs.getString("renal"));
		objSaude.setCancer(rs.getString("cancer"));
		objSaude.setHepatite(rs.getString("hepatite"));
		objSaude.setLabirintite(rs.getString("labirintite"));
		objSaude.setPatologiaArterial(rs.getString("patologiaArterial"));
		objSaude.setPatologiaPulmonar(rs.getString("patologiaPulmonar"));
		objSaude.setTireoide(rs.getString("tireoide"));
		objSaude.setHabitoMesntrual(rs.getString("habitoMenstrual"));
		objSaude.setHabitoIntestinal(rs.getString("habitoIntestinal"));
		objSaude.setPatologiaOrtopedica(rs.getString("patologiaOrtopedica"));
		objSaude.setDoresDeCabeca(rs.getString("doresDeCabeca"));
		return objSaude;

	}

}
