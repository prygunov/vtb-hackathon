package ru.vtb.hackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.vtb.hackathon.model.OfficeTime;

@Entity
@Getter
@Setter
@Table(name = "office")
@NoArgsConstructor
public class OfficeEntity {

    @Id
    private Long id;
    private String salePointName;
    private String addressString;
    private String status;

    private Double latitude;
    private Double longitude;
}
