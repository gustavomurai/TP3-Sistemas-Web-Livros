package br.edu.ifsp.ads571.tp3livros;

import java.math.BigDecimal;

/*
 * TP3 - Sistemas Web 1
 * Matéria: CBTSWE - ADS 571
 * Professor: Wellington Tuler Moraes
 *
 * Dupla:
 * 1 - Gustavo Murai - CB3033261
 * 2 - Igor Cerqueira Murai - CB3033295
 *
 * Classe modelo do sistema.
 * Esta classe representa um livro dentro da aplicação.
 */
public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private BigDecimal preco;

    public Livro() {
    }

    public Livro(int id, String titulo, String autor, BigDecimal preco) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro(String titulo, String autor, BigDecimal preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}