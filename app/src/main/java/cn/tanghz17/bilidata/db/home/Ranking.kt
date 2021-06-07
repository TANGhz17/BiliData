package cn.tanghz17.bilidata.db.home

import com.google.gson.annotations.SerializedName

data class Ranking(
    @SerializedName("code")
    val code: Int, // 0
    val data: Array<RankingItem>,
    @SerializedName("message")
    val message: String, // 0
    @SerializedName("ttl")
    val ttl: Int // 1
)

data class RankingItem(
    val id:Int,
    @SerializedName("aid")
    val aid: String, // 545925965
    @SerializedName("author")
    val author: String, // 不那么肝的老肝妈
    @SerializedName("badgepay")
    val badgepay: Boolean, // false
    @SerializedName("bvid")
    val bvid: String, // BV1Dq4y1j7es
    @SerializedName("coins")
    val coins: Int, // 32416
    @SerializedName("create")
    val create: String, // 2021-06-05 17:00
    @SerializedName("description")
    val description: String, // 记得点个赞哦
    @SerializedName("duration")
    val duration: String, // 1:41
    @SerializedName("favorites")
    val favorites: Int, // 18975
    @SerializedName("mid")
    val mid: Int, // 368094978
    @SerializedName("pic")
    val pic: String, // http://i0.hdslb.com/bfs/archive/0cc7b06e4ecb8d14a80b9381db3c56c2364faadf.jpg
    @SerializedName("play")
    val play: Int, // 962807
    @SerializedName("pts")
    val pts: Int, // 1653399
    @SerializedName("redirect_url")
    val redirectUrl: String,
    @SerializedName("review")
    val review: Int, // 3733
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String, // 一根头发弹出：《千本樱》准备好你的硬币！
    @SerializedName("typename")
    val typename: String, // 演奏
    @SerializedName("video_review")
    val videoReview: Int // 2034
)


