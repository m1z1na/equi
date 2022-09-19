package com.example.equi.service;

import com.example.equi.model.Client;

import java.util.List;

public interface ClientService {
    /**
     * Создает новое обоорудование
     * @param equi - обоорудования для создания
     * @return
     */
    String create(Client equi);

    /**
     * Возвращает список всех имеющихся обоорудований
     * @return список обоорудования
     */
   // List<client> readAll();

    /**
     * Возвращает обоорудование по его ID
     * @param id - ID обоорудования
     * @return - объект обоорудования с заданным ID
     */
    String read(int id) throws Exception;

    /**
     * Обновляет обоорудование с заданным ID,
     * в соответствии с переданным обоорудованием
     * @param equi - обоорудования в соответсвии с которым нужно обновить данные
     * @param id - id обоорудования которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client equi, int id);

    /**
     * Удаляет обоорудование с заданным ID
     * @param id - id обоорудования, которого нужно удалить
     * @return - true если был удален, иначе false
     */
    boolean delete(int id);

    <client> List<client> readAll();
    // кол-во * стоимость за шт * на наценку
    int getCostCustomer() throws Exception;
    // стоимость для заказчика -  стоимость для компании
    int getProfit() throws Exception;
    // кол-во * стоимость за шт
    int getCost();
}