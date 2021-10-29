package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import utilities.DriverManagerConnectionPool;

public class AnnuncioDAO {
	
	
	
	private static final String TABLE_NAME = "annuncio";
	public AnnuncioDAO(){}
	
	
	public synchronized void doSave(Annuncio annuncio, String photo) throws SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME
				+ " (nomelibro,datainserimento,descrizione,image,fk_annuncio, prezzo, nome, cognome) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		File file = new File(photo);

		try {
			FileInputStream fis = new FileInputStream(file);
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, annuncio.getNomeLibro());
			preparedStatement.setString(2, annuncio.getDate());
			preparedStatement.setString(3, annuncio.getDescrizione());
			preparedStatement.setBinaryStream(4, fis, fis.available());
			preparedStatement.setInt(5, annuncio.getFkannuncio());
			preparedStatement.setString(6, annuncio.getPrice());
			preparedStatement.setString(7, annuncio.getNome());
			preparedStatement.setString(8, annuncio.getCognome());
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
	
	
	public synchronized Collection<Annuncio> doRetrieveAll(String order) throws SQLException{
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Annuncio> products = new ArrayList<Annuncio>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME;
		
		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Annuncio bean = new Annuncio();
				bean.setDate(rs.getDate("datainserimento").toLocalDate());
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setFkannuncio(rs.getInt("fk_annuncio"));
				bean.setId(rs.getInt(1));
				bean.setNomeLibro(rs.getString("nomelibro"));
				bean.setImage(rs.getBlob("image"));
				bean.setPrice(rs.getString("prezzo"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				products.add(bean);
			}

		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return products;

	}
	
	
	public synchronized Collection<Annuncio> doRetrieveByKey(int matricola) throws SQLException{
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<Annuncio> products = new ArrayList<Annuncio>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE fk_annuncio = ?";;
		
		
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, matricola);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Annuncio bean = new Annuncio();
				bean.setDate(rs.getDate("datainserimento").toLocalDate());
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setFkannuncio(rs.getInt("fk_annuncio"));
				bean.setId(rs.getInt(1));
				bean.setNomeLibro(rs.getString("nomelibro"));
				bean.setImage(rs.getBlob("image"));
				bean.setPrice(rs.getString("prezzo"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				products.add(bean);
			}

		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
		return products;

	}
	
	
	
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE idannuncio = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	
	
}
