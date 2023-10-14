package ru.vtb.hackathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.hackathon.dto.atm.AtmDto;
import ru.vtb.hackathon.dto.feature.Feature;
import ru.vtb.hackathon.service.atm.AtmService;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Банкоматы", description = "описание")
@RequestMapping("/api/v1/atms")
@RequiredArgsConstructor
public class AtmController {

    private final AtmService atmService;

    @GetMapping
    @Operation(description = "Получить банкоматы по гео, дистанцию и время", summary = "По удалению от заданной точки")
    public List<AtmDto> getAtmAround(@RequestParam(value = "lat") Double latitude,
                                     @RequestParam(value = "long") Double longitude,
                                     @RequestParam(value = "rad") Double rad,
                                     @RequestParam(value = "features", required = false) Map<Feature, Boolean> features) {
        List<AtmDto> allAtmAround = atmService.findAllAtmAround(latitude, longitude, rad);
        if (features != null) {
            allAtmAround = atmService.filterByFeatures(allAtmAround, features);
        }
        return allAtmAround;
    }
}
