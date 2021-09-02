package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Livro;
import utils.JPAUtil;

public class LivroDAO {

	private static final EntityManager manager = JPAUtil.getEntityManager();

	public Livro getById(int id) {

		return manager.find(Livro.class, id);

	}

//	public List<Livro> findAll() {
//
//		String jpql = "select p from livro a";
//		TypedQuery<Livro> consulta = manager.createQuery(jpql, Livro.class);
//		return consulta.getResultList();
//
//	}

	public List<Livro> findAll() {
		TypedQuery<Livro> query = manager.createQuery("from Livro", Livro.class);
		return query.getResultList();
	}

	public void salvar(Livro livro) {

		manager.getTransaction().begin();
		manager.persist(livro);
		manager.getTransaction().commit();

	}

	public void update(Livro livro) {

		manager.getTransaction().begin();
		manager.merge(livro);
		manager.getTransaction().commit();

	}

	public void excluir(int id) {

		manager.remove(getById(id));

	}
}
