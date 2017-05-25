/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author rogerd
 */
public class Venda {
    private int Id;
    private int Id_cliente;
    private double Total;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId_cliente() {
        return Id_cliente;
    }

    public void setId_cliente(int Id_cliente) {
        this.Id_cliente = Id_cliente;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
}
