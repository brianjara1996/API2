package com.API2.mascota.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.API2.mascota.Models.mascota;

@Repository
@Transactional

public class mascotaDaoImpl implements mascotaDao{
	
    @PersistenceContext
   private EntityManager entityManager;

	@Override
	public mascota loginMascota(mascota M) {			
			
	        String query = "From mascota where nombre ='" + M.getNombre() + "' and apellido = '" + M.getApellido() +"'";

	        List<mascota> result =  entityManager.createQuery(query).getResultList();

	        if(result.isEmpty()){
	            return null;
	        }
	        else {
	            return result.get(0);
	        }
			
		
	}

	@Override
	public mascota buscoMascota(Long id) {
		
		mascota p = new mascota();
		
		try {
			String query = "From mascota where id = "+ id;

			
			p = (mascota) entityManager.createQuery(query).getSingleResult();
			
			return p;
		}
		catch(Exception e) {
			System.out.println("Error al buscar en tabla mascota");
			
			return p;
		}
		
	}

	@Override
	public String eliminarM(Long id) {
		
		mascota p = new mascota();		
		
		try {		
	        String query = "from mascota where id = "+ id;
	        
	        p =  (mascota) entityManager.createQuery(query).getSingleResult();
	        
	         entityManager.remove(p);
	         
	        
	}
	catch(Exception e) {
		System.out.println("Error al buscar en tabla mascota");
		
		return "ERROR";
	}
     
     
     return "OK";
		
	}

	@Override
	public String agregarM(mascota m) {
		try {
			
			entityManager.merge(m);
			
			return "OK";
			
		}
		catch(Exception e) {
			System.out.println("Error al mascota persona");
			return "ERROR";
		}
		
	}

	@Override
	public String actualizarM(mascota m) {
		try {
			
				
	            String query2 = "Update mascota set nombre = '"+m.getNombre()+"', apellido = '"+ m.getApellido()+"', edad = "+m.getEdad()+",  imagen = '" + m.getImagen() +"' where id = " + m.getId() + "";
	            
	            entityManager.createQuery(query2).executeUpdate();
				
	            return "OK";
					
		}
		catch(Exception e) {
			System.out.println("Error al actualizar datos de  persona");
			return "ERROR";
		}
	}


}
