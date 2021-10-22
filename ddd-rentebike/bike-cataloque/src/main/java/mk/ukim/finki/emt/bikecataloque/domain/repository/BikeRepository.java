package mk.ukim.finki.emt.bikecataloque.domain.repository;

import mk.ukim.finki.emt.bikecataloque.domain.models.Bike;
import mk.ukim.finki.emt.bikecataloque.domain.models.BikeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike, BikeId> {
}
