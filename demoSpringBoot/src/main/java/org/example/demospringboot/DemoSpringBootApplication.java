package org.example.demospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Model.*;


@SpringBootApplication
@Controller
public class DemoSpringBootApplication {
    dbService dbService;

    public DemoSpringBootApplication(dbService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping("/")
    String home(Model model) {
        return "index";
    }

    @RequestMapping("/adoptar")
    String adoptar(Model model) {
        model.addAttribute("mascotaList", dbService.getMascotas());
        model.addAttribute("accesorioList",  dbService.getAccesorios());
        return "adoptar";
    }

    @RequestMapping("/complete")
    String complete(Model model, @RequestParam("Accesorio") int accesorioId, @RequestParam("Mascota") int mascotaId ) {
        List<Mascota> mascotas = dbService.getMascotas();

        return  "su mama";
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoSpringBootApplication.class, args);
    }
}

