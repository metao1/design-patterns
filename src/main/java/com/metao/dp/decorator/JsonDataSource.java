package com.metao.dp.decorator;

public class JsonDataSource implements DataSource<Model> {

    private final String filePath;

    public JsonDataSource(String path) {
        this.filePath = path;
    }

    @Override
    public void writeData(Model data) {
        String dataString = data.getData();
        if (dataString != null && dataString.length() > 0) {

        }
    }

    @Override
    public Model readData() {
        return null;
    }
}
