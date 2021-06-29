package com.oceanbrasil.ocean_android_androidroom

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDAO {
    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteWord(word: Word)
}