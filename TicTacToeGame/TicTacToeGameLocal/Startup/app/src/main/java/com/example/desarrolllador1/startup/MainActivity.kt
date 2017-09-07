package com.example.desarrolllador1.startup

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    protected  fun btnClick(view:View){
        val btnSelected:Button =  view as Button
        var cellID=0
        when(btnSelected.id){
            R.id.btn1->cellID=1
            R.id.btn2->cellID=2
            R.id.btn3->cellID=3
            R.id.btn4->cellID=4
            R.id.btn5->cellID=5
            R.id.btn6->cellID=6
            R.id.btn7->cellID=7
            R.id.btn8->cellID=8
            R.id.btn9->cellID=9
        }

        //Toast.makeText(this, "ID, "+ cellID, Toast.LENGTH_SHORT).show()

        PlayGame(cellID,btnSelected)
    }
    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer=1
    fun PlayGame(cellID:Int, btnSelected:Button){

        if(ActivePlayer == 1){
            btnSelected.text="X"
            btnSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellID)
            ActivePlayer=2
            AutoPlay()
        }else{
            btnSelected.text="O"
            btnSelected.setBackgroundColor(Color.RED)
            Player2.add(cellID)
            ActivePlayer=1
        }

        btnSelected.isEnabled=false
        CheckWinner()
    }

    fun CheckWinner(){
        var winner = -1
        //row 1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winner=1
        }

        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winner=2
        }

        //row 2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winner=1
        }

        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winner=2
        }

        //row 3
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winner=1
        }

        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winner=2
        }

        //col 1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winner=1
        }

        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winner=2
        }

        //col 2
        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winner=1
        }

        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winner=2
        }

        //col 3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            winner=1
        }

        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winner=2
        }

        if(winner != -1){
            if (winner==1){
                Toast.makeText(this, "Jugador 1 ganador, ", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,  "Jugador 2 ganador, ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun AutoPlay(){
        var enptyCells=ArrayList<Int>()
        for(cellID in 1..9){
            if (!( Player1.contains(cellID) || Player2.contains(cellID))){
                enptyCells.add(cellID)
            }
        }

        var r= Random()
        val ranIndex=r.nextInt(enptyCells.size-0)+0

        val cellID = enptyCells.get(ranIndex)

        var btnSelected : Button?
        when(cellID){
            1->btnSelected= btn1
            2->btnSelected= btn2
            3->btnSelected= btn3
            4->btnSelected= btn4
            5->btnSelected= btn5
            6->btnSelected= btn6
            7->btnSelected= btn7
            8->btnSelected= btn8
            9->btnSelected= btn9
            else->{
                btnSelected=btn1
            }
        }

        PlayGame(cellID,btnSelected)
    }


}
