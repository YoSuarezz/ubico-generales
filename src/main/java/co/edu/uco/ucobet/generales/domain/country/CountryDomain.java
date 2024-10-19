package co.edu.uco.ucobet.generales.domain.country;

import co.edu.uco.ucobet.generales.domain.Domain;

import java.util.UUID;

public final class CountryDomain extends Domain {

    private String name;

    public CountryDomain(UUID id) {
        super(id);
        setName(name);
    }

    public final String getName() {
        return name;
    }

    private final void setName(String name) {
        this.name = name;
    }
}