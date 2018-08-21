package br.com.caelum.livraria.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.caelum.livraria.modelo.Autor;

public class AutorDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject //Injeta o EntityManager nessa classe 
	private EntityManager em;
	private DAO<Autor> dao;
	
	@PostConstruct //. Com isso o CDI chamar� esse m�todo assim que inicializar o AutorDao, inicializando tamb�m o DAO gen�rico:
	public void init() {
		this.dao = new DAO<Autor>(this.em, Autor.class);
		System.out.println("Criando AutorDao ");
	}


	public void adiciona(Autor t) {
		dao.adiciona(t);
	}


	public void remove(Autor t) {
		dao.remove(t);
	}


	public void atualiza(Autor t) {
		dao.atualiza(t);
	}


	public List<Autor> listaTodos() {
		return dao.listaTodos();
	}


	public Autor buscaPorId(Integer id) {
		return dao.buscaPorId(id);
	}


	
}
