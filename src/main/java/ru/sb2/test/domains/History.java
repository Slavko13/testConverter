package ru.sb2.test.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data
public class History implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String sourceValute;
    private String targetValute;
    private double sourceValuteValue;
    private double targetValuteValue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate localDate;


    @ManyToOne
    @JoinColumn(name = "users_login")
    private Users user;


}
