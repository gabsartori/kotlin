package br.upf.sistemaLivros.controller
import br.upf.sistemaLivros.model.Livro
import br.upf.sistemaLivros.service.LivroService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/livros")
class LivroController(private val livroService: LivroService) {
    @PostMapping
    fun criarLivro(@RequestBody livro: Livro): Livro {
        return livroService.criarLivro(livro)
    }

    @GetMapping
    fun listarLivros(): List<Livro> {
        return livroService.listarLivros()
    }

    @GetMapping("/{id}")
    fun buscarLivroPorId(@PathVariable id: Long): Livro? {
        return livroService.buscarLivroPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizarLivro(@PathVariable id: Long, @RequestBody livro: Livro): Livro? {
        if (livro.id != id) {
            throw IllegalArgumentException("O ID do livro não corresponde ao ID na URL.")
        }
        return livroService.atualizarLivro(livro)
    }

    @DeleteMapping("/{id}")
    fun deletarLivro(@PathVariable id: Long): Boolean {
        return livroService.deletarLivro(id)
    }
}