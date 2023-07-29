package core.domain.entities;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class BaseEntityModel {
    @Id
    @Column(name = "`Id`")
    protected UUID id = UUID.randomUUID();

    public UUID getId() {
        return id;
    }

}
