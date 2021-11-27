package cl.valentina.appcriptomonedas

import android.app.Application
import cl.valentina.appcriptomonedas.network.RetrofitApiService
import cl.valentina.appcriptomonedas.room.DaoCriptomonedas

import cl.valentina.appcriptomonedas.room.DatabaseCriptomonedas

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//Inyección de dependencias
@Module
@InstallIn(SingletonComponent::class)
class AppModulo {

    /*@Provides
    @Singleton
    fun getDetalleDatabase(context: Application): DatabaseDetalleCriptomoneda {
        return DatabaseDetalleCriptomoneda.getAppDetalleDbInstance(context)
    }*/

    /*@Provides
    @Singleton
    fun getDaoDetalle(databaseDetalleCriptomoneda: DatabaseDetalleCriptomoneda): DaoDetalleCriptomoneda {
        return databaseDetalleCriptomoneda.getDaoDetalleCriptomonedas()
    }*/

    @Provides
    @Singleton
    fun getDatabaseCriptomonedas(context: Application): DatabaseCriptomonedas {
        return DatabaseCriptomonedas.getAppDbInstance(context)
    }

    @Provides
    @Singleton
    fun getDaoCriptomonedas(databaseCriptomonedas: DatabaseCriptomonedas): DaoCriptomonedas {
        return databaseCriptomonedas.getDaoCriptomonedas()
    }

    val BaseUrl = "https://fake-server-app-crypto.herokuapp.com/"

    @Provides
    @Singleton
    fun getRetrofitInstancia(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun getRetofitApiService(retrofit: Retrofit): RetrofitApiService {
        return retrofit.create(RetrofitApiService::class.java)
    }
}