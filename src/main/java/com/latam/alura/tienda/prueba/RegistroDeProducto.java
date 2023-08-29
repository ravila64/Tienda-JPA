package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		Producto producto = productoDAO.consultaPorID(1L);
		System.out.println("Producto consultado "+producto.getNombre());
		
		// consulta de todos los elementos
		System.out.println("lista todos los productos");
		List<Producto> listaProd = productoDAO.consultarTodosProductos();
		listaProd.forEach(prod->System.out.println(prod.getNombre()+" "+prod.getDescripcion()));
		// otra forma 
		System.out.println("lista todos los productos, opcion 2");
		for (Producto prod : listaProd) {
			System.out.println(prod.toString());
		}
		
		// consulta x nombre
		System.out.println("lista productos x nombre:"+"[Xiaomi Redmi]");
		List<Producto> listaProdxNombre = productoDAO.consultarPorNombre("Xiaomi Redmi"); 
		listaProdxNombre.forEach(prod->System.out.println(prod.getNombre()+" "+prod.getDescripcion()));
		
	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Xiaomi Redmi","Producto usado",new BigDecimal("1000"), celulares);
				
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDAO productoDAO = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		
		categoriaDAO.guardar(celulares);
		productoDAO.guardar(celular); // em.persist(celular);
			
		em.getTransaction().commit(); 
		em.close();
	}
}
