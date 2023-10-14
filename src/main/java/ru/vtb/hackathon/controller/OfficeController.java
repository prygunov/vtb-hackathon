package ru.vtb.hackathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.hackathon.entity.OfficeEntity;
import ru.vtb.hackathon.model.DirectionMode;
import ru.vtb.hackathon.model.dto.office.OfficeDto;
import ru.vtb.hackathon.service.office.OfficeService;

import java.util.List;

@RestController
@Tag(name = "Офисы", description = "описание")
@RequestMapping("/api/v1/offices")
@RequiredArgsConstructor
public class OfficeController {

    private final OfficeService officeService;

    @GetMapping
    @Operation(description = "Получить офисы по гео", summary = "В заданном радиусе от заданной точки")
    public List<OfficeDto> getOffices(@RequestParam(value = "lat") Double latitude,
                                      @RequestParam(value = "long") Double longitude,
                                      @RequestParam(value = "rad") Double rad) {
        return officeService.findAllOfficesAround(latitude, longitude, rad);
    }

    @GetMapping("/near")
    @Operation(description = "Получить офисы по гео, дистанцию и время", summary = "По удалению от заданной точки")
    public List<OfficeDto> getNearestOffices(@RequestParam(value = "lat") Double latitude,
                                                @RequestParam(value = "long") Double longitude,
                                                @RequestParam(value = "rad") Double rad,
                                                @RequestParam(value = "mode") DirectionMode mode) {
        return officeService.findNearOffices(latitude, longitude, rad, mode);
    }

}
