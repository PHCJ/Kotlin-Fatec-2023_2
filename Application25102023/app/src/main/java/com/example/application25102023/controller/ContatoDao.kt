package com.example.application25102023.controller

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.application25102023.model.Contato
//import androidx.room.Update
//import androidx.room.Insert

@Dao
interface ContatoDao {
    //@Insert
    //fun insertContato(contato: Contato)
    //@Update
    //fun updateContato(contato: Contato)
    @Upsert
    suspend fun upsertContato(contato: Contato)
    @Delete
    suspend fun deleteContato(contato: Contato)

    @Query("SELECT * FROM contato")
    fun selectContatos(): List<Contato>
    @Query("SELECT * FROM contato ORDER BY nome")
    fun selectContatoOrdenadoPeloNome(): List<Contato>
}