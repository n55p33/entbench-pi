package org.apache.batik.svggen;
public class SVGCompositeDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String opacityValue;
    private java.lang.String filterValue;
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue) {
        super(
          );
        this.
          opacityValue =
          opacityValue;
        this.
          filterValue =
          filterValue;
    }
    public SVGCompositeDescriptor(java.lang.String opacityValue, java.lang.String filterValue,
                                  org.w3c.dom.Element def) {
        this(
          opacityValue,
          filterValue);
        this.
          def =
          def;
    }
    public java.lang.String getOpacityValue() { return opacityValue;
    }
    public java.lang.String getFilterValue() { return filterValue;
    }
    public org.w3c.dom.Element getDef() { return def; }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_OPACITY_ATTRIBUTE,
            opacityValue);
        attrMap.
          put(
            SVG_FILTER_ATTRIBUTE,
            filterValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null)
            defSet.
              add(
                def);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PLWJ2x9evmNvU3e5Ifjnd+n7ZFF8LIKuaUo0vngse2qJH38jlwplw4+cZ7E4" +
       "PO4csdj59rP4r+7S9xNF8S8i6GHAIn7hfPeUw3/5LXD4WNH4neB7zxGH7/n2" +
       "c/jTd+n7maL4TARdARxiR4f9p5x99lvg7FrR+DT4ukecdb89nF3aA5w7Uz3v" +
       "3zMxKYPGTekXpl/+wqfyz726PzLdiKESQZU7vaC69RFXcSv/wl1eFpy+rfmL" +
       "4d977Y//x/L7jsPSgydiKC4YoOfvJobj8Pim0ytLRiz7frUc65fuor7PF8Uv" +
       "7H2wG0WBvokjBWCXwL98/oby4dfTxa+Wxan2/+23oP3rx547Oppx9O3V/nn+" +
       "iihYXizdcbZjIT989i55fyv/xXKi/3IXKf9OUfxWBF3fO4nulI8UOCW6nZiv" +
       "vR7TXyyLUzH/pzd06xpBj9/+1UzxBODJW97o7d+VSZ995dr9T7yy+K/lw5GT" +
       "t18P0ND9amxZZ68jz9SveAFgtqT5gf3lpFf+/EEEPXGHpby4kiorJeG/v4f/" +
       "QyC5i/ARdG/5exbuKxF09RQODLWvnAX5agRdBiBF9U+92zxf2N/KppfOZAJH" +
       "plmK+tHXE/UJytl3JYXjl28kj1f6eHIUXz73CsW+/+utH9+/a5EsMc+LUe6n" +
       "ofv2T2xOsoXn7jja8VhXiHd+4+GfeuCF4xDy8J7gUzc5Q9szt39EMrC9qHz2" +
       "kf/8Ez/z7n/9yu+VN27/D0oT+v68KgAA");
}
