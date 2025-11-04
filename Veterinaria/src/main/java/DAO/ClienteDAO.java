package DAO;

import DTO.ClienteDTO;
import DTO.MascotaDTO;
import DTO.VentaDTO;
import EnumErrores.OutCome;

import java.util.ArrayList;

public class ClienteDAO {
    private ArrayList<ClienteDTO> clientes = new ArrayList<>();

    public ClienteDTO getCliente(String id) {
        for (ClienteDTO cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public void registrarCliente(ClienteDTO cliente) {
        clientes.add(cliente);
    }

    public OutCome encontrarMascota(String idCliente, MascotaDTO mascota) {
        ClienteDTO cliente = getCliente(idCliente);
        ArrayList<MascotaDTO> mascotasCliente = cliente.getMascotas();
        for (MascotaDTO m : mascotasCliente) {
            if (m.getId().equals(mascota.getId())) {
                return OutCome.NOT_FOUND;
            }
        }
        return OutCome.SUCCESS;
    }

    public OutCome addMascota(String id, MascotaDTO mascota) {
        if (encontrarMascota(id, mascota) == OutCome.NOT_FOUND) {
            return OutCome.NOT_FOUND;
        }
        getCliente(id).addMascota(mascota);
        return OutCome.SUCCESS;
    }

    public OutCome  addVenta(String id, VentaDTO venta){
        ClienteDTO cliente = getCliente(id);
        if (cliente == null) {
            return OutCome.NOT_FOUND;
        }
        getCliente(id).addVenta(venta);
        return OutCome.SUCCESS;
    }

}
