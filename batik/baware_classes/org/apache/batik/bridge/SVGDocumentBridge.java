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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VO7VcJGG2saKw9o493v8E8n7/wPpSRNk9zEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3jld6enT11V3RXqSRv7k1KXVI0cD/UA+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rk+ARO8Hmj57J3JsSte/EPmRnSmec+P6wXPKPpSTDySlew09GQCpYzC2ujBm" +
       "Cis+NuCf+37H1CfbLTJ+9jTER0Hi9hC5i4f4r88p+9WcfCQp3Q0gsoGquIP9" +
       "6JzA99GbxfcISNM9vunF43vhnLIXc/JrSellAN+hER7666Pn+/ixAn79JhSQ" +
       "v8NRlC/2ClhcjAIuFwyX859STqiC6zPnqOKzOfkPSekBNdJB8Dp7bckd4/30" +
       "TeAtXlzBQHp2j/edF4P3yvFMs8NbyFywfv4c0F/IyR+CqWieWq52EnPBHpyY" +
       "gOKkdMsqsE4Y/h/drB7eCtJ793p478Xo4dL+Fay9DT9+8gIdzBB+AuJ0un+n" +
       "Nf9ZNPKVczT0tZx8KSk9bBazWWvYx5MkOryZLNrIOb54rJYvX4Ra3r9Xy/sv" +
       "VC35z68WDH9+DuT/npOXTkLODQKEBz1Krg/5mzcL+S0g/coe8q/8kCB/5xzI" +
       "/zsn30pKrzkFeax7wer6iP/yZhHjIH1ij/gTPyTEf3sO4r/LyV+DKH+EmDTB" +
       "8kZN9KilJMqhgZ+B/TcXEfpe2MN+4Yfi8k9dM22pcXyg+4bl6wckz7eLpyPn" +
       "v3THjZV06e6cXElKr9wp6XTt06q5dMvNqmYI0m/tVfNbPxTVVG+4Asd9y8vf" +
       "QmKtlZ7HN2ueJnrxIlahh1efo6OHc3L/kSEdtnTUCjAr3zhrSJceuAhD+t29" +
       "tn73wv1HK6BdPQf2m3LyWFJ67Q72MDH1aIcdTC3Xx/z4zWJ+DUi/v8f8+xeD" +
       "+SSk8jllBQAoKd2uWXEYxPoZaG++CWjFnjXfo35hD+0LFw/tLeeUvS0njaT0" +
       "EFgDc1amu4JvJZOgb7mu5enJfgN7Zil068INlORYAdjNKiDfBHx5r4AvX7wC" +
       "eueU9XPS2W1yCgUA8EXe24/xUTeB78E8M9/EfWWP7ysXj296Tlm+IL40BrYL" +
       "8BFEcPTm32uK19iUdXJg6CAOjnUV7H8MV6+0jnHzN4H7tXnmj4L01T3ur148" +
       "bv2csvx9sUvvADsagJsHuxrdn0SKH+cv2x+q4JHTKsAXCzC7neYq1KDcbOhC" +
       "QfraXg1fuxg1HIfrS1aBNz5HF2lOfKCL+BpdnAllwc2OeH4i8/U91K9f/Ij/" +
       "1Dll78rJNindBkacnBQ+bB0je+dF2PI39si+cfHI3ndO2c/m5Gd2tky5wVxx" +
       "T47fSZTvudlInI/fS3uUL108yg+dU/ZLOfn5pHQfQCla+joMomRqacX3XCej" +
       "8S/cLMbXg/TNPcZvXjzGXz2n7OM5eT4p3X8CI61bhpmcAfnLNwsyP1v6sz3I" +
       "P7t4kC+eU/Zvc/LJ3blaJ/AT3trqZ+D9mx8EXgb0dc13aflHNg9d89nr7lNN" +
       "9Teev/eOB58Xvlp8mnX0OeWdbOmOReq6J7+JOPF8WxjpiyKYlu7cfSERFnB+" +
       "Jyk9eIPTQBBs5kfngZc+veP/DDDhs/xgzVT8P8n3e0nprmM+0NTu4STLHySl" +
       "K4Alf/zD8HDaOvEC+u7TkGy3x3nopDUUG9bvu884qnLyy638uqD47PjwaD/d" +
       "fXj8jPri893BO7+Lfnz35ZjqKttt3sodbOn23UdsRaP59cATN2ztsK3b6Ce/" +
       "d89v3vnGw6uMe3YCH1vmCdkeu/5nWm0vTIoPq7a/8+C/f8snnv9G8Qb+/wcp" +
       "2kU0Dz4AAA==");
}
