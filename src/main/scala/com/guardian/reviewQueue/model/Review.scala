/*
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 18/02/11
 * Time: 16:16
 */
package com.guardian.reviewQueue.model;

import java.util.Date

class Review extends Entity {
  protected def this() {
    this ()
  }

  def this(`type` : ReviewTypes) {
    this ()
    ReviewType = `type`
  }

  var Title: String = null
  var StandFirst: String = null
  var TrailText: String = null
  var Body: String = null
  var PublicationDate: Date = null
  var ReviewType: ReviewTypes = null
  var StarRating: Int = 0
  var WebUrl: String = null
  var Thumbnail: String = null
}