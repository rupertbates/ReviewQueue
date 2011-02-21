/*
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 18/02/11
 * Time: 16:16
 */
package com.guardian.reviewQueue.model;

import java.util.Date

class Review(var Title: String,
  var StandFirst: String = "",
  var TrailText: String = "",
  var Body: String = "",
  var PublicationDate: Date = new Date(),
  var ReviewType: ReviewTypes,
  var StarRating: Int = 0,
  var WebUrl: String = "",
  var Thumbnail: String = "") extends Entity {



}