package org.apache.batik.util.resources;
public class ResourceManager {
    protected java.util.ResourceBundle bundle;
    public ResourceManager(java.util.ResourceBundle rb) { super();
                                                          bundle = rb; }
    public java.lang.String getString(java.lang.String key) throws java.util.MissingResourceException {
        return bundle.
          getString(
            key);
    }
    public java.util.List getStringList(java.lang.String key) throws java.util.MissingResourceException {
        return getStringList(
                 key,
                 " \t\n\r\f",
                 false);
    }
    public java.util.List getStringList(java.lang.String key,
                                        java.lang.String delim)
          throws java.util.MissingResourceException { return getStringList(
                                                               key,
                                                               delim,
                                                               false);
    }
    public java.util.List getStringList(java.lang.String key,
                                        java.lang.String delim,
                                        boolean returnDelims)
          throws java.util.MissingResourceException { java.util.List result =
                                                        new java.util.ArrayList(
                                                        );
                                                      java.util.StringTokenizer st =
                                                        new java.util.StringTokenizer(
                                                        getString(
                                                          key),
                                                        delim,
                                                        returnDelims);
                                                      while (st.
                                                               hasMoreTokens(
                                                                 )) {
                                                          result.
                                                            add(
                                                              st.
                                                                nextToken(
                                                                  ));
                                                      }
                                                      return result;
    }
    public boolean getBoolean(java.lang.String key)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException {
        java.lang.String b =
          getString(
            key);
        if (b.
              equals(
                "true")) {
            return true;
        }
        else
            if (b.
                  equals(
                    "false")) {
                return false;
            }
            else {
                throw new org.apache.batik.util.resources.ResourceFormatException(
                  "Malformed boolean",
                  bundle.
                    getClass(
                      ).
                    getName(
                      ),
                  key);
            }
    }
    public int getInteger(java.lang.String key)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException {
        java.lang.String i =
          getString(
            key);
        try {
            return java.lang.Integer.
              parseInt(
                i);
        }
        catch (java.lang.NumberFormatException e) {
            throw new org.apache.batik.util.resources.ResourceFormatException(
              "Malformed integer",
              bundle.
                getClass(
                  ).
                getName(
                  ),
              key);
        }
    }
    public int getCharacter(java.lang.String key)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException {
        java.lang.String s =
          getString(
            key);
        if (s ==
              null ||
              s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.util.resources.ResourceFormatException(
              "Malformed character",
              bundle.
                getClass(
                  ).
                getName(
                  ),
              key);
        }
        return s.
          charAt(
            0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7BsK8yq0JRXiEZ8q/wMW1wh8BSEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Fde/Ytv/cnn/6I8+f1/q03YBCsrAAA=");
}
