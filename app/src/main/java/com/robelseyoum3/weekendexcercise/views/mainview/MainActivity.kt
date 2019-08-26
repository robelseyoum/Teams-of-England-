package com.robelseyoum3.weekendexcercise.views.mainview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log
import android.view.View
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.views.sortview.BubbleActivity
import com.robelseyoum3.weekendexcercise.views.teamview.TeamActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {


        when(view!!.id){

            R.id.btn_team_league ->{
                intent = Intent(this, TeamActivity::class.java)

            }

            R.id.btn_bubble_sort ->{
                intent = Intent(this, BubbleActivity::class.java)
            }

        }
            startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_bubble_sort.setOnClickListener(this)
        btn_team_league.setOnClickListener(this)


        val teamRequest = RetrofitInstances().retrofitInstances.create(TeamRequest::class.java)

        val call = teamRequest.getTeams(Constants.TEAMVALUE)

        call.enqueue(object : Callback<TeamModel>{
            override fun onFailure(call: Call<TeamModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamModel>, response: Response<TeamModel>) {
                val res = response.body()
                Log.d("TEAM-OUTPUT", res!!.teams[0].strTeam)

            }

        })
    }
}
