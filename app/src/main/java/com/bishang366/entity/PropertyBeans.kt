package com.bishang366.entity

import com.google.gson.annotations.SerializedName

data class MemberInfo(
        @SerializedName("id")
        var id: Int,
        @SerializedName("memberId")
        var memberId: Long,
        @SerializedName("coinSymbol")
        var coinSymbol: String,
        @SerializedName("num")
        var num: Double,
        @SerializedName("earnNum")
        var earnNum: Double,
        @SerializedName("createTime")
        var createTime: String,
        @SerializedName("updateTime")
        var updateTime: String
)

data class PropertyInfo(
        @SerializedName("number")
        var number: String,
        @SerializedName("size")
        var size: String,
        @SerializedName("numberOfElements")
        var numberOfElements: String,
        @SerializedName("first")
        var first: Boolean,
        @SerializedName("totalPages")
        var totalPages: Int,
        @SerializedName("totalElements")
        var totalElements: Int,
        @SerializedName("last")
        var last: Boolean,
        @SerializedName("sort")
        var sorts: ArrayList<SortInfo> = arrayListOf(),
        @SerializedName("content")
        var content: ArrayList<PropertyDetailInfo> = arrayListOf()
)

data class PropertyDetailInfo(
        @SerializedName("id")
        var id: Int,
        @SerializedName("memberId")
        var memberId: Long,
        @SerializedName("coinSymbol")
        var coinSymbol: String,
        @SerializedName("num")
        var num: Double,
        @SerializedName("status")
        var status: String,
        @SerializedName("earnNum")
        var earnNum: Double,
        @SerializedName("createTime")
        var createTime: String,
        @SerializedName("updateTime")
        var updateTime: String
)

data class OptionInfo(
        @SerializedName("number")
        var number: Int,
        @SerializedName("size")
        var size: Int,
        @SerializedName("numberOfElements")
        var numberOfElements: Int,
        @SerializedName("first")
        var first: Boolean,
        @SerializedName("totalPages")
        var totalPages: Int,
        @SerializedName("totalElements")
        var totalElements: Int,
        @SerializedName("last")
        var last: Boolean,
        @SerializedName("sort")
        var sorts: ArrayList<SortInfo> = arrayListOf(),
        @SerializedName("content")
        var content: ArrayList<OptionDetailInfo> = arrayListOf()
)

data class OptionCurrentInfo(
        @SerializedName("number")
        var number: Int,
        @SerializedName("size")
        var size: Int,
        @SerializedName("numberOfElements")
        var numberOfElements: Int,
        @SerializedName("first")
        var first: Boolean,
        @SerializedName("totalPages")
        var totalPages: Int,
        @SerializedName("totalElements")
        var totalElements: Int,
        @SerializedName("last")
        var last: Boolean,
        @SerializedName("sort")
        var sorts: ArrayList<SortInfo> = arrayListOf(),
        @SerializedName("data")
        var content: ArrayList<OptionDetailInfo> = arrayListOf()
)

data class SortInfo(
        @SerializedName("direction")
        var direction: String,
        @SerializedName("property")
        var property: String,
        @SerializedName("ignoreCase")
        var ignoreCase: Boolean,
        @SerializedName("nullHandling")
        var nullHandling: String,
        @SerializedName("ascending")
        var ascending: Boolean,
        @SerializedName("descending")
        var descending: Boolean
)

data class OptionDetailInfo(
        @SerializedName("id")
        var id: Int,
        @SerializedName("memberId")
        var memberId: Long,
        @SerializedName("symbol")
        var symbol: String,
        @SerializedName("coinSymbol")
        var coinSymbol: String,
        @SerializedName("betAmount")
        var betAmount: String,
        @SerializedName("direction")
        var direction: String,
        @SerializedName("fee")
        var fee: String,
        @SerializedName("status")
        var status: String,
        @SerializedName("result")
        var result: String,
        @SerializedName("cycleId")
        var cycleId: Int,
        @SerializedName("cycleRate")
        var cycleRate: String,
        @SerializedName("cycleLength")
        var cycleLength: Int,
        @SerializedName("openPrice")
        var openPrice: Double,
        @SerializedName("closePrice")
        var closePrice: Double,
        @SerializedName("type")
        var type: String,
        @SerializedName("winAmount")
        var winAmount: Double,
        @SerializedName("createTime")
        var createTime: String,
        @SerializedName("closeTime")
        var closeTime: String,
        @SerializedName("updateTime")
        var updateTime: String,
        var countDownTime: Int
)
