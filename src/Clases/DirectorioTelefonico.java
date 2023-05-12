package Clases;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class DirectorioTelefonico {
    Map<Long,Cliente> clientes=new HashMap();

    public DirectorioTelefonico() {
    }

    public Map<Long, Cliente> getClientes() {
        return clientes;
    }
    
    public boolean agregarCliente(Cliente cliente) {
        if (clientes.containsKey(cliente.getTelefono())) {
            return false;
        }else{
            clientes.put(cliente.getTelefono(), cliente);
            return true;
        }
    }

    public boolean buscarCliente(long telefono) {
        if (clientes.containsKey(telefono)) {
            return true;
        }
        return false;
    }

    public Map<Long,Cliente> buscarTelefono(String apellido) {
        Map<Long,Cliente> encontrados=new HashMap();
        for(Map.Entry<Long,Cliente> cliente:clientes.entrySet()){
            if(cliente.getValue().getApellido().equalsIgnoreCase(apellido)){
                encontrados.put(cliente.getKey(), cliente.getValue());
            }
        }
        return encontrados;
    }

    public Map<Long,Cliente> buscarClientes(String ciudad) {
        Map<Long,Cliente> encontrados=new HashMap();
        for(Map.Entry<Long,Cliente> cliente:clientes.entrySet()){
            if(cliente.getValue().getCiudad().equalsIgnoreCase(ciudad)){
                encontrados.put(cliente.getKey(), cliente.getValue());
            }
        }
        return encontrados;
    }

    public boolean borrarCliente(long telefono) {
        if(clientes.containsKey(telefono)){
            clientes.remove(telefono);
            return true;
        }
        return false;
    }
}
