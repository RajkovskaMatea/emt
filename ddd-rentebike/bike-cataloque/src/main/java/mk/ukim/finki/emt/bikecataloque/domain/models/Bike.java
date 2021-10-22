package mk.ukim.finki.emt.bikecataloque.domain.models;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name = "bike")
@Getter
public class Bike extends AbstractEntity<BikeId> {
    private String bikeName;
    private int sales=0; //number of sales of bikes
    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })

    private Money price;
    private Bike(){
      super(BikeId.randomId(BikeId.class));
    }
    public static Bike build(String bikeName, Money price,int sales){
        Bike b=new Bike();
        b.price=price;
        b.bikeName=bikeName;
        b.sales=sales;
        return b;
    }
    public void addSales(int qty){
        this.sales -= qty;
    }
    public void removeSales(int qty){

        this.sales -=qty;
    }
}
