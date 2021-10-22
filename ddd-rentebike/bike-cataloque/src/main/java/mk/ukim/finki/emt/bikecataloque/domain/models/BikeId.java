package mk.ukim.finki.emt.bikecataloque.domain.models;


import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class BikeId extends DomainObjectId {
    private BikeId() {
        super(BikeId.randomId(BikeId.class).getId());
    }

    public BikeId(@NonNull String uuid) {
        super(uuid);
    }

    public static BikeId of(String uuid) {
        BikeId b = new BikeId(uuid);
        return b;
    }

}
