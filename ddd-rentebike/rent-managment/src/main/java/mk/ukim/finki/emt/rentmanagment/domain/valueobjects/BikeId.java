package mk.ukim.finki.emt.rentmanagment.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class BikeId extends DomainObjectId {
private BikeId(){
    super(BikeId.randomId(BikeId.class).getId());
}
public BikeId(String uuid){
    super(uuid);
}

}
