package org.apache.batik.svggen;
public abstract class AbstractSVGFilterConverter implements org.apache.batik.svggen.SVGFilterConverter, org.apache.batik.svggen.ErrorConstants {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected java.util.Map descMap = new java.util.HashMap();
    protected java.util.List defSet = new java.util.LinkedList();
    public AbstractSVGFilterConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { return defSet; }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Kx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "snUvL3dSq2jI232LdphubtiOBvt030CmeJP23IkWYxxupC4mI3nexTqN1hKx" +
       "50WdRWb4KnXyoYbpRAp3qc0cCRGRb3WxusB3TazVTDUTXqsUSccrxHOadjNP" +
       "h9mQZV1movrq3Gph5Gge1dRBG1NaKtpuiwjaiXergG/zsTPOpSIw66LSyvPI" +
       "dhmRkWc0g9Q3eC1uNDlBHqczuUE3UbAsNGXCY3NTrfWXI6QVWUoXs3PT2nXV" +
       "zR7VR0U+XyjNfLDSNTnGI4YJpyuwoHeLLg8mQnTUby0aXmTyttbcO8AjvXS3" +
       "aVk7bNFYJDjca23yemPEdbrdNHW7k8XInxgze6pI4461pWf0YKhaWKCljbi9" +
       "IDfGzoc5P9utpwkcDjg6bjvKupllHXjfR4fs0l54/UY7s2R1AuvLbEZp+GzW" +
       "7+3qOTvjjX7IZpTqiqtwO1l6aMRxixhtr8b9eo7pm4UW9U1iv/PS8X7XW+RL" +
       "aa/UsEwl17bkD+uRNoqGTq7CMYvFagBgivRIduq1R9kS8bq9mQOWhFOMCaa8" +
       "GcKp56ndtaDua2tnjG03WE1JFoy79nqNdDX3mt012mvUG3UiGdBzd8KuRWMP" +
       "E9uOEmotQzR6UyNf7FGpTURrWvRmsYZHs0EqKx4ljpNG4hZpFLPDhAxZI+zv" +
       "kf0QaUT9JToZkGk9YSJDm8T7rT22aqIm+Jo9S9OmrVCSstir0oTA2z29N9QG" +
       "syRK4r4yEl1f1CM7ZhEsTDv75jaCd3KIorHF5nWwaf7oR8vt9Mff3onGk9Xh" +
       "zenlte22yxfO29jJ5/fu8Oj40OgR+fje7uzepPrchI5vQU++z9+bnB2MH52c" +
       "Ir14nzuHS/eBJywfuoqFiqLqOPbwz4fycOS9V12JVwcjX/zEa6+roy8hJ+eR" +
       "H0ugR5Mg/B5XyzT3grIR9OLVh0B89Y+As6P03/3Enz87/17zlbdxqfi+S3pe" +
       "Fvkz/Bu/P/iQ8mNH0AOnB+t3/VfhItNLF4/Tb0Rakkb+/MKh+ntPx64a9OfB" +
       "Qx+PHX35lPIsdO59DPpdh9C7z43Q5+/z7vWy+MnqWD3pabrlV/d/d5+mPnYS" +
       "Y/fVszo2feUszj/37U6szqtTNbx22uMzZeNt8IyPexy/Dc8cnaandU/3nL+A" +
       "y85lZFGeJgfpxtUqti/fx3NvlsWXEujxA/3ZUaxzZv9Pvx378wR69upL+fJK" +
       "4Zm7/g50+AuL8nOv33zk6dfFf1vdS5/+zeRRDnpET133/OXOufr1MAIDXtny" +
       "6OGqJ6y+/kUCPX1Fppdn1lWlUv4rB/pfBtFzmT6BHqq+z9P9agLdOKMDog6V" +
       "8yS/kUAPAJKy+lZ4j/Puwx1Xfu0cRhzHTeXup76du09Zzl9bl7hS/R3rBAPS" +
       "8fEFzZuvM8LHvtn60uHaXHHloiilPMJBDx9u8E9x5P1XSjuRdX344W898fOP" +
       "vnCCeU8cFD6L4XO6ve/ed9SUFybVrXLxS0//4kf+2et/XB2//1/2Rg2fJycA" +
       "AA==");
}
