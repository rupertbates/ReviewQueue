package com.guardian.reviewQueue.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.guardian.reviewQueue.model.Review
import java.util.List
import android.widget._

class ReviewAdapter(mContext: Context, reviews: List[Review]) extends BaseAdapter with AdapterView.OnItemClickListener{

  def getCount: Int = reviews.size

  def getItem(position: Int): AnyRef = {
    reviews.get(position)
  }

  def getItemId(position: Int): Long = {
    reviews.get(position).Id
  }

  def getView(position: Int, reviewView: View, parent: ViewGroup): View = {
    var txtView: TextView = null
    if (reviewView == null) {
      txtView = new TextView(mContext)

      txtView.setLayoutParams(new AbsListView.LayoutParams(85, 85))
      txtView.setPadding(8, 8, 8, 8)
    }
    else {
      txtView = reviewView.asInstanceOf[TextView]
    }
    txtView.setText(reviews.get(position).Title)
    return txtView
  }
  def onItemClick(parent: AdapterView[_], view: View, position: Int, id: Long) {
        Toast.makeText(mContext, (view.asInstanceOf[TextView]).getText, Toast.LENGTH_SHORT).show
      }

}