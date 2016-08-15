package org.apache.batik.dom.svg;
public class SVGOMForeignObjectElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGForeignObjectElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMForeignObjectElement() {
        super(
          );
    }
    public SVGOMForeignObjectElement(java.lang.String prefix,
                                     org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_FOREIGN_OBJECT_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_FOREIGN_OBJECT_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_FOREIGN_OBJECT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMForeignObjectElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "J3jVJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tY9T75eD0DDtrTmu7C6BBFuMTwF4tzse");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jqG7QFpofunGTvpDMfSOW0kDSZCeliztveK0ZAzds/1/Wu4whq6eyMXQ5d3L" +
       "aREEtA5EitdKcORypYvOtMlQDSxbi46i2EunAtG9l23n4kOvN2DHVU5fDyyC" +
       "1+2196NAM9ldfH9O+9rLvcEnX8O+urueqDlqnhet3MdC9+5uSh4Hq0/etrWj" +
       "ti5TT3//ga9feeoosH5gp/CJx5/S7T23vgiIu0G8vbqX/+ojv/iRf/zyt7YH" +
       "2P8PzH+pkI8wAAA=");
}
