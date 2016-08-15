package org.apache.batik.css.dom;
public class CSSOMViewCSS implements org.w3c.dom.css.ViewCSS {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMViewCSS(org.apache.batik.css.engine.CSSEngine engine) { super(
                                                                          );
                                                                        cssEngine =
                                                                          engine;
    }
    public org.w3c.dom.views.DocumentView getDocument() {
        return (org.w3c.dom.views.DocumentView)
                 cssEngine.
                 getDocument(
                   );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        if (elt instanceof org.apache.batik.css.engine.CSSStylableElement) {
            return new org.apache.batik.css.dom.CSSOMComputedStyle(
              cssEngine,
              (org.apache.batik.css.engine.CSSStylableElement)
                elt,
              pseudoElt);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwUxxWfO+Pvb/Nhlw8DxhAZyF1oAhU1oYHDBJMztjBB" +
       "7dFwzO3O3S3s7S67s/bZSdokUhIiVSklhNCq4S8QCqJJVDVqKzURFWqTKG2l" +
       "JPQjrUKr9p+0KWpQ1bQq/Xpvdvd2b+/OFKm1tHPrmTdv5r35vd97sxevkXrL" +
       "JP1M4zE+YzArNqLxCWpaTE6o1LL2QV9aeq6O/vngB3s2R0lDinTkqTUmUYvt" +
       "VJgqWymyTNEsTjWJWXsYk3HGhMksZk5RruhaiixUrNGCoSqSwsd0maHAfmom" +
       "STfl3FQyNmejrgJOliVhJ3Gxk/i28PBwkrRJujHji/cFxBOBEZQs+GtZnHQl" +
       "D9MpGre5osaTisWHiyZZZ+jqTE7VeYwVeeywutF1we7kxgoXDLzc+fGN4/ku" +
       "4YL5VNN0Lsyz9jJLV6eYnCSdfu+IygrWUfIFUpckrQFhTgaT3qJxWDQOi3rW" +
       "+lKw+3am2YWELszhnqYGQ8INcbKyXIlBTVpw1UyIPYOGJu7aLiaDtStK1jpW" +
       "Vpj47Lr4yecOdn2zjnSmSKeiTeJ2JNgEh0VS4FBWyDDT2ibLTE6Rbg0Oe5KZ" +
       "ClWVWfekeywlp1Fuw/F7bsFO22CmWNP3FZwj2GbaEtfNknlZASj3v/qsSnNg" +
       "6yLfVsfCndgPBrYosDEzSwF37pR5RxRN5mR5eEbJxsH7QACmNhYYz+ulpeZp" +
       "FDpIjwMRlWq5+CRAT8uBaL0OADQ5WVxTKfraoNIRmmNpRGRIbsIZAqlm4Qic" +
       "wsnCsJjQBKe0OHRKgfO5tmfL0w9qu7QoicCeZSapuP9WmNQfmrSXZZnJIA6c" +
       "iW1rk6foolePRQkB4YUhYUfm2w9dv2d9/6U3HJklVWTGM4eZxNPS2UzH20sT" +
       "Q5vrcBtNhm4pePhllosom3BHhosGMMyikkYcjHmDl/b+8HOPXGAfRknLKGmQ" +
       "dNUuAI66Jb1gKCoz72UaMyln8ihpZpqcEOOjpBHek4rGnN7xbNZifJTMU0VX" +
       "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" +
       "l8JmFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VCIAAA==");
}
