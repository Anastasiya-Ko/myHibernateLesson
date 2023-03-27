package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    /*указываем, что колонка генерируется автоматически постгресом(при создании бд указан такой же способ генерации id)
    * IDENTITY указывает на то, ЧТО hibernate никак не думает о генерации id, всё происходит на стороне постгреса
    * (самая используемая стратегия)*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String namePerson;

    @Column(name = "age")
    private int age;


    //cascade = CascadeType.PERSIST - при сохранении человека будут автоматически сохраняться его товары
    //@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE) - каскадирует метод save
    //FetchType.LAZY - ленивая загрузка (является загрузкой по умолчанию),
    // т.е при запросе объекта класса Персон, не будут автоматически подгружаться товары, связанные с ним
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> items;

    public Person(String namePerson, int age) {
        this.namePerson = namePerson;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + namePerson + '\'' +
                ", age=" + age +
                '}';
    }
}
