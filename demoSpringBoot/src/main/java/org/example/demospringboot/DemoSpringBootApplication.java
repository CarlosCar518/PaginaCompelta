package org.example.demospringboot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import Model.*;

@SpringBootApplication
@Controller
public class DemoSpringBootApplication {

    dbService dbService;

    public DemoSpringBootApplication(dbService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping("/")
    public String home(Model model) {
        return "index";
    }

    @RequestMapping("/adoptar")
    public String adoptar(Model model) {
        model.addAttribute("mascotaList", dbService.getMascotas());
        model.addAttribute("accesorioList", dbService.getAccesorios());
        return "adoptar";
    }

    @PostMapping("/complete")
    public ResponseEntity<byte[]> complete(Model model, @RequestParam("Mascota") int mascota,
            @RequestParam("itemsJson") String carrito) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Accesorio> accesorios = mapper.readValue(carrito,
                new TypeReference<List<Accesorio>>() {
        });

        List<Mascota> mascotas = dbService.getMascotas();
        Mascota mascotaFinal = null;

        for (Mascota mascota1 : mascotas) {
            if (mascota1.getId() == mascota) {
                mascotaFinal = mascota1;
                break;
            }
        }

        pdfService pdf = new pdfService();

        assert mascotaFinal != null;

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=recibo.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf.createPdf(mascotaFinal, accesorios));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }
}
