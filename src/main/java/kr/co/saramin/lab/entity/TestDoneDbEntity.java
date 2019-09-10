package kr.co.saramin.lab.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "test_done_db", schema = "workshop")
public class TestDoneDbEntity {
    private int key;
    private String name;

    @Enumerated(EnumType.STRING)
    @Column( name="type", nullable=false, columnDefinition = "enum('self','observer')")
    private String type;
    private String testType;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestDoneDbEntity that = (TestDoneDbEntity) o;
        return key == that.key &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(testType, that.testType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, name, type, testType);
    }
}
