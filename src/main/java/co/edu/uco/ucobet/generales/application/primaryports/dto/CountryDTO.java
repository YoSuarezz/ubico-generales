package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class CountryDTO {

    private UUID id;
    private String name;

    public CountryDTO() {
        setId(UUIDHelper.getDefault());
        setName(TextHelper.EMPTY);
    }

    public CountryDTO(final UUID id, final String name) {
        setId(id);
        setName(name);
    }

    static final CountryDTO create() {
        return new CountryDTO();
    }

    public static final CountryDTO create(final UUID id, final String name) {
        return new CountryDTO(id, name);
    }

    public static final CountryDTO create(final UUID id) {
        return new CountryDTO(id, TextHelper.EMPTY);
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
}