package com.example.todolistapp.di

import com.example.todolistapp.data.datasource.ToDosDataSource
import com.example.todolistapp.data.repo.ToDosRepository
import com.example.todolistapp.room.ToDoDao
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.Provides
import javax.inject.Singleton
import dagger.hilt.android.qualifiers.ApplicationContext
import android.content.Context
import androidx.room.Room
import com.example.todolistapp.room.Veritabani

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideToDosRepository(todoDataSource: ToDosDataSource) : ToDosRepository{
        return ToDosRepository(todoDataSource)
    }

    @Provides
    @Singleton
    fun provideTodosDataSource(todoDao : ToDoDao) : ToDosDataSource{
        return ToDosDataSource(todoDao)
    }

    @Provides
    @Singleton
    fun provideTodosDao(@ApplicationContext context : Context) : ToDoDao{
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"todo.db")
            .createFromAsset("todo.db")
            .build()
        return veritabani.getTodosDao()
    }
}