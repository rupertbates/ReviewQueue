package com.guardian.test
import com.guardian
import com.reviewQueue.service.ReviewFetcherService
import guardian.reviewQueue.model.ReviewTypes
import org.scalatest.junit.{ShouldMatchersForJUnit, JUnitSuite}
import org.junit.Test

//import junit.framework.Test

import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit

class ReviewFetcherSpecs extends JUnitSuite with ShouldMatchersForJUnit {
  @Test def canGetReviewsFromWebsite{
      val fetcher = new ReviewFetcherService
      val reviews = fetcher getReviewJson ReviewTypes.Unknown
      reviews.size should be > 0 //should not be ('empty)
  }
}