package org.apache.batik.dom.svg12;
public class SVG12DOMImplementation extends org.apache.batik.dom.svg.SVGDOMImplementation {
    public SVG12DOMImplementation() { super();
                                      factories = svg12Factories;
                                      registerFeature("CSS", "2.0");
                                      registerFeature("StyleSheets", "2.0");
                                      registerFeature("SVG", new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
                                      registerFeature("SVGEvents",
                                                      new java.lang.String[] { "1.0",
                                                      "1.1",
                                                      "1.2" });
    }
    public org.apache.batik.css.engine.CSSEngine createCSSEngine(org.apache.batik.dom.AbstractStylableDocument doc,
                                                                 org.apache.batik.css.engine.CSSContext ctx,
                                                                 org.apache.batik.css.parser.ExtendedParser ep,
                                                                 org.apache.batik.css.engine.value.ValueManager[] vms,
                                                                 org.apache.batik.css.engine.value.ShorthandManager[] sms) {
        org.apache.batik.util.ParsedURL durl =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             doc).
          getParsedURL(
            );
        org.apache.batik.css.engine.CSSEngine result =
          new org.apache.batik.css.engine.SVG12CSSEngine(
          doc,
          durl,
          ep,
          vms,
          sms,
          ctx);
        java.net.URL url =
          getClass(
            ).
          getResource(
            "resources/UserAgentStyleSheet.css");
        if (url !=
              null) {
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              url);
            org.w3c.css.sac.InputSource is =
              new org.w3c.css.sac.InputSource(
              purl.
                toString(
                  ));
            result.
              setUserAgentStyleSheet(
                result.
                  parseStyleSheet(
                    is,
                    purl,
                    "all"));
        }
        return result;
    }
    public org.w3c.dom.Document createDocument(java.lang.String namespaceURI,
                                               java.lang.String qualifiedName,
                                               org.w3c.dom.DocumentType doctype)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGOMDocument result =
          new org.apache.batik.dom.svg12.SVG12OMDocument(
          doctype,
          this);
        result.
          setIsSVG12(
            true);
        if (qualifiedName !=
              null)
            result.
              appendChild(
                result.
                  createElementNS(
                    namespaceURI,
                    qualifiedName));
        return result;
    }
    public org.w3c.dom.Element createElementNS(org.apache.batik.dom.AbstractDocument document,
                                               java.lang.String namespaceURI,
                                               java.lang.String qualifiedName) {
        if (namespaceURI ==
              null)
            return new org.apache.batik.dom.GenericElement(
              qualifiedName.
                intern(
                  ),
              document);
        java.lang.String name =
          org.apache.batik.dom.util.DOMUtilities.
          getLocalName(
            qualifiedName);
        java.lang.String prefix =
          org.apache.batik.dom.util.DOMUtilities.
          getPrefix(
            qualifiedName);
        if (org.apache.batik.util.SVG12Constants.
              SVG_NAMESPACE_URI.
              equals(
                namespaceURI)) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                factories.
                get(
                  name);
            if (ef !=
                  null) {
                return ef.
                  create(
                    prefix,
                    document);
            }
        }
        else
            if (org.apache.batik.util.XBLConstants.
                  XBL_NAMESPACE_URI.
                  equals(
                    namespaceURI)) {
                org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory ef =
                  (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                    xblFactories.
                    get(
                      name);
                if (ef !=
                      null) {
                    return ef.
                      create(
                        prefix,
                        document);
                }
            }
        if (customFactories !=
              null) {
            org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory cef;
            cef =
              (org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory)
                customFactories.
                get(
                  namespaceURI,
                  name);
            if (cef !=
                  null) {
                return cef.
                  create(
                    prefix,
                    document);
            }
        }
        return new org.apache.batik.dom.svg12.BindableElement(
          prefix,
          document,
          namespaceURI,
          name);
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        org.apache.batik.dom.events.DocumentEventSupport result =
          super.
          createDocumentEventSupport(
            );
        result.
          registerEventFactory(
            "WheelEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.SVGOMWheelEvent(
                      );
                }
            });
        result.
          registerEventFactory(
            "ShadowTreeEvent",
            new org.apache.batik.dom.events.DocumentEventSupport.EventFactory(
              ) {
                public org.w3c.dom.events.Event createEvent() {
                    return new org.apache.batik.dom.svg12.XBLOMShadowTreeEvent(
                      );
                }
            });
        return result;
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.svg12.XBLEventSupport(
          n);
    }
    protected static org.apache.batik.dom.util.HashTable
      svg12Factories =
      new org.apache.batik.dom.util.HashTable(
      svg11Factories);
    static { svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_DIV_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowDivElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_LINE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowLineElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_PARA_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowParaElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_BREAK_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionBreakElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_REGION_EXCLUDE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRegionExcludeElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_ROOT_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowRootElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_SPAN_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.FlowSpanElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_HANDLER_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.HandlerElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_MULTI_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.MultiImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SOLID_COLOR_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SolidColorElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageElementFactory(
                                  ));
             svg12Factories.put(org.apache.batik.util.SVG12Constants.
                                  SVG_SUB_IMAGE_REF_TAG,
                                new org.apache.batik.dom.svg12.SVG12DOMImplementation.SubImageRefElementFactory(
                                  )); }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f2XN9/4LYzlf04gUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wWkkufGAewC5zQ89AE/smpqNuytpZdWMew5r1oe/x0tauzrHmcOj8FtuWMel" +
           "E6C5MMO3tevLuCfrt+k57qGbXVNkZ7hPveeZ59TBp/N7B3WmKTy2H9weHdcn" +
           "RJ68+WG1l13R7IofX37PPz84frP5jldQ0n3klJKnRf527/mvNl+vfGQPOXtU" +
           "Crnu8ugk09WTBZCLcJ9ahu74RBnkoSP33J964yH4/c6Be75z47LqDf1+Jgu0" +
           "bXidquHtbQMjC7BDr96TejUmlMyZlKcsU49l3PHLVADfmTYhdA/ccSWgHQq7" +
           "+7iwA+/vgjj6SUfqE6U2gNx7w2uAw7Hyr/haAQbOA9ddZm4v4JTPPXfpwv3P" +
           "8X+ZldCPLslu6yIX9KVtH69dHXs+74eabmUTctu2kuVnP+8DyIM31w4g57Lf" +
           "zJD3bjl+5cARpzkAcha2xyl/DSCXT1NCidnvcboPA+Tijg56avtwnOQjUDok" +
           "SR8/6t+g4LUt9yVnji2+A7DJ3HnXT3LnEcvxany6YLOL58PFtdxePV9TPv9c" +
           "u//Ol0qf3t4GKLa02aRSLnSRW7cXE0cL9LGbSjuUdb71xI/u+MJtrztEkju2" +
           "Cu+WzTHdHrlx6Z12fJAVyze/f//vvvE3n/tWVn/7X6aFdYURIAAA");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "r/0XGxSfiYoUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "DZPTBLbzIHfX+vSX2rX1G6BxHjTKwMn2jAXcWSxDhitdv+EPv3il5/SbMRQd" +
           "R82agRXBgZC5AN3EzgPtFs177xPBXWLhbuemogrjKzqYg7dXD91YwaTc2Ss/" +
           "7f3xgWdWr3KUmULH1qDCT/N2kDWf4f1RippMy6CgikAx1WDzKtBHJJ/b5aVJ" +
           "7xlEpL9GhL9vpujeqqljrEiJbqsAr8rMUZ4xWED6alVGvKpbe/TSqjLz9JCo" +
           "XzrLq40xKKZ/+PaHv0pe/vPrVRJbg1vZBjcO65WlnCleMfq0927bxb/8LJE7" +
           "eCvZhvX13ySfsN/bwYLB2tkjvJVXH/3blmP35E/fQuLYHvJlWOX3p559/fBu" +
           "+WKUl8ciZ1SU1eWThoNehUUtAvcAnZnJelr56bqthKJeBpo+cHSdAJF4VpI3" +
           "hyhr9lZQYs2pIfKIClh7UGznJ4YV+UlR5HsDXQyjS3fKHJqHDNlh+OPbuP8T" +
           "6CjNmmOAIdkiUKh6yjYFlblY5mOfZ81xcZyG/8dzzzpGzCJQb/X6ytvE0C0X" +
           "bAD7zRXXRHG1kZ9bjTf2rh7/HUd86frRAtjNOpoWCH0QBg2mRbIq91SLIFiT" +
           "PxbgRlV7dxTV8yc35IyYobsRCs+gKAZtUPIsBDksCRr5MyhHKWr25SCE4iUo" +
           "sgTaQYS9At1WIkjciYqRSl7lce6+WZxLU4I1Azvw/ErvHU5HXOqhxF09Mv3g" +
           "9c8+LWoWWcMrK/wKCDdaUT6VDvjOmto8XQ0Te260vdC0K+oCuUNs2D92WwMo" +
           "H4FjZrJ8syWU0O1EKa+/s3bg5V+fa3gLCPYkimA4AycDF2rhKagKHGDWkymf" +
           "WwN/CfFKY3jP95bv2Zf95x95ynK5eFtt+bR85ZkHfntx8xpUJBsnUT3kAlKc" +
           "R82qfWhZP0rkRWsetar2WBG2CFpUrE2iRkdXzzpkUkmhNgZkzHiA+8V1Z2up" +
           "l1W8FA1U3Oqr3BMgvS8R66Dh6AqnPCBjv6fsvwaPIx3TDE3we0qh7Kq0PS0f" +
           "+nr85xc6Y+NwGMvMCarfYDuZEv8G/37wCbldsOrH8InA9yP25VUmfMQtuHPU" +
           "vYrvKN3FoY4QY7F0aso0PdnGt01xRL7Bmm8WWT9FkUG3lzFYRCRX9vNbfP3z" +
           "/JU13/4voFYC2ooUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "16+L/c+LV3x8479DU/vJmBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4I1vzK4Gb31lt7O784vo0csDuJRlE+QruJXEN19wL4Tu8Hw3BDd3Tc3X3ZW2" +
           "8qrGfYc17MPf46WtXb3jzOGV+M03resScag5gSlb2o1l3ZN13Ow+98itni3y" +
           "u9yn3/Xc8yr7GWTvoN40Bdf3g9ek4/z40NO3vrTS+ZPNrgjylXf988PDNxlv" +
           "fwWl3cdOMXma5O/QL3yt8zrlI3vQ2aOSyA2PSSeRrp0shFz0tTDyneGJcsgj" +
           "R+p5MNPGI0DUew/Uc+/Ny6s31fuZ3NC25nWqlre3NYzcwA61el+m1U1ZyZXZ" +
           "cpUo01iOvXmZSuA7ssYH6lF8TQq1Q2L3Hid2oP2dEQc/7Wp9ouQWQo+87LPA" +
           "4ZrIK35uAAb00A2PnNuHOeXzz1++8ODzo7/KS+pHj2d39KELemRZx2tZx/rn" +
           "PV/TzXxj7thWtrz85z0h9PCtuQuhc/lvLsi7txjvP1DIaYwQOgva45C/HkJX" +
           "TkMCivnvcbgPhdDFHRzQ2LZzHOQjgDoAybof9W5SANuW/+Izx5zwIOjkar3n" +
           "p6n1COV4dT5z3PxB+tDJou2T9HXlC89TzDtewj6zfR1QLClNMyoX+tDt24eK" +
           "I0d94pbUDmmdJ5/68aUv3vHaw4hyacvwzn2O8fbYzUvxhO2FefE8/YMHf+8N" +
           "v/X8t/N63P8CybEUkykgAAA=");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+58Xr/j41n8BUnEAV44UAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "HRsgAAA=");
    }
    protected static class FlowRegionExcludeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionExcludeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRegionExcludeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Wfz6NbH/efGKj6//F0o5MPqcFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "O7FPLSAAAA==");
    }
    protected static class FlowRootElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRootElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowRootElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "f56/suY7/wUMDz+mihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8eUXIAAA");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMFlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nxev+PjWfwEnR+vPihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class HandlerElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public HandlerElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMHandlerElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5/krezz+X0BPjQWIFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JuSR5Yyz+BT+FHnhEw833/S9HH/n4hn2o+nNsRkkcDvc4mecf9t78uKf7kG3" +
           "T6GrykF2OJLtOHOcKciIwsOUEWSQJ+ZPZjfbo/z6UQh7zenwcmzZ08FldyaA" +
           "fgad9S8fjyc/Bp9z4Ps/2Tfb7mxge6be0zw42B8/Otl9Pz0HvPVCcb+yX8jw" +
           "35xTeSJvr2XNz2zVlHV/Frh1mKelAEO3XNnOF35LBEzMVq4dUh+BNDU7fuZ2" +
           "JSdzP0jMc3PKpN/f5nbbgJa1xZzE1iRKtzSfn9tC5SfXXTtirAfSxPf/w4e+" +
           "/sHXfhvotA1dWGX7DVR5bEUuzjLn97zw0Ude9dx33p9HKRB+Ru943b/meQj7" +
           "chJnDZk11KGoD2ei9vN0gJXDqJsHFk3NpX1ZUxYCywHxd3WQFiLP3vPtxSe+" +
           "+9ltynfabk8Ba+977td+vP+B5/aOJdqvvSnXPY6zTbZzpl99sMMB9MTLrZJj" +
           "UP/4+Wf/8Leffe+Wq3tOpo0kuBV99i//++v7H//OV8/IUG6zvf+DYqM7L7Xw" +
           "kKkfflh0okuJIqaSzmMIqTprvaIb8zZLD+K2ZvA8XZyZsaE484BvTau4vjb5" +
           "ukt6s0q3olTU2WyNxTVHjZRqbM6mfXTS6PU5vkAM5+i4jC+H9CIQ6yMmIjpL" +
           "kQpHC8qzPLJOkCt4OMdNus9LQlUYOdOVWpzBiNIR1o22hkSbWVrqwnANQ+Ia" +
           "h+hVbiS6UtkSyoTYsAup1S5MUd4rRM7amNPBLJpsmpLtw3EyhnUNQ9YVy1q6" +
           "BSnSpFRYc4YzWQci1QqlmrwsD2ZkTGJxn2SkyGFlZiAn1IAaEW5hpC79Qui0" +
           "veUSGzSHdWPAM3RE0UHLpvxluiQX5f7SWBIK1S618L48MKuC2GvOx6wZuAur" +
           "WOUtpkpOfXORqAjrL41I7U1Wk65jLsENctQOeapfLKCbfsGfpk6h3gOr9aaz" +
           "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");
    }
    protected static class MultiImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public MultiImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMMultiImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "z4tXfHz9vxYXpoeOFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class SolidColorElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SolidColorElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSolidColorElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wcVxW+u37Edmyv7fgRkthJXCdVnLBbtwlQObR1HDtx" +
           "WD8UJ5Hq0GzuztzdnXh2ZjJzx167KbSVUANCIYS0TSvVv1xVoNJWiAqQaGVU" +
           "ibYqILVEQEENSPwpj4hGSOVHeJ1zZ2Zndna3UfiBJc/O3nvuufec853vnLsv" +
           "Xid1lkn6mMbjfMlgVnxM4zPUtJg8qlLLOgZjKenpGvr3Ux9O3Rsl9XOkNUet" +
           "SYlabFxhqmzNkV5FszjVJGZNMSbjihmTWcxcoFzRtTnSpVgTeUNVJIVP6jJD" +
           "gRPUTJJ2yrmppG3OJlwFnPQm4SQJcZLESHh6OEmaJd1Y8sU3BsRHAzMomff3" +
           "sjhpS56hCzRhc0VNJBWLDxdMstvQ1aWsqvM4K/D4GXWf64IjyX1lLuh/Jfbx" +
           "zYu5NuGCDVTTdC7Ms44yS1cXmJwkMX90TGV56yz5EqlJkvUBYU4Gkt6mCdg0" +
           "AZt61vpScPoWptn5UV2Ywz1N9YaEB+Jke6kSg5o076qZEWcGDQ3ctV0sBmu3" +
           "Fa11rCwz8cndictPn2r7Xg2JzZGYos3icSQ4BIdN5sChLJ9mpjUiy0yeI+0a" +
           "BHuWmQpVlWU30h2WktUotyH8nltw0DaYKfb0fQVxBNtMW+K6WTQvIwDlfqvL" +
           "qDQLtnb7tjoWjuM4GNikwMHMDAXcuUtq5xVN5mRreEXRxoEvgAAsXZdnPKcX" +
           "t6rVKAyQDgciKtWyiVmAnpYF0TodAGhysqmqUvS1QaV5mmUpRGRIbsaZAqlG" +
           "4QhcwklXWExogihtCkUpEJ/rU/svPKwd1qIkAmeWmaTi+dfDor7QoqMsw0wG" +
           "eeAsbB5MPkW7XzsfJQSEu0LCjswPzt14YE/f2luOzOYKMtPpM0ziKWk13fru" +
           "ltFd99bgMRoM3VIw+CWWiyybcWeGCwYwTHdRI07Gvcm1oz998NHvsL9ESdME" +
           "qZd01c4DjtolPW8oKjMPMY2ZlDN5gjQyTR4V8xNkHbwnFY05o9OZjMX4BKlV" +
           "xVC9Lr6DizKgAl3UBO+KltG9d4PynHgvGISQLvgn2wmJLBDxF7HxyYmcyOl5" +
           "lqAS1RRNT8yYOtpvJYBx0uDbXCINqJ9PWLptAgQTuplNUMBBjrkTsp5PWAvZ" +
           "obsTsycODd19cHoSWZDlYb1Ilziizfg/7VNAezcsRiIQii1hIlAhhw7rqszM" +
           "lHTZPjB246XUOw7IMDFcT3FyBLaOO1vHxdZx2Douto5X3npgVlcVjJpujjnD" +
           "4xQzfolEIuIonXg2BxEQz3lgBqDm5l2zDx05fb6/BqBoLNZiSEC0v6REjfr0" +
           "4XF+Snq5o2V5+7WhN6KkNkk6YCebqlhxRswscJk076Z7cxqKl19DtgVqCBY/" +
           "U5eYDBRWrZa4Whr0BWbiOCedAQ1ehcNcTlSvLxXPT9auLD524st3RUm0tGzg" +
           "lnXAeLh8Bsm+SOoDYbqopDf2xIcfv/zUI7pPHCV1yCufZSvRhv4wWMLuSUmD" +
           "2+irqdceGRBubwRi5xQSETizL7xHCS8NexyPtjSAwRndzFMVpzwfN/GcqS/6" +
           "IwLF7eK9E2ARw0S9E+Cx6Gau+MTZbgOfPQ7qEWchK0QN+fys8dxvfvGne4S7" +
           "vXITC/QJs4wPBygOlXUIMmv3YXvMZAzkPrgy860nrz9xUmAWJO6otOEAPkeB" +
           "2iCE4OavvHX2/d9fW70a9XHOocbbaWiVCkUjG9Cm1k8wEnbb6Z8Hkk0F+kDU" +
           "DBzXAJ9KRqFplWFi/TO2Y+jVv15oc3CgwogHoz23VuCPf+oAefSdU//oE2oi" +
           "EpZo32e+mMP7G3zNI6ZJl/Achcfe633mTfocVBBgbUtZZoKIifABEUHbJ+y/" +
           "Szz3huY+i48dVhD8pfkVaKVS0sWrH7Wc+Oj1G+K0pb1YMNaT1Bh24IWPnQVQ" +
           "3xMmp8PUyoHc3rWpL7apazdB4xxolICVrWkT2LNQggxXum7db3/yRvfpd2tI" +
           "dJw0qTqVHQ6E2gXoZlYOiLdg3P+AE91FDHebMJWUGV82gA7eWjl0Y3mDC2cv" +
           "/7Dn+/tfWLkmUGY4OjYHFd4pnoP4+LQYj3LSaJg6B1UM2ql6S/SBPiLF2k6v" +
           "UHqfQUT6e0TE+0ZO7q9YPMYKnGmWAvAqrx2lFQMD0lutNxJ93erjl1fk6eeH" +
           "nA6mo7TfGIN2+ru/+tfP4lf+8HaF0lbv9rbBg8N+JSVnUvSMPu190Hrpjz8a" +
           "yB64nWqDY323qCf4fStYMFi9eoSP8ubjf9507L7c6dsoHFtDvgyr/Pbki28f" +
           "2ildiooG2akZZY116aLhoFdhU5PBTUBDM3GkRWTXHUUU9SBoesHR51wUnatM" +
           "3gKi+NhdTonVlobII+rA2oNim8gYbPPjTpvvTXQiRhfvkQQ0D+qSjfgTx3jw" +
           "E+gohY9jgCHJZNCqeso2BJW5WBZzn8PHcSedhv/HvMeBEaMATXe1Dss7xtBt" +
           "N20A/I1lV0XneiO9tBJr6Fk5/muB+eIVpBnQm7FVNRD8IBDqDZNlFOGrZodi" +
           "DfExD7eq6qfjpE58CkPOOCs0N0bhFZzUwDMoeRbCHJYEjeIzKMc5afLlIIjO" +
           "S1BkEbSDCL4C4ZZjyLkXFSLlzCoi3XWrSBeXBLsGTHlxrffS03Yu9tDkrhyZ" +
           "evjGZ553uhZJpcvL4hoIt1qngSqm+Paq2jxd9Yd33Wx9pXFH1IVyu3NgP/E2" +
           "B3A+AolmYMXZFCrp1kCxsr+/uv/1n5+vfw8o9iSJUMiCk4FLteMp6Ats4NaT" +
           "SZ9dAz8LiV5jeNezS/ftyfztd6JouWy8pbp8Srr6wkO/vLRxFXqS9ROkDqoB" +
           "K8yRJsU6uKQdZdKCOUdaFGusAEcELQpVJ0iDrSlnbTYhJ0krApkiEwi/uO5s" +
           "KY5iz8tJf9nNvsJNAQr8IjMP6LYmC9IDOvZHSn5v8FjSNozQAn+kGMrOcttT" +
           "0sGvxn58saNmHJKxxJyg+nWWnS4ycPAnCJ+S2xxe/Q/8ReD/3/iPQccB5ybc" +
           "Mepex7cV7+PQSThzNankpGF4sg3XDCdFvoaPrxdwnJPIoDu6V/Svorzi12+I" +
           "/S+IV3x8878457PJjhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZfazjWHX3e7MzOzssO7Pf2y37yQDdDXqO43x2oBDH+XLs" +
           "xIkTO3ELg2NfO44/4684hm0BiY+WChAslEqwf4HaouVDVVErVVRbVS0gUCUq" +
           "1C+pgKpKpaWo7B+lVWlLr533Xt57M7NoVamRcuNcn3PuPfec87vnnvv8D5Dz" +
           "vofkXMfcaKYTHIA4OFiapYNg4wL/gKJLrOT5QGmYku+PYd91+ckvXv7Rjz+8" +
           "uLKPXBCReyXbdgIp0B3bHwHfMSOg0MjlXW/TBJYfIFfopRRJaBjoJkrrfnCN" +
           "Rl5xgjVArtJHU0DhFFA4BTSbAlrfUUGmVwI7tBoph2QH/gr5ZWSPRi64cjq9" +
           "AHnitBBX8iTrUAybaQAlXEz/81CpjDn2kMePdd/qfIPCH8uhz/7GW6/87jnk" +
           "sohc1m0unY4MJxHAQUTkTgtYc+D5dUUBiojcbQOgcMDTJVNPsnmLyD2+rtlS" +
           "EHrgeJHSztAFXjbmbuXulFPdvFAOHO9YPVUHpnL077xqShrU9YGdrlsNW2k/" +
           "VPCSDifmqZIMjlhuM3RbCZDHznIc63i1Bwkg6+0WCBbO8VC32RLsQO7Z2s6U" +
           "bA3lAk+3NUh63gnhKAHy8C2FpmvtSrIhaeB6gDx0lo7dvoJUd2QLkbIEyP1n" +
           "yTJJ0EoPn7HSCfv8oP+GD77d7tj72ZwVIJvp/C9CpkfPMI2ACjxgy2DLeOfT" +
           "9MelB778/n0EgcT3nyHe0vz+O1588+sffeGrW5qfvQnNYL4EcnBd/vT8rm++" +
           "qvFU7Vw6jYuu4+up8U9pnrk/e/jmWuzCyHvgWGL68uDo5QujP5u987Pg+/vI" +
           "pS5yQXbM0IJ+dLfsWK5uAq8NbOBJAVC6yB3AVhrZ+y5yO3ymdRtseweq6oOg" +
           "i9xmZl0XnOw/XCIVikiX6Hb4rNuqc/TsSsEie45dBEHuh1/kCQTZi5Dssxem" +
           "bYAo6MKxACrJkq3bDsp6Tqq/jwI7mMO1XaBz6PUG6juhB10QdTwNlaAfLMDh" +
           "C8WxUD/SsALK8W2sQA6YruVClID8WbgcpN7m/j+NE6f6Xlnv7UFTvOosEJgw" +
           "hjqOqQDvuvxsSDRf/Pz1r+8fB8bhSgUIBYc+2A59kA19AIc+yIY+uPnQVznH" +
           "1FOrOV5z292S0ojfIHt72VTuS+e29QhoTwMiA8TMO5/i3kK97f1PnoOu6K5v" +
           "S00CSdFbQ3djhyXdDDFl6NDIC59Yv4v/lfw+sn8ag1N9YNellJ1NkfMYIa+e" +
           "jb2byb38vu/96Asff8bZReEpUD8Ehxs50+B+8uzKe44MFAiXO/FPPy596fqX" +
           "n7m6j9wGEQOiZCBBr4YA9OjZMU4F+bUjwEx1OQ8VVh3Pksz01RHKXQoWnrPe" +
           "9WQucVf2fDdc48up178OrvX6MAyy3/TtvW7a3rd1odRoZ7TIAPmNnPupv/7z" +
           "f8Kz5T7C7ssndkMOBNdO4EUq7HKGDHfvfGDsAQDp/u4T7Ec/9oP3/WLmAJDi" +
           "1Tcb8GraNiBOQBPCZX7PV1d/851vf/pb+zunCeCGGc5NXY6PlbyY6nTXSygJ" +
           "R3vtbj7Qc00Yi6nXXJ3YlqPoqi7NTZB66X9dfg32pX/54JWtH5iw58iNXv/T" +
           "Bez6f4ZA3vn1t/77o5mYPTnd73ZrtiPbgui9O8l1z5M26Tzid/3FI7/5FelT" +
           "EI4hBPp6AjJUQ7I1QDKjoZn+T2ftwZl3WNo85p90/tPxdSIvuS5/+Fs/fCX/" +
           "wz96MZvt6cTmpK0Zyb22da+0eTyG4h88G+kdyV9AuuIL/V+6Yr7wYyhRhBJl" +
           "CHH+wINQFJ/yjEPq87f/7R//yQNv++Y5ZL+FXDIdSdkCCtwIoHcDfwFRLHbf" +
           "9Oatddepua9kqiI3KL91ioeyf+fgBJ+6Nb600rxkF6IP/efAnL/77//jhkXI" +
           "kOUm2/EZfhF9/pMPN37h+xn/LsRT7kfjG+EZ5nA73sJnrX/bf/LCn+4jt4vI" +
           "FfkwQeQlM0wDR4RJkX+UNcIk8tT70wnOdje/dgxhrzoLLyeGPQsuu20BPqfU" +
           "6fOlk3jyE/jZg9//Sb/pcqcd2231nsbh3v748ebuuvEejNbzhYPKQT7lf1Mm" +
           "5YmsvZo2r9uaKX38ORjWfpaZQg5VtyUzG/jNAXQxU756JJ2HmWq6Ay3NSibm" +
           "fpibZ+6Uan+wTe+2gJa2hUzE1iVKt3Sfn99SZTvXXTthtAMzxQ/8w4e/8aFX" +
           "fwfalELOR+l6Q1OeGLEfpsnze5//2COvePa7H8hQCsIP/87X/GuWitAvpXHa" +
           "NNOmdaTqw6mqXJYR0JIfMBmwACXT9iVdmfV0C+JvdJgZos/c8x3jk9/73Dbr" +
           "O+u3Z4jB+5/9tZ8cfPDZ/RO59qtvSHdP8mzz7WzSrzxcYQ954qVGyTha//iF" +
           "Z/7wt59533ZW95zOHJvwYPS5v/zvbxx84rtfu0mScpvp/B8MG9x5Z6fod+tH" +
           "HxqbSYW1zMdCLsQrTcXaRBVVGxnBgpo2FN6miXmwNoeD+QjrkEEskNUJVeqs" +
           "8u0kTIJEsaeLgrikkhgrV3pzjp/U+43ujMuPuYiPsJh3+pSg11dDqc1P9Pls" +
           "1aX55rDZ7HPs2l0WF21uwHcAhSViQbQVW8Inqk5QMjrA7SgMVSBXS3hk0340" +
           "1RXMNOyyxcyXKmNqvB0zxYSdBJRWXZk0PdDEZQ/Ybjvy8ElcG+Aj36xNB0Z/" +
           "AgJuZkrzVrxYWUnf4EstP1nyVFvsM9x8qS+ssSDHstNKRsHY5lxeG4NJn6e6" +
           "PFteUqQ2YidjiipsPMt12/iAMtctmx1aRW5IySLd5DqL8qBpSZSCzar+BCf8" +
           "UaeeMI6lqri/XLhcqbxoJKOFnOf7FCHQZKwwfhANMUnwVxFT7KFksT0V1HKx" +
           "u9xMMZMOFyilzuNkFpb6YbtB8uOx0qgwfrG44TB5alFrg5nW8uM2XypvklJz" +
           "ZVJGNCFmk2LbCMpWQ9HydTEoY5HLyawjuIFdmvCF2TrB+rWZ1CRylAHKBqeV" +
           "nHylvBKbgtwmh7gc8HmfsEK8JWGY11gnVdlWIP6wdsGrTLUClYjtmePjuswN" +
           "i0RX6Zf8xoKmapa7nOib/AZ0c3mJ6ISCNXR5U5jg+UVBMIKJE2w6VdsM1nlS" +
           "mvXUeV4d8jHRDxgh1ysL42HUXZOmuoroFTmkA3teCZaOsAyZYruvG2umw5D1" +
           "qRxOglUp5vsla+SB5nQUO81Iq9f9qajYbE+eBmWP79U3Q1KT9V4gbHTeqtvu" +
           "rJUfO0q9vdj4K2s1iThsKPEly5q4o/aoO/clsb4y28XhQl4b5lRoxo6mL4KG" +
           "MXGbFOpN4IGD7a0VbNU16hYQLGms5xSVdLzK0Fkx/jq/bgNQ9+dEiWENoTJN" +
           "fJUacs0wTzeW/ppNAqw4a6JqwQwHyWDWYwLWZfKJ3hMMDFe90AxaSq0215iR" +
           "w+B8d51rCIK+2cxlAbQb69l63FFG3XylHckW5iS1WrXfiXy61uQUprkSlTwm" +
           "F8ll4JisUHV6S4ZlZgXRJPslbTncjEdFvhr3jc58bbdm+ZJTG4hLZlokeiYf" +
           "840a7ZVJPelpdROfEINczwzaNaXIbuyOFrW73JCONLuwtiiaIONWpRNvZpa8" +
           "GZglc1XnsNGoP65uZoPAjagZEedDcj5tdPsrqsYKtBvUteE4dM3+hCGIpWeM" +
           "fbfECvVIdOb+2N/IA1LBanLH4QSRNGdzrGsmup6oGlrh+3WQyP5I7w51HVt0" +
           "zfpisa54Kz9hzM5YZJdEoVieTgbrSpchW/IYb20IWhoMsKgTK2JcIJ0wcEpT" +
           "3HY13pT5JeWGy6VNFuNhojpmsxt2HRs6MhE3hwluasSKtEpmISHjfEmdl1Fi" +
           "RTh0X9S5ZiMflUfNperli9NWjrNXJafAl3IVYdEv94y+YZRnDTBfmYt45K99" +
           "mTJgHIkVOV71TKxGBhq/ahAzdFICM5IYCZ4oFYWFlyeEuT5oAKU+xMBC7stj" +
           "k4voeMqOa1JIk6VC0Q/w0cTKB+1EM+1pHdCLKuFbOW7gkLP5ynFJtRB3ZTVC" +
           "k0m34rKdBo9tGqEqctFoERXXAkOH3MQiCzndWykyaI+IcL4e6aUYOuVYT+hK" +
           "3Glw1T6IN2yw5Orrka0kLYZ3k7XaR9vyikPL3TXdqoBerVmoj9Z5rtbMNeJy" +
           "WwpzzFicawOVHVZWEC8Wvfywn1M3flWJIzVq26DIVaJpd9xAh5RfXLPERhuY" +
           "00mXsSJ8No0YsZ4YrKdtquW87SW1eGLVBWpQdoJBs84agCjojWZxIEVRZ1pA" +
           "lZoqVPJSbdoZOPJ8Lgk6D2Ny2a41LMyorpv2fF4Wqx3DyLdyBjkhiWRap2q9" +
           "0arlmkJLR8eDwiy3hHtPyZHxhrZ2tI6TFHA+bLBqzqkDlVMmKOo0C47edEUH" +
           "L4CcxbCVNp70u2WRMtG6vJBVUMZxa6w6Mk8Q2nwSiKLT6+pqnWhOOnMqt0G5" +
           "JMEX4SynF6sKvyCrrmrwUo/n8r7gdSqCnBsssXaul3fn2IzpS2OMWBSKXYG1" +
           "h/wQjxnLrbKTjdORcU9w6YrkSolCFOPYMbsN3hOMcYHuDzUtnoZWRZnj6GYU" +
           "qa5SCLoKtc6vxiu+Myw3C9rUEc3ZQKcVDWdz9WYNa5EdMGcoYdLmqwWtXgHC" +
           "0szPcItsFOQIrZB2Dg1UgTasSXtWHCxnnZZSdG2HLebo4WyJ05xEaWUCmzCF" +
           "lVnmUI5gdbpVMMrRpLNSh5NxGeTHzVxeHFRWtRkEnZ7dtmB411deXDBbQ4bM" +
           "m2HQj6kaDrylialGGYCOXS9bTmWstrv9Qs4L0VygskVTzVU7UitvzqOaNye0" +
           "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" +
           "zBsgAAA=");
    }
    protected static class SubImageElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/ufFKz6+8V8thjrPihQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "w+sGcCDLXtCv4ESSnD3hbgTd5gdeBJxLU/N5j8paeUXjnoPC9cHv8bLWUa1j" +
           "5+A4/OYzi7nNJNLc0JzZ2o213JM13Ows99DN7iryc9yn3/3c82rvM8jufq1p" +
           "DI7u+1dIx+UJoKdufmDl8nuaowLIV979zw8Kb5q//RWUdR85JeRplr/DvfC1" +
           "1uuUj+xC5w7LITfcIJ0kunayCHIp0KI4cIUTpZCHDs1zf2aNh4Cqz+6b59mz" +
           "S6tn2n0nd7Ste52q4+1uHSN3sAOr3pNZdY0quTEbnhJnFsup1y9TBXxH1gTA" +
           "PEqgyZF2wOzu48z2rX/kxOFPO1afKLdF0H1n3wUcTIa84ssF4DkP3HClub2G" +
           "Uz7//OWL9z8v/lVeRz+8KruNhS7qsW0fL2Ade77gB5pu5ity27ac5ec/74ug" +
           "B28uXQSdz39zRd67pfi1fUucpoigc6A9PvLXI+jK6ZGAY/57fNyHIujS0Thg" +
           "qu3D8SEfAdzBkOzxo/4ZVa9tzS/ZORZ9+2iT2/Oun2bPQ5LjJfksYvPr54Po" +
           "ircX0NeVLzzf7r7jpepntlcCii2nacblIgvdur2dOIzQx27K7YDXBfrJH9/x" +
           "xdueOICSO7YCH8XNMdkeObv+3nT8KK+Yp39w/++94bee/3ZehPtfFsTB4Bcg" +
           "AAA=");
    }
    protected static class SubImageRefElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public SubImageRefElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.SVGOMSubImageRefElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Xb7/Of7KHo//F/fOkbeQFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "FPUdIAAA");
    }
    protected static org.apache.batik.dom.util.HashTable
      xblFactories =
      new org.apache.batik.dom.util.HashTable(
      );
    static { xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_XBL_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLXBLElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_DEFINITION_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLDefinitionElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_TEMPLATE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLTemplateElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_CONTENT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLContentElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_HANDLER_GROUP_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLHandlerGroupElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_IMPORT_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLImportElementFactory(
                                ));
             xblFactories.put(org.apache.batik.util.XBLConstants.
                                XBL_SHADOW_TREE_TAG,
                              new org.apache.batik.dom.svg12.SVG12DOMImplementation.XBLShadowTreeElementFactory(
                                )); }
    protected static class XBLXBLElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLXBLElementFactory() { super(
                                          );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMXBLElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nvwvYq/8MYYUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class XBLDefinitionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLDefinitionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMDefinitionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "itj/rHjFx1f/C7LS8dyUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sOR3//1/XLcIObLcYEc+xS8iL3z8QfJN38v5dyGecT+cXI/QII3b8RY/bf/b" +
           "3uPn/2QPulWELisHOeJYsqIscESQFwWHiSPII0+8P5njbDf0q0cQ9trT8HJs" +
           "2NPgstsZwHNGnT1fPI4nPwafM+D7P9k3W+6sY7uz3kUebO+PHu3vnpecAdF6" +
           "rrhP7KMZ/5tzKY/l7ZWs+emtmbLHnwFhHeTJKeAAu4tk5QO/JQQuZilXDqWP" +
           "QbKabUKmReRi7gXpee5Omfb72wxvC2hZW8xFbF0Cv6n7/OyWKt+57tgJo12Q" +
           "LH7gH5752ode921g0y50bp2tNzDlsRH7UZY/v/eF5x561bPf+UCOUgB+xu98" +
           "4l/zbIR+OY2zhsqa5qGqD2aq8nlSQEtByOTAoqm5ti/rykPfsAH+rg+SQ+Tp" +
           "u769/Ph3P7NN/E777Sli7f3P/uqP9z/47N6xdPt112W8x3m2KXc+6VcfrLAP" +
           "PfZyo+QczX/83NN/8FtPv287q7tOJo8UOBt95i//+2v7H/vOV26Qp9xiuf8H" +
           "w4a3394uBZ3a4YcuzKRirIyTCRxhBKXamzWhz7mKU+MLsd2jMNkP59RqQYhw" +
           "d074C7izdOdEH48IBlOLXbGo2AymB+EoWvhjttCpcyTfj2rjYXUznjV7kw21" +
           "Ynu98YifSlSvvjJmJNnyGqVRUq5zS9PiMENViqotYmLR4c1K3O06IlypVqsJ" +
           "ka6dgVoh1Ga5zLWCYImNUlORcZchA3i1bnqS5TFtS/JErlgPRAEV6tMqXHKw" +
           "Lgz3l6Enot7GLLgcRQuSzTQnRTGwJpzMlAo8ZwtCxy6VPG9ZcBinpyqoPBbR" +
           "VXNWwqzGmOebAjzfsKWmWaA2/DhY4SuJC9NAVOtiEghKt0tFnaWhtOMqBdSl" +
           "VuVAM2g53nQasWqPGvSaKI4T1OtUOBD7cST17OV81VxUXLvFD10poifjqaOM" +
           "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" +
           "Sb4mISAAAA==");
    }
    protected static class XBLTemplateElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLTemplateElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMTemplateElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fpfvf4a/ssf3/gus2birkBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLMzOzssO7PvZcs+maXsGn1OnIedDi/HcZ52" +
           "EjsPJ25hcPxIHL/fdui2gMSrVIBgoVSC/QvUFi0PVUWtVFFtVbWAQJWoUIFK" +
           "PFRVKi1FZf8orUpbeu1835fv+2Zm0apSI+XGuT7n3HvuOed3zz33uR9D53wP" +
           "gh3bSJeGHewrSbC/Nir7Qeoo/n6XrgxFz1dk0hB9fwz6rkmPf+HST3/2odXl" +
           "Pei8AN0tWpYdiIFmWz6n+LYRKTINXdr1UoZi+gF0mV6LkYiEgWYgtOYHV2no" +
           "ZcdYA+gKfTgFBEwBAVNA8ikgxI4KML1csUKTzDhEK/Bd6DegMzR03pGy6QXQ" +
           "YyeFOKInmgdihrkGQMKF7P8UKJUzJx706JHuW52vU/ijMPLM77zl8h+ehS4J" +
           "0CXNGmXTkcAkAjCIAN1uKuZC8XxClhVZgO60FEUeKZ4mGtomn7cA3eVrS0sM" +
           "Qk85WqSsM3QULx9zt3K3S5luXigFtneknqophnz475xqiEug6307XbcaNrN+" +
           "oOBFDUzMU0VJOWS5RdcsOYAeOc1xpOOVHiAArLeaSrCyj4a6xRJBB3TX1naG" +
           "aC2RUeBp1hKQnrNDMEoAPXhTodlaO6Kki0vlWgA9cJpuuH0FqG7LFyJjCaB7" +
           "T5PlkoCVHjxlpWP2+XH/dR94m9W29vI5y4pkZPO/AJgePsXEKariKZakbBlv" +
           "f4r+mHjfl967B0GA+N5TxFuaP/71F9702oef/8qW5pduQDNYrBUpuCZ9anHH" +
           "N15JPlk7m03jgmP7Wmb8E5rn7j88eHM1cUDk3XckMXu5f/jyee6v5m//jPKj" +
           "PehiBzov2UZoAj+6U7JNRzMUr6VYiicGityBblMsmczfd6BbwTOtWcq2d6Cq" +
           "vhJ0oFuMvOu8nf8HS6QCEdkS3QqeNUu1D58dMVjlz4kDQdC94As9AUFnvg3l" +
           "nzPfytoAkpGVbSqIKImWZtnI0LMz/X1EsYIFWNsVsgBeryO+HXrABRHbWyIi" +
           "8IOVcvBCtk3Ej5ZFFBlNW0W0MWA6pgNQAvDn4bKfeZvz/zROkul7OT5zBpji" +
           "laeBwAAx1LYNWfGuSc+EdeqFz1372t5RYBysVAD1wND726H386H3wdD7+dD7" +
           "Nx76yqxOjxXQBUxIbfubYhbyKXTmTD6Xe7LJbV0CGFQH0ABA8/YnR2/uvvW9" +
           "j58FvujEt2Q2AaTIzbGb3IFJJ4dMCXg09PzH43dMf7OwB+2dBOFMIdB1MWMf" +
           "ZtB5BJFXTgffjeRees8Pf/r5jz1t78LwBKofoMP1nFl0P3566T1bUmSAlzvx" +
           "Tz0qfvHal56+sgfdAiADwGQgArcGCPTw6TFORPnVQ8TMdDkHFFZtzxSN7NUh" +
           "zF0MVp4d73pyn7gjf74TrPGlzO1fA9b6OwdxkP9mb+92svaerQ9lRjulRY7I" +
           "rx85n/z2X/9TKV/uQ/C+dGw7HCnB1WOAkQm7lEPDnTsfGHuKAui++/HhRz76" +
           "4/f8au4AgOJVNxrwStaSACiACcEyv+sr7ne+/71PfXNv5zQB2DHDhaFJyZGS" +
           "FzKd7ngRJcFor97NBwCOAYIx85orE8u0ZU3VxIWhZF76X5eeKH7xXz5weesH" +
           "Bug5dKPX/mIBu/5X1KG3f+0t//5wLuaMlG14uzXbkW1R9O6dZMLzxDSbR/KO" +
           "v3nod78sfhLgMcBAX9soOaxB+RpAudGQXP+n8nb/1Lti1jziH3f+k/F1LDG5" +
           "Jn3omz95+fQnf/ZCPtuTmc1xWzOic3XrXlnzaALE33860tuivwJ05ef7v3bZ" +
           "eP5nQKIAJEoA4/yBB7AoOeEZB9Tnbv27P/+L+976jbPQXhO6aNiivAUUsBMA" +
           "71b8FYCxxHnjm7bWjTNzX85Vha5TfusUD+T/zoIJPnlzfGlmickuRB/4z4Gx" +
           "eOff/8d1i5Ajyw3241P8AvLcJx4k3/CjnH8X4hn3w8n1+AySuB0v+hnz3/Ye" +
           "P/+Xe9CtAnRZOsgQp6IRZoEjgKzIP0wbQRZ54v3JDGe7nV89grBXnoaXY8Oe" +
           "BpfdvgCeM+rs+eJxPPk5+JwB3//JvtlyZx3bffUu8mBzf/Rod3ec5AyI1nPo" +
           "PrZfyPjfmEt5LG+vZM0vb82UPb4GhLWfp6aAQ9Us0cgHflMAXMyQrhxKn4JU" +
           "NduC1gaWi7kXJOe5O2Xa72/zuy2gZS2ai9i6ROWm7vMrW6p857pjJ4y2Qar4" +
           "/n/40Nc/+KrvA5t2oXNRtt7AlMdG7IdZ9vzu5z760Mue+cH7c5QC8DN9+xP/" +
           "muci9ItpnDVU1jQPVX0wU3WUpwS06AdMDiyKnGv7oq489DQT4G90kBoiT9/1" +
           "ff0TP/zsNu077beniJX3PvNbP9//wDN7x5LtV12X7x7n2Sbc+aRffrDCHvTY" +
           "i42SczT/8fNP/+nvP/2e7azuOpk6UuBk9Nm//e+v73/8B1+9QZZyi2H/Hwwb" +
           "3H65XfY7xOGHLs5VPpYSjlcHJYSSzVTF1OW6S7fGLVIOrCHLE6hJW0QPnafS" +
           "oBIjzbExknQ/krBgIydWiJm1ogCjSY8saJ2g5436BMpO/S7SEpu8Sph1sceT" +
           "M5KaUq2CITa5jlsdTeElUtNI0uWGtU5Uwxisj4WYXOCcGTLRIxUVgipuqqqC" +
           "ISXFLEVhz3UTWuYact21RqmYlKtM1ZJEfiywoDNC6U5sVETFxfvwUN1wlWky" +
           "nm7ctknTc0topWNGmNraGm2Hxkx2DG2mjYtdjeny42ZEdYM56bjualOlBkUO" +
           "G5qC7bqlMTkhluNBxw3qLa9pNB03dZt6qTklJjOJHGt0ohdWjbJi1estd9KY" +
           "DbvNGj6n6nh302h0LRqejadNuqxxStztNqaTYs9tzOVNM7AD1LBHidW3262R" +
           "g7TGqIHN6nNppBQCqTAMRlh/6AkYE5SIycLvlRdGN7DaqYjaowLbnTc1JNRs" +
           "zqLRnsr2p90pUY2HZHM4MSKqYKDNETkeFz11pJdVbshZctqJJXRluYI4Qedt" +
           "21xhPtcZ85u15TqWKcTzviyPitYIb4mYNPXqU95w1uWkhTlIc9jmi9WQ9ahK" +
           "szkstmZzqcVW6nOBqUjkuuvMV0Yj1XsTRWDdGKtbWovX1tMiOi8WzGrRlKlY" +
           "JmnEaq4XtsmMNQVx4eVaIxfCfD3BGdfsquay3UOKIlu0iOZiUCouVvPpelGP" +
           "mUWzsZo35yIBY1JXnm1ct8IGDR63zfq6VCosCSqaVdh1v2XzgWtNGKK66rPU" +
           "uKHookgoa6fFkQHDkkRT5xc9zTGitZgMO/imy+hsS+gtmgaznEq4HAsCW6xT" +
           "fLliL0dOQE4yZWFPj9bMsLpUi72OR5jcRBPhDV5Fm9wYXXNzoWM2bQqnCH8B" +
           "J/1h2cdm44LEEWFroNMkqyglrwgDb8aGaOA0hBklmD2LH6UN1vGqoliq+akf" +
           "hmHPEplBMIin3ALv+EHF0FGMKfcrVKKZfpXkxpJYSxezRoStkTIHj6OCwMUb" +
           "zTXYUj9lWwPenKyFqi36bJm1ptqcMidSkevLLaW9KaNLOSLliTVfc+5sLHYt" +
           "VpryAe72F8sS3myK00Z91mcJrOoqfS8pUTXGV3F4QfaoAUxJGNVxcG24UivE" +
           "EHUojfN1cTBqrluhay8KHmcwwyAguaVVX2D9kWYQyCLRW+Vyk+qyTC/tr2Kq" +
           "xYf1QU8Xhv5K2hCYTDMFlmkEMKyaJuGP2r3YcmXa6rX7SAMJdFRFQSLLcCQx" +
           "4fEuZVPUoD1mC6vpqgsv4s2w7QUrZYQRJusz02Q4mbHqol6Y8bhaKVrt+cCv" +
           "ltaOqoYh7MVlQyB0ho0NKhnagpBq8GrUGamOUJDHOkESa3tYJBpSiV55FbvZ" +
           "6Baw0nRJ8Rtp6jZXDIuNUHcyYmC1pOlWhVMXrUAsWRWjzBRsV68u+8G6G3O2" +
           "N5j0+TpI2ixL3URjqlmU/KgT+CQ356ZDPGQ1tgMkmvOw6blrYqr5s1YPXTJi" +
           "VKfbumG6s1ajZ63gYDZd4ZXBsrQoh5rYbsvzZsQTAz6pyAMGY0O/tFJNrdSt" +
           "zss1pDYw6fGmosNMwk07Gg4bZqoHFtsqCDTaKHbDGb5Q17MKrPdrJRBQ8SCe" +
           "sOmcFFWRqqVLzdFbw0pXD2S+HqNePeVb/bFl4wuxP0+bUYFrhH0eCcoDv6Ml" +
           "42EBjweDkYl5uI4XUTPcCF2+MZTqYrpcKZyHp/NxCSlXN4gay6WgKARzu9ma" +
           "d2ZsHLebDM8Flg+2l8Bj+M6oXoIlulCrwGU4WiZrw2RDeiatrJI/YGmprlFU" +
           "f4OgNdegVUxLlXXbLVcSUp/JowIZGWRhwTNCKA7xfgdtoZaaYMsRUSovqy0T" +
           "Ky8HcHM87ukVZ0XO+CHKYHUDq6EVnV+yTJ9bx3NsYSaEheCG2S7gdNRGau1G" +
           "ccLpU7dfsxBDW0bLEtx12zThR/5sqLdLJgLHclQWldWKqAcobKflScqEBM42" +
           "ao6yiGoB0jYscVChMbrdaNg9ZEDjZDTlRkMrSvSquLawJFmDnTGs63Ri2aRZ" +
           "ZshZmCZMjLghTutyvbHgBRKT0FIqpiURtWbsgJBEQawbCm6TsB/POtJg6hlW" +
           "KazACDqztGhkT9oTpm/a1DSeN9mIaMgJUyZB6PYVuDwtTIt6mcdWjtsZlQt+" +
           "y+wMSsYSkUWmqpf6Fj2Ejaogw5teUSqnerqal/psWVHLfgWvRX6jbYN906wI" +
           "dZbj66rr8RUbXa4LGhwEqGf0KxbVbcPtVRuOnJam4A6/rlF4d+EGhJf0tIKc" +
           "JDxRr4rYpD1stxbRjMPTqFdsMA3bnjo9tFzm3JaqRtUSgjjgENVRS6kxRlFP" +
           "rqyFstTXInfAMXhvwTlYid4oKlzrD+DNsNGf1n20aA0ait8DcDChYS2YrZE6" +
           "V7K8Al0JTAyvKmHHIv3xTE+xRq9dKOA1vFq31F6lN4BZTirYVXCcbMaFVsS6" +
           "C345CgEObPQyIFTSKkgBNHopigurAVBWbhp4OO6XJVuB49CRuN6oMNQpjo9r" +
           "YBOP14NWTTWSgiJjFFxg7HJQSuupCMclYa6u1wnAawZe2ilX3SzJttAJGrbC" +
           "2Gi9y1f4gbCZoeKwk/bkeoS0o5bUYFFRsQ3fDYy1MmCFMDQLjUoL98NR2iPL" +
           "GB7rru+ZkZESklTrTOkROST6cNHmtUaVHY0n5krourVEWM+767FaThqIAnIV" +
           "Ze12BETS+wNtxVdb1XFMgrSmXDcnQ2KaNPSQ5KKyYPSYSV9dpRQ1S6gVJ9QH" +
           "hWVsVOvSJKh3W5UWPFk6gdpl5VpsFzsTI16I9co4RdB2VKnONW84G1V6Zcls" +
           "Yxs04WUKTbue0jaFWTxezTS/6lK9waIK2xu5P1VKjVlNEWdVS6Zmo7SkLYeY" +
           "uZDAFsOu0sZobAhJ3xacsJZMe3B1NlV5BK9a4wDGySQpEhSb2BJZTL2VqCyZ" +
           "GUnMOrihtm2wfzQos1yqz8Y1KbSCIRwOVbzqGYWoxadRtwsrvU0D2ZglkASK" +
           "lMevq4zYIyR9WJbEaTtCdKs6T4mIb7ecESZTeLveKrjN5YIr8QPPqaQprY1Y" +
           "psCk3RVHqApdxatmrIHDuGa59MJaGJjusp2p2u2LcVlZ9oRNaTkvwTpYxfY6" +
           "ncuFOA5wSurZfBwF44KDITUea8kWWvVanbpJbwiwF6ASBoQ0AUpSeMOscFzD" +
           "U2EiIiIEESLcr7YSotSZLbggpuHFglxziUiOmzNjkjBmb27xiJL0prSOwpvE" +
           "GscLJ12PsHI5peywA/surDpqpJZFxPfVErIMfXSheXqdBQeA178+Oxq8+aWd" +
           "zu7MD6JHtw7gUJa9aL+EU0ly4wH3Aug2x7MDcHJX5HzcXWkrr2rcc1i/Pvw9" +
           "Xtra1TvOHB6J33jDmi6VBIrlawtDub6ke7KOm53nHrrZlUV+lvvUO595Vh58" +
           "urh3UG+ageP7wU3S8fl40FM3P7Qy+XXNrgjy5Xf+84PjN6ze+hJKu4+cmuRp" +
           "kX/APPfV1qulD+9BZ49KItddJJ1kunqyEHLRU4LQs8YnyiEPHZnn/swaDwFV" +
           "v3tgnu/euLx6Q7ufyR1t616nanl7W8fIHezQqvdkVo1LUm7Mhi2FmcVy7vhF" +
           "KoFvyxoPmEfyFDFQDoXdfVzYgfV3Tuz/oqP1iZJbAL3iplcCh+MVX/I1A3Ce" +
           "B6673NxeyEmfe/bShfufnXwrL6cfXZrdRkMX1NAwjtexjj2fdzxF1fJFuW1b" +
           "1XLyn3cH0IM3n10Anct/c0XeteV434ExTnME0FnQHqf87QC6fJoSSMx/j9N9" +
           "MIAu7uiAtbYPx0k+DKQDkuzxI84Nil/b0l9y5lgAHgBObtK7fpFJj1iOV+az" +
           "oM0vog8DLNxeRV+TPv9st/+2F6qf3t4MSIa42WRSLtDQrdtLiqMgfeym0g5l" +
           "nW8/+bM7vnDbE4docsd2wrvQOTa3R25chqdMJ8gL55s/uf+PXvd7z34vr8X9" +
           "LzwdzUIhIAAA");
    }
    protected static class XBLContentElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLContentElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMContentElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "je9/lr+yx9f/CzUs0n2OFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AAA=");
    }
    protected static class XBLHandlerGroupElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLHandlerGroupElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMHandlerGroupElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2wcVxW+u37Edmyv7fgR8nAS1wmKE3brtgEqh7a2Y8cO" +
           "64fiJKIOzebuzN3diWdnJjN37LVLoa2EGhAKIaRtQKp/uapApa0QFSDRyqgS" +
           "bVVAaomAghqQ+FMeEbUKRVV4nXNnZmd2dp0o/MCSZ2fvPffce875znfO3Wev" +
           "kRrLJN1M43G+aDArPqLxaWpaTB5WqWUdg7GU9GQVff/Uu5N3R0ntLGnOUWtC" +
           "ohYbVZgqW7Nku6JZnGoSsyYZk3HFtMksZs5TrujaLOlQrPG8oSqSwid0maHA" +
           "CWomSSvl3FTSNmfjrgJOtifhJAlxksRgeHogSRol3Vj0xTcHxIcDMyiZ9/ey" +
           "OGlJnqHzNGFzRU0kFYsPFEyyz9DVxayq8zgr8PgZ9YDrgiPJA2Uu6Hkh9sH1" +
           "C7kW4YJNVNN0LsyzjjJLV+eZnCQxf3REZXnrLPk8qUqSjQFhTnqT3qYJ2DQB" +
           "m3rW+lJw+iam2flhXZjDPU21hoQH4mRXqRKDmjTvqpkWZwYNddy1XSwGa3cW" +
           "rXWsLDPx8X2JS0+eavluFYnNkpiizeBxJDgEh01mwaEsn2amNSjLTJ4lrRoE" +
           "e4aZClWVJTfSbZaS1Si3IfyeW3DQNpgp9vR9BXEE20xb4rpZNC8jAOV+q8mo" +
           "NAu2dvq2OhaO4jgY2KDAwcwMBdy5S6rnFE3mZEd4RdHG3k+DACzdkGc8pxe3" +
           "qtYoDJA2ByIq1bKJGYCelgXRGh0AaHKyZV2l6GuDSnM0y1KIyJDctDMFUvXC" +
           "EbiEk46wmNAEUdoSilIgPtcmD55/UBvToiQCZ5aZpOL5N8Ki7tCioyzDTAZ5" +
           "4Cxs7Es+QTtfOhclBIQ7QsKOzPc/t3bf/u7V1xyZrRVkptJnmMRT0kq6+c1t" +
           "w3vvrsJj1Bm6pWDwSywXWTbtzgwUDGCYzqJGnIx7k6tHf3L/w99mf46ShnFS" +
           "K+mqnQcctUp63lBUZh5mGjMpZ/I4qWeaPCzmx8kGeE8qGnNGpzIZi/FxUq2K" +
           "oVpdfAcXZUAFuqgB3hUto3vvBuU58V4wCCEd8E92ExL5GxF/kffxyYmcyOl5" +
           "lqAS1RRNT0ybOtpvJYBx0uDbXCINqJ9LWLptAgQTuplNUMBBjrkTsp5PWPPZ" +
           "/jsSMycO999xaGoCWZDlYb1Ilziizfg/7VNAezctRCIQim1hIlAhh8Z0VWZm" +
           "SrpkD42sPZd6wwEZJobrKU6mYOu4s3VcbB2HreNi63jlrXs/M5Qco5qMkTR1" +
           "2xhx5kYppv0iiUTEedrxgA4sIKhzQA/Az417Zx44cvpcTxXg0VioxriAaE9J" +
           "nRr2OcQj/pT0fFvT0q6r/a9ESXWStMFONlWx7AyaWSA0ac7N+cY0VDC/kOwM" +
           "FBKsgKYuMRl4bL2C4mqp0+eZieOctAc0eGUOEzqxfpGpeH6yennhkRNfuD1K" +
           "oqW1A7esAdrD5dPI+EVm7w1zRiW9scfe/eD5Jx7SffYoKUZeDS1biTb0hBET" +
           "dk9K6ttJX0y99FCvcHs9sDunkI1AnN3hPUrIacAjerSlDgzO6Gaeqjjl+biB" +
           "50x9wR8RUG4V7+0Aixhm636Ax9/d9BWfONtp4LPLgT7iLGSFKCSfmjGe+vXP" +
           "/3incLdXc2KBZmGG8YEAz6GyNsForT5sj5mMgdw7l6e//vi1x04KzILEbZU2" +
           "7MXnMPAbhBDc/MXXzr79u6srV6I+zjkUejsN/VKhaGQd2tR8AyNhtz3+eYAn" +
           "VeAQRE3vcQ3wqWQUmlYZJtY/Y7v7X/zL+RYHByqMeDDaf3MF/vhHhsjDb5z6" +
           "R7dQE5GwTvs+88Uc8t/kax40TbqI5yg88tb2b7xKn4IyAtRtKUtMsDERPiAi" +
           "aAeE/beL512huU/gY7cVBH9pfgX6qZR04cp7TSfee3lNnLa0IQvGeoIaAw68" +
           "8LGnAOq7wuQ0Rq0cyN21OvnZFnX1OmicBY0SULM1ZQKFFkqQ4UrXbPjNj1/p" +
           "PP1mFYmOkgZVp7LDgVDAAN3MygH7Fox773Oiu4DhbhGmkjLjywbQwTsqh24k" +
           "b3Dh7KUfdH3v4DPLVwXKDEfH1qDCj4pnHz4+JsajnNQbps5BFYOeqtYSzaCP" +
           "SLG23auW3mcQkf4eEfG+mZN7K1aQkQJnmqUAvMoLSGnFwIBsX69BEs3dyqOX" +
           "luWpp/udNqattOkYgZ76O7/810/jl3//eoX6Vus2uMGDw34lJWdCNI4+7b3T" +
           "fPEPP+zNDt1KtcGx7pvUE/y+AyzoW796hI/y6qN/2nLsntzpWygcO0K+DKv8" +
           "1sSzrx/eI12Mii7ZqRll3XXpooGgV2FTk8F1QEMzcaRJZNdtRRR1IWi2g6M/" +
           "dFH0YWXyFhDFx75ySlxvaYg8og6sPSi2iIzBXj/u9PreRDtidOFOSUDzkC7Z" +
           "iD9xjPtvQEcpfBwDDEkmg37VU7YpqMzFspj7JD6OO+k08D/mPQ4MGgW4NN+w" +
           "zfLO0n/L7Rugf3PZpdG56EjPLcfqupaP/0oAv3gZaQQIZ2xVDSAgiIZaw2QZ" +
           "RTis0eFZQ3zMwf1q/dNxUiM+hSFnnBWaG6jwCk6q4BmUPAuxDkuCRvEZlOOc" +
           "NPhyEEnnJSiyANpBBF+BdcuB5NyQCpFyehXh7rhZuItLgq0D5r244Hs5ajtX" +
           "fOh0l49MPrj28aed1kVS6dKSuBDC/dbpoop5vmtdbZ6u2rG915tfqN8ddfHc" +
           "6hzYz76tAbAPQrYZWHa2hOq61Vss72+vHHz5Z+dq3wKePUkiFFLhZOB67XgK" +
           "mgMbCPZk0qfYwA9EouEY2PvNxXv2Z/76W1G5XEretr58SrryzAO/uLh5BRqT" +
           "jeOkBkoCK8ySBsU6tKgdZdK8OUuaFGukAEcELQpVx0mdrSlnbTYuJ0kzApki" +
           "HQi/uO5sKo5i48tJT9kdv8J1Aar8AjOHdFuTBfMBJ/sjJb88eFRpG0ZogT9S" +
           "DGV7ue0p6dCXYj+60FY1CslYYk5Q/QbLThdpOPhjhM/LLQ65/gf+IvD/b/zH" +
           "oOOAcyduG3Yv5juLN3NoJ5y5qlRywjA82bo1w0mRL+PjKwUc5yTS544ikUWc" +
           "Gotfvyr2Py9e8fG1/wKdbjhqmBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "uW/kNbn/BWX6w5ItIAAA");
    }
    protected static class XBLImportElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLImportElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMImportElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "81f2+MZ/AbHSbrOMFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class XBLShadowTreeElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public XBLShadowTreeElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.dom.svg12.XBLOMShadowTreeElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/brY/7x4xcc3/guKI1YnlBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471028785000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ZeczrWHX3+968WR7DvDf7dGBW3tDOBH1OnMROOmxxYmex" +
           "HTt2Eidu4eF4SRyv8R7TaQcklpYKEAyUSjB/gdqiYVFV1EoV1VRVCwhUiQp1" +
           "kwqoqlRaisr8UVqVtvTa+fb33qBRpUbKjeN7zrn33HPO75577gs/gC4EPlTy" +
           "XGu7tNxwX0vD/bVV3w+3nhbsD+g6J/uBprYtOQjG4N1V5fEvXvrRjz+8urwH" +
           "3SxBd8uO44ZyaLhOwGuBa8WaSkOXjt8SlmYHIXSZXsuxDEehYcG0EYRP09Cr" +
           "TrCG0BX6cAowmAIMpgAXU4Bbx1SA6dWaE9ntnEN2wmAD/TJ0joZu9pR8eiH0" +
           "2GkhnuzL9oEYrtAASLg1/z8FShXMqQ89eqT7TudrFP5YCX7uN95++XfPQ5ck" +
           "6JLhCPl0FDCJEAwiQbfbmr3Q/KClqpoqQXc6mqYKmm/IlpEV85aguwJj6chh" +
           "5GtHi5S/jDzNL8Y8XrnblVw3P1JC1z9STzc0Sz38d0G35CXQ9b5jXXcakvl7" +
           "oOBFA0zM12VFO2S5yTQcNYQeOctxpOMVChAA1ltsLVy5R0Pd5MjgBXTXznaW" +
           "7CxhIfQNZwlIL7gRGCWEHryh0HytPVkx5aV2NYQeOEvH7boA1W3FQuQsIXTv" +
           "WbJCErDSg2esdMI+Pxi+8YPvdHrOXjFnVVOsfP63AqaHzzDxmq75mqNoO8bb" +
           "n6I/Lt/35ffvQRAgvvcM8Y7m93/ppbe+4eEXv7qjec11aNjFWlPCq8qnF3d8" +
           "87XtJ5vn82nc6rmBkRv/lOaF+3MHPU+nHoi8+44k5p37h50v8n82f/az2vf3" +
           "oIt96GbFtSIb+NGdimt7hqX5Xc3RfDnU1D50m+ao7aK/D90CnmnD0XZvWV0P" +
           "tLAP3WQVr252i/9giXQgIl+iW8Cz4eju4bMnh6viOfUgCLoXfKEnIGjvMlR8" +
           "9i7lbQip8Mq1NVhWZMdwXJjz3Vz/ANaccAHWdgUvgNebcOBGPnBB2PWXsAz8" +
           "YKUddKiuDQfxsoLAwrRbQTos07c9gBKAvwiX/dzbvP+ncdJc38vJuXPAFK89" +
           "CwQWiKGea6maf1V5LsKJlz5/9et7R4FxsFIhxICh93dD7xdD74Oh94uh968/" +
           "9JUZTgsrWXWTsa9pxK6HlPOg30LnzhWzuSef3s4pgElNAA4ANm9/Unjb4B3v" +
           "f/w88EYvuQnYIyeFb4ze7WM46RegqQCfhl78RPKu6a+U96C90zCcqwReXczZ" +
           "uRw8j0Dyytnwu57cS+/73o++8PFn3ONAPIXrB/hwLWce34+fXXzfVTQVIOax" +
           "+Kcelb909cvPXNmDbgKgAYAylIFjAwx6+OwYp+L86UPMzHW5ABTWXd+Wrbzr" +
           "EOguhisf2OLoTeEVdxTPd4I1Lhz/KRABdx5EQvGb997t5e09Oy/KjXZGiwKT" +
           "3yR4n/rrP/+narHch/B96cSGKGjh0ycgIxd2qQCHO499IHcUQPd3n+A++rEf" +
           "vO8XCgcAFK+73oBX8rYNoAKYECzze766+ZvvfPvT39o7dpoQ7JnRwjKU9EjJ" +
           "W3Od7ngZJcForz+eD4AcC4Rj7jVXJo7tqoZuyAtLy730vy49UfnSv3zw8s4P" +
           "LPDm0I3e8NMFHL//GRx69utv//eHCzHnlHzLO16zY7Idjt59LLnl+/I2n0f6" +
           "rr946De/In8KIDJAwcDItALYoGINoMJocKH/U0W7f6avkjePBCed/3R8nUhN" +
           "riof/tYPXz394R+9VMz2dG5z0taM7D29c6+8eTQF4u8/G+k9OVgButqLw1+8" +
           "bL34YyBRAhIVgHIB6wM0Sk95xgH1hVv+9o//5L53fPM8tEdCFy1XVneAAvYC" +
           "4N1asAJAlnpveevOuklu7gLYU+ga5XdO8UDx7zyY4JM3xhcyT02OQ/SB/2St" +
           "xbv//j+uWYQCWa6zI5/hl+AXPvlg+83fL/iPQzznfji9FqFBGnfMi3zW/re9" +
           "x2/+0z3oFgm6rBzkiFPZivLAkUBeFBwmjiCPPNV/OsfZbehPH0HYa8/Cy4lh" +
           "z4LL8c4AnnPq/PniSTz5CficA9//yb/5cucvdjvrXe2D7f3Ro/3d89JzIFov" +
           "IPvYfjnnf0sh5bGivZI3P7szU/74cyCsgyI5BRy64chWMfBbQ+BilnLlUPoU" +
           "JKv5JrS2sELMvSA9L9wp135/l+HtAC1vkULEziXqN3Sfn99RFTvXHcfCaBck" +
           "ix/4hw9/40Ov+w6w6QC6EOfrDUx5YsRhlOfP733hYw+96rnvfqBAKQBR02ef" +
           "+NciG6FfTuO8IfKGPFT1wVxVoUgKaDkImQJYNLXQ9mVdmfMNG+BvfJAcws/c" +
           "9R3zk9/73C7xO+u3Z4i19z/3az/Z/+BzeyfS7dddk/Ge5Nml3MWkX32wwj70" +
           "2MuNUnCQ//iFZ/7wt595325Wd51OHglwNvrcX/73N/Y/8d2vXSdPucly/w+G" +
           "DW+/3KsF/dbhh67MdTFR+FTU2WYwQzCyGUYsZzI8W1t7uKIM1OpYatXVjqhG" +
           "GVHTtyu2b7ujKishdQRDqqtYxRhMrjfVtl22Kn181G6TYatCNy00oKZDl5qM" +
           "CMGfJ5vydE56g3mfopa4MYMpviyshUjkGtxMw1gsrIa1+kRfdoQmtrCrTiaF" +
           "dSyGVWxRwuoyOmYZ04zLVaNNpw4juKmn92WZ9Ia9qehJKdIK6HFFHWWNRlPH" +
           "JvGUEOwtE2qiNxRC3qgl3lgSI7bZNuRUNm1GjCiGt2bZYM3Mo3m7Pt9EmUSy" +
           "qeS6Xco1qFkqWKlJORRuGz7PZ2bZmlcZpCb4S6+tkIOyTZlboZc0hx1K7Zuo" +
           "Igs0Vqv3OzXZJnqDpV+apRPLR5ep6hL2gkLcrTddNTZdQ4jnckRH04kjqHNT" +
           "0NkNF6pkmg4wuZmM1CbdmDejGWNU2ys1cL2NrSBdcNDkpcj3W3VcGJTQ4Zoy" +
           "wrnUMGfCBKEWraSvNCm9sZaGyUYaIEMhq3hau5wpWSagDBr0Fcy2qS7f14wB" +
           "q9YnLiOHVHuDSF0HN8uVHjdTfWLuDys8wJ00CGhiACs2nVWam3iGDYVRiS9R" +
           "1NCNe6bWGvU6stSqaduRK0sVvxUwVZsNu+YIIy2bsvipFVb6YSWkxhtOWcU4" +
           "tghIHEHaNjLkqqQy4hedYWhoob1dbIPWYIz5AuqXV9kciWYL1FrW1tFwOaeY" +
           "Np6xGdnrOPTGVqeZIJml6ooUJotS1qBbPl4e1XppTGLyxpLXDNGRe3PDnTKB" +
           "JSUkKi7rBFodtVzGGViOOHU3jSEVVMc9Ilj3zeGWadQmQmfS50stYbz2O3Oz" +
           "P+a7Fk0RG7xEbhes0ynNNSQhjQnP0hwzwGdcnBJicz4Xe+JUktZ0v4Woq3K5" +
           "s6FUv7L1TbcvdJQuP0CkHlZbaQGHsaGqNVgemXqktPaylWk2aLliiyGmDX3f" +
           "qa7cBu8jKzFxu3Ej3ZriJMOCdFQetbuoALYMxiaGmIU0uwrHxZ7aDBWw4smS" +
           "mVgzbEQvN0RVaNdkg4mZUbm+GrAS4wgtblwniZQrE0jSC6mytMxYrzoU3ZQz" +
           "SW/aYablBl9RrNZkilKDrkZqZZ9Fm9362ElnMd/v8+VkDUv8xAAOb8AyvtUd" +
           "Zj2IyfpSEDx+rPbK9f7Wc+GKSKyWTgvDhoOMbZVi2/TUwB512p6NmSYOIsYe" +
           "Byu0Jpqh1FrE7aCulehRjSz3vK3G41MTr7hhWRA68pqDx5wpltXm0Bi0qBWC" +
           "z+3WarpF6Xa0DVJGqOuBuej5NDrWFbPdNTQSNbzhAOn4q8WgPBK36hKtjees" +
           "RTZRGOPWMm83KmORrJWkdb9cZ0rMxKyiA75NG0O8UuNayoQYDur9lrqso/Nm" +
           "kDRUdoZEfrIYye1MHK3TUUiVAsGtoh2W5nXLQ4NFpa5p+jRRNcPrSCRiE46N" +
           "enO1vxj2hm1pyDZtnWS6qKfqvDMntsu1yFXYmd1KgtCq1ZXFbIImMZP2SJZd" +
           "9uW4TfVQKVXiBj/hxk0pwrIa0jfjKm9aZZ2mltNYbGnOqrFyzFJKxc2aIrl1" +
           "XyvhXKzDY2NSg13O0SaWQMVLSw54PEYTZzmItkrY0bZLGlV1Teb1iC7j0aAy" +
           "3hLiMlOxpGfPJkN2zHNDT+gkkqMuhq2plG31YdZvbBctLxsZy2FiV9dBizQG" +
           "M3yLe0gzM0mpUUOQ2TJoBjgX9QOpP3H79ZI0lLA6JsCwTqtJWFHTmkuKc2mR" +
           "uqMO7S4GSCKqIWcnPLLtVKuRKC2yeh2b2+OWzyyViVbp6HHKjvwANwhiWIXr" +
           "6wUXw1Fvg3qiu64yrKRi7IhWJzRuSetMrlQZvo90kaqeAn/kJ3Oc7I31StLR" +
           "2560EqXJynUqGWxEiaTDqo9NkzlB9VOUaYYVeTmGSwHf26Jk5MAh4VeIkekP" +
           "qVJWTdIV7FZL0qY3lpioNrapNVYdN9DqDB0PR3y/XaNFUWoLNTtZqgTeReCA" +
           "a7KNReIMOcXT2e12GbXiDG22hnVRpK2sDoxD4GgTeKoSLhpaO5BQM/VaHbqa" +
           "BbRLo9i6Ve/JktiLxmBVYlSnIlRdMuXMJbvt+Vqy1zI+6ofWtte20GzRwDZa" +
           "rEqVUlSTiLRsrzcWJ9UmLXdWwyMpEnGtFnfhUaNWnlYJpR/K0/ZomloK4/bZ" +
           "6jSBVZHpLZPQobmSX0rmPWe6qVEWbrPrTQVf8Y1ZlpANnQBbYmZ5DAECaut2" +
           "e9MZQ2yQ5bpspCE4slhq3SEGvVJvBXDXs8clNBbXGGFI9Y3VopPNtqzWU6Xd" +
           "alLZrOc64iIGm+g23jZptjNeceNZWN+uCbIHLyo6XIodkN8CvxlS6jyqY2I1" +
           "qdG4Liq2RHaR9bgax+E0a5RrMKZs2eoEqSQ+p4jNkQAvEoXGQznuRd11zGG1" +
           "GTZXom0TLq3nVArLI7rBbOKMq8ODqKeawcxFBz3V9rq82FRje+mi5Gxe6fJJ" +
           "V+2MxnjqkaFV4ROLrI4MuWfinFeLjCzyTVpoAz9Apha91sorvM7jlblWwQOS" +
           "tzvODGujutA0RhiBsrRquh17NEW2xAw2ui1YW/UxodRZdruDAYOHyMZD0vFk" +
           "YNPSuFeVZ4miNgce2oMZLU3mQ3ejLOjKwCyJqsS1ETHTW3AkU210mG0lUhP7" +
           "zkxFGwpcQ1q6Zhrl5aiVhZtN113BRCtIE4SX+IXhb0VSGlUzJmlWNrA6TCeG" +
           "UloJpOPgotxFF0nbrG9quD3hWhHfMaM2HxOSxbLKkPO2BKE7A8HYtocejpMl" +
           "XNmGq/pwyxoeSSmrGY756TQgQnrpljuSj9SqvUCS1/FMK62yaa3OcLOsaTYa" +
           "6HoemeVoaim8TURodTyqi1ud1VBknaqBMsQWvtCogN0b3VD1bGwnTjVctCot" +
           "Hbdq5YBdBe3ptLLBmpPqsKlyemdDNzCyuuyK3MQ0SJxeSSy+wWZLSlwyC5Sb" +
           "mltDnyf9ZgdsJXMk5kJPjxEQ+iWt0q3OCFoL/XpD9P1tlWDhyF/VSXUjrHnW" +
           "7CzdNtVAeT6YoBE1UiWVarMTTSbFKGgTCkGPvOmgbDR9wXIW4/nKKy/plmca" +
           "3ZEBR2wdxHDFQBrhYNaYNePAs1qi3+ivhz2VjMa41sD7cLCWFg1UI3ivW5bc" +
           "5bgptO1pz9MqHqrhs9q6VC+TtawTWHPJrI/g0YLOPL7PcqvOioEpf4RW4KVe" +
           "6scdeAFnPZdlW0rajHrVSVwfh1RYHbgDb1u3HX5TXrcaiO5yHUElY3fDAVOl" +
           "zoDrLzsRNcSllDLSErzw5zCW1lJFqcLLiOpX5o6Fj8AB4E1vyo8Gb3tlp7M7" +
           "i4Po0b0DOJTlHb1XcCpJrz/gXgjd5vluCE7umlqMe1zaKqoa9xxWsA9/T5a2" +
           "jusd5w6PxG+5blWXSEPNCYyFpV1b1D1dx83Pcw/d6NKiOMt9+t3PPa+yn6ns" +
           "HdSbZuD4fnCXdHI+PvTUjQ+tTHFhc1wE+cq7//nB8ZtX73gFpd1HzkzyrMjf" +
           "YV74Wvf1ykf2oPNHJZFrrpJOMz19uhBy0dfCyHfGp8ohDx2Z5/7cGg8Bs9x7" +
           "YJ57r19eva7dzxWOtnOvM7W8vZ1jFA52aNV7cqsmVaUwZsdVotxiBXfyMpXA" +
           "d+aND8yj+JocaofC7j4p7MD6x04c/LSj9amSWwi95mUuBQ5HrLziqwbgPg9c" +
           "c8G5u5RTPv/8pVvvf37yV0VB/eji7DYaulWPLOtkJevE882er+lGsSy37epa" +
           "XvHz3hB68MazC6ELxW+hyHt2HL96YI6zHCF0HrQnKX89hC6fpQQSi9+TdB8K" +
           "oYvHdMBeu4eTJB8B0gFJ/vhR7zrlr13xLz13IgQPIKcw6l0/zahHLCdr83nY" +
           "FpfRhyEW7a6jrypfeH4wfOdL6Gd2dwOKJWdZLuVWGrpld01xFKaP3VDaoayb" +
           "e0/++I4v3vbEIZ7csZvwcfCcmNsj1y/EE7YXFqXz7A/u/703/tbz3y6qcf8L" +
           "akHziyUgAAA=");
    }
    protected static final org.w3c.dom.DOMImplementation
      DOM_IMPLEMENTATION =
      new org.apache.batik.dom.svg12.SVG12DOMImplementation(
      );
    public static org.w3c.dom.DOMImplementation getDOMImplementation() {
        return DOM_IMPLEMENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeO8eOn/EjL+PETmI7oTHkjgQoUNMUx3GI0/Oj" +
       "cbBUB3Ks98b2Jnu7y+6cfQ5Neag0oRIoDSHQFiwqAklpwBECtYgCqVB5CIrK" +
       "o1BKw6NPKEUlrZqi0pb+/8zu7eMebiSCpZvbm/n/mfkf8/3/P+sjH5BiyyRN" +
       "VGMRNmlQK9KlsX7JtGiiU5Usawv0xeXbiqS/b3u396IwKRkic8Ykq0eWLLpB" +
       "oWrCGiKNimYxSZOp1UtpAjn6TWpRc1xiiq4NkfmK1Z00VEVWWI+eoEgwKJkx" +
       "UisxZirDKUa77QkYaYzBTqJ8J9GO4HB7jFTKujHpktd7yDs9I0iZdNeyGKmJ" +
       "bZfGpWiKKWo0plisPW2SswxdnRxVdRahaRbZrp5vq2BT7PwsFTQfrT758d6x" +
       "Gq6CuZKm6YyLZ22mlq6O00SMVLu9XSpNWleRr5OiGKnwEDPSGnMWjcKiUVjU" +
       "kdalgt1XUS2V7NS5OMyZqcSQcUOMLPNPYkimlLSn6ed7hhlKmS07ZwZpl2ak" +
       "FVJmiXjrWdH9t22rebCIVA+RakUbwO3IsAkGiwyBQmlymJpWRyJBE0OkVgNj" +
       "D1BTkVRlp23pOksZ1SSWAvM7asHOlEFNvqarK7AjyGamZKabGfFGuEPZv4pH" +
       "VGkUZF3gyiok3ID9IGC5AhszRyTwO5tl1g5FSzCyJMiRkbH1y0AArLOTlI3p" +
       "maVmaRJ0kDrhIqqkjUYHwPW0USAt1sEBTUYa8k6KujYkeYc0SuPokQG6fjEE" +
       "VGVcEcjCyPwgGZ8JrNQQsJLHPh/0Xnzz1dpGLUxCsOcElVXcfwUwNQWYNtMR" +
       "alI4B4Kxsi12QFrw2J4wIUA8P0AsaH70tROXnN107BlBsygHTd/wdiqzuHxw" +
       "eM6LiztXXlSE2yg1dEtB4/sk56es3x5pTxuAMAsyM+JgxBk8tvmpr157H30/" +
       "TMq7SYmsq6kk+FGtrCcNRaXmpVSjpsRoopuUUS3Ryce7yWx4jikaFb19IyMW" +
       "Zd1klsq7SnT+G1Q0AlOgisrhWdFGdOfZkNgYf04bhJDZ8CGV8PkCEX/8m5FE" +
       "dExP0qgkS5qi6dF+U0f5rSggzjDodiw6DF6/I2rpKRNcMKqbo1EJ/GCM2gMJ" +
       "PRm1xkdXr4kODF66es36vh5EQZoEfn5cIuhtxme0ThrlnTsRCoEpFgeBQIUz" +
       "tFFXE9SMy/tT67pOPBB/TjgZHgxbU4yshqUjYukIXzoCS0f40pHcS5NQiK84" +
       "D7cgDA9m2wEAAAhcuXLgik1X7mkuAo8zJmaBzpG02ReJOl2UcKA9Lk/XVe1c" +
       "9ubqJ8NkVozUSTJLSSoGlg5zFCBL3mGf6sphiFFuqFjqCRUY40xdpglAqnwh" +
       "w56lVB+nJvYzMs8zgxPI8MhG84eRnPsnx26fuG7wmnPCJOyPDrhkMQAbsvcj" +
       "pmewuzWICrnmrd797snpA7t0Fx984caJklmcKENz0CeC6onLbUulh+OP7Wrl" +
       "ai8D/GYSnDeAxqbgGj74aXegHGUpBYFHdDMpqTjk6LicjZn6hNvDnbWWP88D" +
       "t6jA87gMPpfYB5R/4+gCA9uFwrnRzwJS8FDxxQHjzl+98N65XN1OVKn2pAMD" +
       "lLV7kAwnq+OYVeu67RaTUqA7fnv/Lbd+sHsr91mgaMm1YCu2nYBgYEJQ8w3P" +
       "XPX6W28efCXs+jmDUJ4ahowonRES+0l5ASFhtRXufgAJVUAJ9JrWyzTwT2VE" +
       "kYZVigfr39XLVz/8l5trhB+o0OO40dkzT+D2n7GOXPvctn828WlCMkZiV2cu" +
       "mYD3ue7MHaYpTeI+0te91Pidp6U7IVAAOFvKTsrxlnAdEG6087n85/D2vMDY" +
       "Bdgst7zO7z9fnowpLu995cOqwQ8fP8F360+5vLbukYx24V7YrEjD9AuD4LRR" +
       "ssaA7rxjvZfXqMc+hhmHYEYZwNfqMwEk0z7PsKmLZ//6p08uuPLFIhLeQMpV" +
       "XUpskPghI2Xg3dQaA3xNG1+yrTtRCk0NF5VkCZ/VgQpektt0XUmDcWXv/PHC" +
       "hy4+NPUm9zJDzLGI8xch5PtQlSfu7sG+7+ULfnno2wcmROhfmR/NAnz1/+pT" +
       "h6//7UdZKuc4liMtCfAPRY/c0dC59n3O7wIKcrems8MUgLLLu+a+5D/CzSU/" +
       "C5PZQ6RGthPlQUlN4TEdguTQcrJnSKZ94/5ET2Q17RnAXBwEM8+yQShzwyM8" +
       "IzU+VwXQaz6asBc+R+2DfTSIXiHCH7o5y5m8bcNmFTdfmJEyw9QZ7JJCclti" +
       "8aw8ABzzCszPyBweo4U/KuDF2F3PSEvOeJ5x6i0IBwJZsb0Qm01i3fa8ftzp" +
       "l3stgN1dglR855D7sjxy42MPNr3ZwuadlJHK9LCaERX7vhKQYfD/l2ER9i6H" +
       "vTQJ0nBjHhmuyC1DkSsDA9dRNEkNyNLgTJpjcnBUyKji3T39sa6ert4tHVu6" +
       "+3od4zWi8SbOlbnNshKvgMjbCogshs7E5qzM3vhfCQnkxN5o5OILQRBtzFe2" +
       "8JLr4PX7pxJ996wWCFPnLwW6oNK9/9X/PB+5/e1nc2SdZUw3Vql0nKqeNUtw" +
       "SR+m9fCKzgWI43P2/e6R1tF1p5IkYl/TDGkg/l4CQrTlh8ngVp6+/s8NW9aO" +
       "XXkK+d6SgDqDU/6g58izl66Q94V5+SqQK6vs9TO1+/Gq3KRQp2tbfKjV4j+9" +
       "rfDZaDvAxqDnuy4W8J1MJpOPNRDzi7lFix3HXpUTlTqGIWsFKw6wSRVxab0u" +
       "p9DbHa4VWVyyZUWoNgoRJdI5MGDfYjjkbTnJDbwRMSNdaQZVJU3wCxLTfzuG" +
       "LjSQgs3wLEeUzpdXPPWEdfcfHxTe3ZyDOFCPHz5UKr+RfOr3guGMHAyCbv7h" +
       "6E2Dr21/njtOKXpqxlweLwWP9qTNNRk7RJxz+xvbDvybEflTqDe5iiwFDZGv" +
       "rP0slkHkWZ7/IHpsNHVvywvXTLW8w5O5UsWCow16y3Hf4uH58Mhb779U1fgA" +
       "h5BZqH5b9f6Lqux7KN/1ErdKNTbfSDvuFynkreOYpER4qtIjadIoNTNHJWSX" +
       "yTxKiSntAHRTgSAawUayA88n8BeCz3/xgw6BHcIx6jrtW5elmWsXAwxZosLG" +
       "2JhVMDXsN5UkVE/jtodHd9W9teOOd+8XHh7MAwPEdM/+b30SuXm/AH9xh9eS" +
       "dY3m5RH3eMLfsdmLjrCs0CqcY8Ofpnc9enjX7rBdYQBoFoHx8PFGw027w0J1" +
       "jrFEaYPJIkQ1XaMIP86YuNhQ9EjmIhQG0zntZQh78cU8sMm3X6AKurvA2D3Y" +
       "3AWZhYz7EmIUID+cXVhgR4fhqUFCmYuYeX5YEqZaf2P1T/bWFW2AI9FNSlOa" +
       "clWKdif8kWW2lRr24JR76+nGGdto6HqMhNqceuVaP3ZB8kiO29h13IkhN/A9" +
       "f1Mw7MZmOnOs1sx8rAbGdJONSVpixqM17Ryth2Y+WlwcbPZhcwCbo9kOhT+/" +
       "h82dBTxkmk92FJvvF7DlowXGHsPmEWzuFTspQPvE/+8T+PNImnNNFpjxSWwY" +
       "VN2ySQFCIPZ2cQM4Rlo+Q6T2UPPcNTVTul64dBbSCP1m3IunuM3widvuFT/1" +
       "7CYfa0A1RXYNbktf44KJeMWA/S86o/W+pN5OcfDo8P38IjC113eymPt6utIy" +
       "NTBUcuZXsXkOakFhlmD+NC/Xyq4Rnj8NRpjrGMGwNWmcuhHysRY2QrYLelNM" +
       "R3puGd7wjfyhgM+/h83bGZ/vEnlK70AmhHi1a4+6yn3nNCh3KY5h8neLraFb" +
       "Tl25+VgLKOJkgbGPsDnBSIPfA7vGoRlIGQYAs6Ovc3IaiCKlFcnLyJX5t9Og" +
       "zHoca4PPIVsjh05dmflYC5/pZQU9tRfiMi4dKs6v9lAZNpjd2b6ZQ92fK6Tu" +
       "nGoOhU6DmrHcJBdCoGwRc4rvPGrOH46D10W1BWYsoLdCY2dgUwuoOUpZzruX" +
       "hKupuk9DU2lGFuR+xYZ3w/VZb/bF22j5ganq0oVTl70mKhjnjXElFJMjKVX1" +
       "3l56nksMk44oXNeV4i7T4EIvg6Ob/w0gZKH8GyUILRUcrXZcCXJA2g2tl/JM" +
       "iIxBSpiRf3vp2hgpd+mgNhEPXpJVMDuQ4GPEKHypABvGF5dZOk2L87fIaxQO" +
       "LvNnsqXnRqzFVyzxf9Fw0umU+CeNuDw9tan36hOfv0e8mpJVaedOnKUCkmjx" +
       "lswuIb3FTXA2Z66SjSs/nnO0bLlT3NSKDbtHZpEHizsAYwx0nYbAexurNfP6" +
       "5vWDFz/+8z0lL0FZtpWEJIhiW7PvzdNGyiSNW2PZxQJU2PyFUvvK706uPXvk" +
       "r2/wNxNEFBeL89PH5VcOXfHyvvqDTWFS0U2KoW6jaX6hv35S20zlcXOIVClW" +
       "Vxq2CLNA1eWrROagl0uYWXG92OqsyvTii01GmrPLy+zXweWqPkHNdXpKS+A0" +
       "UMtUuD3CMoE7NUDJAIPbY5sS2x9iszeN1gBnjcd6DMOpwktPGvzIH8mdfaNX" +
       "d/BHfFr3P4hA/Dy+JQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8yFvbD7O9MPYlD31DU345UMT/tp3acI8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+cU8+ft58iu32yr/+dk8+dwFyv9y0div5Mk/ukBN/+yCsl/Pk6/kyas7Ti6g" +
       "/Y1s9/47F9D8Zp58NC5dU0JNjrWjsXOo9mffABdPUBfz7d96o9OZkwzsNHPk" +
       "DG/PM58Bz60DZ7j1vZkg7jqOI4rwYHEo3GOnTj0PZoQcWItmvnammZPmvK0y" +
       "PSYzRQvyObio/C/z5Ktx6cGdXs9ON28/r+djLf6Lt6DFRw61GBxoMfieavHO" +
       "jnFymj0U6VjnRZv/6QJP/KM8+fqRJ5K782eKO0LBkyo7KD3W2OtvQWNP5Zl5" +
       "mPeJA4194nujsZPS/Y8Lyv40T/57XHr8tK+Qa5BwSRAAVDtUAnyu1rWcMtq/" +
       "Y8VCQ3/yFjT0WJ75HHg+d6Chz31vNHRmSD19oU9RvloMzL29O+ty73Ke+edx" +
       "6eEDLzpHh++9SIfn6+4v3oLu8oi3hIMp4sau7u79XerueCJqv5GL7T10Qdkj" +
       "eXI/wB1Di8+93jE/EnbvgTcjbBaXHj3/Oml+N+6x226x725eK1986dq973xJ" +
       "+Ne7uPXwdvR9o9K9euI4J68ynfi+EoSabhV6uG93sSkohHscDJ0733YF0Unx" +
       "zlnf+75djScOEPhsDRCOgfQk5VNx6fpZStBi8T5JdyMuXT2mAxHf7uMkyXtA" +
       "64Ak//yB4OLVCmA4v6R7m06zvdOrzyMHffiNbHZiwXrj1Gqk+HeEwyVhsvuH" +
       "hFvKl14aUD/xbfSzu5ujiiNvt3kr94KFw+4S69Gy8uk7tnbY1pXe+77z4Kv3" +
       "PXu4BH5wx/Cx15/g7d3nX9Mk3SAuLlZuf+2dX/6Rz7309eLKzf8FEMUJeicy" +
       "AAA=");
}
