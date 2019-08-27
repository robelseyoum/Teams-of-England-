package com.robelseyoum3.weekendexcercise.views.teamview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.common.enqueue
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamDetailModel
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamsDetails
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.models.teammodels.Teams
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import com.robelseyoum3.weekendexcercise.presenter.TeamDetailPresenter
import com.robelseyoum3.weekendexcercise.presenter.TeamDetailView
import com.robelseyoum3.weekendexcercise.presenter.TeamPresenter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team.*
import kotlinx.android.synthetic.main.activity_team_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamDetailActivity : AppCompatActivity(), TeamDetailView {
    override fun getTeamId(): String {
        return intent.getStringExtra(Constants.TEAM_ID)
    }

    val presenter: TeamDetailPresenter = TeamDetailPresenter()

    override fun showLoading() {
       progress_id_details.visibility = View.VISIBLE
    }

    override fun showTeamLeague(teamDetailModel: TeamDetailModel) {

        progress_id_details.visibility = android.view.View.GONE

        Picasso.get().load(teamDetailModel!!.teams[0].strTeamJersey).into(tv_image_detail)
        tv_title_detail.text = teamDetailModel.teams[0].strStadiumLocation
        tv_description_detail.text = teamDetailModel.teams[0].strDescriptionEN

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        presenter.onViewAttached(this)


/*
        call.enqueue(object : Callback<TeamDetailModel>{
            override fun onFailure(call: Call<TeamDetailModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamDetailModel>, response: Response<TeamDetailModel>) {
                val res = response.body()
                //Log.d("TEAM-IIDD", ""+res!!.teams[0].idTeam)

                progress_id_details.visibility = View.GONE

                Picasso.get().load(res!!.teams[0].strTeamJersey).into(tv_image_detail)
                tv_title_detail.text = res.teams[0].strStadiumLocation
                tv_description_detail.text = res.teams[0].strDescriptionEN
            }

        })  */

    }


}
