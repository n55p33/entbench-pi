package org.apache.batik.svggen;
public class SVGPaint implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGLinearGradient svgLinearGradient;
    private org.apache.batik.svggen.SVGTexturePaint svgTexturePaint;
    private org.apache.batik.svggen.SVGColor svgColor;
    private org.apache.batik.svggen.SVGCustomPaint svgCustomPaint;
    private org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgLinearGradient =
          new org.apache.batik.svggen.SVGLinearGradient(
            generatorContext);
        this.
          svgTexturePaint =
          new org.apache.batik.svggen.SVGTexturePaint(
            generatorContext);
        this.
          svgCustomPaint =
          new org.apache.batik.svggen.SVGCustomPaint(
            generatorContext);
        this.
          svgColor =
          new org.apache.batik.svggen.SVGColor(
            generatorContext);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { java.util.List paintDefs =
                                                 new java.util.LinkedList(
                                                 svgLinearGradient.
                                                   getDefinitionSet(
                                                     ));
                                               paintDefs.addAll(svgTexturePaint.
                                                                  getDefinitionSet(
                                                                    ));
                                               paintDefs.
                                                 addAll(
                                                   svgCustomPaint.
                                                     getDefinitionSet(
                                                       ));
                                               paintDefs.
                                                 addAll(
                                                   svgColor.
                                                     getDefinitionSet(
                                                       ));
                                               return paintDefs;
    }
    public org.apache.batik.svggen.SVGTexturePaint getTexturePaintConverter() {
        return svgTexturePaint;
    }
    public org.apache.batik.svggen.SVGLinearGradient getGradientPaintConverter() {
        return svgLinearGradient;
    }
    public org.apache.batik.svggen.SVGCustomPaint getCustomPaintConverter() {
        return svgCustomPaint;
    }
    public org.apache.batik.svggen.SVGColor getColorConverter() {
        return svgColor;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          svgCustomPaint.
          toSVG(
            paint);
        if (paintDesc ==
              null) {
            if (paint instanceof java.awt.Color)
                paintDesc =
                  org.apache.batik.svggen.SVGColor.
                    toSVG(
                      (java.awt.Color)
                        paint,
                      generatorContext);
            else
                if (paint instanceof java.awt.GradientPaint)
                    paintDesc =
                      svgLinearGradient.
                        toSVG(
                          (java.awt.GradientPaint)
                            paint);
                else
                    if (paint instanceof java.awt.TexturePaint)
                        paintDesc =
                          svgTexturePaint.
                            toSVG(
                              (java.awt.TexturePaint)
                                paint);
        }
        return paintDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b37bH3J4J8fwPP6Kbx3/A+1kIPnNIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kTx7fHxX/l2pnLtHPnV8d+oi4viO59aFh6JepgOnFBXHMk/e611AeSTzpU++" +
       "9LI2/XL98uFtz48mlQcTP/g+R89059S4VwGl5+99/ESVzyJObiF+5ZN/8AT/" +
       "/dbH3sB97PvO8Xme5E9Tr3xt8EH1r1+u3Hd8J3HHg42znV44exNxPdKTNPL4" +
       "M/cRTx5PQzlFT4NvdjgNs/OnqCcTffcj1A/tFeWCy7SfuKDuy0Xycnn+mvR0" +
       "w/bKq1NOT86crZ0VPStvyvm8rf7D2Te//sXdV17ZH50pMli5KtV7PRm689VS" +
       "cWH97AWX7iePSf548Ode/f3/LHz0SGPedvZS+cZFAjxS3odP3/Xt71JfOTGg" +
       "v/N6x3qnJVcW/O1jHr6nKITBJx7yIL71k/j3L6j7pSL5u0nlcTCJpy9Xjk2y" +
       "qGdPsP7Cm8D6ZFFYXLV89BDrR996rP/kgrp/ViRfTSrvAViPLsPuBDs6AfvL" +
       "bwLsE0VhccchH4KV33qwv3FB3b8qkq8llccA2FOXNmegaidQ/+WbgPrOovBZ" +
       "8OmHUPW3HupvX1D3H4rk34DlroBa3K+dAfmDJyB/602AfE9RWNwZxocg47cG" +
       "5Os+hSh8m7xJDsyGdgC0NrCOXyqW9P7rBYL5gyL5T0nlgcQHq+zREM9esBL3" +
       "9FiN7ODorWIptd99E1IrBFb5APg+fii1j/+ZSG3vnwsplUpedvn2BYL5kyJ5" +
       "7bxgnn+9h2F3k87/fCPSyZPKtSNixZOZx+94qbp/Xan+3Ms3rj328vzflg+t" +
       "jl9APkhWrhmp45x+rXAqfyWIwDJcAnxw/3YhKH4u3Qe8wD2gFXeYZaZg9dLl" +
       "ffsrYE0/3x7Iqvw93e7BpHL9pB0gtc+cbvJQUrkPNCmybw/ucv+5f7SRXzoV" +
       "uR3qUCncR19PuMddTr/DKiymfCl8FJmlzGHQ8ZWXx/THX2t9ef8OTHXk3a6g" +
       "co2sXN0/STuO7p65J7UjWleGz33n4Z9/8NmjuOLhPcMn+nyKt/fd/dFV3w2S" +
       "8pnU7pce+3sf+cmXf6e8jv3/0V98mcIt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "AAA=";
}
