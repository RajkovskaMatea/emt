package mk.ukim.finki.emt.rentmanagment.domain.model;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RentItemId extends DomainObjectId {
    private RentItemId() {
        super(RentItemId.randomId(RentItemId.class).getId());
    }

    public RentItemId(String uuid) {
        super(uuid);
    }

}
