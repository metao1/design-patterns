package com.metao.dp.factory;

public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }

    @Override
    public void render() {

    }

    @Override
    public void onClick() {

    }
}
