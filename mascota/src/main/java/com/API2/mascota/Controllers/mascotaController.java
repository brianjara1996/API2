package com.API2.mascota.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.API2.mascota.Dao.mascotaDao;
import com.API2.mascota.Models.mascota;
import com.API2.mascota.Utils.ErrorMensaje;
import com.API2.mascota.Utils.JWTUtil;

@RestController
public class mascotaController {
	
	@Autowired
	private mascotaDao MascotaDao;
	
    @Autowired
    private JWTUtil jwtUtil;
    
    
    @RequestMapping(value = "api/LoginM" , method = RequestMethod.POST)
    public String loginM(@RequestBody mascota mas){

    	mascota mm = MascotaDao.loginMascota(mas);
    	
     if(mm.getId() !=  0) {
    	 	 
    	 String Token = jwtUtil.create(mm.getApellido() , mm.getNombre());
    	 
    	 return Token;
     } 
     
     return "FAIL";

    }
    
    
    @RequestMapping(value = "api/mascota/{id}" , method = RequestMethod.GET)
    public Object getmascota(@PathVariable Long id, @RequestHeader(value="Authorization") String token){
   	
    	
    	
    	String verifico = jwtUtil.getKey(token);
    	
    	if(verifico == null) {
    		
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Token recibido no valido para continuar");
    		
    		return er;
    	}
    	else {
    		
        	mascota masco = new mascota();
        	
        	masco = MascotaDao.buscoMascota(id);
        	
        	
        	if(masco.getId() == 0 && masco.getNombre() == null) {

        		ErrorMensaje er = new ErrorMensaje();
        		er.setCode(500);
        		er.setMensaje("No se encontro mascota con ese id en la Base de datos");
        		
        		return er;
        	}
        	else {
        	  return masco;
        	}
    	}
    	    	
    }
    
    
    @RequestMapping(value = "api/mascota-delete/{id}", method = RequestMethod.GET)
    public Object Eliminar(@PathVariable Long id , @RequestHeader(value="Authorization") String token){
   	
    	
    	
    	String verifico = jwtUtil.getKey(token);
    	
    	if(verifico == null) {
    		
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Token recibido no valido para continuar");
    		
    		return er;
    	}
    	else {
    		
        	String resp = MascotaDao.eliminarM(id);
        	
        	if(resp == "OK") {
        		
        		ErrorMensaje er = new ErrorMensaje();
        		er.setCode(200);
        		er.setMensaje("Se Elimino correctamente");
        		
        		return er;
        		
        	}
        	else {
        	
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(200);
    		er.setMensaje("No se encontro mascota para eliminar en DB");
    		
    		return er;
        	
        	}
    	}
    		
    }
    
    
    
    @RequestMapping(value = "api/persona-add" , method = RequestMethod.POST)
    public Object agregarM(@RequestBody mascota pp , @RequestHeader(value="Authorization") String token){
   	
    	
    	
    	String verifico = jwtUtil.getKey(token);
    	
    	
    	if(verifico == null) {
    		
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Token recibido no valido para continuar");
    		
    		return er;
    		
    	}
    	else {
    		
    		String resu = MascotaDao.agregarM(pp);
    		    		
             if(resu == "OK") {
        		
        		ErrorMensaje er = new ErrorMensaje();
        		er.setCode(200);
        		er.setMensaje("Se agrego correctamente");
        		
        		return er;
        		
        	}
        	else {
        	
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Error al agregar mascota a la DB");
    		
    		return er;
        	
        	}
    		
    	}

    }
    
    
    
    @RequestMapping(value = "api/mascota-update" , method = RequestMethod.POST)
    public Object actulizarM(@RequestBody mascota pp , @RequestHeader(value="Authorization") String token){
   	
    	
    	
    	String verifico = jwtUtil.getKey(token);
    	
    	
    	if(verifico == null) {
    		
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Token recibido no valido para continuar");
    		
    		return er;
    		
    	}
    	else {
    	
    		String resp = MascotaDao.actualizarM(pp);
    		
    		 if(resp == "OK") {
         		
         		ErrorMensaje er = new ErrorMensaje();
         		er.setCode(200);
         		er.setMensaje("Se agrego correctamente");
         		
         		return er;
         		
         	}
         	else {
         	
     		ErrorMensaje er = new ErrorMensaje();
     		er.setCode(500);
     		er.setMensaje("Error al agregar persona a la DB");
     		
     		return er;
         	
         	}
    		
    	}
    }
    
    
    @RequestMapping(value = "api/mascota-imagen" , method = RequestMethod.POST)
    public Object getImagen(@RequestBody mascota mm , @RequestHeader(value="Authorization") String token){

    	String verifico = jwtUtil.getKey(token);
    	
    	if(verifico == null) {
    		
    		ErrorMensaje er = new ErrorMensaje();
    		er.setCode(500);
    		er.setMensaje("Token recibido no valido para continuar");
    		
    		return er;
    	}
    	else {
    		
    		return MascotaDao.loginMascota(mm);
    	}
    
    }
    

}
