package mk.ukim.finki.emt.rentmanagment.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.rentmanagment.domain.valueobjects.Bike;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "rents")
@Getter
public class Rent extends AbstractEntity<RentId> {
    private Instant rentedOn;
    @Enumerated(EnumType.STRING)
    private RentState rentState;
    @Column(name = "rent_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;
   // private Money total;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RentItem> rentItemList=new HashSet<>();


    private Rent(){
        super(RentId.randomId(RentId.class));
    }
    public Rent(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency){
        super(RentId.randomId(RentId.class));
        this.rentedOn=now;
        this.currency=currency;
    }

    public Money total(){
        //calculates sum of all rent items
        return rentItemList.stream().map(RentItem::subtotal).reduce(new Money(currency, 0),
                Money::add);

    }
    //add and delete item from rent entity
    public RentItem addItem(@NonNull Bike bike, int qty){
        Objects.requireNonNull(bike, "bike must not be null");
        var item=new RentItem(bike.getId(), bike.getPrice(),qty);
        rentItemList.add(item);
        return item;
    }
    public void removeItem(@NonNull RentItemId rentItemId){
        Objects.requireNonNull(rentItemId, "Rent item must not be null");
        rentItemList.removeIf(v->v.getId().equals(rentItemId));
    }
}
