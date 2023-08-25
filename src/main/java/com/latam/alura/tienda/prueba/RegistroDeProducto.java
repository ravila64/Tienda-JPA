package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular = new Producto();
		celular.setNombre("Xiaomi Redmi");
		celular.setDescripcion("Producto usado");
		celular.setPrecio(new BigDecimal("800"));

//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
//		EntityManager em = factory.createEntityManager();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
			
		em.getTransaction().begin();
		productoDAO.guardar(celular); // em.persist(celular);
		em.getTransaction().commit();
		em.close();

	}

}
