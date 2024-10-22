package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class CityDTO {

    private UUID id;
    private String name;
    private StateDTO state;

    public CityDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setState(StateDTO.create());
    }

    static final CityDTO create() {
        return new CityDTO();
    }

    public static final CityDTO create(final UUID id, final String name, final StateDTO state) {
        return new CityDTO(id, name, state);
    }

    public CityDTO(final UUID id,final String name,final StateDTO state) {
        setId(id);
        setName(name);
        setState(state);
    }

    public static final CityDTO create(final UUID id) {
        return new CityDTO(id, TextHelper.EMPTY, StateDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public StateDTO getState() {
        return state;
    }

    public void setState(final StateDTO state) {
        this.state = ObjectHelper.getDefault(state, StateDTO.create());
    }
}