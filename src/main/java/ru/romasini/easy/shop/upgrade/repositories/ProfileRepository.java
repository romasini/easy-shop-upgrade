package ru.romasini.easy.shop.upgrade.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.romasini.easy.shop.upgrade.entities.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
