package co.edu.uco.ucobet.generales.application.primaryports.dto;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;
import co.edu.uco.ucobet.generales.crosscutting.helpers.UUIDHelper;

import java.util.UUID;

public final class RegisterNewCityDTO {
    private String cityName;
    private UUID stateId;



    public RegisterNewCityDTO(final UUID stateId,final String cityName) {
        setStateId(stateId);
        setCityName(cityName);
    }

    public static RegisterNewCityDTO create(final UUID stateId,final String cityName){
        return new RegisterNewCityDTO(stateId,cityName);
    }

    public String getCity() {
        return cityName;
    }

    public void setCityName( final String cityName) {
        this.cityName = TextHelper.applyTrim(cityName);
    }

    public UUID getStateId() {
        return stateId;
    }

    private void setStateId( final UUID stateId) {
        this.stateId = UUIDHelper.getDefault(stateId,UUIDHelper.getDefault());
    }
}