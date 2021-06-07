package cn.tanghz17.bilidata.db.upData

import com.google.gson.annotations.SerializedName

data class UpDataMsg(
    @SerializedName("code")
    val code: Int, // 0
    @SerializedName("data")
    val `data`: UpData,
    @SerializedName("message")
    val message: String, // 0
    @SerializedName("ttl")
    val ttl: Int // 1
)

data class UpData(
    @SerializedName("birthday")
    val birthday: String, // 02-02
    @SerializedName("coins")
    val coins: Double, // 935.6
    @SerializedName("face")
    val face: String, // http://i1.hdslb.com/bfs/face/f9210be6605d22528c4da8e20f057078877f260e.jpg
    @SerializedName("fans_badge")
    val fansBadge: Boolean, // true
    @SerializedName("is_followed")
    val isFollowed: Boolean, // false
    @SerializedName("jointime")
    val jointime: Int, // 0
    @SerializedName("level")
    val level: Int, // 6
    @SerializedName("live_room")
    val liveRoom: LiveRoom,
    @SerializedName("mid")
    val mid: Int, // 86168911
    @SerializedName("moral")
    val moral: Int, // 0
    @SerializedName("name")
    val name: String, // 唐家17号
    @SerializedName("nameplate")
    val nameplate: Nameplate,
    @SerializedName("official")
    val official: Official,
    @SerializedName("pendant")
    val pendant: Pendant,
    @SerializedName("rank")
    val rank: Int, // 10000
    @SerializedName("sex")
    val sex: String, // 男
    @SerializedName("sign")
    val sign: String, // 切片不长进，二创没人看
    @SerializedName("silence")
    val silence: Int, // 0
//    @SerializedName("sys_notice")
//    val sysNotice: SysNotice,
    @SerializedName("top_photo")
    val topPhoto: String, // http://i0.hdslb.com/bfs/space/df46e2fb56c34f91a938d5276249397a712a3ec4.png
    @SerializedName("user_honour_info")
    val userHonourInfo: UserHonourInfo,
    @SerializedName("vip")
    val vip: Vip
) {
    data class LiveRoom(
        @SerializedName("broadcast_type")
        val broadcastType: Int, // 0
        @SerializedName("cover")
        val cover: String, // http://i0.hdslb.com/bfs/live/new_room_cover/afe317271ca48464f2ce612f0f06b0b93aeb8a72.jpg
        @SerializedName("liveStatus")
        val liveStatus: Int, // 0
        @SerializedName("online")
        val online: Int, // 132
        @SerializedName("roomStatus")
        val roomStatus: Int, // 1
        @SerializedName("roomid")
        val roomid: Int, // 12053261
        @SerializedName("roundStatus")
        val roundStatus: Int, // 0
        @SerializedName("title")
        val title: String, // 下午就是死线！
        @SerializedName("url")
        val url: String // https://live.bilibili.com/12053261
    )

    data class Nameplate(
        @SerializedName("condition")
        val condition: String, // 单个自制视频总播放数>=10万
        @SerializedName("image")
        val image: String, // http://i1.hdslb.com/bfs/face/f6a31275029365ae5dc710006585ddcf1139bde1.png
        @SerializedName("image_small")
        val imageSmall: String, // http://i1.hdslb.com/bfs/face/b09cdb4c119c467cf2d15db5263b4f539fa6e30b.png
        @SerializedName("level")
        val level: String, // 高级勋章
        @SerializedName("name")
        val name: String, // 白银殿堂
        @SerializedName("nid")
        val nid: Int // 3
    )

    data class Official(
        @SerializedName("desc")
        val desc: String,
        @SerializedName("role")
        val role: Int, // 0
        @SerializedName("title")
        val title: String,
        @SerializedName("type")
        val type: Int // -1
    )

    data class Pendant(
        @SerializedName("expire")
        val expire: Int, // 0
        @SerializedName("image")
        val image: String, // http://i1.hdslb.com/bfs/garb/item/5dba346937dd64a13881360b807d2dadfc6fe017.png
        @SerializedName("image_enhance")
        val imageEnhance: String, // http://i1.hdslb.com/bfs/garb/item/e805ed44dd58a8fc8bea55cd20545ebb18cf91c3.webp
        @SerializedName("image_enhance_frame")
        val imageEnhanceFrame: String, // http://i1.hdslb.com/bfs/garb/item/da6434b0d6765276fb8621ae137d8374b42b0c5e.png
        @SerializedName("name")
        val name: String, // 泠鸢yousa登门喜鹊
        @SerializedName("pid")
        val pid: Int // 4973
    )

//    class SysNotice(
//    )

    data class UserHonourInfo(
        @SerializedName("colour")
        val colour: Any, // null
        @SerializedName("mid")
        val mid: Int, // 0
        @SerializedName("tags")
        val tags: Any // null
    )

    data class Vip(
        @SerializedName("avatar_subscript")
        val avatarSubscript: Int, // 1
        @SerializedName("avatar_subscript_url")
        val avatarSubscriptUrl: String, // http://i0.hdslb.com/bfs/vip/icon_Certification_big_member_22_3x.png
        @SerializedName("due_date")
        val dueDate: Long, // 1697212800000
        @SerializedName("label")
        val label: Label,
        @SerializedName("nickname_color")
        val nicknameColor: String, // #FB7299
        @SerializedName("role")
        val role: Int, // 3
        @SerializedName("status")
        val status: Int, // 1
        @SerializedName("theme_type")
        val themeType: Int, // 0
        @SerializedName("type")
        val type: Int, // 2
        @SerializedName("vip_pay_type")
        val vipPayType: Int // 1
    ) {
        data class Label(
            @SerializedName("bg_color")
            val bgColor: String, // #FB7299
            @SerializedName("bg_style")
            val bgStyle: Int, // 1
            @SerializedName("border_color")
            val borderColor: String,
            @SerializedName("label_theme")
            val labelTheme: String, // annual_vip
            @SerializedName("path")
            val path: String,
            @SerializedName("text")
            val text: String, // 年度大会员
            @SerializedName("text_color")
            val textColor: String // #FFFFFF
        )
    }
}
