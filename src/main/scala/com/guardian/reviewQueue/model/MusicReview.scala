package com.guardian.reviewQueue.model

import java.util.List


class MusicReview extends Review {
  protected def this() {
    this ()
    ReviewType = ReviewTypes.Music
  }

  def this(types: List[Nothing]) {
    this ()
    ReviewType = ReviewTypes.Music
    MusicTypes = types
  }

  var MusicTypes: List[Nothing] = null
}