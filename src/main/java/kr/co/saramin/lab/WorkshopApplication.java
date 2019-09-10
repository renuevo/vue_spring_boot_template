package kr.co.saramin.lab;

import kr.co.saramin.lab.service.CompanyGraphServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WorkshopApplication implements CommandLineRunner {

    private final CompanyGraphServiceImpl companyGraphServiceImpl;

    @Autowired
    public WorkshopApplication(CompanyGraphServiceImpl companyGraphServiceImpl) {
        this.companyGraphServiceImpl = companyGraphServiceImpl;
    }

    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        companyGraphServiceImpl.companyReviewDataAnalysis();
        System.exit(1);
    }
}
