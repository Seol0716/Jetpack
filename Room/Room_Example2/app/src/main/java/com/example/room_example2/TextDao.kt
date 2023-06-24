package com.example.room_example2


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface TextDao {

    //Dao 앱의 데이터베이스 데이터를 쿼리,업데이트,삽입,삭제하는데 사용할 수 있는 메소드를 제공

    //모든 데이터 가져오기
    @Query("SELECT *FROM text_table")
    fun getAllData() : List<Text>

    //데이터 저장
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: Text)

    //데이터 삭제
    @Query("DELETE FROM text_table")
    fun deleteAllData()
}