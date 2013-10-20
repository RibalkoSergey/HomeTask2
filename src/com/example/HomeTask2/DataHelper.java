package com.example.HomeTask2;

import com.example.HomeTask2.entities.Client;
import com.example.HomeTask2.entities.ClientType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataHelper {
    public static ArrayList<Client> getClients() {
        Client client1 = new Client("Петров Максим Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.SMALL);
        Client client2 = new Client("Иванов Сергей Петрович", "г.Черкассы ул.Смелянская 125", ClientType.BIG);
        Client client3 = new Client("Буркалов Павел Иванович", "г.Черкассы ул.Смелянская 125", ClientType.MIDDLE);
        Client client4 = new Client("Лесечко Дмитрий Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.VAST);
        Client client5 = new Client("Лисай Сергей Дмитриевич", "г.Черкассы ул.Смелянская 125", ClientType.SMALL);
        Client client6 = new Client("Бобров Владимир Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.MIDDLE);
        Client client7 = new Client("Петров Сергей Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.MIDDLE);
        Client client8 = new Client("Харченко Александр Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.BIG);
        Client client9 = new Client("Абажей Дмитрий Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.SMALL);
        Client client10 = new Client("Мирошниченко Петр Сергеевич", "г.Черкассы ул.Смелянская 125", ClientType.SMALL);

        ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);
        clients.add(client6);
        clients.add(client7);
        clients.add(client8);
        clients.add(client9);
        clients.add(client10);

        return clients;
    }
}
