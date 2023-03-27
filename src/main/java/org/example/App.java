package org.example;

import org.example.model.Item;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;

public class App 
{
    public static void main( String[] args )
    {
        //Подключаем конфигурацию hibernate + передаём класс, который является нашей сущностью
        //hibernate теперь понимает, что в бд есть база с таким же названием, как переданный в параметры класс
        //Класс Configuration по умолчанию читает конфигурацию из файла hibernate.properties
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);

        //Создаём sessionFactory, чтобы из него уже получить сессию для работы с hibernate
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //Получаем сессию
        Session session = sessionFactory.getCurrentSession();

//        try {
//            //Начинаем транзакцию
//            session.beginTransaction();
//
//            //Ищем в нашей сущности человека с id=1 и hibernate автоматически преобразует его в объекта класса Персон
//            Person person = session.get(Person.class, 1);
//
//            System.out.println(person.getName());
//            System.out.println(person.getAge());
//
//            //Закрываем транзакцию
//            session.getTransaction().commit();
//            //Закрытие sessionFactory должно быть выполнено в любом случае,
//            //даже при выбрасывании ошибки в сессии(поэтому оборачиваем в try/finally-блок)
//        } finally {
//            //Закрываем sessionFactory
//            sessionFactory.close();
//        }


//        try {
//            //Начинаем транзакцию
//            session.beginTransaction();
//
//            //Создаём объект класса Персон, с помощью hibernate
//            Person personFirst = new Person("Яся", 8);
//            Person personSecond = new Person("Нева", 15);
//            Person personThird = new Person("Иванка", 25);
//            Person personFourth = new Person("Ирия", 35);
//
//            session.save(personFirst);
//            session.save(personSecond);
//            session.save(personThird);
//            session.save(personFourth);
//
//            System.out.println(personFirst.getName() + " - age: " + personFirst.getAge() + ", id: " + personFirst.getId());
//            System.out.println(personSecond.getName() + " - age: " + personSecond.getAge() + ", id: " + personSecond.getId());
//            System.out.println(personThird.getName() + " - age: " + personThird.getAge() + ", id: " + personThird.getId());
//            System.out.println(personFourth.getName() + " - age: " + personFourth.getAge() + ", id: " + personFourth.getId());
//
//            //Закрываем транзакцию
//            session.getTransaction().commit();
//            //Закрытие sessionFactory должно быть выполнено в любом случае,
//            //даже при выбрасывании ошибки в сессии(поэтому оборачиваем в try/finally-блок)
//        } finally {
//            //Закрываем sessionFactory
//            sessionFactory.close();
//        }


//        try {
//            //Начинаем транзакцию
//            session.beginTransaction();
//
//            //Обновляем объект класса Персон с id=2
//
//            //Сперва получаем объект класса Персон с id=2 и кладём его в переменную
//            Person person = session.get(Person.class, 2);
//            //Назначаем этому объекту новый возраст
//            person.setAge(16);
//
//            //Закрываем транзакцию
//            session.getTransaction().commit();
//            //Закрытие sessionFactory должно быть выполнено в любом случае,
//            //даже при выбрасывании ошибки в сессии(поэтому оборачиваем в try/finally-блок)
//        } finally {
//            //Закрываем sessionFactory
//            sessionFactory.close();
//        }

//        try {
//            //Начинаем транзакцию
//            session.beginTransaction();
//
//            //Удаляем объект класса Персон с id=2
//
//            //Сперва получаем объект класса Персон с id=2 и кладём его в переменную
//            Person person = session.get(Person.class, 2);
//            //Удаляем
//            session.delete(person);
//
//            //Закрываем транзакцию
//            session.getTransaction().commit();
//            //Закрытие sessionFactory должно быть выполнено в любом случае,
//            //даже при выбрасывании ошибки в сессии(поэтому оборачиваем в try/finally-блок)
//        } finally {
//            //Закрываем sessionFactory
//            sessionFactory.close();
//        }


//        try {
//            session.beginTransaction();
//
//            //HQL-запрос
//            session.createQuery("update Person set name='test' where age > 0").executeUpdate();
//
//           session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        //Получаем товары выбранного человека
//        try {
//            session.beginTransaction();
//
//            Person person = session.get(Person.class, 4);
//            System.out.println(person);
//
//            List<Item> items = person.getItems();
//
//            System.out.println(items.toString());
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

//        //Получаем человека, который выбрал конкретный товар
//        try {
//            session.beginTransaction();
//
//            Item item = session.get(Item.class, 1);
//            System.out.println(item);
//
//            Person person = item.getOwner();
//            System.out.println(person);
//
//
//            session.getTransaction().commit();
//        } finally {
//            sessionFactory.close();
//        }

        //
        try {
            session.beginTransaction();

           Person person = new Person("Любава", 54);

           Item item = new Item("Воблер", person.getId());

           person.setItems(new ArrayList<>(Collections.singleton(item)));

           session.save(person);


           session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }


    }
}
