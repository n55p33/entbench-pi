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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7efDj1n0ffyutjrWsXV2WrFiyJEuxZSgLEjxAVnFskiBx" +
       "EAdJgASBJpZBHASIkzhIEIli2TOpPU3juq18dCbRX85Rj2J5Ok3dScYdtWnr" +
       "eJJJJ23auuk09rTN1KnraTzTpK3dNn0A+Tt39yepu+EMHsH3vu+97+d7vZOv" +
       "frd0MQpLUOA724Xjx1f1NL66dOpX422gR1cpuj5UwkjXuo4SRQLIe0F96suX" +
       "/+wHnzavXCjdIZceUDzPj5XY8r1orEe+s9Y1unT5OLfn6G4Ul67QS2WtwEls" +
       "OTBtRfHzdOltJ6rGpafpQxZgwAIMWIALFuD2MRWo9HbdS9xuXkPx4mhV+unS" +
       "AV26I1Bz9uLSk6cbCZRQcffNDAsEoIW78t9TAKqonIalJ46w7zBfA/gzEPzy" +
       "5z585e/eVrosly5bHp+zowImYtCJXLrH1d25HkZtTdM1uXSfp+sar4eW4lhZ" +
       "wbdcuj+yFp4SJ6F+JKQ8Mwn0sOjzWHL3qDm2MFFjPzyCZ1i6ox3+umg4ygJg" +
       "fccx1h3Cfp4PAF6yAGOhoaj6YZXbbcvT4tK7z9Y4wvj0ABCAqne6emz6R13d" +
       "7ikgo3T/TneO4i1gPg4tbwFIL/oJ6CUuPXrDRnNZB4pqKwv9hbj0yFm64a4I" +
       "UN1dCCKvEpceOktWtAS09OgZLZ3Qz3fZH/3UT3qEd6HgWdNVJ+f/LlDp8TOV" +
       "xrqhh7qn6ruK97yf/qzyjq9+8kKpBIgfOkO8o/nKT33vQ889/vpv7Wh+6Do0" +
       "3Hypq/EL6hfm9/7eu7rPtm7L2bgr8CMrV/4p5IX5D/clz6cB8Lx3HLWYF149" +
       "LHx9/M+kl76of+dC6RJZukP1ncQFdnSf6ruB5eghrnt6qMS6Rpbu1j2tW5ST" +
       "pTvBO215+i6XM4xIj8nS7U6RdYdf/AYiMkATuYjuBO+WZ/iH74ESm8V7GpRK" +
       "pTvBU7oHPE+Vdp/iOy6NYNN3dVhRFc/yfHgY+jn+CNa9eA5ka8JzYPU2HPlJ" +
       "CEwQ9sMFrAA7MPV9wWIdw7ypBDrra/rV3LSCv4hG0xzJlc3BARDyu866uAO8" +
       "g/AdTQ9fUF9OOr3vfemF375wZPJ7GcSlx0E/V3f9XC36uQr6uXrUT+ngoGj+" +
       "wby/nf6A9G3gxyDC3fMs/xPURz751G3AcILN7UB0OSl840DbPfZ8sohvKjC/" +
       "0uuf33xs+tHyhdKF0xEz5xFkXcqrD/M4dxTPnj7rKddr9/Invv1nr332Rf/Y" +
       "Z06F4L0rX1szd8Wnzkoz9FVdA8HtuPn3P6H82gtfffHpC6XbgX+DmBYrwAZB" +
       "uHj8bB+nXPL5w/CWY7kIABt+6CpOXnQYky7FZuhvjnMKNd9bvN8HZPy23EYf" +
       "BA+1N9riOy99IMjTB3dmkSvtDIoifH6AD37hG7/7x9VC3IeR9vKJsYvX4+dP" +
       "eHfe2OXCj+87tgEh1HVA9+8/P/xbn/nuJ/5yYQCA4j3X6/DpPO0CrwYqBGL+" +
       "md9a/dtv/uEXfv/CsdHEYHhL5o6lpkcg8/zSpXNAgt5++JgfEB0c4Ey51Tw9" +
       "8VxfswxLmTt6bqX/+/IzlV/7r5+6srMDB+QcmtFzb9zAcf47O6WXfvvD/+Px" +
       "opkDNR+djmV2TLYLeQ8ct9wOQ2Wb85F+7F889re/pvwCCJ4gYEVWphcxqFTI" +
       "oFQoDS7wv79Ir54pq+TJu6OTxn/av07MIl5QP/37f/L26Z/8w+8V3J6ehpzU" +
       "NaMEz+/MK0+eSEHzD5/1dEKJTEBXe5398SvO6z8ALcqgRRXEqIgLQXhJT1nG" +
       "nvrinX/wj37zHR/5vdtKF/qlS46vaH2lcLLS3cC69cgEkSkNPvihnXI3d4Hk" +
       "SgG1dA34nVE8Uvy6BBh89sbxpZ/PIo5d9JHvc8784//hf14jhCKyXGfwPFNf" +
       "hl/9+Ue7P/adov6xi+e1H0+vDblgxnVcF/mi+6cXnrrjn14o3SmXrqj76dxU" +
       "cZLccWQwhYkO53hgyneq/PR0ZDf2Pn8Uwt51Nryc6PZscDkO9eA9p87fL52J" +
       "J/fmUn4UPO/du9p7z8aTg1Lx8sGiypNF+nSevPfQfe8OQj8GXOra3oP/HHwO" +
       "wPN/8ydvLs/Yja33d/cD/BNHI3wAxqGLUT7kFLUfikv3FgalbPYj0S6g5SmS" +
       "Jx/a9VK/ofn8pdPg3gee5/bgnrsBuMENwOWv3UJiWFy6p2ByqBTTz0Nen7zx" +
       "CLqnPMM+/ebZv+eQ/cqe/coN2BduqJs7g9BaAykfYrgMfrsgsq/1jp94WnQI" +
       "451HIl/ovgvmkSowqYWjI9gZ9idvkf3cnBp79hs3YP/D50h/dsj5vTljehxu" +
       "d4znufIZ3l74/xDt83venr8Bb/qb4e1ypHvRCalejznjLTL3OHj2pLvv6zDn" +
       "vBnm3hYUdqi1Q13Js/AzjLlvkbEnwNPbM9a7AWPRm2Hs7UdSuxFr8RuyVjSV" +
       "HgBLv4hcRa+W89/Z9Tu/LX99H5htRMXyFtQwLE9xDrl5eOmoTx9GpylwcDBU" +
       "PL100EMPuVJ4SB6Ur+7WiGd4xd40r2AUu/e4MdoHy82f/U+f/p2//p5vgqGG" +
       "Kl1c58MAGGFO9Mgm+Qr8r7z6mcfe9vK3fraYPAFpTl965jsv5a3+zHmI8+Sn" +
       "8+Sjh1AfzaHyxUqDVqKYKeY7ulagPXeEHR4Gj93SEX7x/m/aP//tX90tHc8O" +
       "p2eI9U++/Ff//OqnXr5wYsH+nmvWzCfr7BbtBdNv30s4LD15Xi9Fjf5/fu3F" +
       "3/iVFz+x4+r+08vPnpe4v/qv/8/vXP38t75+nfXQ7Y5/E4qN7/snRC0i24cf" +
       "eqroyEZNx67BZTG0htntzEYtro0TtS7XGVE9LJ3hasrZ9XWkUNR4S0atxpxD" +
       "oGaMrqMs9rwJy4xiKZj3x2OfZNtuQ4A65c6IVOz+SHTaI9/v1HgsG/jb6shZ" +
       "0dtBtzKeKguSNhAImVfna/BgUyOgmaqquwoElqBoJkIQJMoICiNShnXKZZuc" +
       "VqKey4pBudVdRGSywJezOb1w+5GJUmZz1qWaTEtDEag17C0Hpr3UVjhWtiSq" +
       "w5aDydIMMJnCbbyXjsZ4EAUCP+iZuIY7I6Nft+yBzdqxK5Sp5VjuWTPQixSw" +
       "5mLSwjpBv7MUArln+2hF7NQ2YFbEuKRSp1ZMrFXHtssqg5WghaybVtkkLVcQ" +
       "jDKXyGRTNjGdrG1on+eFer8jMY7p8ZY6UwZ+E5e1acXuCyHODdes0pV6cW0+" +
       "qvXCETwxqiFSwxeYiXRdv7tY1SBJRhqWuU2YMm7NK5rrDoXOENf0ET4xSbci" +
       "ofiS5vvlGodLbHuEUSuk4tb6SKzxlOz509Cu02xFcHnFGvmbKNPrvV51ZEqz" +
       "iVATAgwomImCMr1ApzQTK8o0USSdjfr+hCO0bNZck8IEq/cb/Nhpa5PxaBH1" +
       "FqNN2xekdFTVrcHYdcoWNloxrI1NKbUnakGYzXiBVCfTBT81oZjbSHif9zPf" +
       "KDelQd3sR+U6Y01gkdGFPjfgEhgX+rJFcrGKpHNhFFWlpS2JXbEjeQHTZusy" +
       "uZoubZNyZLo/J112iWT6oi1ZIrVdzKcCizm83+1TbdfeDrY+M8ba5XaLGtVZ" +
       "uWG2RxQyhuSGRgJsJFmjVGHFLAm+YtXNaXmw4tu1nrVkUoSFmNaGz1itifBS" +
       "tQZVwzCpJ8k0m6xGnR7mDTpTp0I3FbMfqKM49pecP6n4vUCkma1BR5s6SgRk" +
       "lxiBgBVGmufWREhLxGC6hRwvwyS6GQoB0XKwsSBFhAkFOuKYGrx2KMXETUVS" +
       "enYdcpJp05mIkRs1Jh2z7gormQi5lJzWUb0VJGGrjtjEZkpN+WbQq0zq7qit" +
       "s1KwGgWsvXIhqxtP+uMV1wooclUW63q1vB7UBDsaaKMIleA+xgQNXvEYqxlM" +
       "4GWr3SeZpDcgVzqlTFwqgCqLEbINWgJu4TbRGQQLbTzIMBjaNhfVUYNdLXyp" +
       "N5m27fGo0tc6s5gFZqNOpDbSIkZdugPROO/z47KP9+mK3lu0CT/lV1sSymwS" +
       "82sUHtfIZcPurBR15rOkKGbUhuy0MdvUaw4dDVfIIBtMFH9o1XS+UV1zVQxu" +
       "ej0bBIdtv80zMdNrENykRhANFUsTj1z2mG5bQ1t0Jxt6WKttbDKREZa8u1Y6" +
       "CmpEQAtxW6f8XmPSJgQ5zrRglCTVvreejzbQAMzrVy2+1dJhkR85pEzZ2+42" +
       "6GJLOO46aZPILHwo1lYbeaFU8dbapIlOzQBBXeuL9oQgG7M6qjVWU4xYSagD" +
       "bGjbojB9WcUcc55WF2jWsFtsVWA3NYhD6IXFS6g+Trcdb+FV2k3g2fVajZ5X" +
       "yQidoXCl00LhFivEk8aqldEssjSAZ205ig35Rlfv4nLFVJPJuKYMrXQlSJy+" +
       "FWsSP29Hi96wApE62UxobSC1mDjg26M5McXK5rZvTdPQGizBHN/sV7uu5pEe" +
       "onZoJUhFncD6bqI1p1DkKaw5jDWbWdOMPJpVob7KKD3D0Ic4ZmWe2lARsxri" +
       "IVbBxMasQyJ9W9AyhGVdpNqoj7sJaiTWMNvEfnOIcrxqjuc0MBnJ9Owq1x1I" +
       "Ix+rJ82W2oIkdJ62YFZcZh6Dc15n29l0lSkzpmleFoe2gCldJzJUfLENiRbo" +
       "JOI6xiJI+bE5Hii1iG74MxRt+HNYq+LYFowyPEtWRG8eYUk10/WQXidTxIiN" +
       "TtK2qGSFya62HAp8EyrrEMprYo9vTZYaNBxYXL0pLv0B3ElbIU9EgVZPelIZ" +
       "qwWDqtNy4F6zHKuarJlxnG7sZQs1BLvrIURaGyRGpV2HmuuFHLoVpA7wNrJ6" +
       "p5EJgam5gz4xgisQorKLNT6gebQ+FEQlDe0yopvplvAnI76qrIWw1ukLorrd" +
       "iFHTh1tlQWiiMjwlqa5Ys6dzcjXG1IFB4WPebVfZybzjKko5rLQcIan3OuKI" +
       "rfZ5EKdSrj0aNLkhPGnxo3IaETrUXKqdlq5xQwmR647bCvH2tq4vjSa8XS0z" +
       "KDYNZDtVEwhCKBFpGAxhbDS3ta4HVAiHqUHEHlyvwt6IQVsihfobEKn7dFjd" +
       "DrNkkMFWM5Sxke4iU66hd3qo7DiVjFnjawlfy5Nynx/aI2XcXevEWLCpLiqQ" +
       "0jJdEqMRhvXTqVdB1riEU/WybKLeCFU36gYNNHdenm2WHJImmuLA+mqzdVUM" +
       "spsKght1WNbbKmnooUfqQmpYmttXRG280u1Ve1sJKtxkrXhIQ561oU0Vkfhs" +
       "lE0ilaJ6qYSgwwAEexh35XlG1dDhyFM8sTqC5I4o8ty6uQSrIcQeyUlfXc8R" +
       "G1c8U7fVHrFSvMoUXhGiI9HTsogay1U/Fm16GsSNuaBsGlQ4VHR/xjIOR8t8" +
       "ZTOeQtXRYLlwe70Q85bssKI4Awp3nXkdEd2BjU47bcEh4/aajpkKXtkgqBWO" +
       "xolABrLUcKqhxOHhEEnqqoRu7cUU8gfIrBHgNu3YstawQzitj8vigkX0lRVC" +
       "qzCkRlUJr4xSgl165YoaTtimyPdloZnpw3XCQZAXUExlEKuyTCTV0UrqE71A" +
       "j3uLuZ+AuL5cavOlryeTsFHXy342kYF3l4EWCaQitFaLmdybOwYy62mavDVt" +
       "AzFtbTOtwLY2ztwx7C2hTVOz4LkRa6HaDFbbZX3R4pdUWkXWsD5Hl8tlE3Ih" +
       "g5mAEQ2dDOSlM5QZUcKwwK1sjXnqbig0ra5CNJarRssWZxWYXI1mtBjVUzoi" +
       "4H6NGQ/QanU+V1cCBMPqEEUGZa3ar7bbor7tlltVR4DXiTGbC901IZJ0U2Tm" +
       "Bu9xyWQ+IDi0jZT5lRqt+PU8QudjWXOJNjEiue2mixJdobJSJCtL5DIb0JWO" +
       "2OvYWy/zPFpHqyxV9ltL1umMLZ/Zrs1EHlr4hMLLaaauwSxREHSIIWYePAw4" +
       "AvWWVEU2OQIOISctV4mMrCvTukyrSZ2d0QOX1cQZ08R7tdq6xjfbjTkklduL" +
       "aNOHSCtcxUmdcVw1ErDuuBLF4yEtoL00hHR3HU6HU4ZYmJJfrm0ny1XMV/ro" +
       "Jq5n9NAA04D+chQYxJZABDceE2HdxgeiwSiD+oafrUiIgWuZh4YoQ0dzpNOt" +
       "IkyHkhl24y8WmyY1TTu8wEb2JCTa0nqiQ1NVmK1b455Bd9A+2tGaATJLOA4h" +
       "MdXFxlLXxvVog7COh8zFtdqzmmOiHBnRykNdjxEWjNKcbsphOB/rA0rq9G2u" +
       "wc/pgIoG4yZLs1irU/aJKOttFknZnsX9PsWyclQjuRZKDidK3Wq1GXVGrPEa" +
       "MqSsyMCCBSFIzJra1AyzZs38td/XamEV3oLxXMuGtbY9m7luB6MWTXM+nnR7" +
       "BExsJEKpytpcq5fbdgZ7HN8SiBoNoxUC6SIjnckocaJOcNEP2635nOQItlIb" +
       "ELzZdPFUJ8h60OdERVEH9Zo7WzFqYxv6wxQxUxJzLKavqVFX2Yr1NLHgrI91" +
       "abc+7m2QJgJRVUGocTHqJZo528xAuHEW2xQoaJmuxjNEYpEOUukJvhAZmZAu" +
       "AlvZzJasPciavl5N08YGNlZGFdmsxNGyQ0OtoDsIeFZ1FLFZ5jbtiK2TS8yf" +
       "RU6l0dyAxUpqbZlOX+7qzIDOqmFGOV3OlKHuoEZpgwG1dVpRhlkrl6vKm3rI" +
       "WCouuRULabcGi0pTaoqZaa8nMxis+dZozyfmcy80RhQznHnMZlWbkGm4GjLb" +
       "prNed92R4ZKrKJhMhnQt6XWCgc8m/qAuNbqNbouU+uVx0vehyGkkSN1Pt35f" +
       "qC08H5YnrtJShPlmPEZElo39uCN1lnNHqoCAP1QTu7UJiE15PUlbFg2CuyjF" +
       "UkfeJKRu0bJTKav8OBlNaMJfjNW+V4lFY1qrkf2G5a1HZMbx4gwSsa0XMpzp" +
       "wVOGqkwg2t7SvqVa40V14uPqqtbINmBW27CG6awMaQYizQWpzgSYN4lqeEBr" +
       "ktm0HKlX7UZWMOa6Hd1f1nEM9iYzaShjtqR4ZMeex1TEtRU6leBsIyuCY5e9" +
       "bs3Actuq0+bQkwS52+XYNqO7VSx28Q2UikO+DQvrTYTPJpvabFkDHillw2w1" +
       "XhMCOWM7BuYLGd3Uoml/SQx1sdqckv0BM8UlqM60qzZTrns1XPa2DaqVQmFY" +
       "N9E5Y4QwLmXNqgOmBrwUKaOIa0FjTkZplqriFJkP8h4ucEOxqmJkSGzXuoXp" +
       "JpWu/QrrbtPYNOfmfLMC4TsL58ZIX0RxlE5cCeKoSF2wDbMr1DkFsturZXWN" +
       "N9SkO9AqI1EI2lvEsrMBFi6m3JhwepwRqz0Ir0X9hqiJHrluprTZ6lPNVtKU" +
       "DGIS8ZV5mLWyxrTqBputRXOZZqGVyQjuRIYzNcc6ynFZXJ2DEWK7VKpeo4L6" +
       "BFWHokZSngpSsGa6bpWzu5AVkiPPTVpohiOIXIEra8KBq1B7Lch8k+DFttcd" +
       "LUZqAjOGCinlgGyI81HmETGJd8ZleNHvynAypFYttW+sCRR253Oc1Aem3IjT" +
       "pjjLKinKJ1XWbK27Mr2aLSls4na6oP0FJg8HrLXiGmXOni6pxmTVtlpdklJj" +
       "iQraaH2QtKt6upl1m6gidB2oy7CkAtUqCgQmNhVxy9n9ChqsNni2xKZs5NSj" +
       "bS0Mt4KbSHzUW0ejirXodKBh4LWRxWCJ1YQ6y1fguePXg6RfwwLDw+bNFM46" +
       "zZSDSdiKtzQRTsJ2u/2BfDvns29tR+2+YvPw6LbJ0kHzgo+9hZ2kXdGTefLM" +
       "0X5r8bmjdOaGwon91hOHY6V8d+yxG10iKXbGvvDxl1/RuF+sXNgfKv6NuHR3" +
       "7Ac/4uhr3TnRVH56/P4b7wIyxR2a48Our338vzwq/Jj5kbdwhP/uM3yebfLv" +
       "MK9+Hf9h9W9eKN12dPR1ze2e05WeP33gdSnU4yT0hFPHXo+dPkbP9/8ne8lO" +
       "zu5kH+vu+tvY79vp/syZ7cExAV4QvHrOoe6X8uSX49JdkR7zRwdgf+2EqXw6" +
       "Lt2+9i3t2IZ+5Y12I092UmR84Qh0YVLvBI+xB23cGtAnMf3GOWVfzZO/D/Au" +
       "9ngLMR1j+8pNYCsU+gHwBHtswS1X6LAg+No5AL+eJ/+4OA+Kzx4BfvkY52/e" +
       "BM5H8sz8UO2lPc6Xbr0O/+U5Zf8qT34XQFxcC3F4DPGf36wqnwHPz+0h/twt" +
       "VeXhgc4DR0eeeKgEpqVGCFbU++Y58P9jnvxBXLpYHKqd0eu/u1nQefnn9qA/" +
       "d8vt91sFwXfPQfff8uTbceneo1Pi4XVg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/vFNwCxO5PNT+F/aw/yltwqz+4bm+7/OKftBnvz3uPQwmOkqjqUpsY7vz5W7" +
       "+Rn+Gah/erMabYHntT3U1269GZ8ZK24DysrrHFy8sQgOLuVJCdg/CFJDv3De" +
       "3lr34sOh8hj+wcFNwH8gz/wh8Pz6Hv6v/4V48UOnLy4UgHZ+fPDgOUJ4JE8u" +
       "g6Fof68nup4475z7vqMr3rFArtysQB4Dzzf2AvnGLfdwucD2zDm435snT8T7" +
       "O9RRfgU1z3n0GOKTNwHx4TzzWfD80R7iH90aiCcRVM4pq+bJc3HpfjA4DU9f" +
       "dCnEc4zyR25WkflM/Pt7lN+/1Yo8eKiA84FzoH4wT5pxcV3/zDWKk9ps3QJt" +
       "HuyvHx1cc/3o5rVJnlM2yBNsp03+OhdsjlH2bnZS/CRg2N2jdG89ysk5ZWKe" +
       "DOPSlZMojy7EHGMc3awmwWrn4It7jF+89RiVc8rUPPlxsEwGGPFrr3Edg/yJ" +
       "m1UkGHAOvrIH+ZVbD9I9pyz/l8GBCUIrAMklcf6fhDMqtN4KuhQszo8u4ue3" +
       "ih+55m88u7+eqF965fJdD78y+TfFXfSjv4fcTZfuMhLHOXkJ9MT7HUGoG1YB" +
       "+O7dldCgQLGOSw9e70ojmFyAtBgskh3lFtjsWUowMS6+T9L9FBDJMV1cumP3" +
       "cpLko6B1QJK/vhQcjuzPXvdmZXsexaGixodz9lw66W428MhJuyimb/e/kcBP" +
       "bJ2859SGR/HPqsPNiWT336oX1Ndeodif/F7jF3e351VHybK8lbvo0p27i/xF" +
       "o/kGx5M3bO2wrTuIZ39w75fvfuZwM+beHcPHNnqCt3df/6p6zw3i4nJ59g8e" +
       "/ns/+suv/GFxMez/AaKqcJfyNgAA");
}
