package org.example.catsgram.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Getter
@Setter
//@NoArgsConstructor без параметров
@AllArgsConstructor // для всех полей
//@RequiredArgsConstructor для private переменной
@EqualsAndHashCode
//@ToString
@ToString(onlyExplicitlyIncluded = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)//делает всё приватным

@Data//геттер и сеттер конструктор ту стринг и хеш код


public class Post {
    @ToString.Exclude//автор не попадет
    final String author; // автор
    final Instant creationDate = Instant.now(); // дата создания
    @ToString.Include//только описание попадет остальные нет
    String description; // описание
    String photoUrl; // url-адрес фотографии

}
