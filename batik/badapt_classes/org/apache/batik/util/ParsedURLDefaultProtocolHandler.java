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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mP0H8YrNH/8LiN6U6B0cAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mf8DDzl7BhYnAAA=");
}
