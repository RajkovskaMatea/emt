package mk.ukim.finki.emt.rentmanagment.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.rentmanagment.domain.valueobjects.BikeId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rent_item")
@Getter
public class RentItem extends AbstractEntity<RentItemId> {
    private Money itemPrice;
    @Column(name = "qty", nullable = false)
    private int quantity;
    @AttributeOverride(name = "id", column = @Column(name = "bike_id", nullable = false))
    private BikeId bikeId;

    private RentItem() {

        super(DomainObjectId.randomId(RentItemId.class));

    }
    public RentItem(@NonNull BikeId bikeId, @NonNull Money itemPrice, int qty) {
        super(DomainObjectId.randomId(RentItemId.class));
      this.bikeId=bikeId;
      this.itemPrice=itemPrice;
      this.quantity=qty;
    }
    public Money subtotal(){
        return itemPrice.multiply(quantity);
    }
}
