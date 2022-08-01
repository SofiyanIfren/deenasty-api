package deenasty.data.api.dao;

import deenasty.data.api.model.Deenasty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeenastyRepository extends JpaRepository<Deenasty, Long> {
}
