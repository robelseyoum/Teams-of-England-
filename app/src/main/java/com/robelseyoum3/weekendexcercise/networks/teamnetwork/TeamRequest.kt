package com.robelseyoum3.weekendexcercise.networks.teamnetwork

import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamDetailModel
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamsDetails
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TeamRequest {


//    const val BASE_URL_TEAM = "https://www.thesportsdb.com/api/v1/json/1/"
//    const val TEAMVALUE = "English Premier League"
//    const val TEAM_ID = "TEAM_ID"


    @GET("search_all_teams.php")
    fun getTeams(@Query("l") leagues: String): Call<TeamModel>

    //https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League

    //https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=133604

    @GET("lookupteam.php")
    fun getTeamDetails(@Query("id") teamID : String): Call<TeamDetailModel>


}