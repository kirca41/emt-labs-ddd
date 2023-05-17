package mk.ukim.finki.emt.products.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.NonNull;
import mk.finki.ukim.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class EmployeeId extends DomainObjectId {

    private EmployeeId() {
        super(EmployeeId.randomId(EmployeeId.class).getId());
    }

    public EmployeeId(@NonNull String uuid) {
        super(uuid);
    }

    public static EmployeeId of(String uuid) {
        EmployeeId e = new EmployeeId(uuid);
        return e;
    }
}
