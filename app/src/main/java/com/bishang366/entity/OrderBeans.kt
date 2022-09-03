package com.bishang366.entity

import com.google.gson.annotations.SerializedName

data class CycleBean(
        @SerializedName("id")
        var id: Int,
        @SerializedName("cycleLength")
        var cycleLength: Int,
        @SerializedName("cycleRate")
        var cycleRate: Double,
        @SerializedName("minAmount")
        var minAmount: String,
        @SerializedName("maxAmount")
        var maxAmount: String,
        @SerializedName("createTime")
        var createTime: String,
        @SerializedName("updateTime")
        var updateTime: String
)

data class CompensationBean(
        @SerializedName("id")
        var id: Int,
        @SerializedName("startTime")
        var startTime: String,
        @SerializedName("endTime")
        var endTime: String,
        @SerializedName("orderNum")
        var orderNum: Int,
        @SerializedName("limitRate")
        var limitRate: Double,
        @SerializedName("createTime")
        var createTime: String,
        @SerializedName("updateTime")
        var updateTime: String
)
