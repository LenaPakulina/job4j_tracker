package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит описание банковского инструмента.
 * @author ELENA PAKULINA
 * @version 1.0
 */

public class BankService {
    /**
     * Поле users содержит всех пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод должен добавить пользователя в систему.
     * По умолчанию к этому user добавляется пустой список
     * В методе есть быть проверка, что такого пользователя еще нет в системе.
     * Если он есть, то добавление пользователя не произойдет.
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод должен удалить пользователя в системе, если он присутствует в ней.
     * @param passport паспортные данные пользователя для удаления из системы
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод должен добавить новый счет к пользователю, найденному по паспортным данным
     * @param passport паспортные данные пользователя
     * @param account банковский счет для добавления к пользьвателю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта. Если ничего не найденно, возвращает null
     * @param passport паспортные данные пользователя
     * @return найденного пользователя в системе с переданными паспортными данными
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам. Если ничего не найдено, возвращает null
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты пользователя
     * @return найденного пользователя в системе
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param sourcePassport паспорт пользователя со счетом, с которого переводят
     * @param sourceRequisite реквизиты счета, с которого переводят
     * @param destinationPassport паспорт пользователя со счетом, куда переводят
     * @param destinationRequisite реквизиты счета, куда переводят
     * @param amount сумма перевода с одного счета на другой
     * @return если счёт не найден или не хватает денег на счёте sourcePassport, то метод вернет false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sAccount != null) {
            Account dAccount = findByRequisite(destinationPassport, destinationRequisite);
            if (dAccount != null && sAccount.getBalance() >= amount) {
                sAccount.setBalance(sAccount.getBalance() - amount);
                dAccount.setBalance(dAccount.getBalance() + amount);
                return true;
            }
        }
        return false;
    }

    /**
     * Метод возвращает данные банковских счетов по пользователю
     * @param user пользователь системы
     * @return список банковских счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
