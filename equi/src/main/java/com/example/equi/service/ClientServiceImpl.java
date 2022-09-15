package com.example.equi.service;

import com.example.equi.model.Client;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
@Service
public class ClientServiceImpl  implements ClientService {


    private static final Map<Integer, Client> CLIENT_REPOSITORY_MAP = new HashMap<>();


    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Client client) {
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_REPOSITORY_MAP.put(clientId, client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
    }

    @Override
    public Client read(int id) {
        return CLIENT_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
            client.setId(id);
            CLIENT_REPOSITORY_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CLIENT_REPOSITORY_MAP.remove(id) != null;
    }

    @Override
    public int getCostCustomer() {
        Integer sum = 0;
        final List<Client> equi = this.readAll();
        for (int i = 0; i < equi.size(); i++) {
            sum =  sum + ( equi.get(i).getAmount() * equi.get(i).getCost() +
                    equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() );
        }
        return sum;
    }



    @Override
    public int getProfit() {
//        Integer sum = 0;
//        final List<Client> equi = this.readAll();
//        for (int i = 0; i < equi.size(); i++) {
//            sum =  sum + ( equi.get(i).getAmount() * equi.get(i).getCost()  +
//                    equi.get(i).getAmount() * equi.get(i).getCost() / 100 * equi.get(i).getMarkup() -
//                    equi.get(i).getAmount() * equi.get(i).getCost() );
//
//        }
       return this.getCostCustomer() - this.getCost();
    }

    @Override
    public int getCost(){
        Integer sum = 0;
        final List<Client> equi = this.readAll();
        for (int i = 0; i < equi.size(); i++) {
                sum =  sum + equi.get(i).getAmount() * equi.get(i).getCost();
        }
        return sum;
}
}