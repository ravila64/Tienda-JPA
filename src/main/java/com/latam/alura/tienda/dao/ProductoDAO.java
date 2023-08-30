package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
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
	
	public List<Producto> consultarPorNombre(String nombre){
		String jpql = "SELECT P FROM Producto P WHERE P.nombre=:nombre";
		List<Producto> resultList = em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
		return resultList;
	}
	
	public List<Producto> consultarPorNombreDeCategoria(String nombre){
		String jpql = "SELECT P FROM Producto P WHERE P.categoria.nombre=:nombre";
		List<Producto> resultList = em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
		return resultList;
	}
	
	public List<Producto> consultarPorFechas(String fecha){
		// hay que hacer conversion de string a Date
		String jpql = "SELECT P FROM Producto P WHERE P.fechaDeRegistro=:fecha";
		List<Producto> resultList = em.createQuery(jpql,Producto.class).setParameter("fechaDeRegistro", fecha).getResultList();
		return resultList;
	}
	
	public BigDecimal consultarPrecioPorNombreProducto(String nombre){
		String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
		BigDecimal result = em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
		return result;
	}
}	
