package com.app.ci_cd_pipeline.projection;

public interface BlockMenuProjection {
     Long getMenuId();
     String getMenuName();
     Long getSubMenuId();
     String getSubMenuName();
     String getBlockType();
}
