package com.app.ci_cd_pipeline.utils;

import org.json.simple.JSONObject;

public interface Response {

    JSONObject getJson();

    JSONObject customGetJson();

    JSONObject customGetJsonForAll();
}