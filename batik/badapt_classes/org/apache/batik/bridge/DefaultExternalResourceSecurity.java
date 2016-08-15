package org.apache.batik.bridge;
public class DefaultExternalResourceSecurity implements org.apache.batik.bridge.ExternalResourceSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_CANNOT_ACCESS_DOCUMENT_URL =
      ("DefaultExternalResourceSecurity.error.cannot.access.document" +
       ".url");
    public static final java.lang.String ERROR_EXTERNAL_RESOURCE_FROM_DIFFERENT_URL =
      ("DefaultExternalResourceSecurity.error.external.resource.from" +
       ".different.url");
    protected java.lang.SecurityException se;
    public void checkLoadExternalResource() { if (se != null) { se.
                                                                  fillInStackTrace(
                                                                    );
                                                                throw se;
                                              } }
    public DefaultExternalResourceSecurity(org.apache.batik.util.ParsedURL externalResourceURL,
                                           org.apache.batik.util.ParsedURL docURL) {
        super(
          );
        if (docURL ==
              null) {
            se =
              new java.lang.SecurityException(
                org.apache.batik.bridge.Messages.
                  formatMessage(
                    ERROR_CANNOT_ACCESS_DOCUMENT_URL,
                    new java.lang.Object[] { externalResourceURL }));
        }
        else {
            java.lang.String docHost =
              docURL.
              getHost(
                );
            java.lang.String externalResourceHost =
              externalResourceURL.
              getHost(
                );
            if (docHost !=
                  externalResourceHost &&
                  (docHost ==
                     null ||
                     !docHost.
                     equals(
                       externalResourceHost))) {
                if (externalResourceURL ==
                      null ||
                      !DATA_PROTOCOL.
                      equals(
                        externalResourceURL.
                          getProtocol(
                            ))) {
                    se =
                      new java.lang.SecurityException(
                        org.apache.batik.bridge.Messages.
                          formatMessage(
                            ERROR_EXTERNAL_RESOURCE_FROM_DIFFERENT_URL,
                            new java.lang.Object[] { externalResourceURL }));
                }
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZaDhE8mZ/fw+Z/ci/2TNS/8F1kkCyEsaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zO8k0z+86/ff+dvPfic/UP1fpLKQiHQlAAA=");
}
