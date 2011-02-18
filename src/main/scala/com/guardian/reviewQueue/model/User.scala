package com.guardian.reviewQueue.model

import java.util.Date
import java.util.ArrayList
import java.util.HashSet
import java.util.List

class User extends Entity {
  def this() {
    this ()
    ExcludedReviewTypes = new ArrayList[Nothing]
    SavedReviews = new HashSet[Nothing]
  }

  def IsSubscribedTo(reviewType: Nothing): Boolean = {
    if (reviewType == ReviewTypes.Unknown) return false
    for (r <- ExcludedReviewTypes) {
      if (r.Id == reviewType.Id) return true
    }
    return false
  }

  def SaveReviewToList(review: Nothing): Unit = {
    var savedReview: Nothing = new Nothing
    savedReview.Review = review
    savedReview.DateAdded = new Date
    SavedReviews.add(savedReview)
  }

  def RemoveReviewFromList(review: Nothing): Unit = {
    SavedReviews.remove(review)
  }

  def UnsubscribeFrom(reviewType: Nothing): Unit = {
    ExcludedReviewTypes.add(reviewType)
  }

  var ClaimedIdentifier: String = null
  var FriendlyIdentifier: String = null
  var FullName: String = null
  var Email: String = null
  var PostalCode: String = null
  var OpenIdProvider: String = null
  var OpenIdProviderVersion: String = null
  var SavedReviews: HashSet[Nothing] = null
  var ExcludedReviewTypes: List[Nothing] = null
}