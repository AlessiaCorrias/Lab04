package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;



public class StudenteDAO {

	List<Studente> studenti = new ArrayList<>();
	
	public Studente getStudenteByMatricola(int m) {
		
		final String sql = "SELECT * FROM studente WHERE matricola=?";
		Studente result=null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, m);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int matricola = rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome = rs.getString("nome");
				String cds=rs.getString("CDS");
				
				result = new Studente(matricola, cognome, nome, cds);
				studenti.add(result);
				
			}
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		
		return result;
	}

	public List<Studente> getStudenti() {
	
		return studenti;
	}

	public List<Corso> getCorsiStudente(int m) {
		List<Corso> result = new ArrayList<>();
		final String sql ="SELECT c.* FROM studente AS s, corso AS c, iscrizione AS i "
				+ "WHERE s.matricola=i.matricola AND c.codins=i.codins AND s.matricola = ?";
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, m);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				
				result.add(new Corso(codins, numeroCrediti, nome, periodoDidattico));
			}
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
		

		return result;
	}
}
