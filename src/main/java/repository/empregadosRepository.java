package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.empregados;

@Repository
public interface empregadosRepository extends JpaRepository<empregados, Long>{

}
