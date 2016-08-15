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
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QCumE4sv0fWHy0d/8K2jx/22lY5Ath/R5JSDGl+aCRCnrw5ZR0jPgn/NkDpY" +
       "Hbmw6BJRXHxJz040Vi+Y2PtLHo75y6k6CKy0pSjuSsf1XakbJC1ztepE3aPz" +
       "1zcoWlACpKCGER9ckScF/QTUIV56qHH42033TYpqHTpgJT7cJJMUlQEJ+zyv" +
       "T1HkiIIv63NhlW1UvhfzZtqL/BT3UZG5Mr/EzaGBJa5xE9LliT29R25uPS+O" +
       "qpKCx8cZl1kRVCVOzXlEWVGSW45X5e61txqeq1md86TZQmAnzhe7gjEEGKyz" +
       "HV/kOceZrfnj3LuTO1756YnKtyFo9iMfpmjO/uLSOKtbAOX7Iw6Yu/4JwA+Y" +
       "7WufHNu5Pv2X3/DDhw3+S0rTJ6SrFx565/TCSTiIzupGFRAkJMtr9s4xNU6k" +
       "EWMA1ctmOAsiAhcZK92o2lLlwxbpTkVQA3NOzEpVbhfbnPX5XnbRQdHK4uAv" +
       "vh6Cg9ooMXZplpriGAvo7/QU3C7nQNnSdc8Epye/lXOLdU9InV9pfOlUc1kX" +
       "BFiBOm72VaaVzAO++8LZyQBNrDmVFbBUloj06HoOpspadOHxLwga1k+Rr83u" +
       "ZaDhE8mZ/fw+Z/ci/2TNS/8FV1XgVEsaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hBvE+Z1k+od3/f47f/uZ7+QHqv8L4lf2hXQlAAA=");
}
