package mk.ukim.finki.emt.bikecataloque.config;

import mk.ukim.finki.emt.bikecataloque.domain.models.Bike;
import mk.ukim.finki.emt.bikecataloque.domain.repository.BikeRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
public class DataInitializer {

    private final BikeRepository bikeRepository;

    public DataInitializer(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }


    @PostConstruct
    public void initData() {
        Bike b1 = Bike.build("Bike1", Money.valueOf(Currency.MKD,2000), 7);
        Bike b2 = Bike.build("Bike2", Money.valueOf(Currency.MKD,2000), 6);
        if (bikeRepository.findAll().isEmpty()) {
            bikeRepository.saveAll(Arrays.asList(b1,b2));
        }
    }

}
