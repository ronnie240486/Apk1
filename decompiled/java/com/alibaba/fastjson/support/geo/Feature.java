package com.alibaba.fastjson.support.geo;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.alibaba.fastjson.annotation.JSONType;
import java.util.LinkedHashMap;
import java.util.Map;

@JSONType(orders = {SessionDescription.ATTR_TYPE, TtmlNode.ATTR_ID, "bbox", "coordinates", "properties"}, typeName = "Feature")
public class Feature extends Geometry {
    private Geometry geometry;

    private String f4399id;
    private Map<String, String> properties;

    public Feature() {
        super("Feature");
        this.properties = new LinkedHashMap();
    }

    public Geometry getGeometry() {
        return this.geometry;
    }

    public String getId() {
        return this.f4399id;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public void setId(String str) {
        this.f4399id = str;
    }

    public void setProperties(Map<String, String> map) {
        this.properties = map;
    }
}
