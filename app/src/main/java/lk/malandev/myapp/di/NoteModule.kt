package lk.malandev.myapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import lk.malandev.myapp.data.remote.ApiService
import lk.malandev.myapp.data.local.NoteDatabase
import lk.malandev.myapp.data.local.UserDao
import lk.malandev.myapp.domain.repository.UserNetworkRepository
import lk.malandev.myapp.data.repository.UserNetworkRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java,"note_db").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(db: NoteDatabase): UserDao = db.userDao()

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserNetworkRepository(apiService: ApiService): UserNetworkRepository {
        return UserNetworkRepositoryImpl(apiService)
    }

}