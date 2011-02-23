package main.scala

import com.guardian
import com.reviewQueue.service.ReviewFetcherService
import guardian.reviewQueue.model.ReviewTypes
import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit

class ReviewFetcherTests extends JUnitSuite with ShouldMatchersForJUnit {
  @Test def canGetReviewsFromWebsite{
      val fetcher = new ReviewFetcherService
      val reviews = fetcher getReviewJson ReviewTypes.Unknown
      reviews should not be ('empty)
  }
}