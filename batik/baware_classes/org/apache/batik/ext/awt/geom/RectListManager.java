package org.apache.batik.ext.awt.geom;
public class RectListManager implements java.util.Collection {
    java.awt.Rectangle[] rects = null;
    int size = 0;
    java.awt.Rectangle bounds = null;
    public void dump() { java.lang.System.err.println("RLM: " + this + " Sz: " +
                                                      size);
                         java.lang.System.err.println("Bounds: " + getBounds(
                                                                     ));
                         for (int i = 0; i < size; i++) { java.awt.Rectangle r =
                                                            rects[i];
                                                          java.lang.System.
                                                            err.println("  [" +
                                                                        r.
                                                                          x +
                                                                        ", " +
                                                                        r.
                                                                          y +
                                                                        ", " +
                                                                        r.
                                                                          width +
                                                                        ", " +
                                                                        r.
                                                                          height +
                                                                        ']');
                         } }
    public static java.util.Comparator comparator = new org.apache.batik.ext.awt.geom.RectListManager.RectXComparator(
      );
    public RectListManager(java.util.Collection rects) {
        super(
          );
        this.
          rects =
          (new java.awt.Rectangle[rects.
                                    size(
                                      )]);
        java.util.Iterator i =
          rects.
          iterator(
            );
        int j =
          0;
        while (i.
                 hasNext(
                   ))
            this.
              rects[j++] =
              (java.awt.Rectangle)
                i.
                next(
                  );
        this.
          size =
          this.
            rects.
            length;
        java.util.Arrays.
          sort(
            this.
              rects,
            comparator);
    }
    public RectListManager(java.awt.Rectangle[] rects) {
        this(
          rects,
          0,
          rects.
            length);
    }
    public RectListManager(java.awt.Rectangle[] rects,
                           int off,
                           int sz) { super();
                                     this.size = sz;
                                     this.rects =
                                       (new java.awt.Rectangle[sz]);
                                     java.lang.System.
                                       arraycopy(
                                         rects,
                                         off,
                                         this.
                                           rects,
                                         0,
                                         sz);
                                     java.util.Arrays.
                                       sort(
                                         this.
                                           rects,
                                         comparator);
    }
    public RectListManager(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        this(
          rlm.
            rects);
    }
    public RectListManager(java.awt.Rectangle rect) {
        this(
          );
        add(
          rect);
    }
    public RectListManager() { super();
                               this.rects = (new java.awt.Rectangle[10]);
                               size = 0; }
    public RectListManager(int capacity) { super(
                                             );
                                           this.rects =
                                             (new java.awt.Rectangle[capacity]);
    }
    public java.awt.Rectangle getBounds() { if (bounds !=
                                                  null)
                                                return bounds;
                                            if (size ==
                                                  0)
                                                return null;
                                            bounds =
                                              new java.awt.Rectangle(
                                                rects[0]);
                                            for (int i =
                                                   1;
                                                 i <
                                                   size;
                                                 i++) {
                                                java.awt.Rectangle r =
                                                  rects[i];
                                                if (r.
                                                      x <
                                                      bounds.
                                                        x) {
                                                    bounds.
                                                      width =
                                                      bounds.
                                                        x +
                                                        bounds.
                                                          width -
                                                        r.
                                                          x;
                                                    bounds.
                                                      x =
                                                      r.
                                                        x;
                                                }
                                                if (r.
                                                      y <
                                                      bounds.
                                                        y) {
                                                    bounds.
                                                      height =
                                                      bounds.
                                                        y +
                                                        bounds.
                                                          height -
                                                        r.
                                                          y;
                                                    bounds.
                                                      y =
                                                      r.
                                                        y;
                                                }
                                                if (r.
                                                      x +
                                                      r.
                                                        width >
                                                      bounds.
                                                        x +
                                                      bounds.
                                                        width)
                                                    bounds.
                                                      width =
                                                      r.
                                                        x +
                                                        r.
                                                          width -
                                                        bounds.
                                                          x;
                                                if (r.
                                                      y +
                                                      r.
                                                        height >
                                                      bounds.
                                                        y +
                                                      bounds.
                                                        height)
                                                    bounds.
                                                      height =
                                                      r.
                                                        y +
                                                        r.
                                                          height -
                                                        bounds.
                                                          y;
                                            }
                                            return bounds;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return copy1(
                 );
    }
    public org.apache.batik.ext.awt.geom.RectListManager copy1() {
        return new org.apache.batik.ext.awt.geom.RectListManager(
          rects);
    }
    public int size() { return size; }
    public boolean isEmpty() { return size ==
                                 0; }
    public void clear() { java.util.Arrays.
                            fill(
                              rects,
                              null);
                          size = 0;
                          bounds = null; }
    public java.util.Iterator iterator() {
        return new org.apache.batik.ext.awt.geom.RectListManager.RLMIterator(
          );
    }
    public java.util.ListIterator listIterator() {
        return new org.apache.batik.ext.awt.geom.RectListManager.RLMIterator(
          );
    }
    public java.lang.Object[] toArray() {
        java.lang.Object[] ret =
          new java.awt.Rectangle[size];
        java.lang.System.
          arraycopy(
            rects,
            0,
            ret,
            0,
            size);
        return ret;
    }
    public java.lang.Object[] toArray(java.lang.Object[] a) {
        java.lang.Class t =
          a.
          getClass(
            ).
          getComponentType(
            );
        if (t !=
              java.lang.Object.class &&
              t !=
              java.awt.Rectangle.class) {
            java.util.Arrays.
              fill(
                a,
                null);
            return a;
        }
        if (a.
              length <
              size)
            a =
              (new java.awt.Rectangle[size]);
        java.lang.System.
          arraycopy(
            rects,
            0,
            a,
            0,
            size);
        java.util.Arrays.
          fill(
            a,
            size,
            a.
              length,
            null);
        return a;
    }
    public boolean add(java.lang.Object o) {
        add(
          (java.awt.Rectangle)
            o);
        return true;
    }
    public void add(java.awt.Rectangle rect) {
        add(
          rect,
          0,
          size -
            1);
    }
    protected void add(java.awt.Rectangle rect,
                       int l,
                       int r) { ensureCapacity(
                                  size +
                                    1);
                                int idx =
                                  l;
                                while (l <=
                                         r) {
                                    idx =
                                      (l +
                                         r) /
                                        2;
                                    while (rects[idx] ==
                                             null &&
                                             idx <
                                             r)
                                        idx++;
                                    if (rects[idx] ==
                                          null) {
                                        r =
                                          (l +
                                             r) /
                                            2;
                                        idx =
                                          (l +
                                             r) /
                                            2;
                                        if (l >
                                              r)
                                            idx =
                                              l;
                                        while (rects[idx] ==
                                                 null &&
                                                 idx >
                                                 l)
                                            idx--;
                                        if (rects[idx] ==
                                              null) {
                                            rects[idx] =
                                              rect;
                                            return;
                                        }
                                    }
                                    if (rect.
                                          x ==
                                          rects[idx].
                                            x)
                                        break;
                                    if (rect.
                                          x <
                                          rects[idx].
                                            x) {
                                        if (idx ==
                                              0)
                                            break;
                                        if (rects[idx -
                                                    1] !=
                                              null &&
                                              rect.
                                                x >=
                                              rects[idx -
                                                      1].
                                                x)
                                            break;
                                        r =
                                          idx -
                                            1;
                                    }
                                    else {
                                        if (idx ==
                                              size -
                                              1) {
                                            idx++;
                                            break;
                                        }
                                        if (rects[idx +
                                                    1] !=
                                              null &&
                                              rect.
                                                x <=
                                              rects[idx +
                                                      1].
                                                x) {
                                            idx++;
                                            break;
                                        }
                                        l =
                                          idx +
                                            1;
                                    }
                                }
                                if (idx <
                                      size) {
                                    java.lang.System.
                                      arraycopy(
                                        rects,
                                        idx,
                                        rects,
                                        idx +
                                          1,
                                        size -
                                          idx);
                                }
                                rects[idx] =
                                  rect;
                                size++;
                                bounds = null;
    }
    public boolean addAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager) {
            add(
              (org.apache.batik.ext.awt.geom.RectListManager)
                c);
        }
        else {
            add(
              new org.apache.batik.ext.awt.geom.RectListManager(
                c));
        }
        return c.
          size(
            ) !=
          0;
    }
    public boolean contains(java.lang.Object o) {
        java.awt.Rectangle rect =
          (java.awt.Rectangle)
            o;
        int l =
          0;
        int r =
          size -
          1;
        int idx =
          0;
        while (l <=
                 r) {
            idx =
              l +
                r >>>
                1;
            if (rect.
                  x ==
                  rects[idx].
                    x)
                break;
            if (rect.
                  x <
                  rects[idx].
                    x) {
                if (idx ==
                      0)
                    break;
                if (rect.
                      x >=
                      rects[idx -
                              1].
                        x)
                    break;
                r =
                  idx -
                    1;
            }
            else {
                if (idx ==
                      size -
                      1) {
                    idx++;
                    break;
                }
                if (rect.
                      x <=
                      rects[idx +
                              1].
                        x) {
                    idx++;
                    break;
                }
                l =
                  idx +
                    1;
            }
        }
        if (rects[idx].
              x !=
              rect.
                x)
            return false;
        for (int i =
               idx;
             i >=
               0;
             i--) {
            if (rects[idx].
                  equals(
                    rect))
                return true;
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        for (int i =
               idx +
               1;
             i <
               size;
             i++) {
            if (rects[idx].
                  equals(
                    rect))
                return true;
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        return false;
    }
    public boolean containsAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return containsAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return containsAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean containsAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        for (int j =
               0,
               i =
                 0;
             j <
               rlm.
                 size;
             j++) {
            i =
              xChange;
            while (rects[i].
                     x <
                     rlm.
                       rects[j].
                       x) {
                i++;
                if (i ==
                      size)
                    return false;
            }
            xChange =
              i;
            x =
              rects[i].
                x;
            while (!rlm.
                      rects[j].
                     equals(
                       rects[i])) {
                i++;
                if (i ==
                      size)
                    return false;
                if (x !=
                      rects[i].
                        x)
                    return false;
            }
        }
        return true;
    }
    public boolean remove(java.lang.Object o) {
        return remove(
                 (java.awt.Rectangle)
                   o);
    }
    public boolean remove(java.awt.Rectangle rect) {
        int l =
          0;
        int r =
          size -
          1;
        int idx =
          0;
        while (l <=
                 r) {
            idx =
              l +
                r >>>
                1;
            if (rect.
                  x ==
                  rects[idx].
                    x)
                break;
            if (rect.
                  x <
                  rects[idx].
                    x) {
                if (idx ==
                      0)
                    break;
                if (rect.
                      x >=
                      rects[idx -
                              1].
                        x)
                    break;
                r =
                  idx -
                    1;
            }
            else {
                if (idx ==
                      size -
                      1) {
                    idx++;
                    break;
                }
                if (rect.
                      x <=
                      rects[idx +
                              1].
                        x) {
                    idx++;
                    break;
                }
                l =
                  idx +
                    1;
            }
        }
        if (rects[idx].
              x !=
              rect.
                x)
            return false;
        for (int i =
               idx;
             i >=
               0;
             i--) {
            if (rects[idx].
                  equals(
                    rect)) {
                java.lang.System.
                  arraycopy(
                    rects,
                    idx +
                      1,
                    rects,
                    idx,
                    size -
                      idx);
                size--;
                bounds =
                  null;
                return true;
            }
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        for (int i =
               idx +
               1;
             i <
               size;
             i++) {
            if (rects[idx].
                  equals(
                    rect)) {
                java.lang.System.
                  arraycopy(
                    rects,
                    idx +
                      1,
                    rects,
                    idx,
                    size -
                      idx);
                size--;
                bounds =
                  null;
                return true;
            }
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        return false;
    }
    public boolean removeAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return removeAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return removeAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean removeAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        boolean ret =
          false;
        for (int j =
               0,
               i =
                 0;
             j <
               rlm.
                 size;
             j++) {
            i =
              xChange;
            while (rects[i] ==
                     null ||
                     rects[i].
                       x <
                     rlm.
                       rects[j].
                       x) {
                i++;
                if (i ==
                      size)
                    break;
            }
            if (i ==
                  size)
                break;
            xChange =
              i;
            x =
              rects[i].
                x;
            while (true) {
                if (rects[i] ==
                      null) {
                    i++;
                    if (i ==
                          size)
                        break;
                    continue;
                }
                if (rlm.
                      rects[j].
                      equals(
                        rects[i])) {
                    rects[i] =
                      null;
                    ret =
                      true;
                }
                i++;
                if (i ==
                      size)
                    break;
                if (x !=
                      rects[i].
                        x)
                    break;
            }
        }
        if (ret) {
            int j =
              0;
            int i =
              0;
            while (i <
                     size) {
                if (rects[i] !=
                      null)
                    rects[j++] =
                      rects[i];
                i++;
            }
            size =
              j;
            bounds =
              null;
        }
        return ret;
    }
    public boolean retainAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return retainAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return retainAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean retainAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        boolean ret =
          false;
        for (int j =
               0,
               i =
                 0;
             j <
               size;
             j++) {
            i =
              xChange;
            while (rlm.
                     rects[i].
                     x <
                     rects[j].
                       x) {
                i++;
                if (i ==
                      rlm.
                        size)
                    break;
            }
            if (i ==
                  rlm.
                    size) {
                ret =
                  true;
                for (int k =
                       j;
                     k <
                       size;
                     k++)
                    rects[k] =
                      null;
                size =
                  j;
                break;
            }
            xChange =
              i;
            x =
              rlm.
                rects[i].
                x;
            while (true) {
                if (rects[j].
                      equals(
                        rlm.
                          rects[i]))
                    break;
                i++;
                if (i ==
                      rlm.
                        size ||
                      x !=
                      rlm.
                        rects[i].
                        x) {
                    rects[j] =
                      null;
                    ret =
                      true;
                    break;
                }
            }
        }
        if (ret) {
            int j =
              0;
            int i =
              0;
            while (i <
                     size) {
                if (rects[i] !=
                      null)
                    rects[j++] =
                      rects[i];
                i++;
            }
            size =
              j;
            bounds =
              null;
        }
        return ret;
    }
    public void add(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        if (rlm.
              size ==
              0)
            return;
        java.awt.Rectangle[] dst =
          rects;
        if (rects.
              length <
              size +
              rlm.
                size) {
            dst =
              (new java.awt.Rectangle[size +
                                        rlm.
                                          size]);
        }
        if (size ==
              0) {
            java.lang.System.
              arraycopy(
                rlm.
                  rects,
                0,
                dst,
                size,
                rlm.
                  size);
            size =
              rlm.
                size;
            bounds =
              null;
            return;
        }
        java.awt.Rectangle[] src1 =
          rlm.
            rects;
        int src1Sz =
          rlm.
            size;
        int src1I =
          src1Sz -
          1;
        java.awt.Rectangle[] src2 =
          rects;
        int src2Sz =
          size;
        int src2I =
          src2Sz -
          1;
        int dstI =
          size +
          rlm.
            size -
          1;
        int x1 =
          src1[src1I].
            x;
        int x2 =
          src2[src2I].
            x;
        while (dstI >=
                 0) {
            if (x1 <=
                  x2) {
                dst[dstI] =
                  src2[src2I];
                if (src2I ==
                      0) {
                    java.lang.System.
                      arraycopy(
                        src1,
                        0,
                        dst,
                        0,
                        src1I +
                          1);
                    break;
                }
                src2I--;
                x2 =
                  src2[src2I].
                    x;
            }
            else {
                dst[dstI] =
                  src1[src1I];
                if (src1I ==
                      0) {
                    java.lang.System.
                      arraycopy(
                        src2,
                        0,
                        dst,
                        0,
                        src2I +
                          1);
                    break;
                }
                src1I--;
                x1 =
                  src1[src1I].
                    x;
            }
            dstI--;
        }
        rects =
          dst;
        size +=
          rlm.
            size;
        bounds =
          null;
    }
    public void mergeRects(int overhead, int lineOverhead) {
        if (size ==
              0)
            return;
        java.awt.Rectangle r;
        java.awt.Rectangle cr;
        java.awt.Rectangle mr;
        int cost1;
        int cost2;
        int cost3;
        mr =
          new java.awt.Rectangle(
            );
        java.awt.Rectangle[] splits =
          new java.awt.Rectangle[4];
        for (int j,
               i =
                 0;
             i <
               size;
             i++) {
            r =
              rects[i];
            if (r ==
                  null)
                continue;
            cost1 =
              overhead +
                r.
                  height *
                lineOverhead +
                r.
                  height *
                r.
                  width;
            do  {
                int maxX =
                  r.
                    x +
                  r.
                    width +
                  overhead /
                  r.
                    height;
                for (j =
                       i +
                         1;
                     j <
                       size;
                     j++) {
                    cr =
                      rects[j];
                    if (cr ==
                          null ||
                          cr ==
                          r)
                        continue;
                    if (cr.
                          x >=
                          maxX) {
                        j =
                          size;
                        break;
                    }
                    cost2 =
                      overhead +
                        cr.
                          height *
                        lineOverhead +
                        cr.
                          height *
                        cr.
                          width;
                    mr =
                      r.
                        union(
                          cr);
                    cost3 =
                      overhead +
                        mr.
                          height *
                        lineOverhead +
                        mr.
                          height *
                        mr.
                          width;
                    if (cost3 <=
                          cost1 +
                          cost2) {
                        r =
                          (rects[i] =
                             mr);
                        rects[j] =
                          null;
                        cost1 =
                          cost3;
                        j =
                          -1;
                        break;
                    }
                    if (!r.
                          intersects(
                            cr))
                        continue;
                    splitRect(
                      cr,
                      r,
                      splits);
                    int splitCost =
                      0;
                    int l =
                      0;
                    for (int k =
                           0;
                         k <
                           4;
                         k++) {
                        if (splits[k] !=
                              null) {
                            java.awt.Rectangle sr =
                              splits[k];
                            if (k <
                                  3)
                                splits[l++] =
                                  sr;
                            splitCost +=
                              overhead +
                                sr.
                                  height *
                                lineOverhead +
                                sr.
                                  height *
                                sr.
                                  width;
                        }
                    }
                    if (splitCost >=
                          cost2)
                        continue;
                    if (l ==
                          0) {
                        rects[j] =
                          null;
                        if (splits[3] !=
                              null)
                            add(
                              splits[3],
                              j,
                              size -
                                1);
                        continue;
                    }
                    rects[j] =
                      splits[0];
                    if (l >
                          1)
                        insertRects(
                          splits,
                          1,
                          j +
                            1,
                          l -
                            1);
                    if (splits[3] !=
                          null)
                        add(
                          splits[3],
                          j,
                          size -
                            1);
                }
            }while(j !=
                     size); 
        }
        int j =
          0;
        int i =
          0;
        float area =
          0;
        while (i <
                 size) {
            if (rects[i] !=
                  null) {
                r =
                  rects[i];
                rects[j++] =
                  r;
                area +=
                  overhead +
                    r.
                      height *
                    lineOverhead +
                    r.
                      height *
                    r.
                      width;
            }
            i++;
        }
        size =
          j;
        bounds =
          null;
        r =
          getBounds(
            );
        if (r ==
              null)
            return;
        if (overhead +
              r.
                height *
              lineOverhead +
              r.
                height *
              r.
                width <
              area) {
            rects[0] =
              r;
            size =
              1;
        }
    }
    public void subtract(org.apache.batik.ext.awt.geom.RectListManager rlm,
                         int overhead,
                         int lineOverhead) {
        java.awt.Rectangle r;
        java.awt.Rectangle sr;
        int cost;
        int jMin =
          0;
        java.awt.Rectangle[] splits =
          new java.awt.Rectangle[4];
        for (int i =
               0;
             i <
               size;
             i++) {
            r =
              rects[i];
            cost =
              overhead +
                r.
                  height *
                lineOverhead +
                r.
                  height *
                r.
                  width;
            for (int j =
                   jMin;
                 j <
                   rlm.
                     size;
                 j++) {
                sr =
                  rlm.
                    rects[j];
                if (sr.
                      x +
                      sr.
                        width <
                      r.
                        x) {
                    if (j ==
                          jMin)
                        jMin++;
                    continue;
                }
                if (sr.
                      x >
                      r.
                        x +
                      r.
                        width)
                    break;
                if (!r.
                      intersects(
                        sr))
                    continue;
                splitRect(
                  r,
                  sr,
                  splits);
                int splitCost =
                  0;
                java.awt.Rectangle tmpR;
                for (int k =
                       0;
                     k <
                       4;
                     k++) {
                    tmpR =
                      splits[k];
                    if (tmpR !=
                          null)
                        splitCost +=
                          overhead +
                            tmpR.
                              height *
                            lineOverhead +
                            tmpR.
                              height *
                            tmpR.
                              width;
                }
                if (splitCost >=
                      cost)
                    continue;
                int l =
                  0;
                for (int k =
                       0;
                     k <
                       3;
                     k++) {
                    if (splits[k] !=
                          null)
                        splits[l++] =
                          splits[k];
                }
                if (l ==
                      0) {
                    rects[i].
                      width =
                      0;
                    if (splits[3] !=
                          null)
                        add(
                          splits[3],
                          i,
                          size -
                            1);
                    break;
                }
                r =
                  splits[0];
                rects[i] =
                  r;
                cost =
                  overhead +
                    r.
                      height *
                    lineOverhead +
                    r.
                      height *
                    r.
                      width;
                if (l >
                      1)
                    insertRects(
                      splits,
                      1,
                      i +
                        1,
                      l -
                        1);
                if (splits[3] !=
                      null)
                    add(
                      splits[3],
                      i +
                        l,
                      size -
                        1);
            }
        }
        int j =
          0;
        int i =
          0;
        while (i <
                 size) {
            if (rects[i].
                  width ==
                  0)
                rects[i] =
                  null;
            else
                rects[j++] =
                  rects[i];
            i++;
        }
        size =
          j;
        bounds =
          null;
    }
    protected void splitRect(java.awt.Rectangle r,
                             java.awt.Rectangle sr,
                             java.awt.Rectangle[] splits) {
        int rx0 =
          r.
            x;
        int rx1 =
          rx0 +
          r.
            width -
          1;
        int ry0 =
          r.
            y;
        int ry1 =
          ry0 +
          r.
            height -
          1;
        int srx0 =
          sr.
            x;
        int srx1 =
          srx0 +
          sr.
            width -
          1;
        int sry0 =
          sr.
            y;
        int sry1 =
          sry0 +
          sr.
            height -
          1;
        if (ry0 <
              sry0 &&
              ry1 >=
              sry0) {
            splits[0] =
              new java.awt.Rectangle(
                rx0,
                ry0,
                r.
                  width,
                sry0 -
                  ry0);
            ry0 =
              sry0;
        }
        else {
            splits[0] =
              null;
        }
        if (ry0 <=
              sry1 &&
              ry1 >
              sry1) {
            splits[1] =
              new java.awt.Rectangle(
                rx0,
                sry1 +
                  1,
                r.
                  width,
                ry1 -
                  sry1);
            ry1 =
              sry1;
        }
        else {
            splits[1] =
              null;
        }
        if (rx0 <
              srx0 &&
              rx1 >=
              srx0) {
            splits[2] =
              new java.awt.Rectangle(
                rx0,
                ry0,
                srx0 -
                  rx0,
                ry1 -
                  ry0 +
                  1);
        }
        else {
            splits[2] =
              null;
        }
        if (rx0 <=
              srx1 &&
              rx1 >
              srx1) {
            splits[3] =
              new java.awt.Rectangle(
                srx1 +
                  1,
                ry0,
                rx1 -
                  srx1,
                ry1 -
                  ry0 +
                  1);
        }
        else {
            splits[3] =
              null;
        }
    }
    protected void insertRects(java.awt.Rectangle[] rects,
                               int srcPos,
                               int dstPos,
                               int len) {
        if (len ==
              0)
            return;
        ensureCapacity(
          size +
            len);
        for (int i =
               size -
               1;
             i >=
               dstPos;
             i--)
            this.
              rects[i +
                      len] =
              this.
                rects[i];
        java.lang.System.
          arraycopy(
            rects,
            srcPos,
            this.
              rects,
            dstPos,
            len);
        size +=
          len;
    }
    public void ensureCapacity(int sz) { if (sz <=
                                               rects.
                                                 length)
                                             return;
                                         int nSz =
                                           rects.
                                             length +
                                           (rects.
                                              length >>
                                              1) +
                                           1;
                                         while (nSz <
                                                  sz)
                                             nSz +=
                                               (nSz >>
                                                  1) +
                                                 1;
                                         java.awt.Rectangle[] nRects =
                                           new java.awt.Rectangle[nSz];
                                         java.lang.System.
                                           arraycopy(
                                             rects,
                                             0,
                                             nRects,
                                             0,
                                             size);
                                         rects =
                                           nRects;
    }
    private static class RectXComparator implements java.util.Comparator, java.io.Serializable {
        RectXComparator() { super(); }
        public final int compare(java.lang.Object o1,
                                 java.lang.Object o2) {
            return ((java.awt.Rectangle)
                      o1).
                     x -
              ((java.awt.Rectangle)
                 o2).
                x;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b+Yl3f8FDwpKvE0iAAA=");
    }
    private class RLMIterator implements java.util.ListIterator {
        int idx = 0;
        boolean removeOk = false;
        boolean forward = true;
        RLMIterator() { super(); }
        public boolean hasNext() { return idx <
                                     size;
        }
        public int nextIndex() { return idx;
        }
        public java.lang.Object next() { if (idx >=
                                               size)
                                             throw new java.util.NoSuchElementException(
                                               "No Next Element");
                                         forward =
                                           true;
                                         removeOk =
                                           true;
                                         return rects[idx++];
        }
        public boolean hasPrevious() { return idx >
                                         0;
        }
        public int previousIndex() { return idx -
                                       1;
        }
        public java.lang.Object previous() {
            if (idx <=
                  0)
                throw new java.util.NoSuchElementException(
                  "No Previous Element");
            forward =
              false;
            removeOk =
              true;
            return rects[--idx];
        }
        public void remove() { if (!removeOk)
                                   throw new java.lang.IllegalStateException(
                                     "remove can only be called directly after next/previous");
                               if (forward)
                                   idx--;
                               if (idx !=
                                     size -
                                     1) java.lang.System.
                                          arraycopy(
                                            rects,
                                            idx +
                                              1,
                                            rects,
                                            idx,
                                            size -
                                              (idx +
                                                 1));
                               size--;
                               rects[size] =
                                 null;
                               removeOk =
                                 false; }
        public void set(java.lang.Object o) {
            java.awt.Rectangle r =
              (java.awt.Rectangle)
                o;
            if (!removeOk)
                throw new java.lang.IllegalStateException(
                  "set can only be called directly after next/previous");
            if (forward)
                idx--;
            if (idx +
                  1 <
                  size) {
                if (rects[idx +
                            1].
                      x <
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            if (idx >=
                  0) {
                if (rects[idx -
                            1].
                      x >
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            rects[idx] =
              r;
            removeOk =
              false;
        }
        public void add(java.lang.Object o) {
            java.awt.Rectangle r =
              (java.awt.Rectangle)
                o;
            if (idx <
                  size) {
                if (rects[idx].
                      x <
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            if (idx !=
                  0) {
                if (rects[idx -
                            1].
                      x >
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            ensureCapacity(
              size +
                1);
            if (idx !=
                  size)
                java.lang.System.
                  arraycopy(
                    rects,
                    idx,
                    rects,
                    idx +
                      1,
                    size -
                      idx);
            rects[idx] =
              r;
            idx++;
            removeOk =
              false;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "L9xJcATsIwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1lEE+tQtWzts6yL5zLfv/6W733sYKt+/");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "V/h4NpzQ7d03v0E1sL2wvPOU/+ojn/nuT730++UB9P8BcJCHerktAAA=";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lpQYfKqvzWWK+Bd54Vf5Iz6d/z/1U90BPUcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7DraH2fz9n3LuxelsduFnZ57SYsDle2Jb+yIcG2HpYs" +
       "2bJl+SECi56WrKf1sGSFR0KaLo+B0rAk0AnbzpQ8ymwgzZSmmQwJnZRHJpQp" +
       "NG2TziSEvpKUMhPSSWhDmvST7HN97rnnerm9h545+lvW9/r//q/v/0mf9ew3" +
       "CrcFfqHoudZmYbnhZTUJLy+t6uVw46nBZYqusqIfqErHEoNgDK49Kb/ql+/7" +
       "y29/QL90XLhdKLxQdBw3FEPDdYKRGrjWWlXown37q5il2kFYuEQvxbUIRaFh" +
       "QbQRhE/QhXtONQ0Lj9InLECABQiwAOUsQK19LdDo+aoT2Z2sheiEwarw9sIR" +
       "XbjdkzP2wsIrr+7EE33R3nXD5ghAD3dm3ycAVN448QuvuIJ9i/kawB8qQk//" +
       "zJsv/cothfuEwn2Gw2XsyICJEAwiFJ5nq7ak+kFLUVRFKLzAUVWFU31DtIw0" +
       "51so3B8YC0cMI1+9IqTsYuSpfj7mXnLPkzNsfiSHrn8FnmaolnLy7TbNEhcA" +
       "60v2WLcI8ew6AHi3ARjzNVFWT5rcahqOEhZefrbFFYyP9kAF0PQOWw1198pQ" +
       "tzoiuFC4f6s7S3QWEBf6hrMAVW9zIzBKWHjoup1msvZE2RQX6pNh4cGz9dht" +
       "Eah1Vy6IrElYePHZanlPQEsPndHSKf18o/+D7/9Rp+sc5zwrqmxl/N8JGj1y" +
       "ptFI1VRfdWR12/B5r6V/WnzJp991XCiAyi8+U3lb51ff+s03fP8jn/nCts5L" +
       "z6kzkJaqHD4pf0y698sv6zzevCVj407PDYxM+Vchz82f3ZU8kXjA815ypces" +
       "8PJJ4WdGn5v/2MfVrx8X7iYLt8uuFdnAjl4gu7ZnWKpPqI7qi6GqkIW7VEfp" +
       "5OVk4Q5wThuOur060LRADcnCrVZ+6XY3/w5EpIEuMhHdAc4NR3NPzj0x1PPz" +
       "xCsUCneAo1ABx+OF7V/+GRbeAumurUKiLDqG40Ks72b4A0h1QgnIVockYPUm" +
       "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" +
       "GfY763ZxrIdgqUgOpADzS2SPjVy4vKxL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "tNJ/8cA/+8FfeOYP8x9Z/l+70Z6jgFIAAA==");
}
