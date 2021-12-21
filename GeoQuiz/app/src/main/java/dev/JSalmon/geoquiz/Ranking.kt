package dev.JSalmon.geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.TextView
import java.io.File
import java.io.RandomAccessFile

class Ranking : AppCompatActivity() {
    private val ranking: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ranking)

        val f = File("/storage/emulated/files/Ranking.dat")
        val raf = RandomAccessFile(f, "rw")

        if (ranking != null) {
            ranking.setText("\n\nRanking\n"+raf.readInt())
        }
    }
}