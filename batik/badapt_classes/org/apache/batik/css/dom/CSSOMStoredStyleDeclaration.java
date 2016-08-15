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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Nyw/pch/+nU/8c4feO7PyvPJ/wGlG+C+IioAAA==");
}
