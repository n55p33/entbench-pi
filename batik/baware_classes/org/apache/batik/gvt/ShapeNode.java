package org.apache.batik.gvt;
public class ShapeNode extends org.apache.batik.gvt.AbstractGraphicsNode {
    protected java.awt.Shape shape;
    protected org.apache.batik.gvt.ShapePainter shapePainter;
    private java.awt.geom.Rectangle2D primitiveBounds;
    private java.awt.geom.Rectangle2D geometryBounds;
    private java.awt.geom.Rectangle2D sensitiveBounds;
    private java.awt.Shape paintedArea;
    private java.awt.Shape sensitiveArea;
    public ShapeNode() { super(); }
    public void setShape(java.awt.Shape newShape) { fireGraphicsNodeChangeStarted(
                                                      );
                                                    invalidateGeometryCache(
                                                      );
                                                    this.shape = newShape;
                                                    if (this.shapePainter !=
                                                          null) {
                                                        if (newShape !=
                                                              null) {
                                                            this.
                                                              shapePainter.
                                                              setShape(
                                                                newShape);
                                                        }
                                                        else {
                                                            this.
                                                              shapePainter =
                                                              null;
                                                        }
                                                    }
                                                    fireGraphicsNodeChangeCompleted(
                                                      ); }
    public java.awt.Shape getShape() { return shape; }
    public void setShapePainter(org.apache.batik.gvt.ShapePainter newShapePainter) {
        if (shape ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          shapePainter =
          newShapePainter;
        if (shapePainter !=
              null &&
              shape !=
              this.
                shapePainter.
              getShape(
                )) {
            shapePainter.
              setShape(
                shape);
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.gvt.ShapePainter getShapePainter() {
        return shapePainter;
    }
    public void paint(java.awt.Graphics2D g2d) { if (isVisible)
                                                     super.
                                                       paint(
                                                         g2d);
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (shapePainter !=
              null) {
            shapePainter.
              paint(
                g2d);
        }
    }
    protected void invalidateGeometryCache() { super.
                                                 invalidateGeometryCache(
                                                   );
                                               primitiveBounds =
                                                 null;
                                               geometryBounds =
                                                 null;
                                               sensitiveBounds =
                                                 null;
                                               paintedArea =
                                                 null;
                                               sensitiveArea =
                                                 null;
    }
    public void setPointerEventType(int pointerEventType) {
        super.
          setPointerEventType(
            pointerEventType);
        sensitiveBounds =
          null;
        sensitiveArea =
          null;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case VISIBLE_FILL:
            case VISIBLE_STROKE:
            case VISIBLE:
                if (!isVisible)
                    return false;
            case PAINTED:
            case FILL:
            case STROKE:
            case ALL:
                {
                    java.awt.geom.Rectangle2D b =
                      getSensitiveBounds(
                        );
                    if (b ==
                          null ||
                          !b.
                          contains(
                            p))
                        return false;
                    return inSensitiveArea(
                             p);
                }
            case NONE:
            default:
                return false;
        }
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        java.awt.geom.Rectangle2D b =
          getBounds(
            );
        if (b !=
              null) {
            return b.
              intersects(
                r) &&
              paintedArea !=
              null &&
              paintedArea.
              intersects(
                r);
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() {
        if (!isVisible)
            return null;
        if (shape ==
              null)
            return null;
        if (primitiveBounds !=
              null)
            return primitiveBounds;
        if (shapePainter ==
              null)
            primitiveBounds =
              shape.
                getBounds2D(
                  );
        else
            primitiveBounds =
              shapePainter.
                getPaintedBounds2D(
                  );
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            invalidateGeometryCache(
              );
        }
        return primitiveBounds;
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        if (shapePainter ==
              null)
            return false;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else {
                    return false;
                }
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                return shapePainter.
                  inPaintedArea(
                    pt);
            case VISIBLE:
            case ALL:
                return shapePainter.
                  inSensitiveArea(
                    pt);
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null)
                    return fillShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null)
                    return strokeShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case NONE:
            default:
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        if (sensitiveBounds !=
              null)
            return sensitiveBounds;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveBounds =
                  shapePainter.
                    getPaintedBounds2D(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveBounds =
                      fillShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveBounds =
                      strokeShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveBounds =
                  shapePainter.
                    getSensitiveBounds2D(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveBounds;
    }
    public java.awt.Shape getSensitiveArea() {
        if (sensitiveArea !=
              null)
            return sensitiveArea;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveArea =
                  shapePainter.
                    getPaintedArea(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveArea =
                      fillShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveArea =
                      strokeShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveArea =
                  shapePainter.
                    getSensitiveArea(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveArea;
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        if (geometryBounds ==
              null) {
            if (shape ==
                  null) {
                return null;
            }
            geometryBounds =
              normalizeRectangle(
                shape.
                  getBounds2D(
                    ));
        }
        return geometryBounds;
    }
    public java.awt.Shape getOutline() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+vcsr8rjb3thn3rlst+evOX2cXMHb/f2Zi655s/75ZEDf/53DuTcj+WJLlzy" +
       "Q6F7j87vvvIjLm87FJRuS+XuSeCUbdk1pxL/CraWPRUk5UOkQbTi3UFBTuIy" +
       "HYIYz0gHwRATZ9Vnx2tmcNKZcZgL3c7MMazbldl7ITxja3yudXmvOpzC+ZDO" +
       "sxb2eW7vFSD8oZeLnMfzlZhdmHYWlZquMtCSRl3+otanWwbnM9yHuUQzI3Wc" +
       "QMK4tT2bLhPzr2G2xey505Og3dkGnQ9plTXyKg+DtpsGYRbO1dtLmpEarndE" +
       "4GF6Wv2l3pGG1dJl0Y6vblFN2qLVlk6rPSy61nOKyjVdgmMrdU1QtU+n4JhA" +
       "KAF7zhhdryaVqJG2dV5mquJUTUBQLgL94jJds8Fl464CbUSOXGqpc6mHjaP2" +
       "rO3ONcZLGviFulKmT5i2YGnUpa70f0xJpzVgp4e6qq+6XtKAvUEVw4F9Pn21" +
       "AvVtgWQ1NX/z6Dvmq6+XNCPVGmd5tEunAhZFXLqOF6jrEkg91mg9HrpO+urq" +
       "Jc1IbQZbL21v8NE2ZY96QWZU/ldGXGctZ3hkb3gEd/VFXsdhfpQ/ceDw8Wj/" +
       "XavNLa8p+4jZoyQT9732n+c77vjjs3nOPJVM1S6U6RiVHWM24JBZm2wfvymw" +
       "d6y36m5995dt8fWFnFqwrGWacwn+vxiMWOm9b7tVefrAh/O3Xzm6u4ADyGIX" +
       "nO4uf9p377ObVoi3Bvm1iLmV5lynZAt1Zm+gVTplSV3ZnrWNLss+BKBD2GER" +
       "YIebtDbFXNzJhNZeoq4gNGA6dc5b3uttPlHqEcwOMVJhUMZ3I8M3hIqkPb55" +
       "eRKabHpn79H37zN56I6XXI3p1OHvf9lx82GTk+aV1bKcWyOnjHltxfVsMOH4" +
       "Ev4CkP6LCY3AAvyFqKjbujtZkrk8wUBSJ0v91OJDbPzr6clf3TN5MGiBMsVI" +
       "6ZgqRe0Ff8t07sk/AMaCLo2X/yAzr41YNw9SzJrXWOGU8BL1mfGf+dTdh9nd" +
       "wIa4xQZOIhuGk0WAga+MKyBpli1a4TB4iXqvjKt5r4/4YPEoZr/gOy1zx2lH" +
       "bUgeLAIkzViHwc5+y679hUPiJepj8VM+dU9jdgbQiOeicbWNxhPFIshySDdZ" +
       "Jt1UOBpeovkJkg5kZ2YC2U26oI1KorFmAx/sZR+kXsPsBTi+8IjHxZYXi4VP" +
       "B6QjlpFHCsfHS9R7Ab3Ce/2TDxDvYvYHiKwzx4RIHkTeKgIi/IiHB7O7LbPu" +
       "ngaRPOc7L1Efg//uU/cJZh8wMldSxgRZisL2tMk6cHTjodCFyofF4snlkE5b" +
       "pp0unCdeoh7rKOs+HKPFgeSIwVxxwZrIbnGqLfIXM4iYl0fAbDf7ntBNg6/v" +
       "eZ6HfRUYZ2aCLUeMCfGoFfVh3oDZMROhOx3PP2GkRLJeMGYrPCt7fHPoDd+r" +
       "//WhppKNEPz2koqkIl2XpL3R7ACw3EiOOBSyX3rxAqc2GLMwElgJ4QkvPufN" +
       "m0A5Fn4Krgh2oYjKXW7PGKiY7tjBmc+KwJmZWLcA0qPWxD9aOGe8RP197+zs" +
       "SwRuu+l9A00+eM3BrBYiGOs+zryU+MKbBuUjqipTQcnj4wKlqQy6gbpiobsI" +
       "0hsWRG8Ujq6XqLfnjnKgVviAeD5mS5n1ptnAF3VY0myj0VoENOZiXTuk9yyT" +
       "3iscDS9RH2Mv9qlbi1kHnC0g6olkX3ZxJG1AQsWiB14UfG5Z9XnhgHiJetIj" +
       "MJNbfpUPKusx62T8UwnXTYmTI+uKyJGAdSsZyLnqnBYST1Efi/t86vox22xy" +
       "ZCDPpZwNSG+xDpFLwZqEZVWicEC8RH2MHvKpuwazHYw0OAHJ3KTZcAwWix/n" +
       "gy2nLJtOFQ6Hl6iPyXGfOgmzEUYaAY5NuXfMNh5isegB+3fgYcuohwvHw0vU" +
       "x2bmUzeGmQqbC+DRn2T47YqLGNPeW38VIFKMVGY+5MA3kM05n4GZny6J9x+v" +
       "r5h7fMfr/GYz83lRDcSYsaQsO9+ROZ7LNJ3GJI5ejfnGTOPW3cDIrHyveiDe" +
       "hJxvo5NmyxthhbhbwqmR/zrbfQegstsxUmY+OJschN6hCT5OaekAqj3vG6cu" +
       "CKd1QWTpAy2ikzKDrgVORHlEOXu6iXBcWC/LujTkX+alw+ik+W3esHj6+Jat" +
       "15+99C7zUwZRFvbtw16qIXg2v6qwInfnnZ27t3RfZZvbz9U9ULk8fWfXaCps" +
       "03mBzTnSBfTVkATzXe/5jbbM6/43T6x7/IWpspeDJLCTBAQIuXfmvmdNaUmd" +
       "LNoZzj0kDAo6/wChs/1HE1euiv3j9/xNNjEPFQu92w+Lr5689pVbm0+0BEl1" +
       "L5khKTAh/AXwhgllGxXH9CFSKxk9KVARepEEOesEUod8FfCbPY6LBWdtphQ/" +
       "hGGkNfeaNffzoSpZHac6d03YDZxhqu0Sc2ZcV95JTXMJ2CX2ISxQgo/HUjgb" +
       "QNThcJ+mpa9tS7dpuF4DpfnDb8x/zB8xO/o/s0Cu67UrAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7efAz532Xfq/9+njj+H19xY4bO7ZjN3Hkvivt6sRNE0m7" +
       "Wh17SNpdHUsbZ+/70N5Sm8bJtCRDaQjgHMy0/is9yLhxhqGEaSeMoUCaaadM" +
       "oUAoQ5MBOqSUDM0MLRAD5dmVfuf7vj/bvG81s49Wz/n9fM/n0ivfLV0Mg1LZ" +
       "9+yNZnvRVSWLrpp2/Wq08ZXw6oioT4QgVOSeLYQhC/JekJ76yuU/e/0z+pUL" +
       "pTv40gOC63qREBmeG86U0LMTRSZKl49zMVtxwqh0hTCFRIDiyLAhwgij54nS" +
       "2040jUpPE4ckQIAECJAAFSRAneNaoNHbFTd2enkLwY3CdeknSwdE6Q5fysmL" +
       "Sk+e7sQXAsHZdzMpEIAe7sp/zwGoonEWlJ44wr7DfA3gz5ahlz7/4St/97bS" +
       "Zb502XCZnBwJEBGBQfjSPY7iiEoQdmRZkfnSfa6iyIwSGIJtbAu6+dL9oaG5" +
       "QhQHyhGT8szYV4JizGPO3SPl2IJYirzgCJ5qKLZ8+OuiagsawPqOY6w7hP08" +
       "HwC8ZADCAlWQlMMmt1uGK0eld59tcYTx6TGoAJre6SiR7h0NdbsrgIzS/TvZ" +
       "2YKrQUwUGK4Gql70YjBKVHr0hp3mvPYFyRI05YWo9MjZepNdEah1d8GIvElU" +
       "euhstaInIKVHz0jphHy+S/3wp3/cHbgXCpplRbJz+u8CjR4/02imqEqguJKy" +
       "a3jP+4nPCe/42qculEqg8kNnKu/qfPUnvveh5x5/7Td3dX7gOnVo0VSk6AXp" +
       "i+K9v/uu3rPt23Iy7vK90MiFfwp5of6TfcnzmQ8s7x1HPeaFVw8LX5v9s9WL" +
       "X1L++ELp0rB0h+TZsQP06D7Jc3zDVgJccZVAiBR5WLpbceVeUT4s3QneCcNV" +
       "drm0qoZKNCzdbhdZd3jFb8AiFXSRs+hO8G64qnf47guRXrxnfqlUuhM8pXvA" +
       "81Rp9ym+o9IU0j1HgQRJcA3XgyaBl+MPIcWNRMBbHRKB1ltQ6MUBUEHICzRI" +
       "AHqgK/sCLYkgRhd8hfJk5WquWv5fRKdZjuRKenAAmPyusyZuA+sYeLasBC9I" +
       "L8Vd7HtffuG3Lhyp/J4HUelxMM7V3ThXi3GugnGuHo1TOjgoun8wH28nP8B9" +
       "C9gx8HD3PMv82Ogjn3rqNqA4fno7YF1eFbqxo+0dW/6w8G8SUL/Sa19IPz7/" +
       "WOVC6cJpj5nTCLIu5c0nuZ878mdPn7WU6/V7+ZPf+bNXP/dR79hmTrngvSlf" +
       "2zI3xafOcjPwJEUGzu24+/c/IfzqC1/76NMXSrcD+wY+LRKADgJ38fjZMU6Z" +
       "5POH7i3HchEAVr3AEey86NAnXYr0wEuPcwox31u83wd4/LZcRx8Ez2ivtMV3" +
       "XvqAn6cP7tQiF9oZFIX7/ADj//w3f+ePkILdh5728onYxSjR8yesO+/scmHH" +
       "9x3rABsoCqj3778w+Vuf/e4n/3KhAKDGe6434NN52gNWDUQI2PzTv7n+t9/6" +
       "gy/+3oVjpYlAeItF25CyI5B5funSOSDBaD94TA/wDjYwplxrnuZcx5MN1RBE" +
       "W8m19H9ffqb6q//101d2emCDnEM1eu6NOzjOf2e39OJvffh/PF50cyDl0emY" +
       "Z8fVdi7vgeOeO0EgbHI6so//i8f+9teFnwfOEzis0NgqhQ8qFTwoFUKDCvzv" +
       "L9KrZ8qqefLu8KTyn7avE7OIF6TP/N6fvH3+J//wewW1p6chJ2VNCv7zO/XK" +
       "kycy0P3DZy19IIQ6qFd7jfrRK/Zrr4MeedCjBHxUSAfAvWSnNGNf++Kdv/+P" +
       "fuMdH/nd20oX+qVLtifIfaEwstLdQLuVUAeeKfM/+KGdcNO7QHKlgFq6BvxO" +
       "KR4pfl0CBD57Y//Sz2cRxyb6yPdpW/zEf/if1zCh8CzXCZ5n2vPQKz/3aO9H" +
       "/rhof2zieevHs2tdLphxHbeFv+T86YWn7vinF0p38qUr0n46NxfsODccHkxh" +
       "wsM5HpjynSo/PR3Zxd7nj1zYu866lxPDnnUux64evOe18/dLZ/zJvTmXHwXP" +
       "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" +
       "ySJdF3UxXTszaBuI6lTRwijMOGdVpkehpFMNvcfWaUGxOmsTSfCGFPfGcnW6" +
       "YP3OBjas7RgNtDk9G9gYvYwbxrIrLXoQEZustSwLdlo2rPICUcKB2SiPhKha" +
       "L7fbveaWS/lZPxGjtNpYD5canDTW6dBVXRcs7yNkpvJ8Im7bXJsjLBAC1KXQ" +
       "88MK4nS3rMt0VXZuddjtUoHqpiiSDaiGsI2sCQ0XYBGvoCOix3Y70yHgu5M4" +
       "MiVwjkxQHr81Kxba8RpQ2tNDqDrAqkpsJIjZhjKKMrFJfxq34bRMBPVGq+3P" +
       "RadSrnQxu0rULX3MglDTWaa6Ztt4thy0e31mnFnt8bwzU3wMo5UQ4zy51Vd7" +
       "4mTVILoLOfL1KaTjuEWpikCp6tZjfH4gSA25gqxQPtPXcYWRYF6at+sjdkmO" +
       "4N4SHjLZVPOgAWcC50mxujQqO77Qjpim7Mf9GuqrLiq2MmjbbWU05EFhpRc3" +
       "mlzQ6XQ+kG/nfO6t7ajdV2weHt02Me1mXvDxt7CTtCt6Mk+eOdpvLT53lM7c" +
       "UDix33ricKyU7449dqNLJMXO2Bc/8dLLMv0L1Qv7Q8W/EZXujjz/h2wlUewT" +
       "XeWnx++/8S4gWdyhOT7s+von/suj7I/oH3kLR/jvPkPn2S7/DvnKN/AflP7m" +
       "hdJtR0df19zuOd3o+dMHXpcCJYoDlz117PXY6WP0fP+f23OWO7uTfSy7629j" +
       "v28n+zNntgfHFfCiwivnHOp+OU9+KSrdFSoRc3QA9tdOqMpnotLtiWfIxzr0" +
       "y2+0G3lykCLji0egC5V6J3jUPWj11oA+ienXzyn7Wp78fYBX2+Mt2HSM7as3" +
       "ga0Q6AfA4++x+bdcoJOiwtfPAfiNPPnHxXlQdPYI8CvHOH/jJnA+kmfmh2ov" +
       "7nG+eOtl+C/PKftXefI7AKJ2LcTJMcR/frOifAY8P7uH+LO3VJSHBzoPHB15" +
       "4oHg64YUwmjR7lvnwP+PefL7Uelicah2Rq7/7mZB5+Wf34P+/C3X328XFb57" +
       "Drr/liffiUr3Hp0ST64D849uAmZxIp+f");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wv/iHuYvvlWYvTdU3/91TtnrefLfo9LDhpsItiELkYLvz5V7+Rn+Gah/erMS" +
       "bYPn1T3UV2+9Gp+JFbcBYeVtDi7emAUHl/KkBPQfOKmJVxgvlihudBgqj+Ef" +
       "HNwE/AfyzB8Az6/t4f/aX4gVP3T64kIBaGfHBw+ew4RH8uQyCEX7ez3h9dh5" +
       "p+h5tiK4xwy5crMMeQw839wz5Ju33ML5Atsz5+B+b548Ee3vUIf5FdQ859Fj" +
       "iE/eBMSH88xnwfOHe4h/eGsgnkRQPacMyZPnotL9IDhNTl90KdhzjPKHblaQ" +
       "+Uz8+3uU37/Vgjx4qIDzgXOgfjBPWlFxXf/MNYqT0mzfAmke7K8fHVxz/ejm" +
       "pTk8p2ycJ+hOmsx1Ltgco8RudlL8JCDY2aN0bj1K7pyyRZ5MotKVkyiPLsQc" +
       "Y5zerCTBaufgS3uMX7r1GIVzyqQ8+VGwTAYY8WuvcR2D/LGbFSQIOAdf3YP8" +
       "6q0H6ZxTlv/L4EAHrhWApOMo/0/CGREabwVdBhbnRxfx81vFj1zzN57dX0+k" +
       "L798+a6HX+b+TXEX/ejvIXcTpbvU2LZPXgI98X6HHyiqUQC+e3cl1C9QJFHp" +
       "wetdaQSTC5AWwSLe1dwAnT1bE0yMi++T9X4CsOS4XlS6Y/dyssrHQO+gSv76" +
       "on8Y2Z+97s3KjhhGgSBFh3P2nDvZbjbwyEm9KKZv978Rw09snbzn1IZH8c+q" +
       "w82JePffqhekV18eUT/+vcYv7G7PS7aw3ea93EWU7txd5C86zTc4nrxhb4d9" +
       "3TF49vV7v3L3M4ebMffuCD7W0RO0vfv6V9Uxx4+Ky+Xbf/Dw3/vhX3r5D4qL" +
       "Yf8Psgn1g/I2AAA=");
}
