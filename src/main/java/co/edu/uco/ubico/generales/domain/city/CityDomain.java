package co.edu.uco.ubico.generales.domain.city;

import co.edu.uco.ubico.generales.domain.Domain;
import co.edu.uco.ubico.generales.domain.state.StateDomain;

import java.util.UUID;

public class CityDomain extends Domain {

    private String name;
    private StateDomain state;


    public CityDomain(final UUID id, final String name, final StateDomain state) {
        super(id);
        setName(name);
        setState(state);
    }

    public final String getName() {
        return name;
    }

    private final void setName(String name) {
        this.name = name;
    }

    public final StateDomain getState() {
        return state;
    }

    private final void setState(StateDomain state) {
        this.state = state;
    }
}
