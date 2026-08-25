package com.alibaba.fastjson.support.geo;

import androidx.media3.exoplayer.rtsp.SessionDescription;
import com.alibaba.fastjson.annotation.JSONType;
import java.util.ArrayList;
import java.util.List;

@JSONType(orders = {SessionDescription.ATTR_TYPE, "bbox", "geometries"}, typeName = "GeometryCollection")
public class GeometryCollection extends Geometry {
    private List<Geometry> geometries;

    public GeometryCollection() {
        super("GeometryCollection");
        this.geometries = new ArrayList();
    }

    public List<Geometry> getGeometries() {
        return this.geometries;
    }
}
