package cn.tanghz17.bilidata.db.videoData


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "VideoData")
data class VideoData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("code")
    val code: Int, // 0
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String, // 0
    @SerializedName("ttl")
    val ttl: Int // 1
) {
    data class Data(
        @SerializedName("aid")
        val aid: Int, // 63823659
        @SerializedName("bvid")
        val bvid: String, // BV1J4411U7cE
        @SerializedName("cid")
        val cid: Int, // 110801274
        @SerializedName("copyright")
        val copyright: Int, // 1
        @SerializedName("ctime")
        val ctime: Int, // 1565856205
        @SerializedName("desc")
        val desc: String, // Android 安卓开发基础教程系列之23Room 数据库系列之（2）Room+ViewModel+Repository+AsyncTask+LiveData源代码：https://github.com/longway777/Android-2019-Tutorial-RoomBasic-step-2
        @SerializedName("desc_v2")
        val descV2: List<DescV2>,
        @SerializedName("dimension")
        val dimension: Dimension,
        @SerializedName("duration")
        val duration: Int, // 2154
        @SerializedName("dynamic")
        val `dynamic`: String, // #ANDROID##Room##Repository#Android 安卓开发基础教程系列之23Room 数据库系列之（2）Room+ViewModel+Repository+AsyncTask+LiveData源代码：https://github.com/longway777/Android-2019-Tutorial-RoomBasic-step-2
        @SerializedName("no_cache")
        val noCache: Boolean, // false
        @SerializedName("owner")
        val owner: Owner,
        @SerializedName("pages")
        val pages: List<Page>,
        @SerializedName("pic")
        val pic: String, // http://i0.hdslb.com/bfs/archive/0a3530af1259c42d39720f29d3bd6d89c18b4c63.jpg
        @SerializedName("pubdate")
        val pubdate: Int, // 1565856204
        @SerializedName("rights")
        val rights: Rights,
        @SerializedName("stat")
        val stat: Stat,
        @SerializedName("state")
        val state: Int, // 0
        @SerializedName("subtitle")
        val subtitle: Subtitle,
        @SerializedName("tid")
        val tid: Int, // 122
        @SerializedName("title")
        val title: String, // Android开发基础教程（2019）第23集 Room (2)
        @SerializedName("tname")
        val tname: String, // 野生技术协会
        @SerializedName("user_garb")
        val userGarb: UserGarb,
        @SerializedName("videos")
        val videos: Int // 1
    ) {
        data class DescV2(
            @SerializedName("biz_id")
            val bizId: Int, // 0
            @SerializedName("raw_text")
            val rawText: String, // Android 安卓开发基础教程系列之23Room 数据库系列之（2）Room+ViewModel+Repository+AsyncTask+LiveData源代码：https://github.com/longway777/Android-2019-Tutorial-RoomBasic-step-2
            @SerializedName("type")
            val type: Int // 1
        )

        data class Dimension(
            @SerializedName("height")
            val height: Int, // 2160
            @SerializedName("rotate")
            val rotate: Int, // 0
            @SerializedName("width")
            val width: Int // 3840
        )

        data class Owner(
            @SerializedName("face")
            val face: String, // http://i1.hdslb.com/bfs/face/3724f3593f236942d9abf55c9b37738ad5eb2da7.jpg
            @SerializedName("mid")
            val mid: Int, // 137860026
            @SerializedName("name")
            val name: String // longway777
        )

        data class Page(
            @SerializedName("cid")
            val cid: Int, // 110801274
            @SerializedName("dimension")
            val dimension: Dimension,
            @SerializedName("duration")
            val duration: Int, // 2154
            @SerializedName("from")
            val from: String, // vupload
            @SerializedName("page")
            val page: Int, // 1
            @SerializedName("part")
            val part: String, // Room 2
            @SerializedName("vid")
            val vid: String,
            @SerializedName("weblink")
            val weblink: String
        ) {
            data class Dimension(
                @SerializedName("height")
                val height: Int, // 2160
                @SerializedName("rotate")
                val rotate: Int, // 0
                @SerializedName("width")
                val width: Int // 3840
            )
        }

        data class Rights(
            @SerializedName("autoplay")
            val autoplay: Int, // 1
            @SerializedName("bp")
            val bp: Int, // 0
            @SerializedName("clean_mode")
            val cleanMode: Int, // 0
            @SerializedName("download")
            val download: Int, // 1
            @SerializedName("elec")
            val elec: Int, // 0
            @SerializedName("hd5")
            val hd5: Int, // 1
            @SerializedName("is_cooperation")
            val isCooperation: Int, // 0
            @SerializedName("is_stein_gate")
            val isSteinGate: Int, // 0
            @SerializedName("movie")
            val movie: Int, // 0
            @SerializedName("no_background")
            val noBackground: Int, // 0
            @SerializedName("no_reprint")
            val noReprint: Int, // 1
            @SerializedName("pay")
            val pay: Int, // 0
            @SerializedName("ugc_pay")
            val ugcPay: Int, // 0
            @SerializedName("ugc_pay_preview")
            val ugcPayPreview: Int // 0
        )

        data class Stat(
            @SerializedName("aid")
            val aid: Int, // 63823659
            @SerializedName("argue_msg")
            val argueMsg: String,
            @SerializedName("coin")
            val coin: Int, // 262
            @SerializedName("danmaku")
            val danmaku: Int, // 104
            @SerializedName("dislike")
            val dislike: Int, // 0
            @SerializedName("evaluation")
            val evaluation: String,
            @SerializedName("favorite")
            val favorite: Int, // 455
            @SerializedName("his_rank")
            val hisRank: Int, // 0
            @SerializedName("like")
            val like: Int, // 336
            @SerializedName("now_rank")
            val nowRank: Int, // 0
            @SerializedName("reply")
            val reply: Int, // 92
            @SerializedName("share")
            val share: Int, // 8
            @SerializedName("view")
            val view: Int // 13598
        )

        data class Subtitle(
            @SerializedName("allow_submit")
            val allowSubmit: Boolean, // false
            @SerializedName("list")
            val list: List<Any>
        )

        data class UserGarb(
            @SerializedName("url_image_ani_cut")
            val urlImageAniCut: String // http://i0.hdslb.com/bfs/garb/item/f565bada7ecd19ec03cffa0abfea1f4eed1914d3.bin
        )
    }
}