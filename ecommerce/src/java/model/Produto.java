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
public class Produto {
    private int Id;
    private String Nome;
    private int Volume;
    private int Id_editora;
    private String Descricao;
    private String Imagem;
    private double Preco;
    private int Quantidade;
    private int Id_categoria;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int Volume) {
        this.Volume = Volume;
    }

    public int getId_editora() {
        return Id_editora;
    }

    public void setId_editora(int Id_editora) {
        this.Id_editora = Id_editora;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getImagem() {
        return Imagem;
    }

    public void setImagem(String Imagem) {
        this.Imagem = Imagem;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double Preco) {
        this.Preco = Preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public int getId_categoria() {
        return Id_categoria;
    }

    public void setId_categoria(int Id_categoria) {
        this.Id_categoria = Id_categoria;
    }
    
    
}
