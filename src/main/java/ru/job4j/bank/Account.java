package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит описание банковского счета.
 * Эта модель содержит поля: баланс и реквизиты.
 * @author ELENA PAKULINA
 * @version 1.0
 */

public class Account {
    private String requisite;
    private double balance;

    /**
     * Создает экземпляр класса с указанными параметрами
     * @param requisite реквизиты счета
     * @param balance баланс по реквизиту счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return возвращает реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет присвоить новые реквизиты счета с
     * сохранением текущего баланса
     * @param requisite реквизиты счета для транзакций
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить текущий баланс
     * @return возвращает текущий баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет присвоить обновленный баланс с
     * сохранением текущих реквизитов счета
     * @param balance новый баланс пользователя
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Сравнивает объекты по реквизитам счета
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает значение хэш-кода
     * @return Возвращает значение хэш-кода
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
