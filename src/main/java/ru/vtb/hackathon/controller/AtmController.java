package ru.vtb.hackathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.hackathon.dto.atm.AtmDto;
import ru.vtb.hackathon.dto.feature.Feature;
import ru.vtb.hackathon.service.atm.AtmService;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Банкоматы")
@RequestMapping("/api/v1/atms")
@RequiredArgsConstructor
public class AtmController {

    private final AtmService atmService;

    @GetMapping
    @Operation(description = "Получить банкоматы по гео, дистанцию", summary = "По удалению от заданной точки")
    public List<AtmDto> getAtmAround(@RequestParam(value = "lat") Double latitude,
                                     @RequestParam(value = "long") Double longitude,
                                     @RequestParam(value = "rad") Double rad) {
        return atmService.findAllAtmAround(latitude, longitude, rad);
    }

    @PostMapping("/filter")
    @Operation(description = "Получить банкоматы по гео с фильтром", summary = "Фильтр по сервисам")
    public List<AtmDto> getAtmAround(@RequestParam(value = "lat") Double latitude,
                                     @RequestParam(value = "long") Double longitude,
                                     @RequestParam(value = "rad") Double rad,
                                     @RequestBody List<Feature> features) {
        return atmService.filterByFeatures(atmService.findAllAtmAround(latitude, longitude, rad), features);
    }
}
