package ru.test.t1.controller;

import org.springframework.web.bind.annotation.*;
import ru.test.t1.service.ServiceT1;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/count")
public class ControllerT1 {
    private final ServiceT1 service;

    public ControllerT1(ServiceT1 service) {
        this.service = service;
    }

    @GetMapping()
    public List<Map.Entry<Character, Integer>> countCharacter(@RequestBody String string) {
        return service.countCharacter(string);
    }
}
