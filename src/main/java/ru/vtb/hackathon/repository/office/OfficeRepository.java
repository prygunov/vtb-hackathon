package ru.vtb.hackathon.repository.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vtb.hackathon.entity.OfficeEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, UUID> {

    @Query(value = "SELECT * FROM (SELECT id, address, latitude, longitude, kep, metro_station, my_branch, office_type, sale_point_format, sale_point_name, status, suo_availability, " +
            "6371 * acos(cos(radians(:lat)) * cos(radians(latitude)) * cos(radians(longitude) - radians(:lon)) + sin(radians(:lat)) * sin(radians(latitude))) AS distance " +
            "FROM office) WHERE distance <= :rad", nativeQuery = true)
    List<OfficeEntity> findAllWithInRadius(@Param("lat") Double lat, @Param("lon") Double lon, @Param("rad") Double rad);

}
