package com.example.application25102023.controller

class ContatoEstado(
    val nome: String = "",
    val sobrenome: String="",
    val telefone: String ="",
    val adicionarContato: Boolean = false,
    val contato: List<Contato> = emptyList(),
    val tipos: Tipos = Tipos.NOME
    )


