package utilities;

import java.sql.SQLException;
import java.util.Collection;

import autenticazione.Utente;

public interface DAOModel {
	public void doSave(Utente utente) throws SQLException;

	public boolean doDelete(int code) throws SQLException;

	public Utente doRetrieveByKey(int code) throws SQLException;
	
	public Collection<Utente> doRetrieveAll(String order) throws SQLException;
}
