package com.Ugams.core.models;
import org.json.JSONException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
public interface MultiApi {
    public List<Map<String,String>> getData() throws JSONException;
    public String getUrl();
}
