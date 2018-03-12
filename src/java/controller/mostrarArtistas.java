/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Artista;
import model.ArtistaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author zero
 */
/* La persistencia permite hace una consulta unida
    basada en las reaciones entre las tablas:
    
*/
@Controller
@RequestMapping("/mostrar.htm")
public class mostrarArtistas {
    
    /* permite que spring construya y destruya las variables cuando lo requiera */
    @Autowired
    private ArtistaDAO dao;
    
    @RequestMapping(method = RequestMethod.GET)
    public String fGet(){
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String mostrarArtista(
        @RequestParam("txtNombre") String nombre,
        @RequestParam("txtEdad") int edad,
        @RequestParam("txtPais") String pais,
        @RequestParam("txtGenero_musical") String genero_musical,
        Model model
    ){
        Artista a = new Artista();
        a.setNombre(nombre);
        a.setEdad(edad);
        a.setPais(pais);
        a.setGeneromusical(genero_musical);
        
        try{
            dao.create(a);/* Almacena un artista */
            model.addAttribute("listaArtistas", dao.readAllJPQL());
            return "mostrar";/* debería mostrarlos a todos*/
        }catch(Exception e){
            model.addAttribute("err", e);
            return "error";
        }
        
    }
    
}
