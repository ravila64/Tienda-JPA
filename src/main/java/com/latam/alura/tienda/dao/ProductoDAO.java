package com.latam.alura.tienda.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Producto;

public class ProductoDAO {
	private EntityManager em;

	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	
	public Producto consultaPorID(Long id) {
		return em.find(Producto.class, id);
	}
	
	public List<Producto> consultarTodosProductos(){
		// LENGUAJE JQPL
		//                    p en vez de *
		String jpql = "SELECT P from Producto AS P";
		return em.createQuery(jpql,Producto.class).getResultList();
	}
	
	public List<Producto> consultarPorNombre(String nombreConsultar){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombreConsultar";
		List<Producto> resultList = em.createQuery(jpql).setParameter("nombreConsultar", jpql).getResultList();
		return resultList;
	}
	
}	
