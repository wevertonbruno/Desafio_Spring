package br.com.meli.grupo1.desafio_spring.DTO.purchases;

import java.io.Serializable;

public class ListOrderDTO implements Serializable {
    private OrderDTO ticket;

    public ListOrderDTO() {
    }

    public ListOrderDTO(OrderDTO ticket) {
        this.ticket = ticket;
    }

    public OrderDTO getTicket() {
        return ticket;
    }

    public void setTicket(OrderDTO ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "ListOrderDTO{" +
                "ticket=" + ticket +
                '}';
    }
}
