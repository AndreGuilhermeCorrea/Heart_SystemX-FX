package util.conect;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import util.exception.DbException;

public class ConnectDB {

	// Connection conectaDB = ConnectDB.getConnection();

	// ConnectDB.closeConectaDB();

	// metodo que estabelece e fecha conexao com DB

	private static Connection conectaDB = null;

	// método getConnection() que retorna um objeto de conexão com o banco de
	// dados.
	// chamamos o método estático getConnection() da classe DriverMenager,
	// pelo qual passamos as configurações para a conexão pelo documento
	// db.properties
	public static Connection getConnection() {
		if (conectaDB == null) {
			try {

				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conectaDB = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}

		return conectaDB;
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConectaDB() {
		if (conectaDB != null) {
			try {
				conectaDB.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
