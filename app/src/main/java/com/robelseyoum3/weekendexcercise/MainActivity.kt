package com.robelseyoum3.weekendexcercise

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


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
