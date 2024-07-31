package com.example.wordle

object FiveLetterWordList {
    val fiveLetterWords =
        "Apple,Beach,Crate,Dream,Earth,Fancy,Grasp,Heart,Inbox,Judge,Kneel,Lemon,Month,Night,Ocean,Pound,Query,Right,Sound,Table,Under,Value,Watch,Xenon,Youth,Zebra,Alert,Brick,Clock,Drain,Elbow,Frame,Ghost,Hotel,Inner,Jolly,Knock,Light,Magic,Noble,Offer,Paint,Quick,River,Steel,Track,Unity,Visit,Whale,Extra,Yield,Zonal,Blaze, Claim, Dance, Flare, Grape, House, Ideal, Knack, Mango, Peace, Queen, Rocky, Shine, Tower, Voice, Wheat, Xerus, Brisk, Crave, Eagle, Frost, Happy, Inlet, Jumpy, Knoll, Loyal, Mirth, Novel, Oasis, Pious, Reach, Sheep, Trace, Utter, Vivid, Wrath, Xylem, Brave, Climb, Dwarf, Elate, Fable, Giant, Heavy, Ivory, Jokes, Midge, Olive, Prank, Quiet, Rhyme, Swoop, Twine, Unify, Verse, Water, Xerox, Zesty, Craft, Drift, Event, Index, Joint, Knead, Laugh, Maple, Nudge, Opium, Panic, Quake, Razor, Shade, Teach, Valor, Whisk, Zephyr"

    fun getAllFiveLetterWords(): List<String> {
        return fiveLetterWords.split(",")
    }

    fun getRandomFiveLetterWord(): String {
        val allWords = getAllFiveLetterWords()
        val randomNumber = (0..allWords.size).shuffled().last()
        return allWords[randomNumber].uppercase()
    }
}
