package com.example.recycler;

public class Item {
    private int imageResId;
    private String text;
    private boolean isChecked;

    public Item(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
        this.isChecked = false;
    }


    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
