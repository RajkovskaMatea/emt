package mk.ukim.finki.emt.rentmanagment.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Bike implements ValueObject {
    private final BikeId id;
    private final String name;
    private final Money price;
    private final int sales;

    private Bike() {
        this.id=BikeId.randomId(BikeId.class);
        this.name="";
        this.price=Money.valueOf(Currency.MKD, 0);
        this.sales = 0;
    }
    @JsonCreator
    public Bike(@JsonProperty("id") BikeId id,
                @JsonProperty("bikeName")String name,
                @JsonProperty("price")Money price,
                @JsonProperty("sales")int sales)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales=sales;
    }

}
