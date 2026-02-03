package ec.ecu.ups.icc.employees.ModuloCompany.Repository;

import ec.ecu.ups.icc.employees.ModuloCompany.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByIdAndActive(Long id, Character active);
}