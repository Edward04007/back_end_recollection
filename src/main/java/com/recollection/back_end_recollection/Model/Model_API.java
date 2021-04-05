package com.recollection.back_end_recollection.Model;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name = "TB_questions_recollection")
public class Model_API implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String photo;
    
    @Column(nullable = false)
    private String question;

    @Column(nullable = false)
    private String alternative_01;

    @Column(nullable = false)
    private String alternative_02;

    @Column(nullable = false)
    private String alternative_03;

    @Column(nullable = false)
    private String alternative_04;

    @Column(nullable = false)
    private String feedback;

}
