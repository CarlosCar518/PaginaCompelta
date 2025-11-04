package Services;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import EnumErrores.OutCome;

public class ClienteService {
    ClienteDAO clienteDAO = new ClienteDAO();

    public OutCome registrarCliente (String id, String nombre,
                                     String direccion, String telefono) {
        if (clienteDAO.getCliente(id) != null) {
            return OutCome.REPEATED;
        }
        clienteDAO.registrarCliente(new ClienteDTO(id,nombre,direccion,telefono));
        return OutCome.SUCCESS;
    }

}
