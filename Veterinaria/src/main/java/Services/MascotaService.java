package Services;

import DAO.MascotaDAO;
import DTO.MascotaDTO;
import DTO.VacunaDTO;

import java.time.LocalDate;

public class MascotaService {

    private MascotaDAO mascotaDAO;

    public MascotaService (MascotaDAO mascotaDAO) {
        this.mascotaDAO = mascotaDAO;
    }

    public void registrarMascota (String nombre, String raza, int edad, String tipo, String id, double peso,
                                 String fechaingreso, String lugarOrigen, char genero, double precio, boolean adoptado, boolean fechaActual){

        String fecha = fechaActual ? fechaingreso : LocalDate.now().toString();
        for (MascotaDTO mascota: mascotaDAO.getMascotas()) {
            if (mascota.getId().equals(id)) {
                return;
            }
        }
        mascotaDAO.registrar(new MascotaDTO(nombre, raza, edad, tipo, id, peso, fecha, lugarOrigen, genero, precio, adoptado));
    }

    public int venderMascota (String id){
        return mascotaDAO.venderMascota(id);
    }

    public void vacunarMascota (String id, String tipo, double cantidad, LocalDate fecha, boolean actual){
        LocalDate fechaFinal = actual ? LocalDate.now() : fecha;
        VacunaDTO vacunaDTO =  new VacunaDTO(tipo);
        mascotaDAO.setVacuna(vacunaDTO, id, cantidad,  fechaFinal);
    }

    public void registrarConsulta (LocalDate fecha, String sintomas, String tratamiento, String id, boolean actual){
        LocalDate fechaFinal = actual ? LocalDate.now() : fecha;
        mascotaDAO.setConsulta(id, fechaFinal, sintomas, tratamiento);
    }
}

