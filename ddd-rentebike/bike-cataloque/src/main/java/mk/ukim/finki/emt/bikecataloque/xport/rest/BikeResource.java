package mk.ukim.finki.emt.bikecataloque.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bikecataloque.domain.models.Bike;
import mk.ukim.finki.emt.bikecataloque.services.BikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bike")
@AllArgsConstructor

public class BikeResource {
    private final BikeService bikeService;

    @GetMapping
    public List<Bike> getAll() {
        return bikeService.getAll();
    }

}
