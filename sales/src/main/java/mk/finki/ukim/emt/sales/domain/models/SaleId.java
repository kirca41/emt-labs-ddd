package mk.finki.ukim.emt.sales.domain.models;

import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

public class SaleId extends DomainObjectId {

    private SaleId() {
        super(SaleId.randomId(SaleId.class).getId());
    }

    public SaleId(@NonNull String uuid) {
        super(uuid);
    }

    public static SaleId of(String uuid) {
        SaleId s = new SaleId(uuid);
        return s;
    }
}
