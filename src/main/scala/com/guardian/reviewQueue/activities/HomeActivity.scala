package com.guardian.reviewQueue.activities

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget._
import com.google.inject.Inject
import com.guardian.reviewQueue.R
import com.guardian.reviewQueue.model.Review
import com.guardian.reviewQueue.model.ReviewTypes
import roboguice.activity.RoboActivity
import roboguice.activity.RoboListActivity
import java.io.IOException
import scala.collection.JavaConversions.asJavaList
import com.guardian.reviewQueue.model.Review
import com.reviewQueue.service.ReviewFetcherService
import com.guardian.reviewQueue.adapters.ReviewAdapter
import com.guardian.reviewQueue.service.ReviewConverterService
import android.util.Log

class HomeActivity extends Activity {
  var reviewFetcher: ReviewFetcherService = null
  /**Called when the activity is first created. */
  override def onCreate(savedInstanceState: Bundle) = {
    super.onCreate(savedInstanceState)
    reviewFetcher = new ReviewFetcherService(new ReviewConverterService())
    setContentView(R.layout.main)
    try {
      val reviews = reviewFetcher.getReviews(ReviewTypes.Unknown)
      if (reviews.size > 0) {
        val adapter = new ReviewAdapter(this, reviews)
        val lv = findViewById(R.id.list).asInstanceOf[ListView] //getListView
        lv setTextFilterEnabled true
        lv setAdapter adapter
        lv setOnItemClickListener adapter
      }
    }
    catch {
      case ex: IOException => {
        val msg: String = ex.getMessage
        Log.e("ReviewFetcher", ex.getMessage)
      }
    }
  }
}

