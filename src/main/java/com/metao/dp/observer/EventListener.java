package com.metao.dp.observer;

import java.io.File;

public interface EventListener {
    void update(String eventType, File file);
}
