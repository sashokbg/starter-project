package bg.kirilov.company.web.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface CityRepository extends Repository<City, Long> {
    List<City> findAll();
    List<City> findByName(String name);
}
