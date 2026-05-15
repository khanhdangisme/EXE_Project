package vn.work.exe.exe_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.work.exe.exe_project.entities.Localization;

@Repository
public interface LocalizationRepository extends JpaRepository<Localization, String> {
}
