package com.techChallenge.techgig.beans;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="q5991")
public class Question implements IdentifierGenerator, IGenericVo {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
private int id;

    private String qName;

    @ManyToMany(targetEntity = Answer.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "q_ans1123",
            joinColumns = { @JoinColumn(name = "q_id") },
            inverseJoinColumns = { @JoinColumn(name = "ans_id") })
    private List<Answer> answers;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getqName() {
        return qName;
    }

    public void setqName(String qName) {
        this.qName = qName;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return null;
    }

    @Override
    public boolean supportsJdbcBatchInserts() {
        return false;
    }
}
