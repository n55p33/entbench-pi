package org.apache.batik.util;
public abstract class Platform {
    public static boolean isOSX = java.lang.System.getProperty("os.name").
      equals(
        "Mac OS X");
    public static boolean isJRE13 = java.lang.System.getProperty("java.version").
      startsWith(
        "1.3");
    public static void unmaximize(java.awt.Frame f) { if (!isJRE13) {
                                                          try {
                                                              java.lang.reflect.Method m1 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "getExtendedState",
                                                                  (java.lang.Class[])
                                                                    null);
                                                              java.lang.reflect.Method m2 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "setExtendedState",
                                                                  new java.lang.Class[] { java.lang.Integer.
                                                                                            TYPE });
                                                              int i =
                                                                ((java.lang.Integer)
                                                                   m1.
                                                                   invoke(
                                                                     f,
                                                                     (java.lang.Object[])
                                                                       null)).
                                                                intValue(
                                                                  );
                                                              m2.
                                                                invoke(
                                                                  f,
                                                                  new java.lang.Object[] { new java.lang.Integer(
                                                                    i &
                                                                      ~6) });
                                                          }
                                                          catch (java.lang.reflect.InvocationTargetException ite) {
                                                              
                                                          }
                                                          catch (java.lang.NoSuchMethodException nsme) {
                                                              
                                                          }
                                                          catch (java.lang.IllegalAccessException iae) {
                                                              
                                                          }
                                                      }
    }
    public Platform() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "t5/7VlEj+1/XVBxJdSEAAA==");
}
