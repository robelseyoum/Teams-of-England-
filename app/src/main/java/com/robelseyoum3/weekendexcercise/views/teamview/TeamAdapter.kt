package com.robelseyoum3.weekendexcercise.views.teamview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.common.inflate
import com.robelseyoum3.weekendexcercise.common.loadUrl
import com.robelseyoum3.weekendexcercise.common.setBoldAndColorSpannable
import com.robelseyoum3.weekendexcercise.models.teamdetails.TeamsDetails
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_row.view.*

class TeamAdapter(private val teamModel: TeamModel, private val listener: OnTeamClickListener)
    : RecyclerView.Adapter<TeamViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        //return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_team_row, parent, false))
        return TeamViewHolder(parent.inflate(R.layout.activity_team_row))
    }

    override fun getItemCount(): Int {
        return teamModel.teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        // res!!.teams[0].strTeam
//        holder.tvName.text = teamModel.teams[position].strTeam

        holder.tvName.setBoldAndColorSpannable(teamModel.teams[position].strTeam)

        holder.tvLeague.text = teamModel.teams[position].strLeague
        holder.tvstaduim.text = teamModel.teams[position].strStadium
        //Picasso.get().load(teamModel.teams[position].strTeamBadge).into(holder.teamImage)

        holder.teamImage.loadUrl(teamModel.teams[position].strTeamBadge)

        holder.bind(teamModel.teams[position], listener)

    }

}


class TeamViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val tvName = view.tv_team_name
    val tvLeague = view.tv_team_league
    val teamImage = view.tv_team_image
    val tvstaduim = view.tv_stadum

    fun bind(teamID: TeamsDetails, listener: OnTeamClickListener){


//        itemView.setOnClickListener {
//            listener.teamDetailsClicked(teamID.teams[adapterPosition].idTeam)
//        }

        itemView.setOnClickListener {
            listener.teamDetailsClicked(teamID)
        }
    }


}

interface OnTeamClickListener {
    fun teamDetailsClicked(teams: TeamsDetails)
}