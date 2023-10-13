package ru.vtb.hackathon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vtb.hackathon.entity.ATMEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ATMRepository extends JpaRepository<ATMEntity, UUID> {

    @Query("SELECT a FROM ATMEntity a where ACOS(SIN(?1 * PI() / 180) * SIN(a.latitude * PI() / 180) + COS(?1 * PI() / 180) * COS(a.latitude * PI() / 180) * COS(?2 - a.longitude) * PI() / 180) * 6371 <= ?3")
    List<ATMEntity> findAllWithInRadius(Double lat, Double lang, Double rad);

}
