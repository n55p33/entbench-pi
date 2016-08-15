package org.apache.batik.css.engine.value;
public class URIValue extends org.apache.batik.css.engine.value.StringValue {
    java.lang.String cssText;
    public URIValue(java.lang.String cssText, java.lang.String uri) { super(
                                                                        org.w3c.dom.css.CSSPrimitiveValue.
                                                                          CSS_URI,
                                                                        uri);
                                                                      this.
                                                                        cssText =
                                                                        cssText;
    }
    public java.lang.String getCssText() { return "url(" +
                                           cssText +
                                           ')'; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AiJJsr+X+PoXeZc1V/4LQu6OCwEWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+OkfvOb33vBbz38rr779L/GgF3p+IAAA");
}
