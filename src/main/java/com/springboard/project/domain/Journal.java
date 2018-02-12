package com.springboard.project.domain;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Getter @Setter @ToString @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "SPRING_JOURNAL")
@SequenceGenerator(
        name = "journal_seq_generator",
        initialValue = 1,
        allocationSize = 1,
        sequenceName = "journal_id_seq")
public class Journal {

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "journal_seq_generator")
    @Column(name="journal_id")
    private Long id;

    @Column(length = 200)
    private String title;

    @Lob
    private String content;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Builder.Default
    private LocalDate postDate = LocalDate.now();

    @Builder.Default
    private int hit = 0;

}
