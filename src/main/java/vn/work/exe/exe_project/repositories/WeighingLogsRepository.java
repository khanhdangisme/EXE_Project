package vn.work.exe.exe_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.work.exe.exe_project.entities.WeighingLogs;

public interface WeighingLogsRepository extends JpaRepository<WeighingLogs, Long> {
}
