package org.example.demospringboot;

import Model.Accesorio;
import Model.Mascota;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class dbService {

    private final   JdbcTemplate jdbcTemplate;

    public dbService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mascota> getMascotas() {
        return  jdbcTemplate.query("SELECT * FROM animales",
                (rs, rowNum) -> new Mascota(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo")
                ));
    }


    public List<Accesorio> getAccesorios() {

        return  jdbcTemplate.query("SELECT * FROM accesorio",
                (rs, rowNum) -> new Accesorio(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio"),
                        rs.getInt("cantidad")
                ));
    }


    public void addMascota(Mascota mascota) {
        jdbcTemplate.update(
                "INSERT INTO animales (nombre) VALUES (?)",
                mascota.nombre
        );
    }
}
