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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVcDXAcxZXuHVmyrH/L/z+SbVkY/KfF/MSAwMFS/COQbcVS" +
       "DCcM8mh3Vlprdmc8MyutTQwBQuGk6nwOGJtQsVN1ODYhBuPcuQL5cXzhYkJh" +
       "UhhIgpOK4Q4IcI4LDJeEO3zh3uvp2fnZ7TYTsqqap9npft3vff369Xu9PXvw" +
       "LCk1DdKopK0Wa7OumC3L0laXbJhKvF2VTbMHnvXFdpfIH972zuqrJVLWS2oG" +
       "ZXNVTDaV5UlFjZu9pCGZNi05HVPM1YoSR44uQzEVY1i2klq6l0xImh0pXU3G" +
       "ktYqLa5ghXWy0UnGypZlJPszltLBGrBIQydIEqWSRJcGi1s7SVVM0ze71Sd7" +
       "qrd7SrBmyu3LtEhd50Z5WI5mrKQa7UyaVmvWIPN1Td08oGpWi5K1WjaqVzII" +
       "bui8Mg+Cpidr//zxjsE6CsE4OZ3WLKqeuVYxNXVYiXeSWvfpMlVJmZvIHaSk" +
       "k1R6KlukudPpNAqdRqFTR1u3FkhfraQzqXaNqmM5LZXpMRTIIrP8jeiyIadY" +
       "M11UZmih3GK6U2bQdmZOW1vLPBUfnB/dufu2uu+XkNpeUptMd6M4MRDCgk56" +
       "AVAl1a8Y5tJ4XIn3krFpGOxuxUjKanILG+l6MzmQlq0MDL8DCz7M6IpB+3Sx" +
       "gnEE3YxMzNKMnHoJalDsU2lClQdA14murraGy/E5KFiRBMGMhAx2x1hGDSXT" +
       "cYvMCHLkdGy+ESoA6+iUYg1qua5GpWV4QOptE1Hl9EC0G0wvPQBVSzUwQMMi" +
       "U7mNIta6HBuSB5Q+tMhAvS67CGqNoUAgi0UmBKvRlmCUpgZGyTM+Z1dfu/32" +
       "9Mq0RCIgc1yJqSh/JTA1BpjWKgnFUGAe2IxV8zp3yRN/sk0iBCpPCFS26/zg" +
       "y+euX9B47Bd2nWkF6qzp36jErL7Yvv6ak9Pb515dgmKU65qZxMH3aU5nWRcr" +
       "ac3q4GEm5lrEwhan8Nja4//wlceUMxKp6CBlMU3NpMCOxsa0lJ5UFWOFklYM" +
       "2VLiHWSMko630/IOMhruO5NpxX66JpEwFauDjFLpozKNfgaIEtAEQlQB98l0" +
       "QnPuddkapPdZnRAyGi5yKVyfI/Yf/W+R26KDWkqJyjE5nUxr0S5DQ/3NKHic" +
       "fsB2MNoPVj8UNbWMASYY1YyBqAx2MKiwApyZ8ogVHbgsHl1hyPpgbi61oJ3p" +
       "Re8hizqOG4lEAP7pwcmvwrxZqalxxeiL7cy0LTv3RN/ztmHhZGDoWGQ+dNpi" +
       "d9pCO6WuEjptgU5b/J2SSIT2NR47t4cZBmkIpjv426q53bfesGFbUwnYlz4y" +
       "ChCWoGqTb91pd32C48j7Yofqq7fMOr3oGYmM6iT1cszKyCouI0uNAXBQsSE2" +
       "h6v6YUVyF4aZnoUBVzRDiylx8Eu8BYK1Uq4NKwY+t8h4TwvOsoUTNMpfNArK" +
       "T449NHLXujsvlYjkXwuwy1JwY8jehR4856mbgz6gULu1973z50O7tmquN/At" +
       "Ls6amMeJOjQFrSEIT19s3kz5SN9PtjZT2MeAt7ZkmF3gCBuDfficTavjuFGX" +
       "clA4oRkpWcUiB+MKa9DQRtwn1EzH0vvxYBaVOPumwHUnm470P5ZO1JFOss0a" +
       "7SygBV0YruvW97z6y3cvp3A7a0itZ/HvVqxWj9/Cxuqphxrrmm2PoShQ7/cP" +
       "dT3w4Nn7bqE2CzVmF+qwGWk7+CsYQoD53l9sOvXa6X2vSDk7j1iwcGf6If7J" +
       "5pTE56RCoCT0NseVB/yeCp4Brab5S2mwz2QiKferCk6s87UXLTryx+11th2o" +
       "8MQxowUXbsB9PqWNfOX52/7SSJuJxHDddTFzq9nOfJzb8lLDkDejHNm7Xmr4" +
       "5rPyHlgWwBWbyS0K9a6EYkDooF1J9b+U0isCZYuRXGR6jd8/vzzxUV9sxyvv" +
       "V697/+g5Kq0/wPKO9SpZb7XNC8mcLDQ/KeicVsrmINS74tjq9XXqsY+hxV5o" +
       "MQYO11xjgHvM+iyD1S4d/dt/e2bihpMlRFpOKlRNji+X6SQjY8C6FXMQPGtW" +
       "//z19uCOlAOpo6qSPOXzHiDAMwoP3bKUblGwtzw16V+vPbD3NLUynTbRkD+D" +
       "tjHj2lZ4BiG9GMn8fLvksQZGMGJbOP08GaJ3KjZdHRQt1bI0kQCf0WPIaRPd" +
       "AO12hcAGbkTSRouuQtJug9P6N+KID5bqdsE0+rAKV0LfkkNzGNfrPfby4l8d" +
       "+MauETsKmst39QG+yf+7Ru2/+z8/yrNH6uQLRGgB/t7owW9NbV9yhvK73ha5" +
       "m7P5qzesWC7vZY+l/iQ1lf1cIqN7SV2M5QzrZDWDPqwX4mTTSSQgr/CV+2Ne" +
       "O8Brza0m04Oe3tNt0M+7UQPcY228rw649hoclxVwXcOs65qgYUYIvbnJtk1K" +
       "5yFZ6HjSMbqhWSClEg8402pBs5D9xZWEnFGtnC3i85XuNKDmdvOFzO2Lfk2w" +
       "Whvrso2jyQZ3lvXmC8zjBj0tkaRySEmvYLg7+BeSdEAoKY/bIjU5SWk4BjOs" +
       "wZ1hGDh1Z/pNa608QjOZvtj6i+smNl/9YZM9xRoL1PWkPNt/9MPe3ovrYnbl" +
       "pkIN+1OdRw+Ux36XOv6mzTClAINdb8Kj0X9c95uNJ2iYUI6xY49jtJ7IEGJM" +
       "T4xS5we1Hq7vMljof4us/4wBPbBBHp9MQeoZ7UmmlDjuI6AOLGEoavt0dfQ5" +
       "R3fQvjekLn3vqv3X2bDO4vhFt/7TX3z95J4thw7aQQnCC6kEb+cjf7sFY9SL" +
       "BHG2ayB/WnHNsXffWHerxJaQGiSbss6CVONd7e3IaHPe4gWRpN9O7Ka/8LXa" +
       "H++oL1kOEXAHKc+kk5sySkfc7+pGm5l+j+G4Gb7r/pjVfAJ/Ebj+ihdaCz6w" +
       "raa+nWW7M3Pprq5nsRxSqnlwG5j9gyFn/yK41jJDXcuZ/fcIZz+P2yLj/LMf" +
       "VpVk3Cw8U7sMMDwrOczgvaxrQ2xbc9ebzsjR7PwONELBshtoI7q1/rWhb73z" +
       "OPMleVmNr7KybefXP2nZvtO2SXuraHbebo2Xx94uskcxJ90sUS+UY/nbh7b+" +
       "6NGt99lS1fs3PpalM6nHf/1/J1oeev25Avn26H5NUxU5HTRS/Lg1aAhfDWkI" +
       "l8B1ExvKmziG8KDQEHjcFinVIWKx/PMOA8EufByQe1dIuXFzZj3reT1H7r1C" +
       "uXnckJpBfqwNKY7gtTnBu+nzgOTfDil5K1wy61vmSH5AKDmP28IwMUWz2Jzw" +
       "9Tnh252igPyPhpR/JlwJJkGCI/+TQvl53BYZFVOTer7BdA/KelDswyHFXgLX" +
       "EOt4iCP200Kxedxg6INo547ck3Jyr1XSkC3CyrrSmQceBX4YUoHPw6UzEXSO" +
       "Aj8TKsDjBtwTmjtRq3PyL9fy5ukzIaVeDFeG9ZvhSP28UGoet0Uq+mF5GTC0" +
       "TDqebzOQI2tGQPgTIYVfCNcW1v0WjvCvCIXncYPwsEAqtvD45MWAqL8SiJot" +
       "lKbTvzIS2LL2dOnJeXPJub1pg5leS7uqpRXc/8EFrYH3jQNdzPbdvXNvfM13" +
       "FjnL9D9hbqLpC1VlWFE93czxB/4QPa6i37G4eerva+5/4+nmgbYwG7n4rPEC" +
       "W7X4eQYstPP4YUNQlGfv/q+pPUsGN4TYk50RQCnY5HdXHXxuxZzY/RL9QslO" +
       "oPO+iPIztfpjyQpDsTJG2h89zs6NOaYbZBJcD7AxfyBopK5V8XZ1eKyCPZmz" +
       "grL3kLwDLjGG9uTYWZ1rZ/aOgmvo7/49NnTo8zdzyo3FMtzteoEp90J4XHis" +
       "At3PC8r+iuQvFikfUKyca3rRheGjIsBAN/1mwXWK6XIqPAw81oCqnpD0RWw1" +
       "MoaPRaQSySjAwmRY0FpfR3KHrdt2WJKGtWQ8h0+ktAj4UHacPm8zJd8Ojw+P" +
       "VaD+FEHZNCTjIeYHM3FW32ddFCYUy0qa4PqAqfJBeBR4rHwreZaqO0cAxSVI" +
       "ZgEUZg6KSLULRVMRoJjAoIiU223a/0NBwWUVaHq5oOxKJC0QlKHfgOC4jUY7" +
       "+dH9WnCq4F5VxUUoWixjuQ7Ua2ZqNodHiMcaQGEUFWQU/bzN4xsCfqLECa0L" +
       "ZcaRdpfQz20CqDuQXAduCZMQxDNgcUuKhee1IPJiBsri8HjyWAvjGUDFhaZH" +
       "AM06JGvsuYhWGECmq1hr+GSC2yG2ep3hkeGxCjSVBWUxJOtt58xQIEdcFG4t" +
       "ln3MBhUUpooSHgUeK985H6HqpgVQUAtIcg1iY7GgWAAS3sv0uTc8FDxWPhQH" +
       "qbq3C6DYimTYIlU0mnH3WLx4jBQLj4tBzF1MqV3h8eCx8vF4mOq8TYAH+ufI" +
       "PXZ05+z0ebG44A7lZ5km+5lC+8NjwWPlY/EI1fdBARa7keyA9BiwyG0eesH4" +
       "RrHAWA0yHmEaHQkPBo81oKvETm3hZwhHpnF2vppvVDZjlXMUlH8WALYfyR5I" +
       "GAEwXxsB3PYWATeaTWP0d5wpfzw8bjxWrhFFbCM6LMDkX5AcBEwG8jEh51xM" +
       "Hi+m032VKfZqeEx4rIUxoZ/VXCt0Hw5jgdftVuz/WGrQVkxbE2ofx3Lf8VW7" +
       "3/Gtkuni9LPCMSIF+KgA/ONInrbI2KBBmgGLvOB27mdB/wyD8Ex49HmsfIv8" +
       "KVX8pACUl5GcAFDkeFwIygtFAGUqls0HWc8zzc6HB4XHKtD5tKDsdSSnAI/g" +
       "DKW1j7p4/LaIcYBUabdp/w+FB5e1sLvf5E8czgiQOYvkD87ZFVXOi4zeLhYi" +
       "URB0NlNrdnhEeKyCBVCQpJbFtUw/y80L5qn/Q+lHAiQ/QfKhAMn/LhaSkKdL" +
       "VzE4rgqPJI+V74AoGFIFHwypCkkp4GrgLn0ACamsWEiAClIXU6crPBI81oCi" +
       "JVSQEoqES6jeAgclTUFSz8NkXLEwAU8sbWSKbQyPCY+V73k8cDQL4JiDZIZF" +
       "Ss2YrAbRmFksNBaCkHcxle4KjwaP9VOhsUiAxuVIFiAag4psBNBYWEw0djOV" +
       "dodHg8fK9RxkJVV2iQCI65FcHThM6QXjmmKBcSloso9ptC88GDzWC4FxowCM" +
       "VUiW21sXPRw8VhQLj0tAmcNMqcPh8eCxCtS9WVDWi6TbIhOH8bga+M8e3yG2" +
       "ACg9RQBlnAPKU0yzp8KDwmMVKK4IygaQbLDwbd2e/DN9yPE1F5MLHkD+GzCh" +
       "0RdUk44xxY6Fx4THKtDbEJRhpiml7Fi/J3jMudDRZfo2jH3ccH3l8Z+aj/zh" +
       "+87BibR/RswUKWoKj796Otm7f/Yv79w7+z/oWyvlSXOdbCw1Bgq8Rurhef/g" +
       "a2deqm54gp7DoGdzsdPq4Pu3+a/X+t6apTrVIj7ZXCZ+mfBlQT+A7OSxruuu" +
       "wfgiZdfY0kUwNufIj3SCjcGJCxhb/nkfLqvAoAR7qRKmEdI9FpmcTH8qv1SM" +
       "vdVpWIb5JTsKIIU/RcBlFagu2FaVcFtV2gHr1oASeH3DhaIYO6vOuRLpLabP" +
       "W+Gh4LEK1BVsmEr7kOyxz5XkztU+7MJQjI1S+jX5LNDhHNPlXHgYeKwCVQ8J" +
       "yg4jecy2CN9B14MuFN8rViQzD7K1UrtN+38oKLis/MiOHrGRfizA4yiSH1ik" +
       "GiK7ttwpyYC3eKpYU6QRtBnHtBoXHhAeq0Df5wRlzyP5d/sIhQ8Lz/kr6efF" +
       "+kIB3GdJI1OoMTwWPFaBvr8WlL2K5CSkPwOeL6TIIy4OLxVrkjSAEuxoaknw" +
       "aOqnwIHHyp8k9Ets6Q0BGG8hOc1OnQfmxmtFwKEByxaBEjczZW4OjwOPVaDm" +
       "+4KyD5Ccsch4dt7M3r1mP97gxHAzcl/r4THxlsL1KGp//Lu8nWuRGv+vSODr" +
       "z5PzfqrG/nmV2BN7a8sn7f3Sb+zY1fkJlKpOUp7IqKr3HVTPfZluKIkkxbuK" +
       "0rH0lSrpvEWmiyJWi5QARcmlj22OTyA643FAbaCe2iUSQF2oNtRkQDo1Sy1S" +
       "F6xpkVL631uv3CIVbj2LlNk33iqV0DpUwduq3NsVeUdys/ZXb9O8o4ODSi54" +
       "6DDH4v05BISA/giRkw9lutiLgIf23rD69nOf+479cwwxVd6yBVuphGzC/mUI" +
       "lk0EXyr0tua0VbZy7sc1T465yMmoxtoCu/NommvsZCl4Bh1taWrgtwrM5txP" +
       "Fpzad+3RF7aVvQTZ0y0kIltk3C35r0Nn9YxBGm7pzH9FEJIt+iMKrXMf3rxk" +
       "QeK939G38Yn9SuF0fv2+2CsHbn35/sn7GiVS2UFKkzC9svQ97S9sTq9VYsNG" +
       "L6lOmsuyICK0kpRV3/uHNWj2Mn7rRHFhcFbnnuKPeVikKf/NtvyfQKlQtRHF" +
       "aHOWSMgBK90n9sgEzqhndD3A4D5hQ4n0y0juyOJogD32da7Sded9xzGTdTr3" +
       "txby4/QLkpIZ9BbvZv4/Sbr8AqBMAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZKOUijdqlt5YMutJ1MApaW6HBbqvVpJE");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "tnLFrP6fzgsTAgw9voX5+IXCzH7vrDNu1bx4nJ16cPBHGcA/3AP+T1Py+T3g" +
       "/+C84MHC6rCyBV+50IF+gvB/7kH41yn5cyCWIH0MuAvvS+eFByAd8lt4/MXA" +
       "u+n4se/BH52QtOhh7tpADzOb//K1gH7lvECBQzqcbYHOLnysnsJ41x6M6Xfn" +
       "h7dFuVtCVbF3IB7efl6IXw+YedcW4rv+PiHueZZ1mD7LOnwghTjVlWAH4rmf" +
       "ZKUQf2AL8QcuejTmMmd7uOdJ1mH6JOvw0Z2Pg08jPM+zrAxhASD78Bbhh/+e" +
       "EO55oHWYochv1om9a4A895Or1wJwP70F+dMXA/I0hjftyXtzSrAo97JF+vEu" +
       "cDS9M5/07iCtnAPpA0dIf3aL9GcvHim9J6+ZEjLKvdQMe1d+tpzWCE+A1s4B" +
       "NIsJEADw+S3Q5y8eaG9PnpySzibg6+1+Hb/nw/XsrJLNp9bP/Njjv/mOZx7/" +
       "g+y4j9vNUFYCPJhc5TCrU3W+9Oznvvhbdz/80exInOyr+pS5O3dPAbvykK8z" +
       "Z3dlyO86Ozwe2yfLrChYH5X2nmt0Vg7p0W66G/m+nztROX8OlR99G3n4qS2b" +
       "n7pRlfNfVeXGnrz0W8BDJco9aLrXNY7H58D6tWliGupvX4kdXtArsdN4gj15" +
       "6WL/0AEeeaLvHJVxgs+9gNeZh3+4xfeHF4/v2/bkvTMl683rzOOv9N9xgi05" +
       "7+uhVwJML2yxvXDx2L5rT973pOQ9G92d+WL+fSf4vuO8s+nrQbR9y6bu5v/5" +
       "8e2+rj18eg/ID6bkfVHubhAyEMffY++MwO87r4U+AtA9sEX5wMVr8Z/tyftw" +
       "Sj60ecl3BuCpt+6Hz5z3YSPwMzc9sgX4yMUD/OievI+n5CdBWDs59Vg599QJ" +
       "uI+c10YfBqC2O3Ju2t2Rc0Gvdw5/fg/Cf52S57anROyY5r88B7iH08QiADXY" +
       "ghtcvOY+sSfvkyn5pSj3ku3Wgc0Dr+1xhkehwqPHT9zTEx0uX71cJop/d0On" +
       "dEW5e86en5geBvfgFYe0bg4WVT/6zL23v/wZ6bc38dLR4Z93tHK3G7Ftnz62" +
       "6tT9rX6gG2Ymojsyeo+f4f50lHvFvgAoyt0EaMry4X/c1PgMiBauVQOUBvR0" +
       "6d8GIr1aaVByK7Cjkr8b5e7bLQmWv9n/0+V+L8rdeVIuyt26uTld5POgdVAk" +
       "vf2DzHr+crV5HPzgaePL9vjc/9UUdVzl9DmFKdzsqN2jfWIxvz0i6mPPNNvf" +
       "+kL5RzfnJKq2kiRpK7eDaHVzZOM2Wt09bup0a0dt3Uq/7sv3fPyOVx/ti7tn" +
       "w/DJQDjF26NXP5Sw7vhRdoxg8rMv/xdv+vFnfj87COL/AUl5DHoDWQAA");
}
