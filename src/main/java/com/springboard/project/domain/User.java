package com.springboard.project.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "SPRING_USER")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator",
    initialValue = 1,allocationSize = 1,sequenceName = "user_id_seq")
    @Column(name="user_id")
    private Long id;
    private String email;
    private String password;
    private String username;
    private LocalDate registerDate;
    private LocalDate updateDate;

}
