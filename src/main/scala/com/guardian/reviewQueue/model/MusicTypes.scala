package com.guardian.reviewQueue.model

import java.util.ArrayList
import java.util.List

object MusicTypes {
  final val Classical: MusicTypes = new MusicTypes(1, "classical", "Classical music and opera")
  final val Electronic: MusicTypes = new MusicTypes(2, "electronic", "Electronic music")
  final val Jazz: MusicTypes = new MusicTypes(3, "Jazz")
  final val Folk: MusicTypes = new MusicTypes(4, "Folk")
  final val Pop: MusicTypes = new MusicTypes(5, "popandrock", "Pop and Rock")
  final val Urban: MusicTypes = new MusicTypes(6, "urban", "Urban music")
  final val World: MusicTypes = new MusicTypes(7, "world", "World music")
  final val Soul: MusicTypes = new MusicTypes(8, "Soul")
  final val DanceMusic: MusicTypes = new MusicTypes(9, "dance", "Dance music")
  final val Unknown: MusicTypes = new MusicTypes(10, "Unknown", "Unknown", false)
}

class MusicTypes extends Enumeration {
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