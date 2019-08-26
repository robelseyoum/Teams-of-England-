package com.robelseyoum3.weekendexcercise.views.teamview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.robelseyoum3.weekendexcercise.R
import com.robelseyoum3.weekendexcercise.models.teammodels.TeamModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_team_row.view.*

class TeamAdapter(private val teamModel: TeamModel, private val listener: OnTeamClickListener)
    : RecyclerView.Adapter<TeamViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_team_row, parent, false))

    }

    override fun getItemCount(): Int {
        return teamModel.teams.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        // res!!.teams[0].strTeam
        holder.tvName.text = teamModel.teams[position].strTeam
        holder.tvDescription.text = teamModel.teams[position].strDescriptionEN
        Picasso.get().load(teamModel.teams[position].strTeamBadge).into(holder.teamImage)
        holder.bind(teamModel, listener)

    }

}


class TeamViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val tvName = view.tv_team_name
    val tvDescription = view.tv_team_description
    val teamImage = view.tv_team_image

    fun bind(teamID: TeamModel, listener: OnTeamClickListener){
        itemView.setOnClickListener {
            listener.teamDetailsClicked(teamID.teams[adapterPosition].idTeam)
        }
    }


}



interface OnTeamClickListener {
    fun teamDetailsClicked(id: Int)
}