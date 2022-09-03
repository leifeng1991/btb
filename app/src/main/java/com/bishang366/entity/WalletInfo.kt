package com.bishang366.entity

import com.google.gson.annotations.SerializedName

data class WalletInfo(
        @SerializedName("id")
        var id: Int,
        @SerializedName("balance")
        var balance: Double,
        @SerializedName("memberId")
        var memberId: Long,
        @SerializedName("frozenBalance")
        var frozenBalance: Double,
        @SerializedName("coin")
        var coin: WalletCoin?
)
data class WalletCoin(
        @SerializedName("name")
        var name: String?,
        @SerializedName("nameCn")
        var nameCn: String?,
        @SerializedName("unit")
        var unit: String?,
        @SerializedName("status")
        var status: Int,
        @SerializedName("minTxFee")
        var minTxFee: Double,
        @SerializedName("cnyRate")
        var cnyRate: Double,
        @SerializedName("maxTxFee")
        var maxTxFee: Double,
        @SerializedName("usdRate")
        var usdRate: Double,
        @SerializedName("enableRpc")
        var enableRpc: Int,
        @SerializedName("sort")
        var sort: Int,
        @SerializedName("canWithdraw")
        var canWithdraw: Int,
        @SerializedName("canRecharge")
        var canRecharge: Int,
        @SerializedName("canTransfer")
        var canTransfer: Int,
        @SerializedName("canAutoWithdraw")
        var canAutoWithdraw: Int,
        @SerializedName("withdrawThreshold")
        var withdrawThreshold: String?,
        @SerializedName("minWithdrawAmount")
        var minWithdrawAmount: String?,
        @SerializedName("maxWithdrawAmount")
        var maxWithdrawAmount: String?,
        @SerializedName("minRechargeAmount")
        var minRechargeAmount: String?,
        @SerializedName("isPlatformCoin")
        var isPlatformCoin: Int,
        @SerializedName("hasLegal")
        var hasLegal: Boolean,
        @SerializedName("allBalance")
        var allBalance: String?,
        @SerializedName("coldWalletAddress")
        var coldWalletAddress: String?,
        @SerializedName("hotAllBalance")
        var hotAllBalance: String?,
        @SerializedName("blockHeight")
        var blockHeight: String?,
        @SerializedName("minerFee")
        var minerFee: String?,
        @SerializedName("withdrawScale")
        var withdrawScale: Int,
        @SerializedName("infolink")
        var infolink: String?,
        @SerializedName("information")
        var information: String?,
        @SerializedName("accountType")
        var accountType: Int,
        @SerializedName("depositAddress")
        var depositAddress: String
)
