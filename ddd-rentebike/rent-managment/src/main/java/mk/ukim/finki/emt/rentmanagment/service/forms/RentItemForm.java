package mk.ukim.finki.emt.rentmanagment.service.forms;


import lombok.Data;
import mk.ukim.finki.emt.rentmanagment.domain.valueobjects.Bike;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RentItemForm {
    @NotNull
    private Bike bike;

    @Min(1)
    private int quantity=1;
}
