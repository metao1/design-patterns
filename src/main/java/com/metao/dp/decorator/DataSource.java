package com.metao.dp.decorator;

public interface DataSource<T> {
    void writeData(T data);

    T readData();
}
