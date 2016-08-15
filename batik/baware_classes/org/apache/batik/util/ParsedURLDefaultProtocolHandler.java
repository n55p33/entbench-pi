package org.apache.batik.util;
public class ParsedURLDefaultProtocolHandler extends org.apache.batik.util.AbstractParsedURLProtocolHandler {
    public ParsedURLDefaultProtocolHandler() { super(null); }
    protected ParsedURLDefaultProtocolHandler(java.lang.String protocol) {
        super(
          protocol);
    }
    protected org.apache.batik.util.ParsedURLData constructParsedURLData() {
        return new org.apache.batik.util.ParsedURLData(
          );
    }
    protected org.apache.batik.util.ParsedURLData constructParsedURLData(java.net.URL url) {
        return new org.apache.batik.util.ParsedURLData(
          url);
    }
    public org.apache.batik.util.ParsedURLData parseURL(java.lang.String urlStr) {
        try {
            java.net.URL url =
              new java.net.URL(
              urlStr);
            return constructParsedURLData(
                     url);
        }
        catch (java.net.MalformedURLException mue) {
            
        }
        org.apache.batik.util.ParsedURLData ret =
          constructParsedURLData(
            );
        if (urlStr ==
              null)
            return ret;
        int pidx =
          0;
        int idx;
        int len =
          urlStr.
          length(
            );
        idx =
          urlStr.
            indexOf(
              '#');
        ret.
          ref =
          null;
        if (idx !=
              -1) {
            if (idx +
                  1 <
                  len)
                ret.
                  ref =
                  urlStr.
                    substring(
                      idx +
                        1);
            urlStr =
              urlStr.
                substring(
                  0,
                  idx);
            len =
              urlStr.
                length(
                  );
        }
        if (len ==
              0)
            return ret;
        idx =
          0;
        char ch =
          urlStr.
          charAt(
            idx);
        while (ch ==
                 '-' ||
                 ch ==
                 '+' ||
                 ch ==
                 '.' ||
                 ch >=
                 'a' &&
                 ch <=
                 'z' ||
                 ch >=
                 'A' &&
                 ch <=
                 'Z') {
            idx++;
            if (idx ==
                  len) {
                ch =
                  0;
                break;
            }
            ch =
              urlStr.
                charAt(
                  idx);
        }
        if (ch ==
              ':') {
            ret.
              protocol =
              urlStr.
                substring(
                  pidx,
                  idx).
                toLowerCase(
                  );
            pidx =
              idx +
                1;
        }
        idx =
          urlStr.
            indexOf(
              '/');
        if (idx ==
              -1 ||
              pidx +
              2 <
              len &&
              urlStr.
              charAt(
                pidx) ==
              '/' &&
              urlStr.
              charAt(
                pidx +
                  1) ==
              '/') {
            if (idx !=
                  -1)
                pidx +=
                  2;
            idx =
              urlStr.
                indexOf(
                  '/',
                  pidx);
            java.lang.String hostPort;
            if (idx ==
                  -1)
                hostPort =
                  urlStr.
                    substring(
                      pidx);
            else
                hostPort =
                  urlStr.
                    substring(
                      pidx,
                      idx);
            int hidx =
              idx;
            idx =
              hostPort.
                indexOf(
                  ':');
            ret.
              port =
              -1;
            if (idx ==
                  -1) {
                if (hostPort.
                      length(
                        ) ==
                      0)
                    ret.
                      host =
                      null;
                else
                    ret.
                      host =
                      hostPort;
            }
            else {
                if (idx ==
                      0)
                    ret.
                      host =
                      null;
                else
                    ret.
                      host =
                      hostPort.
                        substring(
                          0,
                          idx);
                if (idx +
                      1 <
                      hostPort.
                      length(
                        )) {
                    java.lang.String portStr =
                      hostPort.
                      substring(
                        idx +
                          1);
                    try {
                        ret.
                          port =
                          java.lang.Integer.
                            parseInt(
                              portStr);
                    }
                    catch (java.lang.NumberFormatException nfe) {
                        
                    }
                }
            }
            if ((ret.
                   host ==
                   null ||
                   ret.
                     host.
                   indexOf(
                     '.') ==
                   -1) &&
                  ret.
                    port ==
                  -1)
                ret.
                  host =
                  null;
            else
                pidx =
                  hidx;
        }
        if (pidx ==
              -1 ||
              pidx >=
              len)
            return ret;
        ret.
          path =
          urlStr.
            substring(
              pidx);
        return ret;
    }
    public static java.lang.String unescapeStr(java.lang.String str) {
        int idx =
          str.
          indexOf(
            '%');
        if (idx ==
              -1)
            return str;
        int prev =
          0;
        java.lang.StringBuffer ret =
          new java.lang.StringBuffer(
          );
        while (idx !=
                 -1) {
            if (idx !=
                  prev)
                ret.
                  append(
                    str.
                      substring(
                        prev,
                        idx));
            if (idx +
                  2 >=
                  str.
                  length(
                    ))
                break;
            prev =
              idx +
                3;
            idx =
              str.
                indexOf(
                  '%',
                  prev);
            int ch1 =
              charToHex(
                str.
                  charAt(
                    idx +
                      1));
            int ch2 =
              charToHex(
                str.
                  charAt(
                    idx +
                      1));
            if (ch1 ==
                  -1 ||
                  ch2 ==
                  -1)
                continue;
            ret.
              append(
                (char)
                  (ch1 <<
                     4 |
                     ch2));
        }
        return ret.
          toString(
            );
    }
    public static int charToHex(int ch) { switch (ch) { case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                        case '8':
                                                        case '9':
                                                            return ch -
                                                              '0';
                                                        case 'a':
                                                        case 'A':
                                                            return 10;
                                                        case 'b':
                                                        case 'B':
                                                            return 11;
                                                        case 'c':
                                                        case 'C':
                                                            return 12;
                                                        case 'd':
                                                        case 'D':
                                                            return 13;
                                                        case 'e':
                                                        case 'E':
                                                            return 14;
                                                        case 'f':
                                                        case 'F':
                                                            return 15;
                                                        default:
                                                            return -1;
                                          } }
    public org.apache.batik.util.ParsedURLData parseURL(org.apache.batik.util.ParsedURL baseURL,
                                                        java.lang.String urlStr) {
        if (urlStr.
              length(
                ) ==
              0)
            return baseURL.
                     data;
        int idx =
          0;
        int len =
          urlStr.
          length(
            );
        if (len ==
              0)
            return baseURL.
                     data;
        char ch =
          urlStr.
          charAt(
            idx);
        while (ch ==
                 '-' ||
                 ch ==
                 '+' ||
                 ch ==
                 '.' ||
                 ch >=
                 'a' &&
                 ch <=
                 'z' ||
                 ch >=
                 'A' &&
                 ch <=
                 'Z') {
            idx++;
            if (idx ==
                  len) {
                ch =
                  0;
                break;
            }
            ch =
              urlStr.
                charAt(
                  idx);
        }
        java.lang.String protocol =
          null;
        if (ch ==
              ':') {
            protocol =
              urlStr.
                substring(
                  0,
                  idx).
                toLowerCase(
                  );
        }
        if (protocol !=
              null) {
            if (!protocol.
                  equals(
                    baseURL.
                      getProtocol(
                        )))
                return parseURL(
                         urlStr);
            idx++;
            if (idx ==
                  urlStr.
                  length(
                    ))
                return parseURL(
                         urlStr);
            if (urlStr.
                  charAt(
                    idx) ==
                  '/')
                return parseURL(
                         urlStr);
            urlStr =
              urlStr.
                substring(
                  idx);
        }
        if (urlStr.
              startsWith(
                "/")) {
            if (urlStr.
                  length(
                    ) >
                  1 &&
                  urlStr.
                  charAt(
                    1) ==
                  '/') {
                return parseURL(
                         baseURL.
                           getProtocol(
                             ) +
                         ":" +
                         urlStr);
            }
            return parseURL(
                     baseURL.
                       getPortStr(
                         ) +
                     urlStr);
        }
        if (urlStr.
              startsWith(
                "#")) {
            java.lang.String base =
              baseURL.
              getPortStr(
                );
            if (baseURL.
                  getPath(
                    ) !=
                  null)
                base +=
                  baseURL.
                    getPath(
                      );
            return parseURL(
                     base +
                     urlStr);
        }
        java.lang.String path =
          baseURL.
          getPath(
            );
        if (path ==
              null)
            path =
              "";
        idx =
          path.
            lastIndexOf(
              '/');
        if (idx ==
              -1)
            path =
              "";
        else
            path =
              path.
                substring(
                  0,
                  idx +
                    1);
        return parseURL(
                 baseURL.
                   getPortStr(
                     ) +
                 path +
                 urlStr);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aTH79+IVmz/8FyhhVq4dHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
