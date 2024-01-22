/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectobubble.repositorio;

import com.example.proyectobubble.entidad.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen,String>{
    @Query("SELECT i FROM Imagen i WHERE i.nombre = :buscar")
    public Imagen buscarImagenPorFrase (@Param("buscar") String buscar);
}
