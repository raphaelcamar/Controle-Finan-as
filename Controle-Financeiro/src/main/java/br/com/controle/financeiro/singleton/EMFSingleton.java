package br.com.controle.financeiro.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {

	private static EntityManagerFactory fabrica;
	
	private EMFSingleton() {
	}

	public static EntityManagerFactory getInstance() {
		if(fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}
}