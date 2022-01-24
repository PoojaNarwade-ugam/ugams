package com.Ugams.core.models.impl;
import com.Ugams.core.models.SingleApi;
import com.Ugams.core.services.OSGiConfigApi;
import com.Ugams.core.services.impl.ApiService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Iterator;
@Model(adaptables = Resource.class,
        adapters = SingleApi.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class SingleApiImpl implements SingleApi {
    private static final Logger log = LoggerFactory.getLogger(SingleApiImpl.class);
    @Inject
    String apiurl;
    private String email;
    private String firstname;
    private String lastname;
    private String image;
    @OSGiService
    OSGiConfigApi osGiConfigApi;


    @Override
    public String getMessage() throws JSONException {

        log.info("inside getMessage");
        String resp = ApiService.getJson(getUrl());

        log.info("jsonresponse"+resp);
        JSONObject obj = new JSONObject(resp);
        Iterator itr = obj.keys();
        JSONArray array = new JSONArray();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            array.put(obj.get(key));
        }
        email = array.getJSONObject(0).getString("email");
        firstname = array.getJSONObject(0).getString("first_name");
        lastname = array.getJSONObject(0).getString("last_name");
        image = array.getJSONObject(0).getString("avatar");
        return resp;
    }
    @Override
    public String getUrl() {
        log.info("final url"+osGiConfigApi.getSingleUserApi()+apiurl);
        return osGiConfigApi.getSingleUserApi()+apiurl;
    }

    public String getFirstName() {
        return firstname;
    }

    @Override
    public String getLastName() {
        return lastname;
    }

    @Override
    public String getImage() {
        String Const = "/content/dam/ugams/";
        String Path = image.replaceFirst("https://reqres.in/img/faces/", Const);
        return Path;
    }

    @Override
    public String getEmail() {
        return email;
    }
}

