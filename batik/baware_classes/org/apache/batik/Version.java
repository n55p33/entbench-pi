package org.apache.batik;
public final class Version {
    public static java.lang.String getVersion() { java.lang.Package pkg =
                                                    org.apache.batik.Version.class.
                                                    getPackage(
                                                      );
                                                  java.lang.String version =
                                                    null;
                                                  if (pkg != null) {
                                                      version =
                                                        pkg.
                                                          getImplementationVersion(
                                                            );
                                                  }
                                                  java.lang.String headURL =
                                                    ("$HeadURL: https://svn.apache.org/repos/asf/xmlgraphics/batik" +
                                                     "/tags/batik-1_7/sources/org/apache/batik/Version.java $");
                                                  java.lang.String prefix =
                                                    "$HeadURL: ";
                                                  java.lang.String suffix =
                                                    "/sources/org/apache/batik/Version.java $";
                                                  if (headURL.
                                                        startsWith(
                                                          prefix) &&
                                                        headURL.
                                                        endsWith(
                                                          suffix)) {
                                                      headURL =
                                                        headURL.
                                                          substring(
                                                            prefix.
                                                              length(
                                                                ),
                                                            headURL.
                                                              length(
                                                                ) -
                                                              suffix.
                                                              length(
                                                                ));
                                                      if (!headURL.
                                                            endsWith(
                                                              "/trunk")) {
                                                          int index1 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/');
                                                          int index2 =
                                                            headURL.
                                                            lastIndexOf(
                                                              '/',
                                                              index1 -
                                                                1);
                                                          java.lang.String name =
                                                            headURL.
                                                            substring(
                                                              index1 +
                                                                1);
                                                          java.lang.String type =
                                                            headURL.
                                                            substring(
                                                              index2 +
                                                                1,
                                                              index1);
                                                          java.lang.String tagPrefix =
                                                            "batik-";
                                                          if (type.
                                                                equals(
                                                                  "tags") &&
                                                                name.
                                                                startsWith(
                                                                  tagPrefix)) {
                                                              version =
                                                                name.
                                                                  substring(
                                                                    tagPrefix.
                                                                      length(
                                                                        )).
                                                                  replace(
                                                                    '_',
                                                                    '.');
                                                          }
                                                          else
                                                              if (type.
                                                                    equals(
                                                                      "branches")) {
                                                                  version +=
                                                                    "; " +
                                                                    name;
                                                              }
                                                      }
                                                  }
                                                  if (version ==
                                                        null) {
                                                      version =
                                                        "development version";
                                                  }
                                                  return version;
    }
    public Version() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AbGTRED4EgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pSSbsB0AAA==");
}
