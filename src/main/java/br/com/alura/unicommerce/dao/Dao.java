package br.com.alura.unicommerce.dao;

public interface Dao<T> {
	
	public T get(Long id);
	
	public void save(T t);
	
	public void delete(T t);
	
	public void update(T t);
	
}
