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

class ReviewTypes extends Enumeration {
  protected def this(id: Int, name: String) {
    this ()
    `this`(id, name, name, true)
  }

  protected def this(id: Int, name: String, displayName: String) {
    this ()
    `this`(id, name, displayName, true)
  }

  protected def this(id: Int, name: String, displayName: String, showInUI: Boolean) {
    this ()
    `super`(id, name, displayName, showInUI)
  }

  def this() {
    this ()
    Reviews = new ArrayList[Nothing]
  }

  var Reviews: List[Nothing] = null
}