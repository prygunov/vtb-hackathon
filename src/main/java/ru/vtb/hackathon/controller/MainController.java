package ru.vtb.hackathon.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vtb.hackathon.model.Office;

import java.util.List;

@RestController
@Tag(name = "Офисы", description = "описание")
@RequestMapping("/api/v1/offices")
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/hi")
    @Operation(description = "Тест")
    public String getHi() {
        return "hi";
    }

    @GetMapping
    @Operation(description = "Банкоматы")
    public List<Office> getOffices() {
        return List.of();
    }

}
