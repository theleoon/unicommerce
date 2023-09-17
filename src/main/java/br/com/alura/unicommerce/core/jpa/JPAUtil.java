package br.com.alura.unicommerce.core.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("mysql");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
