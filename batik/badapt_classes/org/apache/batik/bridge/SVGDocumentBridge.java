package org.apache.batik.bridge;
public class SVGDocumentBridge implements org.apache.batik.bridge.DocumentBridge, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.dom.svg.SVGContext {
    protected org.w3c.dom.Document document;
    protected org.apache.batik.gvt.RootGraphicsNode node;
    protected org.apache.batik.bridge.BridgeContext ctx;
    public SVGDocumentBridge() { super(); }
    public java.lang.String getNamespaceURI() { return null; }
    public java.lang.String getLocalName() { return null; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGDocumentBridge(
                                                            ); }
    public org.apache.batik.gvt.RootGraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                    org.w3c.dom.Document doc) {
        org.apache.batik.gvt.RootGraphicsNode gn =
          new org.apache.batik.gvt.RootGraphicsNode(
          );
        this.
          document =
          doc;
        this.
          node =
          gn;
        this.
          ctx =
          ctx;
        ((org.apache.batik.dom.svg.SVGOMDocument)
           doc).
          setSVGContext(
            this);
        return gn;
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Document doc,
                                  org.apache.batik.gvt.RootGraphicsNode node) {
        if (ctx.
              isDynamic(
                )) {
            ctx.
              bind(
                doc,
                node);
        }
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            org.w3c.dom.Element childElt =
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  );
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode childNode =
              builder.
              build(
                ctx,
                childElt);
            if (childNode ==
                  null) {
                return;
            }
            node.
              add(
                childNode);
        }
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        
    }
    public void dispose() { ((org.apache.batik.dom.svg.SVGOMDocument)
                               document).
                              setSVGContext(
                                null);
                            ctx.unbind(document);
    }
    public float getPixelUnitToMillimeter() {
        return ctx.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           );
    }
    public java.awt.geom.Rectangle2D getBBox() {
        return null;
    }
    public java.awt.geom.AffineTransform getScreenTransform() {
        return ctx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        ctx.
          getUserAgent(
            ).
          setTransform(
            at);
    }
    public java.awt.geom.AffineTransform getCTM() {
        return null;
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        return null;
    }
    public float getViewportWidth() { return 0.0F;
    }
    public float getViewportHeight() { return 0.0F;
    }
    public float getFontSize() { return 0;
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
      ("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" +
       "5Z3TjZ4+fV11V6jGa+AvT11aPXI00Q/k");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8/oESP39RPfP3okcq9L1L0R+ZKeK59y4fvCcsg/l5ANx6V5NjceA6wjMrTqf" +
       "DgotPlbgn/9+x9Qn+y0yfu40xEdBovcQ6YuH+K/PKfu1nHwkLt0NIJKeLNrj" +
       "/eycwPfRm8X3CEiLPb7FxeN74ZyyF3Py63HpZQDfoRIe2uuj59v4sQB+4yYE" +
       "kL/DUZSv9gJYXYwALhcVLuc/+ZwQRa3PnCOKz+bkP8SlB+RQBc7r7LUlfYz3" +
       "0zeBt3hxpQ3Ss3u877gYvFeOV5od3oLnournzwH9hZz8EViKpLVhKycxF9W9" +
       "EwtQFJdu2XjGCcX/45uVw4+B9N69HN57MXK4tH8Fa6/Dj5+8QAcrhBsDP73e" +
       "v9Oa/yw6+co5EvpaTr4Ulx7Wi9UMm1BIHIeHN5NFH3mNLx6L5csXIZb378Xy" +
       "/gsVS/7zq0WFvzgH8n/PyUsnIecKAdwDiLGvD/mbNwv5LSD96h7yr/6QIH/n" +
       "HMj/OyffikuvOQV5qjre5vqI/+pmESMgfWKP+BM/JMR/dw7iv8/J3wAvf4QY" +
       "1UF4I8dqiImxeKjgZ2D/7UW4vhf2sF/4oZj8U9csW3IUHaiuZrjqAcqyePF0" +
       "ZPyX7rixkC7dnZMrcemVOyGdbn1aNJduuVnRTED67b1ofvuHIhr4hhE44hpO" +
       "/hYSaWzU3L8Z0jpWixexCjm8+hwZPZyT+48U6bCno16AWrnaWUW69MBFKNLv" +
       "7aX1exduP0oB7eo5sN+Uk8fi0mt3sCexroY77GBpuT7mx28W82tA+oM95j+4" +
       "GMwnIVXOKSsAlOPS7YoR+V6knoH25puAVuxZ8z3qF/bQvnDx0N5yTtlbc9KK" +
       "Sw+BGJg2UtWeu0Y88yjDtg1Hjfcb2DOh0K0r2xPjYwG0b1YA+Sbgy3sBfPni" +
       "BTA6p4zKSW+3ySkEAMAXeW87xkfcBL4H88x8E/eVPb6vXDy+xTlleUB8aQp0" +
       "F+Drdr2jN/9eU7zGJibxgaYCPzhVZbD/0Wy1hh3jZm8C92vzzB8F6at73F+9" +
       "eNzqOWX5+2KX3g52NAA3C3Y1qjsLRTfKX7Y/FMEjp0WArFZgdTtdqxCDeLOu" +
       "qwnS1/Zi+NrFiOHYXV8yCrzRObJY58QFsoiukcUZV+bd7IznJzJf30P9+sXP" +
       "+E+fU/aunGzj0m1gxtFZYcPGMbJ3XIQuf2OP7BsXj+x955T9XE5+dqfLhO1J" +
       "on1y/k6ifM/NeuJ8/l7ao3zp4lF+6JyyX87JL8Sl+wBKzlAT3wvjhaEU33Od" +
       "9Ma/eLMYXw/SN/cYv3nxGH/tnLKP5+T5uHT/CYx91dD0+AzIX7lZkPnZ0p/v" +
       "Qf75xYN88Zyyf5uTT+7O1XqeG7PGVj0D79/8IPBSIK9rvkvLP7J56JrPXnef" +
       "asq/+fy9dzz4/PyrxadZR59T3kmW7litbfvkNxEnnm/zQ3VVONPSnbsvJPwC" +
       "zu/GpQdvcBoInI10dB546dO7+p8BKny2PoiZiv8n6/1+XLrruB7oavdwssof" +
       "xqUroEr++Ef+4bJ14gX03ach6W6P89BJbSg2rN93n3HU5OSXW/l1QfHZ8eHR" +
       "/nr34fEz8ovPD8fv+G7z47svx2Rb3G7zXu4gS7fvPmIrOs2vB564YW+Hfd3W" +
       "f/J79/zWnW88vMq4Z8fwsWae4O2x63+mhTt+XHxYtf3dB//9Wz7x/DeKN/D/" +
       "P94YjasPPgAA");
}
