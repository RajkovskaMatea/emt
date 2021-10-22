package mk.ukim.finki.emt.bikecataloque.services.implementation;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bikecataloque.domain.exceptions.BikeNotFoundException;
import mk.ukim.finki.emt.bikecataloque.domain.models.Bike;
import mk.ukim.finki.emt.bikecataloque.domain.models.BikeId;
import mk.ukim.finki.emt.bikecataloque.domain.repository.BikeRepository;
import mk.ukim.finki.emt.bikecataloque.services.BikeService;
import mk.ukim.finki.emt.bikecataloque.services.form.BikeForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepository bikeRepository;

    @Override
    public Bike findById(BikeId id) {
        return bikeRepository.findById(id).orElseThrow(BikeNotFoundException::new);
    }

    @Override
    public Bike createBike(BikeForm form) {
        Bike b=Bike.build(form.getBikeName(),form.getPrice(),form.getSales());
        bikeRepository.save(b);
        return b;
    }


    @Override
    public Bike rentItemCreated(BikeId bikeId, int quantity) {
        Bike b=bikeRepository.findById(bikeId).orElseThrow(BikeNotFoundException::new);
        b.addSales(quantity);
        bikeRepository.saveAndFlush(b);
        return b;
    }

    @Override
    public Bike rentItemRemoved(BikeId bikeId, int quantity) {
        Bike b=bikeRepository.findById(bikeId).orElseThrow(BikeNotFoundException::new);
        b.removeSales(quantity);
        bikeRepository.saveAndFlush(b);
        return b;
    }

    @Override
    public List<Bike> getAll() {
        return bikeRepository.findAll();
    }
}
