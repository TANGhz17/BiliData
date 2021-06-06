package cn.tanghz17.bilidata.db.home
import com.google.gson.annotations.SerializedName


data class RankingItem(
    val id: Long,
    val pic: String,
    val title: String,
    val danmaku: Int,
    val mid: Int,
    val face: String,
    val name: String,

)
//data class test(
//    @SerializedName("code")
//    val code: Int, // 0
//    @SerializedName("data")
//    val `data`: List<Data>,
//    @SerializedName("message")
//    val message: String, // 0
//    @SerializedName("ttl")
//    val ttl: Int // 1
//) {
//    data class Data(
//        @SerializedName("aid")
//        val aid: String, // 545925965
//        @SerializedName("author")
//        val author: String, // 不那么肝的老肝妈
//        @SerializedName("badgepay")
//        val badgepay: Boolean, // false
//        @SerializedName("bvid")
//        val bvid: String, // BV1Dq4y1j7es
//        @SerializedName("coins")
//        val coins: Int, // 32416
//        @SerializedName("create")
//        val create: String, // 2021-06-05 17:00
//        @SerializedName("description")
//        val description: String, // 记得点个赞哦
//        @SerializedName("duration")
//        val duration: String, // 1:41
//        @SerializedName("favorites")
//        val favorites: Int, // 18975
//        @SerializedName("mid")
//        val mid: Int, // 368094978
//        @SerializedName("pic")
//        val pic: String, // http://i0.hdslb.com/bfs/archive/0cc7b06e4ecb8d14a80b9381db3c56c2364faadf.jpg
//        @SerializedName("play")
//        val play: Int, // 962807
//        @SerializedName("pts")
//        val pts: Int, // 1653399
//        @SerializedName("redirect_url")
//        val redirectUrl: String,
//        @SerializedName("review")
//        val review: Int, // 3733
//        @SerializedName("rights")
//        val rights: Rights,
//        @SerializedName("subtitle")
//        val subtitle: String,
//        @SerializedName("title")
//        val title: String, // 一根头发弹出：《千本樱》准备好你的硬币！
//        @SerializedName("typename")
//        val typename: String, // 演奏
//        @SerializedName("video_review")
//        val videoReview: Int // 2034
//    ) {
//        data class Rights(
//            @SerializedName("autoplay")
//            val autoplay: Int, // 1
//            @SerializedName("bp")
//            val bp: Int, // 0
//            @SerializedName("download")
//            val download: Int, // 0
//            @SerializedName("elec")
//            val elec: Int, // 0
//            @SerializedName("hd5")
//            val hd5: Int, // 0
//            @SerializedName("is_cooperation")
//            val isCooperation: Int, // 0
//            @SerializedName("movie")
//            val movie: Int, // 0
//            @SerializedName("no_background")
//            val noBackground: Int, // 0
//            @SerializedName("no_reprint")
//            val noReprint: Int, // 1
//            @SerializedName("pay")
//            val pay: Int, // 0
//            @SerializedName("ugc_pay")
//            val ugcPay: Int, // 0
//            @SerializedName("ugc_pay_preview")
//            val ugcPayPreview: Int // 0
//        )
//    }
//}
