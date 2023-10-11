package com.example.application11102023.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.application11102023.model.CourseModel

class DBHandler(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    // Método chamado para criar o banco de dados executando uma consulta SQLite.
    override fun onCreate(db: SQLiteDatabase) {
        // Abaixo, estamos criando uma consulta SQLite e definindo os nomes das colunas com seus tipos de dados.
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)")

        // Em seguida, executamos a consulta acima usando o método execSQL.
        db.execSQL(query)
    }

    // Método para adicionar um novo curso ao banco de dados SQLite.
    fun addNewCourse(
        courseName: String?,
        courseDuration: String?,
        courseDescription: String?,
        courseTracks: String?
    ) {
        // obtendo um objeto de banco de dados gravável.
        val db = this.writableDatabase

        //passa os valores e suas chaves correspondentes.
        val values = ContentValues()
        values.put(NAME_COL, courseName)
        values.put(DURATION_COL, courseDuration)
        values.put(DESCRIPTION_COL, courseDescription)
        values.put(TRACKS_COL, courseTracks)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    //atualizar o banco de dados.
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //verifica se a tabela já existe e, se existir, ela é descartada.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)

        //chamamos o método onCreate para criar uma nova tabela.
        onCreate(db)
    }

    companion object {
        // Variáveis constantes para o banco de dados.
        private const val DB_NAME = "coursedb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "mycourses"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"
        private const val DURATION_COL = "duration"
        private const val DESCRIPTION_COL = "description"
        private const val TRACKS_COL = "tracks"
    }

    // Método para ler todos os cursos do banco de dados e retorná-los como uma lista de CourseModel.
    fun readCourses(): ArrayList<CourseModel>? {
        // Obtendo um objeto de banco de dados somente leitura.
        val db = this.readableDatabase

        // Criando um cursor para ler dados do banco de dados.
        val cursorCourses: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // Criando uma lista para armazenar os modelos de curso.
        val courseModelArrayList: ArrayList<CourseModel> = ArrayList()

        // Movendo o cursor para a primeira posição.
        if (cursorCourses.moveToFirst()) {
            do {
                // Adicionando dados do cursor à lista de modelos de curso.
                courseModelArrayList.add(
                    CourseModel(
                        cursorCourses.getString(1),
                        cursorCourses.getString(4),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)
                    )
                )
            } while (cursorCourses.moveToNext())
            // Movendo o cursor para o próximo.
        }

        // Finalmente, fechando o cursor e retornando a lista de modelos de curso.
        cursorCourses.close()
        return courseModelArrayList
    }
}