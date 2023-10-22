package br.upf.sistemaLivros.repository

import br.upf.sistemaLivros.model.Livro
import org.springframework.stereotype.Repository

@Repository
class LivroRepository(
    private var livros: MutableList<Livro>) {
    private var nextId: Long = 1

    init {
        val livro1 = Livro(
            id = 1,
            nome = "Harry Potter",
            autor = "J.K. Rowling",
            categoria = "Fantasia"
        )

        val livro2 = Livro(
            id = 2,
            nome = "O morro dos ventos uivantes",
            autor = "Emily Brontë",
            categoria = "Romance"
        )
        val livro3 = Livro(
            id = 3,
            nome = "Frankenstein",
            autor = "Mary Shelley",
            categoria = "Ficção Científica"
        )
        livros = mutableListOf(livro1, livro2, livro3)
    }
    fun findAll() = livros

    fun salvarLivro(livro: Livro) {
        livros.add(livro)
    }

    fun listarLivros(): List<Livro> {
        return livros.toList()
    }

    fun buscarLivroPorId(id: Long): Livro? {
        return livros.find { it.id == id }
    }

    fun atualizarLivro(livro: Livro): Livro? {
        val livroExistente = livros.find { it.id == livro.id }
        if (livroExistente != null) {
            val index = livros.indexOf(livroExistente)
            livros[index] = livro
        }
        return livroExistente
    }

    fun deletarLivro(id: Long) {
        val livroExistente = livros.find { it.id == id }
            livros.remove(livroExistente)
    }
}