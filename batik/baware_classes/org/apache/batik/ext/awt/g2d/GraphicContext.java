package org.apache.batik.ext.awt.g2d;
public class GraphicContext implements java.lang.Cloneable {
    protected java.awt.geom.AffineTransform defaultTransform = new java.awt.geom.AffineTransform(
      );
    protected java.awt.geom.AffineTransform transform = new java.awt.geom.AffineTransform(
      );
    protected java.util.List transformStack = new java.util.ArrayList(
      );
    protected boolean transformStackValid = true;
    protected java.awt.Paint paint = java.awt.Color.black;
    protected java.awt.Stroke stroke = new java.awt.BasicStroke(
      );
    protected java.awt.Composite composite = java.awt.AlphaComposite.
                                               SrcOver;
    protected java.awt.Shape clip = null;
    protected java.awt.RenderingHints hints = new java.awt.RenderingHints(
      null);
    protected java.awt.Font font = new java.awt.Font("sanserif",
                                                     java.awt.Font.
                                                       PLAIN,
                                                     12);
    protected java.awt.Color background = new java.awt.Color(
      0,
      0,
      0,
      0);
    protected java.awt.Color foreground = java.awt.Color.
                                            black;
    public GraphicContext() { super();
                              hints.put(java.awt.RenderingHints.
                                          KEY_RENDERING, java.awt.RenderingHints.
                                                           VALUE_RENDER_DEFAULT);
    }
    public GraphicContext(java.awt.geom.AffineTransform defaultDeviceTransform) {
        this(
          );
        defaultTransform =
          new java.awt.geom.AffineTransform(
            defaultDeviceTransform);
        transform =
          new java.awt.geom.AffineTransform(
            defaultTransform);
        if (!defaultTransform.
              isIdentity(
                ))
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createGeneralTransformElement(
                    defaultTransform));
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.g2d.GraphicContext copyGc =
                                        new org.apache.batik.ext.awt.g2d.GraphicContext(
                                        defaultTransform);
                                      copyGc.
                                        transform =
                                        new java.awt.geom.AffineTransform(
                                          this.
                                            transform);
                                      copyGc.
                                        transformStack =
                                        new java.util.ArrayList(
                                          transformStack.
                                            size(
                                              ));
                                      for (int i =
                                             0;
                                           i <
                                             this.
                                               transformStack.
                                             size(
                                               );
                                           i++) {
                                          org.apache.batik.ext.awt.g2d.TransformStackElement stackElement =
                                            (org.apache.batik.ext.awt.g2d.TransformStackElement)
                                              this.
                                                transformStack.
                                              get(
                                                i);
                                          copyGc.
                                            transformStack.
                                            add(
                                              stackElement.
                                                clone(
                                                  ));
                                      }
                                      copyGc.
                                        transformStackValid =
                                        this.
                                          transformStackValid;
                                      copyGc.
                                        paint =
                                        this.
                                          paint;
                                      copyGc.
                                        stroke =
                                        this.
                                          stroke;
                                      copyGc.
                                        composite =
                                        this.
                                          composite;
                                      if (clip !=
                                            null)
                                          copyGc.
                                            clip =
                                            new java.awt.geom.GeneralPath(
                                              clip);
                                      else
                                          copyGc.
                                            clip =
                                            null;
                                      copyGc.
                                        hints =
                                        (java.awt.RenderingHints)
                                          this.
                                            hints.
                                          clone(
                                            );
                                      copyGc.
                                        font =
                                        this.
                                          font;
                                      copyGc.
                                        background =
                                        this.
                                          background;
                                      copyGc.
                                        foreground =
                                        this.
                                          foreground;
                                      return copyGc;
    }
    public java.awt.Color getColor() { return foreground;
    }
    public void setColor(java.awt.Color c) {
        if (c ==
              null)
            return;
        if (paint !=
              c)
            setPaint(
              c);
    }
    public java.awt.Font getFont() { return font;
    }
    public void setFont(java.awt.Font font) {
        if (font !=
              null)
            this.
              font =
              font;
    }
    public java.awt.Rectangle getClipBounds() {
        java.awt.Shape c =
          getClip(
            );
        if (c ==
              null)
            return null;
        else
            return c.
              getBounds(
                );
    }
    public void clipRect(int x, int y, int width,
                         int height) { clip(
                                         new java.awt.Rectangle(
                                           x,
                                           y,
                                           width,
                                           height));
    }
    public void setClip(int x, int y, int width,
                        int height) { setClip(
                                        new java.awt.Rectangle(
                                          x,
                                          y,
                                          width,
                                          height));
    }
    public java.awt.Shape getClip() { try {
                                          return transform.
                                            createInverse(
                                              ).
                                            createTransformedShape(
                                              clip);
                                      }
                                      catch (java.awt.geom.NoninvertibleTransformException e) {
                                          return null;
                                      } }
    public void setClip(java.awt.Shape clip) {
        if (clip !=
              null)
            this.
              clip =
              transform.
                createTransformedShape(
                  clip);
        else
            this.
              clip =
              null;
    }
    public void setComposite(java.awt.Composite comp) {
        this.
          composite =
          comp;
    }
    public void setPaint(java.awt.Paint paint) {
        if (paint ==
              null)
            return;
        this.
          paint =
          paint;
        if (paint instanceof java.awt.Color)
            foreground =
              (java.awt.Color)
                paint;
    }
    public void setStroke(java.awt.Stroke s) {
        stroke =
          s;
    }
    public void setRenderingHint(java.awt.RenderingHints.Key hintKey,
                                 java.lang.Object hintValue) {
        hints.
          put(
            hintKey,
            hintValue);
    }
    public java.lang.Object getRenderingHint(java.awt.RenderingHints.Key hintKey) {
        return hints.
          get(
            hintKey);
    }
    public void setRenderingHints(java.util.Map hints) {
        this.
          hints =
          new java.awt.RenderingHints(
            hints);
    }
    public void addRenderingHints(java.util.Map hints) {
        this.
          hints.
          putAll(
            hints);
    }
    public java.awt.RenderingHints getRenderingHints() {
        return hints;
    }
    public void translate(int x, int y) {
        if (x !=
              0 ||
              y !=
              0) {
            transform.
              translate(
                x,
                y);
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createTranslateElement(
                    x,
                    y));
        }
    }
    public void translate(double tx, double ty) {
        transform.
          translate(
            tx,
            ty);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createTranslateElement(
                tx,
                ty));
    }
    public void rotate(double theta) { transform.
                                         rotate(
                                           theta);
                                       transformStack.
                                         add(
                                           org.apache.batik.ext.awt.g2d.TransformStackElement.
                                             createRotateElement(
                                               theta));
    }
    public void rotate(double theta, double x,
                       double y) { transform.
                                     rotate(
                                       theta,
                                       x,
                                       y);
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createTranslateElement(
                                           x,
                                           y));
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createRotateElement(
                                           theta));
                                   transformStack.
                                     add(
                                       org.apache.batik.ext.awt.g2d.TransformStackElement.
                                         createTranslateElement(
                                           -x,
                                           -y));
    }
    public void scale(double sx, double sy) {
        transform.
          scale(
            sx,
            sy);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createScaleElement(
                sx,
                sy));
    }
    public void shear(double shx, double shy) {
        transform.
          shear(
            shx,
            shy);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createShearElement(
                shx,
                shy));
    }
    public void transform(java.awt.geom.AffineTransform Tx) {
        transform.
          concatenate(
            Tx);
        transformStack.
          add(
            org.apache.batik.ext.awt.g2d.TransformStackElement.
              createGeneralTransformElement(
                Tx));
    }
    public void setTransform(java.awt.geom.AffineTransform Tx) {
        transform =
          new java.awt.geom.AffineTransform(
            Tx);
        invalidateTransformStack(
          );
        if (!Tx.
              isIdentity(
                ))
            transformStack.
              add(
                org.apache.batik.ext.awt.g2d.TransformStackElement.
                  createGeneralTransformElement(
                    Tx));
    }
    public void validateTransformStack() {
        transformStackValid =
          true;
    }
    public boolean isTransformStackValid() {
        return transformStackValid;
    }
    public org.apache.batik.ext.awt.g2d.TransformStackElement[] getTransformStack() {
        org.apache.batik.ext.awt.g2d.TransformStackElement[] stack =
          new org.apache.batik.ext.awt.g2d.TransformStackElement[transformStack.
                                                                   size(
                                                                     )];
        transformStack.
          toArray(
            stack);
        return stack;
    }
    protected void invalidateTransformStack() {
        transformStack.
          clear(
            );
        transformStackValid =
          false;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return new java.awt.geom.AffineTransform(
          transform);
    }
    public java.awt.Paint getPaint() { return paint;
    }
    public java.awt.Composite getComposite() {
        return composite;
    }
    public void setBackground(java.awt.Color color) {
        if (color ==
              null)
            return;
        background =
          color;
    }
    public java.awt.Color getBackground() {
        return background;
    }
    public java.awt.Stroke getStroke() { return stroke;
    }
    public void clip(java.awt.Shape s) { if (s !=
                                               null)
                                             s =
                                               transform.
                                                 createTransformedShape(
                                                   s);
                                         if (clip !=
                                               null) {
                                             java.awt.geom.Area newClip =
                                               new java.awt.geom.Area(
                                               clip);
                                             newClip.
                                               intersect(
                                                 new java.awt.geom.Area(
                                                   s));
                                             clip =
                                               new java.awt.geom.GeneralPath(
                                                 newClip);
                                         }
                                         else {
                                             clip =
                                               s;
                                         }
    }
    public java.awt.font.FontRenderContext getFontRenderContext() {
        java.lang.Object antialiasingHint =
          hints.
          get(
            java.awt.RenderingHints.
              KEY_TEXT_ANTIALIASING);
        boolean isAntialiased =
          true;
        if (antialiasingHint !=
              java.awt.RenderingHints.
                VALUE_TEXT_ANTIALIAS_ON &&
              antialiasingHint !=
              java.awt.RenderingHints.
                VALUE_TEXT_ANTIALIAS_DEFAULT) {
            if (antialiasingHint !=
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_OFF) {
                antialiasingHint =
                  hints.
                    get(
                      java.awt.RenderingHints.
                        KEY_ANTIALIASING);
                if (antialiasingHint !=
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_ON &&
                      antialiasingHint !=
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_DEFAULT) {
                    if (antialiasingHint ==
                          java.awt.RenderingHints.
                            VALUE_ANTIALIAS_OFF)
                        isAntialiased =
                          false;
                }
            }
            else
                isAntialiased =
                  false;
        }
        boolean useFractionalMetrics =
          true;
        if (hints.
              get(
                java.awt.RenderingHints.
                  KEY_FRACTIONALMETRICS) ==
              java.awt.RenderingHints.
                VALUE_FRACTIONALMETRICS_OFF)
            useFractionalMetrics =
              false;
        java.awt.font.FontRenderContext frc =
          new java.awt.font.FontRenderContext(
          defaultTransform,
          isAntialiased,
          useFractionalMetrics);
        return frc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "by3kx+kXJCUz6C3ezfx/jnJsPKBMAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gVd2bC9P4SswvQt4IjBtvpLXh+io2mgx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
