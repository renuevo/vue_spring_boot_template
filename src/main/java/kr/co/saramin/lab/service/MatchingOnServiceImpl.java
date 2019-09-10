package kr.co.saramin.lab.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import kr.co.saramin.lab.dao.MatchingOnDao;
import kr.co.saramin.lab.entity.HexacoResultDbEntity;
import kr.co.saramin.lab.entity.PersonalityTestDbEntity;
import kr.co.saramin.lab.entity.TestDoneDbEntity;
import kr.co.saramin.lab.repository.HexacoResultRepository;
import kr.co.saramin.lab.repository.PersonalityTestRepository;
import kr.co.saramin.lab.repository.TestDoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MatchingOnServiceImpl implements MatchingOnService {

    final private PersonalityTestRepository personalityTestRepository;
    final private HexacoResultRepository hexacoResultRepository;
    final private TestDoneRepository testDoneRepository;
    final private MatchingOnDao matchingOnDao;
    final private Environment env;

    @Autowired
    public MatchingOnServiceImpl(PersonalityTestRepository personalityTestRepository, HexacoResultRepository hexacoResultRepository, TestDoneRepository testDoneRepository, MatchingOnDao matchingOnDao, Environment env) {
        this.personalityTestRepository = personalityTestRepository;
        this.hexacoResultRepository = hexacoResultRepository;
        this.testDoneRepository = testDoneRepository;
        this.matchingOnDao = matchingOnDao;
        this.env = env;
    }

    @Override
    public List<PersonalityTestDbEntity> readTestData(String type, String testType) {
        return personalityTestRepository.findByTypeAndTestType(type, testType, new Sort(Sort.Direction.ASC, "num"));
    }

    @Override
    @Transactional
    public void testDoneData(String type, String testType, String name, List<String> resultList) {
        List<PersonalityTestDbEntity> presonPersonalityTestDbEntityList = personalityTestRepository.findByTypeAndTestType(type, testType, new Sort(Sort.Direction.ASC, "num"));
        TestDoneDbEntity testDoneDbEntity = new TestDoneDbEntity();
        testDoneDbEntity.setName(name);
        testDoneDbEntity.setType(type);
        testDoneDbEntity.setTestType(testType);
        testDoneDbEntity = testDoneRepository.save(testDoneDbEntity);

        HexacoResultDbEntity hexacoResultDbEntity = new HexacoResultDbEntity();
        hexacoResultDbEntity.setUserKey(testDoneDbEntity.getKey());

        Map<String, Integer> resultMap = Maps.newConcurrentMap();
        Map<String, Integer> countMap = Maps.newConcurrentMap();

        int score = 0;
        PersonalityTestDbEntity personalityTestDbEntity;
        for (int i = 1; i < resultList.size(); i++) {
            personalityTestDbEntity = presonPersonalityTestDbEntityList.get(i - 1);
            if (personalityTestDbEntity.getrType().equals("Y")) {
                switch (Integer.parseInt(resultList.get(i))) {
                    case 1:
                        score = 5;
                        break;
                    case 2:
                        score = 4;
                        break;
                    case 3:
                        score = 3;
                        break;
                    case 4:
                        score = 2;
                        break;
                    case 5:
                        score = 1;
                        break;
                }
            } else {
                score = Integer.parseInt(resultList.get(i));
            }

            if (resultMap.containsKey(personalityTestDbEntity.getResultType2())) {
                resultMap.put(personalityTestDbEntity.getResultType2(), resultMap.get(personalityTestDbEntity.getResultType2()) + score);
                countMap.put(personalityTestDbEntity.getResultType2(), countMap.get(personalityTestDbEntity.getResultType2()) + 1);
            } else {
                resultMap.put(personalityTestDbEntity.getResultType2(), score);
                countMap.put(personalityTestDbEntity.getResultType2(), 1);
            }
        }

        resultMap.replaceAll((k, v) -> resultMap.get(k) / countMap.get(k));

        hexacoResultDbEntity.setSincerity(resultMap.get("Sincerity"));
        hexacoResultDbEntity.setFairness(resultMap.get("Fairness"));
        hexacoResultDbEntity.setGreedAvoidance(resultMap.get("Greed-Avoidance"));
        hexacoResultDbEntity.setModesty(resultMap.get("Modesty"));
        hexacoResultDbEntity.setFearfulness(resultMap.get("Fearfulness"));
        hexacoResultDbEntity.setAnxiety(resultMap.get("Anxiety"));
        hexacoResultDbEntity.setDependence(resultMap.get("Dependence"));
        hexacoResultDbEntity.setSentimentality(resultMap.get("Sentimentality"));
        hexacoResultDbEntity.setSocialSelfEsteem(resultMap.get("Social Self_Esteem"));
        hexacoResultDbEntity.setSocialBoldness(resultMap.get("Social Boldness"));
        hexacoResultDbEntity.setSociability(resultMap.get("Sociability"));
        hexacoResultDbEntity.setLiveliness(resultMap.get("Liveliness"));
        hexacoResultDbEntity.setForgiveness(resultMap.get("Forgiveness"));
        hexacoResultDbEntity.setGentleness(resultMap.get("Gentleness"));
        hexacoResultDbEntity.setFlexibility(resultMap.get("Flexibility"));
        hexacoResultDbEntity.setPatience(resultMap.get("Patience"));
        hexacoResultDbEntity.setOrganization(resultMap.get("Organization"));
        hexacoResultDbEntity.setDiligence(resultMap.get("Diligence"));
        hexacoResultDbEntity.setPerfectionism(resultMap.get("Perfectionism"));
        hexacoResultDbEntity.setPrudence(resultMap.get("Prudence"));
        hexacoResultDbEntity.setAestheticAppreciation(resultMap.get("Aesthetic Appreciation"));
        hexacoResultDbEntity.setInquisitiveness(resultMap.get("Inquisitiveness"));
        hexacoResultDbEntity.setCreativity(resultMap.get("Creativity"));
        hexacoResultDbEntity.setUnconventionality(resultMap.get("Unconventionality"));
        hexacoResultDbEntity.setAltruism(resultMap.get("Altruism"));

        score = hexacoResultDbEntity.getSincerity();
        score += hexacoResultDbEntity.getFairness();
        score += hexacoResultDbEntity.getGreedAvoidance();
        score += hexacoResultDbEntity.getModesty();
        hexacoResultDbEntity.setHonestyHumility(score / 4);

        score = hexacoResultDbEntity.getFearfulness();
        score += hexacoResultDbEntity.getAnxiety();
        score += hexacoResultDbEntity.getDependence();
        score += hexacoResultDbEntity.getSentimentality();
        hexacoResultDbEntity.setEmotionality(score / 4);

        score = hexacoResultDbEntity.getSocialSelfEsteem();
        score += hexacoResultDbEntity.getSocialBoldness();
        score += hexacoResultDbEntity.getSociability();
        score += hexacoResultDbEntity.getLiveliness();
        hexacoResultDbEntity.setExtraversion(score / 4);

        score = hexacoResultDbEntity.getForgiveness();
        score += hexacoResultDbEntity.getGentleness();
        score += hexacoResultDbEntity.getFlexibility();
        score += hexacoResultDbEntity.getPatience();
        hexacoResultDbEntity.setAgreeableness(score / 4);

        score = hexacoResultDbEntity.getOrganization();
        score += hexacoResultDbEntity.getDiligence();
        score += hexacoResultDbEntity.getPerfectionism();
        score += hexacoResultDbEntity.getPrudence();
        hexacoResultDbEntity.setConscientiousness(score / 4);

        score = hexacoResultDbEntity.getAestheticAppreciation();
        score += hexacoResultDbEntity.getInquisitiveness();
        score += hexacoResultDbEntity.getCreativity();
        score += hexacoResultDbEntity.getUnconventionality();
        hexacoResultDbEntity.setOpennessToExperience(score / 4);
        hexacoResultDbEntity.setName(name);
        hexacoResultRepository.save(hexacoResultDbEntity);

    }

    @Override
    @Transactional
    public void readInsertTest(String testProp) {

        PersonalityTestDbEntity personalityTestDbEntity;
        List<PersonalityTestDbEntity> personalityTestDbEntityList = Lists.newArrayList();
        List<String[]> csvList = matchingOnDao.readCsv(env.getProperty("FILE.PATH.ROOT") + env.getProperty("FILE.PATH.TEST" + testProp));

        for (String[] strings : csvList) {
            personalityTestDbEntity = new PersonalityTestDbEntity();
            personalityTestDbEntity.setNum(Integer.parseInt(strings[0]));
            personalityTestDbEntity.setType(strings[1]);
            personalityTestDbEntity.setTestType(strings[2]);
            personalityTestDbEntity.setProblem(strings[3]);
            personalityTestDbEntity.setrType(strings[4]);
            personalityTestDbEntity.setResultType1(strings[5]);
            personalityTestDbEntity.setResultType2(strings[6]);
            personalityTestDbEntityList.add(personalityTestDbEntity);
        }
        personalityTestRepository.saveAll(personalityTestDbEntityList);
    }


    @Override
    public List<HexacoResultDbEntity> getHexacoAll(){
        return hexacoResultRepository.findAll();
    }

    @Override
    public HexacoResultDbEntity getHexaco(String name) {
        return hexacoResultRepository.findByName(name);
    }
}
