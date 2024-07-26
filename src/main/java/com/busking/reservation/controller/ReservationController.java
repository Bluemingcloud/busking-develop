package com.busking.reservation.controller;

import java.io.IOException;
import java.util.List;

import com.busking.reservation.model.ReservationLocationDTO;
import com.busking.reservation.service.ReservationService;
import com.busking.reservation.service.ReservationServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.reservation")
public class ReservationController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ReservationService service;

    public ReservationController() {
        super();
        service = new ReservationServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        String path = request.getContextPath();
        String command = uri.substring(path.length());

        if (command.equals("/reservation/reservation.reservation")) {
            handleReservationList(request, response);
        } else if (command.equals("/reservation/reservationForm.reservation")) {
            handleReservationForm(request, response);
        } else if (command.equals("/reservation/reservationPost.reservation")) {
            handleCreateReservation(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
        }
    }

    private void handleReservationList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ReservationLocationDTO> locations = service.getReservationList();
        request.setAttribute("locations", locations);
        request.getRequestDispatcher("/reservation/reservation.jsp").forward(request, response);
    }

    private void handleReservationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int locaId = Integer.parseInt(request.getParameter("locaId"));
            ReservationLocationDTO location = service.getReservationLocationById(locaId);

            if (location != null) {
                request.setAttribute("location", location);
                request.getRequestDispatcher("/reservation/reservationForm.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Location not found");
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid location ID");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your request");
        }
    }

    private void handleCreateReservation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            service.createReservation(request, response);
            response.sendRedirect("reservationSuccess.jsp");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred while processing your reservation");
        }
    }
}
