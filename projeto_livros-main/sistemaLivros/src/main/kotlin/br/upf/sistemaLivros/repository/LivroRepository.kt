package br.upf.sistemaLivros.repository

import br.upf.sistemaLivros.model.Livro
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository {
    private val livros = mutableListOf<Livro>()
    private var nextId: Long = 1

    fun salvarLivro(livro: Livro): Livro {
        val livroComId = livro.copy(id = nextId++)
        livros.add(livroComId)
        return livroComId
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

    fun deletarLivro(id: Long): Boolean {
        val livroExistente = livros.find { it.id == id }
        if (livroExistente != null) {
            livros.remove(livroExistente)
            return true
        }
        return false
    }
}