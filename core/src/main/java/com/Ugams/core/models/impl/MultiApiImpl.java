package com.Ugams.core.models.impl;
import com.Ugams.core.services.impl.ApiService;
import org.json.JSONException;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONObject;


import com.Ugams.core.models.MultiApi;

@Model(adaptables = Resource.class,
        adapters = MultiApi.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class MultiApiImpl implements MultiApi {
    @Inject
    String page;
    @Override
    public List<Map<String, String>> getData() throws JSONException {

        String resp = ApiService.readJson(getUrl());
        JSONObject jsonObject =  new JSONObject(resp);
        JSONArray array = jsonObject.getJSONArray("data");
        List<Map<String, String>> userList = new ArrayList<>();
        for (int i=0;i<array.length();i++){
            Map<String,String> user =new HashMap<>();
            user.put("firstname",array.getJSONObject(i).getString("first_name"));
            user.put("lastname",array.getJSONObject(i).getString("last_name"));
            user.put("email",array.getJSONObject(i).getString("email"));
            user.put("img",array.getJSONObject(i).getString("avatar"));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public String getUrl() {
        return "https://reqres.in/api/users?page="+page;
    }
}
