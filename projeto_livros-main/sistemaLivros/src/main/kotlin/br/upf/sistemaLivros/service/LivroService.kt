package br.upf.sistemaLivros.service

import br.upf.sistemaLivros.model.Livro
import br.upf.sistemaLivros.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class LivroService(private val livroRepository: LivroRepository) {
    fun criarLivro(livro: Livro): Livro {
        return livroRepository.salvarLivro(livro)
    }

    fun listarLivros(): List<Livro> {
        return livroRepository.listarLivros()
    }

    fun buscarLivroPorId(id: Long): Livro? {
        return livroRepository.buscarLivroPorId(id)
    }

    fun atualizarLivro(livro: Livro): Livro? {
        return livroRepository.atualizarLivro(livro)
    }

    fun deletarLivro(id: Long): Boolean {
        return livroRepository.deletarLivro(id)
    }
}