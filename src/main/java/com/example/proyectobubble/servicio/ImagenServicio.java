/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectobubble.servicio;

import com.example.proyectobubble.entidad.Imagen;
import com.example.proyectobubble.repositorio.ImagenRepositorio;
import jakarta.transaction.Transactional;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepositorio imagenRepositorio;

    public Imagen obtenerImagen(String buscar) {
        Imagen imagen = imagenRepositorio.buscarImagenPorFrase(buscar);
        return imagen;
    }

    @Transactional
    public void guardarImagen(String nombre, MultipartFile archivo) throws IOException {
        Imagen imagen = new Imagen();
        imagen.setMime(archivo.getContentType());
        imagen.setNombre(nombre);
        imagen.setContenido(archivo.getBytes());
        imagenRepositorio.save(imagen);
    }
}
