package org.apache.batik.dom.svg;
public class SVGOMImageElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement.
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
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
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
    protected SVGOMImageElement() { super(
                                      ); }
    public SVGOMImageElement(java.lang.String prefix,
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
            SVG_IMAGE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_IMAGE_Y_DEFAULT_VALUE,
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
        return SVG_IMAGE_TAG;
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
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMImageElement(
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
       "I9Eevqok/oiV/D84kelQGygAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7e9DrxnUf7pV0JV3JunrYkiJbL/vKsUTrguALoGXHBgGQ" +
       "BAmAIAmCJBpFBvEgQOL9JmKljsepPc3U9bRyak8T1X/Y4zbj2JlONU2ncatM" +
       "09oZp+3E4z7STmO3006Spm7i6STtxG3dBfi97nfv/aRrqZzZJbh7dvf8zjl7" +
       "9uxi+eXvQbeFAVTxXGu3ttzoipZFVzZW80q087TwyoBp8nIQaiphyWEogLIX" +
       "lHf+6qU/+8GnjXvPQxck6AHZcdxIjkzXCSda6FqJpjLQpeNSytLsMILuZTZy" +
       "IsNxZFowY4bRcwx014mmEXSZOWQBBizAgAW4ZAHGj6lAo7doTmwTRQvZiUIf" +
       "+hnoHANd8JSCvQh68upOPDmQ7YNu+BIB6OGO4rcIQJWNswB64gj7HvM1gD9T" +
       "gV/6Gz9179+9BbokQZdMZ1qwowAmIjCIBN1ta/ZKC0JcVTVVgu5zNE2daoEp" +
       "W2Ze8i1B94fm2pGjONCOhFQUxp4WlGMeS+5upcAWxErkBkfwdFOz1MNft+mW" +
       "vAZYHzzGukfYLcoBwIsmYCzQZUU7bHLr1nTUCHr8dIsjjJeHgAA0vd3WIsM9" +
       "GupWRwYF0P173Vmys4anUWA6a0B6mxuDUSLokRt2Wsjak5WtvNZeiKCHT9Px" +
       "+ypAdWcpiKJJBL3tNFnZE9DSI6e0dEI/3+Pe/6mfdvrO+ZJnVVOsgv87QKPH" +
       "TjWaaLoWaI6i7Rve/QzzC/KDX/vkeQgCxG87Rbyn+fsf+f6H3vvYq9/Y07z9" +
       "OjSj1UZToheUL6zu+Z13EE+3bynYuMNzQ7NQ/lXIS/PnD2qeyzww8x486rGo" +
       "vHJY+erkny0/+svaH52HLtLQBcW1YhvY0X2Ka3umpQU9zdECOdJUGrpTc1Si" +
       "rKeh28EzYzravnSk66EW0dCtVll0wS1/AxHpoItCRLeDZ9PR3cNnT46M8jnz" +
       "IAi6HSToMZDeA+0/7y6yCHoeNlxbg2VFdkzHhfnALfCHsOZEKyBbA14Bq9/C" +
       "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" +
       "+P9xRt2fFtl/34NfFs9/eIzrj98orqdA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+soBrq+8+bh+eOO6c2UXfx5BdwBc88NXkyew/eCNYiuWvlcOsL3ypmM7d9cZ" +
       "dcUbn3MXwCIIsPWP3nEegzt3+xsA90xRWLT79QNwv/7mg3vojLofK7L7I+hB" +
       "AO46rzoP5+eVM+bnjZqVsnngDcjmXUXh+0D6zQPZ/ObNyuY1V99zT51R9+NF" +
       "9kQEPQRkc6OrFatjqE++AagPFIWPgPTNA6jffPOhImfU1YvsvWC1drSUc1Xt" +
       "UO/3ntT7UUUJ99k3ALfwwFAbpG8dwP3Wmw/3g2fUFaH5ufeBeAJo9vQNoqNb" +
       "QYtjrM/d1PUzsCG45lZxcT/y4Wv+t7C/a6985eVLdzz08uzflBdrj+7D38lA" +
       "d+ixZZ28knXi+YIXaLpZiuHO/QUtr8TWB7BudLUhgm4BecHxud6eehhBb70e" +
       "NaAE+UlK7sAaTlJG0G3l90m6cQRdPKaLoAv7h5MkAugdkBSPM+/Q1NCz7mPM" +
       "JvTRneJeIHuGqYSHG5r91ufhk5ZWrjn3v5bSjpqcvMZb7GPKv6Ec7jni/R9R" +
       "XlC++vKA++nvt764v0asWHKeF73cwUC37280l50W+5Ynb9jbYV8X+k//4J5f" +
       "vfOpwz3WPXuGj63+BG+PX//CLmV7UXnFNv+1h/7e+7/08u+VdzH+H1eLlGUf" +
       "NAAA");
}
