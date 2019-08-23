package com.robelseyoum3.weekendexcercise.models.teamdetails

import com.google.gson.annotations.SerializedName




data class TeamDetailModel (

	@SerializedName("teams") val teams : List<TeamsDetails>
)