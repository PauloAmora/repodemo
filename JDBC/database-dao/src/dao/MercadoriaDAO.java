package dao;

import java.util.List;

import model.Mercadoria;

public interface MercadoriaDAO {
	
	public int create(Mercadoria m);
	
	public int update(Mercadoria m);
	
	public Mercadoria findByName(String nome);
	
	public List<Mercadoria> findAll();
	
	
	

}
