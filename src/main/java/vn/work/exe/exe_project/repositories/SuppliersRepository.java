package vn.work.exe.exe_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.work.exe.exe_project.entities.Suppliers;
@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, String> {
}
