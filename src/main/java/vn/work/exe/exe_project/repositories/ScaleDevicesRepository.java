package vn.work.exe.exe_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.work.exe.exe_project.entities.ScaleDevices;
@Repository
public interface ScaleDevicesRepository extends JpaRepository<ScaleDevices, String> {
}
