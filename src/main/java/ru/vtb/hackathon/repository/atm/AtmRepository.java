package ru.vtb.hackathon.repository.atm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.hackathon.entity.AtmEntity;
import ru.vtb.hackathon.entity.OfficeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface AtmRepository extends JpaRepository<AtmEntity, UUID> {

    @Query("SELECT o FROM AtmEntity o WHERE (6371 * " +
            "acos(cos(radians(:lat)) * cos(radians(o.geoPosition.latitude)) * cos(radians(o.geoPosition.longitude) - radians(:lan)) + " +
            "sin(radians(:lat)) * sin(radians(o.geoPosition.latitude)))) <= :rad")
    List<AtmEntity> findAllWithInRadius(@Param("lat") Double lat, @Param("lan") Double lan, @Param("rad") Double rad);


}
