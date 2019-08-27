package com.robelseyoum3.weekendexcercise.presenter

import android.util.Log
import android.view.View
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.common.enqueue
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamDetailModel
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_detail.*




class TeamDetailPresenter: BasePresenter<TeamDetailView>(){

    override fun onViewAttached(view: TeamDetailView) {
        super.onViewAttached(view)
        view.showLoading()
        val teamId = view.getTeamId()

//
//        // Log.d("Wow-TEAM-ID Detail", teamID)
//
//        //progress_id_details.visibility = android.view.View.VISIBLE
//
//
        val teamRequest = RetrofitInstances().retrofitInstances.create(TeamRequest::class.java)

        val call = teamRequest.getTeamDetails(teamId!!.toString())


        call.enqueue {
            onResponse = {
                    teamDetailModel -> val res = teamDetailModel.body()

                view.showTeamLeague(res!!)
            }
            onFailure = {
                    error -> Log.d("Fail", error!!.message)
            }
        }


    }
}

interface TeamDetailView: BasePresenter.View{
    fun showLoading()
    fun showTeamLeague(teamDetailModel: TeamDetailModel)
    fun getTeamId(): String
}


/*
class TeamPresenter: BasePresenter<TeamView>(){

    override fun onViewAttached(view: TeamView) {
        super.onViewAttached(view)
        view.showLoading()


        val teamRequest = RetrofitInstances().retrofitInstances.create(TeamRequest::class.java)

        val call = teamRequest.getTeams(Constants.TEAMVALUE)

        call.enqueue(object : Callback<TeamModel> {
            override fun onFailure(call: Call<TeamModel>, t: Throwable) {
            }

            override fun onResponse(call: Call<TeamModel>, response: Response<TeamModel>) {
                val res = response.body()
                //Log.d("TEAM-IIDD", ""+res!!.teams[0].idTeam)
                //getTeams(res!!)
                view.showTeamLeague(res!!)
            }

        })
    }
}

interface TeamView: BasePresenter.View{
    fun showLoading()
    fun showTeamLeague(teamModel: TeamModel)
}
 */