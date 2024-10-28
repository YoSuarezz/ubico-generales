package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public class StateDTO {

    private UUID id;
    private String name;
    private CountryDTO country;

    StateDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
        setCountry(CountryDTO.create());
    }

    public StateDTO(final UUID id,final String name,final CountryDTO country) {
        setId(id);
        setName(name);
        setCountry(country);
    }

    public StateDTO(UUID id, String name) {
        setId(id);
        setName(name);
        setCountry(CountryDTO.create());
    }

    static final StateDTO create() {
        return new StateDTO();
    }

    public static final StateDTO create(final UUID id, final String name, final CountryDTO country) {
        return new StateDTO(id, name, country);
    }

    public static final StateDTO create(final UUID id) {
        return new StateDTO(id, TextHelper.EMPTY, CountryDTO.create());
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = UUIDHelper.getDefault(id, UUIDHelper.getDefault());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.applyTrim(name);
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(final CountryDTO country) {
        this.country = ObjectHelper.getDefault(country, CountryDTO.create());
    }
}