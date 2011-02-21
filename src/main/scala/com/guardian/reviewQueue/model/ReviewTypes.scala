package com.guardian.reviewQueue.model

import java.util.ArrayList
import java.util.List

object ReviewTypes {
  final val Film: ReviewTypes = new ReviewTypes(1, "Film")
  final val Music: ReviewTypes = new ReviewTypes(2, "Music")
  final val Books: ReviewTypes = new ReviewTypes(3, "Books")
  final val Theatre: ReviewTypes = new ReviewTypes(4, "Theatre")
  final val Game: ReviewTypes = new ReviewTypes(5, "Games")
  final val TvAndRadio: ReviewTypes = new ReviewTypes(6, "TvAndRadio", "Television & Radio")
  final val Unknown: ReviewTypes = new ReviewTypes(7, "Unknown", "Unknown", false)
}

class ReviewTypes(val Id: Int,
                  val Name: String,
                  val DisplayName: String,
                  val ShowInUI: Boolean = true)
  extends Enumeration {

  def this(Id: Int, Name: String) = this (Id, Name, Name)

  var Reviews: List[Review] = null
}