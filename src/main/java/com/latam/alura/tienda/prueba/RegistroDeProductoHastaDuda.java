package com.latam.alura.tienda.prueba;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProductoHastaDuda {

	public static void main(String[] args) {
Categoria celulares = new Categoria("CELULARES");
		
//		Producto celular = new Producto("Xiaomi Redmi","Producto usado",new BigDecimal("1000"), celulares);
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
//		EntityManager em = factory.createEntityManager();
		EntityManager em = JPAUtils.getEntityManager();
//		ProductoDAO productoDAO = new ProductoDAO(em);
//		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		em.getTransaction().begin();
		em.persist(celulares);
		celulares.setNombre("LIBROS");
		em.flush();
		em.clear();
		celulares = em.merge(celulares);
		celulares.setNombre("SOFTWARE");
		em.flush();   // sincronizar, hasta aqui estaba managed o gerenciado
		// eliminar registro
		em.remove(celulares);
		em.flush();
		
//		categoriaDAO.guardar(celulares);
		// SE QUITARON AL UTILIZAR flush() y clear()
//		productoDAO.guardar(celular); // em.persist(celular);
//		em.getTransaction().commit(); 
//		em.close();
	}

}
