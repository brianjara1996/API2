package com.API2.mascota.Dao;

import com.API2.mascota.Models.mascota;

public interface mascotaDao {
	
	mascota loginMascota(mascota M);
	
	mascota buscoMascota(Long id);
	
	String eliminarM(Long id);
	
	String agregarM(mascota m);
	
	String actualizarM(mascota m);
	

}
