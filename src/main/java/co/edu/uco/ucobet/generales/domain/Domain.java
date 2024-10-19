package co.edu.uco.ucobet.generales.domain;

import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class Domain {

    private UUID id;

    protected Domain(final UUID id) {
        setId(id);
    }

    public final UUID getId() {
        return id;
    }

    private final void setId(UUID id) {
        this.id = id;
    }

    public void generateId() {
        this.id = UUIDHelper.generate();
    }
}
