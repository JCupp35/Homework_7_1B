package com.cupp.msu.criminalintentchapter9a.database

import androidx.room.Dao
import androidx.room.Query
import com.cupp.msu.criminalintentchapter9a.Crime
import kotlinx.coroutines.flow.Flow
import java.util.*

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    //suspend fun getCrimes(): List<Crime>
    fun getCrimes(): Flow<List<Crime>>

    @Query("SELECT * FROM crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID): Crime
}