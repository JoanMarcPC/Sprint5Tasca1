package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.services;

import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.domain.Sucursal;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.repositories.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class SucursalServiceImpl implements SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    @Override
    public List<SucursalDTO> findAll() {
        List<Sucursal> sucursals = sucursalRepository.findAll();
        List<SucursalDTO> sucursalDTOS = sucursals.stream().map(this::EntityToDTO).collect(Collectors.toList());
        return sucursalDTOS;
    }


    @Override
    public Optional<SucursalDTO> findById(Long Id) {


        Optional<Sucursal> sucursal = sucursalRepository.findById(Id);
        if (sucursal.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(this.EntityToDTO(sucursal.get()));
        }
    }

    @Override
    public SucursalDTO add(SucursalDTO sucursalDTO) {
        return this.EntityToDTO(sucursalRepository.save(this.DTOToEntity(sucursalDTO)));
    }

    @Override
    public void deleteById(Long id) {
        sucursalRepository.deleteById(id);
    }

    @Override
    public SucursalDTO updateById(Long id, Sucursal sucursal) {
        try {
            Optional<Sucursal> sucursalFound = sucursalRepository.findById(id);
            if (sucursalFound.isPresent()) {
                Sucursal _sucursal = sucursalFound.get();
                _sucursal.setName(sucursal.getName());
                _sucursal.setCountry(sucursal.getCountry());
                return this.EntityToDTO(sucursalRepository.save(_sucursal));

            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Sucursal DTOToEntity(SucursalDTO dto) {
        Sucursal entity = new Sucursal();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(dto.getCountry());
        return entity;
    }

    @Override
    public SucursalDTO EntityToDTO(Sucursal entity) {
        SucursalDTO dto = new SucursalDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCountry(entity.getCountry());
        dto.checkType();

        return dto;
    }
}
