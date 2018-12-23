package com.zhuguang.jack.aware;

import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.instrument.classloading.LoadTimeWeaver;

public class LoadTimeTest implements LoadTimeWeaverAware {
    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {

    }
}
