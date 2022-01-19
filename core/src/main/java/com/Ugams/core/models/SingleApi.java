package com.Ugams.core.models;

import org.json.JSONException;

public interface SingleApi {
    public String getMessage() throws JSONException;
    public String getUrl();
    public String getFirstName();
    public String getLastName();
    public String getImage();
    public String getEmail();
}
