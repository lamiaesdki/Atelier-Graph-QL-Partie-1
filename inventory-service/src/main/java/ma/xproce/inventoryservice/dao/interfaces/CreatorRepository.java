package ma.xproce.inventoryservice.dao.interfaces;

import ma.xproce.inventoryservice.dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<Creator, Long> {
}
