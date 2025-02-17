package my.code.c1.service;

import my.code.c1.dto.PositionDTO;
import my.code.c1.exception.ResourceNotFoundException;
import my.code.c1.mapper.PositionMapper;
import my.code.c1.model.Position;
import my.code.c1.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private PositionMapper positionMapper;

    public List<Position> getAll() {
        var positions = positionRepository.findAll();
        return positions.stream()
                .toList();
    }

    public PositionDTO findById(Long id) {
        var position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position with id = " + id + " not found"));
        return positionMapper.map(position);
    }

    public PositionDTO create(PositionDTO data) {
        var position = positionMapper.map(data);
        positionRepository.save(position);
        return positionMapper.map(position);
    }

    public PositionDTO update(PositionDTO data, Long id) {
        var position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found"));
        positionMapper.update(data, position);
        positionRepository.save(position);
        return positionMapper.map(position);
    }

    public void deleteById(Long id) {
        var position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position not found"));
        positionRepository.delete(position);
    }
}
