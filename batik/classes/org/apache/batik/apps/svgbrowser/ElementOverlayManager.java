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
           "thflNe7N77/hd9/2m899M6+z/Q9mv6lY3B8AAA==");
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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uqrsA0hecpLCxEQQNEVHUSUIMs/Unw2Adqv908fO7nXnHdGpac+7oZPFAjwX" +
       "rYvn+855ngcKLr8DpMO9UR6e9zwHpe0Duu3y+DZ/ssh+4sjQ7w1CPwZUaure" +
       "1v8K/B2A9H+KVAxXFOxW8we7+5DiseOYIgAr2Wu1MwsVCPt8u7DTfVQKbOiB" +
       "rZJJaXy4Ld65wyJvFFlnN3Prhir1jrOAYZDqe8D1GwAe3QBw8YhtuYjHpYfO" +
       "En5MW/8cgeObJPApkJA9gcgNCOReCoF3Z3448lXtYtOhQ9MFK8N6H6lCzz74" +
       "Lftzf/bLuyj0vJ2ca6x97LmP/9XhJ5+7dCr2f+Ka8Pt0n138v6Xw5VsyC8/z" +
       "+EWzbHvgf/rVZ//5Lz370R1VD56NZDGwUfvl3//x7x5+9ttfv06odLfs+44m" +
       "eefEMrtJsRRL9Dv3YnnnDcSivBSxXFa2fr/4VTlHk3qTNBXG29nT1LkBTdZL" +
       "oemBs7p8ZHlvvMHqZazjw33Tcwjsm0TwOEjEHgFxAwTRS0Fwzx5BdEafzmo7" +
       "I6Xbzdwzym9Ov/3Nz2+++uWdusgS2K2Uyjc6F7j2aKKIKZ+6IC4+2TH+kPjr" +
       "L3znT/j3Xtov5vefhf+ai+AfSeF60UdR9ew53sc3yfsaSNR+cuoGvP/QS+H9" +
       "fcUKGRYx07HPbt/k/qR7PMI5UB++SVDFGjbdg5reANTHXwqoq2a0pw3zitBR" +
       "Lcrfc466T7wodTsndwDWyrtqh63DrcX/3PXnv6N4fDNwENH22Af00E1Pco4I" +
       "eo3lKE8eraE8YDUIaJ60nNYRy69u1aQIHQ53ZyfnaMVfMq3AhB44GYzyPePp" +
       "T/z3T/3u33niW8BeBqW71kWwAkzg1IzjpDiZ+siXP/36+5/79ie2mwHAUP5v" +
       "/eiRdxejfu4ixEX26SL7zBHURwqo7HanTUlRPNrG75p6jHZxCs97Y7AL8G8B" +
       "bfzQF8hG1EeP/qiq1KujsyrjQGoDszv0UIfq7W4XJYfrTcT4whDtWgTWQHnT" +
       "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" +
       "DybZjGibTWbIOKMu02e0AYZPkjozXTqL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/b/HHr+uFT4AAA==");
}
