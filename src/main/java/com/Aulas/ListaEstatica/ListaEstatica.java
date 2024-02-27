package com.Aulas.ListaEstatica;

import java.util.concurrent.ExecutionException;

public class ListaEstatica {
    private Object item[];
    private Integer primeiro, ultimo;

    public ListaEstatica(Integer maxtam) {
        //Super Class Object armazena tudo
        this.item = new Object[maxtam];
        this.primeiro = 0;
        this.ultimo = maxtam;
    }

    //Metodode preencher a lista pelo final
    public void inserirFinal(Object x) throws Exception {
        if (this.ultimo>= this.item.length){
            throw  new Exception("Erro: A lista esta cheia");

        }else {
            this.item[this.ultimo] = x;
            this.ultimo++;
        }
    }

    public void inserirEmQualquerPosicao(Object x, int pos) throws Exception {

        if (this.ultimo >= this.item.length) {
            throw new Exception("Erro: A lista está cheia");
        }
        // Desloca os elementos para a direita para abrir espaço para o novo elemento
        for (int i = this.ultimo; i > pos; i--) {
            this.item[i] = this.item[i - 1];
        }
        // Insere o novo elemento na posição especificada
        this.item[pos] = x;
        this.ultimo++; // Incrementa o contador de elementos
    }
}