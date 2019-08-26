package com.robelseyoum3.weekendexcercise.views.teamview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.Constants
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamsDetails
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.RetrofitInstances
import com.robelseyoum3.weekendexcercise.networks.teamnetwork.TeamRequest
import com.robelseyoum3.weekendexcercise.presenter.TeamPresenter
import com.robelseyoum3.weekendexcercise.presenter.TeamView
import kotlinx.android.synthetic.main.activity_team.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamActivity : AppCompatActivity(), TeamView {

    val presenter: TeamPresenter = TeamPresenter()

    override fun showLoading() {
        progress_id.visibility = View.VISIBLE
    }

    override fun showTeamLeague(teamModel: TeamModel) {

        progress_id.visibility = View.GONE
        getTeams(teamModel)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)


        presenter.onViewAttached(this)

    }

    fun getTeams(teamModel: TeamModel){

        val adapter = TeamAdapter(teamModel, object  : OnTeamClickListener{

            override fun teamDetailsClicked(teams: TeamsDetails) {
               Log.d("Wow-TEAM-ID", ""+teams.strTeam)
                sendToSecondActivity(teams.idTeam)
            }
        })

        rvList.layoutManager = LinearLayoutManager(this@TeamActivity)
        rvList.adapter = adapter
    }



    fun sendToSecondActivity(id: Int){

        intent = Intent(this, TeamDetailActivity::class.java )
        intent.putExtra(Constants.TEAM_ID, id.toString())
        startActivity(intent)

    }


}
