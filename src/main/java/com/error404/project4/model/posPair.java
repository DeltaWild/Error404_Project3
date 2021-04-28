package com.error404.project4.model;

import java.io.Serializable;
import java.util.Objects;

public class posPair implements Comparable<posPair>, Serializable {
    public final long fid;
    public final int pos;

    public posPair(long fid, int pos) {
        this.fid = fid;
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        posPair posPair = (posPair) o;
        return fid == posPair.fid && pos == posPair.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, pos);
    }

    @Override
    public String toString() {
        return "fileItem{" +
                "fileID=" + fid +
                ", fileName='" + pos +
                '}';
    }

    @Override
    public int compareTo(posPair file2) {
        return (int)(this.fid - file2.fid);
    }
}
