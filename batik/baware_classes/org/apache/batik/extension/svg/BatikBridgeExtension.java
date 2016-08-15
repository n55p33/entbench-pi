package org.apache.batik.extension.svg;
public class BatikBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 1.0F; }
    public java.util.Iterator getImplementedExtensions() { java.lang.String[] extensions =
                                                             { "http://xml.apache.org/batik/ext/poly/1.0",
                                                           "http://xml.apache.org/batik/ext/star/1.0",
                                                           "http://xml.apache.org/batik/ext/histogramNormalization/1.0",
                                                           "http://xml.apache.org/batik/ext/colorSwitch/1.0",
                                                           "http://xml.apache.org/batik/ext/flowText/1.0" };
                                                           java.util.List v =
                                                             java.util.Arrays.
                                                             asList(
                                                               extensions);
                                                           return java.util.Collections.
                                                             unmodifiableList(
                                                               v).
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() {
        return "Thomas DeWeese";
    }
    public java.lang.String getContactAddress() {
        return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() {
        return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikStarElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikFlowTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.ColorSwitchBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        return false;
    }
    public BatikBridgeExtension() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vjDFCc+U9yLQhurFK741/BufTnd+mR8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
