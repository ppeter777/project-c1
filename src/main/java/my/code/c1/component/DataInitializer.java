package my.code.c1.component;

import lombok.AllArgsConstructor;
import my.code.c1.dto.PositionDTO;
import my.code.c1.mapper.PositionMapper;
import my.code.c1.model.Position;
import my.code.c1.repository.PositionRepository;
//import my.code.c1.service.PositionService;
import my.code.c1.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataInitializer implements ApplicationRunner {

    private final PositionRepository positionRepository;

    @Autowired
    private final PositionService positionService;

    @Autowired
    private final PositionMapper positionMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        if (positionRepository.getPositionByFen(fen).isEmpty()) {
            var position = new PositionDTO();
            position.setFen(fen);
            positionService.create(position);
        }
    }
}
