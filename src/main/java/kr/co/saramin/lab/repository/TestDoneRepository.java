package kr.co.saramin.lab.repository;

import kr.co.saramin.lab.entity.TestDoneDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDoneRepository extends JpaRepository<TestDoneDbEntity, Integer> {
}
