package com.metao.dp.composite;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundShape extends BaseShape {

    private List<Shape> children = new ArrayList<>();

    public CompoundShape(Shape... shapes) {
        super(0, 0, Color.BLACK);
        add(shapes);
    }

    public void add(Shape... shapes) {
        children.addAll(Arrays.asList(shapes));
    }

    public void remove(Shape... shapes) {
        children.removeAll(Arrays.asList(shapes));
    }

    public void clear() {
        children.clear();
    }

    @Override
    public int getX() {
        if (children.isEmpty()) {
            return 0;
        }
        int x = children.get(0).getX();
        for (final Shape child : children) {
            if (child.getX() < x) {
                x = child.getX();
            }
        }
        return x;
    }

    @Override
    public int getY() {
        if (children.isEmpty()) {
            return 0;
        }
        int y = children.get(0).getY();
        for (final Shape child : children) {
            if (child.getY() < y) {
                y = child.getY();
            }
        }
        return y;
    }

    @Override
    public int getWidth() {
        int maxWidth = 0;
        int x = getX();
        for (final Shape child : children) {
            int childRelativeX = child.getX() - x;
            int childWidth = childRelativeX + child.getWidth();
            if (childWidth > maxWidth) {
                maxWidth = childWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int maxHeight = 0;
        int y = getY();
        for (final Shape child : children) {
            int childRelativeY = child.getY() - y;
            int childHeight = childRelativeY + child.getWidth();
            if (childHeight > maxHeight) {
                maxHeight = childHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void move(int x, int y) {
        for (final Shape child : children) {
            child.move(x, y);
        }
    }

    @Override
    public boolean isInsideBound(int x, int y) {
        for (final Shape child : children) {
            if (child.isInsideBound(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void unSelect() {
        super.unSelect();
        for (final Shape child : children) {
            child.unSelect();
        }
    }

    @Override
    public void select() {
        super.select();
        for (final Shape child : children) {
            child.select();
        }
    }

    public void setChildren(List<Shape> children) {
        this.children = children;
    }
}
