package co.edu.uco.ubico.generales.domain.state;

import co.edu.uco.ubico.generales.domain.Domain;
import co.edu.uco.ubico.generales.domain.country.CountryDomain;

import java.util.UUID;

public final class StateDomain extends Domain {

    private String name;
    private CountryDomain country;

    public StateDomain(final UUID id, final String name, final CountryDomain country) {
        super(id);
        setName(name);
        setCountry(country);
    }

    public final String getName() {
        return name;
    }

    private final void setName(String name) {
        this.name = name;
    }

    public final CountryDomain getCountry() {
        return country;
    }

    private final void setCountry(CountryDomain country) {
        this.country = country;
    }
}
