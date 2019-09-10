package kr.co.saramin.lab.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "personality_test_db", schema = "workshop")
public class PersonalityTestDbEntity {

    private int key;
    private int num;

    @Enumerated(EnumType.STRING)
    @Column( name="type", nullable=false, columnDefinition = "enum('self','observer')")
    private String type;

    private String testType;
    private String problem;

    @Enumerated(EnumType.STRING)
    @Column( name="R_type", nullable=false, columnDefinition = "enum('Y','N')")
    private String rType;

    private String resultType1;
    private String resultType2;

    @Id
    @GeneratedValue(
            strategy= GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "key")
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Basic
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "test_type")
    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    @Basic
    @Column(name = "problem")
    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Basic
    @Column(name = "R_type")
    public String getrType() {
        return rType;
    }

    public void setrType(String rType) {
        this.rType = rType;
    }

    @Basic
    @Column(name = "result_type_1")
    public String getResultType1() {
        return resultType1;
    }

    @Basic
    @Column(name = "result_type_2")
    public String getResultType2() {
        return resultType2;
    }

    public void setResultType2(String resultType2) {
        this.resultType2 = resultType2;
    }

    public void setResultType1(String resultType1) {
        this.resultType1 = resultType1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalityTestDbEntity that = (PersonalityTestDbEntity) o;
        return key == that.key &&
                num == that.num &&
                Objects.equals(type, that.type) &&
                Objects.equals(testType, that.testType) &&
                Objects.equals(problem, that.problem) &&
                Objects.equals(rType, that.rType) &&
                Objects.equals(resultType1, that.resultType1) &&
                Objects.equals(resultType2, that.resultType2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, num, type, testType, problem, rType, resultType1, resultType2);
    }
}
