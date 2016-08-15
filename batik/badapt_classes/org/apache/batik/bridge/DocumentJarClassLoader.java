package org.apache.batik.bridge;
public class DocumentJarClassLoader extends java.net.URLClassLoader {
    protected java.security.CodeSource documentCodeSource = null;
    public DocumentJarClassLoader(java.net.URL jarURL, java.net.URL documentURL) {
        super(
          new java.net.URL[] { jarURL });
        if (documentURL !=
              null) {
            documentCodeSource =
              new java.security.CodeSource(
                documentURL,
                (java.security.cert.Certificate[])
                  null);
        }
    }
    protected java.security.PermissionCollection getPermissions(java.security.CodeSource codesource) {
        java.security.Policy p =
          java.security.Policy.
          getPolicy(
            );
        java.security.PermissionCollection pc =
          null;
        if (p !=
              null) {
            pc =
              p.
                getPermissions(
                  codesource);
        }
        if (documentCodeSource !=
              null) {
            java.security.PermissionCollection urlPC =
              super.
              getPermissions(
                documentCodeSource);
            if (pc !=
                  null) {
                java.util.Enumeration items =
                  urlPC.
                  elements(
                    );
                while (items.
                         hasMoreElements(
                           )) {
                    pc.
                      add(
                        (java.security.Permission)
                          items.
                          nextElement(
                            ));
                }
            }
            else {
                pc =
                  urlPC;
            }
        }
        return pc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
