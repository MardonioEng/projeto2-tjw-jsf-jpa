package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Produto;
import utils.JPAUtil;

public class ProdutoDoa {

	private static final EntityManager manager = JPAUtil.getEntityManager();

	public Produto getById(int id) {

		return manager.find(Produto.class, id);

	}

//	public List<Produto> findAll() {
//
//		String jpql = "select p from produto a";
//		TypedQuery<Produto> consulta = manager.createQuery(jpql, Produto.class);
//		return consulta.getResultList();
//
//	}

	public List<Produto> findAll() {
		TypedQuery<Produto> query = manager.createQuery("from Produto", Produto.class);
		return query.getResultList();
	}

	public void salvar(Produto produto) {

		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();

	}

	public void update(Produto produto) {

		manager.getTransaction().begin();
		manager.merge(produto);
		manager.getTransaction().commit();

	}

	public void excluir(int id) {

		manager.remove(getById(id));

	}
}
