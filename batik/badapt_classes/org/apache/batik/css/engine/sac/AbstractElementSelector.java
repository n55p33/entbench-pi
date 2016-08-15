package org.apache.batik.css.engine.sac;
public abstract class AbstractElementSelector implements org.w3c.css.sac.ElementSelector, org.apache.batik.css.engine.sac.ExtendedSelector {
    protected java.lang.String namespaceURI;
    protected java.lang.String localName;
    protected AbstractElementSelector(java.lang.String uri, java.lang.String name) {
        super(
          );
        namespaceURI =
          uri;
        localName =
          name;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null ||
                                                        obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractElementSelector s =
                                                    (org.apache.batik.css.engine.sac.AbstractElementSelector)
                                                      obj;
                                                  return s.
                                                           namespaceURI.
                                                    equals(
                                                      namespaceURI) &&
                                                    s.
                                                      localName.
                                                    equals(
                                                      localName);
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return localName;
    }
    public void fillAttributeSet(java.util.Set attrSet) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6L7z4oMeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
