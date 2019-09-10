package kr.co.saramin.lab.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import kr.co.saramin.lab.common.CsvUtils;
import kr.co.saramin.lab.common.VoMapperUtils;
import kr.co.saramin.lab.dto.CompanyReviceTop;
import kr.co.saramin.lab.dto.CompanyReviewDto;
import lombok.extern.slf4j.Slf4j;
import org.openkoreantext.processor.KoreanPosJava;
import org.openkoreantext.processor.KoreanTokenJava;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import scala.collection.Seq;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CompanyGraphServiceImpl {

    private final CsvUtils csvUtils;
    private final Environment env;
    private final VoMapperUtils voMapperUtils;

    @Autowired
    public CompanyGraphServiceImpl(CsvUtils csvUtils, Environment env, VoMapperUtils voMapperUtils) {
        this.csvUtils = csvUtils;
        this.voMapperUtils = voMapperUtils;
        this.env = env;
    }


    public void companyReviewDataAnalysis() {
        Map<String, CompanyReviceTop> companyReviceTopMap = Maps.newConcurrentMap();
        List<CompanyReviewDto> companyReviewDtoList = csvUtils.readModelCsv(env.getProperty("FILE.PATH.ROOT") + env.getProperty("FILE.PATH.COMPANY_REVIEW"), "UTF-8", CompanyReviewDto.class, voMapperUtils.getMethods(CompanyReviewDto.class, "set"));
        CharSequence normalized;
        CompanyReviceTop companyReviceTop;
        Seq<KoreanTokenizer.KoreanToken> tokens;
        if (companyReviewDtoList.size() > 0) {
            for (CompanyReviewDto companyReviewDto : companyReviewDtoList) {
                normalized = OpenKoreanTextProcessorJava.normalize(companyReviewDto.getAnwr());
                tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
                for (KoreanTokenJava koreanTokenJava : OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens)) {
                    if (koreanTokenJava.getPos().equals(KoreanPosJava.Noun) || koreanTokenJava.getPos().equals(KoreanPosJava.Alpha)) {
                        companyReviceTop = companyReviceTopMap.getOrDefault(koreanTokenJava.getText(), new CompanyReviceTop());
                        companyReviceTop.addCount();
                        companyReviceTop.setWord(koreanTokenJava.getText());
                        companyReviceTopMap.put(koreanTokenJava.getText(), companyReviceTop);
                    }
                }
            }
        }
        csvUtils.writeCsv(Lists.newArrayList(companyReviceTopMap.values()), env.getProperty("FILE.PATH.ROOT") + env.getProperty("FILE.PATH.COMPANY_REVIEW") + "_top", "UTF-8", CompanyReviceTop.class);

    }


}
