package com.example.equi.service;

import com.example.equi.model.Client;

import java.util.List;

public interface ClientService {
    /**
     * Создает нового клиента
     * @param equi - клиент для создания
     */
    void create(Client equi);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
   // List<client> readAll();

    /**
     * Возвращает клиента по его ID
     * @param id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Client read(int id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param equi - клиент в соответсвии с которым нужно обновить данные
     * @param id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    boolean update(Client equi, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int id);

    <client> List<client> readAll();
}