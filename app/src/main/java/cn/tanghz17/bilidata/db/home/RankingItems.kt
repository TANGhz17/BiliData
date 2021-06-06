package cn.tanghz17.bilidata.db.home

import android.content.res.Resources

fun rankingItemList(resources: Resources): List<RankingItem> {
    return listOf(
        RankingItem(
            id = 1,
            pic = "",
            title = "title",
            danmaku = 1000,
            mid = 1,
            face = "",
            name = "name"
        )
    )
}