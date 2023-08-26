package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		Producto celular = new Producto("Xiaomi Redmi","Producto usado",new BigDecimal("1000"), Categoria.CELULARES);
		
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
