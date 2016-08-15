package org.apache.batik.extension.svg;
public class BatikDomExtension implements org.apache.batik.dom.DomExtension, org.apache.batik.extension.svg.BatikExtConstants {
    public float getPriority() { return 1.0F; }
    public java.lang.String getAuthor() { return "Thomas DeWeese"; }
    public java.lang.String getContactAddress() { return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.dom.ExtensibleDOMImplementation di) {
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_REGULAR_POLYGON_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikRegularPolygonElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_STAR_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikStarElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikHistogramNormalizationElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_COLOR_SWITCH_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.ColorSwitchElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_TEXT_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowTextElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_DIV_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowDivElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_PARA_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowParaElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_BREAK_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionBreakElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_LINE_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowLineElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_SPAN_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowSpanElementFactory(
              ));
    }
    protected static class BatikRegularPolygonElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikRegularPolygonElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikRegularPolygonElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "59fF+ufEKzbf+C8VKcJ/qhQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/928QPe/HU6EjTsgAAA=");
    }
    protected static class BatikStarElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikStarElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikStarElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ild8fOu/xMizC5YUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IAAA");
    }
    protected static class BatikHistogramNormalizationElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikHistogramNormalizationElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikHistogramNormalizationElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "XmS4kJ188ee3xPpnxSs23/4Pum5SkboUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "evLlB774+t959jtZwe5/ABl4QbhTIAAA");
    }
    protected static class ColorSwitchElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public ColorSwitchElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.ColorSwitchElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "tvjzSbH+GfGKzXf+C1fJFs2aFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "nv1OUZj7XySBP0YrIAAA");
    }
    protected static class FlowTextElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowTextElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowTextElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "IHff6sTnm5XVW6BxFjRKwMjmpAHUWSxDhiNdveF3P32z49TlCAmPknpFoxmb" +
           "AyFtAbqZmQfWLeoPPWwHdwHD3SxMJRXGV3Sgg7etHbqRgs6Fs5d+1PmDgy8u" +
           "Xxco020dW/wKPynaPmw+JfrDnNTphsZBFYNKqsYUJaCHSDG3zc2R7rcfkd4a" +
           "IfG+mZOHKjJHRivEnTwB8BqeHMf7gUgSIj6x8oyBAelerywSJd3KUxeXM5Mv" +
           "7LeLl9byUmMEKunv/ebfP49f+uM7a+S1Gqes9W8c1itLOeOiXPRo7/2mC3/6" +
           "cSw3eDfZBvt67pBP8Pc2sKBv/ewR3MpbT/2la+bB/Km7SBzbAr4MqvzO+Evv" +
           "HNolXQiL2tjOGRU1dfmkfr9XYVGDwSVARTOxp1GcrntKKOpE0HTDc81B0bW1" +
           "yVtAFJs9lZS43tQAeYRtWLtQbBYnBiv8uF3huwNtiNGFeyUBzWFNshB/YhuP" +
           "3IaOUtjMAIYkg0GV6irb5FfmYFmMfQabY/Zx6v8fzz12DOhFoN616yt3E/vu" +
           "tl4D1G+uuCLa1xrp5eVobefysWsC8KWrRwNAN2spii/yfhTU6AbLysJRDTa/" +
           "6uJrDsqD22+Okwi0wpLT9hy4X3StPwdYq/Tun3UGIh6cxUm1+PbLcU7qPTmI" +
           "p/3iF1mAPYEIvgL3VsLJvh0VQ5UkK4Lefqegl6b4Cwg8/eJy755Uy77eQ727" +
           "fGTisZv3v2AXMJJCl5bEZRDutnYtVTrtO9bV5uqqObz7VtOrdTvDDqpb7A17" +
           "Z3CLD/IDwI86Jp+uQHY3Y6Uk/97KwTd+cbbmCrDtCRKicCBO+K7WtqegRLCA" +
           "Zk8kPaL1/Tkkyo7+3d9efHBv9u+/F/nLIeat68unpKsvPvrrC5tXoDzZOEaq" +
           "ITGw4iypl83hRfUok+aNWdIomyNF2CJokakyRmotVT5jsbFMkjQhrCmSgvCL" +
           "487GUi+Wv5z0Vtzv17g0QK5fYMagZqkZwX/AzF5P2b8OLmFauh6Y4PWUQtlW" +
           "aXtKGv5K9CfnWyOjcDTLzPGr32Ba6RIZ+/+I8Ni52abYj+ETguc/+GDQscO+" +
           "D7cOOZfy7aVbORQV9lgklRzXdVe27mPdPiJfxeZrReznJNTn9CKdhexMiz+/" +
           "LtY/J16x+cZ/AVyWI+2UFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WdCAZyEgAAA=");
    }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "KdY/J16x+dZ/AQ4+j4WSFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "2+VzAR8gAAA=");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "rH9OvGLzjf8C5FcjQZQUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/wVZthK5ISAAAA==");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "IZlw8ec3xfrnxSs23/ov2h4unqIUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fDtP0P0v9DQm2zcgAAA=");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "htj/vHjFxzf/C4JPqQyYFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "NVYlIAAA");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Py9e8fHt/wLnY9TQlBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "FyNYVzghIAAA");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "mtj/gnjFx9f/C6o4+JaUFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471109864000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8wkWVWv+WZndnZYdmbf68g+GdDdJl/1o6qr2kHYflRV" +
           "P6q6qrr6rTDUu6rr/erqblyFjTwUAwQWxAT2L4hKlkeMRBODWWMUCMQEQ3wl" +
           "AjEmokjC/iEaV8Vb1d/39fd9M7NkY2Infbv61j3nnnPPOb977rkv/AA6F4VQ" +
           "wffstW578b66ivcXNrofr3012u/SKCeGkao0bTGKhqDvuvzEFy/96OUPG5f3" +
           "oPNz6F7Rdb1YjE3PjQZq5NlLVaGhS7tewladKIYu0wtxKcJJbNowbUbxNRp6" +
           "zTHSGLpKH4oAAxFgIAKciwDXd6MA0WtVN3GaGYXoxlEA/TJ0hobO+3ImXgw9" +
           "fpKJL4aic8CGyzUAHC5k/8dAqZx4FUKPHem+1fkGhT9WgJ/7zbdf/r2z0KU5" +
           "dMl0hUwcGQgRg0nm0J2O6khqGNUVRVXm0N2uqiqCGpqibW5yuefQPZGpu2Kc" +
           "hOrRImWdia+G+Zy7lbtTznQLEzn2wiP1NFO1lcN/5zRb1IGuD+x03WpIZv1A" +
           "wYsmECzURFk9JLnNMl0lhh49TXGk49UeGABIb3fU2PCOprrNFUEHdM/Wdrbo" +
           "6rAQh6arg6HnvATMEkNXbsk0W2tflC1RV6/H0EOnx3HbV2DUHflCZCQxdP/p" +
           "YTknYKUrp6x0zD4/6L/5g+902+5eLrOiynYm/wVA9MgpooGqqaHqyuqW8M6n" +
           "6I+LD3z5/XsQBAbff2rwdswf/NJLT7/pkRe/uh3z0zcZw0oLVY6vy5+W7vrm" +
           "65pP1s5mYlzwvcjMjH9C89z9uYM311Y+iLwHjjhmL/cPX744+PPZuz6rfn8P" +
           "utiBzsuenTjAj+6WPcc3bTWkVFcNxVhVOtAdqqs08/cd6HbwTJuuuu1lNS1S" +
           "4w50m513nffy/2CJNMAiW6LbwbPpat7hsy/GRv688iEIuh98oSoEnSlA+efM" +
           "U1kbQzJseI4Ki7Lomq4Hc6GX6R/BqhtLYG0NWAJeb8GRl4TABWEv1GER+IGh" +
           "HrwAQaO6EdARjpY63Mj6Wp5DHPbuZ87m//9Ms8q0vZyeOQMM8brTMGCDCGp7" +
           "tqKG1+Xnkgbx0uevf33vKCwO1imGKDDz/nbm/Xzm/aOZ98HM+zfMfJW0vVTw" +
           "xRwagTakmAX7GjpzJpfjvkywrTMAU1oAFABc3vmk8LbuO97/xFnghX56W2YN" +
           "MBS+NWo3dzDSycFSBr4MvfiJ9N3jXynuQXsn4TdTBnRdzMi5DDSPwPHq6bC7" +
           "Gd9L7/vej77w8We8XQCewPMDXLiRMovrJ04ve+jJqgKQcsf+qcfEL13/8jNX" +
           "96DbAFgAgIxF4NAAex45PceJ+L52iJWZLueAwpoXOqKdvToEuIuxEXrprif3" +
           "h7vy57vBGl/KHP4NYK3fdBAB+W/29l4/a+/b+k9mtFNa5Fj884L/qb/5i3+u" +
           "5Mt9CNuXjm2EghpfOwYVGbNLOSjcvfOBYaiqYNzff4L76Md+8L5fyB0AjHj9" +
           "zSa8mrVNABHAhGCZ3/PV4G+/8+1Pf2tv5zQx2CsTyTbl1ZGSFzKd7noFJcFs" +
           "b9zJA6DGBnGYec3Vket4iqmZomSrmZf+16U3lL70rx+8vPUDG/QcutGbfjKD" +
           "Xf9PNaB3ff3t//5IzuaMnG11uzXbDdvi5707zvUwFNeZHKt3/+XDv/UV8VMA" +
           "iQH6ReZGzQENytcAyo0G5/o/lbf7p96VsubR6Ljzn4yvYynJdfnD3/rha8c/" +
           "/OOXcmlP5jTHbc2I/rWte2XNYyvA/sHTkd4WIwOMQ17s/+Jl+8WXAcc54CgD" +
           "eIvYEODQ6oRnHIw+d/vf/cmfPvCOb56F9kjoou2JyhZQwB4AvFuNDABhK/+t" +
           "T2+tm2bmvpyrCt2g/NYpHsr/nQUCPnlrfCGzlGQXog/9J2tLz/7Df9ywCDmy" +
           "3GQnPkU/h1/45JXmW76f0+9CPKN+ZHUjNoP0bUdb/qzzb3tPnP+zPej2OXRZ" +
           "PsgNx6KdZIEzB/lQdJgwgvzxxPuTuc12I792BGGvOw0vx6Y9DS67PQE8Z6Oz" +
           "54vH8eTH4HMGfP8n+2bLnXVsd9R7mgfb+mNH+7rvr86AaD1X3sf2ixn9W3Mu" +
           "j+ft1az5ma2ZssefBWEd5UkpoNBMV7TziZ+OgYvZ8tVD7mOQpGb7z8LGcjb3" +
           "g7Q8d6dM+/1tZrcFtKwt5yy2LoHe0n1+bjsq37nu2jGjPZAkfuAfP/yND73+" +
           "O8CmXejcMltvYMpjM/aTLG9+7wsfe/g1z333AzlKAfgZ/+rLV57OuNKvpHHW" +
           "EFlDHqp6JVNVyLMBWoxiJgcWVcm1fUVX5kLTAfi7PEgK4Wfu+Y71ye99bpvw" +
           "nfbbU4PV9z/36z/e/+Bze8fS7NffkOkep9mm2rnQrz1Y4RB6/JVmySnIf/rC" +
           "M3/0O8+8byvVPSeTRgKciT73V//9jf1PfPdrN8lQbrO9/4Nh4zvvbCNRp374" +
           "oUszsZzK49WkkFQwQnHWS0zTB27f6FaIEu/SdSkolg3ZWYTzQi/VTIPtxBOj" +
           "rKyVRIowXN0wc1Zkl9OZH3fH/AgZNJuUJVmsr4Wmz4tCTDRGZpEJfGKymvAT" +
           "s6d79ZkF+4P2oMlauMnim9DaRBsGE9dyj8NaVlmxsc2mUnFdtoCjpU0Nn4Y+" +
           "M1sLAjxUO50lJa96C8rGDd+bWEVlJNpueyakMTeOSbiCVdOqi3nBoLxYDN1g" +
           "OPJHs6TfK67H4dAVvLI+8dGQCJsuNSfT1WzTox0+GfUwrzzYeCOx2tWDTmDh" +
           "hK3MTSO1fM8vWh7aRyfMRnGIAGkOXUOQu02btYy0N0wLjtBjLaqYFAp9sV4g" +
           "DL1hjmjYRibdddmPKkKj65STgHFGs2W74VlumZKCqk32S67TIN2FGbbdgSK3" +
           "BqWI6ZCaCBNciKKMgptTukmKfsgaU3fCTCS/qveGo/XQWSBVP6SaSqeEW2PB" +
           "WbNCixGGG1uaB8RwzqbBBBwL0okrlXvidLAYGENXLpYGodDW9aErjnsbyhP4" +
           "JHEMezWPG/yqVJFWk16qOFp3Emm9psFqFV/FYXbj20ltbCm6bAquSDfQtm71" +
           "0zLFs23G61GTuchjNIO2XCGwqHSOOv6IHM8VkwNrZ6GLaUdKkwLa4JVYR21z" +
           "WKtNCUJNNxJvh35k41inOWKrFSdY9eRyI/TLhXBWIJCFxzZavCdvmJWQdsuY" +
           "3/bV4mTAKt5galNrRksRYsY6Tj3po0tpMI5Hc0OneZQgKd+2lmx9KRTbncWk" +
           "Wm/ULZRLWvOJGabFYKMwsrBmTL7S2WyMQafEx22k0WXZqGvyRp8IhhFwlgYe" +
           "WriSLJsdxRJoSzflyUQUzETTWp24yiMJGwnphlKFRoQ1Vxw8YrDpJta6PE+w" +
           "SKc5jNYcvGgueK1Sq1ZrqGxEk6LisC47EYZpHE5EsVIrFqKlWugtVpQrklJT" +
           "F+FNuzeYD7lkQ7UG9Y7k05RLrGd8JZlKkZ/itZpRKdtrw3eazZIVYGJDbgyC" +
           "Kj9tEWMbdSiHmffXXavAq4HU7ZS7Bd1ZN2uoYDITpcj6SYnq4npJ9GZBPCWV" +
           "SmNA2oJurkJ9qlDrZKkkoy4yxYqTFtHvNODCQOVNGjM5k66x7JBYO/NSGkWC" +
           "MAl680B1W2Qp7td6YP2tlNbQeX3Oc2ihqPQjotmclxhUtfQOg8trWRfnhqPP" +
           "Sl1xTU3bjLgaScUU9YoOQW0ouKxKHTvA5kNC0EeNqFVj603DLg5IxZ4Hor2G" +
           "pbTcKU+LCY4QDFuUuQqxnrRnrNqO3EYd6xY9rFtuuQNmyuJTcjxF01LQbLQi" +
           "SpRnYWdpjQzC7TFKqyDW66MO2qry9bC/RhRYMryyxtZKo0bTq5Cil1ImJ47H" +
           "ojxwNxaeWDWaxuQSrRaq/WWDsknBFRrLaE4yYxMv8w7PiFZBUoYUzPD9ynqN" +
           "ayzPufXE0QLCZxvL4SzoVKsT1i03nOGCFaZxXS9pMtMpDylUnShyjSsFSMS5" +
           "2FpIVbNL+iozbdGUWcemrWqLI2ETr5izniINqcpynSI1TUvmg4qqMpFBW2O5" +
           "2rMnRmu60v2Zplq+VlVq/WlRRGDKUJahrjCoMUiJJEn7WImkhBmjLkUmViaN" +
           "dLyQ6TEz8je43OcoODDhakdvN0OVwtsThk8HFbnFcSImCFFBlqRhSqnTesUl" +
           "JrLeGw2RAluO8BoaazBrJ8ikuixGfJOWOxGCMA3F6tvSjG5P3MqsvZDndczi" +
           "wmiFIwU3HKKI4NQn3aQmSUwH44hJvQQ2CqQgx0t3uoRrNWUSFuc1FwALVplR" +
           "STAwgftU456LkpbUlNwljqd1LLDqitkNkSZfATjHjx2bmHfjGTzDovZ0WQmN" +
           "wazdWAeM2mqJWiUi4aXuGpG9wNBNYVCt8QRKpewyKuD4SF7HsCmukPVQCgh0" +
           "rRdgG+P6tYK1KbZXdaZXtqmRw3b1Dvg3iDtcE9Y5Ux3VPCzmkDJVJNNxQZ0i" +
           "RNIzS8qS8wdF3OGmIW4M7aVq6OMFN3L6PK+ohb4xbHBjZTbtVPmgiK/75U1/" +
           "OUVJdxp3HVOuI0WBoTslie+WyCjhkVE4lbgwHtYwj+P6CTlzWCudj32Mbunj" +
           "ZrnerzBrnQtJr9huuwCakIUhGZRj6eGil0p8OlxOWrXSLFVbzbIcwRgXFrwB" +
           "WF/dGVGzKiuNKNJdDTnNXeGCt2qzolUZgkDq6aIy7hXtiVXXrEk3TkryYinj" +
           "emdZrHWSbq23lrkxyQMgw61Ky2vgjUBxoyGmC7rQWWAr3AsaddWdB82iQCsV" +
           "sKjKFGVdt4FuwBm2jJcGZmu4DLAlHE43q+4UXrbKrDuJS04p1FO1Dct+bxMM" +
           "PLJSEQvVFlo0ajDJ4P1K0SmlUlst1/ghTCMtml1oSTsgFjDtEBU44VwUhqNU" +
           "ITuI0hkXKAAEGB5NKq1CYQCihZQKm9GiE6iJuxnM+s0w6rldpAHykLmFFE1h" +
           "Xa0ighl6fL9V0at1YjrgudDC1HqvhZXHY9ocWHELbZClGVtqRKOx1WpLSFPU" +
           "WrW1JBIiSyvFqOkEbHXe5AqrFqEm+kjxNXLVbtUth19XxwQ8t4P6msRjE1tw" +
           "CMtSVrHQgh1ORhiKH+nTcIpVCzi/WiPFCtIf0YUS4oXelEosuzQ3lXEx7FaQ" +
           "uE4WquqCbyo0Ww70mdkuDhrhhFqHzY5cUhdpsCYKaEDUEm5qsD2n6YNcKqQZ" +
           "CjM0harijZIZ1BolVdERsz2ukEJnU23J/nrYsHEWSRy8QYwmyCjV9QCuL+fj" +
           "VHbQ9mqk2+tZoCu1NKn2RnbKz5pRqSZjYYmJ55WQ0wSsV1TddmivMLjP1tes" +
           "r7Tt+bQuGVKyLI6CcVTBJkbfqk2xOVXrA+wIFFxRxm2lamxmG5yM67LO8TIy" +
           "n7TXVb42VUxf7cFcEholDC5orlhDGvEQJTrGjEdIyRBZtNokI4JyFuUx7lll" +
           "nGV5EaB+rYKGVQ2rlSW4Noz5pY2aFWm91uwALC5XX9LlkmJocwtPBV+X6brp" +
           "shYvkZSNDRZD0kvRojmcecUxMjP1gdgOGj1n01cn8kaQLDCKmpCM1VCJaQkt" +
           "9f0xGWkb1w+whRZW+r5OBvCaWRkVZW6lU7i+4dBOWcTZttMWDYMUkU5hxMe2" +
           "Kk5jkXKLQS1haWk8XVhd30b14VjC6GjYcRh9UyMK7EZG7FakFerL+hKGVy7O" +
           "sDqC1ApUmdAUYRn2iz1EdVLfCYVAdloyO5REfeU2hmhzUS1MosGqFZabLOIX" +
           "SZcI6ClWc+IFrLsLclXT4GbVQwpdcUSC9D87Frzt1Z3M7s4PoUd3DeBAlr1o" +
           "v4oTyermE+7F0B1+6MXg1K4q+by7slZe0bjvsGp9+Hu8rLWrdZw5PA6/9YZa" +
           "ruI5+weVW8lWWyzTcfxt2Tavb1w9WcPNznIP3+qiIj/HffrZ555X2M+U9g5q" +
           "TVNwdD+4PzouTwg9desDK5Nf0uwKIF959l+uDN9ivONVlHUfPSXkaZa/y7zw" +
           "NeqN8kf2oLNH5ZAbro9OEl07WQS5GKpxErrDE6WQh4/M82BmjYeBqqUD85Ru" +
           "Xlq9qd3P5I62da9Tdby9rWPkDnZo1fsyq6YVOTdmy5OTzGI5dfoKVcB3Zk0I" +
           "zCOHqhirh8zuPc7swPo7J45+0rH6RLkthh64+V3A4WTFV3u3ABznoRuuM7dX" +
           "cPLnn7904cHnR3+dl9GPrsnuoKELWmLbx+tXx57P+6GqmfmC3LGtZvn5z3tj" +
           "6JFXFi6GzoI21+Q9W5pfi6Ert6YBsXz0fJzqN2Lo8mmqGDqX/x4f96EYurgb" +
           "B+y2fTg+5CNAJjAke/yof5MS2LYAuDpzLBQPoCc37j0/ybhHJMfr81n45hfR" +
           "h6GWbK+ir8tfeL7bf+dL1c9s7wdkW9xsMi4XaOj27VXFUbg+fktuh7zOt598" +
           "+a4v3vGGQ1y5ayvwLoiOyfbozYvxhOPHefl884cP/v6bf/v5b+cVuf8FgxIL" +
           "jSEgAAA=");
    }
    public BatikDomExtension() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UaobTXG9DwadmBgU3O+JLjbv/xsmpHop7RoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
