package dev.JSalmon.geoquiz

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class TablaRanking(context: Context) {
    companion object {
        //companion object es como usar static en java,
        //para poder acceder desde otras clases
        const val NAME="tablaRanking"
    }

    val prefs: SharedPreferences=context.getSharedPreferences(NAME, 0)

    fun setPuntuacion(key:String, puntos:Int){
        prefs.edit().putInt(key, puntos).apply()
    }// setPuntuacion()

    fun getPuntuacion(key:String):Int{
        return prefs.getInt(key, -1)
    }// getPuntuacion()

}// TablaRanking

class TaskTablaRanking: Application(){
    //La clase application es la primera clase por la que pasa la app por
    //eso sirve para instanciar cosas que usaremos en varios sitios
    companion object {
        lateinit var prefs:TablaRanking
    }

    override fun onCreate() {
        super.onCreate()
        prefs=TablaRanking(baseContext)
    }// onCreate()

}// TaskTablaRanking