package ru.vtb.hackathon.repository.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vtb.hackathon.entity.OfficeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, UUID> {

    @Query("SELECT a FROM OfficeEntity a where ACOS(SIN(?1 * PI() / 180) * SIN(a.geoPosition.latitude * PI() / 180) + COS(?1 * PI() / 180) * COS(a.geoPosition.latitude * PI() / 180) * COS(?2 - a.geoPosition.longitude) * PI() / 180) * 6371 <= ?3")
    List<OfficeEntity> findAllWithInRadius(Double lat, Double lang, Double rad);

}
