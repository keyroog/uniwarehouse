package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilities.DriverManagerConnectionPool;

public class AnnuncioDAO {
	
	
	
	private static final String TABLE_NAME = "Annuncio";
	public AnnuncioDAO(){}
	
	
	public synchronized void doSave(Annuncio annuncio, String photo) throws SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME
				+ " (idannuncio,nomelibro,datainserimento,descrizione,image,fk_annuncio) VALUES (?, ?, ?, ?, ?, ?)";
		
		File file = new File(photo);

		try {
			FileInputStream fis = new FileInputStream(file);
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, annuncio.getId());
			preparedStatement.setString(2, annuncio.getNomeLibro());
			preparedStatement.setString(3, annuncio.getDate());
			preparedStatement.setString(4, annuncio.getDescrizione());
			preparedStatement.setBinaryStream(5, fis, fis.available());
			preparedStatement.setInt(6, annuncio.getFkannuncio());
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
}
