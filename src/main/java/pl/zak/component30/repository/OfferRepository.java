package pl.zak.component30.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zak.component30.entity.Offer;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    Optional<Offer> findByItem(String item);
}
