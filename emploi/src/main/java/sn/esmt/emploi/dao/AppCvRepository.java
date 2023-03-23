package sn.esmt.emploi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.esmt.emploi.entities.AppCvEntity;

public interface AppCvRepository extends JpaRepository<AppCvEntity, Integer> {
    AppCvEntity findById(int id);

    AppCvEntity findByEmailAndAdresse(String email, String adresse);
}