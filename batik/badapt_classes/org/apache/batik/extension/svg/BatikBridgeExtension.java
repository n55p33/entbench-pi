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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b4oTninvRaAN1YtXfGv4N36xdL+ZHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MSJ3rMAHixrZJ6tpvW5HKy9HycZyYSbjupzxjdxbsYtGZ2KHzpia+FlH5Q1z" +
       "3qpHDd6feFtS2A0bu7mMM3UdJSYjOx/z1iCZoopVDwh/mFsiOWXdbGLUOhyO" +
       "N9AkRFN7E07YqjOnyIaI267Va5PctldtMzO2Gyg4Pq1O+xYrL+he3Z+Nxr16" +
       "Pu17W51AbQMlfJYlOvQwHxPiaGjPOzSRDKXWznHQFhJ0a43Nus0FPL6pOwN+" +
       "ZMRRjPvrKT6ZCJZNCToy1gditOSEiiNjrda8N6Z649aw19tJy1q72fComsMx" +
       "DI+5edbuhLyaWoTbCriUiugMDgXEMmihsUE2XNgXF9qQ3qLirO943SjWXVUU" +
       "MJ3rtJgdOp4JYrOdIzy84nJhK6+689FKEjLgnxEfDWoWWxMtZKAMRC73qK5H" +
       "kV42Q1Nm27ETMprXRCdExOGovkqY7cCWGiM3TwcVfIQvZlSPn7RGTX8kT9qT" +
       "zGFMRm3xrCnibFvstlojagObNjaZDweTrbBi/UUfhEQ6yrvDmbZxuyTPEnV7" +
       "rhMBiaIrI8SIapKsrI1H4PNm1u04OI5OqvU6OxZGjEdM2/WJEvjyttpAZDKx" +
       "jRiL25E3y0fMIKz28WGNxpMGniDT6lzs8jkVBEY+amuSpm66FXfDVplOMhW8" +
       "TO6gOxJTh0a4NNGQ1Fd9vbIUsKzH2vSkvtaH/hJjkQ2B4lq3m/MhqdQqFaxF" +
       "ZEKAN2WElSiqss3QwJyLsDOqJSRZU6bKOJGXcFDfyfB8O7C46ra3cPyxZHiy" +
       "OkrqUz616rkj5rg5WvRzQqjg1IDbBPS8r/NwX7CSKTme25XxGI+bU9GJ7FZv" +
       "IiJGQmFCl1ec9hbdNrkGrLXWtVzaGhN5leNDSe2qVaY+IIO6rmsxEfsDOZ7W" +
       "mxsYS1fOup3aKlgXRlO7EdLTfm8grvoBT1GzWipGK7bSc9rZElPxmB20piMl" +
       "aYSdjqKvlyNySCAS1uVqjs+qxHwlCJ6xHe9St9pagZhZuq2khoghtt3QHDce" +
       "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");
}
