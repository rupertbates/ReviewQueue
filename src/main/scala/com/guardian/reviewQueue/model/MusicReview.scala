package com.guardian.reviewQueue.model

import java.util.List


class MusicReview(Title : String) extends Review(Title, ReviewType = ReviewTypes.Music) {
  var MusicTypes: List[MusicTypes] = null
}