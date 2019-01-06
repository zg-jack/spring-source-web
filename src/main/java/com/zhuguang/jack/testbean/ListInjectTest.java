package com.zhuguang.jack.testbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListInjectTest {

    public List list = new ArrayList();

    public Map map = new HashMap();

    public Map getMap() {
        return this.map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return this.list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
