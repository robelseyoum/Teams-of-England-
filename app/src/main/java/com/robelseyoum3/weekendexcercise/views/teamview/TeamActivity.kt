package com.robelseyoum3.weekendexcercise.views.teamview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import kotlinx.android.synthetic.main.activity_team.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)


        val teamRequest = RetrofitInstances().retrofitInstances.create(TeamRequest::class.java)

        val call = teamRequest.getTeams(Constants.TEAMVALUE)

        call.enqueue(object : Callback<TeamModel> {
            override fun onFailure(call: Call<TeamModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamModel>, response: Response<TeamModel>) {
                val res = response.body()
               // Log.d("TEAM-IIDD", ""+res!!.teams[0].idTeam)
                getTeams(res!!)
            }

        })
    }

    fun getTeams(teamModel: TeamModel){

        val adapter = TeamAdapter(teamModel, object  : OnTeamClickListener{

            override fun teamDetailsClicked(id: Int) {
                Log.d("Wow-TEAM-ID", ""+id)
            }
        })

        rvList.layoutManager = LinearLayoutManager(this@TeamActivity)
        rvList.adapter = adapter
    }


}
