package com.metao.dp.factory;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public void render() {

    }

    @Override
    public void onClick() {

    }
}
