/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectobubble.controlador;

import com.example.proyectobubble.entidad.Imagen;
import com.example.proyectobubble.servicio.ImagenServicio;
import java.io.IOException;
import java.util.Base64;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/")
@Slf4j
public class ControladorGeneral {

    @Autowired
    private ImagenServicio imagenServicio;

    @GetMapping("/")
    public String inicio() {
        log.info("pagina inicio");
        return "inicio.html";

    }

    @PostMapping("/")
    public String busqueda(ModelMap modelo, @RequestParam String buscarsolicitado) {
        System.out.println(buscarsolicitado);
        Imagen imagen = imagenServicio.obtenerImagen(buscarsolicitado);
        System.out.println(imagen.toString());
        String buscar = buscarsolicitado;
        String imagenBase64 = Base64.getEncoder().encodeToString(imagen.getContenido());
        modelo.addAttribute("buscar", buscar);
        modelo.addAttribute("imagen", imagenBase64);
        log.info("busqueda solicitada");
        return "inicio.html";

    }

    @PostMapping("/guardarimagenbbdd")
    public String cargarImagen(@RequestParam String nombre, MultipartFile archivo) throws IOException {
        log.info("cargar imagen");
        imagenServicio.guardarImagen(nombre, archivo);
        return "inicio.html";
    }

    @GetMapping("/novedades")
    public String novedades() {
        log.info("NOVEDADES!");
        return "novedades.html";
    }

    @GetMapping("/contacto")
    public String contacto() {
        log.info("CONTACTO!");
        return "contacto.html";
    }
}
