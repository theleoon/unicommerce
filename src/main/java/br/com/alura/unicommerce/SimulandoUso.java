package br.com.alura.unicommerce;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.unicommerce.modelo.Categoria;

public class SimulandoUso {

	
	public static void main(String[] args) {
		
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("mysql");
		
		Categoria novaCategoria = new Categoria();
		novaCategoria.setNome("Celulares");
		
		EntityManager manager = ef.createEntityManager();
				
		manager.getTransaction().begin();
		manager.persist(novaCategoria);
		manager.getTransaction().commit();
		
		
	}

}
