package com.practice.tree;

import java.io.Serializable;

public final class GenericPair<L, R> implements Serializable {

    private static final long serialVersionUID = 1L;
    private final L left;
    private final R right;


    public GenericPair(L left, R right) {
        this.left = left;
        this.right = right;
    }


    public L getLeft() {
        return left;
    }

    public R getRight() {
        return right;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GenericPair<?, ?> other = (GenericPair<?, ?>) obj;
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "{=[" + left + ", " + right + "]}";
    }
}
