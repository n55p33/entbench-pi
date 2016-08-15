package org.apache.batik.css.dom;
public abstract class CSSOMStoredStyleDeclaration extends org.apache.batik.css.dom.CSSOMSVGStyleDeclaration implements org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider, org.apache.batik.css.dom.CSSOMStyleDeclaration.ModificationHandler, org.apache.batik.css.engine.StyleDeclarationProvider {
    protected org.apache.batik.css.engine.StyleDeclaration declaration;
    public CSSOMStoredStyleDeclaration(org.apache.batik.css.engine.CSSEngine eng) {
        super(
          null,
          null,
          eng);
        valueProvider =
          this;
        setModificationHandler(
          this);
    }
    public org.apache.batik.css.engine.StyleDeclaration getStyleDeclaration() {
        return declaration;
    }
    public void setStyleDeclaration(org.apache.batik.css.engine.StyleDeclaration sd) {
        declaration =
          sd;
    }
    public org.apache.batik.css.engine.value.Value getValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getValue(
                    i);
            }
        }
        return null;
    }
    public boolean isImportant(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getPriority(
                    i);
            }
        }
        return false;
    }
    public java.lang.String getText() { return declaration.
                                          toString(
                                            cssEngine);
    }
    public int getLength() { return declaration.size(
                                                  );
    }
    public java.lang.String item(int idx) { return cssEngine.
                                              getPropertyName(
                                                declaration.
                                                  getIndex(
                                                    idx));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "81WeKMoxM6Xh2ZWVIIO5DqG12HzZtO1e1/tXGSmLqKpMBSXLc+AYmrkGc/r1" +
       "X6t58VB9UTukzE5SnlSkXUnaGc1MG2VGMuJalHNz6CQRa0UYzIz4WuzinfvL" +
       "t++Cv9TboRexNj0yfn/Jx1rAHX5SYOxFbM7BDkCEbQHc5Q7mWOEHd8EKWHmS" +
       "RngkSxVp/FbIx1pA04sFxi5h83Oo4MAKYUARNsjJTuX32CLJ+k/BE5xjLhe6" +
       "cLdcqAEezbKANn7j5WPNDzmXudSrBSz4NjZXIIFJjCY8TvTm/8IOKUZmFLgd" +
       "xYN6Y9a/M+Y/CuLZ4zXlU49vfYtX2Olb/wmAXLGkLLuPkq73Uk2nMYkrN8E8" +
       "WGr8631GGvMdY8AvoOUqvGdS/5GRybmogRJaN+UHkCC9lIyU8G833UeMVDp0" +
       "jJSaL26Sj0E6kODrTc1OmcvucPbq2+C1acrnOscQl2NPudOGplnct3pY1fG/" +
       "2Ww4T5p/tA2IY8c3bnrk1mdPmreKMP/u3SilCkDcvOBMnzbm5pVmyyrtWHx7" +
       "4gsVC+yiqs5csBMVM1xeGwL/1tB1pnuu3Izm9M3b1ROrXv7VgdLXoX7cRnwC" +
       "lK/bsi8xUloSjnnbwtnJCk5m/C6wdfG3RlcvjX38Nr8mIlmXQ176AfHKqYff" +
       "ONx4oslPqjpJCdSLNMVvV9aPKpupOKz3k2rJaEvBEkGKJMgZmXCieQMBRRa3" +
       "i2XO6nQv3kkzMi+7Ds6+ya+U1RGqr1OTStTKpVVOj33qzDiwJTXNw+D0uAqC" +
       "syak4m6Aww6EuzTNrqtLpms87sdyYyy0viL+im/F/wFg/yYdgh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
