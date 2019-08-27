package com.robelseyoum3.weekendexcercise.views.teamview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamDetailModel
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamsDetails
import com.robelseyoum3.weekendexcercise.models.teammodels.Teams
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        var intent = intent

        val teamID = intent.getStringExtra(Constants.TEAM_ID)

       // Log.d("Wow-TEAM-ID Detail", teamID)


        val teamRequest = RetrofitInstances().retrofitInstances.create(TeamRequest::class.java)

        val call = teamRequest.getTeamDetails(teamID!!.toString())


        call.enqueue(object : Callback<TeamDetailModel>{
            override fun onFailure(call: Call<TeamDetailModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamDetailModel>, response: Response<TeamDetailModel>) {
                val res = response.body()
                //Log.d("TEAM-IIDD", ""+res!!.teams[0].idTeam)

                Picasso.get().load(res!!.teams[0].strTeamJersey).into(tv_image_detail)
                tv_title_detail.text = res.teams[0].strStadiumLocation
                tv_description_detail.text = res.teams[0].strDescriptionEN
            }

        })

    }
}
