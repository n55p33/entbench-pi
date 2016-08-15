package org.apache.batik.bridge;
public class SVGSVGElementBridge extends org.apache.batik.bridge.SVGGElementBridge implements org.apache.batik.dom.svg.SVGSVGContext {
    public SVGSVGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SVG_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSVGElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CanvasGraphicsNode(
          );
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CanvasGraphicsNode cgn;
        cgn =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            instantiateGraphicsNode(
              );
        associateSVGContext(
          ctx,
          e,
          cgn);
        try {
            org.w3c.dom.svg.SVGDocument doc =
              (org.w3c.dom.svg.SVGDocument)
                e.
                getOwnerDocument(
                  );
            org.apache.batik.dom.svg.SVGOMSVGElement se =
              (org.apache.batik.dom.svg.SVGOMSVGElement)
                e;
            boolean isOutermost =
              doc.
              getRootElement(
                ) ==
              e;
            float x =
              0;
            float y =
              0;
            if (!isOutermost) {
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getX(
                      );
                x =
                  _x.
                    getCheckedValue(
                      );
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getY(
                      );
                y =
                  _y.
                    getCheckedValue(
                      );
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            cgn.
              setVisible(
                org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e));
            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                se.
                getViewBox(
                  );
            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
              se.
              getPreserveAspectRatio(
                );
            java.awt.geom.AffineTransform viewingTransform =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                par,
                w,
                h,
                ctx);
            float actualWidth =
              w;
            float actualHeight =
              h;
            try {
                java.awt.geom.AffineTransform vtInv =
                  viewingTransform.
                  createInverse(
                    );
                actualWidth =
                  (float)
                    (w *
                       vtInv.
                       getScaleX(
                         ));
                actualHeight =
                  (float)
                    (h *
                       vtInv.
                       getScaleY(
                         ));
            }
            catch (java.awt.geom.NoninvertibleTransformException ex) {
                
            }
            java.awt.geom.AffineTransform positionTransform =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                x,
                y);
            if (!isOutermost) {
                cgn.
                  setPositionTransform(
                    positionTransform);
            }
            else
                if (doc ==
                      ctx.
                      getDocument(
                        )) {
                    ctx.
                      setDocumentSize(
                        new java.awt.Dimension(
                          (int)
                            (w +
                               0.5F),
                          (int)
                            (h +
                               0.5F)));
                }
            cgn.
              setViewingTransform(
                viewingTransform);
            java.awt.Shape clip =
              null;
            if (org.apache.batik.bridge.CSSUtilities.
                  convertOverflow(
                    e)) {
                float[] offsets =
                  org.apache.batik.bridge.CSSUtilities.
                  convertClip(
                    e);
                if (offsets ==
                      null) {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x,
                        y,
                        w,
                        h);
                }
                else {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x +
                          offsets[3],
                        y +
                          offsets[0],
                        w -
                          offsets[1] -
                          offsets[3],
                        h -
                          offsets[2] -
                          offsets[0]);
                }
            }
            if (clip !=
                  null) {
                try {
                    java.awt.geom.AffineTransform at =
                      new java.awt.geom.AffineTransform(
                      positionTransform);
                    at.
                      concatenate(
                        viewingTransform);
                    at =
                      at.
                        createInverse(
                          );
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      cgn.
                      getGraphicsNodeRable(
                        true);
                    cgn.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
            java.awt.RenderingHints hints =
              null;
            hints =
              org.apache.batik.bridge.CSSUtilities.
                convertColorRendering(
                  e,
                  hints);
            if (hints !=
                  null)
                cgn.
                  setRenderingHints(
                    hints);
            java.awt.geom.Rectangle2D r =
              org.apache.batik.bridge.CSSUtilities.
              convertEnableBackground(
                e);
            if (r !=
                  null) {
                cgn.
                  setBackgroundEnable(
                    r);
            }
            if (vb.
                  isSpecified(
                    )) {
                org.w3c.dom.svg.SVGRect vbr =
                  vb.
                  getAnimVal(
                    );
                actualWidth =
                  vbr.
                    getWidth(
                      );
                actualHeight =
                  vbr.
                    getHeight(
                      );
            }
            ctx.
              openViewport(
                e,
                new org.apache.batik.bridge.SVGSVGElementBridge.SVGSVGElementViewport(
                  actualWidth,
                  actualHeight));
            return cgn;
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        node.
          setComposite(
            org.apache.batik.bridge.CSSUtilities.
              convertOpacity(
                e));
        node.
          setFilter(
            org.apache.batik.bridge.CSSUtilities.
              convertFilter(
                e,
                node,
                ctx));
        node.
          setMask(
            org.apache.batik.bridge.CSSUtilities.
              convertMask(
                e,
                node,
                ctx));
        node.
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        ctx.
          closeViewport(
            e);
    }
    public void dispose() { ctx.removeViewport(
                                  e);
                            super.dispose(
                                    ); }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            boolean rebuild =
              false;
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_WIDTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_HEIGHT_ATTRIBUTE)) {
                    rebuild =
                      true;
                }
                else
                    if (ln.
                          equals(
                            SVG_X_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_Y_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGDocument doc =
                          (org.w3c.dom.svg.SVGDocument)
                            e.
                            getOwnerDocument(
                              );
                        org.apache.batik.dom.svg.SVGOMSVGElement se =
                          (org.apache.batik.dom.svg.SVGOMSVGElement)
                            e;
                        boolean isOutermost =
                          doc.
                          getRootElement(
                            ) ==
                          e;
                        if (!isOutermost) {
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getX(
                                  );
                            float x =
                              _x.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getY(
                                  );
                            float y =
                              _y.
                              getCheckedValue(
                                );
                            java.awt.geom.AffineTransform positionTransform =
                              java.awt.geom.AffineTransform.
                              getTranslateInstance(
                                x,
                                y);
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            cgn.
                              setPositionTransform(
                                positionTransform);
                            return;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_VIEW_BOX_ATTRIBUTE) ||
                              ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            org.w3c.dom.svg.SVGDocument doc =
                              (org.w3c.dom.svg.SVGDocument)
                                e.
                                getOwnerDocument(
                                  );
                            org.apache.batik.dom.svg.SVGOMSVGElement se =
                              (org.apache.batik.dom.svg.SVGOMSVGElement)
                                e;
                            boolean isOutermost =
                              doc.
                              getRootElement(
                                ) ==
                              e;
                            float x =
                              0;
                            float y =
                              0;
                            if (!isOutermost) {
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getX(
                                      );
                                x =
                                  _x.
                                    getCheckedValue(
                                      );
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getY(
                                      );
                                y =
                                  _y.
                                    getCheckedValue(
                                      );
                            }
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getWidth(
                                  );
                            float w =
                              _width.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getHeight(
                                  );
                            float h =
                              _height.
                              getCheckedValue(
                                );
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
                              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                                se.
                                getViewBox(
                                  );
                            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
                              se.
                              getPreserveAspectRatio(
                                );
                            java.awt.geom.AffineTransform newVT =
                              org.apache.batik.bridge.ViewBox.
                              getPreserveAspectRatioTransform(
                                e,
                                vb,
                                par,
                                w,
                                h,
                                ctx);
                            java.awt.geom.AffineTransform oldVT =
                              cgn.
                              getViewingTransform(
                                );
                            if (newVT.
                                  getScaleX(
                                    ) !=
                                  oldVT.
                                  getScaleX(
                                    ) ||
                                  newVT.
                                  getScaleY(
                                    ) !=
                                  oldVT.
                                  getScaleY(
                                    ) ||
                                  newVT.
                                  getShearX(
                                    ) !=
                                  oldVT.
                                  getShearX(
                                    ) ||
                                  newVT.
                                  getShearY(
                                    ) !=
                                  oldVT.
                                  getShearY(
                                    ))
                                rebuild =
                                  true;
                            else {
                                cgn.
                                  setViewingTransform(
                                    newVT);
                                java.awt.Shape clip =
                                  null;
                                if (org.apache.batik.bridge.CSSUtilities.
                                      convertOverflow(
                                        e)) {
                                    float[] offsets =
                                      org.apache.batik.bridge.CSSUtilities.
                                      convertClip(
                                        e);
                                    if (offsets ==
                                          null) {
                                        clip =
                                          new java.awt.geom.Rectangle2D.Float(
                                            x,
                                            y,
                                            w,
                                            h);
                                    }
                                    else {
                                        clip =
                                          new java.awt.geom.Rectangle2D.Float(
                                            x +
                                              offsets[3],
                                            y +
                                              offsets[0],
                                            w -
                                              offsets[1] -
                                              offsets[3],
                                            h -
                                              offsets[2] -
                                              offsets[0]);
                                    }
                                }
                                if (clip !=
                                      null) {
                                    try {
                                        java.awt.geom.AffineTransform at;
                                        at =
                                          cgn.
                                            getPositionTransform(
                                              );
                                        if (at ==
                                              null)
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                );
                                        else
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                at);
                                        at.
                                          concatenate(
                                            newVT);
                                        at =
                                          at.
                                            createInverse(
                                              );
                                        clip =
                                          at.
                                            createTransformedShape(
                                              clip);
                                        org.apache.batik.ext.awt.image.renderable.Filter filter =
                                          cgn.
                                          getGraphicsNodeRable(
                                            true);
                                        cgn.
                                          setClip(
                                            new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                                              filter,
                                              clip));
                                    }
                                    catch (java.awt.geom.NoninvertibleTransformException ex) {
                                        
                                    }
                                }
                            }
                        }
                if (rebuild) {
                    org.apache.batik.gvt.CompositeGraphicsNode gn =
                      node.
                      getParent(
                        );
                    gn.
                      remove(
                        node);
                    disposeTree(
                      e,
                      false);
                    handleElementAdded(
                      gn,
                      e.
                        getParentNode(
                          ),
                      e);
                    return;
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public static class SVGSVGElementViewport implements org.apache.batik.bridge.Viewport {
        private float width;
        private float height;
        public SVGSVGElementViewport(float w,
                                     float h) {
            super(
              );
            this.
              width =
              w;
            this.
              height =
              h;
        }
        public float getWidth() { return width;
        }
        public float getHeight() { return height;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HOsMAPbgDHsH6TBJUE0Gk88VEtUJ/qnb5ejMgEEXhjW2bnrd0AE2XLBsuXDn" +
           "bijHOoOpX59h72E6fIWgWnBDv1MJHD8c/l/4IU9Qa8lHrp3pq+/guQzJuqDo" +
           "kxz/jCQ+ezZUM//s/W+zPC186qmHjEubsuxGC9e8WtNxWmLuqOfYwTukUwTN" +
           "L6MXVBE+YQac5PSPEdTkpwcYYL/ddGcIqnPoQBSfuEm+SVAFkNDptzTbSU2s" +
           "A6GgGeGgmQ+4ipjlfXZprbe7tAKL+xlGSw/7JGqXCZN/FE2Il85u2/7AzU8+" +
           "xZ+BoixMTVEps6H95C/SQqlZWlaaLau6f+Wtxudql9sVuZkr7ET+Ild4DkOk" +
           "a7T7Wuh7IxnhwlPpnXMbXvzpkeo3oYvZhQICQXN2FbcXec2EGr8rVtxmQ1lm" +
           "j7eulY9NblyT/suvWQOHeFveVp4+IV49v/ut4wvOwSNv9gCqArDBedb3bJlU" +
           "hrE4rsdRg2T05kFFkCIJsqeHb6TBKdCPpcwvljsbCqv0IwJBncUPmOJPL9Ds" +
           "TmB9s2oqKVZ8ARacFc+3Wrtam5rmY3BWXI+8LXRYn6e3AfGYiA1qmv2+q96m" +
           "sdzu9b9l2CLjfp5N6XD5v2uh0LcuGQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028784000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVaecwkR3Xv/exd7y62d73gI45vFoLd6Ou5Z1omkJ6enpme" +
           "u3t6pns6wNLXdPf0ffcMcWLIgQUSWLAQooAjBVDAMoeioCBFRI6iBBAoEhHK" +
           "JQVQFCkkBAn/ERKFJKS657v3cKwkn76vpqbq1av3Xr33q6pX3ws/gE4HPgS7" +
           "jrlWTSfcVdJwd2VWd8O1qwS7vUF1IviBIuOmEAQMaLsiPfaFCz/68bPaxR3o" +
           "DA+9WrBtJxRC3bEDWgkcM1bkAXThsJUwFSsIoYuDlRALSBTqJjLQg/DJAfSq" +
           "I0ND6PJgXwQEiIAAEZBcBAQ7pAKD7lDsyMKzEYIdBh70i9CpAXTGlTLxQujR" +
           "40xcwResPTaTXAPA4Wz2fQ6UygenPvTIge5bna9R+MMwcvXX337xd2+BLvDQ" +
           "Bd2eZuJIQIgQTMJDt1uKJSp+gMmyIvPQXbaiyFPF1wVT3+Ry89ClQFdtIYx8" +
           "5cBIWWPkKn4+56Hlbpcy3fxICh3/QL2lrpjy/rfTS1NQga73HOq61bCdtQMF" +
           "z+tAMH8pSMr+kFsN3ZZD6OGTIw50vNwHBGDobZYSas7BVLfaAmiALm3XzhRs" +
           "FZmGvm6rgPS0E4FZQuj+GzLNbO0KkiGoypUQuu8k3WTbBajO5YbIhoTQ3SfJ" +
           "ck5gle4/sUpH1ucHoze9/512197JZZYVyczkPwsGPXRiEK0sFV+xJWU78PYn" +
           "Bh8R7vnyMzsQBIjvPkG8pfn9X3jp59740Itf3dL89HVoxuJKkcIr0ifFO7/5" +
           "AP44eksmxlnXCfRs8Y9pnrv/ZK/nydQFkXfPAcesc3e/80X6TxdPP698fwc6" +
           "T0JnJMeMLOBHd0mO5eqm4ncUW/GFUJFJ6Jxiy3jeT0K3gfpAt5Vt63i5DJSQ" +
           "hG4186YzTv4dmGgJWGQmug3UdXvp7NddIdTyeupCEHQJ/EEYBJ36IJT/bD9D" +
           "6O2I5lgKIkiCrdsOMvGdTP8AUexQBLbVEBF4vYEETuQDF0QcX0UE4Aeastch" +
           "+rqsKsh03gG/GTyAgc28bTfzM/f/fYY00/FicuoUMP8DJ4PfBHHTdUxZ8a9I" +
           "V6Mm8dLnrnx95yAY9qwTQhiYdHc76W4+6e520t3rTHr5WNtcVxLXAZFz6lQu" +
           "wWsykbaLD5bOACAA4PH2x6dv673jmcduAV7nJrdm1gekyI1RGj+EDTIHRwn4" +
           "LvTiR5N3zX+psAPtHIfbTA3QdD4bPslA8gAML58Ms+vxvfCe7/3o8x95yjkM" +
           "uGP4vYcD147M4vixkwb3HUmRATIesn/iEeGLV7781OUd6FYADgAQQwE4MLDY" +
           "QyfnOBbPT+5jY6bLaaDw0vEtwcy69gHtfKj5TnLYknvCnXn9LmDjC5mDXwa2" +
           "/s09j88/s95Xu1n5mq3nZIt2Qosce3926n78r/7sH8u5ufdh+sKRjW+qhE8e" +
           "gYaM2YUcBO469AHGVxRA97cfnXzowz94z8/nDgAoXnu9CS9nJQ4gASwhMPOv" +
           "ftX76+98+5Pf2jl0mhDsjZFo6lJ6oOTZTKc7b6IkmO31h/IAaDFB8GVec3lm" +
           "W46sL3VBNJXMS//jwuuKX/zn91/c+oEJWvbd6I0vz+Cw/aea0NNff/u/PpSz" +
           "OSVlW9uhzQ7Jtnj56kPOmO8L60yO9F1//uBvfEX4OEBegHaBvlFyANvJbbAD" +
           "Bj1+k+ONr1tgNeK9LQF56tJ3jI9977NbuD+5f5wgVp65+t6f7L7/6s6RTfa1" +
           "1+xzR8dsN9rcje7YrshPwM8p8Pdf2V+2ElnDFmgv4Xto/8gB3LtuCtR59GZi" +
           "5VO0/+HzT/3Bp596z1aNS8f3GAIcoT77F//5jd2Pfvdr14E24LmOkK9kORcU" +
           "yQV9Ii93M8lys0J535NZ8XBwFDeOW/jI6e2K9Oy3fnjH/Id/+FI+6fHj39Ew" +
           "GQru1kR3ZsUjmcb3ngTJrhBogK7y4uitF80Xfww48oCjBLaDYOwD8E6PBdUe" +
           "9enb/uaP/vied3zzFminDZ0HWsptIccn6BwABiXQAO6n7lt+bhsYSRYpF3NV" +
           "oWuU38bTffm30zf3sHZ2ejtEt/v+fWyK7/67f7vGCDkoX8fpToznkRc+dj/+" +
           "5u/n4w/RMRv9UHrthgZOuodjS89b/7Lz2Jk/2YFu46GL0t4xei6YUYY5PDg6" +
           "Bvtna3DUPtZ//Bi4PfM8eYD+D5z0+iPTnsTlQ28D9Yw6q58/AcW53R8A6PSh" +
           "PZT60EkoPgXlFTIf8mheXs6Kn9lHvttcX49B0OScK8CvE13enm/KWxjPyjdl" +
           "RW+7mm+54cq3jsv1IOB/dU+uqzeQi7qBXFl1uC/SGU3RVS28nkz0y8qU80hP" +
           "AU1Pl3bru4XsO3f9WW/Jqm8A8wX51SWLcd0WzH0x7l2Z0uV9sJmDqwxwx8sr" +
           "s56zuRtc3vJIyhZ+d3v+PyFr5X8sK4iUOw+ZDRxwlXjf3z/7jQ+89jvAnXvQ" +
           "6ThzNeDFR2YcRdnt6tde+PCDr7r63fflexsw4/zp133/6YyrdDONs+KtWfG2" +
           "fVXvz1Sd5gfHgRCEw3w7UuQDbQtH9KmFYFNz/hfahnd8qVsJSGz/ZzBftNhk" +
           "lqasMkZQtYOGdidJCBGbWM64b8trYiTymJvSqmhV683AsfyuM1+JJSQS465S" +
           "98m6UIVlQ+sb7dDxdJJsVbHlrG9MDZ2cOrjl+SOtPS/iPF0w3J4wGhdwzxam" +
           "3nw0W4w915y7Vr3Gl8QyGjHBym2KWoNbWTGzjGPOjpcsUqqoxRmv6A62DgxK" +
           "XxRFgq61GdKoYfwYlXR8oayJcEFXPGNQqVXrfgmVujNuJo3YRXtRxGatUWIv" +
           "GNNM252629SIGUEH4lCq0IzVkTupupwnquH5xEwIjdaYKrA0aQ493Rris0V7" +
           "SS0EbUEWBNaYLnGst8BVVNMcwmIFehCjpWIhneOwV/LoVhw02+VoIjg8Va2u" +
           "1y2nLy4mVlvSey5heMN0PW3KCl0KiyZdHepjv0cONr1Bb8JZSnXRDgOOJwZj" +
           "tzFYciufHQi9iMXHDq56C2XBJ6hGVbmOpHsdKkAdv1Jdp91NiexbPSd0ooXT" +
           "bQ0nK6qvFURtNgoFLfEKYgPvg7sybTE2YZrTUJ9TmuryNY3V8UFEBcPZaMhX" +
           "mxS13ogdZrSIarQ6EJX1ekh354ZiM3DRhY1KGw/m9LTd63gtR+8TXdVoqZX2" +
           "WJmyLaU2W1tAppHVnALnGEdTkgiZolEqdwA9sVB7xRJc16Y1oROKvLWoxZVm" +
           "vTkKCzNdcLgNEW3UwQD2DH9AqXxgK8vFWi8HDhyqi16B0CPTxZTBeOEZklGl" +
           "ZtQiRrvYTEyqjTZm4bIpDQ0vFcaeSREsgYUTgjYoySTodatgYmtq7hmU2nKb" +
           "eCPou2KdbXbbw/UYI1YzdVmmW0vMc4WquupTJu7blbSnmqFQGwRmESlLpUFd" +
           "q2Gjfpz2CEzGqtqM5Wurhmi13AYzHFZW3GyoSBhfKy7bjOpvuJU6pTGdZMtl" +
           "wh4Lda6+rgqzctecS5WNQE5HrWgK15skEfWr/HgoikzBLxZlasQ6hSLfcqpc" +
           "EPDAcPy4WKgyrDOcDPtEZFrpqNYYxmtmk8INddSYOL7TnOMlL3Ct1rjjsEU+" +
           "sdbz1VLX2ABPpnbTxMK5SaJit4FtFr0q0yYTDi3RjBYtWv1m35oW5x6cxlKb" +
           "EOg2xhWltjQL+95ElgjD4jYxuaAEh1gWySJVaWk6gmixGvNEUHLGdDKnZzjd" +
           "XlF1t+9zS50YtKeLXhyghEFPiotiuznqzsjEizzew5qpMeRY2uxzM82QurQt" +
           "4zHqUlSrs2GTkIpGQ7gOL42+VNq4BtkctlBxWTfMdTuGzVlVW7LEuFOM6n65" +
           "Ko7JYtdUC53pJiZG1Aj4eMWh2yWBpJYd3UyFkb4Z6b6Gz0rtDWYQFsZvvJnf" +
           "aERdL/UwkmqyEbex1goaK2S1MCe6nEDjXHHiNktKiDtpzZjJtjnRe7LQ8QSW" +
           "M+P6TGvOUxMfkM0eY+BWRR4HfL8d61aP49GZjfUpKTL9lapGfcl3nEpTZr1u" +
           "J13MLH8mCRtGXgysSGcWC0JkRqajTA3fW9Vqkm1rDkqE5WaxS+lpq7DGHUd0" +
           "aVQfiUUqLozhddjqi5aWoBISd5m1OvZnOIYYJULjU8IMaxOmq48aKM5150TU" +
           "XlecWWuhiCXWW2k0iUtqIY4aPUTrz9qyvLLsMJxiCWvON4mxLos9lCOUdbTy" +
           "NX/QUkVW3EQ0xpK8xywofZLWCgYvIm59tR6t4lE1GA0rjaLdrIwHDIl6PIfU" +
           "g1UVVeu+QPcU2gPwmNS43ny49gJNZkNelwMZdhYYWqq7wGKT7mDVwCtsUMBT" +
           "fzRtLhi/BNai1U+o8hKx5ogCN2S4LBUFjKkmjFomUnxepeJO22yJrCclM7Ui" +
           "LthVq0i3OorTXvF+glA+4VanrNafDgV2gPbrdKOuzJBuqaxL01ZL14odoVSJ" +
           "k7aFCJthDR55SlyWkiHVoR2/uxpWlKGJqNVVREccLVkeXa9qaDVYIrRZodZY" +
           "k6Ydqurj/njRsSgYL5trG2ZovaeWyena6BY3zSiRJZQqx20S7mjl8siJvIDA" +
           "arK/ZPxaY7wS4WLVNotpa1iFo1k9ELmuMWpL5HwxK0swjTTjpNVAyCU86y+Z" +
           "JoiyAVNg23rBVXsdqzrrbkxmVFgVKy1HlYWyFtYrsbMpYxjCTiKywXddv1yY" +
           "jRl/JFaq5dEw6luqU27BqBe1zAJLwEV24zP9xXpVT2CuFW/UGjXuRvNFyNmb" +
           "SFuKG2D5BoxwZE2GG6xKsiQ5B4iomCjawwY8E0VyXaxM+RBmfUdryEI/9lRB" +
           "Xasdc0yjblghxyyLT0v8YsrLRZgrTK1NU6TXaMfA53MOG8hjApgdmDhM5QKm" +
           "piu6JdZqy5YUjGRKLJSrlocScD/10kZh1a0nFaNohaJcllNlSM26q4EFW0ni" +
           "e43YhLVxwK3wDVXmQhNOFaGKR2WqQ0o90sOq0mLc5bFyfW3EbZub+20ErfXn" +
           "VQWFHWpIwHNMjph41vPb/RWr63RpqOLCWCluShu9x/bxopNYvO54Q7/qqKzo" +
           "VsJBtVyNGXwYLzwFGS3L9RYsTji2b08jMm1rHB02CthGSYhardvS/BmCIpOk" +
           "zBj1RO852qScNnCkVqUKFQWOCohubsbJoEms41WlgnYGzHoTlJYqXCnLlM71" +
           "u40Gi7bWeD0pxxNN3ixVtzyfJDWd5bqzXtuJfRMAqmWFq8bQT+r4cgF2rAac" +
           "1rlk3ZgoFc/p1MRJSZZTxE8LvQJpShSDYhUiMMNI3VD1hdBt4UyDaGq4mDbt" +
           "QYrqFV2tLMO0bZseP2jgfncSqL3NFJtJdhGfxm0YZmrA4pTkDIfRQJfZkaaV" +
           "FXceNxGbKa5shucpLlr2CqV2KeAZM8JGw8Bc9fiZ4Y+KWOpVjbjeN3Sb4Jte" +
           "0FKSyhpm6UYZTiuk6LjFBi6C46Gl1tcbjpYddOgV5Hq0kJZ9VLRbRmnJKMWK" +
           "YJUpz7JEqrX0J0p1VOjyE1WtreVahakrjVI3RmS0MeY33HI6CsfFVRgU0piJ" +
           "UzCn1/BtoMbcTBBUULrjlWyhMoo1B4hQXePIulQZcmA/rFGrROFJtGY7fLub" +
           "jBtMu6xU+zEzZNrFdBHU14lXLpfcboOfsHUG5SM1CLVJy6uEtag7DobYRFRb" +
           "3aBbY5q9GVHoGI3GnAhnPcSzxaqyGqoEwWkrtiTaPogBosQNmkHEtWxRX3XH" +
           "ztjlqqhWLxG1JcmqrN1sxcVhr9tqSIiJVMgZSgkNs+u7ZdeDETWiNr0IHL6M" +
           "dIOscApWNvxsiCABwsKbCV5s1DyruyIiMYjSDo4qDTYcpaw1iLzxcpEwkTFL" +
           "mNGgNuTmTQIGu7tUnUwnhMwYbiItFgNEljsS6dkTh2pOlxFhwdM51jZGLTfc" +
           "MOJ0VgqwWkftKB0V4GFFd1fmkuNdX1TqIdYfwKnZmSZIHZwOOZwfIW2iRJqN" +
           "alRC6thmBryVh5uOng6ZOeEGtS5axZEp5Zk8awrCQIhqS5gN00j2TDSYR7zh" +
           "1wkGJk250jLGhlBn6myk1cnU1hJz4trcUORicFpQnLKziHmNInGKG5XaosQp" +
           "Uono+A1/HqYWVTStVV2JzAU6Es01gwRRzAIMVNqxMncrMDmvoDEShZUkHifT" +
           "UYyquIf5raYii2CLNGeaT1T8QKbVElOoGu22gZO9wFO6IljsvoxPXCmJzVUg" +
           "4l5cIJNe05ZmE2vcmwzQVsBYTRSclbz+nG9gtABOV3CZ9UPBqvrWotxkORJu" +
           "DDh6YdeUMrbsLHSs6FlxCfbQmhXImwgVUbOED1ZLtzqqca1qXIq0wkCKOhSG" +
           "ZVc455VdLe/Kb9EHT2rgRpl1XHkFt8f0+hPuHE54mMbN01B3nXydOZrGPUxQ" +
           "ndq/yD9yo1eL/UeJLNf24I1e2vLM4iffffU5efyp4s5eBrAeQmf2HkAPJ8xy" +
           "rk/cOCM2zF8ZD9NSX3n3P93PvFl7xyt4p3j4hJAnWX5m+MLXOq+XPrgD3XKQ" +
           "pLrm/fP4oCePp6bO+0oY+TZzLEH14IH9795PBH1iz/6fuP5bwY2zQG/YOs5N" +
           "sqvP3KTvvVnxyyF0VlVC9iCxdehnv/JyWYqjDPOGp4/r9hAQ8/k93Z7/v9ft" +
           "6k36PpIVHwihc0C37mGG7FC5Z1+JcmkI3X3dF7j9qIBfwVsecOz7rvl/ge0b" +
           "t/S55y6cvfe52V/m71YH79DnBtDZZWSaR7OeR+pnXF9Z6rna57Y5UDf/+K0Q" +
           "uvcGcoGI21ZyBZ7b0v92CF08SR9Cp/PPo3SfCqHzh3SA1bZylOTTIXQLIMmq" +
           "n3GvkwPcJn/TU0cCfs+F8sW59HKLczDk6LNWBhL5/2vsB3S0/Y+NK9Lnn+uN" +
           "3vlS7VPbZzXJFDabjMvZAXTb9oXvABQevSG3fV5nuo//+M4vnHvdPnrduRX4" +
           "0J2PyPbw9d+wCMsN81enzZfu/b03/c5z385Tkv8N0oSVw0gjAAA=");
    }
    public java.util.List getIntersectionList(org.w3c.dom.svg.SVGRect svgRect,
                                              org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                if (gn instanceof org.apache.batik.gvt.ShapeNode) {
                    org.apache.batik.gvt.ShapeNode sn =
                      (org.apache.batik.gvt.ShapeNode)
                        gn;
                    java.awt.Shape sensitive =
                      sn.
                      getSensitiveArea(
                        );
                    if (sensitive !=
                          null) {
                        sensitive =
                          at.
                            createTransformedShape(
                              sensitive);
                        if (sensitive.
                              intersects(
                                rect))
                            ret.
                              add(
                                curr);
                    }
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextIntersectionSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else {
                        ret.
                          add(
                            curr);
                    }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public java.util.List getEnclosureList(org.w3c.dom.svg.SVGRect svgRect,
                                           org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextEnclosureSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else
                        if (rect.
                              contains(
                                gnBounds)) {
                            ret.
                              add(
                                curr);
                        }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public boolean checkIntersection(org.w3c.dom.Element element,
                                     org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                return org.apache.batik.bridge.SVGTextElementBridge.
                  getTextIntersection(
                    ctx,
                    element,
                    ati,
                    rect,
                    true);
            }
        }
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        if (gn !=
              null)
            gnBounds =
              gn.
                getSensitiveBounds(
                  );
        if (gnBounds ==
              null)
            return false;
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        if (!rect.
              intersects(
                gnBounds))
            return false;
        if (!(gn instanceof org.apache.batik.gvt.ShapeNode))
            return true;
        org.apache.batik.gvt.ShapeNode sn =
          (org.apache.batik.gvt.ShapeNode)
            gn;
        java.awt.Shape sensitive =
          sn.
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        sensitive =
          at.
            createTransformedShape(
              sensitive);
        if (sensitive.
              intersects(
                rect))
            return true;
        return false;
    }
    public boolean checkEnclosure(org.w3c.dom.Element element,
                                  org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                gnBounds =
                  org.apache.batik.bridge.SVGTextElementBridge.
                    getTextBounds(
                      ctx,
                      element,
                      true);
                org.w3c.dom.Element p =
                  (org.w3c.dom.Element)
                    element.
                    getParentNode(
                      );
                while (p !=
                         null &&
                         gn ==
                         null) {
                    gn =
                      ctx.
                        getGraphicsNode(
                          p);
                    p =
                      (org.w3c.dom.Element)
                        p.
                        getParentNode(
                          );
                }
            }
            else
                if (gn !=
                      null)
                    gnBounds =
                      gn.
                        getSensitiveBounds(
                          );
        }
        else
            if (gn !=
                  null)
                gnBounds =
                  gn.
                    getSensitiveBounds(
                      );
        if (gnBounds ==
              null)
            return false;
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        return rect.
          contains(
            gnBounds);
    }
    public boolean filterChildren(org.w3c.dom.Element curr,
                                  org.w3c.dom.Element end,
                                  java.util.Set elems,
                                  java.util.List ret) {
        org.w3c.dom.Node child =
          curr.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child instanceof org.w3c.dom.Element &&
                  filterChildren(
                    (org.w3c.dom.Element)
                      child,
                    end,
                    elems,
                    ret))
                return true;
            child =
              child.
                getNextSibling(
                  );
        }
        if (curr ==
              end)
            return true;
        if (elems.
              contains(
                curr))
            ret.
              add(
                curr);
        return false;
    }
    protected java.util.Set getAncestors(org.w3c.dom.Element end,
                                         org.w3c.dom.Element base) {
        java.util.Set ret =
          new java.util.HashSet(
          );
        org.w3c.dom.Element p =
          end;
        do  {
            ret.
              add(
                p);
            p =
              (org.w3c.dom.Element)
                p.
                getParentNode(
                  );
        }while(p !=
                 null &&
                 p !=
                 base); 
        if (p ==
              null)
            return null;
        return ret;
    }
    protected org.w3c.dom.Element getNext(org.w3c.dom.Element curr,
                                          org.w3c.dom.Element base,
                                          org.w3c.dom.Element end) {
        org.w3c.dom.Node next;
        next =
          curr.
            getNextSibling(
              );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        while (next ==
                 null) {
            curr =
              (org.w3c.dom.Element)
                curr.
                getParentNode(
                  );
            if (curr ==
                  end ||
                  curr ==
                  base) {
                next =
                  null;
                break;
            }
            next =
              curr.
                getNextSibling(
                  );
            while (next !=
                     null) {
                if (next instanceof org.w3c.dom.Element)
                    break;
                next =
                  next.
                    getNextSibling(
                      );
            }
        }
        return (org.w3c.dom.Element)
                 next;
    }
    public void deselectAll() { ctx.getUserAgent(
                                      ).deselectAll(
                                          );
    }
    public int suspendRedraw(int max_wait_milliseconds) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              addRedrawSuspension(
                max_wait_milliseconds);
        return -1;
    }
    public boolean unsuspendRedraw(int suspend_handle_id) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              releaseRedrawSuspension(
                suspend_handle_id);
        return false;
    }
    public void unsuspendRedrawAll() { org.apache.batik.bridge.UpdateManager um =
                                         ctx.
                                         getUpdateManager(
                                           );
                                       if (um !=
                                             null)
                                           um.
                                             releaseAllRedrawSuspension(
                                               );
    }
    public void forceRedraw() { org.apache.batik.bridge.UpdateManager um =
                                  ctx.
                                  getUpdateManager(
                                    );
                                if (um !=
                                      null)
                                    um.
                                      forceRepaint(
                                        );
    }
    public void pauseAnimations() { ctx.getAnimationEngine(
                                          ).
                                      pause(
                                        );
    }
    public void unpauseAnimations() { ctx.
                                        getAnimationEngine(
                                          ).
                                        unpause(
                                          );
    }
    public boolean animationsPaused() { return ctx.
                                          getAnimationEngine(
                                            ).
                                          isPaused(
                                            );
    }
    public float getCurrentTime() { return ctx.
                                      getAnimationEngine(
                                        ).
                                      getCurrentTime(
                                        );
    }
    public void setCurrentTime(float t) {
        ctx.
          getAnimationEngine(
            ).
          setCurrentTime(
            t);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a/Exje/fM7mtJmr0R/wRn87+G3bf7m0pMgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7ebAsV3nf3Pe0S+hpMUjGSEIbIMa87tlnLIzp6Zmetffp" +
       "7plmEb1Pz/Q2vc+AiCBFoAxFKFvY2GVkUyUnNiUjyoGKXQ6xsmCbspMqHFdM" +
       "krKhSKqMI5Myf0BSxrFzumfunXvve+8qqvt86843Ped8Z/l95zvf951z+rzw" +
       "3cKNgV8oeq61Niw3vKyl4eWFVbscrj0tuDwc1yjJDzQVtaQgmIC0p5RHvnjp" +
       "Bz/81PyuC4WbxMK9kuO4oRSarhMwWuBasaaOC5f2qV1Ls4OwcNd4IcUSFIWm" +
       "BY3NIHxyXLj9WNGw8Nj4sAsQ6AIEugDlXYCQPRco9BrNiWw0KyE5YbAqfLBw" +
       "MC7c5ClZ98LCwycr8SRfsnfVUDkCUMMt2W8egMoLp37hjUfYt5ivAPzpIvTs" +
       "z7/3rt+8WLgkFi6ZDpt1RwGdCEEjYuEOW7NlzQ8QVdVUsXC3o2kqq/mmZJmb" +
       "vN9i4Z7ANBwpjHztSEhZYuRpft7mXnJ3KBk2P1JC1z+Cp5uapR7+ulG3JANg" +
       "fd0e6xYhlqUDgLeZoGO+LinaYZEblqajhoWHTpc4wvjYCDCAojfbWjh3j5q6" +
       "wZFAQuGe7dhZkmNAbOibjgFYb3Qj0EpYeP01K81k7UnKUjK0p8LC/af5qG0W" +
       "4Lo1F0RWJCy89jRbXhMYpdefGqVj4/Nd4u2ffL/Tdy7kfVY1xcr6fwso9OCp" +
       "Qoyma77mKNq24B1vHf+c9LqvfOxCoQCYX3uKecvzLz/wvXf++IMv/cGW58eu" +
       "wkPKC00Jn1Kel+/8+hvQJ1oXs27c4rmBmQ3+CeS5+lO7nCdTD8y81x3VmGVe" +
       "Psx8ifm92TOf116+ULhtULhJca3IBnp0t+Lanmlpfk9zNF8KNXVQuFVzVDTP" +
       "HxRuBs9j09G2qaSuB1o4KNxg5Uk3uflvICIdVJGJ6GbwbDq6e/jsSeE8f069" +
       "QqFwM/gU3gA+7yhs/96ekbDwXmju2hokKZJjOi5E+W6GP4A0J5SBbOeQDLR+" +
       "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" +
       "UwkIVz2SycNXyMSIw8tXcOZi+fg5xHJ/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AA==");
}
