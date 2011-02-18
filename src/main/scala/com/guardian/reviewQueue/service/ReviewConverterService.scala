/*
 * Created by IntelliJ IDEA.
 * User: rupert bates
 * Date: 18/02/11
 * Time: 16:02
 */
package com.guardian.reviewQueue.service

import com.google.gson.GsonBuilder
;
class ReviewConverterService {
    val b = new GsonBuilder();
    b.setDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    val _gson = b.create();

//    public List<Review> convertReviews(String json)
//    {
//        Type collectionType = new TypeToken<Collection<Review>>(){}.getType();
//        return _gson.fromJson(json, collectionType);
//    }
}