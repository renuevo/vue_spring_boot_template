package kr.co.saramin.lab.repository;

import kr.co.saramin.lab.entity.HexacoResultDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HexacoResultRepository extends JpaRepository<HexacoResultDbEntity, Integer> {
    public HexacoResultDbEntity findByName(String name);
}
