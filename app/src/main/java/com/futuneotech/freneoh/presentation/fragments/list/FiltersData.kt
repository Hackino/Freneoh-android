package com.futuneotech.freneoh.presentation.fragments.list

import com.futuneotech.freneoh.R

sealed class Item(val title:Int)
sealed class PublishedDateItems( title:Int,val type:Int,val selected:Boolean):Item(title){
    object Daily:PublishedDateItems(title = R.string.daily,type=1,selected = false)
    object Weekly:PublishedDateItems(title = R.string.weekly,type=7,selected = false)
    object Monthly:PublishedDateItems(title = R.string.monthly,type=30,selected = false)
}

val publishedDateList = listOf(
    PublishedDateItems.Daily,
    PublishedDateItems.Weekly,
    PublishedDateItems.Monthly,
)

sealed class ArticleSection( title:Int,val type:String,val section:String):Item(title) {
    object All:ArticleSection(title = R.string.all_sections,type="all-sections",section = "all-sections")
    object Arts:ArticleSection(title = R.string.arts,type="arts",section = "Arts")
    object Automobiles:ArticleSection(title = R.string.automobiles,type="automobiles",section = "Automobiles")
    object Books:ArticleSection(title = R.string.books,type="books",section = "Books")
    object Business:ArticleSection(title = R.string.business,type="business",section = "Business")
    object Fashion:ArticleSection(title = R.string.fashion,type="fashion",section = "Fashion")
    object Food:ArticleSection(title = R.string.food,type="food",section = "Food")
    object Health:ArticleSection(title = R.string.health,type="health",section = "Health")
    object Home:ArticleSection(title = R.string.home,type="home",section = "Home")
    object Insider:ArticleSection(title = R.string.insider,type="insider",section = "Insider")
    object Magazine:ArticleSection(title = R.string.magazine,type="magazine",section = "Magazine")
    object Movies:ArticleSection(title = R.string.movies,type="movies",section = "Movies")
    object NYRegion:ArticleSection(title = R.string.nyregion,type="nyregion",section = "New York")
    object Obituaries:ArticleSection(title = R.string.obituaries,type="obituaries",section = "Obituaries")
    object Opinion:ArticleSection(title = R.string.opinion,type="opinion",section = "Opinion")
    object Politics:ArticleSection(title = R.string.politics,type="politics",section = "Politics")
    object RealEstate:ArticleSection(title = R.string.realestate,type="realestate",section = "Real Estate")
    object Science:ArticleSection(title = R.string.science,type="science",section = "Science")
    object Sports:ArticleSection(title = R.string.sports,type="sports",section = "Sports")
    object SundayReview:ArticleSection(title = R.string.sundayreview,type="sundayreview",section = "Opinion")
    object Technology:ArticleSection(title = R.string.technology,type="technology",section = "Technology")
    object Theater:ArticleSection(title = R.string.theater,type="theater",section = "Theater")
    object TMagazine:ArticleSection(title = R.string.tmagazine,type="t-magazine",section = "T Magazine")
    object Travel:ArticleSection(title = R.string.travel,type="travel",section = "Travel")
    object Upshot:ArticleSection(title = R.string.upshot,type="upshot",section = "Upshot")
    object US:ArticleSection(title = R.string.us,type="us",section = "U.S.")
    object World:ArticleSection(title = R.string.world,type="world",section = "World")
}

val sectionsList = listOf(
    ArticleSection.All,
    ArticleSection.Arts, ArticleSection.Automobiles,
    ArticleSection.Books, ArticleSection.Business,
    ArticleSection.Fashion, ArticleSection.Food,
    ArticleSection.Health, ArticleSection.Home,
    ArticleSection.Insider, ArticleSection.Magazine,
    ArticleSection.Movies, ArticleSection.NYRegion,
    ArticleSection.Obituaries, ArticleSection.Opinion,
    ArticleSection.Politics, ArticleSection.RealEstate,
    ArticleSection.Science, ArticleSection.Sports,
    ArticleSection.SundayReview, ArticleSection.Technology,
    ArticleSection.Theater, ArticleSection.TMagazine,
    ArticleSection.Travel, ArticleSection.Upshot,
    ArticleSection.US, ArticleSection.World,
)