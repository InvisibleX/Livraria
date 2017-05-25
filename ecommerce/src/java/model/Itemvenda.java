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
public class Itemvenda {
    private int Id;
    private int Codvenda;
    private int Codproduto;
    private int Quantidade;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getCodvenda() {
        return Codvenda;
    }

    public void setCodvenda(int Codvenda) {
        this.Codvenda = Codvenda;
    }

    public int getCodproduto() {
        return Codproduto;
    }

    public void setCodproduto(int Codproduto) {
        this.Codproduto = Codproduto;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }
    
    
}
