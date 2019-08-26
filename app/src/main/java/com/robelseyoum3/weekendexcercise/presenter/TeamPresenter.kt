package com.robelseyoum3.weekendexcercise.presenter

import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
/*
        val movieRequest = RetrofitInstances().retrofitInstances.create(MovieRequest::class.java)

        val call = movieRequest.getMoviesPopular(Constants.API_KEY)

        call.enqueue {
            onResponse = {
                  moviePopularModel -> val res = moviePopularModel.body()
                getTopMoviesList(res!!)
            }

            onFailure = {
                    error -> Log.d("Fail", error!!.message)
            }
        }

*/
 */

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