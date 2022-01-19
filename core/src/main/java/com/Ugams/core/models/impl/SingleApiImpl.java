package com.Ugams.core.models.impl;

import com.Ugams.core.models.SingleApi;
import com.Ugams.core.utils.Network;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import javax.inject.Inject;
import java.util.Iterator;
@Model(adaptables = Resource.class,
        adapters = SingleApi.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class SingleApiImpl implements SingleApi {

    @Inject
    String apiurl;
    private String email;
    private String firstname;
    private String lastname;
    private String image;
    @Override
    public String getUrl() {
        return "https://reqres.in/api/users/"+apiurl;
    }

    @Override
    public String getMessage() throws JSONException {

        String response = Network.readJson("https://reqres.in/api/users/"+apiurl);
        JSONObject jsonObject =  new JSONObject(response);
        Iterator x = jsonObject.keys();
        JSONArray jsonArray = new JSONArray();
        while (x.hasNext()){
            String key = (String) x.next();
            jsonArray.put(jsonObject.get(key));
        }
        email = jsonArray.getJSONObject(0).getString("email");
        firstname = jsonArray.getJSONObject(0).getString("first_name");
        lastname = jsonArray.getJSONObject(0).getString("last_name");
        image = jsonArray.getJSONObject(0).getString("avatar");
        return response;
    }

    public String getFirstName(){
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getImage() {
        String Path = image.replaceAll("https://reqres.in/img/faces/","/content/dam/ugams/");
        return Path;
    }

    @Override
    public String getEmail() {
        return email;
    }




}
