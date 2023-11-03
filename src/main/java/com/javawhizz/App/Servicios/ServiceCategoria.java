package com.javawhizz.App.Servicios;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawhizz.App.Entidades.Categoria;
import com.javawhizz.App.Interfaz.ICategoria;


@Service
public class ServiceCategoria {
    @Autowired
    private ICategoria icategorias;

    // Método para guardar una nueva categoría
    public Categoria guardarCategoria(Categoria categoria) {
        return icategorias.save(categoria);
    }

	public List<Categoria> listarcategorias(){
		return (List<Categoria>)icategorias.findAll();
	}

	// Método para buscar una categoría por su ID
    public Optional<Categoria> buscarCategoriaPorId(long id) {
        return icategorias.findById(id);
    }
	 // Método para editar una categoría existente
	 public Categoria editarCategoria(Categoria categoria) {
        return icategorias.save(categoria);
    }

    // Método para eliminar una categoría por su ID
    public void eliminarCategoria(long id) {
        icategorias.deleteById(id);
    }
    
}
