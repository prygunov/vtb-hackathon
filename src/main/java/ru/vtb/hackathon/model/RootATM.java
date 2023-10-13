package ru.vtb.hackathon.model;

import lombok.Data;
import ru.vtb.hackathon.entity.ATMEntity;

import java.util.List;

@Data
public class RootATM {

    List<ATMEntity> atms;

}
