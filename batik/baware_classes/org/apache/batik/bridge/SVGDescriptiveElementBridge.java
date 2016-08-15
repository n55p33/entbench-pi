package org.apache.batik.bridge;
public abstract class SVGDescriptiveElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.GenericBridge, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.dom.svg.SVGContext {
    org.w3c.dom.Element theElt;
    org.w3c.dom.Element parent;
    org.apache.batik.bridge.BridgeContext theCtx;
    public SVGDescriptiveElementBridge() { super(); }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        org.apache.batik.bridge.UserAgent ua =
          ctx.
          getUserAgent(
            );
        ua.
          handleElement(
            e,
            java.lang.Boolean.
              TRUE);
        if (ctx.
              isDynamic(
                )) {
            org.apache.batik.bridge.SVGDescriptiveElementBridge b;
            b =
              (org.apache.batik.bridge.SVGDescriptiveElementBridge)
                getInstance(
                  );
            b.
              theElt =
              e;
            b.
              parent =
              (org.w3c.dom.Element)
                e.
                getParentNode(
                  );
            b.
              theCtx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                b);
        }
    }
    public void dispose() { org.apache.batik.bridge.UserAgent ua =
                              theCtx.
                              getUserAgent(
                                );
                            ((org.apache.batik.dom.svg.SVGOMElement)
                               theElt).setSVGContext(null);
                            ua.handleElement(theElt, parent);
                            theElt = null;
                            parent = null; }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        dispose(
          );
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        
    }
    public float getPixelUnitToMillimeter() {
        return theCtx.
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
        return theCtx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        theCtx.
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
    public float getViewportWidth() { return theCtx.
                                        getBlockWidth(
                                          theElt);
    }
    public float getViewportHeight() { return theCtx.
                                         getBlockHeight(
                                           theElt);
    }
    public float getFontSize() { return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeOzuO48TxI++HncRxAnHCHeEdzMtx4sThHLux" +
       "4wqnxNnbmztvvLe72Z2zz4bQJCVNWomUpgEChbRSg4AoEFRBaUVBqWgLFFqV" +
       "VymteKhFalpKIUKFqhTo/8/u3u7teTc6qVdLM96bmX9m/m/++eb/d/bk+2SS" +
       "oZNGqrAIG9OoEVmvsB5BN2iiXRYMow/KBsW7yoSPtp/ZvCZMKgbI9CHB6BIF" +
       "g3ZIVE4YA6RBUgwmKCI1NlOaQIkenRpUHxGYpCoDZJZkdKY1WRIl1qUmKDbo" +
       "F/QYqRMY06V4htFOqwNGGmIwkyifSbTNW90aI9NEVRtzms91NW931WDLtDOW" +
       "wUhtbKcwIkQzTJKjMclgrVmdrNRUeSwlqyxCsyyyU77UgmBT7NICCJoerfn4" +
       "09uHajkEMwRFURlXz9hCDVUeoYkYqXFK18s0bewit5CyGJnqasxIc8weNAqD" +
       "RmFQW1unFcy+miqZdLvK1WF2TxWaiBNiZEl+J5qgC2mrmx4+Z+ihklm6c2HQ" +
       "dnFOW1PLAhXvWBk9ctf22h+WkZoBUiMpvTgdESbBYJABAJSm41Q32hIJmhgg" +
       "dQosdi/VJUGWxq2VrjeklCKwDCy/DQsWZjSq8zEdrGAdQTc9IzJVz6mX5AZl" +
       "/ZqUlIUU6Drb0dXUsAPLQcEqCSamJwWwO0ukfFhSEows8krkdGy+HhqA6OQ0" +
       "ZUNqbqhyRYACUm+aiCwoqWgvmJ6SgqaTVDBAnZH5vp0i1pogDgspOogW6WnX" +
       "Y1ZBqykcCBRhZJa3Ge8JVmm+Z5Vc6/P+5qsO3aRsVMIkBHNOUFHG+U8FoUaP" +
       "0BaapDqFfWAKTmuJ3SnMfupgmBBoPMvT2GzzxM1nr1vVePo5s82CCdp0x3dS" +
       "kQ2Kx+PTX1rYvmJNGU6jUlMNCRc/T3O+y3qsmtasBgwzO9cjVkbsytNbfnnD" +
       "nhP0vTCp6iQVoipn0mBHdaKa1iSZ6huoQnWB0UQnmUKVRDuv7yST4TkmKdQs" +
       "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" +
       "j0PTJ3LVpnPpk/wRs4f/C1FZjhy4LQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IM9+LYKePIKM6UIegJWgK0TC4bnOGdh/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("93ZYw0f3sD/6I4L9zXNgfyvP/nEEveuUpmeK7SY3VvSv3w7E1/aIr/2IEP+L" +
       "cxD/Tp79s5O2jUTgfXSv3xtB/vatQm6D9NIe8ks/Epd//rpJWArDA8XRDEc5" +
       "wBimVzwdO/+/O0dA/zHP/m0EvX0noNO9z4jmd29VNM+BJO5FI/xIRHP9DbjD" +
       "9QniGHZ+LYE0EiW3AUOMI6W4jVHQ/a/nyOi/5dkfHkWLQ0pHVEDscLTrosV3" +
       "b4chSXtpSbfdd3YXDv/0HNg/zLM/iaB372DTka4EO+xgarkx5v95C5gfOrSQ" +
       "9R7z+vZgPgHpwr3n1N2fZ3dG0GOaEk2MTLE4x4hYd2xYlmEr0X4NfGYpdJdq" +
       "uUJ0JIALd92qAJ6A8us0u7/o9gvgsXPqHs+zRyLogUMBAPDjvOzBY3xvvwV8" +
       "j+aFT4K02ePb3H58V8+pe3+ePQXWegAfirpHF2zeVdwWEdLoQFNAsJgpEljH" +
       "a5ZS7R7jfvoWcL87L/wgSNs97u3tx109p66eZx+MoIcBbkYKFMVhA8EJ82up" +
       "hyJ44rQIEFUFU8DpVoUYDm41pjVBenkvhpdvjxiOY9qFZoH3xXNkgebZC0AW" +
       "4XWyOB3KLnz4VjX+DEgf30P9+O3XOHlOHZVngwi6BDSOsYUPN4+R4bfDlj+x" +
       "R/aJ249seU4dn2fMzpYHlisK1kn9nUTJ3mokzvX3yh7lK7cfpXxOnZpn1yLo" +
       "CkA5N5TUc4NoYcjFdxEno/FLt4rxWZA+ucf4yduP0TunLr9ke2EdQQ+dwIgr" +
       "hqZHZ0BatwryPSC9ugf56u0H+dPn1P1MnqURdD8A2XediDG2yhl42VuBl4HV" +
       "2DnfcuQX0x+77kOy3cdP0q+8fvmeR1/nfqf4nOHoA6V7SegeNbask/eITzxf" +
       "8gJFNQoZ3Lu7VewVwD4ZQY/eZPsQhB3xaJ/xws/t2r8KjPlse7B6Kv6fbPfp" +
       "CLrvuB0gtXs42eQzEXQHaJI/ftY7nMCeu9leJrLfWQVS28ko270rPHbSYIq1" +
       "68NvpoijLic/g8g3JYsv/A43EOPdN37XpK+9PqR+6vvNL+8+w5AsYbvNqdxD" +
       "QnfvvggpiOabkM/clNohrUv4cz9429fvfd/hhunbdgwfG+8J3p668TcPPduL" +
       "iq8Utr/26N/+8F99/feKu7D/F26hmbp6OQAA");
}
