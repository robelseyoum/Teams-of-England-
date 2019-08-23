package com.robelseyoum3.weekendexcercise.networks.teamnetwork

import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamRequest {


    @GET("search_all_teams.php")
    fun getTeams(@Query("l") leagues: String): Call<TeamModel>


}