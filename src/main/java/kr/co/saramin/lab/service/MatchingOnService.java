package kr.co.saramin.lab.service;

import kr.co.saramin.lab.entity.HexacoResultDbEntity;
import kr.co.saramin.lab.entity.PersonalityTestDbEntity;

import java.util.List;

public interface MatchingOnService {
    public void testDoneData(String type, String testType, String name, List<String> resultList);
    public List<PersonalityTestDbEntity> readTestData(String type, String testType);
    public void readInsertTest(String testProp);
    public HexacoResultDbEntity getHexaco(String name);
    public List<HexacoResultDbEntity> getHexacoAll();
}
