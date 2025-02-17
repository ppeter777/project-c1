package my.code.c1.controller.api;

import jakarta.validation.Valid;
import my.code.c1.dto.PositionDTO;
import my.code.c1.mapper.PositionMapper;
import my.code.c1.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PositionController {
    @Autowired
    private PositionService positionService;


    @Autowired
    private PositionMapper positionMapper;

    @GetMapping("/positions")
    ResponseEntity<List<PositionDTO>> index() {
        var labels = positionService.getAll();
        var result = labels.stream()
                .map(positionMapper::map)
                .toList();
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(labels.size()))
                .body(result);
    }

    @GetMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PositionDTO show(@PathVariable Long id) {
        return positionService.findById(id);
    }

    @PostMapping("/positions")
    @ResponseStatus(HttpStatus.CREATED)
    PositionDTO create(@Valid @RequestBody PositionDTO positionData) {
        return positionService.create(positionData);
    }

    @PutMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.OK)
    PositionDTO update(@Valid @RequestBody PositionDTO data, @PathVariable Long id) {
        return positionService.update(data, id);
    }

    @DeleteMapping("/positions/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void destroy(@PathVariable Long id) {
        positionService.deleteById(id);
    }
}

