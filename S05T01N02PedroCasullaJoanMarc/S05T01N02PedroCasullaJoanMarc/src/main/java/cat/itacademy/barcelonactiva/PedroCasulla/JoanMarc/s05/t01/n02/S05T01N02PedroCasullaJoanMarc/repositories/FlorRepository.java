package cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.repositories;



import cat.itacademy.barcelonactiva.PedroCasulla.JoanMarc.s05.t01.n02.S05T01N02PedroCasullaJoanMarc.domain.Flor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorRepository extends JpaRepository<Flor,Long> {

}
