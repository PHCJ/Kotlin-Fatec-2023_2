package com.example.application25102023.controller

sealed interface ContatoEventos {
    object  SalvarContatos: ContatoEventos

    data class SetNome(val nome:String): ContatoEventos
    data class SetSobrenome(val sobrenome: String):ContatoEventos
    data class SetTelefone(val telefone: String):ContatoEventos

}