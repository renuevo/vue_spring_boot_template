package kr.co.saramin.lab.repository;

import kr.co.saramin.lab.entity.PersonalityTestDbEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalityTestRepository extends JpaRepository<PersonalityTestDbEntity, Integer> {

    public List<PersonalityTestDbEntity> findByTypeAndTestType(String type, String testType, Sort sort);

}
