package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	private CorsoDAO daoC;
	private StudenteDAO daoS;

	public Model() {
		daoC = new CorsoDAO();
		daoS = new StudenteDAO();
	}

	public List<Corso> getElencoCorsi() {

		daoC.getTuttiICorsi().add(getCo());
		return daoC.getTuttiICorsi();
	}

	public Corso getCo() {
		return new Corso("0000000", 0, "Tutti i corsi", 0);
	}

	public List<Studente> getElencoStudenti() {
		return daoS.getStudenti();
	}

	public Studente completa(int m) {
		Studente s;
		s = daoS.getStudenteByMatricola(m);
		return s;

	}

	public String cercaIscrittiCorso(Corso scelta) {
		String result = "";

		for (Studente s : daoC.getStudentiIscrittiAlCorso(scelta)) {
			result += s.toStringFormattato();
		}

		return result;
	}

	public String cercaCorsiStudente(int m) {
		String result = "";
		for (Corso c : daoS.getCorsiStudente(m)) {
			result += c.toStringcompleto();
		}
		return result;
	}

	public boolean isIscritto(int m, Corso scelta) {
		for(Corso c : daoS.getCorsiStudente(m)) {
			if (c.getCodins().equals(scelta.getCodins()))
			return true;	
			
		}
			return false;
	
	}

	public boolean esisteStudente(int m) {
		for(Studente s : this.getElencoStudenti()) {
			if(s.getMatricola()==m)
				return true;
		}
		return false;
	}

}
