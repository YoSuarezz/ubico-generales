package co.edu.uco.ubico.generales.domain;

public interface DomainRule <T>{
    void validate(T data);
}
