package mk.ukim.finki.emt.bikecataloque.services;

import mk.ukim.finki.emt.bikecataloque.domain.models.Bike;
import mk.ukim.finki.emt.bikecataloque.domain.models.BikeId;
import mk.ukim.finki.emt.bikecataloque.services.form.BikeForm;

import java.util.List;

public interface BikeService {
    Bike findById(BikeId id);
    Bike createBike(BikeForm form);
    Bike rentItemCreated(BikeId bikeId, int quantity);
    Bike rentItemRemoved(BikeId bikeId, int quantity);
    List<Bike> getAll();
}
