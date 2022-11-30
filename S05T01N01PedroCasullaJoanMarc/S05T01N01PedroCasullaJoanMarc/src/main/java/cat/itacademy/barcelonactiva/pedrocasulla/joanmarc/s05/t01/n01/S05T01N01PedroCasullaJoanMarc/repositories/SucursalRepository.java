package cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.repositories;



import cat.itacademy.barcelonactiva.pedrocasulla.joanmarc.s05.t01.n01.S05T01N01PedroCasullaJoanMarc.domain.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Long> {

}
