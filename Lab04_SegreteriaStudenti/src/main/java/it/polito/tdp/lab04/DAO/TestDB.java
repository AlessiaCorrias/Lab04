package it.polito.tdp.lab04.DAO;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
		
		CorsoDAO cdao = new CorsoDAO();
		//cdao.getTuttiICorsi();
		
		StudenteDAO sdao = new StudenteDAO();
		System.out.println(sdao.getStudenteByMatricola(148072).toString());
		System.out.println(sdao.getStudenti());
	}

}
