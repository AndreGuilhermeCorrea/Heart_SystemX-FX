package model.dao.factory;

import model.dao.AntropometriaDAO;
import model.dao.ClienteDAO;
import model.dao.FamiliaDAO;
import model.dao.PsicoAltoRiscoDAO;
import model.dao.PsicoDAO;
import model.dao.SaudeDAO;
import model.dao.UsuarioDAO;
import model.dao.impl.AntropometriaDaoJDBC;
import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.FamiliaDaoJDBC;
import model.dao.impl.PsicoAltoRiscoDaoJDBC;
import model.dao.impl.PsicoDaoJDBC;
import model.dao.impl.SaudeDaoJDBC;
import model.dao.impl.UsuarioDaoJDBC;
import util.conect.ConnectDB;

//classe com operaçoes estaticas responsaveis por instanciar os dao's
public class DaoFactory {

	public static ClienteDAO createClienteDao() {
		return new ClienteDaoJDBC(ConnectDB.getConnection());
	}

	public static FamiliaDAO createFamiliaDAO() {
		return new FamiliaDaoJDBC(ConnectDB.getConnection());
	}

	public static AntropometriaDAO createAntropometriaDAO() {
		return new AntropometriaDaoJDBC(ConnectDB.getConnection());
	}

	public static SaudeDAO createSaudeDAO() {
		return new SaudeDaoJDBC(ConnectDB.getConnection());
	}

	public static PsicoDAO createPsicoDAO() {
		return new PsicoDaoJDBC(ConnectDB.getConnection());
	}

	public static PsicoAltoRiscoDAO createPsicoAltoRiscoDAO() {
		return new PsicoAltoRiscoDaoJDBC(ConnectDB.getConnection());
	}

	public static UsuarioDAO createUsuarioDAO() {
		return new UsuarioDaoJDBC(ConnectDB.getConnection());
	}
}
