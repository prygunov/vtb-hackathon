package ru.vtb.hackathon.model;

import lombok.Data;
import ru.vtb.hackathon.entity.AtmEntity;

import java.util.List;

@Data
public class RootAtm {

    List<AtmEntity> atms;

}
