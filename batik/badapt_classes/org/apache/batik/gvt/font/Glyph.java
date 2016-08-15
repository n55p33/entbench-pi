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
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "M6mzLdxbLI5lR9ii3ewW73r+D/JBY38QPAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NtojIQ6zwMpwioOBM007bcKkl2rbmjmN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
