package com.groupB.foodoasis.Classes;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearLocatedPlacesFromGoogleMap {
    //initialize hash map
    private HashMap<String, String> parseJsonObject(JSONObject object) {
        HashMap<String, String> dataList = new HashMap<>();
        try {
            //get details from the object
//            String name = object.getString("name");
//            String icon_url = object.getString("icon");
//            String place_id = object.getString("place_id");
//            String latitude = object.getJSONObject("geometry")
//                    .getJSONObject("location")
//                    .getString("lat");
//            String longitude = object.getJSONObject("geometry")
//                    .getJSONObject("location")
//                    .getString("lng");

            String name = object.getString("name");
            String icon_url = "NA";
            String place_id = object.getString("number");
            String latitude = object.getString("lat");
            String longitude = object.getString("lon");

            //add key and value pairs in the hashmap
            dataList.put("name", name);
            dataList.put("icon", icon_url);
            dataList.put("place_id", place_id);
            dataList.put("lat", latitude);
            dataList.put("lng", longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    public List<HashMap<String, String>> parseJsonArray(JSONArray jsonArray) {
        List<HashMap<String, String>> dataList = new ArrayList<>();
        System.out.println(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                //add data in hashmap list
                HashMap<String, String> data = parseJsonObject((JSONObject) jsonArray.get(i));
                dataList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }

    public List<HashMap<String, String>> parseResult(JSONObject jsonObject) {
        JSONArray jsonArray = null;
        try {
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parseJsonArray(jsonArray);
    }
}
