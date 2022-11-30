package cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.services;


import cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.domain.Sucursal;
import cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.dto.SucursalDTO;

import java.util.List;
import java.util.Optional;

public interface SucursalService {
    List<SucursalDTO> findAll();

    Optional<SucursalDTO> findById(Long Id);

    SucursalDTO add(SucursalDTO sucursalDTO);

    void deleteById(Long id);

    SucursalDTO updateById(Long id,Sucursal sucursal);

    Sucursal DTOToEntity(SucursalDTO dto);

    SucursalDTO EntityToDTO(Sucursal entity);
}
