package br.upf.sistemaLivros.model

    data class Livro(val id: Long? = null,
                     val nome: String,
                     val autor: String,
                     val categoria: String)