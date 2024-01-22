enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(
    val nome : String,
    val email : String,
    val idade : Int
)

data class ConteudoEducacional(
    var nome: String, 
    val duracao: Int = 60,
    val descricao : String,
    val nivel : Nivel =Nivel.BASICO
)

data class Formacao(val nome: String) {

    private val conteudos = mutableListOf<ConteudoEducacional>()
    private val inscritos = mutableListOf<Usuario>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun removerConteudo(conteudo: ConteudoEducacional) {
        conteudos.remove(conteudo)
    }
    
     fun exibirInformacoes() {
        println("Formação: $nome")
        println("Conteúdos:")
        conteudos.forEach { println("${it.nome} - ${it.nivel}") }
        println("Inscritos: ${inscritos.size}")
    }
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val usuario1 = Usuario("João", "joao@email.com", 25)
    val usuario2 = Usuario("Maria", "maria@email.com", 30)

    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90, "Fundamentos de programação", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Banco de Dados Avançado", 120, "Modelagem e otimização de bancos de dados", Nivel.DIFICIL)

    val formacao1 = Formacao("Desenvolvedor Web Full Stack")
    formacao1.adicionarConteudo(conteudo1)
    formacao1.adicionarConteudo(conteudo2)

    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    formacao1.exibirInformacoes()

}