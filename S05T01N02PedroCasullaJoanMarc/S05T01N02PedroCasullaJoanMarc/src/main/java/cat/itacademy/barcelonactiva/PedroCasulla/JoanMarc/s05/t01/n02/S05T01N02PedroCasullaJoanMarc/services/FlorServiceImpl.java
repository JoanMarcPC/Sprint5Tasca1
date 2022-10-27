package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.services;


import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.domain.Flor;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.dto.FlorDTO;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.repositories.FlorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorServiceImpl implements FlorService {
    @Autowired
    private FlorRepository sucursalRepository;

    @Override
    public List<FlorDTO> findAll() {
        List<Flor> flors = sucursalRepository.findAll();
        List<FlorDTO> florDTOS = flors.stream().map(this::EntityToDTO).collect(Collectors.toList());
        return florDTOS;
    }


    @Override
    public Optional<FlorDTO> findById(Long Id) {


        Optional<Flor> sucursal = sucursalRepository.findById(Id);
        if (sucursal.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.EntityToDTO(sucursal.get()));
        }
    }

    @Override
    public FlorDTO add(FlorDTO florDTO) {
        return this.EntityToDTO(sucursalRepository.save(this.DTOToEntity(florDTO)));
    }

    @Override
    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public FlorDTO updateById(Long id, Flor flor) {
        try {
            Optional<Flor> florFound = sucursalRepository.findById(id);
            if (florFound.isPresent()) {
                Flor _sucursal = florFound.get();
                _sucursal.setName(flor.getName());
                _sucursal.setCountry(flor.getCountry());
                return this.EntityToDTO(sucursalRepository.save(_sucursal));

            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Flor DTOToEntity(FlorDTO dto) {
        Flor entity = new Flor();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        return entity;
    }

    @Override
    public FlorDTO EntityToDTO(Flor entity) {
        FlorDTO dto = new FlorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountry(entity.getCountry());
        dto.checkType();

        return dto;
    }
}
