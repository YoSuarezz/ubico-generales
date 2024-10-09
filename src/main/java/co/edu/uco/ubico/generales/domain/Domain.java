package co.edu.uco.ubico.generales.domain;

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
}
