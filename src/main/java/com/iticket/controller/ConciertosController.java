/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iticket.controller;

import com.iticket.entity.Artista;
import com.iticket.entity.Conciertos;
import com.iticket.service.IArtistaService;
import com.iticket.service.IConciertosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author rivil
 */
@Controller
public class ConciertosController{
    
    @Autowired
    private IConciertosService conciertosService;

    @Autowired
    private IArtistaService artistaService;

    //Metodo que arrastra los datos de base de datos al htnml
    @GetMapping("/conciertos")
    public String index(Model model) {
        List<Conciertos> listaConciertos = conciertosService.getAllConciertos();
        model.addAttribute("titulo", "Tabla Conciertos");
        model.addAttribute("conciertos", listaConciertos);
        return "conciertos";//devolvera html conciertos
    }

    //Metodo que crear una nueva conciertos
    @GetMapping("/ConciertosN")
    public String crearConciertos(Model model) {
        List<Artista> listaArtista = artistaService.listArtista();
        model.addAttribute("conciertos", new Conciertos());
        model.addAttribute("artista", listaArtista);
        return "crear";//devolvera html crear
    }

    //Metodo que guardar la nueva conciertos y su info
    @PostMapping("/save")//cuando se usa ese url pasa lo de abajo
    public String guardarConciertos(@ModelAttribute Conciertos conciertos) {
        conciertosService.saveConciertos(conciertos);
        return "redirect:/conciertos";
    }

    //Metodo que edita
    @GetMapping("/editConciertos/{id}")
    public String editarConciertos(@PathVariable("id") Long idConciertos, Model model) {
        Conciertos conciertos = conciertosService.getConciertosById(idConciertos);
        List<Artista> listaArtistas = artistaService.listArtista();
        model.addAttribute("conciertos", conciertos);
        model.addAttribute("artista", listaArtistas);
        return "crear";
    }

    //Metodo que elimina
    @GetMapping("/delete/{id}")
    public String eliminarConciertos(@PathVariable("id") Long idConciertos) { 
        conciertosService.delete(idConciertos);
        return "redirect:/conciertos";
    }
    
}
