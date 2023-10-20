package br.upf.sistemaLivros.model

    data class Livro(val id: Long,
                     val nome: String,
                     val autor: String,
                     val categoria: String)