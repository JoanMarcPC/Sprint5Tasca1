package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.services;


import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.domain.Flor;
import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.dto.FlorDTO;

import java.util.List;
import java.util.Optional;

public interface FlorService {
    List<FlorDTO> findAll();

    Optional<FlorDTO> findById(Long Id);

    FlorDTO add(FlorDTO sucursalDTO);

    void deleteById(Long id);

    FlorDTO updateById(Long id,Flor sucursal);

    Flor DTOToEntity(FlorDTO dto);

    FlorDTO EntityToDTO(Flor entity);
}
