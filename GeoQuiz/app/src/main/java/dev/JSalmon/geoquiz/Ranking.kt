package dev.JSalmon.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dev.JSalmon.geoquiz.TaskTablaRanking.Companion.prefs

class Ranking : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val ranking: TextView = findViewById(R.id.rankingFile)
        var text:String="\n\nTOP 10\n"
        for (i in 0 until 10) {
            if(prefs.getPuntuacion(i.toString())==-1){
                text += "\n" + "_"
            }else {
                text += "\n" + prefs.getPuntuacion(i.toString()).toString()
            }
        }
        ranking.setText(text)

    }// onCreate()

}// Ranking