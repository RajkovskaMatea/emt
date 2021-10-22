package mk.ukim.finki.emt.rentmanagment.domain.repository;

import mk.ukim.finki.emt.rentmanagment.domain.model.Rent;
import mk.ukim.finki.emt.rentmanagment.domain.model.RentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, RentId> {

}
