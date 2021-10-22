package mk.ukim.finki.emt.bikecataloque.services.form;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class BikeForm {
    private String bikeName;
    private Money price;
    private int sales;
}
