package com.guardian.reviewQueue.model

import java.util.{ArrayList, HashSet, List}
import scala.collection.JavaConversions._
class User extends Entity {

  var ExcludedReviewTypes = new ArrayList[ReviewTypes]
  var SavedReviews = new HashSet[SavedReview]
  var ClaimedIdentifier: String = null
  var FriendlyIdentifier: String = null
  var FullName: String = null
  var Email: String = null
  var PostalCode: String = null
  var OpenIdProvider: String = null
  var OpenIdProviderVersion: String = null


  def IsSubscribedTo(reviewType: ReviewTypes): Boolean = {
    if (reviewType == ReviewTypes.Unknown) return false
    //ExcludedReviewTypes.foreach()

    for (r <- ExcludedReviewTypes) {
      if (r.Id == reviewType.Id) return true
    }
    return false
  }

  def SaveReviewToList(review: Review): Unit = {
    val savedReview: SavedReview = new SavedReview(review)
    SavedReviews.add(savedReview)
  }

  def RemoveReviewFromList(review: SavedReview): Unit = {
    SavedReviews.remove(review)
  }

  def UnsubscribeFrom(reviewType: ReviewTypes): Unit = {
    ExcludedReviewTypes.add(reviewType)
  }

}