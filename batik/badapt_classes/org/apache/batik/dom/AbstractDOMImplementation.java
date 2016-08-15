package org.apache.batik.dom;
public abstract class AbstractDOMImplementation implements org.w3c.dom.DOMImplementation, java.io.Serializable {
    protected final org.apache.batik.dom.util.HashTable features = new org.apache.batik.dom.util.HashTable(
      );
    { registerFeature("Core", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("XML", new java.lang.String[] { "1.0", "2.0",
                      "3.0" });
      registerFeature("Events", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("UIEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MouseEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("TextEvents", "3.0");
      registerFeature("KeyboardEvents", "3.0");
      registerFeature("MutationEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MutationNameEvents", "3.0");
      registerFeature("Traversal", "2.0");
      registerFeature("XPath", "3.0"); }
    protected void registerFeature(java.lang.String name, java.lang.Object value) {
        features.
          put(
            name.
              toLowerCase(
                ),
            value);
    }
    protected AbstractDOMImplementation() { super(); }
    public boolean hasFeature(java.lang.String feature, java.lang.String version) {
        if (feature ==
              null ||
              feature.
              length(
                ) ==
              0) {
            return false;
        }
        if (feature.
              charAt(
                0) ==
              '+') {
            feature =
              feature.
                substring(
                  1);
        }
        java.lang.Object v =
          features.
          get(
            feature.
              toLowerCase(
                ));
        if (v ==
              null) {
            return false;
        }
        if (version ==
              null ||
              version.
              length(
                ) ==
              0) {
            return true;
        }
        if (v instanceof java.lang.String) {
            return version.
              equals(
                v);
        }
        else {
            java.lang.String[] va =
              (java.lang.String[])
                v;
            for (int i =
                   0;
                 i <
                   va.
                     length;
                 i++) {
                if (version.
                      equals(
                        va[i])) {
                    return true;
                }
            }
            return false;
        }
    }
    public java.lang.Object getFeature(java.lang.String feature,
                                       java.lang.String version) {
        if (hasFeature(
              feature,
              version)) {
            return this;
        }
        return null;
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        return new org.apache.batik.dom.events.DocumentEventSupport(
          );
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.events.EventSupport(
          n);
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
       "yjNfyws+/wNClEXGLCcAAA==");
}
