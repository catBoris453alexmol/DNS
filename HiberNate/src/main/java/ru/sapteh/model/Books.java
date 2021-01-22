package ru.sapteh.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Books {
    @Id
    @GeneratedValue
    private int id;
    @NonNull private String name;
    @NonNull private String autor;
    @NonNull private String publisher;
}