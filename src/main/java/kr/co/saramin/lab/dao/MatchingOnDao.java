package kr.co.saramin.lab.dao;


import kr.co.saramin.lab.common.CsvUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MatchingOnDao {

    final private CsvUtils csvUtils;

    @Autowired
    public MatchingOnDao(CsvUtils csvUtils){
        this.csvUtils = csvUtils;
    }


    @SneakyThrows
    public List<String[]> readCsv(String path){
        List<String[]> csvList = csvUtils.readCsv(path,"UTF-8",1);
        return csvList;
    }

}
