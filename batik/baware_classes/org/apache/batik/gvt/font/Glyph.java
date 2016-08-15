package org.apache.batik.gvt.font;
public class Glyph {
    private java.lang.String unicode;
    private java.util.Vector names;
    private java.lang.String orientation;
    private java.lang.String arabicForm;
    private java.lang.String lang;
    private java.awt.geom.Point2D horizOrigin;
    private java.awt.geom.Point2D vertOrigin;
    private float horizAdvX;
    private float vertAdvY;
    private int glyphCode;
    private java.awt.geom.AffineTransform transform;
    private java.awt.geom.Point2D.Float position;
    private org.apache.batik.gvt.font.GVTGlyphMetrics metrics;
    private java.awt.Shape outline;
    private java.awt.geom.Rectangle2D bounds;
    private org.apache.batik.gvt.text.TextPaintInfo tpi;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    private java.awt.Shape dShape;
    private org.apache.batik.gvt.GraphicsNode glyphChildrenNode;
    public Glyph(java.lang.String unicode, java.util.List names, java.lang.String orientation,
                 java.lang.String arabicForm,
                 java.lang.String lang,
                 java.awt.geom.Point2D horizOrigin,
                 java.awt.geom.Point2D vertOrigin,
                 float horizAdvX,
                 float vertAdvY,
                 int glyphCode,
                 org.apache.batik.gvt.text.TextPaintInfo tpi,
                 java.awt.Shape dShape,
                 org.apache.batik.gvt.GraphicsNode glyphChildrenNode) {
        super(
          );
        if (unicode ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (horizOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (vertOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          unicode =
          unicode;
        this.
          names =
          new java.util.Vector(
            names);
        this.
          orientation =
          orientation;
        this.
          arabicForm =
          arabicForm;
        this.
          lang =
          lang;
        this.
          horizOrigin =
          horizOrigin;
        this.
          vertOrigin =
          vertOrigin;
        this.
          horizAdvX =
          horizAdvX;
        this.
          vertAdvY =
          vertAdvY;
        this.
          glyphCode =
          glyphCode;
        this.
          position =
          new java.awt.geom.Point2D.Float(
            0,
            0);
        this.
          outline =
          null;
        this.
          bounds =
          null;
        this.
          tpi =
          tpi;
        this.
          dShape =
          dShape;
        this.
          glyphChildrenNode =
          glyphChildrenNode;
    }
    public java.lang.String getUnicode() { return unicode; }
    public java.util.Vector getNames() { return names; }
    public java.lang.String getOrientation() { return orientation;
    }
    public java.lang.String getArabicForm() { return arabicForm; }
    public java.lang.String getLang() { return lang; }
    public java.awt.geom.Point2D getHorizOrigin() { return horizOrigin;
    }
    public java.awt.geom.Point2D getVertOrigin() { return vertOrigin;
    }
    public float getHorizAdvX() { return horizAdvX; }
    public float getVertAdvY() { return vertAdvY; }
    public int getGlyphCode() { return glyphCode; }
    public java.awt.geom.AffineTransform getTransform() { return transform;
    }
    public void setTransform(java.awt.geom.AffineTransform transform) {
        this.
          transform =
          transform;
        outline =
          null;
        bounds =
          null;
    }
    public java.awt.geom.Point2D getPosition() { return position;
    }
    public void setPosition(java.awt.geom.Point2D position) { this.
                                                                position.
                                                                x =
                                                                (float)
                                                                  position.
                                                                  getX(
                                                                    );
                                                              this.
                                                                position.
                                                                y =
                                                                (float)
                                                                  position.
                                                                  getY(
                                                                    );
                                                              outline =
                                                                null;
                                                              bounds =
                                                                null;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics() {
        if (metrics ==
              null) {
            java.awt.geom.Rectangle2D gb =
              getGeometryBounds(
                );
            metrics =
              new org.apache.batik.gvt.font.GVTGlyphMetrics(
                getHorizAdvX(
                  ),
                getVertAdvY(
                  ),
                new java.awt.geom.Rectangle2D.Double(
                  gb.
                    getX(
                      ) -
                    position.
                    getX(
                      ),
                  gb.
                    getY(
                      ) -
                    position.
                    getY(
                      ),
                  gb.
                    getWidth(
                      ),
                  gb.
                    getHeight(
                      )),
                java.awt.font.GlyphMetrics.
                  COMPONENT);
        }
        return metrics;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(float hkern,
                                                                     float vkern) {
        return new org.apache.batik.gvt.font.GVTGlyphMetrics(
          getHorizAdvX(
            ) -
            hkern,
          getVertAdvY(
            ) -
            vkern,
          getGeometryBounds(
            ),
          java.awt.font.GlyphMetrics.
            COMPONENT);
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        return getOutline(
                 ).
          getBounds2D(
            );
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (bounds !=
              null &&
              org.apache.batik.gvt.text.TextPaintInfo.
              equivilent(
                tpi,
                cacheTPI))
            return bounds;
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        java.awt.geom.Rectangle2D bounds =
          null;
        if (dShape !=
              null &&
              tpi !=
              null) {
            if (tpi.
                  fillPaint !=
                  null)
                bounds =
                  tr.
                    createTransformedShape(
                      dShape).
                    getBounds2D(
                      );
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                java.awt.Shape s =
                  tpi.
                    strokeStroke.
                  createStrokedShape(
                    dShape);
                java.awt.geom.Rectangle2D r =
                  tr.
                  createTransformedShape(
                    s).
                  getBounds2D(
                    );
                if (bounds ==
                      null)
                    bounds =
                      r;
                else
                    bounds.
                      add(
                        r);
            }
        }
        if (glyphChildrenNode !=
              null) {
            java.awt.geom.Rectangle2D r =
              glyphChildrenNode.
              getTransformedBounds(
                tr);
            if (bounds ==
                  null)
                bounds =
                  r;
            else
                bounds.
                  add(
                    r);
        }
        if (bounds ==
              null)
            bounds =
              new java.awt.geom.Rectangle2D.Double(
                position.
                  getX(
                    ),
                position.
                  getY(
                    ),
                0,
                0);
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        return bounds;
    }
    public java.awt.Shape getOutline() { if (outline ==
                                               null) {
                                             java.awt.geom.AffineTransform tr =
                                               java.awt.geom.AffineTransform.
                                               getTranslateInstance(
                                                 position.
                                                   getX(
                                                     ),
                                                 position.
                                                   getY(
                                                     ));
                                             if (transform !=
                                                   null) {
                                                 tr.
                                                   concatenate(
                                                     transform);
                                             }
                                             java.awt.Shape glyphChildrenOutline =
                                               null;
                                             if (glyphChildrenNode !=
                                                   null) {
                                                 glyphChildrenOutline =
                                                   glyphChildrenNode.
                                                     getOutline(
                                                       );
                                             }
                                             java.awt.geom.GeneralPath glyphOutline =
                                               null;
                                             if (dShape !=
                                                   null &&
                                                   glyphChildrenOutline !=
                                                   null) {
                                                 glyphOutline =
                                                   new java.awt.geom.GeneralPath(
                                                     dShape);
                                                 glyphOutline.
                                                   append(
                                                     glyphChildrenOutline,
                                                     false);
                                             }
                                             else
                                                 if (dShape !=
                                                       null &&
                                                       glyphChildrenOutline ==
                                                       null) {
                                                     glyphOutline =
                                                       new java.awt.geom.GeneralPath(
                                                         dShape);
                                                 }
                                                 else
                                                     if (dShape ==
                                                           null &&
                                                           glyphChildrenOutline !=
                                                           null) {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             glyphChildrenOutline);
                                                     }
                                                     else {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             );
                                                     }
                                             outline =
                                               tr.
                                                 createTransformedShape(
                                                   glyphOutline);
                                         }
                                         return outline;
    }
    public void draw(java.awt.Graphics2D graphics2D) {
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        if (dShape !=
              null &&
              tpi !=
              null) {
            java.awt.Shape tShape =
              tr.
              createTransformedShape(
                dShape);
            if (tpi.
                  fillPaint !=
                  null) {
                graphics2D.
                  setPaint(
                    tpi.
                      fillPaint);
                graphics2D.
                  fill(
                    tShape);
            }
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                graphics2D.
                  setStroke(
                    tpi.
                      strokeStroke);
                graphics2D.
                  setPaint(
                    tpi.
                      strokePaint);
                graphics2D.
                  draw(
                    tShape);
            }
        }
        if (glyphChildrenNode !=
              null) {
            glyphChildrenNode.
              setTransform(
                tr);
            glyphChildrenNode.
              paint(
                graphics2D);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z27R2RbuLRbHsiNs0W52i3c9/wu987hUEDwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gydFtj8ZjdyuVl9z1qSidI12n6nmK4rXcrPPr3A3NdKNPsmWkAi3VctdtKIG" +
       "ajN5f81NuoLMkWIeZEMrWSiCuwhloJX1os8KgRwP2SGczCk6dPK06XBUjkAt" +
       "M5SU6ZiS/UZtEvdRc1FrS8vJzM34xGkupgRdpUdtTSErqwUTdTbN3nLda6iJ" +
       "J4/WchturahBXyERrsJrbs7Ckp6t5BXHaaavTHi1E1HjjdTqqM0m3RtJIsdX" +
       "2BYKZKczHKErXds2Oc231+02r1ZgrrV2HNi0luGQMFxnTkaEO2o2BUsZYFA3" +
       "iwfSYpHNapKGQbQF4VK1upyl0nDkNpzcH3Q6JLRIG0ta6iXtWHXX6wFhtv2o" +
       "g8zSti5D9ZEjikOzvskMhcD9cgUiymxUiSa6Uasikw7jbkZUaLTTRV/vDWEo" +
       "nXjTSYpIzcZMmoVgMDpoL/YVyk1UiodrPWEzgti8j5D2pluHUmalS1ENEapB" +
       "WcC8mjCchEPapLFKk192pcpk0GV6YXvZ5YaSSNXcZKm6aSWpUUrcIThP9qZO" +
       "vAZDeJgMjJHYsaRQm5VJ1OnKDbu9JKNUmUqjuExUTHWmGCLqW6O8aRPjZqLM" +
       "1iykULlaQydx0tfEtih1fAl1vRYH+TTTsTVRayA9vt6JxnWOxidxAxhDBd1k" +
       "aYPE3IEaW6v2oGvVWzLTx72mS/REdg7Hca6aNW8xHik21xoJEDKb9ntELNFj" +
       "MexnfQunZilULlNdvoO7YIMxmA1HTd2UPdsY9uVFbnbbdWkdWPbMbnP2jM1r" +
       "TLNjcJ7daOBNaa3MJpG1qJc1heCJYMn1DDjnF42eryR1yBaphQ4hsILxrc14" +
       "2tIJdAnTLIoJXc4XqL4JD3Mn6DtLWhs3yqjZiQxCBb5rnjlsLfeITm+GSEEQ" +
       "cs1FRrvQsMIvI26QayQmpCrGR+S8vcDKOkW2hqMAYqZJvb5SLRZ368JyoDMo" +
       "Md6Y3BgMy0EyqtWGxCatElAnW8AoROOrDZFtxB6NpPE8Q1gsNcmBp7J0ZJJl" +
       "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" +
       "Wa1VjQXKRCUgsVyNh3CnOJE2FTToybEJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "C0X284BkfITktubJsJRVYM8PiX/wah1rEYL2jT3xb1x7xX7yjLJfK7KP7cYl" +
       "e+SFvCNu9R9erV6L4P/v7Ol955rrldjy+NQZHD9dZP8YcIyPcTz30UOOv3W1" +
       "Y7PY2X1/z/H7116Fnzuj7PNF9q+S0u0HvudIdOm/OKT4mWtA8dx+V7v7vHqK" +
       "57cVzhdftyHdj20J/f4ZZP99kf3eM5L94lWQvbe4+SqA+4V7si+89vr82hll" +
       "f1hkXy2CEgFFPSiii3NyGwtb1P7iIclnDOF8JpIPA7wP7Ek+cO1JfvuMsu8W" +
       "2X/b+Z0duV0g7xF6f3y1yx1gteeoPT3q2tP7yzPK/leR/c/d+QBzJLj6kN2f" +
       "Xq1XLQOg/p6df23Y7b3q9vvdyf4d4yLk+uCVSqRVtDt/3enMz99UQP0rMEfO" +
       "I3W9PO5lf3glnLOkdMN2hBevO9/3tH8xsvu3GNqvfPj2m+/9sPgfty/JX/zX" +
       "FbdQpZuN1POOvqh35PrGMNINeyuCW3av7YVb7LclpReeGrwPKBUfBc7zz9vV" +
       "vzMpveBS9ZPSdSA/WvMFSemOkzUBv+3n0Xr3ApM5rJeUbtxdHK1yP+gdVCku" +
       "XxQeqOpIwO7uzcZsp8X7jhjQ7hDzrmfSwZHjyJcdO0Tc/jOYgwO/lN2/GP7J" +
       "Dw/oH/0e9ou7t/01T91sil5upko37f7xwLbT4tDwoVN7O+jrxt6rf3Dbr97y" +
       "8oMDztt2gA+N+Qi2l1761fr2Iky2L8Nv/sm9/+hH/sGH/2Absfz/AHEqwkGl" +
       "RwAA");
}
