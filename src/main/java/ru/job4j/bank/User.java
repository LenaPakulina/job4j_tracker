package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит описание пользователя банка.
 * Эта модель содержит поля: номер паспорта и ФИО.
 * @author ELENA PAKULINA
 * @version 1.0
 */

public class User {
    private String passport;
    private String username;

    /**
     * Создает экземпляр пользователя с указанными параметрами
     * @param passport паспорт пользователя
     * @param username ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить данные паспорта пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод устанавливает данные паспорта пользователя с
     * сохранением ФИО
     * @param passport паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО пользователя
     * @return возвращает ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод устанавливает данные ФИО пользователя с
     * сохранением данных паспорта
     * @param username ФИО пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает объекты по данным паспорта
     * @param o Объект сравнения
     * @return Возвращает true, если указанный объект равен текущему
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод возвращает значение хэш-кода
     * @return Возвращает значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}