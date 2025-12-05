package org.example.catsgram.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;


//@RequiredArgsConstructor для private переменной
//@EqualsAndHashCode
//@ToString
//@ToString(onlyExplicitlyIncluded = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)//делает всё приватным

//@Data//геттер и сеттер конструктор ту стринг и хеш код
@Getter
@Setter
@AllArgsConstructor // для всех полей
public class Post {
    private  int id;
    //    @ToString.Exclude//автор не попадет
    private  String author; // автор
    private LocalDate date ; // дата создания
    //    @ToString.Include//только описание попадет остальные нет
    private  String description; // описание
    private  String photoUrl; // url-адрес фотографии

}

//@NoArgsConstructor без параметров


