package vn.work.exe.exe_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.work.exe.exe_project.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, String> {
}
