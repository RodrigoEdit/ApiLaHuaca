package com.javawhizz.App.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javawhizz.App.Entidades.Cliente;
import com.javawhizz.App.Interfaz.ICliente;


@Service
public class ServiceCliente {
    @Autowired
    private ICliente icliente;


    public Cliente guardarclientes(Cliente cliente) {
        return icliente.save(cliente);
    }

	public List<Cliente> listarclientes(){
		return (List<Cliente>)icliente.findAll();
	}


    public Optional<Cliente> buscarclientePorId(long id) {
        return icliente.findById(id);
    }

	 public Cliente editarcliente(Cliente cliente) {
        return icliente.save(cliente);
    }


    public void eliminarcliente(long id) {
        icliente.deleteById(id);
    }
    
}
