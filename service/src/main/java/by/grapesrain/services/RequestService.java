package by.grapesrain.services;

import by.grapesrain.entitys.Departament;
import by.grapesrain.entitys.Request;

import java.util.List;

/**
 * Created by PloSkiY on 06.07.2017.
 */
public interface RequestService {

    List<Request> allRequests();

    List<Request> allRequestsWithPage(int startR, int limitR);

    Request findById(long id);

    List<Request> findRequestsByDepartament(Departament departament);

    void save(Request request, String login);

    List<Request> allRequestsByDepWithPage(int startR, int limitR, Departament departament);

    List<Request> allRequestsByDepWithPageWithautClose(int startR, int limitR, Departament departament);

    int quantityRequests(Departament departament);
}
