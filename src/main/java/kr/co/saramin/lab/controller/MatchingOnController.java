package kr.co.saramin.lab.controller;

import com.google.common.collect.Maps;
import kr.co.saramin.lab.entity.HexacoResultDbEntity;
import kr.co.saramin.lab.entity.PersonalityTestDbEntity;
import kr.co.saramin.lab.service.MatchingOnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MatchingOnController {

    final private MatchingOnService matchingOnService;

    @Autowired
    public MatchingOnController(MatchingOnService matchingOnService) {
        this.matchingOnService = matchingOnService;
    }


    @GetMapping("/insert_test_data")
    public void insertTestData(@RequestParam String testProp) {
        matchingOnService.readInsertTest(testProp);
    }

    @GetMapping("/load_test_data")
    public List<PersonalityTestDbEntity> loadTestData(@RequestParam String type, @RequestParam String testType) {
        return matchingOnService.readTestData(type, testType);
    }

    @GetMapping("/upload_test_data")
    public Map<String, Object> uploadData(@RequestParam String type, @RequestParam String testType, @RequestParam String name, @RequestParam List<String> radio_list) {
        Map<String, Object> resultMap = Maps.newConcurrentMap();
        matchingOnService.testDoneData(type, testType, name, radio_list);
        resultMap.put("data", matchingOnService.getHexaco(name));
        resultMap.put("msg", "감사합니다");
        return resultMap;
    }

    @GetMapping("/load_test_done_data")
    public List<HexacoResultDbEntity> loadTestDoneAll(){
        return matchingOnService.getHexacoAll();
    }

    @GetMapping("/get_hexaco")
    public HexacoResultDbEntity uploadData(@RequestParam String name) {
        return matchingOnService.getHexaco(name);
    }
}
