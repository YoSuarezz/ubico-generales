package co.edu.uco.ucobet.generales.application.secondaryports.repository;

import co.edu.uco.ucobet.generales.application.secondaryports.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, UUID>, CityRepositoryCustom {
    boolean isCityBeingUsed(UUID cityId);
}
