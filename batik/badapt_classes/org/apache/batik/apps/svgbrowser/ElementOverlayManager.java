package org.apache.batik.apps.svgbrowser;
public class ElementOverlayManager {
    protected java.awt.Color elementOverlayStrokeColor = java.awt.Color.black;
    protected java.awt.Color elementOverlayColor = java.awt.Color.white;
    protected boolean xorMode = true;
    protected org.apache.batik.swing.JSVGCanvas canvas;
    protected org.apache.batik.swing.gvt.Overlay elementOverlay = new org.apache.batik.apps.svgbrowser.ElementOverlayManager.ElementOverlay(
      );
    protected java.util.ArrayList elements;
    protected org.apache.batik.apps.svgbrowser.ElementOverlayController
      controller;
    protected boolean isOverlayEnabled = true;
    public ElementOverlayManager(org.apache.batik.swing.JSVGCanvas canvas) {
        super(
          );
        this.
          canvas =
          canvas;
        elements =
          new java.util.ArrayList(
            );
        canvas.
          getOverlays(
            ).
          add(
            elementOverlay);
    }
    public void addElement(org.w3c.dom.Element elem) { elements.add(
                                                                  elem);
    }
    public void removeElement(org.w3c.dom.Element elem) { if (elements.
                                                                remove(
                                                                  elem)) {
                                                              
                                                          } }
    public void removeElements() { elements.clear();
                                   repaint(); }
    protected java.awt.Rectangle getAllElementsBounds() { java.awt.Rectangle resultBound =
                                                            null;
                                                          int n =
                                                            elements.
                                                            size(
                                                              );
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 n;
                                                               i++) {
                                                              org.w3c.dom.Element currentElement =
                                                                (org.w3c.dom.Element)
                                                                  elements.
                                                                  get(
                                                                    i);
                                                              java.awt.Rectangle currentBound =
                                                                getElementBounds(
                                                                  currentElement);
                                                              if (resultBound ==
                                                                    null) {
                                                                  resultBound =
                                                                    currentBound;
                                                              }
                                                              else {
                                                                  resultBound.
                                                                    add(
                                                                      currentBound);
                                                              }
                                                          }
                                                          return resultBound;
    }
    protected java.awt.Rectangle getElementBounds(org.w3c.dom.Element elem) {
        return getElementBounds(
                 canvas.
                   getUpdateManager(
                     ).
                   getBridgeContext(
                     ).
                   getGraphicsNode(
                     elem));
    }
    protected java.awt.Rectangle getElementBounds(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            return null;
        }
        java.awt.geom.AffineTransform at =
          canvas.
          getRenderingTransform(
            );
        java.awt.Shape s =
          at.
          createTransformedShape(
            node.
              getOutline(
                ));
        return outset(
                 s.
                   getBounds(
                     ),
                 1);
    }
    protected java.awt.Rectangle outset(java.awt.Rectangle r,
                                        int amount) {
        r.
          x -=
          amount;
        r.
          y -=
          amount;
        r.
          width +=
          2 *
            amount;
        r.
          height +=
          2 *
            amount;
        return r;
    }
    public void repaint() { canvas.repaint(
                                     ); }
    public class ElementOverlay implements org.apache.batik.swing.gvt.Overlay {
        public void paint(java.awt.Graphics g) {
            if (controller.
                  isOverlayEnabled(
                    ) &&
                  isOverlayEnabled(
                    )) {
                int n =
                  elements.
                  size(
                    );
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    org.w3c.dom.Element currentElement =
                      (org.w3c.dom.Element)
                        elements.
                        get(
                          i);
                    org.apache.batik.gvt.GraphicsNode nodeToPaint =
                      canvas.
                      getUpdateManager(
                        ).
                      getBridgeContext(
                        ).
                      getGraphicsNode(
                        currentElement);
                    if (nodeToPaint !=
                          null) {
                        java.awt.geom.AffineTransform elementsAt =
                          nodeToPaint.
                          getGlobalTransform(
                            );
                        java.awt.Shape selectionHighlight =
                          nodeToPaint.
                          getOutline(
                            );
                        java.awt.geom.AffineTransform at =
                          canvas.
                          getRenderingTransform(
                            );
                        at.
                          concatenate(
                            elementsAt);
                        java.awt.Shape s =
                          at.
                          createTransformedShape(
                            selectionHighlight);
                        if (s ==
                              null) {
                            break;
                        }
                        java.awt.Graphics2D g2d =
                          (java.awt.Graphics2D)
                            g;
                        if (xorMode) {
                            g2d.
                              setColor(
                                java.awt.Color.
                                  black);
                            g2d.
                              setXORMode(
                                java.awt.Color.
                                  yellow);
                            g2d.
                              fill(
                                s);
                            g2d.
                              draw(
                                s);
                        }
                        else {
                            g2d.
                              setColor(
                                elementOverlayColor);
                            g2d.
                              setStroke(
                                new java.awt.BasicStroke(
                                  1.8F));
                            g2d.
                              setColor(
                                elementOverlayStrokeColor);
                            g2d.
                              draw(
                                s);
                        }
                    }
                }
            }
        }
        public ElementOverlay() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "D6pjNmY3Qz9qU5MhZtiM1UaDhtrpeR2AUzVqmDAlbSa1Rh2D1uZ0g0ZFtx+Q" +
           "nXZrSAcSSP3nM0NIGXqLaBN2gTqaZlVGPWIo1l3WbgUTDK95ajOr0Ytl6KQW" +
           "poj4cDqImW6XiqlZX3LUGZ42t+gMmCylpOFwyTDr5dzv8TS5JcWVDUuDRd1r" +
           "lZxAdOVu1HCyci9g1fJUnxq1oTrdpsGkN6XrYzvE/DYvdZ2stp506gvB8rys" +
           "O7QjjqOaVBWteNteVKXCRhkOaY4Sh1ifHKoe1lgKE54y1jWpJi/7A7pdEsLt" +
           "slVhSgnF0wNh7FK6M+2MOKUxEbvlwWTpVfh5gG3IOrtZW8JgQq7obkmTFbsv" +
           "6MrIMlLbEqvsSthOEHY0EBRO6pM2zSlMOhGdSnckeKNSF+eR0WpWdplM7LVH" +
           "TZlUkaEkKFWkEi9kxfBKUnvAqkOyp5JcG9VdJuINjii3miK3qPvUxu67jVYN" +
           "NxLNyGpD2dfr/JYPer5ckuzBWE7Ls8ypJjWzV1tjbVRRNCUmCCKyWjUjyhh0" +
           "qOADcjL0u+3E5dZ9Y1vTl/1+gogGkZ/eFgtKUAJ/ja9I2YwD30GFDirOCXHe" +
           "onsDZsWV0+YStRDgFGSJ6GQDeiu40pCfOFNyMapVukF5MZyxsqzKfGtYJum+" +
           "4zfTRNG5qJpinO2x3nS8EVWYymqwiDT6SNvoym5n5YJDeOpJjsOvVIEJ4Zjs" +
           "9VYsp1c7ouK5ZSkq1ZqkqCsrRZRp2uWas0kz3pankbhUW9nAnovYKCODjcFJ" +
           "VIDB9mJKkoHWSeks8ZG2lWy3giFIg+6mqya03aVpbeivao5NreCAKGXGBp+5" +
           "q3baWSOshfUUwSN7GePPKljUQNz6ugcjM2tbDxNOLTdXbJhOsnplELENwRWl" +
           "GslU13jDRrA+3VlrWLDp8uWRWMI3KwXfrn05IYgFkzTd8iSOh8P+lIPr9Q6A" +
           "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" +
           "OKQeXTiAA1s+0P4BTiy7ocfy5omjwlxRorj0EoW5E8WLc4cH4sdvKNNGG3As" +
           "3p8n8f5BDTY/sD10qyuH4rD20Xc/+5zR+1h576A+pIDz+cFN0MklQ+gNtz6V" +
           "8sV1y3HR4nPv/qcHhz+2ePsPUJZ95IyQZ6f8Lf75L7Rfr//KHnT+qIRxw0XQ" +
           "aaZrpwsXlwAGrEN3eKp88dCRBS7nG/4E+H71wAJfvXlp9Kbecq7wlp2PnKm9" +
           "nTtts12JS9vE++1Q8xeWHhVc8UtU7IrGi6ELvmYdXBZKJ5xsBA7NiWcZx97n" +
           "v9x5+VRZLIbuPl23PxS19r+7BQCu8sANV5G76zP9k89dvvia5+S/LArfR1dc" +
           "d3LQxdnatk9WmU483+6H5swqduHOXc3JL35+LoYefTkRY+jS8Z9CsZ/dMT8d" +
           "Q/fdlBnsZv5zkva9MXTlLC0wR/F7ku4XwWrHdCCOdg8nSZ6JofOAJH/8Zf8m" +
           "ha1dlS49dyL2DgCjsOy9L2fZI5aTBfU8Xos75MPYWu9uka/rn3quI7zjxdrH" +
           "dgV93dayLJ/lIgfdsbtbOIrPx2452+FctzNPfu/uT9/5xCGQ3L0T+DhqTsj2" +
           "yM0r5k3Hj4sad/Z7r/mdN/3Gc18r6mz/A96GX0TcHwAA");
    }
    public java.awt.Color getElementOverlayColor() {
        return elementOverlayColor;
    }
    public void setElementOverlayColor(java.awt.Color selectionOverlayColor) {
        this.
          elementOverlayColor =
          selectionOverlayColor;
    }
    public java.awt.Color getElementOverlayStrokeColor() {
        return elementOverlayStrokeColor;
    }
    public void setElementOverlayStrokeColor(java.awt.Color selectionOverlayStrokeColor) {
        this.
          elementOverlayStrokeColor =
          selectionOverlayStrokeColor;
    }
    public boolean isXorMode() { return xorMode;
    }
    public void setXorMode(boolean xorMode) {
        this.
          xorMode =
          xorMode;
    }
    public org.apache.batik.swing.gvt.Overlay getElementOverlay() {
        return elementOverlay;
    }
    public void removeOverlay() { canvas.
                                    getOverlays(
                                      ).
                                    remove(
                                      elementOverlay);
    }
    public void setController(org.apache.batik.apps.svgbrowser.ElementOverlayController controller) {
        this.
          controller =
          controller;
    }
    public boolean isOverlayEnabled() { return isOverlayEnabled;
    }
    public void setOverlayEnabled(boolean isOverlayEnabled) {
        this.
          isOverlayEnabled =
          isOverlayEnabled;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZDO8YzaZEeNQPWbAaEMUmyR1Zrp0FnGD");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Ag4mdfIVPgAA");
}
