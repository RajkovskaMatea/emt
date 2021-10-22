package mk.ukim.finki.emt.bikecataloque.domain.valueobjects;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Quantity implements ValueObject {
    //quantity refers to how many bikes are on stock and that's why it is in bike cataloque,
    // and not in shared kernel
    private final int quantity;
    protected Quantity(){
        //quantity is set to zero because it is final and immutable
        this.quantity=0;
    }
}
